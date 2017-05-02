package android.myapplicationdev.com.p03_classjournal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {
    ListView lv;
    ArrayAdapter aa;
    ArrayList<DailyGrade> gradeList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent i = getIntent();
        String title = i.getStringExtra("moduleCode");
        setTitle("Info for "+title);
        lv = (ListView)findViewById(R.id.lvGrades);
        gradeList = new ArrayList<DailyGrade>();
        gradeList.add(new DailyGrade(1, "B"));
        gradeList.add(new DailyGrade(2, "C"));
        gradeList.add(new DailyGrade(3, "A"));
        aa = new DailyGradeAdapter(this, R.layout.row, gradeList);
        lv.setAdapter(aa);



    }
}
