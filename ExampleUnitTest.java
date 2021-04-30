package com.example.kryptonote;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void sampleTest1() {
        KryptoNoteActivity krypto = new KryptoNoteActivity("1234");
        System.out.println(krypto.encrypt("THIS IS A TEST"));
    }

    @Test
    public void sampleTest2() {
        KryptoNoteActivity krypto = new KryptoNoteActivity("1234");
        System.out.println(krypto.decrypt("HEYHEEE"));
    }

}
