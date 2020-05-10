# Testausdokumentti

Ohjelmaa on testattu automaattisesti JUnit yksikkö- ja integraatiotesteillä, sekä manuaalisesti järjestelmätasolla.

### Yksikkö- ja integraatiotestaus

Automatisoidut testit on jaettu kahteen testiluokkaan: [AlgorithmTest](https://github.com/tibe314/Sanajahtiratkaisija/blob/master/Ratkaisija/src/test/java/ratkaisija/AlgorithmTest.java) joka tarkistaa että sananetsinnässä käytetty koodi toimii oikein,ja [DatabaseTest](https://github.com/tibe314/Sanajahtiratkaisija/blob/master/Ratkaisija/src/test/java/ratkaisija/DatabaseTest.java) joka testaa tietokannan muokkausta. DatabaseTest-testiluokka suorittaa testit ohjelman varsinaisessa tietokannassa joka ei ole fiksua, mutta testitiedoston implementointi olisi vaatinut laajaa refaktorointia jota en ajan loppuessa ehtinyt tehdä. Tästä syystä DatabaseTest-luokan testit on mahdollista rikkoa lisäämällä tietokantaan tiettyjä sanoja eivätkä testit testaa tietokannan palauttamista (sillä se palauttaisi testejä ajettaessa oikean tietokannan, mutta myös koska tietokannan alustus suoritetaan eri tavalla riippuen siitä ajetaanko ohjelma komentoriviltä vai jar-tiedostosta).

Tietokannan palautukseen liittyvä koodi on kuitenkin tarkistettu manuaalisesti ja todettu toimivaksi.

### Testauskattavuus

Käyttöliittymäkerrosta lukuunottamatta sovelluksen testauksen rivikattavuus on 78% ja haarautumakattavuus 87%. Arvoja laskee huomattavasti se, että tietokannan palautuksesta vastaavaa koodia ei testata JUnit:lla ja että palautus käyttää eri metodeja ajotavasta riippuen.

![Testikattavuuskuva](https://github.com/tibe314/Sanajahtiratkaisija/blob/master/dokumentointi/kuvat/testikattavuus.png)


### Järjestelmätestaus

Sovelluksen järjestelmätestaus on suoritettu manuaalisesti asentamalla se [käyttöohjeen](https://github.com/tibe314/Sanajahtiratkaisija/blob/master/dokumentointi/kayttoohje.md) mukaisesti Linux-ympäristöön. Sovellus on testattu useammalla tietokoneella ja [määrittelydokumentissa](https://github.com/tibe314/Sanajahtiratkaisija/blob/master/dokumentointi/vaatimusmaarittely.md) ja käyttöohjeessa määritellyt ominaisuudet on todettu toimiviksi.
