package com.tw.bootcamp.lengthcompare;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class LengthTest {

    @Test
    public void should_be_equal_when_one_length_is_2_other_is_2() {
        assertEquals(new Length(2, LengthUnit.CM), new Length(2, LengthUnit.CM));
    }

    @Test
    public void should_not_be_equal_when_one_length_is_2_other_is_3() {
        assertNotEquals(new Length(2, LengthUnit.CM), new Length(3, LengthUnit.CM));
    }

    @Test
    public void should_not_be_equal_when_two_length_are_same_value_and_unit() {
        assertNotEquals(new Length(2, LengthUnit.CM), new Length(2, LengthUnit.M));
    }

    @Test
    public void should_be_equal_when_the_same_length_in_different_unit() {
        assertEquals(new Length(2, LengthUnit.M), new Length(200, LengthUnit.CM));
    }
}
