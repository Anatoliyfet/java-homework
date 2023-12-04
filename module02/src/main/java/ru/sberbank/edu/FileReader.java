package ru.sberbank.edu;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReader implements Reader {

    /**
     * получаем пробелы
     * лень было и времени нет на каждый параметр писать отдельный метод
     *
     * @param strings
     * @return
     */
    private int getSpaceCount(String[] strings) {
        int spaceCount = 0;
        for (String ignored : strings) {
            spaceCount++;
        }
        spaceCount--;
        return spaceCount;
    }

    /**
     * делаем подсчет значений для дз и воз
     *
     * @return конструктор StaticsDataFiles
     * @throws FileNotFoundException
     */
    @Override
    public StaticsDataFiles readFile(String nameFile) throws FileNotFoundException {
        String[] strings;
        int countLines = 0;
        int spaceCount = 0;
        int lenPreviosLine = 0;
        int lenNextline;

        File file = new File(new PathNamer().getPath(nameFile));
        try (Scanner scanner = new Scanner(file) ) {

            String biggestLine = null;
            while (scanner.hasNextLine()) {
                countLines++;
                String currentString = scanner.nextLine();
                strings = currentString.split(" ");
                spaceCount = spaceCount + getSpaceCount(strings);

                lenNextline = currentString.length();
                biggestLine = getString(lenPreviosLine, lenNextline, biggestLine, currentString);
                lenPreviosLine = currentString.length();

            }

            StaticsDataFiles statistic = new StaticsDataFiles(countLines, spaceCount, biggestLine);
            scanner.close();

            return statistic;
        }

    }

    private String getString(int lenPreviosLine, int lenNextline, String biggestLine, String currentString) {
        if (lenPreviosLine < lenNextline) {
            biggestLine = currentString;
        }
        return biggestLine;
    }
}
