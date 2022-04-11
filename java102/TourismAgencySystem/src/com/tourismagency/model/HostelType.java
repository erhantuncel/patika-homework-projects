package com.tourismagency.model;

import com.tourismagency.helper.DBConnector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class HostelType {
    private int id;
    private String name;

    public HostelType() {

    }

    public HostelType(int id, String name) {
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

    public static HostelType getById(int id) {
        HostelType hostelTypeFound = null;
        String query = "SELECT * FROM hostel_types WHERE id = ?";

        try {
            PreparedStatement ps = DBConnector.getInstance().prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                hostelTypeFound = new HostelType();
                hostelTypeFound.setId(rs.getInt("id"));
                hostelTypeFound.setName(rs.getString("name"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return hostelTypeFound;
    }
}
