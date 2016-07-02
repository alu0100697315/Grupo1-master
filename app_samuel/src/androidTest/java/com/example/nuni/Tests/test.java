package com.example.nuni.Tests;

import android.test.ActivityTestCase;

import com.example.nuni.ldh1.MainActivity;
import com.example.nuni.ldh1.Nfc;
import com.example.nuni.ldh1.R;

import junit.framework.Assert;

public class test extends ActivityTestCase{
    Nfc adaptador = new Nfc();
    MainActivity main = new MainActivity();

    public void testHappy(){
        Assert.assertTrue(true);
    }

    public void TestBoton(){
        assertNotNull(main.getBotonNFC());
    }

    public void testTextos(){
        assertEquals("",adaptador.findViewById(R.id.textView6).toString());
        assertEquals("Su dispositivo tiene NFC", adaptador.getCNFC());
    }
    /*
    public void testAdapter(){
        assertNotNull(adaptador.getNfc());
    }
    */
    public void testContent(){
        assertNotNull(adaptador.getContent());
    }
    public void testConteiner(){
        assertNotNull(adaptador.TestContainer());
    }
    public void TestNFC(){
        assertNotNull(Nfc.class);
    }

    public void TestPlaceholder(){
        assertNotNull(Nfc.PlaceholderFragment.class);
    }
}


