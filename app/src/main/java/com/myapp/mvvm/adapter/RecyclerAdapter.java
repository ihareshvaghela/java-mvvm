package com.myapp.mvvm.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.myapp.mvvm.R;
import com.myapp.mvvm.model.NicePlaces;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private Context mContext;
    private List<NicePlaces> placesList;

    public RecyclerAdapter(Context mContext, List<NicePlaces> placesList) {
        this.mContext = mContext;
        this.placesList = placesList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.textView.setText(placesList.get(position).getTitle());

        RequestOptions requestOptions = new RequestOptions()
                .error(R.mipmap.ic_launcher_round);

        Glide.with(mContext)
                .setDefaultRequestOptions(requestOptions)
                .load(placesList.get(position).getImageURL())
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return placesList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        CircleImageView imageView;
        TextView textView;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            textView = itemView.findViewById(R.id.title);
        }
    }
}
