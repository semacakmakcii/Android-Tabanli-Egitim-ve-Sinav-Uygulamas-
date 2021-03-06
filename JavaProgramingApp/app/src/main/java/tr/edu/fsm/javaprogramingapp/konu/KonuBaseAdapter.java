package tr.edu.fsm.javaprogramingapp.konu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import tr.edu.fsm.javaprogramingapp.R;

/**
 * Created by erol on 12.04.2017.
 */

public class KonuBaseAdapter extends BaseAdapter {

    List<Konu> list;
    Context context;
    public KonuBaseAdapter(Context context) {
        list = new ArrayList<>();
        this.context = context;
    }

    public void add(Konu k){
        list.add(k);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Konu getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }


    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.konu_item, viewGroup, false);
        TextView textView = (TextView) rowView.findViewById(R.id.konu_title);
        textView.setText(list.get(i).title);
        return rowView;
    }
}
