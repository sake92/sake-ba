package site.posts.matematika

import ba.sake.hepek.html.structure.PageSettings
import ba.sake.hepek.html.structure.blog.BlogPostPage
import ba.sake.hepek.katex.KatexDependencies
import templates.SakeBaBlogPage

trait MatematikaTemplate extends SakeBaBlogPage with KatexDependencies {

  override def pageSettings = PageSettings().withCategory("Matematika")

  // compiler sometimes doesn't infer the type ??????????????
  override def categoryPosts: List[BlogPostPage] = List(Index, TeorijaSkupova)

}
