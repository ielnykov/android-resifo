package at.fh.valuvi.resifo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import at.fh.valuvi.resifo.models.Entry;
import at.fh.valuvi.resifo.components.CustomAdapter;

public class FindRecordActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private List<Entry> listEntries;
    private ListView listView;
    private CustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.find_record);

        Entry entry1 = new Entry();
        Entry entry2 = new Entry();
        Entry entry3 = new Entry();
        Entry entry4 = new Entry();
        Entry entry5 = new Entry();
        Entry entry6 = new Entry();
        Entry entry7 = new Entry();
        Entry entry8 = new Entry();
        Entry entry9 = new Entry();

        entry1.userDate = new Date();
        entry1.r_street = "Dostojewskogo";
        entry1.r_houseNumber = "22";
        entry1.r_city = "Moskau";

        entry2.userDate = new Date();
        entry2.r_street = "Herrengasse";
        entry2.r_houseNumber = "4";
        entry2.r_city = "Wien";

        entry3.userDate = new Date();
        entry3.r_street = "Karl Marks Straße";
        entry3.r_houseNumber = "1";
        entry3.r_city = "Berlin";

        entry4.userDate = new Date();
        entry4.r_street = "Dostojewskogo";
        entry4.r_houseNumber = "22";
        entry4.r_city = "Moskau";

        entry5.userDate = new Date();
        entry5.r_street = "Herrengasse";
        entry5.r_houseNumber = "4";
        entry5.r_city = "Wien";

        entry6.userDate = new Date();
        entry6.r_street = "Karl Marks Straße";
        entry6.r_houseNumber = "1";
        entry6.r_city = "Berlin";

        entry7.userDate = new Date();
        entry7.r_street = "Dostojewskogo";
        entry7.r_houseNumber = "22";
        entry7.r_city = "Moskau";

        entry8.userDate = new Date();
        entry8.r_street = "Herrengasse";
        entry8.r_houseNumber = "4";
        entry8.r_city = "Wien";

        entry9.userDate = new Date();
        entry9.r_street = "Karl Marks Straße";
        entry9.r_houseNumber = "1";
        entry9.r_city = "Berlin";


        listEntries = new ArrayList<Entry>();
        listEntries.add(entry1);
        listEntries.add(entry2);
        listEntries.add(entry3);
        listEntries.add(entry4);
        listEntries.add(entry5);
        listEntries.add(entry6);
        listEntries.add(entry7);
        listEntries.add(entry8);
        listEntries.add(entry9);

        listView = (ListView) findViewById(R.id.entryList);

        adapter = new CustomAdapter(this, listEntries);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_search, menu);
        MenuItem item = menu.findItem(R.id.menuSearch);
        SearchView searchView = (SearchView) item.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);

                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Entry selectedEntry = listEntries.get(i);
        Intent intent = new Intent(view.getContext(), OverviewCompleteRecordActivity.class);
        intent.putExtra("entry", selectedEntry);
        startActivity(intent);
    }

    public void backFR(View view) {
        Intent intent = new Intent(this, ChooseRecordActivity.class);
        startActivity(intent);
    }
}
