package android.myapplicationdev.com.p03_classjournal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by 15039836 on 2/5/2017.
 */

public class rowForModuleAdapter extends ArrayAdapter<rowForModule> {

    private Context context;
    private ArrayList<rowForModule> module;
    private TextView tvCode, tvName;

    public rowForModuleAdapter(Context context, int resource, ArrayList<rowForModule> objects){
        super(context, resource, objects);
        module = objects;
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // The usual way to get the LayoutInflater object to
        //  "inflate" the XML file into a View object
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        // "Inflate" the row.xml as the layout for the View object
        View rowView = inflater.inflate(R.layout.row_for_module, parent, false);

        // Get the TextView object
        tvCode = (TextView) rowView.findViewById(R.id.textViewCode);
        tvName = (TextView) rowView.findViewById(R.id.textViewName);

        rowForModule currentModule = module.get(position);

        tvCode.setText(currentModule.getModuleCode());
        tvName.setText(currentModule.getModuleName());

        // Return the nicely done up View to the ListView
        return rowView;
    }


}
