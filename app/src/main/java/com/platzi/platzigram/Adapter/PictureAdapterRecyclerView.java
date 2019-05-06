package com.platzi.platzigram.Adapter;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.widget.RecyclerView;
import android.transition.Explode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.platzi.platzigram.Model.Picture;
import com.platzi.platzigram.R;
import com.platzi.platzigram.view.PictureDetailActivity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

//Se va a encargar de sincronizar un objeto ArrayList y de estar reciclando esas tarjetas
//Lo que va a recibir el Adapter es una colección de PictureViewHolder
public class PictureAdapterRecyclerView extends RecyclerView.Adapter<PictureAdapterRecyclerView.PictureViewHolder> {

    /*Declaración de los atributos necesarios
     * Primero, el Array que voy a manejar de Pictures
     * Segundo, el recurso que será nuestro layout, nuestro cardView_picture
     * Tercero, el Activity para pasar como parámetro
     * la actividad desde donde se está llamando esta clase "PictureAdapterRecyclerView" */
    private ArrayList<Picture> pictures;
    private int resource;
    private Activity activity;

    //Generaremos el constructor con todos los elementos
    public PictureAdapterRecyclerView(ArrayList<Picture> pictures, int resource, Activity activity) {
        this.pictures = pictures;
        this.resource = resource;
        this.activity = activity;
    }

    //Implementamos todos los métodos

    //Inicializamos nuestra clase PictureViewHolder
    @Override
    public PictureViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        //Inflamos nuestro layout, lo estamos convirtiendo en un view, cuando tan solo es xml
        //Nuestro resource será el cardview_picture.xml
        View view = LayoutInflater.from(parent.getContext()).inflate(resource, parent, false);
        /*En return haremos un new de PictureViewHolder y le pasaremos ese View que ya viene inflado,
         es decir, ya tiene asociado su recurso */
        return new PictureViewHolder(view);
    }

    /*Aquí se trabajará con toda la lista de elementos
    estaremos haciendo el paso de datos de cada objetos de la lista de pictures*/
    @Override
    public void onBindViewHolder(@NonNull PictureViewHolder holder, int i) {
        /*Vamos a recorrer todo nuestro ArrayList
        * y uno a uno va a ir poniendo 1º objeto se lo asignamos a este CardView,
        * 2º objeto a otro cardView y así sucesivamente
        * Vamos generando tarjetas con datos llenos*/
        Picture picture = pictures.get(i);

        /*A través de este objetos tendremos acceso a los views para poder rellenarlos con datos
        * o realizar acciones sobre ellos
        * utilizaremos Picasso para vtraer imágenes desde Internet*/
        holder.usernameCard.setText(picture.getUserName());
        holder.timeCard.setText(picture.getTime());
        holder.likenumberCard.setText(picture.getLike_number());
        /*La actividad será la que llame al RecyclerView, la url la obtendremos del objeto Picture
        * y el imageView de nuestro objeto holder*/
        Picasso.with(activity).load(picture.getPicture()).into(holder.pictureCard);

        /*Método Onclick de la imágen, cuando el usuario de click en la imagen de la tarjeta
        * accederemos a su perfil*/
        holder.pictureCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Creamos un nuevo intent con el activity como contexto
                * y el Activity a mostrar PictureDetailActivity.class*/
                Intent intent = new Intent(activity, PictureDetailActivity.class);
                /* Vamos a hacer la validación de la API para poder ejecutar transiciones
                * la API en la que corramos la aplicación debe ser >= Lollipop
                * para que podamos ver las transiciones*/
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
                    //Generamos un objeto de tipo transición Explode
                    Explode explode = new Explode();
                    //Le damos una duración a la transición de 1000 ms (1 segundo)
                    explode.setDuration(1000);
                    /*Tenemos que asignar la transición en el evento que está ocurriendo en la actividad
                    * En está caso como estamos en el adapter necesitamos emplear el objeto activity*/
                    activity.getWindow().setExitTransition(explode);
                    /*Ahora iniciaremos la actividad con varias valores:
                    * ejecutaremos el intent que tiene configurado a donde ir
                    * y además crearemos la escena de la transición
                    * pasándole como parámetros el contexto, el view
                    * y el nombre de la transición dependiente*/
                    activity.startActivity(intent,
                            ActivityOptionsCompat.makeSceneTransitionAnimation(activity,
                                    view, activity.getString(R.string.transitionname_picture)).toBundle());

                }
                /*Es importante definir que pasa si alguien está corriendo la aplicación en
                * una versión menor a Lollipop
                * Iniciaremos la actividad sin transición*/
                else {
                    //Llamamos al método a través del activity que está llamando a esta clase
                    activity.startActivity(intent);
                }
            }
        });

    }

    /*Devolverá el total de elementos que contenga nuestro ArrayList, para saber cuantas veces
    * hay que recorrerlo*/
    @Override
    public int getItemCount() {
        return pictures.size();
    }

    //Declaramos nuestra clase anidada Inner
    //Esta clase se va a encargar de todos los views que componen a nuestro cardview_picture
    public class PictureViewHolder extends RecyclerView.ViewHolder{

        //Definimos todos los views que componen al cardView y los declaramos private

        private ImageView pictureCard;
        private TextView usernameCard;
        private TextView timeCard;
        private TextView likenumberCard;

        //Le pasamos como parametro el layout para que encuentre en él cada view correspondiente
        public PictureViewHolder(@NonNull View itemView) {
            super(itemView);

            //Asignamos a los atributos los views del cardview a través del id
            pictureCard      = itemView.findViewById(R.id.pictureCard);
            usernameCard     = itemView.findViewById(R.id.userNameCard);
            timeCard         = itemView.findViewById(R.id.timeCard);
            likenumberCard   = itemView.findViewById(R.id.likeNumberCard);

        }
    }
}
