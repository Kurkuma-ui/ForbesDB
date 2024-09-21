package utils;

import java.sql.*;

import dto.CSVObject;

public class DBConnector {
    private static final String DB_URL = "jdbc:sqlite:forbes.sqlite";

    public static void createDatabase() {
        try (Connection conn = DriverManager.getConnection(DB_URL);
             Statement stmt = conn.createStatement()) {

            // Создание таблицы forbes_rating
            String sql1 = "CREATE TABLE IF NOT EXISTS forbes_rating (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "Rank INTEGER," +
                    "Name TEXT NOT NULL)";
            stmt.execute(sql1);
            System.out.println("CREATED TABLE forbes_rating");

            // Создание таблицы user_info
            String sql2 = "CREATE TABLE IF NOT EXISTS user_info (" +
                    "Name TEXT," +
                    "Age INTEGER," +
                    "Country TEXT," +
                    "Networth REAL," +
                    "Source TEXT," +
                    "PRIMARY KEY (Name, Age, Country))";
            stmt.execute(sql2);
            System.out.println("CREATED TABLE user_info");

            // Создание таблицы source_industry
            String sql3 = "CREATE TABLE IF NOT EXISTS source_industry (" +
                    "Source TEXT," +
                    "Industry TEXT," +
                    "PRIMARY KEY (Source, Industry))";
            stmt.execute(sql3);
            System.out.println("CREATED TABLE source_industry");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void writeToDB(CSVObject csvObject) {
        String insertForbesRating = "INSERT INTO forbes_rating (Rank, Name) VALUES (?, ?)";
        String insertUserInfo = "INSERT INTO user_info (Name, Age, Country, Networth, Source) VALUES (?, ?, ?, ?, ?)";
        String insertSourceIndustry = "INSERT OR IGNORE INTO source_industry (Source, Industry) VALUES (?, ?)";

        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement pstmtForbes = conn.prepareStatement(insertForbesRating);
             PreparedStatement pstmtUserInfo = conn.prepareStatement(insertUserInfo);
             PreparedStatement pstmtSourceIndustry = conn.prepareStatement(insertSourceIndustry)) {

            // Вставка данных в таблицу forbes_rating
            pstmtForbes.setInt(1, csvObject.getRank());
            pstmtForbes.setString(2, csvObject.getName());
            pstmtForbes.executeUpdate();

            // Вставка данных в таблицу user_info
            pstmtUserInfo.setString(1, csvObject.getName());
            pstmtUserInfo.setInt(2, csvObject.getAge());
            pstmtUserInfo.setString(3, csvObject.getCountry());
            pstmtUserInfo.setDouble(4, csvObject.getNetworth());
            pstmtUserInfo.setString(5, csvObject.getSource());
            pstmtUserInfo.executeUpdate();

            // Вставка данных в таблицу source_industry
            pstmtSourceIndustry.setString(1, csvObject.getSource());
            pstmtSourceIndustry.setString(2, csvObject.getIndustry());
            pstmtSourceIndustry.executeUpdate();

        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.getMessage());
        }
    }
}

