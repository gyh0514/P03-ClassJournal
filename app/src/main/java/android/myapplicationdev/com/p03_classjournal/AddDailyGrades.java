package android.myapplicationdev.com.p03_classjournal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import static android.R.attr.data;

public class AddDailyGrades extends AppCompatActivity {

    Button btnSubmit;
    TextView tvWeeks;
    RadioGroup rg;
    RadioButton rb;

    int selectedButtonId;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_daily_grades);

        btnSubmit = (Button)findViewById(R.id.btnSubmit);
        tvWeeks = (TextView)findViewById(R.id.tvWeeks);


        // Getting (sizeOfWeeks = gradeList.size() + 1;) from SecondActivity
        Intent intentReceived = getIntent();
        String weeks = intentReceived.getStringExtra("week");
        tvWeeks.setText("Week: " + weeks);



        // Get the intent
        Intent i = getIntent();
        // Get the Hero object first activity put in Intent
        DailyGrade grade = (DailyGrade) i.getSerializableExtra("grade");

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rg =(RadioGroup)findViewById(R.id.radioGroup1);
                // Get the Id of the selected radio button in the RadioGroup
                selectedButtonId  = rg.getCheckedRadioButtonId();
                // Get the radio button object from the Id we had gotten above
                rb = (RadioButton)findViewById(selectedButtonId);
                //Toast.makeText(AddDailyGrades.this, ""+selectedButtonId, Toast.LENGTH_SHORT).show();
                // Create intent & pass in String data
                Intent i = new Intent();
                i.putExtra("grade", rb.getText().toString());
                // Set result to RESULT_OK to indicate normal response and pass in the intent containing the data
                setResult(RESULT_OK, i);
                // Call this when your activity is done and should be closed.
                finish();

            }
        });
    }

}
