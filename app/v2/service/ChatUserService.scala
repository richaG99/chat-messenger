package v2.service

import models.ChatUser
import v2.repositories.slick.ChatUserSlickRepository
import play.api.db.slick.Config.driver.simple._
/**
 * Created by richa on 22/08/15.
 */
abstract class ChatUserService extends ChatUserSlickRepository {

  def findUserWithEmailId( emailId: String)(implicit s: Session): Option[ChatUser]= {
   val user = findUserWithEmailId(emailId)
   user match {
    case None => None
    case x => x
   }
  }

  def findUsersWithEmailId( emaildIdList: List[String])(implicit s: Session): List[ChatUser]= {
    findUsersWithEmailId(emaildIdList)
  }

}

object ChatUserServiceObject extends ChatUserService
