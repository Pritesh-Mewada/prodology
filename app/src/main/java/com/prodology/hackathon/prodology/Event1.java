package com.prodology.hackathon.prodology;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gadhvi on 25-02-2017.
 */

public class Event1 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.event1);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        setTitle("Event-1");


        ListView lvItems = (ListView) findViewById(R.id.l1);
        ExpandableAdapter adapter = getAdapter();

        lvItems.setAdapter(adapter);
        lvItems.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ExpandableAdapter adapter = (ExpandableAdapter) parent.getAdapter();

                Item item = (Item) adapter.getItem(position);
                if (item != null) {
                    item.isExpanded = !item.isExpanded;
                }

                adapter.notifyDataSetChanged();
            }
        });
    }

    private ExpandableAdapter getAdapter() {

        List<Item> items = new ArrayList<>();

        for (int i = 0; i < 4; i++) {


            if (i == 0) {
                Item item = new Item();
                item.title="Expanding Menu-1";
                item.description = "Welocome To Prodology Hackathon";
                item.isExpanded = false;
                items.add(item);
            }
            if (i ==1 ) {
                Item item = new Item();
                item.title="Expanding Menu-2";
                item.description = "Welocome To Prodology Hackathon";
                item.isExpanded = false;
                items.add(item);
            }

        }


        return new ExpandableAdapter(this, items);


    }


    public boolean onOptionsItemSelected(MenuItem item)
    {
        finish();
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);

    }

}