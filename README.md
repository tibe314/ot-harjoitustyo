# Sanajahtiratkaisija

Sovelluksen avulla käyttäjän on mahdollista ratkaista [Sanajahti](https://fi.wikipedia.org/wiki/Sanajahti)-peli, eli löytää annetusta 4\*4-kirjainruudukosta kaikki suomen kielen sanat.

Sovelluksen tarkoitus on olla osa Helsingin Yliopiston *Ohjelmistotekniikka*-kurssin suoritusta.

Ohjelma sisältää tarkoituksella FinnishWordList.txt -tiedoston jota käytetään käyttäjän oman sanalistatietokannan alustamiseen ja päivittämiseen. Ensimmäisen ajokerran yhteydessä ohjelma luo oman tietokantatiedoston (jonka sisältö oletuksena on kopio alkuperäisestä).

## Dokumentointi
- [Käyttöohje](https://github.com/tibe314/ot-harjoitustyo/blob/master/dokumentointi/kayttoohje.md)
- [Vaatimusmäärittely](https://github.com/tibe314/ot-harjoitustyo/blob/master/dokumentointi/vaatimusmaarittely.md)
- [Työaikakirjanpito](https://github.com/tibe314/ot-harjoitustyo/blob/master/dokumentointi/tuntikirjanpito.md)
- [Arkkitehtuurikuvaus](https://github.com/tibe314/ot-harjoitustyo/blob/master/dokumentointi/arkkitehtuuri.md)
- [Algoritmin toiminta](https://github.com/tibe314/ot-harjoitustyo/blob/master/dokumentointi/algoritmin_toiminta.md)
- [Testausdokumentti](https://github.com/tibe314/Sanajahtiratkaisija/blob/master/dokumentointi/testaus.md)

## Releaset
- [Loppupalautus (v1.0)](https://github.com/tibe314/Sanajahtiratkaisija/releases/tag/v1.0)
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
Suoritettava Ratkaisija-1.0-SNAPSHOT.jar -tiedosto löytyy target kansiosta, ja sen voi ajaa komennolla
```
java -jar Ratkaisija-1.0-SNAPSHOT.jar
```
