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

Tietokannan muokkausnäkymästä on mahdollista 


