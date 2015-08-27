package models

import org.joda.time.DateTime
import play.api.db.slick.Config.driver.simple._
import com.github.tototoshi.slick.PostgresJodaSupport._
import play.api.libs.json.{Json, Format}

/**
 * Created by richa on 22/08/15.
 */

object Message {
  implicit val message: Format[Message] = Json.format[Message]
}

case class MessageRead(subject: Option[String], body: Option[String])

object MessageRead{

  implicit val actionRead: Format[MessageRead] = Json.format[MessageRead]
}


case class Message(id: Option[Long], subject: Option[String], body: Option[String], created_at: DateTime)

class Messages(tag: Tag) extends Table[Message](tag, "messages") {

  def id = column[Long]("id", O.PrimaryKey,O.AutoInc)

  def subject = column[String]("subject", O.NotNull)

  def body = column[String]("body", O.NotNull)

  def created_at = column[DateTime]("created_at",  O.NotNull ) // O.Default(new DateTime()))


  def * = (id.? , subject.?, body.?, created_at) <>  ((Message.apply _).tupled, Message.unapply _)

}



