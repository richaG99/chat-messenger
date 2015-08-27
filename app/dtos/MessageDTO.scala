package dtos


import play.api.libs.json.{Json, Format}


/**
 * Created by richa on 23/08/15.
 */
case class MessageDTO(
                     msg_id: Long,
                     msg_subject: String,
                     msg_body: Option[String],
                     msg_created_at: String,
                     sender_emailId: String,
                     sender_name: String
                     )


object MessageDTO {
  implicit val messageDtoFormat: Format[MessageDTO] = Json.format[MessageDTO]

}