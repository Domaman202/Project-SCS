package ru.DmN.siberia.scs

import kotlin.test.Test

class Tests {
    @Test
    fun boolean() {
        Test("boolean").json()
    }

    @Test
    fun namedArray() {
        Test("named_array").json()
    }

    @Test
    fun namedMap() {
        Test("named_map").json()
    }

    @Test
    fun number() {
        Test("number").json()
    }

    @Test
    fun string() {
        Test("string").json()
    }

    @Test
    fun unnamedArray() {
        Test("unnamed_array").json()
    }

    @Test
    fun unnamedMap() {
        Test("unnamed_map").json()
    }
}