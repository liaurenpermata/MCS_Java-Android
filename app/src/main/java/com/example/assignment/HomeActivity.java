package com.example.assignment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    Bundle bundle1, bundle2;
    Fragment homeFragment, profileFragment, transactionFragment;
    String username, email, phoneNumber, password, usernameNew;

    private com.example.assignment.UserHelper helper = new com.example.assignment.UserHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        bundle1 = getIntent().getExtras();
        email = bundle1.getString("email");
        password = bundle1.getString("password");

        callUsername(email, password);

        bundle2 = new Bundle();
        bundle2.putString("myUsername", username);

        homeFragment = new HomeFragment();
        homeFragment.setArguments(bundle2);

        loadFragment(homeFragment);

    }

    public boolean loadFragment(Fragment fragment){
        if(fragment != null){
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frameLayout, fragment)
                    .commit();
            return true;
        }
        return false;
    }

    public boolean onCreateOptionsMenu(Menu menu){
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu_item, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){

        Fragment fragment = null;
        callUsername(email, password);

        switch (item.getItemId()){
            case R.id.homeItem:
                if(!usernameNew.equals(username) && usernameNew != null){
                    helper.open();
                    helper.editUsername(email, phoneNumber, usernameNew);
                    helper.close();
                    bundle2.putString("myUsername", usernameNew);
                    username = usernameNew;
                }else {
                    bundle2.putString("myUsername", username);
                }
                homeFragment.setArguments(bundle2);
                fragment = homeFragment;
                break;

            case R.id.profileItem:
                profileFragment = new ProfileFragment();
                bundle2.putString("myUsername", username);
                bundle2.putString("myPhoneNumber", phoneNumber);
                bundle2.putString("myEmail", email);
                profileFragment.setArguments(bundle2);
                fragment = profileFragment;
                break;

            case R.id.transactionItem:
                transactionFragment = new TransactionFragment();
                fragment = transactionFragment;
                break;
        }
        return loadFragment(fragment);
    }

    public void callUsername(String email, String password){

        helper.open();
        ArrayList<User> userList = helper.searchUser(email, password);
        helper.close();

        username = userList.get(0).getUsername();
        phoneNumber = userList.get(0).getPhoneNumber();
    }
}