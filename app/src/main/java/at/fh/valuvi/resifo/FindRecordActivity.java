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
import at.fh.valuvi.resifo.models.Entry;
import at.fh.valuvi.resifo.components.CustomAdapter;

public class FindRecordActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ListView listView;
    private CustomAdapter adapter;
    private ArrayList<Entry> listEntries = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.find_record);

        Entry[] entries = new Entry().findAll();
        for (Entry entry: entries) {
            listEntries.add(entry);
        }

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
