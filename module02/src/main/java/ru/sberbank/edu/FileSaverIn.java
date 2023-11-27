package ru.sberbank.edu;

import java.io.FileNotFoundException;

public interface FileSaverIn {
    String save( StaticsDataFiles FilesData ) throws FileNotFoundException;
}
