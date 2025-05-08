package br.com.kunden.moviescatalog.models;

import java.util.Date;

public class Movie {
    private String title;
    private Date year;
    private String genre;
    private String descricao;
    private Integer image;

    public Movie(String title, Date year, String genre, String descricao){
        this.title = title;
        this.year = year;
        this.genre = genre;
        this.descricao = descricao;
    }
}
