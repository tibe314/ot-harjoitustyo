# Arkkitehtuurikuvaus

## Pakkausrakenne

Ohjelman pakkausrakenne on seuraava:

![pakkausrakennekuva](https://github.com/tibe314/Sanajahtiratkaisija/blob/master/dokumentointi/kuvat/pakkausrakenne.png)

*ratkaisija.UI* pitää sisällään JavaFX:llä koodatun graafisen käyttöliittymän, *ratkaisija.Solver* sananetsintään käytetyn koodin ja *ratkaisija.DataHandling* tietokannan muokkauksen hoitavat luokat.

UI ja Solver ovat molemmat yhteydessä DataHandling:n koodiin, tietokannan muokkaus tapahtuu käyttöliittymän kautta ja Solver:n sananetsintäkoodi vastaanottaa DataHandling:iltä listan etsittävistä sanoista.

## Käyttöliittymä

Graafinen käytöliittymä sisältää kolme eri näkymää:

- Aloitusnäkymä/ruudukonsyöttönäkymä
- Ratkaisunäkymä
- Tietokannan muokkausnäkymä

Nämä näkymät ovat omia [Scene](https://docs.oracle.com/javase/8/javafx/api/javafx/scene/Scene.html)-olioitaan jotka vuorotellen asetetaan [Stageen](https://docs.oracle.com/javase/8/javafx/api/javafx/stage/Stage.html). Käyttöliittymä on rakennettu luokassa [Ratkaisija.ui.RatkaisijaUI](https://github.com/tibe314/Sanajahtiratkaisija/blob/master/Ratkaisija/src/main/java/ratkaisija/UI/RatkaisijaUI.java).

## Sovelluslogiikka

### Sanojen löytäminen

Kun *RatkaisijaUI*:lle on annettu oikean mittainen syöte, vastaanottaa [solver.Algorithm](https://github.com/tibe314/Sanajahtiratkaisija/blob/master/Ratkaisija/src/main/java/ratkaisija/solver/Algorithm.java)-luokka [datahandling.WordScanner](https://github.com/tibe314/Sanajahtiratkaisija/blob/master/Ratkaisija/src/main/java/ratkaisija/datahandling/WordScanner.java)-luokalta listan etsittävistä sanoista ja *Algorithm* rupeaa etsimään sanoja 2d char-taulukosta. Algoritmin toimintaa on tarkemmin kuvattu [Algoritmin toiminta](https://github.com/tibe314/Sanajahtiratkaisija/blob/master/dokumentointi/algoritmin_toiminta.md)-dokumentissa. Tämän jälkeen *Algorithm* palauttaa UI:lle näytettäväksi listan sanoja jotka löytyvät taulukosta.

### Tietokannan muokkaaminen

Tietokannan muokkausnäkymästä on mahdollista lisätä ja poistaa sanoja. Sanaa lisätessä ohjelma etenee seuraavasti:

![sanan lisäämiskuva](https://github.com/tibe314/Sanajahtiratkaisija/blob/master/dokumentointi/kuvat/sanan_lisays.png)

DatabaseHandler (lyhennetty DBH) siis tarkistaa löytyykö lisättävää sanaa jo tietokannasta, ja sen mukaan joko kutsuu WordScannerin oikeasti sanaa lisäävää metodia addWord(String). Esimerkissä tietokannasta ei alkuun löydy sanaa "sana" ja se yritetään lisätä sinne kahdesti.

Sanan poistamiseen käytettävät delWord(String)-metodit toimivat lähes samalla tavalla, erona on se että välissä kutsutaan WordScannerin omaa metodia copyWords(ArrayList<String>, File) joka ylikirjoittaa kohdetiedoston sisällön uudella listalla, josta nyt on poistettu poistettava sana. Tähän olisi ehkä jokin parempikin keino, mutta ohjelman sisältämistä suurista sanatiedostoista huolimatta ohjelma toimii sulavasti.

Itse koodissa tietokannan nollaaminen on varsin monimutkaista, mutta idea on yksinkertainen: UI kutsuu DatabaseHandler:n kautta resetDB() metodia joka WordScanner:n sisällä kutsuu omaa reset() metodia. Tämä metodi taas poistaa PrivateWordList.txt -tiedoston ja luo sen uudestaan täyttäen sen WordListFinnish.txt -tiedoston sisällöllä.

## Rakenteeseen jääneet heikkoudet

### WordScanner ja DatabaseHandler

Tarve eriyttää sovelluslogiikka käyttöliittymästä niin että UI:lla ei ole tietoa luettavista tai muokattavista tiedostoista johti siihen että WordScanner:n ja DatabaseHandler:n metodit ovat kohteettomia, eli kohteena olevien tiedostojen sijainnit ja nimet on kirjoitettu koodiin. Tämä johti siihen että sovelluksen automaattiset testit muokkaavat suoraan ohjelman tietokantaa, joten jonkin ongelman ilmaantuessa testit saattavat jättää muokkauksia tietokantaan. Halusin projektissa enemmän keskittyä Algorithm-luokkaan, joten tietokannan muokkauksesta vastaava koodi kirjoitettiin hiukan huolimattomasti, ja syvempi tutustuminen aiheeseen ja sen parempi suunnittelu olisivat johtaneet parempaan lopputulokseen ja säästäneet aikaa loppuvaiheen debugaukselta. Koko DatabaseHandler-luokan tarpeellisuus on hieman kyseenalaista, mutta toisaalta WordScanner on varsin massiivinen luokka.
