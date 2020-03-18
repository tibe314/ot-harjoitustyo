package com.mycompany.unicafe;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class KassapaateTest {

    Kassapaate kassa;

    @Before
    public void setUp() {
        kassa = new Kassapaate();
    }

    @Test
    public void kassanLuontiOnnistuu() {
        assertTrue(kassa != null);
        assertEquals(0, kassa.edullisiaLounaitaMyyty() + kassa.maukkaitaLounaitaMyyty());
        assertEquals(100000, kassa.kassassaRahaa());
    }

    @Test
    public void edullisenOstoOnnistuu() {
        kassa.syoEdullisesti(0);
        assertEquals(0, kassa.edullisiaLounaitaMyyty());
        assertEquals(100000, kassa.kassassaRahaa());
        
        int vaihtoraha = kassa.syoEdullisesti(1000);
        assertEquals(1, kassa.edullisiaLounaitaMyyty());
        assertEquals(100240, kassa.kassassaRahaa());
        assertEquals(760, vaihtoraha);
        
    }
    
    @Test
    public void maukkaanOstoOnnistuu() {
        kassa.syoMaukkaasti(0);
        assertEquals(0, kassa.maukkaitaLounaitaMyyty());
        assertEquals(100000, kassa.kassassaRahaa());
        
        int vaihtoraha = kassa.syoMaukkaasti(1000);
        assertEquals(1, kassa.maukkaitaLounaitaMyyty());
        assertEquals(100400, kassa.kassassaRahaa());
        assertEquals(600, vaihtoraha);
    }
    
    @Test
    public void edullinenKorttiTesti() {
        Maksukortti kortti = new Maksukortti(1000);
        assertTrue(kassa.syoEdullisesti(kortti));
        assertEquals(1, kassa.edullisiaLounaitaMyyty());
        
        Maksukortti tyhjakortti = new Maksukortti(0);
        assertTrue(!kassa.syoEdullisesti(tyhjakortti));
        assertEquals(1, kassa.edullisiaLounaitaMyyty());
    }
    
    @Test
    public void maukasKorttiTesti() {
        Maksukortti kortti = new Maksukortti(1000);
        assertTrue(kassa.syoMaukkaasti(kortti));
        assertEquals(1, kassa.maukkaitaLounaitaMyyty());
        
        Maksukortti tyhjakortti = new Maksukortti(0);
        assertTrue(!kassa.syoMaukkaasti(tyhjakortti));
        assertEquals(1, kassa.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void kortinLatausTesti() {
        Maksukortti kortti = new Maksukortti(0);
        kassa.lataaRahaaKortille(kortti, 100);
        assertEquals(100100, kassa.kassassaRahaa());
        assertEquals(100, kortti.saldo());
        
        kassa.lataaRahaaKortille(kortti, -100);
        assertEquals(100100, kassa.kassassaRahaa());
        assertEquals(100, kortti.saldo());
    }
}
