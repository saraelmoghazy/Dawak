package com.elmoghazy.dawak.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.elmoghazy.dawak.R;
import com.elmoghazy.dawak.models.Drug;

import java.util.ArrayList;
import java.util.List;

//interface OnItemClickListener {
//    void onItemClick(String item);
//}

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private static final String TAG = "RecyclerViewAdpater";
    private List<Drug> drugsList = new ArrayList<>();
//    private ArrayList<String> drugNames = new ArrayList<>();
//    private ArrayList<String> drugImages = new ArrayList<>();

    private Context mContext;
//old working constructor without MVVM
//    public MyAdapter(Context mContext, ArrayList<String> drugsNames, ArrayList<String> drugImages){
//        this.drugNames = drugsNames;
//        this.drugImages = drugImages;
//        this.mContext = mContext;
//    }
    public MyAdapter(Context mContext, List<Drug> drugsList){
        this.drugsList = drugsList;
        this.mContext = mContext;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item,viewGroup, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, final int position) {
        // it's called when every single iem is added to the list
        Log.d(TAG, "onBindViewHolder" + position);
        myViewHolder.textView.setText(drugsList.get(position).getName());
        Glide.with(mContext)
                .asBitmap()
                .load(drugsList.get(position).getImageURL())
                .into(myViewHolder.imageView);
        myViewHolder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG,"onClick");
                Toast.makeText(mContext,"Hello " + drugsList.get(position).getName(),Toast.LENGTH_LONG).show();

            }
        });
    }

    @Override
    public int getItemCount() {
        return drugsList.size();
    }

    //    private final OnItemClickListener listener;
//    private DrugViewModel myViewModel;
//    private String[] mDataset;
    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView textView;
        public ImageView imageView;
        public MyViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.drugName);
            imageView = itemView.findViewById(R.id.drugImg);
        }

//        public void bind(final String item, final OnItemClickListener listener){
//            textView.setOnClickListener(new TextView.OnClickListener(){
//                @Override
//                public void onClick(View v) {
//                    listener.onItemClick(item);
//                }
//            });
//        }

    }


    // Provide a suitable constructor (depends on the kind of dataset)
//    public MyAdapter(String[] myDataset, OnItemClickListener listener, DrugViewModel myViewModel) {
//        mDataset = myDataset;
//        this.listener = listener;
//        this.myViewModel = myViewModel;
//    }
//    // Create new views (invoked by the layout manager)
//    @Override
//    public MyViewHolder onCreateViewHolder(ViewGroup parent,
//                                           int viewType) {
//        // create a new view
//        TextView v = (TextView) LayoutInflater.from(parent.getContext())
//                .inflate(R.layout.list_item, parent, false);
//        MyViewHolder vh = new MyViewHolder(v);
//        return vh;
//    }
//
//    // Replace the contents of a view (invoked by the layout manager)
//    @Override
//    public void onBindViewHolder(MyViewHolder holder, int position) {
//        // - get element from your dataset at this position
//        // - replace the contents of the view with that element
//        holder.textView.setText(mDataset[position]);
//
//    }
//
//    // Return the size of your dataset (invoked by the layout manager)
//    @Override
//    public int getItemCount() {
//        return mDataset.length;
//    }
}
