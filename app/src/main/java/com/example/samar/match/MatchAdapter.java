package com.example.samar.match;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.hardware.Camera;
import android.os.Build;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.github.siyamed.shapeimageview.CircularImageView;
import com.squareup.picasso.Picasso;

import java.util.List;

import static android.support.v4.app.ActivityCompat.startActivity;
import static android.support.v4.app.ActivityCompat.startActivityForResult;

/**
 * Created by Samar on 01/12/2016.
 */

public class MatchAdapter extends  RecyclerView.Adapter<MatchAdapter.MyViewHolder> {

    private List<Data> dataList;
    Context context;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name, age_location;
        public CircularImageView genre;

        public MyViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.name);
            genre = (CircularImageView) view.findViewById(R.id.image);
            age_location = (TextView) view.findViewById(R.id.age_location);
        }
    }


    public MatchAdapter(List<Data> moviesList, Context context) {
        this.dataList = moviesList;
        this.context=context;
    }

    @Override
    public MatchAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.grid_layout, parent, false);

        return new MatchAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MatchAdapter.MyViewHolder holder, final int position) {
        final Data data = dataList.get(position);
        holder.name.setText(data.getImage());
        /*Bitmap selectedBitmap = BitmapFactory.decodeResource(context.getResources(),
                data.getName());
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            selectedBitmap.setHeight(Math.round(selectedBitmap.getWidth()));
        }*/
        Picasso.with(context).load(data.getName()).into(holder.genre);
        holder.genre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(context,""+position,Toast.LENGTH_SHORT).show();
                Snackbar.make(v, data.getImage()+" "+data.getAge(), Snackbar.LENGTH_SHORT)
                        .setAction("Action", null).show();
                Intent details = new Intent(context,Details.class);
                details.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                details.putExtra("position",position);
                context.startActivity(details);
            }
        });
        holder.genre.setContentDescription("Profile Pic of "+data.getImage()+"Activate to go to details");
        holder.age_location.setText(data.getAge());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }


}
