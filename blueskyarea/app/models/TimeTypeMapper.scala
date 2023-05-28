package models

import scala.slick.lifted.MappedTypeMapper
import org.joda.time.DateTime
import java.sql.Timestamp

trait TimeTypeMapper{
  implicit val timeTypeMapper =
    MappedTypeMapper.base[DateTime, Timestamp](t => new Timestamp(t.getMillis), t => new DateTime(t.getTime))
}
