package br.com.kunden.moviescatalog.models;

import java.util.Date;

public class Movie {
    private String title;
    private String year;
    private String genre;
    private String descricao;
    private Integer image;

    public String getTitle() {
        return title;
    }

    public String getYear() {
        return year;
    }

    public String getGenre() {
        return genre;
    }

    public String getDescricao() {
        return descricao;
    }

    public Integer getImage() {
        return image;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setImage(Integer image) {
        this.image = image;
    }

    public Movie(String title, String year, String genre, String descricao){
        this.title = title;
        this.year = year;
        this.genre = genre;
        this.descricao = descricao;
    }
}
