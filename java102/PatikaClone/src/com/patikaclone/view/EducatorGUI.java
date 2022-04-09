package com.patikaclone.view;

import com.patikaclone.helper.Config;

import javax.swing.*;

public class EducatorGUI extends JFrame {
    private JPanel wrapper;

    public EducatorGUI() {
        add(wrapper);
        setSize(400,400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle(Config.PROJECT_TITLE);
        setResizable(false);
        setVisible(true);
    }
}
