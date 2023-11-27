package ru.sberbank.edu;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoSettings;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @Mock
    private Person person;
    private Person personTwo;
    private Person personThree;

    @BeforeEach
    void  setUp() {
        this.person = new Person("Alhadin", "Moscow", 37);
        this.personTwo = new Person("Alhadin", "Moscow", 37);
        this.personThree = new Person("Muhamed", "Moscow", 15);
    }

    @Test
    void testPersonHashCode() {
        Assertions.assertThat(person.hashCode()).isEqualTo(personTwo.hashCode()).isNotEqualTo(personThree.hashCode());

    }
    @Test
    public void testPersonCompare() {
        Assertions.assertThat(person.equals(personTwo)).isNotEqualTo(personThree.equals(personTwo));
    }

}