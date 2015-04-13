package com.json.benzibama.android.expandablelistviewexample;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ExpandableListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class MainActivity extends Activity {
    HashMap<String,List<String>> Student_info;
    List<String> Student_list;
    ExpandableListView exp_list;
    Student_Adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        exp_list= (ExpandableListView) findViewById(R.id.exp_list);
        Student_info=DataProvider.getInfo();
        Student_list=new ArrayList<String>(Student_info.keySet());
        adapter=new Student_Adapter(this,Student_info,Student_list);
        exp_list.setAdapter(adapter);
        exp_list.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPosition) {
                Toast.makeText(getBaseContext(),Student_list.get(groupPosition)+" is expanded",Toast.LENGTH_LONG).show();
            }
        });

        exp_list.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {
            @Override
            public void onGroupCollapse(int groupPosition) {
                Toast.makeText(getBaseContext(),Student_list.get(groupPosition)+" is Collapsed",Toast.LENGTH_LONG).show();

            }
        });
    }


}
