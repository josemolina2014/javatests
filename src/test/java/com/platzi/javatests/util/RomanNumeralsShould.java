package com.platzi.javatests.util;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class RomanNumeralsShould {
    @Test
    public void arabicToRomanLeesThan10() {
        assertThat(RomanNumerals.arabicToRomanRecursive(1), is("I"));
        assertThat(RomanNumerals.arabicToRomanRecursive(2), is("II"));
        assertThat(RomanNumerals.arabicToRomanRecursive(4), is("IV"));
        assertThat(RomanNumerals.arabicToRomanRecursive(5), is("V"));
        assertThat(RomanNumerals.arabicToRomanRecursive(7), is("VII"));
        assertThat(RomanNumerals.arabicToRomanRecursive(9),  is( "IX"));
        ;
    }
    @Test
    public void arabicToRomanGreaterThan10() {
        assertThat(RomanNumerals.arabicToRomanRecursive(10),  is( "X"));
        assertThat(RomanNumerals.arabicToRomanRecursive(11),  is( "XI"));
        assertThat(RomanNumerals.arabicToRomanRecursive(15),  is( "XV"));
    }

    @Test
    public void arabicToRomanLessThan50() {
        assertThat(RomanNumerals.arabicToRomanRecursive(24),  is( "XXIV"));
        assertThat(RomanNumerals.arabicToRomanRecursive(25),  is( "XXV"));
        assertThat(RomanNumerals.arabicToRomanRecursive(40),  is( "XL"));
        assertThat(RomanNumerals.arabicToRomanRecursive(49),  is( "XLIX"));
    }

    @Test
    public void arabicToRomanGreaterThan50() {
        assertThat(RomanNumerals.arabicToRomanRecursive(50),  is( "L"));
        assertThat(RomanNumerals.arabicToRomanRecursive(51),  is( "LI"));
        assertThat(RomanNumerals.arabicToRomanRecursive(55),  is( "LV"));
        assertThat(RomanNumerals.arabicToRomanRecursive(56),  is( "LVI"));
        assertThat(RomanNumerals.arabicToRomanRecursive(60),  is( "LX"));
        assertThat(RomanNumerals.arabicToRomanRecursive(70),  is( "LXX"));
        assertThat(RomanNumerals.arabicToRomanRecursive(80),  is( "LXXX"));
        assertThat(RomanNumerals.arabicToRomanRecursive(81),  is( "LXXXI"));
        assertThat(RomanNumerals.arabicToRomanRecursive(85),  is( "LXXXV"));
        assertThat(RomanNumerals.arabicToRomanRecursive(86),  is( "LXXXVI"));
    }

    @Test
    public void arabicToRomanGreaterThan100() {
        assertThat(RomanNumerals.arabicToRomanRecursive(126),  is( "CXXVI"));
        assertThat(RomanNumerals.arabicToRomanRecursive(556),  is( "DLVI"));
        assertThat(RomanNumerals.arabicToRomanRecursive(400),  is( "CD"));
        assertThat(RomanNumerals.arabicToRomanRecursive(900),  is( "CM"));
    }

    @Test
    public void arabicToRomanGreaterThan1000() {
        assertThat(RomanNumerals.arabicToRomanRecursive(2507),  is( "MMDVII"));
        assertThat(RomanNumerals.arabicToRomanRecursive(3999),  is( "MMMCMXCIX"));
    }

//    @Test
//    public void arabicToRomanFor() {
////        assertEquals("", RomanNumerals.arabicToRomanFor(4000));
////        assertEquals("", RomanNumerals.arabicToRomanFor(3));
////        assertEquals("", RomanNumerals.arabicToRomanRecursive(1));
////        assertEquals("", RomanNumerals.arabicToRomanRecursive(10));
////        assertEquals("", RomanNumerals.arabicToRomanRecursive(5));
////        assertEquals("", RomanNumerals.arabicToRomanRecursive(9));
////        assertEquals("", RomanNumerals.arabicToRomanRecursive(15));
//        assertEquals("", RomanNumerals.arabicToRomanRecursive(900));
////        assertEquals("", RomanNumerals.arabicToRomanRecursive(125));
////        assertEquals("", RomanNumerals.arabicToRomanRecursive(1000));
////        assertEquals("", RomanNumerals.arabicToRomanRecursive(1123));
//
//    }
}