package com.example.dell.loot;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.lang.reflect.Method;
import java.util.ArrayList;

public class LeaderBoard extends Fragment {

    ListView listView;
    View view;
    ArrayList<String> usernames, coins;

    public LeaderBoard() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_leader_board, container, false);
        listView = view.findViewById(R.id.listView);
        StringRequest leaders = new StringRequest(Request.Method.GET, Endpoints.leaders,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // TODO: parse response and inflate ArrayList objects
                        listView.setAdapter(new LeaderListAdapter(getContext(), usernames, coins));
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });
        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        requestQueue.add(leaders);
        return view;
    }
}
