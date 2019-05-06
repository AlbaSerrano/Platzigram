package com.platzi.platzigram.view;

import android.os.Build;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.transition.Fade;
import android.view.View;

import com.platzi.platzigram.R;

public class PictureDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picture_detail);
        //Llamamos al método showToolbar
        showToolbar("", true);
        //Definimos una transición de entrada
        //Validamos la versión de Android
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            //Si es mayor o igual a Lollipop vamos a hacer una transición de Fade
            getWindow().setEnterTransition(new Fade());
        }
    }

    /*Método para mostrar el Toolbar y para ello,
     * le pasamos el título y si el botón de Up está habilitado o no*/
    public void  showToolbar(String title, boolean upButton){
        Toolbar toolbar = findViewById(R.id.toolbar);

        /*Damos soporte a nuestro toolbar*/
        setSupportActionBar(toolbar);
        //Título de la vista
        getSupportActionBar().setTitle(title);
        //Configuramos si el botón Up está habilitado o no
        getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);
        //Agregamos nuestro collapsing por si necesitamos utilizarlo
        CollapsingToolbarLayout collapsingToolbarLayout = findViewById(R.id.collapsingToolbar);
    }
}
