// SPDX-License-Identifier: GPL-3.0-or-later
package io.github.nubeliax.nuvora

import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test

class FoundationSanityTest {

    @Test
    fun deterministicSanityCheck_passes() {
        val expected = 2
        val actual = 1 + 1
        assertEquals(expected, actual)
    }

    @Test
    fun coroutinesTestSanityCheck_passes() = runTest {
        val result = suspendIdentity(42)
        assertEquals(42, result)
    }

    private suspend fun suspendIdentity(value: Int): Int = value
}
