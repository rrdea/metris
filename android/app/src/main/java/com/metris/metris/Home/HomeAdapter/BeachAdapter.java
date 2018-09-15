package com.metris.metris.Home.HomeAdapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.metris.metris.Model.Beach;
import com.metris.metris.R;

import java.util.ArrayList;

public class BeachAdapter extends RecyclerView.Adapter<BeachAdapter.CustomViewHolder> {

    private LayoutInflater inflater;
    private ArrayList<Beach> beaches;
    private Context context;

    public BeachAdapter(Context context) {
        this.context = context;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public BeachAdapter(Context context, ArrayList<Beach> Beachs) {
        this.context = context;
        this.beaches = Beachs;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public BeachAdapter.CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.item_beach, viewGroup, false);
        BeachAdapter.CustomViewHolder viewHolder = new BeachAdapter.CustomViewHolder(view, this);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final BeachAdapter.CustomViewHolder holder, final int position) {

        Beach current = beaches.get(position);

        holder.image.setImageResource(current.getImage());
        holder.name.setText(current.getName());

    }

    @Override
    public int getItemCount() {
        return beaches.size();
    }

    public void addItem(ArrayList<Beach> data) {
        this.beaches = data;
        notifyDataSetChanged();
    }


    public class CustomViewHolder extends RecyclerView.ViewHolder {

        private ImageView image;
        private TextView name;
        private BeachAdapter adapter;

        public CustomViewHolder(View itemView) {
            super(itemView);

            image = (ImageView) itemView.findViewById(R.id.item_beach_image);
            name = (TextView) itemView.findViewById(R.id.item_beach_title);

        }

        public CustomViewHolder(View itemView, BeachAdapter adapter) {
            super(itemView);

            image = (ImageView) itemView.findViewById(R.id.item_beach_image);
            name = (TextView) itemView.findViewById(R.id.item_beach_title);
            this.adapter = adapter;

        }

    }
}
