package ru.maximov.refactoring

import org.junit.jupiter.api.Assertions.assertTrue

class StatementAssertion(private val statement:String) {
    fun forCustomer(customer: Customer) : StatementAssertion {
        assertTrue(statement.contains("Учёт аренды для ${customer.name}"))
        return this
    }

    fun hasAmountForMovie(movie: Movie, amount: Double) : StatementAssertion {
        assertTrue(statement.contains("\t ${movie.title} \t $amount"))
        return this
    }

    fun withTotalAmount(totalAmount: Double) : StatementAssertion {
        assertTrue(statement.contains("Сумма задолженности составляет $totalAmount"))
        return this
    }

    fun custumerGotFrequentRenterPoints(frequentRenterPoints: Int) : StatementAssertion {
        assertTrue(statement.contains("Вы заработали $frequentRenterPoints очков за активность"))
        return this
    }
}