package controllers

import play.api.mvc._

import models.Questions
import play.api.db.DB
import play.api.Play.current

import scala.util.Random
import scala.slick.session.Database

object QuestionController extends QuestionController {
}

class QuestionController extends Controller {

  val database = Database.forDataSource(DB.getDataSource())

  def showQuestion() = Action { implicit request =>
    database withSession {
      val r = new Random
      val questionId = r.nextInt(4) + 1
      Questions.getByQuestionId(questionId) match {
        case Some(question) =>
          val fakeChoices = Questions.getFakeChoicesByCategoryId(question.categoryId, questionId)
          val choices = r.shuffle(fakeChoices.::(question.answer))
          Ok(views.html.question.showQuestion("問題です！", question, choices))
        case _ => NotFound("対象の問題が見つかりません。")
      }
    }
  }
}
