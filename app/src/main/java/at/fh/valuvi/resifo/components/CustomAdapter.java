package at.fh.valuvi.resifo.components;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filterable;
import android.widget.TextView;
import android.widget.Filter;
import java.util.ArrayList;
import java.util.List;
import at.fh.valuvi.resifo.R;
import at.fh.valuvi.resifo.helpers.DateHelper;
import at.fh.valuvi.resifo.models.Entry;

public class CustomAdapter extends BaseAdapter implements Filterable {

    private List<Entry> entries;
    private List<Entry> searchEntries;
    private Context context;
    private LayoutInflater inflater;
    private ValueFilter valueFilter;

    public CustomAdapter(Context context, List<Entry> entries) {
        this.context = context;
        this.entries = entries;
        this.searchEntries = entries;

        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return entries.size();
    }

    @Override
    public Object getItem(int i) {
        return entries.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = inflater.inflate(R.layout.row_item, null);
        }

        TextView viewAddress = (TextView) view.findViewById(R.id.textViewAddress);
        TextView viewDate = (TextView) view.findViewById(R.id.textViewDate);

        Entry entry = entries.get(i);

        String entryAddress = entry.getRAddress();

        viewAddress.setText(entryAddress);
        viewDate.setText(DateHelper.getDisplayDate(entry.userDate));

        return view;
    }

    @Override
    public Filter getFilter() {
        if(valueFilter == null) {
            valueFilter = new ValueFilter();
        }

        return valueFilter;
    }

    private class ValueFilter extends Filter {

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            FilterResults results = new FilterResults();
            if(constraint != null && constraint.length() > 0) {
                List<Entry> filterList=new ArrayList<>();
                for(int i = 0; i < searchEntries.size(); i++) {
                    Entry entry = searchEntries.get(i);
                    if(entry.getRAddress().toLowerCase().contains(constraint.toString().toLowerCase()) ||
                       DateHelper.getDisplayDate(entry.userDate).contains(constraint.toString())) {
                        filterList.add(entry);
                    }
                }

                results.count = filterList.size();
                results.values = filterList;
            } else {
                results.count = searchEntries.size();
                results.values = searchEntries;
          }

            return results;
        }

        @SuppressWarnings("unchecked")
        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            entries = (ArrayList<Entry>) results.values;
            notifyDataSetChanged();
        }
    }


}

