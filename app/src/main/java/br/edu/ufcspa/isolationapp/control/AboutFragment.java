package br.edu.ufcspa.isolationapp.control;

import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import br.edu.ufcspa.isolationapp.Model.Links;
import br.edu.ufcspa.isolationapp.R;

/**
 * Created by icaromsc on 14/06/2017.
 */

public class AboutFragment extends Fragment {

    View myView;
    public AboutFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

         myView= inflater.inflate(R.layout.fragmente_about, container, false);


        return myView;
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }


}
