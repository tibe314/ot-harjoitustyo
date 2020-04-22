# Sananetsintäalgoritmin toiminta

Koska algoritmi jota ohjelma käyttää sanojen etsintään ruudukossa on varsin tärkeässä osassa, koen sen vaivan arvoiseksi selittää sen toimintaperiaatteen tässä dokumentissa.

## Vaihe 1

Ensimmäisessä vaiheessa algoritmi ottaa käyttäjän syötteen ja tekee siitä listan char-muuttujia. Sen jälkeen ohjelma yksitellen käy läpi koko sanalistan sana sanalta. Kun yksittäinen sana otetaan käsittelyyn, ohjelma kirjain kirjaimelta tarkistaa löytyykö kirjain käyttäjän syöttämästä kirjainlistasta, ja jos on, kirjain poistetaan. Tätä jatketaan kunnes sanan kaikki kirjaimet on käyty läpi, jolloin sana lisätään *potentiaalisten sanojen listaan*, tai jos tarkistettavaa kirjainta ei (enää) löydy kirjainlistalta, sana hylätään. Tämä vaihe on tarpeellinen, koska kotimaisten kielten keskuksen [nykysuomen sanalista](http://kaino.kotus.fi/sanat/nykysuomi/) sisältää yhteensä 91&nbsp;110 sanaa. Algoritmin tämän vaiheen aikavaativuus on O(n) ja saatu lista potentiaalisia sanoja on usein noin sadan luokkaa, eli tämä vaihe nopeuttaa huomattavasti ohjelman toimintaa sillä seuraavaksi käytettävä polunetsintäalgoritmi on huomattavasti raskaampi.

<img src="https://github.com/tibe314/ot-harjoitustyo/blob/master/dokumentointi/algoritmianimaatio1.gif" width="400" height="125">
(Kämäinen animaatio ykkösvaiheen algoritmista)

## Vaihe 2

Toisessa vaiheessa algoritmi yrittää löytää potentiaalisten sanojen listan sanoille mahdollista polkua annetussa 4\*4-ruudukossa (itse koodissa käsittelemme 6\*6-ruudukkoa niin että reunimmaiset ruudut ovat tyhjiä IndexOutOfBoundsError:n välttämiseksi, mutta muuten algoritmin toiminta on kuin tässä kuvataan). Tämäkin algoritmi on oikeastaan kaksivaiheinen:

### Vaihe 2.1

Sanan löytymiselle on kaksi sääntöä, A. sanan alku- ja loppupisteellä ei ole väliä, ja B. seuraavan kirjaimen on oltava viereisessä ruudussa pysty-, vaaka- tai vinottain. Ensimmäinen vaihe käy kirjaimia läpi yksitellen, ja ensimmäisen kirjaimen löydyttyä algoritmi siirtyy polunetsintävaiheeseen.

### Vaihe 2.2

Käsiteltävää taulukkoa voi ajatella verkkona, jonka jokainen kirjain on oma solmunsa, ja jokainen solmu sisältää 8 yhteyttä viereisiin solmuihin.

Koodi on käytännössä syvyyshaku, mutta tässä koodin vaiheet tarkemmin:

- Jos solmun kirjain on etsittävän sanan viimeinen kirjain, hurraa! Sana löytyi, sana lisätään *löytyneiden sanojen listaan* ja palataan.

- Merkataan nykyinen solmu käsiteltäväksi.

- Käydään läpi jokainen viereinen solmu:
    - Jos solmun kirjain on etsittävä kirjain, kutsutaan rekursiivisesti polunetsintäalgoritmia seuraavan solmun koordinaateilla ja seuraavalla kirjaimella
    - Jos solmun kirjain ei ole etsittävä, tai solmu on jo käsiteltävänä, siirrytään seuraavaan solmuun.
    
- Merkataan nykyinen solmu käsittelemättömäksi, ja palataan.

Algoritmi on aikavaativuudeltaan vaikka mitä

![Animaatio2](https://github.com/tibe314/ot-harjoitustyo/blob/master/dokumentointi/algoritmianimaatio2.gif)

(Hieman parempi animaatio jossa polunetsintäalgoritmi yrittää etsiä verkosta sanaa 'ohjelmointi')
