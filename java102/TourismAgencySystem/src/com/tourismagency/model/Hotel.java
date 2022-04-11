package com.tourismagency.model;

import com.tourismagency.helper.DBConnector;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private int id;
    private String name;
    private String email;
    private String phone;
    private int starCount;
    private List<HostelType> hostelTypes;
    private List<FacilityPropery> facilityProperies;

    public Hotel(){

    }

    public Hotel(int id, String name, String email, String phone, int starCount) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.starCount = starCount;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getStarCount() {
        return starCount;
    }

    public void setStarCount(int starCount) {
        this.starCount = starCount;
    }

    public List<HostelType> getHostelTypes() {
        this.hostelTypes = new ArrayList<>();
        HotelHostelType.getByHotelId(this.id).stream().forEach(hotelhostel -> {
            hostelTypes.add(HostelType.getById(hotelhostel.getHostelId()));
        });
        return hostelTypes;
    }

    public void setHostelTypes(List<HostelType> hostelTypes) {
        this.hostelTypes = hostelTypes;
    }

    public List<FacilityPropery> getFacilityProperies() {
        facilityProperies = new ArrayList<>();
        HotelFacilityProperty.getByHotelId(this.id).stream().forEach(hotelFacility -> {
            facilityProperies.add(FacilityPropery.getById(hotelFacility.getFacilityProperyId()));
        });
        return this.facilityProperies;
    }

    public void setFacilityProperies(List<FacilityPropery> facilityProperies) {
        this.facilityProperies = facilityProperies;
    }

    public static ArrayList<Hotel> getList() {
        ArrayList<Hotel> hotelList = new ArrayList<>();
        String query = "SELECT * FROM hotels;";
        Hotel object;
        try {
            Statement statement = DBConnector.getInstance().createStatement();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                object = new Hotel();
                object.setId(rs.getInt("id"));
                object.setName(rs.getString("name"));
                object.setEmail(rs.getString("email"));
                object.setPhone(rs.getString("phone"));
                object.setStarCount(rs.getInt("star_count"));
                hotelList.add(object);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return hotelList;
    }

    public static Hotel getById(int id) {
        Hotel hotelFound = null;
        String query = "SELECT * FROM hotels WHERE id = ?";

        try {
            PreparedStatement ps = DBConnector.getInstance().prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                hotelFound = new Hotel();
                hotelFound.setId(rs.getInt("id"));
                hotelFound.setName(rs.getString("name"));
                hotelFound.setEmail(rs.getString("email"));
                hotelFound.setPhone(rs.getString("phone"));
                hotelFound.setStarCount(rs.getInt("star_count"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return hotelFound;
    }
}
