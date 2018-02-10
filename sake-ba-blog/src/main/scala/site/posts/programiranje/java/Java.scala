package site.posts.programiranje.java

import java.time.LocalDate
import scalatags.Text.all._
import ba.sake.hepek.html.structure.blog.Section
import hepek.images.Images
import hepek.utils.Imports._

object Java extends JavaTemplate {

  override def pageTitle       = "Uvod u Javu"
  override def pageDescription = Option("Uvod u Java programski jezik.")

  override def postCreateDate = LocalDate.of(2017, 7, 2)
  override def postSections   = List(uvodSection)

  def uvodSection =
    Section("Java",
            uvodSectionContent,
            List(javaPJSection, javaPlatformSection))
  def javaPJSection = Section("Java kao programski jezik", javaPJSectionContent)

  def javaPlatformSection =
    Section("Java kao platforma", javaPlatformSectionContent)

  // SEKCIJE
  def uvodSectionContent = div(
    p(
      "Svako putovanje mora početi od nekud.",
      br,
      "Ovo naše polazi od ",
      hyperlink("https://en.wikipedia.org/wiki/Java_(programming_language)",
                true)(
        "Jave"
      ),
      ", jednog od najkorištenijih programskih jezika na svijetu."
    ),
    p(
      """
        Kada se kaže "Java" obično se misli na programski jezik, 
        ali Java također podrazumijeva i cijelu platformu za razvijanje softvera.
      """,
      br,
      "U platformu se podrazumijeva JVM (Java Virtual Machine) i Java API."
    )
  )

  def javaPJSectionContent = div(
    "Kada je dizajniran Java programski jezik, dizajneri su željeli da Java bude: ",
    ul(
      li("jednostavna"),
      li("objektno orijentisana"),
      li("distribuirana"),
      li("višenitna (multithreaded)"),
      li("dinamična"),
      li("nezavisna od arhitekture"),
      li("portabilna"),
      li("visokih performansi"),
      li("robustna (otporna na greške)"),
      li("bezbjedna")
    ),
    row(
      half1(
        p(
          "Sav izvorni kod se nalazi u običnim tekstualnim fajlovima s nastavkom ",
          i(".java"),
          """ (npr. "MojProgram.java").""",
          br,
          "Ti fajlovi se zatim kompajliraju u ",
          i(".class"),
          " fajlove pomoću programa zvanog ",
          b("javac"),
          " kompajler.",
          br,
          "Fajl dobijen kompajliranjem (",
          i(".class"),
          " fajl) ne sadrži nativni kod za specifičan procesor već sadrži takozvani ",
          b("bytecode"),
          " (bajtkod).",
          br,
          """Bajtkod predstavlja "mašinski kod" za Java Virtuelnu Mašinu (JVM).""",
          br,
          """Jedna instanca JVM (pomoću programa zvanog "java") pokreće Vašu aplikaciju tako što interpretira bajtkod u izvorni kod."""
        )
      ),
      half2(
        image(relTo(Images.java.compiler),
              "Razvijanje i izvršavanje Java programa")
      )
    ),
    row(
      half1(
        p(
          "Možda i najpoznatija uzrečica koja ide uz Javu je ",
          b("Write once - Run anywhere"),
          ".",
          br,
          "Pošto postoje JVM za većinu popularnih operativnih sistema, isti ",
          i(".class"),
          " fajlovi se mogu izvršavati na Windowsu, Linuxu, ili Mac OS. ",
          "Neke JVM dodatno optimizuju Vaš kod da bi se brže izvršavao i s manje potrebne memorije."
        )
      ),
      half2(
        image(relTo(Images.java.portability), "Portabilnost Java programa")
      )
    )
  )

  def javaPlatformSectionContent = div(
    row(
      half1(
        p(
          "Platformu čini hardver i softversko okruženje u kojem se program izvršava.",
          br,
          "Već smo naveli neke od najpopularnijih platformi kao što su MS Windows, Linux, Solaris OS, i Mac OS.",
          br,
          "Većina platformi su kombinacija operativnog sistema i hardvera.",
          br,
          "Java platforma se razlikuje od ostalih platformi jer se sastoji samo iz softvera koji se izvršava na različitim hardverski baziranim platformama."
        )
      ),
      half2(
        image(relTo(Images.java.platform),
              "Razvijanje i izvršavanje Java programa")
      )
    ),
    p(
      "Java platformu čine dvije komponente:",
      ul(
        li("Java virtuelna mašina (JVM)"),
        li("Java API (Application Programming Interface)")
      ),
      p(
        "Pošto smo već opisali Java virtuelnu mašinu, ukratko ćemo reći nešto o Java API (interfejsu za programiranje aplikacija).",
        br,
        "Java API je velika kolekcija gotovih softverskih komponenti koje pružaju razne pogodnosti/usluge.",
        br,
        "Grupisan je u biblioteke povezanih klasa i interfejsa (library), a ove biblioteke se nazivaju i paketima.",
        br,
        "Kao platformski nezavisno okruženje, Java platforma može biti malo sporija od nativnog koda.",
        br,
        "Međutim, napredak u ravoju kompajlera i virtuelnih mašina dovodi performanse Java koda vrlo blizu onom napisanom u C-u ili C++-u."
      )
    )
  )

}
