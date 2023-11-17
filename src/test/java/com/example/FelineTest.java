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
        Mockito.when(feline.getKittens()).thenReturn(3);
        int result = feline.getKittens();
        assertEquals(3, result);
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
