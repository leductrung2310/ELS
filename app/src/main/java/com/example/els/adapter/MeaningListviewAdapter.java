package com.example.els.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.els.R;
import com.example.els.models.dictionary.Definition;
import com.example.els.models.dictionary.Meaning;

import java.util.List;

public class MeaningListviewAdapter extends BaseAdapter {

    List<Meaning> list ;
    ExampleListviewAdapter adapter;

    public MeaningListviewAdapter(List<Meaning> meaningList) {
        this.list = meaningList;
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

        View viewMeaning;
        if(view == null) {
            viewMeaning = View.inflate(viewGroup.getContext(), R.layout.meaning_item, null);
        } else viewMeaning = view;

        //set text list view item
        TextView tvPartOfSpeech = (TextView) viewMeaning.findViewById(R.id.partOfSpeech);

        Meaning meaning = (Meaning) getItem(i);
        tvPartOfSpeech.setText(meaning.getPartOfSpeech());

        //set adapter example listview
        ListView lvExample = (ListView) viewMeaning.findViewById(R.id.listExamples);

        List<Definition> definitions = list.get(i).getDefinitions();
        adapter = new ExampleListviewAdapter(definitions);

        lvExample.setAdapter(adapter);

        return viewMeaning;
    }
}
