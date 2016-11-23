package at.fh.swengb.javalist.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import at.fh.swengb.javalist.R;

/**
 * Created by Lukas Schneider on 23.11.2016.
 */

public class CustomAdapter extends android.widget.BaseAdapter {
    List<JavaMethod> listMeth;
    Context context;
    LayoutInflater inflter;

    public CustomAdapter(Context applicationContext, List<JavaMethod> listMeth) {
        this.context = applicationContext;
        this.listMeth= listMeth;
        inflter = (LayoutInflater.from(applicationContext));
    }

    @Override
    public int getCount() {
        return listMeth.size();
    }

    @Override
    public Object getItem(int i) {
        return listMeth.get(i);
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
        TextView viewMethName=(TextView)view.findViewById(R.id.textViewListName);
        TextView viewDescription=(TextView)view.findViewById(R.id.textViewDesc);
        TextView viewCreator=(TextView)view.findViewById(R.id.textViewCrea);

        JavaMethod meth = listMeth.get(i);
        viewMethName.setText(meth.getNameMethod());
        viewDescription.setText(meth.getDescription());
        viewCreator.setText(meth.getCreator());

        return view;
    }
}
