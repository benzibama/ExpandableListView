package com.json.benzibama.android.expandablelistviewexample;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by bama on 4/8/2015.
 */
public class DataProvider {
    public static HashMap<String, List<String>> getInfo(){


        HashMap<String ,List<String>> Student_info=new HashMap<String, List<String>>();
        List<String>  Student_ID=new ArrayList<String>();
        Student_ID.add("1001");
        Student_ID.add("1002");
        Student_ID.add("1003");
        Student_ID.add("1004");
        Student_ID.add("1005");
        List<String>  Student_Name=new ArrayList<String>();
        Student_Name.add("Bama Subramanian");
        Student_Name.add("Maheshwari");
        Student_Name.add("Thiruvambihai");
        Student_Name.add("Avinash Subramanian");
        Student_Name.add("Meghana Subramanian");
        Student_info.put("Student ID",Student_ID);
        Student_info.put("Student Name",Student_Name);
        return Student_info;
    }
}
