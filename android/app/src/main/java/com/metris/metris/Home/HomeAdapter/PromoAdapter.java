package com.metris.metris.Home.HomeAdapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.metris.metris.Model.Promo;
import com.metris.metris.R;

import java.util.ArrayList;

public class PromoAdapter extends RecyclerView.Adapter<PromoAdapter.CustomViewHolder> {

    private LayoutInflater inflater;
    private ArrayList<Promo> promos;
    private Context context;

    public PromoAdapter(Context context) {
        this.context = context;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public PromoAdapter(Context context, ArrayList<Promo> promos) {
        this.context = context;
        this.promos = promos;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public PromoAdapter.CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.item_promo, viewGroup, false);
        PromoAdapter.CustomViewHolder viewHolder = new PromoAdapter.CustomViewHolder(view, this);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final PromoAdapter.CustomViewHolder holder, final int position) {

        Promo current = promos.get(position);

        holder.image.setImageResource(current.getImage());
        holder.title.setText(current.getTitle());

    }

    @Override
    public int getItemCount() {
        return promos.size();
    }

    public void addItem(ArrayList<Promo> data) {
        this.promos = data;
        notifyDataSetChanged();
    }


    public class CustomViewHolder extends RecyclerView.ViewHolder {

        private ImageView image;
        private TextView title;
        private PromoAdapter adapter;

        public CustomViewHolder(View itemView) {
            super(itemView);

            image = (ImageView) itemView.findViewById(R.id.item_promo_image);
            title = (TextView) itemView.findViewById(R.id.item_promo_title);

        }

        public CustomViewHolder(View itemView, PromoAdapter adapter) {
            super(itemView);

            this.image = (ImageView) itemView.findViewById(R.id.item_promo_image);
            this.title = (TextView) itemView.findViewById(R.id.item_promo_title);
            this.adapter = adapter;

        }

    }
}
