package ru.netology


fun main() {
    println(commission(masterCard, 0, 1000))
    println(commission(visa, 0, 1000))
    println(commission(vkPay, 0, 1000))
}

const val masterCard = "Mastercard"
const val maestro = "Maestro"
const val visa = "VISA"
const val mir = "Мир"
const val vkPay = "VK Pay"
val comissionVisa = 35

fun commission(
    typeCard: String = "VKpay",
    sumTransferInMonth: Int = 0,
    sumMoneyTransfer: Int
): Any {
    return when (typeCard) {
        masterCard, maestro ->
            if (sumTransferInMonth in 300..74999) {
                sumMoneyTransfer.toDouble() * 1
            } else if (sumTransferInMonth > 600000) {
                println("Вы достигли максимального лимита в месяц")
            } else {
                sumMoneyTransfer * 0.994 - 20
            }
        visa, mir ->
            if (sumMoneyTransfer * 0.0075 > comissionVisa) {
                sumMoneyTransfer.toDouble() * 0.9925
            } else if (sumMoneyTransfer <= comissionVisa) {
                println("Минимальный платеж 35 рублей по карте Visa и Мир")
            } else if (sumTransferInMonth > 600000) {
                println("Вы достигли максимального лимита в месяц")
            } else {
                (sumMoneyTransfer - 35)
            }
        vkPay ->
            if (sumMoneyTransfer in 1..15000) {
                sumMoneyTransfer.toDouble() * 1
            } else if (sumTransferInMonth > 40000) {
                println("Вы достигли максимального лимита в месяц")
            } else {
                println("Вы достигли максимального лимита в месяц")
            }
        else -> println("")
    }
}




