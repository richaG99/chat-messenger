package models

import play.api.db.slick.Config.driver.simple._
import play.api.libs.json.{Json, Format}

/**
 * Created by richa on 22/08/15.
 */

object ChatUser {
  implicit val chat_user: Format[ChatUser] = Json.format[ChatUser]

  val dummyUser = ChatUser( -1L, "", "")
}
case class ChatUser(id: Long, name: String, email_id: String)

class ChatUsers(tag: Tag) extends Table[ChatUser](tag, "chat_users") {

  def id = column[Long]("id", O.PrimaryKey)

  def name = column[String]("name", O.NotNull)

  def email_id = column[String]("email_id", O.NotNull)

  def * = (id , name, email_id) <>  ((ChatUser.apply _).tupled, ChatUser.unapply _)
}


