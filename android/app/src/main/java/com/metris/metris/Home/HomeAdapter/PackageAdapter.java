package com.metris.metris.Home.HomeAdapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.metris.metris.Model.Package;
import com.metris.metris.R;

import java.util.ArrayList;

public class PackageAdapter extends RecyclerView.Adapter<PackageAdapter.CustomViewHolder> {

    private LayoutInflater inflater;
    private ArrayList<Package> packages;
    private Context context;

    public PackageAdapter(Context context) {
        this.context = context;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public PackageAdapter(Context context, ArrayList<Package> packages) {
        this.context = context;
        this.packages = packages;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public PackageAdapter.CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.item_package, viewGroup, false);
        PackageAdapter.CustomViewHolder viewHolder = new PackageAdapter.CustomViewHolder(view, this);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final PackageAdapter.CustomViewHolder holder, final int position) {

        Package current = packages.get(position);

        holder.image.setImageResource(current.getImage());
        holder.name.setText(current.getName());

    }

    @Override
    public int getItemCount() {
        return packages.size();
    }

    public void addItem(ArrayList<Package> data) {
        this.packages = data;
        notifyDataSetChanged();
    }


    public class CustomViewHolder extends RecyclerView.ViewHolder {

        private ImageView image;
        private TextView name;
        private PackageAdapter adapter;

        public CustomViewHolder(View itemView) {
            super(itemView);

            image = (ImageView) itemView.findViewById(R.id.item_package_image);
            name = (TextView) itemView.findViewById(R.id.item_package_title);

        }

        public CustomViewHolder(View itemView, PackageAdapter adapter) {
            super(itemView);

            image = (ImageView) itemView.findViewById(R.id.item_package_image);
            name = (TextView) itemView.findViewById(R.id.item_package_title);
            this.adapter = adapter;

        }

    }
}
