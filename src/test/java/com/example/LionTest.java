package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Spy
    private Feline felineSpy;

    @Test
    public void testGetKittens(){
        Mockito.when(felineSpy.getKittens()).thenReturn(3);
        Lion lion = Lion.getInstance("Самец", felineSpy);
        int result = lion.getKittens();
        assertEquals(3, result);
    }

    @Test
    public void testDoesHaveMane(){
        Lion lion = Lion.getInstance("Самец", felineSpy);
        boolean result = lion.doesHaveMane();
        assertTrue(result);
    }

    @Test
    public void testIsLion(){
        Lion lion = Lion.getInstance("Самец", felineSpy);
        boolean result = lion.doesHaveMane();
        assertTrue(result);
    }

    @Test
    public void testGetFood() throws Exception {
        Lion lion = Lion.getInstance("Самец", felineSpy);
        List<String> result = lion.getFood();
        assertEquals(List.of("Животные", "Птицы", "Рыба"), result);
    }
}
