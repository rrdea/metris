package com.metris.metris.Home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.metris.metris.Home.HomeAdapter.BeachAdapter;
import com.metris.metris.Home.HomeAdapter.PackageAdapter;
import com.metris.metris.Home.HomeAdapter.PromoAdapter;
import com.metris.metris.Model.Beach;
import com.metris.metris.Model.Promo;
import com.metris.metris.Model.Package;
import com.metris.metris.R;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private PromoAdapter promoAdapter;
    private BeachAdapter beachAdapter;
    private PackageAdapter packageAdapter;

    private RecyclerView promoRv;
    private RecyclerView beachRv;
    private RecyclerView packageRv;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        promoRv = (RecyclerView) view.findViewById(R.id.home_rv_promo);
        beachRv = (RecyclerView) view.findViewById(R.id.home_rv_beach);
        packageRv = (RecyclerView) view.findViewById(R.id.home_rv_package);

        ArrayList<Promo> promos = new ArrayList();
        promos.add(new Promo(R.drawable.blue_poster, "Lihat Semua Promo %"));
        promos.add(new Promo(R.drawable.img_bangsring, "Diskon 10%"));
        promos.add(new Promo(R.drawable.img_cemara, "Diskon 20%"));

        ArrayList<Beach> beaches = new ArrayList();
        beaches.add(new Beach(R.drawable.img_gili_noko, "Gili Noko"));
        beaches.add(new Beach(R.drawable.img_tiga_warna, "Tiga Warna"));
        beaches.add(new Beach(R.drawable.img_bangsring, "Bangsring"));

        ArrayList<Package> packages = new ArrayList();
        packages.add(new Package(R.drawable.img_bangsring, "Bahari"));
        packages.add(new Package(R.drawable.img_watulimo, "Limo"));
        packages.add(new Package(R.drawable.img_lenggoksono, "Sono"));

        promoAdapter = new PromoAdapter(getContext(), promos);
        promoRv.setAdapter(promoAdapter);
        promoRv.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

        beachAdapter = new BeachAdapter(getContext(), beaches);
        beachRv.setAdapter(beachAdapter);
        beachRv.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

        packageAdapter = new PackageAdapter(getContext(), packages);
        packageRv.setAdapter(packageAdapter);
        packageRv.setLayoutManager(new LinearLayoutManager(getContext()));

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);



    }
}
