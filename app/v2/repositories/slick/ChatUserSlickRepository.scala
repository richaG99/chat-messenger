package v2.repositories.slick

import models.ChatUsers
import models.ChatUser
import play.api.db.slick.Config.driver.simple._
import v2.Repository

import scala.slick.lifted.TableQuery

/**
 * Created by richa on 22/08/15.
 */
trait ChatUserSlickRepository extends Repository{

  val chatUsers = TableQuery[ChatUsers]

  def findByEmailId(email_id:String) : Option[ChatUser]  = db.withSession { implicit session =>
    chatUsers.filter(_.email_id === email_id.toLowerCase ).firstOption
  }

  def findById(id:Long) : Option[ChatUser]  =  db.withSession { implicit session =>
    chatUsers.filter(_.id === id).firstOption
  }

  def findByName(name:String): Option[ChatUser]  =  db.withSession { implicit session =>
    chatUsers.filter(_.name === name).firstOption
  }

  def findUsersByEmailIdList(emailIdList: List[String])= db.withSession { implicit session =>
   chatUsers.filter(_.email_id.inSet(emailIdList)).list
  }


}
