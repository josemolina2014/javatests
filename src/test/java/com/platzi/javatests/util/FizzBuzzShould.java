package com.platzi.javatests.util;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class FizzBuzzShould {

    @Test
    public void fizzBuzz_dividedBy3() {

        assertThat(FizzBuzz.fizzBuzz(3),is("Fizz"));
        assertThat(FizzBuzz.fizzBuzz(6),is("Fizz"));
        assertThat(FizzBuzz.fizzBuzz(93),is("Fizz"));
        assertThat(FizzBuzz.fizzBuzz(27),is("Fizz"));
    }

    @Test
    public void fizzBuzz_divided_by_5() {
        assertThat(FizzBuzz.fizzBuzz(5), is("Buzz"));
        assertThat(FizzBuzz.fizzBuzz(10), is("Buzz"));
    }

    @Test
    public void fizzBuzz_divided_by_3_and_5() {
        assertThat(FizzBuzz.fizzBuzz(15), is("FizzBuzz"));
        assertThat(FizzBuzz.fizzBuzz(30), is("FizzBuzz"));
    }

    @Test
    public void fizzBuzz_divided_others() {
        assertThat(FizzBuzz.fizzBuzz(2), is("2"));
        assertThat(FizzBuzz.fizzBuzz(16),is("16"));
    }
}