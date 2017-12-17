package io.qameta.allure.csv;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvBindByPosition;
import io.qameta.allure.entity.TestResult;
import io.qameta.allure.entity.TestStatus;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;

/**
 * Class contains the information for the behavior csv export.
 */
public class CsvExportBehavior implements Serializable {

    @CsvBindByName(column = "Epic")
    @CsvBindByPosition(position = 0)
    private final String epic;

    @CsvBindByName(column = "Feature")
    @CsvBindByPosition(position = 1)
    private final String feature;

    @CsvBindByName(column = "Story")
    @CsvBindByPosition(position = 2)
    private final String story;

    @CsvBindByName(column = "FAILED")
    @CsvBindByPosition(position = 3)
    private long failed;

    @CsvBindByName(column = "BROKEN")
    @CsvBindByPosition(position = 4)
    private long broken;

    @CsvBindByName(column = "PASSED")
    @CsvBindByPosition(position = 5)
    private long passed;

    @CsvBindByName(column = "SKIPPED")
    @CsvBindByPosition(position = 6)
    private long skipped;

    @CsvBindByName(column = "UNKNOWN")
    @CsvBindByPosition(position = 7)
    private long unknown;

    public CsvExportBehavior(final String epic, final String feature, final String story) {
        this.epic = epic;
        this.feature = feature;
        this.story = story;
    }

    public String getEpic() {
        return epic;
    }

    public String getFeature() {
        return feature;
    }

    public String getStory() {
        return story;
    }

    public long getFailed() {
        return failed;
    }

    public long getBroken() {
        return broken;
    }

    public long getPassed() {
        return passed;
    }

    public long getSkipped() {
        return skipped;
    }

    public long getUnknown() {
        return unknown;
    }

    public boolean isPassed(final String epic, final String feature, final String story) {
        return StringUtils.equals(this.epic, epic)
                && StringUtils.equals(this.feature, feature)
                && StringUtils.equals(this.story, story);
    }

    public void addTestResult(final TestResult result) {
        if (TestStatus.FAILED.equals(result.getStatus())) {
            this.failed++;
        }
        if (TestStatus.BROKEN.equals(result.getStatus())) {
            this.broken++;
        }
        if (TestStatus.PASSED.equals(result.getStatus())) {
            this.passed++;
        }
        if (TestStatus.SKIPPED.equals(result.getStatus())) {
            this.skipped++;
        }
        if (TestStatus.UNKNOWN.equals(result.getStatus())) {
            this.unknown++;
        }
    }
}
