package com.saptool.ui.main;

import com.saptool.ui.main.Main;
import com.saptool.utils.Generic;
import com.saptool.utils.GlobalConstants;
import com.saptool.utils.RestApi;
import com.saptool.utils.WindowsProcessKiller;

import java.io.File;
import java.lang.management.ManagementFactory;

/**
 *
 * @author Bharath Kumar Reddy Vatrapu
 */
public class Grid extends javax.swing.JPanel {
    HubWarning hubWarning;
    Generic generic;
    /**
     * Creates new form Projects
     */
    public Grid() {
        initComponents();
        generic=new Generic();
    }


    private void initComponents() {

        panelHUB = new javax.swing.JPanel();
        btnHUbStart = new javax.swing.JButton();
        btnHubJsonConfig = new javax.swing.JButton();
        btnHubconfig = new javax.swing.JButton();
        btnHubCheck = new javax.swing.JButton();
        panelHUB1 = new javax.swing.JPanel();
        btnNodesStart = new javax.swing.JButton();
        btnNodesJsonConfig = new javax.swing.JButton();
        btnNodesConfig = new javax.swing.JButton();
        btnNodesCheck = new javax.swing.JButton();
        btnStop = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        panelHUB.setBackground(new java.awt.Color(255, 255, 255));
        panelHUB.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "HUB", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18), new java.awt.Color(0, 51, 255)));

        btnHUbStart.setBackground(new java.awt.Color(255, 255, 255));
        btnHUbStart.setFont(new java.awt.Font("Arial", 0, 18));
        btnHUbStart.setForeground(new java.awt.Color(0, 153, 51));
        btnHUbStart.setText("Start");
        btnHUbStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHUbStartActionPerformed(evt);
            }
        });

        btnHubJsonConfig.setBackground(new java.awt.Color(255, 255, 255));
        btnHubJsonConfig.setFont(new java.awt.Font("Arial", 0, 18));
        btnHubJsonConfig.setText("Json Config");
        btnHubJsonConfig.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHubJsonConfigActionPerformed(evt);
            }
        });

        btnHubconfig.setBackground(new java.awt.Color(255, 255, 255));
        btnHubconfig.setFont(new java.awt.Font("Arial", 0, 18));
        btnHubconfig.setText("Config");
        btnHubconfig.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHubconfigActionPerformed(evt);
            }
        });

        btnHubCheck.setBackground(new java.awt.Color(255, 255, 255));
        btnHubCheck.setFont(new java.awt.Font("Arial", 0, 18));
        btnHubCheck.setText("Check");
        btnHubCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHubCheckActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelHUBLayout = new javax.swing.GroupLayout(panelHUB);
        panelHUB.setLayout(panelHUBLayout);
        panelHUBLayout.setHorizontalGroup(
                panelHUBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelHUBLayout.createSequentialGroup()
                                .addGap(55, 55, 55)
                                .addGroup(panelHUBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(btnHubCheck, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnHubconfig, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnHubJsonConfig, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnHUbStart, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(60, Short.MAX_VALUE))
        );
        panelHUBLayout.setVerticalGroup(
                panelHUBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelHUBLayout.createSequentialGroup()
                                .addGap(44, 44, 44)
                                .addComponent(btnHUbStart, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(41, 41, 41)
                                .addComponent(btnHubconfig, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37)
                                .addComponent(btnHubJsonConfig, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(54, 54, 54)
                                .addComponent(btnHubCheck, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(58, Short.MAX_VALUE))
        );

        panelHUB1.setBackground(new java.awt.Color(255, 255, 255));
        panelHUB1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "NODES", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18), new java.awt.Color(0, 51, 255)));

        btnNodesStart.setBackground(new java.awt.Color(255, 255, 255));
        btnNodesStart.setFont(new java.awt.Font("Arial", 0, 18));
        btnNodesStart.setForeground(new java.awt.Color(0, 153, 51));
        btnNodesStart.setText("Start");
        btnNodesStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNodesStartActionPerformed(evt);
            }
        });

        btnNodesJsonConfig.setBackground(new java.awt.Color(255, 255, 255));
        btnNodesJsonConfig.setFont(new java.awt.Font("Arial", 0, 18));
        btnNodesJsonConfig.setText("Json Config");
        btnNodesJsonConfig.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNodesJsonConfigActionPerformed(evt);
            }
        });

        btnNodesConfig.setBackground(new java.awt.Color(255, 255, 255));
        btnNodesConfig.setFont(new java.awt.Font("Arial", 0, 18));
        btnNodesConfig.setText("Config");
        btnNodesConfig.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNodesConfigActionPerformed(evt);
            }
        });

        btnNodesCheck.setBackground(new java.awt.Color(255, 255, 255));
        btnNodesCheck.setFont(new java.awt.Font("Arial", 0, 18));
        btnNodesCheck.setText("Check");
        btnNodesCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNodesCheckActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelHUB1Layout = new javax.swing.GroupLayout(panelHUB1);
        panelHUB1.setLayout(panelHUB1Layout);
        panelHUB1Layout.setHorizontalGroup(
                panelHUB1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelHUB1Layout.createSequentialGroup()
                                .addGap(55, 55, 55)
                                .addGroup(panelHUB1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(btnNodesCheck, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnNodesConfig, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnNodesJsonConfig, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnNodesStart, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(60, Short.MAX_VALUE))
        );
        panelHUB1Layout.setVerticalGroup(
                panelHUB1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelHUB1Layout.createSequentialGroup()
                                .addGap(44, 44, 44)
                                .addComponent(btnNodesStart, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(41, 41, 41)
                                .addComponent(btnNodesConfig, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37)
                                .addComponent(btnNodesJsonConfig, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(54, 54, 54)
                                .addComponent(btnNodesCheck, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(58, Short.MAX_VALUE))
        );

        btnStop.setBackground(new java.awt.Color(255, 255, 255));
        btnStop.setText("Stop");
        btnStop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStopActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(55, 55, 55)
                                .addComponent(panelHUB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(153, 153, 153)
                                .addComponent(panelHUB1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(119, 119, 119)
                                .addComponent(btnStop, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(248, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(btnStop, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                        .addGap(65, 65, 65)
                                                        .addComponent(panelHUB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(layout.createSequentialGroup()
                                                        .addGap(73, 73, 73)
                                                        .addComponent(panelHUB1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addContainerGap(113, Short.MAX_VALUE))
        );
    }

    private void btnHUbStartActionPerformed(java.awt.event.ActionEvent evt) {
        if(GlobalConstants.HUB_STATUS){
            hubWarning=new HubWarning();
            HubWarning.txtMessage.setText("Hub is Already running... Do you want to Stop ?");
            hubWarning.setVisible(true);
        } else {
            generic.startHub();
        }
    }

    private void btnHubJsonConfigActionPerformed(java.awt.event.ActionEvent evt) {
        Thread object = new Thread(new openhubJsonFile());
        object.start();
    }

    private void btnHubconfigActionPerformed(java.awt.event.ActionEvent evt) {
        Thread object = new Thread(new openhubConfigFile());
        object.start();
    }

    private void btnHubCheckActionPerformed(java.awt.event.ActionEvent evt) {
        String hubStatus = null;
        try {

            hubStatus = RestApi.callRestApi("http://localhost:4444/grid/api/hub");
            if (hubStatus.contains("no resp")) {
                GlobalConstants.HUB_STATUS = false;
                Main.hubStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Gray_24px.png")));
            } else{
                GlobalConstants.HUB_STATUS = true;
                Main.hubStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Green_24px.png")));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void btnNodesStartActionPerformed(java.awt.event.ActionEvent evt) {
        if(GlobalConstants.NODE_STATUS){
            hubWarning=new HubWarning();
            HubWarning.txtMessage.setText("Nodes Already running.. Do you want to Stop ?");
            hubWarning.setVisible(true);
        } else {
            if(!GlobalConstants.HUB_STATUS){
                generic.startHub();
            }
            generic.startNode();
        }
    }

    private void btnNodesJsonConfigActionPerformed(java.awt.event.ActionEvent evt) {
        Thread object = new Thread(new opennodeJsonFile());
        object.start();
    }

    private void btnNodesConfigActionPerformed(java.awt.event.ActionEvent evt) {
        Thread object = new Thread(new opennodeConfigFile());
        object.start();
    }

    private void btnNodesCheckActionPerformed(java.awt.event.ActionEvent evt) {
        String nodeStatus = null;
        try {

            nodeStatus = RestApi.callRestApi("http://localhost:4444/grid/api/hub");
            if (nodeStatus.contains("no resp")) {
                GlobalConstants.NODE_STATUS = false;
                Main.nodeStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Gray_24px.png")));
            } else{
                if(nodeStatus.contains("\"total\":20")){
                    GlobalConstants.NODE_STATUS=true;
                    Main.nodeStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Green_24px.png")));
                } else{
                    GlobalConstants.NODE_STATUS = false;
                    Main.nodeStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Gray_24px.png")));
                }

            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void btnStopActionPerformed(java.awt.event.ActionEvent evt) {
        generic.stopHub_Node();
    }



    class openhubJsonFile implements Runnable{
        @Override
        public void run() {
            try {

                ProcessBuilder pb = new ProcessBuilder(GlobalConstants.SublimeText_Path, GlobalConstants.HUB_JSON_FILE_PATH);
                pb.start();
            }catch (Exception e)
            {
                // Throwing an exception
                e.printStackTrace();
            }
        }
    }

    class opennodeJsonFile implements Runnable{
        @Override
        public void run() {
            try {

                ProcessBuilder pb = new ProcessBuilder(GlobalConstants.SublimeText_Path, GlobalConstants.NODES_JSON_FILE_PATH);
                pb.start();
            }catch (Exception e)
            {
                // Throwing an exception
                e.printStackTrace();
            }
        }
    }
    class opennodeConfigFile implements Runnable{
        @Override
        public void run() {
            try {

                ProcessBuilder pb = new ProcessBuilder(GlobalConstants.SublimeText_Path, GlobalConstants.NODES_CONFIG_FILE_PATH);
                pb.start();
            }catch (Exception e)
            {
                // Throwing an exception
                e.printStackTrace();
            }
        }
    }
    class openhubConfigFile implements Runnable{
        @Override
        public void run() {
            try {

                ProcessBuilder pb = new ProcessBuilder(GlobalConstants.SublimeText_Path, GlobalConstants.HUB_CONFIG_FILE_PATH);
                pb.start();
            }catch (Exception e)
            {
                // Throwing an exception
                e.printStackTrace();
            }
        }
    }

    // Variables declaration - do not modify
    private javax.swing.JButton btnHUbStart;
    private javax.swing.JButton btnHubCheck;
    private javax.swing.JButton btnHubJsonConfig;
    private javax.swing.JButton btnHubconfig;
    private javax.swing.JButton btnNodesCheck;
    private javax.swing.JButton btnNodesConfig;
    private javax.swing.JButton btnNodesJsonConfig;
    private javax.swing.JButton btnNodesStart;
    private javax.swing.JButton btnStop;
    private javax.swing.JPanel panelHUB;
    private javax.swing.JPanel panelHUB1;
    // End of variables declaration
}

