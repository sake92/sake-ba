package ba.sake.hepek.bootstrap3.blog

import scalatags.Text.all._
import ba.sake.hepek.bootstrap3.statik.BootstrapStaticPage
import ba.sake.hepek.bootstrap3.component.AllBootstrapComponents
import ba.sake.hepek.html.structure.blog.BlogPostPage
import ba.sake.hepek.html.structure.blog.Section

trait BootstrapBlogPage extends BootstrapStaticPage with BlogPostPage {
  // avoid polluting user's namespace
  import AllBootstrapComponents._
  import BootstrapSectionUtils._

  def tocTitle: String = "Table Of Contents"

  override def beforePageContent: Frag = navbarr

  override def pageContent = frag(
    row(div(cls := "page-header text-center")(h1(pageTitle))),
    row(
      div(cls := "col-lg-2 col-lg-push-1  col-md-3")(sidebar),
      div(cls := "col-lg-8 col-lg-push-1  col-md-9")(
        h6(span(cls := "glyphicon glyphicon-time"),
           " " + postCreateDate.format(dateFormat)),
        h6(span(cls := "glyphicon glyphicon-user"), " Autor: " + postAuthor),
        tag("article")(renderTOCAndSections(postSections)),
        div(id := "disqus_thread")
      )
    )
  )

  /* CONTENT*/
  private def renderTOCAndSections(secs: List[Section], depth: Int = 1): Frag =
    frag(
      div(cls := "panel-group")(
        div(cls := "panel panel-default")(
          div(cls := "panel-heading")(
            h4(cls := "panel-title")(
              a(data.toggle := "collapse", href := "#collapseTOC")(tocTitle)
            )
          ),
          div(id := "collapseTOC", cls := "panel-collapse collapse")(
            div(cls := "panel-body pages-toc")(renderTOC(secs, depth))
          )
        )
      ),
      div(renderSections(secs, depth))
    )

  private def sidebar: Frag = {
    val pageLiTags = for {
      p <- categoryPosts
      activeClass = if (p.relPath == relPath) "active" else ""
    } yield li(cls := activeClass, a(href := relTo(p))(p.pageLabel))
    ul(cls := "nav nav-pills nav-stacked")(pageLiTags)
  }

  /* NAVBAR */
  private def navbarLiTags: List[Frag] =
    for {
      page <- siteSettings.mainPages
      labela = page.pageCategory.getOrElse(page.pageLabel)
      klasa = {
        if (page.pageCategory == this.pageCategory) "active "
        else ""
      }
    } yield li(cls := klasa)(a(href := relTo(page))(labela))

  // helpers
  private def navbarr =
    navbar()(
      navbarHeader()(
        navbarCollapseToggleBtn(),
        navbarBrand(relTo(siteSettings.indexPage))(
          siteSettings.faviconInverted.map { fav =>
            span(img(src := fav))
          },
          " " + siteSettings.name
        )
      ),
      navbarCollapse()(navbarContent()(navbarLiTags))
    )

}
