package ru.sberbank.edu;

import junit.framework.TestCase;
import org.assertj.core.api.Assertions;

public class PathNamerTest extends TestCase {

    public void testGetPath() {
        PathNamer path = new PathNamer();
        String pathName = path.getPath("123.txt");
        Assertions.assertThat(path.getPath("123.txt").equals(pathName));
    }
}