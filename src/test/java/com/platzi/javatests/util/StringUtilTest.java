package com.platzi.javatests.util;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class StringUtilTest {

    @Test
    public void repeatStringOne(){
        Assert.assertEquals("hola", StringUtil.repeat("hola", 1));
    }

    @Test
    public void repeatStringMultipleTimes(){
        Assert.assertEquals("holaholahola", StringUtil.repeat("hola", 3));
    }

    @Test
    public void repeatStringZeroTimes(){
        Assert.assertEquals("", StringUtil.repeat("hola", 0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void repeatStringNegativeTimes(){
       StringUtil.repeat("hola", -1);
    }

    @Test
    public void noEmptyString() {
        Assert.assertFalse(StringUtil.isEmpty("value"));
    }

    @Test
    public void isEmptyString() {
        Assert.assertTrue(StringUtil.isEmpty(""));
    }

    @Test
    public void noEmptyStringWithSpace() {
        Assert.assertFalse(StringUtil.isEmpty(" value "));
    }
    @Test
    public void nullString() {
        Assert.assertTrue(StringUtil.isEmpty(null));
    }
}