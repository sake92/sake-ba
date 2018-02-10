package site.posts.matematika

import java.time.LocalDate
import scalatags.Text.all._
import ba.sake.hepek.html.structure.blog.Section
import hepek.utils.Imports._

object Index extends MatematikaTemplate {

  override def pageTitle = "Matematika"
  override def pageLabel = "Početna"

  override def postCreateDate = LocalDate.of(2017, 6, 10)
  override def postSections   = List(matematikaUvodSection)

  def matematikaUvodSection = Section("Uvod", matematikaUvodSectionContent)

  def matematikaUvodSectionContent =
    row(
      half1(
        md("""
            Matematika je jedan od najomraženijih predmeta kod većine učenika. 
            S pravom, dakako!  
            Zapitajmo se šta je uzrok tome?  
            Da li je matematika zaista toliko teška, komplikovana?  
            Odgovor je jednostavan, naravno... da jeste. :D  
            Ako ne razumijemo osnovne koncepte kao što su skupovi i funkcije kako nastaviti dalje?
           """),
        md("""
            Šta profesori rade po tom pitanju?  
            Obično pišu knjige od po 1000+ stranica i nazivaju ih jednostavnim...  
            Po mom skromnom mišljenju, većina koncepata nije dovoljno dobro ili nikako objašnjena.  
            Npr, meni nikad nisu objašnjavali šta znače razni simboli tipa `AA`, `EE` i `|->`...  
            To se smatra elementarnim i krivica se prebacuje ili na prethodnog profesora ili
              pak na mene jer sam glup pa to ne znam.
           """),
        md("""
            Zar je sramota pitati takva pitanja?  
            Hoćeš li ti biti manje profesor ako zastaneš 5 minuta i objasniš terminologiju?  
            Lema, korolar, teorema, šta su te stvari??? :D
            Nauči me! To ti je pos'o!
           """)
      ),
      half2(
        image("http://i.imgur.com/UOhQzH5.gif", "Vako nekako")
      )
    )

}
