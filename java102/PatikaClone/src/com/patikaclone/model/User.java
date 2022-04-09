package com.patikaclone.model;

import com.patikaclone.helper.DBConnector;
import com.patikaclone.helper.Helper;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class User {

    private int id;
    private String name;
    private String uname;
    private String password;
    private String type;

    public User() {
    }

    public User(int id, String name, String uname, String password, String type) {
        this.id = id;
        this.name = name;
        this.uname = uname;
        this.password = password;
        this.type = type;
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

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public static ArrayList<User> getList() {
        ArrayList<User> userList = new ArrayList<>();
        String query = "SELECT * FROM users;";
        User object;
        try {
            Statement st = DBConnector.getInstance().createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                object = new User();
                object.setId(rs.getInt("id"));
                object.setName(rs.getString("name"));
                object.setUname(rs.getString("uname"));
                object.setPassword(rs.getString("password"));
                object.setType(rs.getString("type"));
                userList.add(object);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }

    public static boolean add(String name, String uname, String password, String type) {
        String query = "INSERT INTO users(name, uname, password, type) VALUES (?, ?, ?, CAST(? AS user_type))";
        User userFound = getByUname(uname);
        if(userFound != null) {
            Helper.showMessage("There is a user has same username with " + uname);
            return false;
        }
        try {
            PreparedStatement preparedStatement = DBConnector.getInstance().prepareStatement(query);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, uname);
            preparedStatement.setString(3, password);
            preparedStatement.setString(4, type);
            int result = preparedStatement.executeUpdate();
            return result != -1;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return true;
    }

    public static User getByUname(String uname) {
        User userFound = null;
        String query = "SELECT * FROM users WHERE uname = ?";
        try {
            PreparedStatement preparedStatement = DBConnector.getInstance().prepareStatement(query);
            preparedStatement.setString(1, uname);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                userFound = new User();
                userFound.setId(rs.getInt("id"));
                userFound.setName(rs.getString("name"));
                userFound.setUname(rs.getString("uname"));
                userFound.setPassword(rs.getString("password"));
                userFound.setType(rs.getString("type"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return userFound;
    }

    public static User getById(int id) {
        User userFound = null;
        String query = "SELECT * FROM users WHERE id = ?";
        try {
            PreparedStatement preparedStatement = DBConnector.getInstance().prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                userFound = new User();
                userFound.setId(rs.getInt("id"));
                userFound.setName(rs.getString("name"));
                userFound.setUname(rs.getString("uname"));
                userFound.setPassword(rs.getString("password"));
                userFound.setType(rs.getString("type"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return userFound;
    }

    public static User getByUnameAndPassword(String uname, String password) {
        User userFound = null;
        String query = "SELECT * FROM users WHERE uname = ? AND password = ?";
        try {
            PreparedStatement preparedStatement = DBConnector.getInstance().prepareStatement(query);
            preparedStatement.setString(1, uname);
            preparedStatement.setString(2, password);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
//                userFound = new User();
                switch (rs.getString("type")) {
                    case "operator":
                        userFound = new Operator();
                        break;
                    default:
                        userFound = new User();
                }
                userFound.setId(rs.getInt("id"));
                userFound.setName(rs.getString("name"));
                userFound.setUname(rs.getString("uname"));
                userFound.setPassword(rs.getString("password"));
                userFound.setType(rs.getString("type"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return userFound;
    }

    public static boolean remove(int id) {
        String query = "DELETE FROM users WHERE id = ?";
        ArrayList<Course> courseList = Course.getListByUser(id);
        courseList.stream().forEach(cL -> {
            Course.remove(cL.getId());
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

    public static boolean update(int id, String name, String uname, String password, String type) {
        String query = "UPDATE users SET name=?, uname=?, password=?, type=CAST(? AS user_type) WHERE id=?";
        User userFound = getByUname(uname);
        if(userFound != null && userFound.getId() != id) {
            Helper.showMessage("There is a user has same username with " + uname);
            return false;
        }
        // TODO: Check user types before update database
        try {
            PreparedStatement preparedStatement = DBConnector.getInstance().prepareStatement(query);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, uname);
            preparedStatement.setString(3, password);
            preparedStatement.setString(4, type);
            preparedStatement.setInt(5, id);
            int result = preparedStatement.executeUpdate();
            return result != -1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    public static List<User> searchUserList(String query) {
        ArrayList<User> userList = new ArrayList<>();
        User object;
        try {
            Statement st = DBConnector.getInstance().createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                object = new User();
                object.setId(rs.getInt("id"));
                object.setName(rs.getString("name"));
                object.setUname(rs.getString("uname"));
                object.setPassword(rs.getString("password"));
                object.setType(rs.getString("type"));
                userList.add(object);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }

    public static String createSearchQuery(String name, String uname, String type) {
        String query = "SELECT * FROM users WHERE uname ILIKE '%{{uname}}%' AND name ILIKE '%{{name}}%'";
        if (!type.isEmpty()) {
            query = query + " AND type='{{type}}'::user_type";
            query = query.replace("{{type}}", type);
        }
        query = query.replace("{{uname}}", uname);
        query = query.replace("{{name}}", name);
        return query;
    }
}
