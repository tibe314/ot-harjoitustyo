# Sananetsintäalgoritmin toiminta

Koska algoritmi jota ohjelma käyttää sanojen etsintään ruudukossa on varsin tärkeässä osassa, koen sen vaivan arvoiseksi selittää sen toimintaperiaatteen tässä dokumentissa.

## Vaihe 1

Ensimmäisessä vaiheessa algoritmi ottaa käyttäjän syötteen ja tekee siitä listan char-muuttujia. Sen jälkeen ohjelma yksitellen käy läpi koko sanalistan sana sanalta. Kun yksittäinen sana otetaan käsittelyyn, ohjelma kirjain kirjaimelta tarkistaa löytyykö kirjain käyttäjän syöttämästä kirjainlistasta, ja jos on, kirjain poistetaan. Tätä jatketaan kunnes sanan kaikki kirjaimet on käyty läpi, jolloin sana lisätään *potentiaalisten sanojen listaan*, tai jos tarkistettavaa kirjainta ei (enää) löydy kirjainlistalta, sana hylätään. Tämä vaihe on tarpeellinen, koska kotimaisten kielten keskuksen [nykysuomen sanalista](http://kaino.kotus.fi/sanat/nykysuomi/) sisältää yhteensä 91&nbsp;110 sanaa. Algoritmin tämän vaiheen aikavaativuus on O(n) ja saatu lista potentiaalisia sanoja on usein noin sadan luokkaa, eli tämä vaihe nopeuttaa huomattavasti ohjelman toimintaa sillä seuraavaksi käytettävä polunetsintäalgoritmi on huomattavasti raskaampi.
