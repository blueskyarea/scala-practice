package models

import org.joda.time.DateTime

import scala.slick.driver.PostgresDriver.simple._

case class Image(
  id: Int,
  fileName: String,
  fileSize: Int,
  mimeType: String,
  imageWidth: Short,
  imageHeight: Short,
  createdAt: DateTime)

class Images extends Table[Image]("images") with TimeTypeMapper {

  def id = column[Int]("id", O.PrimaryKey, O.NotNull)

  def fileName = column[String]("file_name", O.NotNull)

  def fileSize = column[Int]("file_size", O.NotNull)

  def mimeType = column[String]("mime_type", O.NotNull)

  def imageWidth = column[Short]("image_width", O.NotNull)

  def imageHeight = column[Short]("image_height", O.NotNull)

  def createdAt = column[DateTime]("created_at", O.NotNull)

  def * = id ~ fileName ~ fileSize ~ mimeType ~ imageWidth ~ imageHeight ~ createdAt <> (Image.apply _, Image.unapply _)

  def inserter = fileName ~ fileSize ~ mimeType ~ imageWidth ~ imageHeight ~ createdAt returning *

}
