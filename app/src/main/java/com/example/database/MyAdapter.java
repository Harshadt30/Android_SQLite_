package com.example.database;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {

    Context context;
    ArrayList<UserInfo> users;

    public MyAdapter(Context context, ArrayList<UserInfo> users) {
        this.context = context;
        this.users = users;
    }

    @Override
    public int getCount() {
        return this.users.size();
    }

    @Override
    public Object getItem(int position) {
        return users.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {

        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        view = layoutInflater.inflate(R.layout.custom_listview, null);

        TextView id = (TextView)view.findViewById(R.id.id_clv);
        TextView name = (TextView)view.findViewById(R.id.name_clv);
        TextView password = (TextView)view.findViewById(R.id.password_clv);

        UserInfo users_all = users.get(position);

        id.setText(String.valueOf(users_all.getId()));
        name.setText(users_all.getName());
        password.setText(users_all.getPassword());

        return view;
    }
}
