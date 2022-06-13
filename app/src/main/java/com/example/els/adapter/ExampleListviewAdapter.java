package com.example.els.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.els.R;
import com.example.els.models.dictionary.Definition;

import java.util.List;

public class ExampleListviewAdapter extends BaseAdapter {

    List<Definition> list;

    public ExampleListviewAdapter(List<Definition> definitionList) {
        this.list = definitionList;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        View viewDefinition;
        if(view == null) {
            viewDefinition = View.inflate(viewGroup.getContext(), R.layout.example_item, null);
        } else viewDefinition = view;


        TextView tvDefinition = (TextView) viewDefinition.findViewById(R.id.meaning);
        TextView tvExample = (TextView) viewDefinition.findViewById(R.id.example);

        //set text list view item
        Definition definition = (Definition) getItem(i);
        tvDefinition.setText(definition.getDefinition());
        tvExample.setText(definition.getExample());

        return viewDefinition;
    }
}
