# Sanajahtiratkaisija

Sovelluksen avulla käyttäjän on mahdollista ratkaista [Sanajahti](https://fi.wikipedia.org/wiki/Sanajahti)-peli, eli löytää annetusta 4\*4-kirjainruudukosta kaikki suomen kielen sanat.

Sovelluksen tarkoitus on olla osa Helsingin Yliopiston *Ohjelmistotekniikka*-kurssin suoritusta.

Ohjelma sisältää tarkoituksella FinnishWordList.txt -tiedoston jota käytetään käyttäjän oman sanalistatietokannan alustamiseen (ja tulevaisuudessa sen päivittämiseen). Ensimmäisen ajokerran yhteydessä ohjelma luo oman tietokantatiedoston (jonka sisältö oletuksena on kopio alkuperäisestä).

## Dokumentointi
- [Vaatimusmäärittely](https://github.com/tibe314/ot-harjoitustyo/blob/master/dokumentointi/vaatimusmaarittely.md)
- [Työaikakirjanpito](https://github.com/tibe314/ot-harjoitustyo/blob/master/dokumentointi/tuntikirjanpito.md)
- [Arkkitehtuurikuvaus](https://github.com/tibe314/ot-harjoitustyo/blob/master/dokumentointi/arkkitehtuuri.md)

## Releaset
- [Viikko 5](https://github.com/tibe314/ot-harjoitustyo/releases/tag/viikko5)

## Komentorivitoiminnot
Sovelluksen voi ajaa komentoriviltä komennolla
```
mvn compile exec:java -Dexec.mainClass=ratkaisija.Sanajahtiratkaisija
```
### Testaus
Testauksen voi suorittaa komennolla
```
mvn test
```
ja testikattavuusraportin komennolla
```
mvn test jacoco:report
```
Raportti luetaan avaamalla selaimella _target/site/jacoco/index.html_
### Checkstyle-raportti
Checkstyle-raportin luonti onnistuu komennolla
```
mvn jxr:jxr checkstyle:checkstyle
```
Ja raportin voi tarkistaa avaamalla selaimessa _target/site/checkstyle.html_

### Jar-tiedoston luominen
Jar-tiedoston luonti tapahtuu komennolla
```
mvn package
```

## Tämänhetkinen toiminnallisuus

### 31.3.2020

Ohjelman voi ajaa, käyttäjä voi syöttää ohjelmalle haluamansa merkkijonon. Nappia painamalla ohjelma tarkistaa onko käyttäjän syöte oikean mittainen (eli onko siinä 16 merkkiä).

### 14.4.2020

Ohjelma ensimmäisellä käynnistyskerralla (tai sen muuten puuttuessa) luo käyttäjälle oman sanatietokannan, jota on mahdollista muokata lisäämällä ja poistamalla sanoja. Tietokannan voi myös palauttaa alkuperäiseen muotoon.

### 21.4.2020

Oikean pituisen syötteen saatuaan ohjelma näyttää muodostetun kirjainruudukon, ja toistaiseksi näyttää kaikki sanat jotka kirjaimista on mahdollista muodostaa polusta riippumatta.
