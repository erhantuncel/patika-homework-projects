package com.patikaclone.helper;

import javax.swing.*;
import java.awt.*;

public class Helper {

    public static void setLayout() {
        for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
            if("Nimbus".equalsIgnoreCase(info.getName())) {
                try {
                    UIManager.setLookAndFeel(info.getClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
                    e.printStackTrace();
                }
                break;
            }
        }
    }

    public static int getScreenCenterPoint(String axis, Dimension size) {
        int point = 0;
        switch (axis) {
            case "x":
                point = (Toolkit.getDefaultToolkit().getScreenSize().width) / 2;
                break;
            case "y":
                point = (Toolkit.getDefaultToolkit().getScreenSize().height) / 2;
                break;
            default:
                point = 0;
        }
        return point;
    }

    public static boolean isFieldEmpty(JTextField field) {
        return field.getText().trim().isEmpty();
    }

    public static void showMessage(String message, MessageType... messageTypes) {
        String title = "Message";
        if (messageTypes.length != 0) {
            MessageType messageType = messageTypes[0];
            switch (messageType) {
                case ALL_FIELDS_MUST_BE_FILLED :
                    message = "All fields must be filled.";
                    title = "Error";
                    break;
                case SUBMIT_SUCCESSFULLY:
                    message = "Operation done succesfully.";
                    title = "Information";
                    break;
                case SUBMIT_WITH_ERROR:
                    message = "Error occurred.";
                    title = "Error";
                    break;
            }
        }
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE);
    }
}
