# Käyttöohje

Lataa tiedosto [sanajahtiratkaisija.jar](https://github.com/tibe314/Sanajahtiratkaisija/releases/tag/v1.0)

## Konfigurointi

Ensimmäisellä käynnistyskerralla tai sen muuten puuttuessa (esim. käyttäjän sen poistaessa) ohjelma luo käynnistyshakemistoon PrivateWordList.txt -tiedoston, joka toimii sovelluksen tietokantana.

Tiedostot sisältävät yhden sanan per rivi loppuen tyhjään riviin. Jos käyttäjä haluaa peukaloida PrivateWordList:iä manuaalisesti (esimerkiksi vaihtaakseen sanatietokannan toiselle kielelle), tulee tyhjä rivi jättää loppuun jotta sanojen lisäys toimii oikein. Ohjelma ei itse tätä tarkista sillä käyttäjän ei ole tarkoitus muokata tiedostoa itse.

## Ohjelman käynnistäminen

Ohjelman voi käynnistää komennolla
```
java -jar sanajahtiratkaisija.jar
```

## Ohjelman käyttö

### Pelin säännöt ja selitys ohjelman toiminnasta

Sanajahti on mobiilipeli jossa pelaajan tarkoitus on aikarajan sisällä löytää mahdollisimman monta sanaa pelin antamasta 4\*4-kirjainruudukosta. Sana täytyy voida muodostaa piirtämällä reitti kirjaimesta kirjaimeen kulkien vinottain tai pysty- ja vaakasuoraan. Samaa ruutua ei saa käyttää samassa sanassa kuin kerran.

![Esimerkkiruudukko](https://github.com/tibe314/ot-harjoitustyo/blob/master/dokumentointi/kuvat/esimerkkiruudukko.png)

(esimerkki miltä pelin ruudukko näyttää. mahdollisista tekijänoikeussyistä kuva tehty itse)

### Sanaruudukon syöttäminen

Sovellus aukeaa ruudukonsyöttönäkymään:

![Aloitusnäkymä](https://github.com/tibe314/ot-harjoitustyo/blob/master/dokumentointi/kuvat/alotusnakyma.png)

Syötekenttään kirjoitetaan yhtenä pötkönä kirjainruudukko ilman välimerkkejä, esim. ylempänä olevan esimerkkiruudukon sisältö syötettäisiin:
```
tenoudnikomtnvol
```
Kirjainten koolla ei ole väliä, ja ohjelma osaa tarkastaa jos syöte on väärän pituinen.

### Ratkaisunäkymä

Antamalla oikean pituinen syöte aloitusnäkymässä ja painamalla *Löydä sanat*-nappia ohjelma siirtyy ratkaisunäkymään:

![Ratkaisunäkymä](https://github.com/tibe314/ot-harjoitustyo/blob/master/dokumentointi/kuvat/ratkaisunakyma.png)

Näkymässä vasemmalla näkyy sanaruudukko, ja oikealla näkyy lista kaikista löytyvistä sanoista pisimmästä lyhimpään (koska itse mobiilipelissä pidemmistä sanoista saa enemmän pisteitä). Takaisin aloitusnäkymään pääsee *Takaisin*-painikkeesta.

### Tietokannan muokkaaminen

Painamalla *Muokkaa tietokantaa*-nappia aloitusnäkymässä ohjelma siirtyy muokkausnäkymään:

![Muokkausnäkymä](https://github.com/tibe314/ot-harjoitustyo/blob/master/dokumentointi/kuvat/muokkausnakyma.png)

Näkymä toimii siten, että haluttu sana syötetään tekstikenttään jonka jälkeen nappia painamalla sanalle tehdään haluttu operaatio (joko lisätään tai poistetaan). Napista *Palauta tietokanta* on mahdollista palauttaa PrivateWordList.txt alkuperäiseen muotoonsa (kopioksi FinnishWordList.txt:stä). **Palautusoperaatio ei sisällä *haluatko varmasti* varoitusta eikä toimintoa voi peruuttaa**.

Operaation tehtyä näkymään ilmestyy viesti joka kertoo mitä tapahtui:

![Ilmoitusesimerkki](https://github.com/tibe314/ot-harjoitustyo/blob/master/dokumentointi/kuvat/ilmoitusesim.png)

Tietokantaan ei ole mahdollista lisätä sanaa joka jo löytyy sieltä, eikä sieltä ole mahdollista poistaa sanaa jota siellä ei ole.

Takaisin aloitusnäkymään pääsee *Takaisin*-painikkeella.
