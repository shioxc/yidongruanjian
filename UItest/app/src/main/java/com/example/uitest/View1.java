package com.example.uitest;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class View1 extends AppCompatActivity {

    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.view1);
        listView = (ListView) findViewById(R.id.list_view);
        int[] pho={R.drawable.lion, R.drawable.tiger,R.drawable.monkey,R.drawable.dog,R.drawable.cat,R.drawable.elephant};
        String[] name={"Lion","Tiger","Monkey","Dog","Cat","Elephant"};
        List<Map<String,Object>> mplist = new ArrayList<>();
        for(int i=0;i<6;i++)
        {
            Map<String,Object>mp= new HashMap<>();
            mp.put("pho",pho[i]);
            mp.put("name",name[i]);
            mplist.add(mp);
        }
        String[] from={"name","pho"};
        int[] to={R.id.name,R.id.img};
        SimpleAdapter adapter= new SimpleAdapter(View1.this,mplist,R.layout.list_item,from,to);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener((parent,view,position,id) -> {
            String selectedItem = name[position];
            Toast.makeText(View1.this, selectedItem, Toast.LENGTH_SHORT).show();
        });
    }
}