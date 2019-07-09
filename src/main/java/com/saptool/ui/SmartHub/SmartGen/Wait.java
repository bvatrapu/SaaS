package com.saptool.ui.SmartHub.SmartGen;


import com.saptool.ui.Frame_Flag;
import com.saptool.ui.Init;
import com.saptool.ui.UI_Design;
import org.apache.commons.lang3.StringUtils;

import javax.swing.*;

/**
 *
 * @author bvatrapu
 */
public class Wait extends JFrame {

    /**
     * Creates new form Comment
     */
    public Wait() {
        initComponents();
    }


    private void initComponents() {

        mainPanel = new JPanel();
        txtWait = new JLabel();
        inputWait = new JTextField();
        btnClose = new JButton();
        btnDone = new JButton();

        UI_Design.frame_boarder(this);

        mainPanel.setBackground(new java.awt.Color(255, 255, 255));

        txtWait.setFont(new java.awt.Font("Segoe UI", 1, 24));
        txtWait.setForeground(new java.awt.Color(51, 0, 204));
        txtWait.setText("Wait in Sec: ");

        inputWait.setFont(new java.awt.Font("Tahoma", 0, 24));
        inputWait.setForeground(new java.awt.Color(102, 102, 102));

        btnClose.setBackground(new java.awt.Color(255, 255, 255));
        btnClose.setIcon(new ImageIcon(getClass().getResource("/icons/smarthub/Close_Window_32px.png")));
        btnClose.setBorder(null);
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });


        UI_Design.button_ui_style_violet(btnDone,"Done");
        btnDone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDoneActionPerformed(evt);
            }
        });

        GroupLayout mainPanelLayout = new GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
                mainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnClose, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
                        .addGroup(mainPanelLayout.createSequentialGroup()
                                .addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(mainPanelLayout.createSequentialGroup()
                                                .addGap(24, 24, 24)
                                                .addComponent(txtWait)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(inputWait, GroupLayout.PREFERRED_SIZE, 665, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(mainPanelLayout.createSequentialGroup()
                                                .addGap(366, 366, 366)
                                                .addComponent(btnDone, GroupLayout.PREFERRED_SIZE, 186, GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(44, Short.MAX_VALUE))
        );
        mainPanelLayout.setVerticalGroup(
                mainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(mainPanelLayout.createSequentialGroup()
                                .addComponent(btnClose, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtWait)
                                        .addComponent(inputWait, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE))
                                .addGap(27, 27, 27)
                                .addComponent(btnDone, GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                                .addContainerGap())
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(mainPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(mainPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();

        setLocationRelativeTo(null);
        setVisible(true);
    }
    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {
        Frame_Flag.smartBuilder_wait=false;
        dispose();
    }

    private void btnDoneActionPerformed(java.awt.event.ActionEvent evt) {
        if(StringUtils.isNumeric(inputWait.getText())) {
            Init.Add_TestScript_step_ListModel.addElement("Wait.sleep(" + inputWait.getText() + ")");
            Frame_Flag.smartBuilder_wait=false;
            dispose();
        }else{
            JOptionPane.showMessageDialog(null,"Enter number as input");
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Wait().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify
    private JButton btnClose;
    private JButton btnDone;
    private JTextField inputWait;
    private JPanel mainPanel;
    private JLabel txtWait;
    // End of variables declaration
}

