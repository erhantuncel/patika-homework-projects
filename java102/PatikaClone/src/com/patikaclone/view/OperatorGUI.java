package com.patikaclone.view;

import com.patikaclone.helper.*;
import com.patikaclone.model.Course;
import com.patikaclone.model.Operator;
import com.patikaclone.model.User;
import com.patikaclone.model.Patika;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.util.List;

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
    private JTextField fld_search_user_name;
    private JTextField fld_search_user_username;
    private JComboBox cmb_search_user_type;
    private JButton btn_user_search;
    private JPanel pnl_patika_list;
    private JScrollPane scrl_patika_list;
    private JTable tbl_patika_list;
    private JTextField fld_patika_name;
    private JButton btn_patika_add;
    private JPanel pnl_course_list;
    private JScrollPane scrl_course_list;
    private JTable tbl_course_list;
    private JPanel pnl_course_add;
    private JTextField fld_course_name;
    private JTextField fld_course_language;
    private JComboBox cmb_course_patika;
    private JComboBox cmb_course_user;
    private JButton btn_course_add;
    private DefaultTableModel mdl_user_list;
    private Object[] row_user_list;
    private DefaultTableModel mdl_patika_list;
    private Object[] row_patika_list;
    private JPopupMenu patikaMenu;
    private DefaultTableModel mdl_course_list;
    private Object[] row_course_list;

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

        tbl_user_list.getModel().addTableModelListener(e -> {
            if (e.getType() == TableModelEvent.UPDATE) {
                int user_id = Integer.parseInt(tbl_user_list.getValueAt(tbl_user_list.getSelectedRow(), 0).toString());
                String user_name = tbl_user_list.getValueAt(tbl_user_list.getSelectedRow(), 1).toString();
                String user_uname = tbl_user_list.getValueAt(tbl_user_list.getSelectedRow(), 2).toString();
                String user_password = tbl_user_list.getValueAt(tbl_user_list.getSelectedRow(), 3).toString();
                String user_type = tbl_user_list.getValueAt(tbl_user_list.getSelectedRow(), 4).toString();

                if (User.update(user_id, user_name, user_uname, user_password, user_type)) {
                    Helper.showMessage(null, MessageType.SUBMIT_SUCCESSFULLY);
                }

                populateUserModel();
                populateCourseModel();
            }
        });

        patikaMenu = new JPopupMenu();
        JMenuItem updateMenu = new JMenuItem("Update");
        JMenuItem removeMenu = new JMenuItem("Remove");
        patikaMenu.add(updateMenu);
        patikaMenu.add(removeMenu);

        updateMenu.addActionListener(e -> {
            int selected_id = Integer.parseInt(tbl_patika_list.getValueAt(tbl_patika_list.getSelectedRow(), 0).toString());
            UpdatePatikaGUI updatePatikaGUI = new UpdatePatikaGUI(Patika.getById(selected_id));
            updatePatikaGUI.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    populatePatikaModel();
                    populateCourseModel();
                }
            });
        });

        removeMenu.addActionListener(e -> {
            if (Helper.confirm(DialogType.SURE)) {
                int selected_id = Integer.parseInt(tbl_patika_list.getValueAt(tbl_patika_list.getSelectedRow(), 0).toString());
                if (Patika.remove(selected_id)) {
                    Helper.showMessage(null, MessageType.SUBMIT_SUCCESSFULLY);
                    populatePatikaModel();
                    populateCourseModel();
                } else {
                    Helper.showMessage(null, MessageType.SUBMIT_WITH_ERROR);
                }
            }
        });


        mdl_patika_list = new DefaultTableModel();
        Object[] col_patika_list = {"Id", "Patika Name"};
        mdl_patika_list.setColumnIdentifiers(col_patika_list);
        row_patika_list = new Object[col_patika_list.length];
        populatePatikaModel();

        tbl_patika_list.setModel(mdl_patika_list);
        tbl_patika_list.setComponentPopupMenu(patikaMenu);
        tbl_patika_list.getTableHeader().setReorderingAllowed(false);
        tbl_patika_list.getColumnModel().getColumn(0).setMaxWidth(75);

        tbl_patika_list.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int selected_row = tbl_patika_list.rowAtPoint(e.getPoint());
                tbl_patika_list.setRowSelectionInterval(selected_row, selected_row);
            }
        });

        mdl_course_list = new DefaultTableModel();
        Object[] col_course_list = {"Id", "Course Name", "Language", "Patika", "Educator"};
        mdl_course_list.setColumnIdentifiers(col_course_list);
        row_course_list = new Object[col_course_list.length];
        populateCourseModel();
        tbl_course_list.setModel(mdl_course_list);
        tbl_course_list.getColumnModel().getColumn(0).setMaxWidth(75);
        tbl_course_list.getTableHeader().setReorderingAllowed(false);
        populatePatikaCombobox();
        populateEducatorCombobox();

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
                    populateCourseModel();
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
                if (Helper.confirm(DialogType.SURE)) {
                    int id = Integer.parseInt(fld_user_id.getText());
                    if(User.remove(id)) {
                        Helper.showMessage(null, MessageType.SUBMIT_SUCCESSFULLY);
                        populateUserModel();
                        populateCourseModel();
                    } else {
                        Helper.showMessage(null, MessageType.SUBMIT_WITH_ERROR);
                    }
                }
            }
        });

        btn_user_search.addActionListener(e -> {
            String name = fld_search_user_name.getText();
            String uname = fld_search_user_username.getText();
            String type = cmb_search_user_type.getSelectedItem().toString();
            String query = User.createSearchQuery(name, uname, type);
            populateUserModel(User.searchUserList(query));

        });

        btn_logout.addActionListener(e -> {
            dispose();
            LoginGUI loginGUI = new LoginGUI();
        });

        btn_patika_add.addActionListener(e -> {
            if (Helper.isFieldEmpty(fld_patika_name)) {
                Helper.showMessage(null, MessageType.ALL_FIELDS_MUST_BE_FILLED);
            } else {
                if (Patika.add(fld_patika_name.getText())) {
                    Helper.showMessage(null, MessageType.SUBMIT_SUCCESSFULLY);
                    populatePatikaModel();
                    fld_patika_name.setText(null);
                } else {
                    Helper.showMessage(null, MessageType.SUBMIT_WITH_ERROR);
                }
            }
        });

        btn_course_add.addActionListener(e -> {
            Item selectedPatikaItem = (Item) cmb_course_patika.getSelectedItem();
            Item selectedUserItem = (Item) cmb_course_user.getSelectedItem();
            if (Helper.isFieldEmpty(fld_course_name) || Helper.isFieldEmpty(fld_course_language)) {
                Helper.showMessage(null, MessageType.ALL_FIELDS_MUST_BE_FILLED);
            } else {
                if (Course.add(selectedUserItem.getKey(), selectedPatikaItem.getKey(), fld_course_name.getText(), fld_course_language.getText())) {
                    Helper.showMessage(null, MessageType.SUBMIT_SUCCESSFULLY);
                    populateCourseModel();
                    fld_course_name.setText(null);
                    fld_course_language.setText(null);
                } else {
                    Helper.showMessage(null, MessageType.SUBMIT_WITH_ERROR);
                }
            }

        });
    }

    private void populateCourseModel() {
        DefaultTableModel cleanModel = (DefaultTableModel) tbl_course_list.getModel();
        cleanModel.setRowCount(0);

        Course.getList().stream().forEach(c -> {
            row_course_list[0] = c.getId();
            row_course_list[1] = c.getName();
            row_course_list[2] = c.getLanguage();
            row_course_list[3] = c.getPatika().getName();
            row_course_list[4] = c.getUser().getName();
            mdl_course_list.addRow(row_course_list);
        });
    }

    private void populatePatikaModel() {
        DefaultTableModel cleanModel = (DefaultTableModel) tbl_patika_list.getModel();
        cleanModel.setRowCount(0);

        Patika.getList().stream().forEach(p -> {
            row_patika_list[0] = p.getId();
            row_patika_list[1] = p.getName();
            mdl_patika_list.addRow(row_patika_list);
        });
        populatePatikaCombobox();
    }

    public void populateUserModel() {
        DefaultTableModel cleanModel = (DefaultTableModel) tbl_user_list.getModel();
        cleanModel.setRowCount(0);

        User.getList().stream().forEach(u -> {

            row_user_list[0] = u.getId();
            row_user_list[1] = u.getName();
            row_user_list[2] = u.getUname();
            row_user_list[3] = u.getPassword();
            row_user_list[4] = u.getType();
            mdl_user_list.addRow(row_user_list);
        });
        populateEducatorCombobox();
    }

    public void populateUserModel(List<User> userList) {
        DefaultTableModel cleanModel = (DefaultTableModel) tbl_user_list.getModel();
        cleanModel.setRowCount(0);

        userList.stream().forEach(u -> {
            row_user_list[0] = u.getId();
            row_user_list[1] = u.getName();
            row_user_list[2] = u.getUname();
            row_user_list[3] = u.getPassword();
            row_user_list[4] = u.getType();
            mdl_user_list.addRow(row_user_list);
        });
    }

    public void  populatePatikaCombobox() {
        cmb_course_patika.removeAllItems();
        Patika.getList().stream().forEach(p -> {
            cmb_course_patika.addItem(new Item(p.getId(), p.getName()));
        });
    }

    public void populateEducatorCombobox() {
        cmb_course_user.removeAllItems();
        User.getList().stream().filter(u -> u.getType().equals("educator")).forEach(e -> {
            cmb_course_user.addItem(new Item(e.getId(), e.getName()));
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
