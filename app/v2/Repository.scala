package v2

import play.api.db.slick._
import utils.DBUtils
import play.api.db.slick.Config.driver.simple._
import play.api.Play.current
import play.api.db.slick.Session

/**
 * Created by richa on 22/08/15.
 */
trait Repository {

  type DAO

  def getSession(dbName: String) : Session= {
    implicit lazy val session = play.api.db.slick.DB(dbName).createSession
    session
  }

  def getDB(dbName:String) = {
    play.api.db.slick.DB(dbName)
  }

  protected def db = {
    getDB(DBUtils.DB_DEFAULT)
  }

}
