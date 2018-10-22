package com.delivery.chaze.chazedelivery;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.Toast;

import com.delivery.chaze.chazedelivery.Adapters.CustomExpandableListAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class OrderActivity extends AppCompatActivity {
    ExpandableListView expandableListView;
    CustomExpandableListAdapter expandableListAdapter;
    List<String> expandableListTitle;
    HashMap<String, List<String>> expandableListDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        expandableListView=(ExpandableListView) findViewById(R.id.expandableListView);
        addItems();
        expandableListTitle=new ArrayList<String>(expandableListDetail.keySet());
        expandableListAdapter=new CustomExpandableListAdapter(this,expandableListTitle,expandableListDetail);
        expandableListView.setAdapter(expandableListAdapter);
        //expandableListView.expandGroup(0);
        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int i) {
                Toast.makeText(getApplicationContext(),expandableListTitle.get(i)+"List EXpanded.",Toast.LENGTH_SHORT).show();

            }
        });
        expandableListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {
            @Override
            public void onGroupCollapse(int i) {
                Toast.makeText(getApplicationContext(),expandableListTitle.get(i)+"List collapsed.",Toast.LENGTH_SHORT).show();
            }
        });
        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i1, long l) {
                Toast.makeText(getApplicationContext(),
                        expandableListTitle.get(i)
                                + " -> "
                                + expandableListDetail.get(
                                expandableListTitle.get(i)).get(
                                i1), Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }

    private void addItems() {
        expandableListDetail= new HashMap<>();
        List<String> shop1=new ArrayList<String>();
        shop1.add("item1");
        shop1.add("item2");
        shop1.add("item3");
        shop1.add("item4");
        shop1.add("item5");

        List<String> shop2=new ArrayList<String>();
        shop2.add("item5");
        shop2.add("item1");
        shop2.add("item2");
        shop2.add("item3");
        shop2.add("item4");

        List<String> shop3=new ArrayList<String>();
        shop3.add("item1");
        shop3.add("item5");
        shop3.add("item2");
        shop3.add("item3");
        shop3.add("item4");

        List<String> shop4=new ArrayList<String>();
        shop4.add("item1");
        shop4.add("item2");
        shop4.add("item5");
        shop4.add("item3");
        shop4.add("item4");

        expandableListDetail.put("shop1",shop1);
        expandableListDetail.put("shop2",shop2);
        expandableListDetail.put("shop3",shop3);
        expandableListDetail.put("shop4",shop4);

        expandableListTitle=new ArrayList<>();
        expandableListTitle.add("shop1");
        expandableListTitle.add("shop2");
        expandableListTitle.add("shop3");
        expandableListTitle.add("shop4");
    }
}
