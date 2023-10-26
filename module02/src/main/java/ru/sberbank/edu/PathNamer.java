package ru.sberbank.edu;

import java.io.File;

public class PathNamer implements Path {
    /**
     *
     * @param name
     * @return путь до файла с его названием на конце
     */
    @Override
    public String getPath(String name) {
        String separator = File.separator;
        String mainPath = System.getProperty("user.dir");
        String path = mainPath + separator + "module02" + separator + "src" + separator + "main" + separator +
                "java" + separator + "files" + separator + name;
        //"files" + separator +
        return path;

    }
}
