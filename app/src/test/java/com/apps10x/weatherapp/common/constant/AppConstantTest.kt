package com.apps10x.weatherapp.common.constant

import org.junit.Assert.*

import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class AppConstantTest {

    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
    }

    @Test
    fun testConstants(){
        assertNotNull(AppConstant.PATTERN_yyyy_MM_dd)
        assertNotNull(AppConstant.PATTERN_EEEE)
        assertNotNull(AppConstant.PATTEERN_yyyy_MM_dd_HH_mm_ss)
        assertNotNull(AppConstant.NUMERIC_ZERO)
        assertNotNull(AppConstant.NUMERIC_ONE)
        assertNotNull(AppConstant.NUMERIC_TWO)
        assertNotNull(AppConstant.NUMERIC_THREE)
        assertNotNull(AppConstant.NUMERIC_FOUR)
        assertNotNull(AppConstant.NO_OF_SECONDS_IN_A_DAY)
        assertNotNull(AppConstant.NUMBER_ZERO_POINT_ZERO)
        assertNotNull(AppConstant.C)
    }
}