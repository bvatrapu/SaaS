package com.saptool.ui.ui_utils;


import com.saptool.utils.GlobalConstants;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author bvatrapu
 */
public class Progressbar extends javax.swing.JFrame {

    /**
     * Creates new form Progressbar
     */
    public Progressbar() {
        initComponents();
        timer.start();
    }
    private Timer timer = new Timer(1150, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            update();
        }
    });

    private void update() {
        dispose();
        timer.stop();
    }

    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();

        setUndecorated(true);

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Bharath_Workspace\\Icons\\gif\\D3cW.gif"));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Progressbar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify
    private javax.swing.JLabel jLabel1;
    // End of variables declaration
}

