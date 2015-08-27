package helpers


import org.json4s.{Extraction, NoTypeHints}
import play.api.Play
import play.api.http.Status._
import play.api.libs.json.JsValue
import play.api.mvc.Results._
import play.api.mvc.{RequestHeader, Result}
import dtos.{Meta, Response}

/**
 * Created by richa on 22/08/15.
 */

object ResultHelper {

  def headers = List(
    "Access-Control-Allow-Origin" -> "*",
    "Access-Control-Allow-Methods" -> "GET, POST, OPTIONS, DELETE, PUT",
    "Access-Control-Allow-Headers" -> "Content-Type, Authorization"
  )

  val corsEnabled = Play.current.configuration.getString("cors.enabled").getOrElse("false").toBoolean

  def ok(data: JsValue = null, message: String)(implicit request: RequestHeader): Result = {
    val res = Ok(Response("OK", OK, meta, data = Option(data), message = message).toJson)
    if(corsEnabled) res.withHeaders(headers: _*) else res
  }

  def internalServerError(message:String)(implicit request: RequestHeader) : Result ={
    val res = InternalServerError( Response("INTERNAL_SERVER_ERROR", INTERNAL_SERVER_ERROR, meta, data = None, message = message).toJson )
    if(corsEnabled) res.withHeaders(headers: _*) else res
  }

  def notFound(message: String)(implicit req: RequestHeader): Result = {
    val res = NotFound(Response("NOT FOUND", NOT_FOUND, meta, message = message).toJson)
    if(corsEnabled) res.withHeaders(headers: _*) else res
  }
  def meta(implicit request: RequestHeader): Meta = Meta(request.host, request.method, request.path, request.uri)


}
