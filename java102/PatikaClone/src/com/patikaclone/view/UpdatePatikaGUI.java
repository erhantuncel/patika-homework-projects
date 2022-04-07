package com.patikaclone.view;

import com.patikaclone.helper.Config;
import com.patikaclone.helper.Helper;
import com.patikaclone.helper.MessageType;
import com.patikaclone.model.Patika;

import javax.swing.*;

public class UpdatePatikaGUI extends JFrame {
    private JPanel wrapper;
    private JTextField fld_patika_name;
    private JButton btn_patika_update;
    private Patika patika;

    public UpdatePatikaGUI(Patika patika) {
        this.patika = patika;
        add(wrapper);
        setSize(300,150);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle(Config.PROJECT_TITLE);
        setVisible(true);
        fld_patika_name.setText(patika.getName());

        btn_patika_update.addActionListener(e -> {
            if (Helper.isFieldEmpty(fld_patika_name)) {
                Helper.showMessage(null, MessageType.ALL_FIELDS_MUST_BE_FILLED);
            } else {
                if (Patika.update(patika.getId(), fld_patika_name.getText())) {
                    Helper.showMessage(null, MessageType.SUBMIT_SUCCESSFULLY);
                }
                dispose();
            }
        });
    }
}
