package br.edu.ufcspa.isolationapp.control;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.app.Fragment;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.List;

import br.edu.ufcspa.isolationapp.Model.Condicao;
import br.edu.ufcspa.isolationapp.R;
import br.edu.ufcspa.isolationapp.adapter.SearchConditionAdapter;
import br.edu.ufcspa.isolationapp.database.DataBaseAdapter;


public class SearchConditionFragment extends Fragment {
    View myView;
    ListView myList;
    EditText edtCondition;
    Button btSearch;
    DataBaseAdapter data;

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
        myList=(ListView) myView.findViewById(R.id.lviewConditions);
        edtCondition=(EditText)myView.findViewById(R.id.edTxCondition);
        btSearch=(Button) myView.findViewById(R.id.btSearch);
        data = DataBaseAdapter.getInstance(myView.getContext());



        btSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<Condicao> lista = data.buscarCondicaoPorNome(edtCondition.getText().toString());

                if(lista.size()>0){
                    SearchConditionAdapter adapter = new SearchConditionAdapter(lista,myView.getContext());
                    myList.setAdapter(adapter);
                }
            }
        });

    }




}
