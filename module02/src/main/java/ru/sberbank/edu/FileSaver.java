package ru.sberbank.edu;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * Save statistics in folder files
 */
public class FileSaver implements FileSaverIn {
    @Override
    public String save(StaticsDataFiles FilesData) {

        if (FilesData == null) {
            return "Constructor is null";
        }
        File file = new File(new PathNamer().getPath("fileSaverData.txt"));
//         pw = null;
//        PrintWriter pw;

        try(PrintWriter pw = new PrintWriter(file)) {
            pw.println("LineCount = " + FilesData.getLineCount());
            pw.println("SpaceCount = " + FilesData.getSpaceCount());
            pw.println("LongestLine = " + FilesData.getLongestLine());
            pw.close();
            return "File SaveFileData was created";
        } catch (FileNotFoundException e) {
            return "File SaveFileData was NOT created";
        }


    }


}
