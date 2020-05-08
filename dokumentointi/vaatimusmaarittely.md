# Vaatimusmäärittely

## Sovelluksen tarkoitus

Sovelluksen tarkoitus on ratkaista [Sanajahti](https://fi.wikipedia.org/wiki/Sanajahti)-peli (Wikipedia-linkki), eli löytää
kaikki suomen kielen sanat (ladattavissa mm. Kotuksen sivuilta) käyttäjän antamasta 4x4 ruudukosta. Sovelluksen käyttöliittymä
mielellään antaisi käyttöliittymässään graafisesti jonkinlaisen avun sanan "piirtämiseen" kuten ensimmäisen ja viimeisen 
kirjaimen korostus sekä nuolilla tms. avuilla sanan "reitin" (ks. käyttöliittymäluonnos) näyttäminen. Sovelluksessa
on myös mahdollista poistaa ja lisätä sanoja sovelluksen tietokantaan, sillä Sanajahdin ja Kotuksen sanatietokannat eivät liene täysin identtiset.


## Käyttöliittymäluonnos

![käyttöliittymäluonnos](https://github.com/tibe314/ot-harjoitustyo/blob/master/dokumentointi/kuvat/kayttoliittymaluonnos.jpg)
Luonnos sovelluksen ideaalista päänäkymästä. Käyttäjä näkee listan mahdollisista sanoista, ja joko käyttöliittymän 
painikkeilla tai näppäimistöä käyttäen olisi mahdollista näyttää ensin käyttäjän antamassa ja sitten sovelluksen piirtämässä
kirjainruudukossa sanojen reitit.

## Perustoiminnallisuus

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
