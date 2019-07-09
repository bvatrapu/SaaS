package com.saptool.ui.Projects;


import javax.swing.*;

/**
 *
 * @author Bharath Kumar Reddy Vatrapu
 */
public class Project_Create_Process extends JFrame {

    /**
     * Creates new form Project_Create_1
     */
    public Project_Create_Process() {
        initComponents();
    }


    private void initComponents() {

        panelBody = new JPanel();
        imgProcessbar = new JLabel();


        setTitle("Project_Create_Process");
//        setResizable(false);
//        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);
//        setLocationRelativeTo(null);
//        setUndecorated(true);
//        setTitle("SAPTOOL-Smart,Intelligent Automation");
//        setBackground(new java.awt.Color(255, 255, 255));
//        setResizable(false);
//        this.getRootPane().setBorder(BorderFactory.createMatteBorder(2, 2, 5, 5,new java.awt.Color(0,122,181) ));

        panelBody.setBackground(new java.awt.Color(255, 255, 255));

        imgProcessbar.setIcon(new ImageIcon(getClass().getResource("/images/Processing.gif")));
        imgProcessbar.setVisible(true);
        GroupLayout panelBodyLayout = new GroupLayout(panelBody);
        panelBody.setLayout(panelBodyLayout);
        panelBodyLayout.setHorizontalGroup(
                panelBodyLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(panelBodyLayout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addComponent(imgProcessbar)
                                .addContainerGap(50, Short.MAX_VALUE))
        );
        panelBodyLayout.setVerticalGroup(
                panelBodyLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(panelBodyLayout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addComponent(imgProcessbar)
                                .addContainerGap(52, Short.MAX_VALUE))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(panelBody, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(panelBody, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Project_Create_Process().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify
    private JLabel imgProcessbar;
    private JPanel panelBody;
    // End of variables declaration
}

