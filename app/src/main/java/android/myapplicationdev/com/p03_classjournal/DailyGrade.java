package android.myapplicationdev.com.p03_classjournal;

import java.io.Serializable;

/**
 * Created by 15017484 on 2/5/2017.
 */

public class DailyGrade implements Serializable {
    private int week;
    private String grade;

    public int getWeek() {
        return week;
    }

    public void setWeek(int week) {
        this.week = week;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public DailyGrade(int week, String grade) {
        this.week = week;
        this.grade = grade;
    }
}
