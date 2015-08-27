package controllers

import play.api.Routes
import play.api.mvc._


object Application extends Controller {

  val CHECK_LOGS_MSG="Please check logs for details"

  def headers = List(
    "Access-Control-Allow-Origin" -> "*",
    "Access-Control-Allow-Methods" -> "GET, POST, OPTIONS, DELETE, PUT",
    "Access-Control-Allow-Headers" -> "Content-Type, Authorization"
  )

  def options(url: String) = Action { request =>
    println("options method is called")
    Ok.withHeaders(headers : _*)
  }


}


