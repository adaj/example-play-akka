
package views.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import java.lang._
import java.util._
import scala.collection.JavaConverters._
import play.core.j.PlayMagicForJava._
import play.mvc._
import play.api.data.Field
import play.mvc.Http.Context.Implicit._
import play.data._
import play.core.j.PlayFormsMagicForJava._

object actor extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(msg: String):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.1*/("""
"""),_display_(/*3.2*/main("Page Title")/*3.20*/ {_display_(Seq[Any](format.raw/*3.22*/("""
  """),format.raw/*4.3*/("""<h1>"""),_display_(/*4.8*/msg),format.raw/*4.11*/("""</h1>
""")))}),format.raw/*5.2*/("""
"""))
      }
    }
  }

  def render(msg:String): play.twirl.api.HtmlFormat.Appendable = apply(msg)

  def f:((String) => play.twirl.api.HtmlFormat.Appendable) = (msg) => apply(msg)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Fri May 31 11:04:56 BRT 2019
                  SOURCE: /home/adelsondias/Repos/example-play-akka/app/views/actor.scala.html
                  HASH: 6d809f268ec9ba761dd4475a050ff784fb5a4e3c
                  MATRIX: 948->1|1055->15|1082->17|1108->35|1147->37|1176->40|1206->45|1229->48|1265->55
                  LINES: 28->1|33->2|34->3|34->3|34->3|35->4|35->4|35->4|36->5
                  -- GENERATED --
              */
          