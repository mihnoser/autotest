import org.junit.Assert.assertEquals
import org.junit.Test
import kotlin.test.assertTrue

class MainKtTest {

    @Test
    fun calculateVisa() {
        val previous = 0
        val transfer = 10000
        val card = "Visa"

        val result = calculateFee(cardSystem = card, allTransfer = transfer, lastTransfer = previous)

        assertEquals(75, result)
    }

    @Test
    fun calculateVisamin() {
        val previous = 0
        val transfer = 1000
        val card = "Visa"

        val result = calculateFee(cardSystem = card, allTransfer = transfer, lastTransfer = previous)

        assertEquals(36, result)
    }

    @Test
    fun calculateMastercard() {
        val previous = 8000
        val transfer = 70000
        val card = "Mastercard"

        val result = calculateFee(cardSystem = card, allTransfer = transfer, lastTransfer = previous)

        assertEquals(38, result)
    }

    @Test
    fun calculateMastercardLessLimit() {
        val previous = 8000
        val transfer = 60000
        val card = "Mastercard"

        val result = calculateFee(cardSystem = card, allTransfer = transfer, lastTransfer = previous)

        assertEquals(0, result)
    }

    @Test
    fun calculateMastercardAllAboveLimit() {
        val previous = 10000
        val transfer = 75000
        val card = "Mastercard"

        val result = calculateFee(cardSystem = card, allTransfer = transfer, lastTransfer = previous)

        assertEquals(80, result)
    }

    @Test
    fun calculateMir() {
        val previous = 5000
        val transfer = 100000
        val card = "Mir"

        val result = calculateFee(cardSystem = card, allTransfer = transfer, lastTransfer = previous)

        assertEquals(0, result)
    }

    @Test
    fun testCard() {
        val previous = 0
        val transfer = 10000
        val card = "Maestro"

        val result = calculateFee(cardSystem = card, allTransfer = transfer, lastTransfer = previous)

        assertEquals(ERROR_TYPE, result)
    }

    @Test
    fun testLimit() {
        val previous = 0
        val transfer = 300000
        val card = "Visa"

        val result = calculateFee(cardSystem = card, allTransfer = transfer, lastTransfer = previous)

        assertEquals(ERROR_LIMIT, result)
    }

    @Test
    fun testMonthLimit() {
        val previous = 550000
        val transfer = 100000
        val card = "Visa"

        val result = calculateFee(cardSystem = card, allTransfer = transfer, lastTransfer = previous)

        assertEquals(ERROR_LIMIT, result)
    }

}
