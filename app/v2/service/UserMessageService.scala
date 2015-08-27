package v2.service

import models.MessageRead
import v2.repositories.slick.{UserMessageSlickRepository}

/**

 * Created by richa on 23/08/15.
 */

abstract class UserMessageService extends UserMessageSlickRepository {

  def allInboxMessagesForUser(user_id: Long) = {
    findAllInboxMessagesForUser(user_id, true)
  }

  def unreadInboxMessagesForUser(user_id: Long) = {
    println("unreadInboxMessagesForUserunreadInboxMessagesForUserunreadInboxMessagesForUserunreadInboxMessagesForUser")
    findAllInboxMessagesForUser(user_id, false)
  }

}

object UserMessageServiceObject extends UserMessageService