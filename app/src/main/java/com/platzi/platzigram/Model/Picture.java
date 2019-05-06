package com.platzi.platzigram.Model;

//Creamos el modelo POJO  Picture para asignar al cardView
public class Picture {

    //Declararemos la imagen como string, ya que vamos a recibirla a través de una url
    //Para mostrar una imagen a través de Internet
    private String picture;
    //Nombre de usuario
    private String userName;
    //Hace cuantos días se ha subido (ej. 3 días, 4 días, etc...)
    private String time;
    //La cantidad de likes que tiene
    private String like_number = "0";

    //Constructor con todos los elementos
    public Picture(String picture, String userName, String time, String like_number) {
        this.picture = picture;
        this.userName = userName;
        this.time = time;
        this.like_number = like_number;
    }

    //Setters...
    public void setPicture(String picture) {
        this.picture = picture;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setLike_number(String like_number) {
        this.like_number = like_number;
    }

    //Getters...
    public String getPicture() {
        return picture;
    }

    public String getUserName() {
        return userName;
    }

    public String getTime() {
        return time;
    }

    public String getLike_number() {
        return like_number;
    }
}
