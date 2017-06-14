package br.edu.ufcspa.isolationapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

import br.edu.ufcspa.isolationapp.Model.Epi;
import br.edu.ufcspa.isolationapp.R;

/**
 * Created by icaromsc on 14/06/2017.
 */

public class EpiAdapter extends BaseExpandableListAdapter{



    private Context _context;
    private List<String> _listDataHeader; // header titles
    private final List<Epi> epis;
    // child data in format of header title, child title
    private HashMap<String, List<String>> _listDataChild;

    public EpiAdapter(Context context, List<Epi> eps) {
        this._context = context;
        this.epis=eps;
    }

    @Override
    public Object getChild(int groupPosition, int childPosititon) {
            /*return this._listDataChild.get(this._listDataHeader.get(groupPosition))
                    .get(childPosititon);*/
        return null;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return epis.get(groupPosition).getId();
    }

    @Override
    public View getChildView(int groupPosition, final int childPosition,
                             boolean isLastChild, View convertView, ViewGroup parent) {


        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this._context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.expandable_epi_item, null);
        }

        Epi epi = epis.get(groupPosition);

        TextView txNomeCondition= (TextView) convertView.findViewById(R.id.txNameCondition);
        TextView txTipoCondition= (TextView) convertView.findViewById(R.id.txTipoCondition);
        TextView txDescricao= (TextView) convertView.findViewById(R.id.txDescricao);
        TextView txObs= (TextView) convertView.findViewById(R.id.txObservacao);


        txNomeCondition.setText(epi.getNome());
        txDescricao.setText(epi.getDescricao());
        txTipoCondition.setText(epi.getTipo());
        txObs.setText(epi.getObservacoes());



        return convertView;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return 1;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return this.epis.get(groupPosition);
    }

    @Override
    public int getGroupCount() {
        return this.epis.size();
    }

    @Override
    public long getGroupId(int groupPosition) {
        return epis.get(groupPosition).getId();
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded,
                             View convertView, ViewGroup parent) {
        //String headerTitle = (String) getGroup(groupPosition);
        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this._context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.epi_item, null);
        }

        Epi epi = epis.get(groupPosition);
        TextView nomeCondicao = (TextView)
                convertView.findViewById(R.id.txNameEpi);

        nomeCondicao.setText(epi.getNome());

        return convertView;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

}


