package ru.sberbank.edu;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GreetingImplTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getBestHobby() {
        GreetingImpl lo_gr = new GreetingImpl();

        Assertions.assertThat(lo_gr.getBestHobby()).isEqualTo("Archeology").isNotEmpty().isNotEqualTo("Guns");
    }
}