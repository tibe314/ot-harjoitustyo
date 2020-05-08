# Arkkitehtuurikuvaus

## Sovelluslogiikka

Raaka kaavio sovelluksen luokkien yhteyksistä:
![luokat](https://github.com/tibe314/ot-harjoitustyo/blob/master/dokumentointi/kuvat/arkkitehtuuri1.jpg)

Tietokantojen lukemisesta ja niihin kirjoittamisesta vastaa WordScanner-luokka. Luokka DatabaseHandler pitää huolen että UI:n kautta käyttäjän syöttämät muutokset tietokantaan ovat fiksuja; DatabaseHandler esim. tarkistaa löytyykö lisättävä sana jo tietokannasta, ja tämän tarkistuksen jälkeen vasta kutsuu sananlisäysmetodia. DBH:n vastuulla on tarkistaa ovatko yritettävät komennot järkeviä, ja WordScanner sisältää vain joukon eri skannereita jotka lukevat, lisäävät ja poistavat tietoa sovelluksen tietokantatiedostoista.
