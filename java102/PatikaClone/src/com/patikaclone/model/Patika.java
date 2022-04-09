package com.patikaclone.model;

import com.patikaclone.helper.DBConnector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Patika {
    private int id;
    private String name;

    public Patika(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static ArrayList<Patika> getList() {
        ArrayList<Patika> patikaList = new ArrayList<>();
        String query = "SELECT * FROM patikas;";
        Patika object;
        try {
            Statement st = DBConnector.getInstance().createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                object = new Patika(rs.getInt("id"), rs.getString("name"));
                patikaList.add(object);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return patikaList;
    }

    public static boolean add(String name) {
        String query = "INSERT INTO patikas (name) VALUES (?);";
        try {
            PreparedStatement preparedStatement = DBConnector.getInstance().prepareStatement(query);
            preparedStatement.setString(1, name);
            int result = preparedStatement.executeUpdate();
            return result != -1;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return true;
    }

    public static boolean update(int id, String name) {
        String query = "UPDATE patikas SET name=? WHERE id=?";
        try {
            PreparedStatement preparedStatement = DBConnector.getInstance().prepareStatement(query);
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, id);
            int result = preparedStatement.executeUpdate();
            return result != -1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    public static Patika getById(int id) {
        Patika patikaFound = null;
        String query = "SELECT * FROM patikas WHERE id = ?";
        try {
            PreparedStatement preparedStatement = DBConnector.getInstance().prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                patikaFound = new Patika(id, rs.getString("name"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return patikaFound;
    }

    public static boolean remove(int id) {
        String query = "DELETE FROM patikas WHERE id = ?";
        ArrayList<Course> courseList = Course.getList();
        courseList.stream().filter(cl -> cl.getPatika().getId() == id).forEach(c -> {
            Course.remove(c.getId());
        });

        try {
            PreparedStatement preparedStatement = DBConnector.getInstance().prepareStatement(query);
            preparedStatement.setInt(1, id);
            int result = preparedStatement.executeUpdate();
            return result != -1;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return true;
    }
}
