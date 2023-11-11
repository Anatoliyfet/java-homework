package ru.sberbank.edu;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CustomDigitComparatorTest {
    @Mock
    private CustomDigitComparator digitComparator = new CustomDigitComparator();
    private List<Integer> list = new ArrayList<>();
    private List<Integer> listSecond = new ArrayList<>();
    @BeforeEach
    void setUp(){

        list.add(5);
        list.add(4);
        list.add(3);
        list.add(10);
        list.add(2);
        list.add(1);

        listSecond.add(5);
        listSecond.add(4);
        listSecond.add(3);
        listSecond.add(10);
        listSecond.add(2);
        listSecond.add(1);
    }

    @Test
    void compareTest() {
        list.sort(digitComparator);
        listSecond.sort(digitComparator);
        Assertions.assertThat(list).isEqualTo(listSecond);
    }
}