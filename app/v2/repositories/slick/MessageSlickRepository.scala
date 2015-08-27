package v2.repositories.slick

import org.joda.time.DateTime
import play.api.db.slick.Config.driver.simple._
import v2.Repository
import models.{MessageRead, Messages, Message}

import scala.slick.lifted.TableQuery

/**
 * Created by richa on 23/08/15.
 */
trait MessageSlickRepository extends Repository{

  val messages = TableQuery[Messages]

  def findById(id:Long) : Option[Message]  =  db.withSession { implicit session =>
    messages.filter(_.id === id).firstOption
  }


  def create(message:MessageRead) = db.withSession { implicit session =>
   val messageObj = Message(None, message.subject, message.body, DateTime.now)

    messages returning messages.map(_.id)  += messageObj
  }

}
