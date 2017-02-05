package at.fh.valuvi.resifo.components;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.List;
import at.fh.valuvi.resifo.R;
import at.fh.valuvi.resifo.models.Entry;

public class CustomAdapter extends BaseAdapter {

    List<Entry> listEntries;
    Context context;
    LayoutInflater inflter;

    public CustomAdapter(Context applicationContext, List<Entry> listEntries) {
        this.context = applicationContext;
        this.listEntries = listEntries;
        inflter = (LayoutInflater.from(applicationContext));
    }

    @Override
    public int getCount() {
        return listEntries.size();
    }

    @Override
    public Object getItem(int i) {
        return listEntries.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view==null) {
            view = inflter.inflate(R.layout.row_item, null);//set layout for displaying items
        }

        TextView viewAddress=(TextView)view.findViewById(R.id.textViewAddress);
        TextView viewDate=(TextView)view.findViewById(R.id.textViewDate);

        Entry entry = listEntries.get(i);
        viewAddress.setText("test"/*entry.getAddress()*/);
        viewDate.setText("test"/*entry.getDate()*/);

        return view;
    }
}

