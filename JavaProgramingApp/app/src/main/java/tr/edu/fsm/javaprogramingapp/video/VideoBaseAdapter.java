package tr.edu.fsm.javaprogramingapp.video;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

import tr.edu.fsm.javaprogramingapp.R;
import tr.edu.fsm.javaprogramingapp.konu.Konu;

/**
 * Created by sema on 16.4.2017.
 */

public class VideoBaseAdapter extends BaseAdapter {

    List<Video> list;
    Context context;
    public VideoBaseAdapter(Context context) {
        list = new ArrayList<>();
        this.context = context;
    }

    public void add(Video k){
        list.add(k);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Video getItem(int i) {
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
