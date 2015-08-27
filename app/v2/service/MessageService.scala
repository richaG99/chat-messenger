package v2.service

import models.{MessageRead, ChatUser, Message}
import v2.repositories.slick.MessageSlickRepository
import play.api.db.slick.Config.driver.simple._
/**
 * Created by richa on 22/08/15.
 */
abstract class MessageService extends MessageSlickRepository {


  def findByMessageId(id: Long) = {
    findById(id)
  }

  def createMessage(message: MessageRead) : Long= {
    create(message)
  }

}

object MessageServiceObject extends MessageService
