package com.saptool.ui.Projects;

import com.saptool.ui.Frame_Flag;
import com.saptool.ui.UI_Design;
import com.saptool.ui.main.Main;
import com.saptool.utils.GlobalConstants;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Bharath Kumar Reddy Vatrapu
 */
public class Project_Confirm extends JFrame {

    /**
     * Creates new form Projects_Confirm
     */
    public Project_Confirm() {
        initComponents();
        initLoad();
        timer.start();
    }
    public void initLoad(){
//        txtProjectName.setVisible(false);
//        txtMessage.setVisible(false);
        btnOk.setVisible(false);

    }
    private Timer timer = new Timer(4000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            update();
        }
    });
    private void update() {
        btnOk.setVisible(true);
        spinner.setIcon(new ImageIcon(getClass().getResource("/icons/projects/Tick_Confirm.png")));
        if(GlobalConstants.project_Button_clicked_name.equalsIgnoreCase("SELECT")){
            txtMessage.setText("project is Loaded successfully...");
        } else if(GlobalConstants.project_Button_clicked_name.equalsIgnoreCase("DELETE")){
            txtMessage.setText("project is Deleted successfully...");
        }
    }

    private void initComponents() {

        panelBody = new JPanel();
        imgRobo = new JLabel();
        txtProjectName = new JLabel();
        txtMessage = new JLabel();
        btnOk = new JButton();
        spinner = new JLabel();


        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //setLocationRelativeTo(null);
        setUndecorated(true);
        setTitle("Projects - Confirmation");
        setBackground(new Color(255, 255, 255));
        setResizable(false);
        this.getRootPane().setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2,new Color(0,122,181) ));

        panelBody.setBackground(new Color(255, 255, 255));

        imgRobo.setIcon(new ImageIcon(getClass().getResource("/icons/projects/Msg_robo.gif")));

        txtProjectName.setFont(new Font("Tahoma", 0, 24));
        txtProjectName.setForeground(new Color(102, 0, 204));
        txtProjectName.setText("projectname");

        txtMessage.setFont(new Font("Tahoma", 0, 24));
        txtMessage.setForeground(new Color(0, 153, 153));
        txtMessage.setText("jLabel1");

        UI_Design.button_ui_style_blue(btnOk,"Ok");
        btnOk.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnOkActionPerformed(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnOk.setBackground(new Color(255, 255, 255));
                btnOk.setFont(new Font("Tahoma", 0, 18));
                btnOk.setForeground(new Color(0, 122, 181));
                btnOk.setIcon(new ImageIcon(getClass().getResource("/icons/projects/ok.png")));
                btnOk.setBorder(BorderFactory.createLineBorder(new Color(0, 122, 181), 1));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnOk.setBackground(new Color(0, 122, 181));
                btnOk.setFont(new Font("Tahoma", 1, 24));
                btnOk.setForeground(new Color(255, 255, 255));
                btnOk.setIcon(null);
                btnOk.setBorder(null);
            }
        });

        spinner.setIcon(new ImageIcon(getClass().getResource("/icons/projects/spinner.gif")));

        GroupLayout panelBodyLayout = new GroupLayout(panelBody);
        panelBody.setLayout(panelBodyLayout);
        panelBodyLayout.setHorizontalGroup(
                panelBodyLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(panelBodyLayout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addComponent(spinner)
                                .addGap(71, 71, 71)
                                .addGroup(panelBodyLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(panelBodyLayout.createSequentialGroup()
                                                .addComponent(txtMessage)
                                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(panelBodyLayout.createSequentialGroup()
                                                .addComponent(txtProjectName, GroupLayout.PREFERRED_SIZE, 407, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(imgRobo)
                                                .addGap(69, 69, 69))))
                        .addGroup(GroupLayout.Alignment.TRAILING, panelBodyLayout.createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnOk, GroupLayout.PREFERRED_SIZE, 204, GroupLayout.PREFERRED_SIZE)
                                .addGap(245, 245, 245))
        );
        panelBodyLayout.setVerticalGroup(
                panelBodyLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(panelBodyLayout.createSequentialGroup()
                                .addGroup(panelBodyLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(panelBodyLayout.createSequentialGroup()
                                                .addGap(90, 90, 90)
                                                .addComponent(spinner))
                                        .addGroup(panelBodyLayout.createSequentialGroup()
                                                .addGroup(panelBodyLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addGroup(panelBodyLayout.createSequentialGroup()
                                                                .addGap(116, 116, 116)
                                                                .addComponent(txtProjectName))
                                                        .addGroup(panelBodyLayout.createSequentialGroup()
                                                                .addGap(32, 32, 32)
                                                                .addComponent(imgRobo)))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(txtMessage)))
                                .addGap(41, 41, 41)
                                .addComponent(btnOk, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
                                .addGap(89, 89, 89))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(panelBody, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(panelBody, GroupLayout.PREFERRED_SIZE, 398, GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void btnOkActionPerformed(java.awt.event.MouseEvent evt) {
        Projects.initLoad();
        Projects.project_confirm =null;
        Projects.selected_Project=null;
        Main.txtLoadProjectName.setText(GlobalConstants.SELECTED_PROJECT);

        Frame_Flag.projects_LoadProject=false;
        dispose();
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
               /* Create and display the form */
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Project_Confirm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify
    public static JButton btnOk;
    private JLabel spinner;
    private JLabel imgRobo;
    private JPanel panelBody;
    public static JLabel txtMessage;
    public static JLabel txtProjectName;
    // End of variables declaration
}

