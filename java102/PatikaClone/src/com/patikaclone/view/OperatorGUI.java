package com.patikaclone.view;

import com.patikaclone.helper.Config;
import com.patikaclone.helper.Helper;
import com.patikaclone.helper.MessageType;
import com.patikaclone.model.Operator;
import com.patikaclone.model.User;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OperatorGUI extends JFrame {
    private JPanel wrapper;
    private JTabbedPane tab_operator;
    private JLabel lbl_welcome;
    private JPanel pnl_top;
    private JButton btn_logout;
    private JPanel pnl_user_list;
    private JScrollPane scrl_user_list;
    private JTable tbl_user_list;
    private JPanel pnl_user_form;
    private JTextField fld_user_name;
    private JTextField fld_user_uname;
    private JTextField fld_user_password;
    private JComboBox cmb_user_type;
    private JButton btn_user_add;
    private JTextField fld_user_id;
    private JButton btn_user_remove;
    private DefaultTableModel mdl_user_list;
    private Object[] row_user_list;

    private final Operator operator;

    public OperatorGUI(Operator operator) {
        this.operator = operator;
        add(wrapper);
        setSize(1000, 500);
        setLocationRelativeTo(null);
//        setLocation(
//                Helper.getScreenCenterPoint("x", getSize()),
//                Helper.getScreenCenterPoint("y", getSize())
//        );
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle(Config.PROJECT_TITLE);
        setVisible(true);

        lbl_welcome.setText("Welcome " + operator.getName());

        mdl_user_list = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                if (column == 0) {
                    return false;
                }
                return super.isCellEditable(row, column);
            }
        };
        Object[] col_user_list = {"ID", "Name Surname", "Username", "Password", "User Type"};
        mdl_user_list.setColumnIdentifiers(col_user_list);
        row_user_list = new Object[col_user_list.length];
        populateUserModel();

        tbl_user_list.setModel(mdl_user_list);
        tbl_user_list.getTableHeader().setReorderingAllowed(false);

        tbl_user_list.getSelectionModel().addListSelectionListener(e -> {
            try {
                String selected_user_id = tbl_user_list.getValueAt(tbl_user_list.getSelectedRow(), 0).toString();
                fld_user_id.setText(selected_user_id);
            } catch (Exception exception) {
                System.out.println(exception.getMessage());
            }
        });

        btn_user_add.addActionListener(e -> {
            if (Helper.isFieldEmpty(fld_user_name) || Helper.isFieldEmpty(fld_user_uname) || Helper.isFieldEmpty(fld_user_password)) {
                Helper.showMessage(null, MessageType.ALL_FIELDS_MUST_BE_FILLED);
            } else {
                String name = fld_user_name.getText();
                String uname = fld_user_uname.getText();
                String password = fld_user_password.getText();
                String type = cmb_user_type.getSelectedItem().toString();
                if (User.add(name, uname, password, type)) {
                    Helper.showMessage(null, MessageType.SUBMIT_SUCCESSFULLY);
                    populateUserModel();
                    fld_user_name.setText(null);
                    fld_user_uname.setText(null);
                    fld_user_password.setText(null);
                }
            }
        });

        btn_user_remove.addActionListener(e -> {
            if (Helper.isFieldEmpty(fld_user_id)) {
                Helper.showMessage(null, MessageType.ALL_FIELDS_MUST_BE_FILLED);
            } else {
                int id = Integer.parseInt(fld_user_id.getText());
                if(User.remove(id)) {
                    Helper.showMessage(null, MessageType.SUBMIT_SUCCESSFULLY);
                    populateUserModel();
                } else {
                    Helper.showMessage(null, MessageType.SUBMIT_WITH_ERROR);
                }
            }
        });
    }

    public void populateUserModel() {
        DefaultTableModel cleanModel = (DefaultTableModel) tbl_user_list.getModel();
        cleanModel.setRowCount(0);

        User.getList().stream().forEach(u -> {
            int i = 0;
            row_user_list[i++] = u.getId();
            row_user_list[i++] = u.getName();
            row_user_list[i++] = u.getUname();
            row_user_list[i++] = u.getPassword();
            row_user_list[i++] = u.getType();
            mdl_user_list.addRow(row_user_list);
        });
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
