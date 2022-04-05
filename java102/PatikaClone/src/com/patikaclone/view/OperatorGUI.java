package com.patikaclone.view;

import com.patikaclone.helper.Config;
import com.patikaclone.helper.Helper;
import com.patikaclone.model.Operator;
import com.patikaclone.model.User;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class OperatorGUI extends JFrame {
    private JPanel wrapper;
    private JTabbedPane tab_operator;
    private JLabel lbl_welcome;
    private JPanel pnl_top;
    private JButton btn_logout;
    private JPanel pnl_user_list;
    private JScrollPane scrl_user_list;
    private JTable tbl_user_list;
    private DefaultTableModel mdl_user_list;
    private Object[] row_user_list;

    private final Operator operator;

    public OperatorGUI(Operator operator) {
        this.operator = operator;

        add(wrapper);
        setSize(1000, 500);
        setLocation(
                Helper.getScreenCenterPoint("x", getSize()),
                Helper.getScreenCenterPoint("y", getSize())
        );
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle(Config.PROJECT_TITLE);
        setVisible(true);

        lbl_welcome.setText("Welcome " + operator.getName());

        mdl_user_list = new DefaultTableModel();
        Object[] col_user_list = {"ID", "Name Surname", "Username", "Password", "User Type"};
        mdl_user_list.setColumnIdentifiers(col_user_list);

        int i=0;
        for (User object : User.getList()) {
            Object[] row = new Object[col_user_list.length];
            row[i++] = object.getId();
            row[i++] = object.getName();
            row[i++] = object.getUname();
            row[i++] = object.getPassword();
            row[i++] = object.getType();
            mdl_user_list.addRow(row);
        }

        tbl_user_list.setModel(mdl_user_list);
        tbl_user_list.getTableHeader().setReorderingAllowed(false);



    }

    public static void main(String[] args) {
        Helper.setLayout();
        Operator operator = new Operator();
        operator.setId(1);
        operator.setName("Ahmet ÇALIŞKAN");
        operator.setUname("ahmet");
        operator.setPassword("1234");

        OperatorGUI operatorGUI = new OperatorGUI(operator);
    }
}
