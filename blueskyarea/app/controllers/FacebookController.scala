package controllers

import play.api.mvc._
import play.api.Play.current
import play.api.libs.Crypto
import play.api.libs.ws.WS
import play.api.libs.concurrent.Execution.Implicits._

import scala.concurrent.Await
import scala.concurrent.duration.Duration

import java.net.URLEncoder

object FacebookController extends Controller {

  val APP_ID     = current.configuration.getString("auth.facebook.app_id").getOrElse("")
  val APP_SECRET = current.configuration.getString("auth.facebook.app_secret").getOrElse("")
  val AUTH_CSRF  = "FACEBOOK_AUTH_CSRF_KEY"

  def showFacebook = Action { implicit request =>
    Ok(views.html.facebook.facebookLogin("Facebookでログイン"))
  }

  def getCallbackUrl(csrfToken:String)(implicit request:Request[AnyContent]) = {
    URLEncoder.encode(routes.FacebookController.callback(csrfToken).absoluteURL(false), "UTF-8")
  }

  def login = Action { implicit request =>
    val csrfToken = Crypto.generateToken
    val authURL = "http://www.facebook.com/dialog/oauth?client_id=%s&redirect_uri=%s".format(APP_ID, getCallbackUrl(csrfToken))
    Redirect(authURL).withSession(AUTH_CSRF -> csrfToken)
  }

  def getAccessToken(hash:String)(implicit request:Request[AnyContent]) = {
    val requestCode = request.getQueryString("code").getOrElse("")
    val token_url = "https://graph.facebook.com/oauth/access_token?client_id=" + APP_ID +
      "&redirect_uri=" + getCallbackUrl(hash) +
      "&client_secret=" + APP_SECRET +
      "&code=" + requestCode
    val result = WS.url(token_url).get.map(_.body)
    Await.result(result, Duration.Inf)
  }

  def getUserJson(accessToken:String)(implicit request:Request[AnyContent]) = {
    val token_url = "https://graph.facebook.com/me?" + accessToken
    val result = WS.url(token_url).get.map(_.json)
    Await.result(result, Duration.Inf)
  }

  def csrfCheck[T](urlToken:String, f: => T)(implicit request:Request[AnyContent]) = {
    session.get(AUTH_CSRF).map(csrfToken => {
      if (csrfToken == csrfToken) {
        f
      } else {
        throw new Exception("CSRF error.")
      }
    }).getOrElse(throw new Exception("No session."))
  }

  def callback(hash:String) = Action { implicit request =>
    csrfCheck(hash, {
      val token = getAccessToken(hash)
      val userInfo = getUserJson(token)
      import play.api.libs.json._
      Ok(views.html.facebook.showPage("ログインしました。", Json.stringify(userInfo)))
    })
  }

}
