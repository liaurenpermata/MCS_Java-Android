package com.example.assignment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

public class TransactionFragment extends Fragment {
    Button btn_show;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_transaction, container, false);

        btn_show = (Button) view.findViewById(R.id.btn_showe);
        btn_show.setOnClickListener(view1  -> Toast.makeText(getContext(), "This is from Fragment Transaction!", Toast.LENGTH_LONG).show());
        return view;
    }
}
