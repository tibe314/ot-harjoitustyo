package com.mycompany.unicafe;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class MaksukorttiTest {

    Maksukortti kortti;

    @Before
    public void setUp() {
        kortti = new Maksukortti(10);
    }

    @Test
    public void luotuKorttiOlemassa() {
        assertTrue(kortti!=null);    
        assertEquals(kortti.saldo(), 10);
    }
    
    @Test
    public void kortinLuontiToimii() {
        assertEquals("saldo: 0.10",kortti.toString());
    }
    
    @Test
    public void kortilleVoiLadata() {
        kortti.lataaRahaa(1000);
        assertEquals("saldo: 10.10",kortti.toString());
    }
    
    @Test
    public void saldoEiMuutuJosRahaaEiTarpeeksi() {
        kortti.otaRahaa(999999999);
        assertEquals("saldo: 0.10",kortti.toString());
    }
    
    @Test
    public void booleanitToimivat() {
        assertEquals(true,kortti.otaRahaa(10));
        //kortin arvo nyt nolla, seuraavan sentin otto = false
        assertEquals(false,kortti.otaRahaa(1));
    }
    
}
