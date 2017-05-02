package android.myapplicationdev.com.p03_classjournal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by 15017484 on 2/5/2017.
 */

public class DailyGradeAdapter extends ArrayAdapter<DailyGrade>{
    private Context context;
    private ArrayList<DailyGrade> grades;
    //private ArrayList<DifferentModuleDG> differentModules;
    private TextView tvGrade;
    private TextView tvWeek;


    public DailyGradeAdapter(Context context, int resource, ArrayList<DailyGrade> objects){
        super(context, resource, objects);
        grades = objects;
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // The usual way to get the LayoutInflater object to
        //  "inflate" the XML file into a View object
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        // "Inflate" the row.xml as the layout for the View object
        View rowView = inflater.inflate(R.layout.row, parent, false);

        // Get the TextView object
        tvGrade = (TextView) rowView.findViewById(R.id.textViewGrade);
        tvWeek = (TextView)rowView.findViewById(R.id.textViewWeek);



        // The parameter "position" is the index of the
        //  row ListView is requesting.
        //  We get back the food at the same index.
        DailyGrade currentWeek = grades.get(position);
        // Set the TextView to show the food

        tvGrade.setText(currentWeek.getGrade());
        tvWeek.append(" "+currentWeek.getWeek());
        return rowView;
    }
}
