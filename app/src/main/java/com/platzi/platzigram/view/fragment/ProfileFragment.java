package com.platzi.platzigram.view.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.platzi.platzigram.Adapter.PictureAdapterRecyclerView;
import com.platzi.platzigram.Model.Picture;
import com.platzi.platzigram.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment {


    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        showToolbar("", false, view);
        //Instanciamos nuestro RecyclerView
        RecyclerView picturesRecycler = view.findViewById(R.id.pictureProfileRecycler);

        //Vamos a darle forma instanciando un LinearLayoutManager, pasándole el contexto.
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());

        //Le vamos a poner una orientación vertical
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        //Le asignamos a nuestro recyclerView el linearLayoutManager
        picturesRecycler.setLayoutManager(linearLayoutManager);

        //Instanciamos nuestro Adapter, pasándole las imágenes a través del método buildPictures()
        PictureAdapterRecyclerView pictureAdapterRecyclerView =
                new PictureAdapterRecyclerView(buildPictures(), R.layout.cardview_picture, getActivity());

        //Le asignamos a nuestro recyclerView el Adapter
        picturesRecycler.setAdapter(pictureAdapterRecyclerView);
        return view;
    }

    //Método que nos va a devolver un ArrayList de Picture
    public ArrayList<Picture> buildPictures(){
        //Creamos e instanciamos nuestro ArrayList
        ArrayList<Picture> pictures = new ArrayList<>();
        //Llenamos nuestro ArrayList con objetos Picture
        pictures.add(new Picture("https://k60.kn3.net/taringa/7/8/1/E/0/9/AlexHit98/E5B.jpg",
                "Alba Serrano", "4 días", "20 Me Gusta"));
        pictures.add(new Picture("https://i.pinimg.com/originals/60/a9/a3/60a9a3502224ff0fe8418503ce91b068.jpg",
                "Mikel Rivero", "6 días", "8 Me Gusta"));
        pictures.add(new Picture("https://st-listas.20minutos.es/images/2013-04/359864/list_640px.jpg?1367746528",
                "Laura Serrano", "10 días", "12 Me Gusta"));
        pictures.add(new Picture("https://www.creativosonline.org/blog/wp-content/uploads/2014/07/fotos-paisajes-playas-balsa.jpg",
                "Iñigo Fiuza", "2 días", "9 Me Gusta"));

        //Devolveremos nuestro ArrayList de Picture rellenado
        return pictures;
    }

    /*Método para mostrar el Toolbar y para ello,
     * le pasamos también el layout a través del Objeto View
     * indicándole así que en este HomeFragment encuentre el toolbar*/
    public void  showToolbar(String title, boolean upButton, View view){
        Toolbar toolbar = view.findViewById(R.id.toolbar);

        /*Como estamos trabajando con soporte tenemos que traer AppCompatActivity
         * por tanto, obtengo el Activity y lo convierto en AppCompatActivity
         * para poder dar soporte a nuestro toolbar*/
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        //Título de la vista
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(title);
        //Configuramos si el botón Up está habilitado o no
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);

    }

}
