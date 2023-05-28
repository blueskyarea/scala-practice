package models

import scala.slick.driver.PostgresDriver.simple._

import Database.threadLocalSession

import org.joda.time.DateTime

/**
 *
 * @param id 問題ID
 * @param categoryId カテゴリID
 * @param question 問題内容
 * @param answer 答え
 * @param questionCount 出題回数
 * @param rightCount 正解回数
 * @param createdAt 作成日時
 * @param modifiedAt 更新日時
 */
case class Question(
    id: Int,
    categoryId: Int,
    question: String,
    answer: String,
    questionCount: Int,
    rightCount: Int,
    createdAt: DateTime,
    modifiedAt: DateTime)

class Questions extends Table[Question]("questions") with TimeTypeMapper {
  def id = column[Int]("id")

  def categoryId = column[Int]("category_id")

  def question = column[String]("question")

  def answer = column[String]("answer")

  def questionCount = column[Int]("question_count")

  def rightCount = column[Int]("right_count")

  def createdAt = column[DateTime]("created_at")

  def modifiedAt = column[DateTime]("modified_at")

  def * = id ~ categoryId ~ question ~ answer ~ questionCount ~ rightCount ~ createdAt ~ modifiedAt <> (Question.apply _, Question.unapply _)

  /**
   * 問題IDから問題を取得する
   * @param questionId 問題ID
   * @return　問題
   */
  def getByQuestionId(questionId: Int): Option[Question] = {
    val query = for {
      ques <- Questions.filter(_.id === questionId)
    } yield ques
    query.firstOption
  }

  /**
   * カテゴリIDからフェイク選択肢を取得する
   * @param categoryId カテゴリID
   * @param questionId 問題ID
   * @return フェイク選択肢
   */
  def getFakeChoicesByCategoryId(categoryId: Int, questionId: Int): List[String] = {
    val query = for {
      ques <- Questions.filter(_.categoryId === categoryId).filter(_.id =!= questionId)
    } yield ques.answer
    query.take(3).list
  }
}

object Questions extends Questions
