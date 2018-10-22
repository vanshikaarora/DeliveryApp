package com.delivery.chaze.chazedelivery;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.delivery.chaze.chazedelivery.Adapters.OrderAdapter;
import com.delivery.chaze.chazedelivery.models.Orders;

import java.util.ArrayList;

import butterknife.BindView;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.orderRecyclerView)
    RecyclerView recyclerView;
    OrderAdapter adapter;
    ArrayList <Orders> ordersList;
    LinearLayoutManager linearLayoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setTool
        //setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        ordersList=new ArrayList<>();
        linearLayoutManager=new LinearLayoutManager(getApplication(),LinearLayoutManager.VERTICAL,false);
        adapter=new OrderAdapter(getApplicationContext(),ordersList);
        adapter.addItems();
        recyclerView=findViewById(R.id.orderRecyclerView);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(linearLayoutManager);
    }
}
