package com.example.hadeel.mvpretrofittask;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity implements UserPresenter.UserPresenterListener {
private UserPresenter userPresenter;
    TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

      userPresenter=new UserPresenter(this,this);
        userPresenter.getUsers();
       // Log.d("String","HHHHHHHHHHHHHHHHH");
    }







    @Override
    public void usersReady(List<User> users) {

    }
}
