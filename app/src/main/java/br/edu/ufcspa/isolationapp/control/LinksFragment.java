package br.edu.ufcspa.isolationapp.control;

import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.text.util.Linkify;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import br.edu.ufcspa.isolationapp.Model.Links;
import br.edu.ufcspa.isolationapp.R;
import br.edu.ufcspa.isolationapp.adapter.EpiAdapter;
import br.edu.ufcspa.isolationapp.database.DataBaseAdapter;

import static android.R.id.message;

/**
 * Created by icaromsc on 14/06/2017.
 */

public class LinksFragment extends Fragment {

    View myView;
    LinearLayout layout;
    TextView tx1;
    TextView tx2;
    TextView tx3;
    TextView tx4;


    public LinksFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        myView = inflater.inflate(R.layout.fragment_links, container, false);


        return myView;
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

       /* tx1=(TextView) myView.findViewById(R.id.txtLink1);
        tx2=(TextView) myView.findViewById(R.id.txtLink2);
        tx3=(TextView) myView.findViewById(R.id.txtLink3);
        tx4=(TextView) myView.findViewById(R.id.txtLink4);

        TextView[] textViews = {tx1,tx2,tx3,tx4};*/
        layout = (LinearLayout) myView.findViewById(R.id.layoutLinks);
        String[] links = Links.links;


        for (String link: links
                ) {
            TextView msg = new TextView(getActivity().getApplicationContext());
            msg.setText(Html.fromHtml(link));
            msg.setMovementMethod(LinkMovementMethod.getInstance());
            msg.setTextSize(20);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                msg.setHighlightColor(getResources().getColor(R.color.colorAccent, null));
            }
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                msg.setLayoutParams(new LinearLayout.LayoutParams(
                        new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                                LinearLayout.LayoutParams.WRAP_CONTENT)));
            }
            msg.setGravity(Gravity.CENTER);

            setMargins(msg, 15, 15, 15, 15);
            layout.addView(msg);
        }
    }


    private void setMargins (View view, int left, int top, int right, int bottom) {
        if (view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams p = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            p.setMargins(left, top, right, bottom);
            view.requestLayout();
        }
    }
}
