package com.json.benzibama.android.expandablelistviewexample;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListAdapter;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

/**
 * Created by bama on 4/8/2015.
 */
public class Student_Adapter  extends BaseExpandableListAdapter{
    private Context cxt;
    private HashMap<String,List<String>> Student_info;
    private List<String> Student_list;
    public Student_Adapter(Context cxt,HashMap<String,List<String>> Student_info, List<String> Student_list){
            this.cxt=cxt;
            this.Student_info=Student_info;
            this.Student_list=Student_list;

    }
    @Override
    public int getGroupCount() {
        return Student_list.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {

        return Student_info.get(Student_list.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition)
    {
        return Student_list.get(groupPosition);
    }

    @Override
    public Object getChild(int parent, int child) {
        return  Student_info.get(Student_list.get(parent)).get(child);


        //return null;
    }

    @Override
    public long getGroupId(int arg0) {
        return arg0;
    }

    @Override
    public long getChildId(int parent, int child) {
        return child;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int parent, boolean isExpanded, View convertView, ViewGroup parentView)
    {
        String group_title=(String)getGroup(parent);
        if(convertView == null)
        {
            LayoutInflater inflater=(LayoutInflater)cxt.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=inflater.inflate(R.layout.parent_layout,parentView,false);
        }
        TextView parent_textview=(TextView)convertView.findViewById(R.id.parent_text);
        parent_textview.setTypeface(null, Typeface.BOLD);
        parent_textview.setText(group_title);
        return convertView;
    }

    @Override
    public View getChildView(int parent, int child, boolean isLastChild, View convertView, ViewGroup parentview)
    {
        String child_title=(String)getChild(parent,child);
        if(convertView == null)
        {
            LayoutInflater inflater=(LayoutInflater)cxt.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=inflater.inflate(R.layout.child_layout,parentview,false);
        }
        TextView child_textview=(TextView) convertView.findViewById(R.id.child_text);
        child_textview.setText(child_title);
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
