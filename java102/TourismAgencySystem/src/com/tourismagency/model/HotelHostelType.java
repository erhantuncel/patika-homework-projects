package com.tourismagency.model;

import com.tourismagency.helper.DBConnector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HotelHostelType {
    private int id;
    private int hotelId;
    private int hostelId;

    public HotelHostelType() {

    }

    public HotelHostelType(int id, int hotelId, int hostelId) {
        this.id = id;
        this.hotelId = hotelId;
        this.hostelId = hostelId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }

    public int getHostelId() {
        return hostelId;
    }

    public void setHostelId(int hostelId) {
        this.hostelId = hostelId;
    }

    public static List<HotelHostelType> getByHotelId(int hotelId) {
        ArrayList<HotelHostelType> hotelHostelTypeList = new ArrayList<>();
        HotelHostelType objectFound;
        String query = "SELECT * FROM hotels_hostel_types WHERE hotel_id = ?";
        try {
            PreparedStatement ps = DBConnector.getInstance().prepareStatement(query);
            ps.setInt(1, hotelId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                objectFound = new HotelHostelType();
                objectFound.setId(rs.getInt("id"));
                objectFound.setHotelId(rs.getInt("hotel_id"));
                objectFound.setHostelId(rs.getInt("hostel_id"));
                hotelHostelTypeList.add(objectFound);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return hotelHostelTypeList;
    }
}
