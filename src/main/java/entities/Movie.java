/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

/**
 *
 * @author tashima-utfpr
 */
public class Movie {
    private String code;
    private String title;
    private String genre;
    private String production;
    private String buyingDate;
    private Integer id;
    
    public Movie (String code, String title, String genre, String production, String buyingDate, Integer id) {
        this.code = code;
        this.title = title;
        this.genre = genre;
        this.production = production;
        this.buyingDate = buyingDate;
        this.id = id;
    }
    
    public String getCode() {
        return this.code;
    }
    public String getTitle() {
        return this.title;
    }
    public String getGenre() {
        return this.genre;
    }
    public String getProduction() {
        return this.production;
    }
    public String getBuyingDate() {
        return this.buyingDate;
    }
    public Integer getId() {
        return this.id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
}
