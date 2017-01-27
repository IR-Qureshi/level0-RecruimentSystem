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

public class CompanyAdapter extends ArrayAdapter<Company> {
    public CompanyAdapter(Context context, int resource,List<Company> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView = ((Activity) getContext()).getLayoutInflater().inflate(R.layout.comp_item, parent, false);

            TextView jobDetail = (TextView) convertView.findViewById(R.id.compJobDetail);
            TextView jobTitle = (TextView) convertView.findViewById(R.id.compJobTitle);
            TextView date = (TextView) convertView.findViewById(R.id.CompPostDate);

            Company company = getItem(position);

            jobDetail.setText(company.getJ_detail());
            jobTitle.setText(company.getJ_title());
            date.setText(company.getJ_post());
        }
        return convertView;
    }
}
