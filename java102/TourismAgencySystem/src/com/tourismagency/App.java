package com.tourismagency;

import com.tourismagency.helper.Helper;
import com.tourismagency.view.HotelManagerGUI;

public class App {

    public static void main(String[] args) {
        Helper.setLayout();
        HotelManagerGUI hotelManagerGUI = new HotelManagerGUI();
    }
}
