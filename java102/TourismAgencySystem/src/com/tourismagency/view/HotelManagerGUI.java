package com.tourismagency.view;

import com.tourismagency.helper.Config;
import com.tourismagency.model.Hotel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class HotelManagerGUI extends JFrame {
    private JPanel wrapper;
    private JPanel pnl_top;
    private JButton btn_logout;
    private JTabbedPane tabbedPane1;
    private JPanel pnl_hotel_list;
    private JScrollPane scrl_hotel_list;
    private JTable tbl_hotel_list;
    private JButton btn_hotels_add;
    private JPanel pnl_hotel_operations;
    private DefaultTableModel mdl_hotel_list;
    private Object[] row_hotel_list;

    public HotelManagerGUI() {
        add(wrapper);
        setSize(900, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle(Config.PROJECT_TITLE);
        setVisible(true);

        mdl_hotel_list = new DefaultTableModel();
        Object[] col_hotel_list = {"Id", "Name", "E-mail", "Phone", "Star Count"};
        mdl_hotel_list.setColumnIdentifiers(col_hotel_list);
        row_hotel_list = new Object[col_hotel_list.length];
        tbl_hotel_list.setModel(mdl_hotel_list);
        populateHotelModel();

        btn_logout.addActionListener(e -> {
            dispose();
        });
    }

    public void populateHotelModel() {
        DefaultTableModel cleanModel = (DefaultTableModel) tbl_hotel_list.getModel();
        cleanModel.setRowCount(0);

        Hotel.getList().stream().forEach(h -> {
            row_hotel_list[0] = h.getId();
            row_hotel_list[1] = h.getName();
            row_hotel_list[2] = h.getEmail();
            row_hotel_list[3] = h.getPhone();
            row_hotel_list[4] = h.getStarCount();
            mdl_hotel_list.addRow(row_hotel_list);
        });
    }

}
