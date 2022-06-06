package com.example.assignment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

public class ProfileFragment extends Fragment {

    TextView txtEmail, txtUsername, txtPhone;
    String username, email, phoneNumber, usernameEdit;
    Button btn_show, btnEdit, btnSave, btnDelete;
    EditText edtUsername;
    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_profile, container, false);

//        btn_show = view.findViewById(R.id.btn_showe);
//        btn_show.setOnClickListener(view1  ->
//                Toast.makeText(getContext(),
//                        "This is from Fragment Profile!",
//                        Toast.LENGTH_LONG).show());

        btnEdit = view.findViewById(R.id.btnEdit);
        btnEdit.setOnClickListener(view1 -> editUsername());
        btnSave = view.findViewById(R.id.btnSave);
        btnSave.setOnClickListener(view1 -> saveUsername());
        btn_show = view.findViewById(R.id.btn_showe);
        btn_show.setOnClickListener(view1 -> logOut());
        btnDelete = view.findViewById(R.id.btnDelete);
        btnDelete.setOnClickListener(view1 -> deleteAcc());
//
        Bundle data = getArguments();
        if(data!=null){
            username = data.getString("myUsername");
            email = data.getString("myEmail");
            phoneNumber = data.getString("myPhoneNumber");
        } else{
            username = "Name not Found";
            email = "Email not Found";
            phoneNumber = "Phone Number not Found";
        }

        txtUsername = view.findViewById(R.id.textViewProfile2);
        txtUsername.setText(username);
        txtEmail = view.findViewById(R.id.textViewProfile3);
        txtEmail.setText(email);
        txtPhone = view.findViewById(R.id.textViewProfile4);
        txtPhone.setText(phoneNumber);

        return view;
    }

    public void deleteAcc(){

        try {
            MainActivity mainActivity = (MainActivity) getActivity();
            if(usernameEdit!=null){
                mainActivity.delete = true;
                mainActivity.email = email;
                mainActivity.phone = phoneNumber;
            }
        } catch (Exception ex){
            ex.printStackTrace();
        }

        Intent loginIntent = new Intent(getActivity(), MainActivity.class);
        startActivity(loginIntent);
    }

    public void logOut(){
        Intent loginIntent = new Intent(getActivity(), MainActivity.class);
        startActivity(loginIntent);
    }

    public void editUsername(){
//
//        helper = new UserHelper(this);
//
        btnEdit.setVisibility(view.GONE);
        txtUsername.setVisibility(view.GONE);
//
        edtUsername = view.findViewById(R.id.edtUsername);
        edtUsername.setVisibility(view.VISIBLE);
//
        btnSave = view.findViewById(R.id.btnSave);
        btnSave.setVisibility(view.VISIBLE);
//
    }
//
    public void saveUsername(){
        if(edtUsername.getText().length() >= 3 && edtUsername.getText().length()<=20){
            usernameEdit = edtUsername.getText().toString();

//            helper.open();
//            helper.editUsername(email, phoneNumber, usernameEdit);
//            helper.close();

            try {
                HomeActivity homeActivity = (HomeActivity) getActivity();
                if(usernameEdit!=null){
                    homeActivity.usernameNew = usernameEdit;
                }
            } catch (Exception ex){
                ex.printStackTrace();
            }

            username = usernameEdit;
            btnEdit.setVisibility(view.VISIBLE);
            txtUsername.setVisibility(view.VISIBLE);
            txtUsername.setText(username);
            edtUsername.setVisibility(view.GONE);
            btnSave.setVisibility(view.GONE);

        } else {
            String toastMessage = "Username must contain between 3 and 20 characters!";
            Toast.makeText(getContext(), toastMessage, Toast.LENGTH_LONG).show();
        }
    }
}
