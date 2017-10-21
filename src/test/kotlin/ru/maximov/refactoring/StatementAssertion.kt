package ru.maximov.refactoring

import org.junit.jupiter.api.Assertions.assertTrue

object StatementAssertion {

    class ForCustomer(private val statement:String) {

        fun forCustomer(customer: Customer): HasAmountForMovie {
            assertTrue(statement.contains("Учёт аренды для ${customer.name}"))
            return HasAmountForMovie(statement)
        }

    }

    class HasAmountForMovie(private val statement:String) {

        fun hasAmountForMovie(movie: Movie, amount: Double): HasAmountForMovie {
            assertTrue(statement.contains("\t ${movie.title} \t $amount"))
            return HasAmountForMovie(statement)
        }

        fun and() : WithTotalAmount{
            return WithTotalAmount(statement)
        }
    }

    class WithTotalAmount(private val statement:String) {

        fun withTotalAmount(totalAmount: Double): CustomerGotFrequentRenterPoints {
            assertTrue(statement.contains("Сумма задолженности составляет $totalAmount"))
            return CustomerGotFrequentRenterPoints(statement)
        }

    }

    class CustomerGotFrequentRenterPoints(private val statement:String) {

        fun customerGotFrequentRenterPoints(frequentRenterPoints: Int) {
            assertTrue(statement.contains("Вы заработали $frequentRenterPoints очков за активность"))
        }

    }

}