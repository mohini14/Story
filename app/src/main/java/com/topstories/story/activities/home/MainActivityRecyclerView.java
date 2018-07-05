package com.topstories.story.activities.home;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

import com.topstories.story.R;
import com.topstories.story.model.MainPageData;

public class MainActivityRecyclerView extends RecyclerView.Adapter<MainActivityRecyclerView.RecyclerviewHolder> {


    ArrayList<MainPageData> dataArray;
    Context mContext;

    public MainActivityRecyclerView(ArrayList<MainPageData> data, Context con) {
        this.dataArray = data;
        this.mContext = con;
    }

    @NonNull
    @Override
    public RecyclerviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.vertical_recyclerview_cell, parent, false);
        return new RecyclerviewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerviewHolder holder, int position) {
        holder.childRecyclerView.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false));
        holder.childRecyclerView.setAdapter(new MainPageHorizontalRecyclerView(dataArray.get(position), mContext));
        holder.textView.setText(dataArray.get(position).getCategory());

    }

    @Override
    public int getItemCount() {
        return dataArray.size();
    }

    public class RecyclerviewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.horizontal_recyclerview)
        RecyclerView childRecyclerView;

        @BindView(R.id.main_page_section_title_textview)
        TextView textView;

        RecyclerviewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
