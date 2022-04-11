package com.tourismagency.model;

import com.tourismagency.helper.DBConnector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HotelFacilityProperty {
    private int id;
    private int hotelId;
    private int facilityProperyId;

    public HotelFacilityProperty() {

    }

    public HotelFacilityProperty(int id, int hotelId, int facilityProperyId) {
        this.id = id;
        this.hotelId = hotelId;
        this.facilityProperyId = facilityProperyId;
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

    public int getFacilityProperyId() {
        return facilityProperyId;
    }

    public void setFacilityProperyId(int facilityProperyId) {
        this.facilityProperyId = facilityProperyId;
    }

    public static List<HotelFacilityProperty> getByHotelId(int hotelId) {
        ArrayList<HotelFacilityProperty> hotelFacilityPropertyList = new ArrayList<>();
        HotelFacilityProperty objectFound;
        String query = "SELECT * FROM hotels_facility_properties WHERE hotel_id = ?";
        try {
            PreparedStatement ps = DBConnector.getInstance().prepareStatement(query);
            ps.setInt(1, hotelId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                objectFound = new HotelFacilityProperty();
                objectFound.setId(rs.getInt("id"));
                objectFound.setHotelId(rs.getInt("hotel_id"));
                objectFound.setFacilityProperyId(rs.getInt("facitiliy_property_id"));
                hotelFacilityPropertyList.add(objectFound);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return hotelFacilityPropertyList;
    }
}
