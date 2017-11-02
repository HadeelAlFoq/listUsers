package com.example.hadeel.mvpretrofittask;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.cuboid.cuboidcirclebutton.CuboidButton;
import com.example.hadeel.mvpretrofittask.R;
import com.example.hadeel.mvpretrofittask.User;

import java.util.ArrayList;
import java.util.List;


public class UserAdapter extends RecyclerView.Adapter<UserAdapter.MyViewHolder> {

    private List<User> usersList;
    private Context context;


    boolean status;


    @Override
    public void onBindViewHolder(UserAdapter.MyViewHolder holder, int position) {

        final UserAdapter.MyViewHolder holder1 = holder;

        holder1.name.setText(usersList.get(position).getLogin());
        holder1.type.setText(usersList.get(position).getType());
        status=usersList.get(position).isSite_admin();

        if(status){




            holder1.circleButton.setBackgroundResource(R.drawable.circle_blue);


        }
        else {

            holder1.circleButton.setBackgroundResource(R.drawable.circle_green);








        }



    }







    public UserAdapter(List<User> usersList,Context context) {
        this.usersList = usersList;
        this.context=context;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_item, parent, false);
        Log.e("My Custom Message","Creating new Row ");


        return new MyViewHolder(itemView);
    }

    @Override
    public int getItemCount() {
        return usersList.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name, type;
        public Button circleButton;
        public LinearLayout linearLayout;


        public MyViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.Name);
            type = (TextView) view.findViewById(R.id.Type);
            circleButton=(Button)view.findViewById(R.id.circleButton);
            linearLayout=(LinearLayout)view.findViewById(R.id.linear);

        }
    }

}
