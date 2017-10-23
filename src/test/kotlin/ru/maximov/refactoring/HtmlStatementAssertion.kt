package ru.maximov.refactoring

import org.junit.jupiter.api.Assertions

object HtmlStatementAssertion {

    class ForCustomer(private val statement:String) {

        fun forCustomer(customer: Customer): HasAmountForMovie {
            Assertions.assertTrue(statement.contains("<H1>Операции аренды для <EM>${customer.name}</EM></H1><P>"))
            return HasAmountForMovie(statement)
        }

    }

    class HasAmountForMovie(private val statement:String) {

        fun hasAmountForMovie(movie: Movie, amount: Double): HasAmountForMovie {
            Assertions.assertTrue(statement.contains("${movie.title}: $amount<BR>"))
            return HasAmountForMovie(statement)
        }

        fun and() : WithTotalAmount{
            return WithTotalAmount(statement)
        }
    }

    class WithTotalAmount(private val statement:String) {

        fun withTotalAmount(totalAmount: Double): CustomerGotFrequentRenterPoints {
            Assertions.assertTrue(statement.contains("<P>Ваша задолженность составляет <EM>$totalAmount</EM><P>"))
            return CustomerGotFrequentRenterPoints(statement)
        }

    }

    class CustomerGotFrequentRenterPoints(private val statement:String) {

        fun customerGotFrequentRenterPoints(frequentRenterPoints: Int) {
            Assertions.assertTrue(statement.contains("На этой аренде вы заработали <EM>$frequentRenterPoints</EM> очков за активность<P>"))
        }

    }

}