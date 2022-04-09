package com.patikaclone.view;

import com.patikaclone.helper.Config;

import javax.swing.*;

public class StudentGUI extends JFrame {
    private JPanel wrapper;

    public StudentGUI() {
        add(wrapper);
        setSize(400,400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle(Config.PROJECT_TITLE);
        setResizable(false);
        setVisible(true);
    }
}
