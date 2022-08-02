package com.example.webapi;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.viewHolder>{




    private final Context context;
    private final List<ListItem> listItems;
    RequestOptions option;

    public PostAdapter(List<ListItem> listItems, Context context) {

        this.listItems = listItems;
        this.context = context;

        option = new RequestOptions().centerCrop()
                .placeholder(R.drawable.loading_shape)
                .error(R.drawable.loading_shape);
    }



    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list, parent, false);

        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, @SuppressLint("RecyclerView") int position) {

        holder.tvTitle.setText(listItems.get(position).getTitle());
        holder.tvDes.setText(listItems.get(position).getDescription());



        Glide.with(context).load(listItems.get(position).getImage()).apply(option).into(holder.imageView);


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent i = new Intent(view.getContext(), ClickedActivity.class);
                        i.putExtra("Title", listItems.get(position));
                        i.putExtra("Description", listItems.get(position));
                        i.putExtra("Image", listItems.get(position));
                        i.putExtra("CategName",listItems.get(position));
                        i.putExtra("PromoCode",listItems.get(position));
                        i.putExtra("ValidityStart",listItems.get(position));
                        i.putExtra("ValidityEnd",listItems.get(position));
                        i.putExtra("StoreName",listItems.get(position));


                        view.getContext().startActivity(i);
            }
        });



    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {

        TextView tvTitle;
        TextView tvDes;
        ImageView imageView;


        public viewHolder(@NonNull View itemView) {
            super(itemView);

            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvDes = itemView.findViewById(R.id.tvDes);
            imageView = itemView.findViewById(R.id.imageView);


        }


    }
}
