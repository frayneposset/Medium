package pn.medium.conversion;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class PersonRepository {

    public List<Person> findAll() {
        var person = new Person();
        person.setId("1");
        person.setFirstName("Fred");
        person.setSecondName("Jones");
        return List.of(person);
    }

    public Optional<Person> findPersonById(String id) {
        return findAll().stream().filter(person-> Objects.equals(person.getId(), id)).findFirst();
    }

    public List<Person> findDaves() {

        var daves = new ArrayList<Person>();
        var dave = new Person();
        dave.setId("2");
        dave.setFirstName("Dave");
        dave.setLastName("Jones");
        daves.add(dave);

        var dave2 = new Person();
        dave2.setId("3");
        dave2.setFirstName("Dave");
        dave2.setLastName("Smith");
        daves.add(dave2);
        return daves;
    }
}
