package com.tourismagency.model;

import com.tourismagency.helper.DBConnector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FacilityPropery {
    private int id;
    private String name;

    public FacilityPropery() {

    }

    public FacilityPropery(int id, String name) {
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

    public static FacilityPropery getById(int id) {
        FacilityPropery facilityProperyFound = null;
        String query = "SELECT * FROM facility_properties WHERE id = ?";

        try {
            PreparedStatement ps = DBConnector.getInstance().prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                facilityProperyFound = new FacilityPropery();
                facilityProperyFound.setId(rs.getInt("id"));
                facilityProperyFound.setName(rs.getString("name"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return facilityProperyFound;
    }
}
