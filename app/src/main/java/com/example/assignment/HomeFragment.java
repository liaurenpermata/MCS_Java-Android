package com.example.assignment;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import java.io.ByteArrayOutputStream;

public class HomeFragment extends Fragment {

    int[] images = {R.drawable.table, R.drawable.chair, R.drawable.lamp};
    String[] version = {"Table", "Chair", "Lamp"};
    String[] versionNumber = {"400.000", "350.000", "120.000"};

    String username;
    TextView txtHomeFrag;
    ListView lView;
    FurnitureAdapter lAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View viewFrag = inflater.inflate(R.layout.fragment_home, container, false);

        txtHomeFrag = viewFrag.findViewById(R.id.textViewHome);

        Bundle data = getArguments();

        if(data!=null){
            username = data.getString("myUsername");
        } else{
            username = "Name not Found";
        }

        txtHomeFrag.setText(username);

        lView = viewFrag.findViewById(R.id.androidList);
        lAdapter = new FurnitureAdapter(getActivity(), version, versionNumber, images);
        lView.setAdapter(lAdapter);

//        lView.setOnItemClickListener((adapterView, view, i, l) ->
//                Toast.makeText(getActivity(), version[i]+" "+versionNumber[i], Toast.LENGTH_SHORT).show()
//        );

        lView.setOnItemClickListener((adapterView, view, i, l) -> {
            Intent intent = new Intent(getActivity(), DetailFurniture.class);
            intent.putExtra("nameProd", version[i]);
            intent.putExtra("priceProd", versionNumber[i]);

            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), images[i]);
            ByteArrayOutputStream bs = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 50, bs);
            intent.putExtra("imageProd", bs.toByteArray());

            startActivity(intent);
        });

        return viewFrag;
    }
}
