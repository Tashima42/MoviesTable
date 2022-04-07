/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.movietables.repositories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author tashima-utfpr
 */
public class Connect {

    static Connection conn;

    public static final Connection connect() {
        if (Connect.conn != null) {
            return Connect.conn;
        } else {
            String url = "jdbc:sqlite:" + System.getProperty("user.dir") + "/database.db";
            try {
                Connection conn = DriverManager.getConnection(url);
                Connect.conn = conn;
                return Connect.conn;
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
        return null;
    }
    
        public static void prepare(Connection conn, Boolean dropTables, Boolean migrate, Boolean populate) {
        if (dropTables) {
            Connect.dropAllTables(conn);
        }
        
        if (migrate) {
            System.out.println("STARTED MIGRATIONS");
            Connect.migrate(conn);
            System.out.println("FINISHED MIGRATIONS");
        }
        if (populate) {
            System.out.println("STARTED POPULATION");
            Connect.populate(conn);
            System.out.println("FINISHED POPULATION");
        }
    }

    public static void migrate(Connection conn) {
        Connect.migrateMovie(conn);
    }

    public static void populate(Connection conn) {
        Connect.populateMovie(conn);
    }

    private static void dropAllTables(Connection conn) {
        try ( Statement stmt = conn.createStatement()) {
            stmt.execute("DROP TABLE movie;");
                 System.out.println("Droped all tables");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void migrateMovie(Connection conn) {
        String sql = """
                     CREATE TABLE IF NOT EXISTS movie(
                          id integer PRIMARY KEY,
                          code text NOT NULL,
                          title text NOT NULL,
                          genre text NOT NULL,
                          production text NOT NULL,
                          buying_date text NOT NULL
                     );""";
        try ( Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Migrated movie");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void populateMovie(Connection conn) {
        String sql = """
                     INSERT INTO movie (code, title, genre, production, buying_date)
                          VALUES (?, ?, ?, ?, ?), (?, ?, ?, ?, ?), (?, ?, ?, ?, ?), (?, ?, ?, ?, ?), (?, ?, ?, ?, ?),
                            (?, ?, ?, ?, ?), (?, ?, ?, ?, ?), (?, ?, ?, ?, ?), (?, ?, ?, ?, ?), (?, ?, ?, ?, ?),
                            (?, ?, ?, ?, ?), (?, ?, ?, ?, ?), (?, ?, ?, ?, ?), (?, ?, ?, ?, ?), (?, ?, ?, ?, ?),
                            (?, ?, ?, ?, ?), (?, ?, ?, ?, ?), (?, ?, ?, ?, ?), (?, ?, ?, ?, ?),(?, ?, ?, ?, ?);""";

        try ( PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, "000001");
            pstmt.setString(2, "Avatar");
            pstmt.setString(3, "Action");
            pstmt.setString(4, "20th Century Fox");
            pstmt.setString(5, "2022-04-06");

            pstmt.setString(6, "000002");
            pstmt.setString(7, "Avengers: Endgame");
            pstmt.setString(8, "Action");
            pstmt.setString(9, "20th Century Fox");
            pstmt.setString(10, "2022-04-06");

            pstmt.setString(11, "000003");
            pstmt.setString(12, "Titanic");
            pstmt.setString(13, "Action");
            pstmt.setString(14, "20th Century Fox");
            pstmt.setString(15, "2022-04-06");

            pstmt.setString(16, "000004");
            pstmt.setString(17, "Star Wars: The Force Awakens");
            pstmt.setString(18, "Action");
            pstmt.setString(19, "20th Century Fox");
            pstmt.setString(20, "2022-04-06");

            pstmt.setString(21, "000005");
            pstmt.setString(22, "Avengers: Infinity War");
            pstmt.setString(23, "Action");
            pstmt.setString(24, "20th Century Fox");
            pstmt.setString(25, "2022-04-06");

            pstmt.setString(26, "000006");
            pstmt.setString(27, "Spider-Man: No Way Home");
            pstmt.setString(28, "Action");
            pstmt.setString(29, "20th Century Fox");
            pstmt.setString(30, "2022-04-06");

            pstmt.setString(31, "000007");
            pstmt.setString(32, "Jurassic World");
            pstmt.setString(33, "Action");
            pstmt.setString(34, "20th Century Fox");
            pstmt.setString(35, "2022-04-06");

            pstmt.setString(36, "000008");
            pstmt.setString(37, "The Lion King");
            pstmt.setString(38, "Action");
            pstmt.setString(39, "20th Century Fox");
            pstmt.setString(40, "2022-04-06");

            pstmt.setString(41, "000009");
            pstmt.setString(42, "The Avengers");
            pstmt.setString(43, "Action");
            pstmt.setString(44, "20th Century Fox");
            pstmt.setString(45, "2022-04-06");
            
            pstmt.setString(46, "000010");
            pstmt.setString(47, "Furious 7");
            pstmt.setString(48, "Action");
            pstmt.setString(49, "20th Century Fox");
            pstmt.setString(50, "2022-04-06");

            pstmt.setString(51, "000011");
            pstmt.setString(52, "Frozen II");
            pstmt.setString(53, "Action");
            pstmt.setString(54, "20th Century Fox");
            pstmt.setString(55, "2022-04-06");

            pstmt.setString(56, "000012");
            pstmt.setString(57, "Avengers: Age of Ultron");
            pstmt.setString(58, "Action");
            pstmt.setString(59, "20th Century Fox");
            pstmt.setString(60, "2022-04-06");

            pstmt.setString(61, "000013");
            pstmt.setString(62, "Black Panther");
            pstmt.setString(63, "Action");
            pstmt.setString(64, "20th Century Fox");
            pstmt.setString(65, "2022-04-06");

            pstmt.setString(66, "000014");
            pstmt.setString(67, "Harry Potter and the Deathly Hallows – Part 2");
            pstmt.setString(68, "Action");
            pstmt.setString(69, "20th Century Fox");
            pstmt.setString(70, "2022-04-06");

            pstmt.setString(71, "000015");
            pstmt.setString(72, "Star Wars: The Last Jedi");
            pstmt.setString(73, "Action");
            pstmt.setString(74, "20th Century Fox");
            pstmt.setString(75, "2022-04-06");

            pstmt.setString(76, "000016");
            pstmt.setString(77, "Jurassic World: Fallen Kingdom");
            pstmt.setString(78, "Action");
            pstmt.setString(79, "20th Century Fox");
            pstmt.setString(80, "2022-04-06");

            pstmt.setString(81, "000017");
            pstmt.setString(82, "Frozen");
            pstmt.setString(83, "Action");
            pstmt.setString(84, "20th Century Fox");
            pstmt.setString(85, "2022-04-06");

            pstmt.setString(86, "000018");
            pstmt.setString(87, "Beauty and the Beast");
            pstmt.setString(88, "Action");
            pstmt.setString(89, "20th Century Fox");
            pstmt.setString(90, "2022-04-06");
            
            pstmt.setString(91, "000019");
            pstmt.setString(92, "Incredibles 2");
            pstmt.setString(93, "Action");
            pstmt.setString(94, "20th Century Fox");
            pstmt.setString(95, "2022-04-06");
            
            pstmt.setString(96, "000020");
            pstmt.setString(97, "The Fate of the Furious");
            pstmt.setString(98, "Action");
            pstmt.setString(99, "20th Century Fox");
            pstmt.setString(100, "2022-04-06");

            pstmt.executeUpdate();
            System.out.println("Populated movie");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String args[]) {
        Connection connection = Connect.connect();
        Connect.prepare(connection, Boolean.TRUE, Boolean.TRUE, Boolean.TRUE);
    }
}
