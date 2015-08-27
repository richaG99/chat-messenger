
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._

import play.api.templates.PlayMagic._
import models._
import controllers._
import play.api.i18n._
import play.api.mvc._
import play.api.data._
import views.html._

/**/
object main extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template2[String,Html,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(title: String)(content: Html):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.32*/("""

"""),format.raw/*3.1*/("""<!DOCTYPE html>

<html>
    <head>
        <title>"""),_display_(/*7.17*/title),format.raw/*7.22*/("""</title>
    </head>
    <body>
    """),_display_(/*10.6*/content),format.raw/*10.13*/("""
    """),format.raw/*11.5*/("""</body>
</html>
"""))}
  }

  def render(title:String,content:Html): play.twirl.api.HtmlFormat.Appendable = apply(title)(content)

  def f:((String) => (Html) => play.twirl.api.HtmlFormat.Appendable) = (title) => (content) => apply(title)(content)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Thu Aug 27 16:23:24 IST 2015
                  SOURCE: /Users/richa/work/chat_messager/app/views/main.scala.html
                  HASH: 7a9245ec58874226b53deb926991444c59f08329
                  MATRIX: 509->1|627->31|655->33|732->84|757->89|820->126|848->133|880->138
                  LINES: 19->1|22->1|24->3|28->7|28->7|31->10|31->10|32->11
                  -- GENERATED --
              */
          