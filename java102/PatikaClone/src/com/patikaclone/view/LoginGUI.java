package com.patikaclone.view;

import com.patikaclone.helper.Config;
import com.patikaclone.helper.Helper;
import com.patikaclone.helper.MessageType;
import com.patikaclone.model.Operator;
import com.patikaclone.model.User;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginGUI extends JFrame {
    private JPanel wrapper;
    private JPanel wtop;
    private JPanel wbottom;
    private JTextField fld_user_uname;
    private JTextField fld_user_password;
    private JButton btn_login;

    public LoginGUI() {
        add(wrapper);
        setSize(400,400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle(Config.PROJECT_TITLE);
        setResizable(false);
        setVisible(true);

        btn_login.addActionListener(e -> {
            if (Helper.isFieldEmpty(fld_user_uname) || Helper.isFieldEmpty(fld_user_password)) {
                Helper.showMessage(null, MessageType.ALL_FIELDS_MUST_BE_FILLED);
            } else {
                User userFound = User.getByUnameAndPassword(fld_user_uname.getText(), fld_user_password.getText());
                if (userFound == null) {
                    Helper.showMessage("User not found!");
                } else {
                    switch (userFound.getType()) {
                        case "operator" :
                            OperatorGUI operatorGUI = new OperatorGUI((Operator) userFound);
                            break;
                        case "educator" :
                            EducatorGUI educatorGUI = new EducatorGUI();
                            break;
                        case "student":
                            StudentGUI studentGUI = new StudentGUI();
                            break;
                    }
                    dispose();
                }
            }
        });
    }

    public static void main(String[] args) {
        Helper.setLayout();
        LoginGUI loginGUI = new LoginGUI();
    }
}
