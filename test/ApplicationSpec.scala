import org.specs2.mutable._
import org.specs2.runner._
import org.junit.runner._

import play.api.test._
import play.api.test.Helpers._

/**
 * Load testdata/CDesk_Reports_SampleData.csv into reports table in postgres
 */
@RunWith(classOf[JUnitRunner])
class ApplicationSpec extends Specification {

  "Application" should {

//    "send 404 on a bad request" in new WithApplication{
//      route(FakeRequest(GET, "/boum")) must beNone
//    }
//    "render the index page" in new WithApplication{
//      val home = route(FakeRequest(GET, "/")).get
//      status(home) must equalTo(OK)
//      contentType(home) must beSome.which(_ == "text/html")
//      contentAsString(home) must contain ("Your new application is ready.")
//    }
//

//    "render top domain impressions for advertiser_id=-1" in new WithApplication {
//      val home = route(FakeRequest(GET, "/advertisers/-1/reports?report_type=domain&measure_name=impressions&topn=1&limit=1")).get
//      status(home) must equalTo(OK)
//      contentType(home) must beSome.which(_ == "application/json")
//      contentAsString(home) must contain("1 reports")
//      contentAsString(home) must contain("\"data\":[{\"dimension_name\":\"www.google.com\",\"measure\":\"98\"}],\"message\":\"1 reports\"}")
//    }
//    "render bottom blacklisted clicks for advertiser_id=-2" in new WithApplication {
//      val home = route(FakeRequest(GET, "/advertisers/-2/reports?report_type=blacklisted&measure_name=clicks&topn=0&limit=1")).get
//      status(home) must equalTo(OK)
//      contentType(home) must beSome.which(_ == "application/json")
//      contentAsString(home) must contain("1 reports")
//      contentAsString(home) must contain("\"data\":[{\"dimension_name\":\"www.bell.com\",\"measure\":\"1\"}],\"message\":\"1 reports\"}")
//    }
  }
}
