package pn.medium.conversion

class PersonRepository {
    fun findAll(): List<Person> = listOf(Person("1", "Fred", null, "Jones"))

    fun findPersonById(id: String): Person? {
        return findAll().firstOrNull { person: Person -> person.id == id }
    }

    fun findDaves(): List<Person> = listOf(
        Person("2", "Dave", null, "Jones"),
        Person("3", "Dave", null, "Smith"),
    )
}
