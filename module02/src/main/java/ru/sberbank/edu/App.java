package ru.sberbank.edu;

import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Сборка статистики из файла и запись в отдельный файл
 *
 */
public class App 
{
    public static void main( String[] args ) {
        FileReader fileReader = new FileReader();
        try {
            StaticsDataFiles statistic =  fileReader.readFile("example.txt");
            FileSaver fileSaver = new FileSaver( );
//          сохраняем и выводим на экран
            System.out.println(fileSaver.save(statistic));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
