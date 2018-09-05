package site

import scalatags.Text.all._
import ba.sake.hepek.core.RelativePath
import ba.sake.hepek.implicits.PageSettings
import hepek.templates.SakeBaBlogStaticPage
import hepek.utils.Site

object NotFound extends SakeBaBlogStaticPage {

  override def pageSettings =
    PageSettings("Ne postoji!")

  override def fileName: String = "404.shtml"

  /* Since we use RELATIVE LINKS when referring to JS files, pages etc.
   * it doesn't work well when you land on a page e.g. sake.ba/blah/sdfd/fdf/dsf/s
   */
  override def relTo(other: RelativePath) =
    Site.url + "/" + super.relTo(other)

  override def pageContent = div(cls := "text-center")(
    p(raw("""Resurs '<!--#echo var="REQUEST_URI" -->' ne postoji!""")),
    p("(Bar zasad...) ^_^"),
    br,
    br,
    br,
    raw(""" <a href="https://<!--#echo var="HTTP_HOST" -->">Haj nazad</a> """)
  )

}
