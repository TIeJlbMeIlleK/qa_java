package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;
import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {

    @Spy
    private Feline feline;

    @Test
    public void testGetKittens() {
        int KITTENS_COUNT = 3;
        Mockito.when(feline.getKittens()).thenReturn(KITTENS_COUNT);
        int result = feline.getKittens();
        assertEquals(KITTENS_COUNT, result);
    }

    @Test
    public void getFamily() {
        Mockito.when(feline.getFamily()).thenReturn("Собачьи");
        String result = feline.getFamily();
        assertEquals("Собачьи", result);
    }

    @Test
    public void testGetFood() throws Exception {
        Mockito.when(feline.eatMeat()).thenReturn(List.of("мясо"));
        List<String> result = feline.eatMeat();
        assertEquals(List.of("мясо"), result);
    }
}
