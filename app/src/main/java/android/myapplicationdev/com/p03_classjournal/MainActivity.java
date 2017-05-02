package android.myapplicationdev.com.p03_classjournal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lvModule;
    ArrayList<rowForModule> al;
    ArrayAdapter<rowForModule> aa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvModule = (ListView) findViewById(R.id.lvModule);

        al = new ArrayList<>();

        rowForModule c302 = new rowForModule("C302", "Web Services", "http://www.rp.edu.sg/Module_Synopses/C302_Web_Services.aspx");
        rowForModule c347 = new rowForModule("C347", "Android Programming II", "http://www.rp.edu.sg/Module_Synopses/C347_Android_Programming_II.aspx");

        al.add(c302);
        al.add(c347);

        aa = new rowForModuleAdapter(this, R.layout.row_for_module, al);
        lvModule.setAdapter(aa);


        lvModule.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                rowForModule currentInfo = al.get(position);
                Intent i = new Intent(MainActivity.this, SecondActivity.class);


                i.putExtra("moduleCode", currentInfo.getModuleCode());
                i.putExtra("url", currentInfo.getUrl());
                startActivity(i);

            }
        });


    }
}