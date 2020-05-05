# Käyttöohje

Lataa tiedosto **TÄHÄN LINKKI RELEASEEN**

## Konfigurointi

Ensimmäisellä käynnistyskerralla tai sen muuten puuttuessa (esim. käyttäjän sen poistaessa) ohjelma luo käynnistyshakemistoon PrivateWordList.txt -tiedoston, joka toimii sovelluksen tietokantana. Ohjelma kopioi sen sisällöksi FinnishWordList.txt -tiedoston sisällön, eli ohjelma olettaa sen löytyvän hakemistosta.

Tiedostot sisältävät yhden sanan per rivi loppuen tyhjään riviin. Jos käyttäjä haluaa peukaloida PrivateWordList:iä manuaalisesti (esimerkiksi vaihtaakseen sanatietokannan toiselle kielelle), tulee tyhjä rivi jättää loppuun jotta sanojen lisäys toimii oikein. Ohjelma ei itse tätä tarkista sillä käyttäjän ei ole tarkoitus muokata tiedostoa itse.

## Ohjelman käynnistäminen

Ohjelman voi käynnistää komennolla
```
TODO
```

## Ohjelman käyttö

### Pelin säännöt ja selitys ohjelman toiminnasta

Sanajahti on mobiilipeli jossa pelaajan tarkoitus on aikarajan sisällä löytää mahdollisimman monta sanaa pelin antamasta 4\*4-kirjainruudukosta. Sana täytyy voida muodostaa piirtämällä reitti kirjaimesta kirjaimeen kulkien vinottain tai pysty- ja vaakasuoraan. Samaa ruutua ei saa käyttää samassa sanassa kuin kerran.

![Esimerkkiruudukko](https://github.com/tibe314/ot-harjoitustyo/blob/master/dokumentointi/kuvat/esimerkkiruudukko.png)
