package models


import play.api.db.slick.Config.driver.simple._
import play.api.libs.json.{Json, Format}

/**
 * Created by richa on 22/08/15.
 */

object UserMessage {
  implicit val userMessage: Format[UserMessage] = Json.format[UserMessage]
}
case class UserMessage( id: Option[Long], message_id: Long, senderId: Long, receiverId: Long, isSent: Option[Boolean], isRead: Option[Boolean])

class UserMessages(tag: Tag) extends Table[UserMessage](tag, "user_message") {

  def id = column[Long]("id", O.PrimaryKey,O.AutoInc )

  def message_id = column[Long]("message_id", O.NotNull)

  def sender_id = column[Long]("sender_id", O.NotNull)

  def receiver_id = column[Long]("receiver_id", O.NotNull)

  def is_sent = column[Boolean]("is_sent", O.Nullable)

  def is_read = column[Boolean]("is_read", O.Nullable)


  def * = (id.? ,message_id, sender_id , receiver_id , is_read.?, is_sent.?) <>  ((UserMessage.apply _).tupled, UserMessage.unapply _)
}


