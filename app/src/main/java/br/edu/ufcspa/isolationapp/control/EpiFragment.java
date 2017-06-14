package br.edu.ufcspa.isolationapp.control;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;

import java.util.List;

import br.edu.ufcspa.isolationapp.Model.Epi;
import br.edu.ufcspa.isolationapp.R;
import br.edu.ufcspa.isolationapp.adapter.EpiAdapter;
import br.edu.ufcspa.isolationapp.database.DataBaseAdapter;

/**
 * Created by icaromsc on 14/06/2017.
 */

public class EpiFragment extends Fragment {


    View myView;
    ExpandableListView myList;
    DataBaseAdapter data;


    public EpiFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        myView = inflater.inflate(R.layout.fragment_epi, container, false);
        return myView;
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        myList=(ExpandableListView) myView.findViewById(R.id.lviewEpis);
        data = DataBaseAdapter.getInstance(myView.getContext());

        List<Epi> lista = data.buscarEPIs();

        if(lista.size()>0){
            //SearchConditionAdapter adapter = new SearchConditionAdapter(lista,myView.getContext());
            EpiAdapter epiAdapter = new EpiAdapter(myView.getContext(),lista);
            myList.setAdapter(epiAdapter);
        }



    }



}
