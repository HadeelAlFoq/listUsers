package com.example.hadeel.mvpretrofittask;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by dena on 10/27/2017.
 */

public class UserPresenter {
    final Context context;
    private final UserPresenterListener mListner;
    private final UserService userService;


    private RecyclerView recyclerView;
    private UserAdapter mAdapter;
    List<User> Users;
    private RecyclerView.LayoutManager mLayoutManager;

    public interface UserPresenterListener {
        void usersReady(List<User> users);

    }

    public UserPresenter(UserPresenterListener listener, Context context) {
        this.mListner = listener;
        this.context = context;


        this.userService = new UserService();
    }

    public void getUsers() {

        Call<List<User>> call = userService.getAPI().getUsers();
        call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                List<User> users= response.body();
                Log.d("REESSSPOne",response.body().toString());
                Collections.sort(users, new Comparator<User>() {
                    @Override
                    public int compare(User user1, User user2) {
                        return Boolean.compare(user2.isSite_admin(),user1.isSite_admin());
                    }
                });

               mAdapter = new UserAdapter(users,context);
                mLayoutManager = new LinearLayoutManager(context);
                recyclerView = (RecyclerView) ((Activity) context).findViewById(R.id.RecyclerView);
                recyclerView.setLayoutManager(mLayoutManager);

                recyclerView.setItemAnimator(new DefaultItemAnimator());

                recyclerView.setAdapter(mAdapter);



            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {

            }





        });
    }

}
