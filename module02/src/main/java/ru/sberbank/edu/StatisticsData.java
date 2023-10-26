package ru.sberbank.edu;

/**
 * класс для сбора статистики
 * от него наследуемся для сбора статистики
 * и последующего сохранения в разные места
 *
 */
public abstract class StatisticsData {
    private int lineCount;
    private int spaceCount;
    private String longestLine;


    /**
     * @return
     */
    public int getLineCount() {
        return lineCount;
    }

    /**
     * @param lineCount
     */
    public void setLineCount(int lineCount) {
        this.lineCount = lineCount;
    }

    /**
     * @param spaceCount
     */
    public void setSpaceCount(int spaceCount) {
        this.spaceCount = spaceCount;
    }

    /**
     * @param longestLine
     */
    public void setLongestLine(String longestLine) {
        this.longestLine = longestLine;
    }


    /**
     * @return
     */
    public int getSpaceCount() {
        return spaceCount;
    }


    /**
     * @return
     */
    public String getLongestLine() {
        return longestLine;
    }

    /**
     * @param lineCount
     * @param spaceCount
     * @param longestLine
     */
    public StatisticsData(int lineCount, int spaceCount, String longestLine) {
        this.lineCount = lineCount;
        this.spaceCount = spaceCount;
        this.longestLine = longestLine;
    }

}
