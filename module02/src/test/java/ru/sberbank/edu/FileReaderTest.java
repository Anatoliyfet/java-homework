package ru.sberbank.edu;

import junit.framework.TestCase;
import org.assertj.core.api.Assertions;

import java.io.FileNotFoundException;

public class FileReaderTest extends TestCase {

    public void testReadFile() {
        FileReader lo_fileReader = new FileReader();
        Assertions.assertThatThrownBy(() -> lo_fileReader.readFile("abrakadabra.txt"))
            .isInstanceOf(FileNotFoundException.class);

//            .hasMessage("Discount cannot be less or equal 0");

    }
}