package pn.medium.conversion

import io.kotest.core.spec.style.FunSpec
import io.kotest.datatest.withData
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.shouldBe

class PersonRepositoryTest : FunSpec({

    data class Data(val input: String, val found: Boolean)

    val personRepository = PersonRepository()

    test("Find all") {
        val actual = personRepository.findAll()

        val expected = listOf(Person("1", "Fred", null, "Jones"))
        actual shouldBe expected
    }

    test("Find Daves") {
        val actual = personRepository.findDaves()
        actual.shouldHaveSize(2)
    }

    context("Test finding by ID") {
        withData(Data("1", true), Data("2", false)) {
            (personRepository.findPersonById(it.input) != null) shouldBe it.found
        }
    }
}
)