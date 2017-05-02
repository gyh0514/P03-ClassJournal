package android.myapplicationdev.com.p03_classjournal;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {
    ListView lv;
    ArrayAdapter aa;
    ArrayList<DailyGrade> gradeList;
    Button btnInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent i = getIntent();
        String title = i.getStringExtra("moduleCode");
        final String url = i.getStringExtra("url");
        setTitle("Info for "+title);
        lv = (ListView)findViewById(R.id.lvGrades);
        btnInfo = (Button)findViewById(R.id.buttonInfo);
        gradeList = new ArrayList<DailyGrade>();

        if(title.equalsIgnoreCase("C302")){
            gradeList.add(new DailyGrade(1, "B"));
            gradeList.add(new DailyGrade(2, "C"));
            gradeList.add(new DailyGrade(3, "A"));
        } else {
            gradeList.add(new DailyGrade(1, "A"));
            gradeList.add(new DailyGrade(2, "A"));
            gradeList.add(new DailyGrade(3, "A"));
        }
        

        aa = new DailyGradeAdapter(this, R.layout.row, gradeList);
        lv.setAdapter(aa);

        btnInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // Intent to display data
                Intent rpIntent = new Intent(Intent.ACTION_VIEW);
                // Set the URL to be used.
                rpIntent.setData(Uri.parse(url));
                startActivity(rpIntent);
            }
        });


    }
}
