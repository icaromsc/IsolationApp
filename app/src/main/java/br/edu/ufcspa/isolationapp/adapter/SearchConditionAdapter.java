package br.edu.ufcspa.isolationapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import br.edu.ufcspa.isolationapp.Model.Condicao;
import br.edu.ufcspa.isolationapp.R;

/**
 * Created by icaromsc on 10/06/2017.
 */

public class SearchConditionAdapter extends BaseAdapter {

    private final List<Condicao> conds;
    private Context context;
    private static LayoutInflater inflater=null;

    public SearchConditionAdapter(List<Condicao> recs, Context ctx) {
        this.conds = recs;
        this.context= ctx;
        inflater = (LayoutInflater)context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }



    @Override
    public int getCount() {
        return conds.size();
    }

    @Override
    public Object getItem(int position) {
        return conds.get(position);
    }

    @Override
    public long getItemId(int position) {
        return conds.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        view =inflater.inflate(R.layout.condition_item, parent, false);
        Condicao condicao = conds.get(position);
        TextView nomeCondicao = (TextView)
                view.findViewById(R.id.txCondition);
        TextView tipo = (TextView)
                view.findViewById(R.id.txType);

        nomeCondicao.setText(condicao.getNomeCondicao());
        tipo.setText(condicao.getTipo());
        return view;
    }



}
