# Vaatimusmäärittely

## Sovelluksen tarkoitus

Sovelluksen tarkoitus on ratkaista [Sanajahti](https://fi.wikipedia.org/wiki/Sanajahti)-peli (Wikipedia-linkki), eli löytää
kaikki suomen kielen sanat käyttäjän antamasta 4x4 ruudukosta. Sovelluksen sanatietokantaa voi myös muokata ohjelman kautta, sillä ladattu sanalista ei ole identtinen Sanajahti-pelin käyttämään. Sovelluksen tietokantaan on mahdollista poistaa ja lisätä sanoja, ja mahdollisten virhelisäysten tai muun ongelman ilmentyessä sovelluksen tietokannan voi palauttaa alkuperäiseen muotoonsa.


## Käyttöliittymäluonnos

![käyttöliittymäluonnos](https://github.com/tibe314/ot-harjoitustyo/blob/master/dokumentointi/kuvat/kayttoliittymaluonnos.jpg)
Luonnos sovelluksen ideaalista ratkaisunäkymästä. Käyttäjä näkee listan kaikista mahdollisista sanoista jotka voi ruudukolla muodostaa.

## Perustoiminnallisuus

Aloitusnäkymässä:

* Käyttäjä voi syöttää sanaruudukon
  * Oikean pituisen syötteen annettuaan käyttäjä voi siirtyä ratkaisunäkymään
  * Ratkaisunäkymässä käyttäjä näkee kaikki sanaruudukossa muodostettavissa olevat sanat
  * Ratkaisunäkymästä voi palata aloitusnäkymään sulkematta sovellusta
* Käyttäjä voi siirtyä tietokannan muokkausnäkymään
  * Muokkausnäkymässä käyttäjä voi lisätä ja poistaa sanoja
  * Käyttäjä voi palauttaa tietokannan alkuperäiseen muotoon
  * Käyttäjä voi palata aloitusnäkymään sulkematta sovellusta

- ~Sovellukselle on mahdollista syöttää näppäimistöltä kirjainruudukko, jonka jälkeen sovellus jonkinlaista
polunetsintäalgoritmia käyttäen löytää kaikki sanat mitä sovellus sanatietokannassaan sisältää.~ **TEHTY**
- ~Sovellukseen on mahdollista lisätä ja poistaa sanoja~ **TEHTY**
- ~Sovelluksen sanatietokannan voi "palauttaa tehdasasetuksiin"~ **TEHTY**
- ~Käyttäjä voi syöttää uuden kirjainruudukon uudelleenkäynnistämättä sovellusta~ **TEHTY**

## Jatkokehitysideoita

- Sovellus antaa jonkinsortin graafisen avun sanan löytämiseen
- Sovellus tukee muita kieliä
- Sovellus mahdollistaa käyttäjän "huijata" muissa sanapeleissä (esim. tuki Scrabblelle lähes olisi sovelluksella jo, jos
tarkoituksena on vain löytää kaikki sanat annetuista kirjaimista)
