package hepek.templates

import java.time.LocalDate
import scalatags.Text.all._
import ba.sake.hepek.html.structure._
import ba.sake.hepek.bootstrap3.blog.BootstrapBlogPage
import ba.sake.hepek.bootstrap3.statik.BootstrapStaticPage
import ba.sake.hepek.bootstrap3.component.BootstrapGridComponents
import ba.sake.hepek.anchorjs.AnchorjsDependencies
import ba.sake.hepek.Resources._
import ba.sake.hepek.Resource
import hepek.images.Images
import hepek.utils.Site
import hepek.utils.Imports._

trait SakeBaBlogPage extends SakeBaBlogStaticPage with BootstrapBlogPage {

  override def tocTitle       = "Sadržaj"
  override def postAuthor     = "Sakib Hadžiavdić"
  override def postCreateDate = LocalDate.now // override when post is finished

  // google analytics
  override def headContent = super.headContent ++ List(
    raw("""
          <!-- Global Site Tag (gtag.js) - Google Analytics -->
          <script async src="https://www.googletagmanager.com/gtag/js?id=UA-93179008-1"></script>
          <script>
            window.dataLayer = window.dataLayer || [];
            function gtag(){dataLayer.push(arguments);}
            gtag('js', new Date());
            gtag('config', 'UA-93179008-1');
          </script>
        """)
  )

  // DISQUS COMMENTS STUFF
  val PAGE_URL = Site.url + "/" + site.Index.relTo(this)
  //.replaceAll("""\\""", "/") // when on windows..
  val PAGE_IDENTIFIER = PAGE_URL.##.abs // hopefully unique enough... :D

  // disqus comments
  override def scriptsInline =
    super.scriptsInline ++
      List(s"""
              var disqus_config = function () {
                this.page.url = '$PAGE_URL';
                this.page.identifier = $PAGE_IDENTIFIER;
              };

              (function() {
                var d = document, s = d.createElement('script');
                s.src = 'https://sake-ba.disqus.com/embed.js';
                s.setAttribute('data-timestamp', +new Date());
                (d.head || d.body).appendChild(s);
              })();
            """)

}

trait SakeBaBlogStaticPage
    extends BootstrapStaticPage
    with BootstrapGridComponents
    with AnchorjsDependencies {

  override def siteSettings = SiteSettings(
    Site.name,
    site.Index,
    Site.mainPages,
    Option(relTo(Images.favicon)),
    Option(relTo(Images.faviconWhite))
  )

  override def styleURLs  = super.styleURLs :+ relTo(styles.css("main"))
  override def scriptURLs = super.scriptURLs :+ relTo(scripts.js("main"))

  // Bootswatch cyborg theme
  override def bootstrapCSSDependencies = List(
    DependencyProvider.cdnjs.depPath(
      Dependency("cyborg/bootstrap.min.css", bootstrapVersion, "bootswatch")
    )
  )

  override def smRatios = None
  override def xsRatios = None

}
