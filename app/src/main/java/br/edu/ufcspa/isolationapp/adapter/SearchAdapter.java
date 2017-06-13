package br.edu.ufcspa.isolationapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

import br.edu.ufcspa.isolationapp.Model.Condicao;
import br.edu.ufcspa.isolationapp.R;

/**
 * Created by icaromsc on 12/06/2017.
 */

public class SearchAdapter extends BaseExpandableListAdapter{

        private Context _context;
        private List<String> _listDataHeader; // header titles
        private final List<Condicao> conds;
        // child data in format of header title, child title
        private HashMap<String, List<String>> _listDataChild;

        public SearchAdapter(Context context, List<Condicao> conds) {
            this._context = context;
            this.conds=conds;
        }

        @Override
        public Object getChild(int groupPosition, int childPosititon) {
            return this._listDataChild.get(this._listDataHeader.get(groupPosition))
                    .get(childPosititon);
        }

        @Override
        public long getChildId(int groupPosition, int childPosition) {
            return conds.get(groupPosition).getId();
        }

        @Override
        public View getChildView(int groupPosition, final int childPosition,
                                 boolean isLastChild, View convertView, ViewGroup parent) {

            final String childText = (String) getChild(groupPosition, childPosition);



            return convertView;
        }

        @Override
        public int getChildrenCount(int groupPosition) {
           return 1;
        }

        @Override
        public Object getGroup(int groupPosition) {
            return this.conds.get(groupPosition);
        }

        @Override
        public int getGroupCount() {
            return this.conds.size();
        }

        @Override
        public long getGroupId(int groupPosition) {
            return conds.get(groupPosition).getId();
        }

        @Override
        public View getGroupView(int groupPosition, boolean isExpanded,
                                 View convertView, ViewGroup parent) {
            String headerTitle = (String) getGroup(groupPosition);
            if (convertView == null) {
                LayoutInflater infalInflater = (LayoutInflater) this._context
                        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = infalInflater.inflate(R.layout.condition_item, null);
            }

            Condicao condicao = conds.get(groupPosition);
            TextView nomeCondicao = (TextView)
                    convertView.findViewById(R.id.txCondition);
            TextView tipo = (TextView)
                    convertView.findViewById(R.id.txType);

            nomeCondicao.setText(condicao.getNomeCondicao());
            tipo.setText(condicao.getTipo());

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
