package at.fh.valuvi.resifo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import at.fh.valuvi.resifo.models.Entry;
import at.fh.valuvi.resifo.components.CustomAdapter;

/**
 * Created by Lukas Schneider on 04.02.2017.
 */

public class FindRecordActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    private List<Entry> listEntries;
    private ListView myListView;
    private CustomAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.find_record);

        Entry entry1 = new Entry();
        Entry entry2 = new Entry();
        Entry entry3 = new Entry();

        entry1.userDate = new Date();
        entry1.r_street = "test";

        entry2.userDate = new Date();
        entry2.r_street = "test";

        entry3.userDate = new Date();
        entry3.r_street = "test";


        listEntries = new ArrayList<Entry>();
        listEntries.add(entry1);
        listEntries.add(entry2);
        listEntries.add(entry3);

        myListView = (ListView) findViewById(R.id.entryList);

        myAdapter = new CustomAdapter(this, listEntries);

        myListView.setAdapter(myAdapter);

        myListView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Entry selectedEntry = listEntries.get(i);
        Intent intent = new Intent(view.getContext(),OverviewActivity.class);
        intent.putExtra("Entry",selectedEntry);
        startActivity(intent);
    }

    public void backFR (View view){
        Intent intent = new Intent(this, ChooseRecordActivity.class);
        startActivity(intent);
    }

    public void search (){
    }
}
