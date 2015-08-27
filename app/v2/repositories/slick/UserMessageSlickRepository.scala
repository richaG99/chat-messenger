package v2.repositories.slick

import dtos.MessageDTO
import models.{Messages, ChatUsers, UserMessage, UserMessages, ChatUser,Message, MessageRead}
import play.api.db.slick.Config.driver.simple._
import com.github.nscala_time.time.OrderingImplicits.DateTimeOrdering

import v2.Repository

import scala.slick.lifted.TableQuery

/**
 * Created by richa on 23/08/15.
 */
trait UserMessageSlickRepository extends Repository{


  val userMessage = TableQuery[UserMessages]
  val users = TableQuery[ChatUsers]
  val message = TableQuery[Messages]

  def findById(id:Long) : Option[UserMessage]  = db.withSession { implicit session =>
    userMessage.filter(_.id === id).firstOption
  }

  def findAllInboxMessagesForUser(_id:Long, is_read: Boolean): List[MessageDTO] =  db.withSession { implicit session =>

    lazy val q =
    if(is_read){
      for{
        ((user_message, user),message) <- userMessage.filter(_.receiver_id === _id) innerJoin  users on (_.receiver_id === _.id) leftJoin message on (_._1.id === _.id)
      } yield ( user_message, user, message)
    } else {
      for{
        ((user_message, user),message) <- userMessage.filter(x =>  x.receiver_id === _id  && x.is_read === false) innerJoin users on (_.receiver_id === _.id) leftJoin message on (_._1.id === _.id)
      } yield ( user_message, user, message)
    }

    q.list.map{
        case(um: UserMessage , usr : ChatUser, msg: Message) =>  (um, usr, msg)                                                                    // msg.body, msg.created_at,  usr.email_id, usr.name )
    }.sortBy(x => x._3.created_at).map{
      case (um, usr, msg) => MessageDTO( um.message_id, msg.subject.getOrElse(""), msg.body, utils.DateTimeMapper.dateToStringWithTime(msg.created_at), usr.email_id, usr.name )
    }


  }

  def createUserMessage(messageId:Long, sender_id:Long, receiver_id:Long) = db.withSession { implicit session =>
    val UserMsgObj = UserMessage( None, messageId, sender_id, receiver_id, Some(true), Some(false) )
    userMessage returning userMessage.map(_.id)  += UserMsgObj
  }


  def updateUserMessageAsRead(msg: UserMessage) = db.withSession{ implicit session =>
    userMessage returning userMessage.map(_.id) += UserMessage(msg.id, msg.message_id, msg.senderId, msg.receiverId, msg.isSent, Some(true))
  }
}
