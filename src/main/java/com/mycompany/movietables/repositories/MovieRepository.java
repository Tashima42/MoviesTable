/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.movietables.repositories;

import com.mycompany.movietables.entities.Movie;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author tashima-utfpr
 */
public class MovieRepository {

    private final Connection conn;

    public MovieRepository() {
        this.conn = Connect.connect();
    }

    public ArrayList<Movie> getAll() {
        String sql = "SELECT id, code, title, genre, production, buying_date FROM movie";

        ArrayList<Movie> movies = new ArrayList<>();
        try ( PreparedStatement ptsmt = this.conn.prepareStatement(sql)) {
            ResultSet res = ptsmt.executeQuery();

            while (res.next()) {
                Integer id = res.getInt("id");
                String code = res.getString("code");
                String title = res.getString("title");
                String genre = res.getString("genre");
                String production = res.getString("production");
                String buyingDate = res.getString("buying_date");

                Movie movie = new Movie(code, title, genre, production, buyingDate, id);
                movies.add(movie);
            }
            return movies;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new Error("Failed to get movies");
        }
    }

    public void add(Movie movie) {
        String sql = """
                     INSERT INTO movie
                          (code, title, genre, production, buying_date)
                          VALUES (?, ?, ?, ?, ?);""";

        try ( PreparedStatement pstmt = this.conn.prepareStatement(sql)) {
            pstmt.setString(1, movie.getCode());
            pstmt.setString(2, movie.getTitle());
            pstmt.setString(3, movie.getGenre());
            pstmt.setString(4, movie.getProduction());
            pstmt.setString(5, movie.getBuyingDate());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to add movie");
        }
    }

    public void remove(Integer id) {
        String sql = "DELETE FROM movie WHERE id = ?";
        try ( PreparedStatement pstmt = this.conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);

            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to remove movie");
        }
    }

    public void update(Movie movie) {
        String sql = "UPDATE movie"
                + "     SET"
                + "     code = ?,"
                + "     title = ?,"
                + "     genre = ?,"
                + "     production = ?,"
                + "     buying_date = ?"
                + "     WHERE id = ?;";

        try ( PreparedStatement ptsmt = this.conn.prepareStatement(sql)) {
            ptsmt.setString(1, movie.getCode());
            ptsmt.setString(2, movie.getTitle());
            ptsmt.setString(3, movie.getGenre());
            ptsmt.setString(4, movie.getProduction());
            ptsmt.setString(5, movie.getBuyingDate());
            ptsmt.setInt(6, movie.getId());

            ptsmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new Error("Failed to update movie");
        }
    }
}
