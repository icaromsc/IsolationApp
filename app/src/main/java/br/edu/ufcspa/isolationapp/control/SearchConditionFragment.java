package br.edu.ufcspa.isolationapp.control;

import android.app.ExpandableListActivity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.app.Fragment;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import br.edu.ufcspa.isolationapp.Model.Condicao;
import br.edu.ufcspa.isolationapp.R;
import br.edu.ufcspa.isolationapp.adapter.SearchAdapter;
import br.edu.ufcspa.isolationapp.adapter.SearchConditionAdapter;
import br.edu.ufcspa.isolationapp.database.DataBaseAdapter;


public class SearchConditionFragment extends Fragment {
    View myView;
    ExpandableListView myList;
    EditText edtCondition;
    Button btSearch;
    DataBaseAdapter data;
    LinearLayout layoutLegend;

    public SearchConditionFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        myView = inflater.inflate(R.layout.fragment_search_condition, container, false);
        return myView;
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        myList=(ExpandableListView) myView.findViewById(R.id.lviewConditions);
        edtCondition=(EditText)myView.findViewById(R.id.edTxCondition);
        btSearch=(Button) myView.findViewById(R.id.btSearch);
        data = DataBaseAdapter.getInstance(myView.getContext());
        layoutLegend= (LinearLayout) myView.findViewById(R.id.layoutLegend);


        btSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<Condicao> lista = data.buscarCondicaoPorNome(edtCondition.getText().toString());
                if(layoutLegend.getVisibility()==View.GONE)
                    layoutLegend.setVisibility(View.VISIBLE);

                if(lista.size()>0){
                    //SearchConditionAdapter adapter = new SearchConditionAdapter(lista,myView.getContext());
                    SearchAdapter searchAdapter = new SearchAdapter(myView.getContext(),lista);
                    myList.setAdapter(searchAdapter);
                }
            }
        });

        myList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d("listview","clicou no item "+position);
                if(myList.isGroupExpanded(position))
                    layoutLegend.setVisibility(View.GONE);
                else
                    layoutLegend.setVisibility(View.VISIBLE);

            }
        });
        myList.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                Log.d("listview","clicou no item "+groupPosition);
                if(myList.isGroupExpanded(groupPosition))
                    layoutLegend.setVisibility(View.GONE);
                else
                    layoutLegend.setVisibility(View.VISIBLE);

                return false;
            }
        });

    }




}
