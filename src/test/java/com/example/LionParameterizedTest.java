package com.example;

import org.junit.Test;
import org.junit.runners.Parameterized;
import org.junit.runner.RunWith;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

@RunWith(Parameterized.class)
public class LionParameterizedTest {

    private final String sex;
    private final Feline felineSpy;
    private final boolean isHaveMane;
    private final Class<? extends Exception> expectedException;

    public LionParameterizedTest(String sex, Feline felineSpy, boolean isHaveMane, Class<? extends Exception> expectedException ) {
        this.sex = sex;
        this.felineSpy = felineSpy;
        this.isHaveMane = isHaveMane;
        this.expectedException = expectedException;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"Самец", new Feline(), true, null},
                {"Самка", new Feline(), false, null},
                {"Сумка", new Feline(), false, IllegalArgumentException.class}
        });
    }

    @Test
    public void testDoesHaveMane() {
        if (expectedException == null){
            Lion lion = Lion.getInstance(sex, felineSpy);
            boolean result = lion.doesHaveMane();
            assertEquals(isHaveMane,result);
        } else {
            assertThrows(IllegalArgumentException.class, () -> {
                Lion.getInstance(sex,felineSpy);
            });
        }

    }

    @Test
    public void testGetFood() throws Exception {
        if (expectedException == null){
            Lion lion = Lion.getInstance(sex, felineSpy);
            List<String> result = lion.getFood();
            assertEquals(List.of("Животные","Птицы", "Рыба"), result);
        } else {
            assertThrows(IllegalArgumentException.class, () -> Lion.getInstance(sex,felineSpy));
        }
    }
}
