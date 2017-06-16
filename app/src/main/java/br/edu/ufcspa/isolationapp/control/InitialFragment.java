package br.edu.ufcspa.isolationapp.control;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import br.edu.ufcspa.isolationapp.R;

/**
 * Created by icaromsc on 16/06/2017.
 */

public class InitialFragment extends Fragment {
    View myView;
    public InitialFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        myView= inflater.inflate(R.layout.fragment_inicial, container, false);

        return myView;
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }
}
