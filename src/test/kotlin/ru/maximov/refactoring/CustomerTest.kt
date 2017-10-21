package ru.maximov.refactoring

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import ru.maximov.refactoring.Movie.Companion.CHILDRENS
import ru.maximov.refactoring.Movie.Companion.NEW_RELEASE
import ru.maximov.refactoring.Movie.Companion.REGULAR

internal class CustomerTest {
    @Test
    fun addRental() {
        val customer = Customer("John Dou")
        val movie = Movie("La La Land", REGULAR)
        val rental = Rental(movie, 7)

        customer.addRental(rental)

        assertEquals(1, customer.rentals.size)
        assertEquals(rental, customer.rentals.elementAt(0))
    }

    @Test
    fun statementWithOneNewRelease() {
        val customer = Customer("John Dou")
        val movie = Movie("Blade Runner 2049", NEW_RELEASE)
        val rental = Rental(movie, 7)
        customer.addRental(rental)

        val statement = customer.statement()

        assertThatIn(statement)
                .forCustomer(customer)
                .hasAmountForMovie(movie, 21.0)
                .withTotalAmount(21.0)
                .custumerGotFrequentRenterPoints(2)
    }

    @Test
    fun statementWithOneRegularReleaseForLessThanTwoDays() {
        val customer = Customer("John Dou")
        val movie = Movie("Pulp Fiction", REGULAR)
        val rental = Rental(movie, 1)
        customer.addRental(rental)

        val statement = customer.statement()

        assertThatIn(statement)
                .forCustomer(customer)
                .hasAmountForMovie(movie, 2.0)
                .withTotalAmount(2.0)
                .custumerGotFrequentRenterPoints(1)
    }

    @Test
    fun statementWithOneRegularReleaseForMoreThanTwoDays() {
        val customer = Customer("John Dou")
        val movie = Movie("Sin City", REGULAR)
        val rental = Rental(movie, 3)
        customer.addRental(rental)

        val statement = customer.statement()

        assertThatIn(statement)
                .forCustomer(customer)
                .hasAmountForMovie(movie, 3.5)
                .withTotalAmount(3.5)
                .custumerGotFrequentRenterPoints(1)
    }

    @Test
    fun statementWithOneChildrenReleaseForLessThanThreeDays() {
        val customer = Customer("John Dou")
        val movie = Movie("Inside Out", CHILDRENS)
        val rental = Rental(movie, 2)
        customer.addRental(rental)

        val statement = customer.statement()

        assertThatIn(statement)
                .forCustomer(customer)
                .hasAmountForMovie(movie, 1.5)
                .withTotalAmount(1.5)
                .custumerGotFrequentRenterPoints(1)
    }

    @Test
    fun statementWithOneChildrenReleaseForMoreThanThreeDays() {
        val customer = Customer("John Dou")
        val movie = Movie("Gravity Falls", CHILDRENS)
        val rental = Rental(movie, 4)
        customer.addRental(rental)

        val statement = customer.statement()

        assertThatIn(statement)
                .forCustomer(customer)
                .hasAmountForMovie(movie, 3.0)
                .withTotalAmount(3.0)
                .custumerGotFrequentRenterPoints(1)
    }

    @Test
    fun statementWithOneChildrenReleaseForMoreThanThreeDaysAndOneNewRelease() {
        val customer = Customer("John Dou")
        val movie1 = Movie("Spider-Man", CHILDRENS)
        val movie2 = Movie("It", NEW_RELEASE)
        val rental1 = Rental(movie1, 4)
        val rental2 = Rental(movie2, 1)
        customer.addRental(rental1)
        customer.addRental(rental2)

        val statement = customer.statement()

        assertThatIn(statement)
                .forCustomer(customer)
                .hasAmountForMovie(movie1, 3.0)
                .hasAmountForMovie(movie2, 3.0)
                .withTotalAmount(6.0)
                .custumerGotFrequentRenterPoints(2)
    }

    private fun assertThatIn(statement: String) : StatementAssertion {
        return StatementAssertion(statement)
    }

}