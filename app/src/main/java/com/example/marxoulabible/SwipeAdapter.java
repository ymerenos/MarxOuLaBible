package com.example.marxoulabible;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class SwipeAdapter extends BaseAdapter {
    private Context mContext;
    private List<String> mItems = new ArrayList<String>();
    private StringManagement stringManagement;
    private int[] quoteTypes;
    public SwipeAdapter(Context context, int nbItems, StringManagement stringManager) {
        mContext = context;
        stringManagement = stringManager;
        quoteTypes = stringManagement.getRandomInts(nbItems);
        mItems = stringManagement.getRandomQuotes(nbItems);

    }

    @Override
    public int getCount() {
        return mItems.size();
    }

    @Override
    public Object getItem(int position) {
        return mItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;

        if (convertView == null) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview, parent, false);
            TextView quote = view.findViewById(R.id.text_view);
            quote.setText(mItems.get(position));
        } else {
            view = convertView;
        }
        return view;
    }
}
