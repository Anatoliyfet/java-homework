package ru.sberbank.edu;

import java.io.FileNotFoundException;

public interface Reader {
      StaticsDataFiles readFile(String nameFile) throws FileNotFoundException;
}
