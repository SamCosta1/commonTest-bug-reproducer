package com.example

import kotlin.test.Test
import kotlin.test.assertEquals

class ExampleTest {
    @Test
    fun failingTest() {
        assertEquals("a", "b")
    }

    @Test
    fun passingTest() {
        assertEquals("a", "a")
    }
}