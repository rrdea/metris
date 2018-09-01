package com.metris.metris.Authorization;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.metris.metris.R;

import java.util.HashMap;

public class RegisterFragment_2 extends Fragment {

    private String[] province;
    private String[] city;
    private Spinner registerProvinceSpinner;
    private Spinner registerCitySpinner;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_register_2, container, false);
        registerProvinceSpinner = (Spinner) view.findViewById(R.id.register_spinner_province);
        registerCitySpinner = (Spinner) view.findViewById(R.id.register_spinner_city);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        settingSpinner();

        registerProvinceSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String selectedProvince = registerProvinceSpinner.getSelectedItem().toString();
                switch (selectedProvince){
                    case "Jawa Timur" :
                        city = new String[4];
                        city[0] = "Malang";
                        city[1] = "Gresik";
                        city[2] = "Banyuwangi";
                        city[3] = "Madura";
                        break;

                     case "Jawa Tengah" :
                        city = new String[2];
                        city[0] = "Solo";
                        city[1] = "Semarang";
                        break;
                }
                ArrayAdapter<String> cityAdapter = new ArrayAdapter<String>(getActivity(),
                        R.layout.spinner_item, city);
                cityAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                registerCitySpinner.setAdapter(cityAdapter);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void settingSpinner(){
        province = new String[2];
        province[0] = "Jawa Timur";
        province[1] = "Jawa Tengah";

        ArrayAdapter<String> provinceAdapter = new ArrayAdapter<String>(getActivity(),
                R.layout.spinner_item, province);
        provinceAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        registerProvinceSpinner.setAdapter(provinceAdapter);
    }
}
