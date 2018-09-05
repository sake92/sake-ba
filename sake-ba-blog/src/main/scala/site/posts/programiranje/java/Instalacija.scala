package site.posts.programiranje.java

import java.time.LocalDate
import scalatags.Text.all._
import ba.sake.hepek.html.structure.blog.Section
import hepek.images.Images
import hepek.utils.Imports._

object Instalacija extends JavaTemplate {

  override def pageSettings =
    super.pageSettings
      .withTitle("Instalacija")
      .withDescription(
        "Postupak downloada i instalacije Java platforme: JDK, JRE, javac, java."
      )

  override def blogSettings =
    super.blogSettings
      .withCreateDate(LocalDate.of(2017, 7, 2))
      .withSections(uvodSection, dodavanjePATHSection, provjeraSection)

  val linkToAddPath =
    hyperlink(relTo(this) + "#" + dodavanjePATHSection.id)(
      dodavanjePATHSection.name
    )

  def uvodSection = Section(
    "Instalacija Jave",
    div(
      md("""
          U nastavku slijedi primjer za instalaciju Jave 8. 
          Potpuno isti postupak je i za ostale verzije.  
      """),
      "Odaberite jednu od sljedećih verzija: ",
      hyperlink(
        "http://www.oracle.com/technetwork/java/javase/downloads/index.html",
        target := "_blank"
      )("Java 8"),
      " | ",
      hyperlink(
        "http://www.oracle.com/technetwork/java/javase/downloads/jdk9-downloads-3848520.html",
        target := "_blank"
      )("Java 9"),
      " | ",
      hyperlink(
        "http://jdk.java.net/10/",
        target := "_blank"
      )("Java 10"),
      ".",
      image(relTo(Images.java.downloadJDK1), "JDK download step 1"),
      md(
        "Kada se otvori stranica sa prethodne slike kliknite na dugme **download JDK**."
      ),
      blockquote(
        md("""
            JDK (Java Development Kit) su alati za razvijanje Java programa: kompajler, debager itd.
            JDK sadrži JRE (Java Runtime Environment) koji služi za pokretanje Java programa (JVM, Java API klase itd).
           """)
      ),
      md("""
          Na sljedećoj slici kliknite na "jdk-8u131-windows-x64.exe".
          To je instalacija za 64-bitni Windows.  
          Ako znate da imate 32-bitni Windows onda skinite tu verziju... 
         """),
      image(relTo(Images.java.downloadJDK2), "JDK download step 2"),
      md("""
          Preporučujem da Javu instalirate u folder pod nazivom "C:\Java".  
          Ovo ne morate raditi ali je korisno kada vam treba više verzija Jave.  
          Također, neki programi na Windowsu imaju problema kada putanja sadrži razmak, 
            zato nećemo instalirati u "Program Files"... 
        """),
      blockquote(
        md("""
            **Napomena**: Ne trebate instalirati i JRE!  
            Kada vam dođe prozor za JRE kliknite Cancel! (iksić).  
            Upravo sam vam uštedio 100-tinjak megabajta, nema na čemu... :D
           """)
      ),
      p(
        "Dakle, Kada se završi download, otvorite instalaciju i kliknite Next.",
        br,
        image(relTo(Images.java.installJDKFolder), "JDK folder"),
        """Zatim kliknite dugme "Change..." i prepravite putanju foldera na "C:\Java\jdk1.8.0_131\". """,
        br,
        "JRE će već biti instaliran zajedno sa JDK! Tako da nam ne treba još jedna instalacija...",
        image(relTo(Images.java.installJRENope), "JRE, nope!")
      )
    )
  )

  def dodavanjePATHSection =
    Section(
      "Dodavanje PATH varijabli",
      div(
        p(
          "Dio koji slijedi vezan je više za sam rad operativnog sistema (Windows u našem slučaju) nego za Javu.",
          br,
          "Otvorite Computer Properties na Windowsu (desni klik na My Computer -> Properties). Otvoriće vam se sljedeći prozor:",
          image(relTo(Images.os.winCompProps), "Computer Properties"),
          "Kliknite na Advanced System Settings. Dobićete sljedeći prozor: ",
          image(relTo(Images.os.winSysProps), "System Properties")
        ),
        p(
          md("""
            Otvorite `Advanced` tab i kliknite `Environment Variables...`.  
            Dodajte 3 sistemske varijable u donji prozor (u System Variables):
          """),
          table(cls := "table table-hover")(
            tr(th("Naziv varijable"), th("Vrijednost")),
            tr(td("JAVA_HOME"), td("""C:\Java\jdk1.8.0_131""")),
            tr(td("JDK_HOME"), td("%JAVA_HOME%")),
            tr(td("JRE_HOME"), td("""%JAVA_HOME%\jre"""))
          ),
          md("""
            **Glavno**, otvorite "PATH" varijablu i dodajte ";%JAVA_HOME%\bin" na kraj.  
            Nemojte zaboravit tačkazarez kopirati! :D  
            Bez navodnika, naravno! Kliknite Ok, Ok...

            To je to! Uspješno ste instalirali Javu! :)  
            Stanje bi trebalo biti otprilike ovako:
          """),
          image(relTo(Images.os.winSysVars), "System Properties")
        )
      )
    )

  def provjeraSection = Section(
    "Provjera",
    div(
      md(s"""
        Da bi provjerili jesmo li uspješno obavili zadatak, 
          otvorićemo Command Prompt (kod Linuxaša se rekne Shell).  
        Otvorite Start, ukucajte "cmd" i kliknite Enter. Ukucajte `java -version`.  
        Ako dobijete poruku 
          `'java' is not recognized as an internal or external command, operable program or batch file.`
          nešto nije uredu, provjerite sve korake sekcije $linkToAddPath ponovo!
      """),
      "Ako dobijete nešto slično sljedećoj slici, sve je OK:",
      image(relTo(Images.os.winJavaVer), "Java verzija")
    )
  )

}
