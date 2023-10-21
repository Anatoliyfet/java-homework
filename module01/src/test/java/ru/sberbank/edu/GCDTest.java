package ru.sberbank.edu;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GCDTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void checkTrueDivisor() {
        GCD lo_gcd = new GCD();
        int lv_maxDiv = lo_gcd.getDivisor(5,10);
        Assertions.assertThat(lv_maxDiv).isEqualTo(5);
        int lv_maxDiv2 = lo_gcd.getDivisor(5,15);
        Assertions.assertThat(lv_maxDiv).isEqualTo(5);
    }
    @Test
    void checkNotZeroDivisor() {
        GCD lo_gcd = new GCD();
        int lv_maxDiv = lo_gcd.getDivisor(5,10);
        Assertions.assertThat(lv_maxDiv).isNotZero();
    }

}