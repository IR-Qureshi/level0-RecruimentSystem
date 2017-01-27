package com.example.dellpc.recruimentsystem;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by dell pc on 25-Jan-17.
 */

public class StudentAdapter extends ArrayAdapter<Student> {

    public StudentAdapter(Context context, int resource, List<Student> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
       if(convertView == null){
           convertView = ((Activity)getContext()).getLayoutInflater().inflate(R.layout.student_item,parent,false);

           TextView studentName = (TextView) convertView.findViewById(R.id.student_itemName);
           TextView studentQualify = (TextView) convertView.findViewById(R.id.student_itemQualify);
           TextView studentAge = (TextView) convertView.findViewById(R.id.student_itemAge);

           Student student = getItem(position);

           studentName.setText(student.getS_name());
           studentAge.setText(student.getS_age());
           studentQualify.setText(student.getS_Qualification());
       }
        return convertView;
    }
}
