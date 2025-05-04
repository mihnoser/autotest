const val ERROR_TYPE = -1
const val ERROR_LIMIT = -2

fun main() {
    println(calculateFee("Visa", 0, 10000))
    println(calculateFee("Mastercard", 80000, 10000))
    println(calculateFee("Mir", 5000, 100000))
}

fun calculateFee(cardSystem: String, lastTransfer: Int, allTransfer: Int): Any {
    if (allTransfer > 150000 || (lastTransfer + allTransfer) > 600000) return ERROR_LIMIT

    return when (cardSystem) {
        "Mastercard" -> {
            val monthLimit = 75000
            val allAboveLimit = (lastTransfer + allTransfer) - monthLimit

            if (allAboveLimit <= 0) {
                0
            } else {
                val allFee = if (monthLimit > allTransfer) {
                    allAboveLimit
                } else {
                    lastTransfer
                }
                (allFee * 0.006 + 20).toInt()
            }
        }

        "Visa" -> {
            val fee = allTransfer * 0.0075
            if (fee > 35) fee.toInt() else 35
        }

        "Mir" -> 0
        else -> ERROR_TYPE
    }
}