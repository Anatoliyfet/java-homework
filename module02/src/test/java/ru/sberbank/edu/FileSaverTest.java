package ru.sberbank.edu;

import junit.framework.TestCase;
import org.assertj.core.api.Assertions;

import java.io.File;
import java.io.FileNotFoundException;

public class FileSaverTest extends TestCase {

    public void testSave()  {
        StaticsDataFiles statistics = new StaticsDataFiles(1, 2, "sd");
      FileSaver fileSaver = new FileSaver();
        Assertions.assertThat(fileSaver.save(statistics).equals("File SaveFileData was NOT created"));

    }
}