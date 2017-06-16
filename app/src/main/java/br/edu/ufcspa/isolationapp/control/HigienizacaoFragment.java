package br.edu.ufcspa.isolationapp.control;

import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import br.edu.ufcspa.isolationapp.BuildConfig;
import br.edu.ufcspa.isolationapp.R;

/**
 * Created by icaromsc on 16/06/2017.
 */

public class HigienizacaoFragment extends Fragment {

    View myView;
    ImageView imgMaos;
    ImageView imgHig;
    String imageUri = "drawable://" + "higienizacao.png";


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        myView= inflater.inflate(R.layout.fragment_imagens, container, false);

        imgMaos= (ImageView) myView.findViewById(R.id.imgMaos);
        imgHig= (ImageView) myView.findViewById(R.id.imgHig);


        String path =Uri.parse("android.resource://"+ BuildConfig.APPLICATION_ID+"‌​/" + "higienizacao.png").getPath();
        Log.d("viewer","path new:"+path);

        return myView;
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        imgHig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("viewer","path old:"+imageUri);
                /*Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                //intent.setDataAndType(Uri.parse(imageUri), "image*//*");
                intent.setDataAndType(Uri.parse("android.resource://"+ BuildConfig.APPLICATION_ID+"‌​/" +"higienizacao.png"), "image*//*");
                startActivity(intent);*/
            }
        });

    }
}
