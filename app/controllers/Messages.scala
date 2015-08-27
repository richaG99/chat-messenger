package controllers


import helpers.ResultHelper._
import org.joda.time.DateTime
import play.api.Logger
import play.api.db.slick.DBAction
import play.api.libs.json.Json
import play.api.mvc.Controller
import utils.DBUtils
import v2.service.{UserMessageServiceObject, MessageServiceObject}


/**
 * Created by richa on 23/08/15.
 */
object Messages extends Controller {

  implicit val context = play.api.libs.concurrent.Execution.Implicits.defaultContext

  val logger: Logger = Logger(this.getClass)

  def messages(id: Long) = DBAction { implicit rs =>
    try {
      val ts = DateTime.now.getMillis
      val msg = MessageServiceObject.findByMessageId(id)
      Logger.debug(utils.LogMsgUtils.dbTimeLogMsgMS(DateTime.now.getMillis - ts, "dataapi.messages.messages"))
      if (msg.isEmpty)
        notFound("Message with id not found")
      else
        ok(Json.toJson(msg), s"message info with id $id")
    } catch {
      case e: Exception =>
        logger.error("Error getting message with  id: " + id, e)
        internalServerError(Application.CHECK_LOGS_MSG)
    }
  }

  def createMessage = DBAction(DBUtils.DB_DEFAULT, parse.json) { implicit request =>
    try {
      val msgBody = request.body.as[models.MessageRead]

      val msgId = MessageServiceObject.createMessage(msgBody)
      if (msgId <= 0 )
        notFound("Message with id not found")
      else
        ok(Json.toJson("success"), s"Message with is created ")
    } catch {
      case e: Exception =>
        logger.error("Error in creating message  ", e)
        internalServerError(Application.CHECK_LOGS_MSG)
    }
  }

  // to mark the message as read
  def updateMessageAsRead(id: Long) = DBAction(DBUtils.DB_DEFAULT, parse.json) { implicit request =>
    try {
      println("@#$@!$!@C!@C#!")
      println(id)
      val a = request.body
      println(a)
      val usrMsgObj = UserMessageServiceObject.findById(id)

      usrMsgObj match {
        case None =>  notFound("Message with id not found")
        case usrMsgObj =>  UserMessageServiceObject.updateUserMessageAsRead(usrMsgObj.get)
      }

        ok(Json.toJson("success"), s"Message with $id is updated as read ")
    } catch {
      case e: Exception =>
        logger.error("Error in creating message  ", e)
        internalServerError(Application.CHECK_LOGS_MSG)
    }
  }


}
