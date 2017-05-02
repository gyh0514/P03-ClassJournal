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

import static android.R.id.message;

public class SecondActivity extends AppCompatActivity {
    ListView lv;
    ArrayAdapter aa;
    ArrayList<DailyGrade> gradeList;
    String message = "";
    Button btnInfo;
    Button btnEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent i = getIntent();
        String title = i.getStringExtra("moduleCode");
        final String url = i.getStringExtra("url");
        setTitle("Info for " + title);
        lv = (ListView) findViewById(R.id.lvGrades);
        btnInfo = (Button) findViewById(R.id.buttonInfo);
        gradeList = new ArrayList<DailyGrade>();

        if (title.equalsIgnoreCase("C302")) {
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

        btnEmail = (Button) findViewById(R.id.buttonEmail);

        btnEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                for (int num = 0; num < gradeList.size(); num++) {
                    message += "Week " + gradeList.get(num).getWeek() + ": DG: " + gradeList.get(num).getGrade() + "\n";
                }

                // The action you want this intent to do;
                // ACTION_SEND is used to indicate sending text
                Intent email = new Intent(Intent.ACTION_SEND);
                // Put essentials like email address, subject & body text
                email.putExtra(Intent.EXTRA_EMAIL,
                        new String[]{"jason_lim@rp.edu.sg"});
                email.putExtra(Intent.EXTRA_SUBJECT,
                        "Test Email from C347");
                email.putExtra(Intent.EXTRA_TEXT,
                        message);
                // This MIME type indicates email
                email.setType("message/rfc822");
                // createChooser shows user a list of app that can handle
                // this MIME type, which is, email
                startActivity(Intent.createChooser(email,
                        "Choose an Email client :"));
            }
        });
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
