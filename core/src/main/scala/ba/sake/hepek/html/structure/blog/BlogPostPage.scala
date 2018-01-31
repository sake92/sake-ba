package ba.sake.hepek.html

package structure

package blog

import java.time.format.DateTimeFormatter
import java.time.LocalDate
import scalatags.text.Frag
import ba.sake.hepek.utils.StringUtils

trait BlogPostPage extends Page {

  def postAuthor: String

  def postCreateDate: LocalDate

  def postSections: List[Section] = List.empty

  def categoryPosts: List[BlogPostPage] = List.empty

  def dateFormat = DateTimeFormatter.ofPattern("dd.MM.yyyy")

}

/**
  * Handy class for sectioning a page (usually blog post). <br>
  * Also useful for generating a TOC (Table Of Contents).
  */
case class Section(
    name: String,
    content: Frag,
    children: List[Section] = List.empty
) {

  def id: String =
    StringUtils.urlify(name)

}
