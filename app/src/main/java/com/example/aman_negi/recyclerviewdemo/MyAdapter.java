package com.example.aman_negi.recyclerviewdemo;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private ArrayList<SingleRow> singleRowArrayList;
    private RecyclerViewClickListener mListener;

    MyAdapter(ArrayList<SingleRow> singleRowArrayList, RecyclerViewClickListener mListener) {
        this.singleRowArrayList = singleRowArrayList;
        this.mListener = mListener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_row, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view, mListener);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        SingleRow s = singleRowArrayList.get(position);
        int image = s.getImage();
        String name = s.getName();
        String num = s.getNum();

        holder.imageView.setImageResource(image);
        holder.txtName.setText(name);
        holder.txtNum.setText(num);
    }

    @Override
    public int getItemCount() {
        return singleRowArrayList.size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView imageView;
        TextView txtName, txtNum;
        private RecyclerViewClickListener recyclerViewClickListener;

        MyViewHolder(View itemView, RecyclerViewClickListener listener) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            txtName = itemView.findViewById(R.id.nameView);
            txtNum = itemView.findViewById(R.id.numView);
            recyclerViewClickListener = listener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            recyclerViewClickListener.onClick(v, getAdapterPosition());
        }
    }
}
