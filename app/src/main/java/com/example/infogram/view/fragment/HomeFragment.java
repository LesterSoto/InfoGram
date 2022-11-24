package com.example.infogram.view.fragment;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.infogram.R;
import com.example.infogram.adapter.CardViewAdapter;
import com.example.infogram.model.Image;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HomeFragment() {
    }


    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        //toolbar
        showToolBar(getString(R.string.title_home_fragment),false, view);

        //recyclerview
        RecyclerView recyclerView = view.findViewById(R.id.recyclerview);

        //layout manager
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        //el adapter
        CardViewAdapter cardViewAdapter = new CardViewAdapter(buidImages(), R.layout.cardview_image, getActivity());
        recyclerView.setAdapter(cardViewAdapter);

        return view;
    }

    public void showToolBar(String titulo, boolean botonSubir, View view){
        Toolbar toolbar = view.findViewById(R.id.toolbar);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);

        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(titulo);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(botonSubir);
    }

    //creamos la lista de imagenes
    public ArrayList<Image> buidImages(){
        ArrayList<Image> images = new ArrayList<>();

        images.add(new Image("https://a.cdn-hotels.com/gdcs/production143/d357/42fb6908-dcd5-4edb-9f8c-76208494af80.jpg", "Jose Silva", " 10 dias", "100 me gusta"));
        images.add(new Image("https://parisando.b-cdn.net/wp-content/uploads/sites/11/2022/03/la-torre-eiffel-de-paris.jpg", "Dominique", " 1 dias", "47 me gusta"));
        images.add(new Image("https://uncube.co/wp-content/uploads/2020/09/4-internet-cyber-gaming-cafe-modern-interior-design-orange-fresh-lights-wooden-ceiling.jpg", "Aline Barros", " 10 dias", "19 me gusta"));
        images.add(new Image("https://midias.correiobraziliense.com.br/_midias/png/2022/11/20/675x450/1_capturar-26884998.png", "Marcos Ribeiro", " 3 dias", "80 me gusta"));
        images.add(new Image("https://f.i.uol.com.br/fotografia/2021/11/30/163830076961a67c61e530e_1638300769_3x2_lg.jpg", "Brenda Amaral", " 4 dias", "100 me gusta"));
        images.add(new Image("https://i.superesportes.com.br/_Mm8F7jv_JZu6-oTz42T2HHtyS4=/650x0/smart/imgsapp.mg.superesportes.com.br/app/foto_126510467054/2022/11/20/14152/20221120114324776688e.jpg", "Rebeca Moliz", " 4 dias", "400 me gusta"));
        images.add(new Image("https://static-wp-tor15-prd.torcedores.com/wp-content/uploads/2019/07/brasil-x-peru.jpg", "Andre Lima", " 1 dias", "2980 me gusta"));
        images.add(new Image("https://www.lance.com.br/galerias/wp-content/uploads/2022/11/Memes-derrota-Argentina-x-Arabia-Copa-do-Mundo-15-711x474.jpg", "Juanito", " 2 dias", "800 me gusta"));
        images.add(new Image("https://g7.news/wp-content/uploads/2022/11/Arabia-Saudita-declara-feriado-apos-vitoria-surpreendente-sobre-a-Argentina-1140x570.jpg", "Al Muhammad Khalil", " 3 dias", "1579 me gusta"));
        images.add(new Image("https://www.viajenaviagem.com/wp-content/uploads/2019/10/reveilon-rio-de-janeiro-1920x640-1.jpg", "Fernando Pastor", " 6 dias", "783 me gusta"));

        return images;
    }
}