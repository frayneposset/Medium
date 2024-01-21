package pn.medium.conversion;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PersonRepositoryTest {

     PersonRepository personRepository = new PersonRepository();

    public static List<Data> data() {
        return List.of(new Data("1",true),new Data("2",false));
    }

    @Test
    void findAll() {
        var actual = personRepository.findAll();

        var person = new Person();
        person.setId("1");
        person.setFirstName("Fred");
        person.setSecondName("Jones");
        var expected =  List.of(person);
        Assertions.assertIterableEquals(actual, expected);
    }

    @Test
    void findDaves() {
        var actual = personRepository.findDaves();
        assertEquals(actual.size(),2);
    }

    @ParameterizedTest
    @MethodSource("data")
    void findById(Data data) {
        assertEquals( personRepository.findPersonById(data.getInput()).isPresent(),data.getFound());
    }
}