package com.tw.bootcamp.stringcalculator;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.core.IsEqual;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

//TODO: Difference between hamcrest and junit
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


public class StringCalculatorTest {

    private StringCalculator calculator;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void setUp() {
        calculator = new StringCalculator();

    }

    @Test
    public void should_get_sum_of_zero_number() {
        assertThat(calculator.add(""), is(0));
    }

    @Test
    public void should_get_sum_of_one_number() {
        assertThat(calculator.add("1"), is(1));
    }

    @Test
    public void should_get_sum_of_two_numbers() {
        assertThat(calculator.add("1,2"), is(3));
    }

    @Test
    public void should_get_sum_of_multiple_numbers() {
        assertThat(calculator.add("2,3,5"), is(10));
    }

    @Test
    public void should_get_right_sum_if_number_is_splitted_by_new_line_sign() {
        assertThat(calculator.add("2,3,5\n6"), is(16));
    }

    @Test(expected = StringInvalidFormat.class)
    public void should_not_get_sum_if_the_string_is_not_splitted_in_right_format() {
        calculator.add("2,3,\n");
    }

    @Test
    public void should_get_sum_if_the_delimiter_is_specified_at_the_beginning_of_string() {
        assertThat(calculator.add("//;\n2;3"), is(5));
    }

    @Test(expected = StringInvalidFormat.class)
    public void should_throw_exception_when_ther_is_negative_number() {
        calculator.add("2,-3");
    }

    @Test
    public void should_list_all_negative_number_in_exception_when_ther_are_negative_numbers() {
        thrown.expect(IsEqual.equalTo(new StringInvalidFormat()));

        calculator.add("-3,5,-4");
    }
}
