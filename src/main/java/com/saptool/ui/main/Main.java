package com.saptool.ui.main;

import com.saptool.ui.*;
import com.saptool.ui.Projects.Project_Warning;
import com.saptool.ui.SmartHub.SmartBuilder.SmartBuilder;
import com.saptool.ui.SmartHub.SmartGen.SmartGen;
import com.saptool.ui.SmartHub.SmartHub;
import com.saptool.ui.dependencycleaner.DependencyCleanerMain;
import com.saptool.ui.executionlab.ExecutionLab;
import com.saptool.ui.Projects.Projects;
import com.saptool.ui.reports.Reports;
import com.saptool.utils.*;
import org.apache.commons.io.FileUtils;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.net.URI;

/**
 *
 * @author Bharath Kumar Reddy Vatrapu
 */
public class Main extends javax.swing.JFrame {
    String username=null;
    GridBagLayout gridBagLayout = new GridBagLayout();
    Generic generic=new Generic();

    public static Projects projects;
    public static SmartHub smartHub;
    public static ExecutionLab executionLab;
    public static SmartBuilder smartBuilder;
    public static SmartGen smartGen;
    public static Reports reports;
    public static BuildProject buildProject;
    public static Schedular schedular;

   // static SeleniumGrid seleniumGrid;



    static Grid grid;

    public static void main(String args[]) {
        /* Create and display the form */
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    public static void setpanelNotVisible(){
        projects.setVisible(false);
        smartHub.setVisible(false);
        smartBuilder.setVisible(false);
        smartGen.setVisible(false);
        executionLab.setVisible(false);
        grid.setVisible(false);
        reports.setVisible(false);
        buildProject.setVisible(false);
        schedular.setVisible(false);
    }

    /**
     * Creates new form Main
     */
    public Main() {
        initComponents();

        generic=new Generic();

        projects = new Projects();
        smartHub = new SmartHub();
        smartBuilder = new SmartBuilder();
        executionLab = new ExecutionLab();
        smartGen = new SmartGen();
        reports = new Reports();
        buildProject = new BuildProject();
        schedular = new Schedular();
        //seleniumGrid = new SeleniumGrid();


        grid = new Grid();

        panelBody.setLayout(gridBagLayout);
        GridBagConstraints c = new GridBagConstraints();

        c.gridx = 0;
        c.gridy = 0;
        panelBody.add(projects,c);

        c.gridx = 0;
        c.gridy = 0;
        panelBody.add(smartHub,c);

        c.gridx = 0;
        c.gridy = 0;
        panelBody.add(smartBuilder,c);

        c.gridx = 0;
        c.gridy = 0;
        panelBody.add(smartGen,c);

        c.gridx = 0;
        c.gridy = 0;
        panelBody.add(executionLab,c);

        c.gridx = 0;
        c.gridy = 0;
        panelBody.add(reports,c);

        c.gridx = 0;
        c.gridy = 0;
        panelBody.add(buildProject,c);

        c.gridx = 0;
        c.gridy = 0;
        panelBody.add(grid,c);

        c.gridx = 0;
        c.gridy = 0;
        panelBody.add(schedular,c);

        setpanelNotVisible();
        initLoad();
    }


    private void initComponents() {

        panelMain = new JPanel();
        panelHeader = new JPanel();
        logoSAPTOOL = new JLabel();
        txtSAPTOOL = new JLabel();
        txtSmartIntelligentAutomation = new JLabel();
        btnClose = new JButton();
      //  txtProjectSelected = new javax.swing.JLabel();
       // txtProjectName = new javax.swing.JLabel();
        txtHub = new JLabel();
        txtNode = new JLabel();
        hubStatus = new JLabel();
        nodeStatus = new JLabel();
        txtDate = new JLabel();
        panelUser = new JPanel();
        iconUser = new JLabel();
        txtUserName = new JLabel();
        toolbarUtilControls = new JToolBar();
        jLabel3 = new JLabel();
        btnSeleniumGrid = new JButton();
        jLabel9 = new JLabel();
        btnSublimeText = new JButton();
        jLabel4 = new JLabel();
        btnSchedular = new JButton();
        jLabel5 = new JLabel();
        btnGitHub = new JButton();
        jLabel6 = new JLabel();
        btnpomCleaner = new JButton();
        jLabel7 = new JLabel();
        btnIntelliJ = new JButton();
        jLabel8 = new JLabel();
        btnVoiceCommands = new JButton();
        panelBody = new JPanel();
        panelLeftControls = new JPanel();
        btnHome = new JButton();
        btnSettings = new JButton();
        btnMax_Min = new JButton();
        btnBuidProject = new JButton();
        btnHistoryLog = new JButton();
        btnShutdown = new JButton();
        btntemp1 = new JButton();
        btnHelp = new JButton();
        panelSAPTOOLControls = new JPanel();
        btnProjects = new JButton();
        btnSmartHub = new JButton();
        btnExecutionLab = new JButton();
        btnReports = new JButton();
        txtProjectloaded = new JLabel();
        txtLoadProjectName = new JLabel();
        toolBarProjectLoad = new JToolBar();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //setLocationRelativeTo(null);
//        setUndecorated(true);
        setTitle("SaaS - Smart,Intelligent Automation");
        setBackground(new Color(255, 255, 255));
     //   setResizable(false);
        this.getRootPane().setBorder(BorderFactory.createMatteBorder(2, 2, 5, 5,new Color(0,122,181) ));


        panelMain.setBackground(new Color(255, 255, 255));

        panelHeader.setBackground(new Color(0, 122, 181));

        logoSAPTOOL.setIcon(new ImageIcon(getClass().getResource("/icons/SaaS_logo.png")));
        logoSAPTOOL.setPreferredSize(new Dimension(104, 116));

        txtSAPTOOL.setBackground(new Color(0, 122, 181));
        txtSAPTOOL.setFont(new Font("Tahoma", 0, 48));
        //txtSAPTOOL.setFont(new java.awt.Font("Old English Text MT", 0, 48));
        txtSAPTOOL.setForeground(new Color(255, 255, 255));
        txtSAPTOOL.setText("Smart automation at Scale - SaaS");

        txtSmartIntelligentAutomation.setFont(new Font("Tahoma", 0, 25));
        txtSmartIntelligentAutomation.setBackground(new java.awt.Color(255, 255, 255));
        txtSmartIntelligentAutomation.setForeground(new java.awt.Color(255, 255, 128));
        txtSmartIntelligentAutomation.setText("                                   Test Automation Level up & Made Easy");

        btnClose.setBackground(new Color(0, 122, 181));
        btnClose.setIcon(new ImageIcon(getClass().getResource("/icons/Delete_32px.png")));
        btnClose.setToolTipText("Close");
        btnClose.setBorder(null);
        btnClose.setBorderPainted(false);
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        txtHub.setFont(new Font("Tahoma", 0, 18));
        txtHub.setForeground(new Color(255, 255, 255));
        txtHub.setText("Hub :");

        txtNode.setFont(new Font("Tahoma", 0, 18));
        txtNode.setForeground(new Color(255, 255, 255));
        txtNode.setText("Node :");

        hubStatus.setIcon(new ImageIcon(getClass().getResource("/icons/Green_24px.png")));
        hubStatus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                hubStatusMouseClicked(evt);
            }
        });

        nodeStatus.setIcon(new ImageIcon(getClass().getResource("/icons/Gray_24px.png")));
        nodeStatus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nodeStatusMouseClicked(evt);
            }
        });

        txtDate.setText(Generic.getDate());
        txtDate.setFont(new Font("Tahoma", 0, 26));
        txtDate.setForeground(new Color(255, 255, 168));

        ///txtProjectSelected.setText("Project Selected :");
       // txtProjectSelected.setFont(new java.awt.Font("Tahoma", 0, 26));
        //txtProjectSelected.setForeground(new java.awt.Color(255, 255, 168));


        //txtProjectName.setFont(new java.awt.Font("Tahoma", 0, 26));
       // txtProjectName.setForeground(new java.awt.Color(255, 255, 130));

        GroupLayout panelHeaderLayout = new GroupLayout(panelHeader);
        panelHeader.setLayout(panelHeaderLayout);
        panelHeaderLayout.setHorizontalGroup(
                panelHeaderLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(panelHeaderLayout.createSequentialGroup()
                                .addGap(54, 54, 54)
                                .addComponent(logoSAPTOOL)
                                .addGroup(panelHeaderLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(panelHeaderLayout.createSequentialGroup()
                                                .addGap(39, 39, 39)
                                                .addComponent(txtSmartIntelligentAutomation)
                                                .addGap(252, 252, 252)
                                               // .addComponent(txtProjectSelected)
                                                .addGap(18, 18, 18)
                                               // .addComponent(txtProjectName)
                                                .addContainerGap())
                                        .addGroup(panelHeaderLayout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addComponent(txtSAPTOOL)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(panelHeaderLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(txtHub)
                                                        .addComponent(txtNode))
                                                .addGap(50, 50, 50)
                                                .addGroup(panelHeaderLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                        .addGroup(panelHeaderLayout.createSequentialGroup()
                                                                .addComponent(hubStatus)
                                                                .addGap(355, 355, 355)
                                                                .addComponent(btnClose, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(panelHeaderLayout.createSequentialGroup()
                                                                .addComponent(nodeStatus)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(txtDate)
                                                                .addGap(147, 147, 147))))))
        );
        panelHeaderLayout.setVerticalGroup(
                panelHeaderLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(panelHeaderLayout.createSequentialGroup()
                                .addGroup(panelHeaderLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(panelHeaderLayout.createSequentialGroup()
                                                .addComponent(btnClose, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(panelHeaderLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addGroup(panelHeaderLayout.createSequentialGroup()
                                                                .addComponent(txtSAPTOOL)
                                                                .addGap(17, 17, 17)
                                                                .addComponent(txtSmartIntelligentAutomation))
                                                        .addComponent(logoSAPTOOL, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(GroupLayout.Alignment.TRAILING, panelHeaderLayout.createSequentialGroup()
                                                                .addGroup(panelHeaderLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(txtDate)
                                                                       // .addComponent(txtProjectSelected)
                                                                        //.addComponent(txtProjectName)
                                                                        )
                                                                .addGap(11, 11, 11))))
                                        .addGroup(panelHeaderLayout.createSequentialGroup()
                                                .addGap(27, 27, 27)
                                                .addGroup(panelHeaderLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(txtHub)
                                                        .addComponent(hubStatus))
                                                .addGap(28, 28, 28)
                                                .addGroup(panelHeaderLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(txtNode)
                                                        .addComponent(nodeStatus))))
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelUser.setBackground(new Color(32, 183, 255));

        iconUser.setIcon(new ImageIcon(getClass().getResource("/users/Administrator-icon.png")));

        txtUserName.setBackground(new Color(255, 255, 255));
        txtUserName.setFont(new Font("Tahoma", 0, 18));
        txtUserName.setForeground(new Color(255, 255, 255));
        txtUserName.setText("Bharath Kumar Reddy");



        GroupLayout panelUserLayout = new GroupLayout(panelUser);
        panelUser.setLayout(panelUserLayout);
        panelUserLayout.setHorizontalGroup(
                panelUserLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(panelUserLayout.createSequentialGroup()
                                .addComponent(iconUser, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
                                .addGap(24, 24, 24)
                                .addComponent(txtUserName, GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE))
        );
        panelUserLayout.setVerticalGroup(
                panelUserLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(panelUserLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(iconUser, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
                        .addGroup(GroupLayout.Alignment.TRAILING, panelUserLayout.createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtUserName)
                                .addGap(31, 31, 31))
        );

        toolbarUtilControls.setRollover(true);

        jLabel3.setText("     ");
        toolbarUtilControls.add(jLabel3);

       // toolBarProjectLoad.setRollover(true);

        btnSeleniumGrid.setIcon(new ImageIcon(getClass().getResource("/icons/Selenium_Grid_48px.png")));
        //btnSeleniumGrid.setBorder(null);
        //btnSeleniumGrid.setBorderPainted(false);
        //btnSeleniumGrid.setFocusable(false);
        btnSeleniumGrid.setHorizontalTextPosition(SwingConstants.CENTER);
        btnSeleniumGrid.setVerticalTextPosition(SwingConstants.BOTTOM);
        btnSeleniumGrid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleniumGridActionPerformed(evt);
            }
        });
        toolbarUtilControls.add(btnSeleniumGrid);

        jLabel9.setText("         ");
        toolbarUtilControls.add(jLabel9);

        btnSublimeText.setIcon(new ImageIcon(getClass().getResource("/icons/Sublime_Text_48px.png")));
        btnSublimeText.setToolTipText("SublimeText");
        btnSublimeText.setFocusable(false);
        btnSublimeText.setHorizontalTextPosition(SwingConstants.CENTER);
        btnSublimeText.setVerticalTextPosition(SwingConstants.BOTTOM);
        btnSublimeText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSublimeTextActionPerformed(evt);
            }
        });
        toolbarUtilControls.add(btnSublimeText);

        jLabel4.setText("         ");
        jLabel4.setToolTipText("");
        toolbarUtilControls.add(jLabel4);

        btnSchedular.setIcon(new ImageIcon(getClass().getResource("/icons/Schedule_48px.png")));
        btnSchedular.setToolTipText("Schedular");
        btnSchedular.setFocusable(false);
        btnSchedular.setHorizontalTextPosition(SwingConstants.CENTER);
        btnSchedular.setVerticalTextPosition(SwingConstants.BOTTOM);
        btnSchedular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSchedularActionPerformed(evt);
            }
        });
        toolbarUtilControls.add(btnSchedular);

        jLabel5.setText("         ");
        toolbarUtilControls.add(jLabel5);

        btnGitHub.setIcon(new ImageIcon(getClass().getResource("/icons/GitHub_48px.png")));
        btnGitHub.setToolTipText("GitHUb");
        btnGitHub.setFocusable(false);
        btnGitHub.setHorizontalTextPosition(SwingConstants.CENTER);
        btnGitHub.setVerticalTextPosition(SwingConstants.BOTTOM);
        btnGitHub.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGitHubActionPerformed(evt);
            }
        });
        toolbarUtilControls.add(btnGitHub);

        jLabel6.setText("         ");
        toolbarUtilControls.add(jLabel6);

        btnpomCleaner.setIcon(new ImageIcon(getClass().getResource("/icons/pom.png")));
        btnpomCleaner.setToolTipText("pom Cleaner");
        btnpomCleaner.setFocusable(false);
        btnpomCleaner.setHorizontalTextPosition(SwingConstants.CENTER);
        btnpomCleaner.setVerticalTextPosition(SwingConstants.BOTTOM);
        btnpomCleaner.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnpomCleanerActionPerformed(evt);
            }
        });
        toolbarUtilControls.add(btnpomCleaner);

        jLabel7.setText("         ");
        toolbarUtilControls.add(jLabel7);

        btnIntelliJ.setIcon(new ImageIcon(getClass().getResource("/icons/IntelliJ_IDEA_48px.png")));
        btnIntelliJ.setFocusable(false);
        btnIntelliJ.setHorizontalTextPosition(SwingConstants.CENTER);
        btnIntelliJ.setVerticalTextPosition(SwingConstants.BOTTOM);
        btnIntelliJ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIntelliJActionPerformed(evt);
            }
        });
        toolbarUtilControls.add(btnIntelliJ);

        jLabel8.setText("         ");
        toolbarUtilControls.add(jLabel8);

        btnVoiceCommands.setIcon(new ImageIcon(getClass().getResource("/icons/Voice_assistant.png")));
        btnVoiceCommands.setToolTipText("voice commands");
        btnVoiceCommands.setFocusable(false);
        btnVoiceCommands.setHorizontalTextPosition(SwingConstants.CENTER);
        btnVoiceCommands.setVerticalTextPosition(SwingConstants.BOTTOM);
        btnVoiceCommands.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoiceCommandsActionPerformed(evt);
            }
        });
        toolbarUtilControls.add(btnVoiceCommands);

        panelBody.setBackground(new Color(255, 255, 255));

        GroupLayout panelBodyLayout = new GroupLayout(panelBody);
        panelBody.setLayout(panelBodyLayout);
        panelBodyLayout.setHorizontalGroup(
                panelBodyLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 1315, Short.MAX_VALUE)
        );
        panelBodyLayout.setVerticalGroup(
                panelBodyLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 687, Short.MAX_VALUE)
        );

        panelLeftControls.setBackground(new Color(0, 148, 219));

        btnHome.setBackground(new Color(0, 148, 219));
        btnHome.setIcon(new ImageIcon(getClass().getResource("/icons/Home_48px.png")));
        btnHome.setToolTipText("Home");
        btnHome.setBorder(null);
        btnHome.setBorderPainted(false);
        btnHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHomeActionPerformed(evt);
            }
        });

        btnSettings.setBackground(new Color(0, 148, 219));
        btnSettings.setIcon(new ImageIcon(getClass().getResource("/icons/Settings_48px.png")));
        btnSettings.setToolTipText("Settings");
        btnSettings.setBorder(null);
        btnSettings.setBorderPainted(false);
        btnSettings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSettingsActionPerformed(evt);
            }
        });

        btnMax_Min.setBackground(new Color(0, 148, 219));
        btnMax_Min.setIcon(new ImageIcon(getClass().getResource("/icons/folder_locator_48px.png")));
        btnMax_Min.setToolTipText("SaaS Folder Locator");
        btnMax_Min.setAlignmentY(1.0F);
        btnMax_Min.setBorder(null);
        btnMax_Min.setBorderPainted(false);
        btnMax_Min.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMax_MinActionPerformed(evt);
            }
        });

        btnBuidProject.setBackground(new Color(0, 148, 219));
        btnBuidProject.setIcon(new ImageIcon(getClass().getResource("/icons/Command_Line_48px.png")));
        btnBuidProject.setToolTipText("Build Project");
        btnBuidProject.setBorder(null);
        btnBuidProject.setBorderPainted(false);
        btnBuidProject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuidProjectActionPerformed(evt);
            }
        });

        btnHistoryLog.setBackground(new Color(0, 148, 219));
        btnHistoryLog.setIcon(new ImageIcon(getClass().getResource("/icons/History_48px.png")));
        btnHistoryLog.setToolTipText("History Log");
        btnHistoryLog.setBorder(null);
        btnHistoryLog.setBorderPainted(false);
        btnHistoryLog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHistoryLogActionPerformed(evt);
            }
        });

        btnShutdown.setBackground(new Color(0, 148, 219));
        btnShutdown.setIcon(new ImageIcon(getClass().getResource("/icons/Shutdown_48px.png")));
        btnShutdown.setToolTipText("Shutdown");
        btnShutdown.setBorder(null);
        btnShutdown.setBorderPainted(false);
        btnShutdown.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShutdownActionPerformed(evt);
            }
        });

        btntemp1.setBackground(new Color(0, 148, 219));
        btntemp1.setIcon(new ImageIcon(getClass().getResource("/icons/Home_48px.png")));
        btntemp1.setToolTipText("Home");
        btntemp1.setBorder(null);
        btntemp1.setBorderPainted(false);
        btntemp1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntemp1ActionPerformed(evt);
            }
        });

        btnHelp.setBackground(new Color(0, 148, 219));
        btnHelp.setIcon(new ImageIcon(getClass().getResource("/icons/About_48px.png")));
        btnHelp.setToolTipText("Help");
        btnHelp.setBorder(null);
        btnHelp.setBorderPainted(false);
        btnHelp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHelpActionPerformed(evt);
            }
        });

        GroupLayout panelLeftControlsLayout = new GroupLayout(panelLeftControls);
        panelLeftControls.setLayout(panelLeftControlsLayout);
        panelLeftControlsLayout.setHorizontalGroup(
                panelLeftControlsLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(panelLeftControlsLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(panelLeftControlsLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(panelLeftControlsLayout.createSequentialGroup()
                                                .addGroup(panelLeftControlsLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(btnHome, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(btnSettings, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(btnBuidProject, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE))
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addGroup(GroupLayout.Alignment.TRAILING, panelLeftControlsLayout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addGroup(panelLeftControlsLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(btnMax_Min, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(btnHistoryLog, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(btnHelp, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(btntemp1, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(btnShutdown, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE))))
                                .addContainerGap())
        );
        panelLeftControlsLayout.setVerticalGroup(
                panelLeftControlsLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(panelLeftControlsLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(btnHome)
                                .addGap(27, 27, 27)
                                .addComponent(btnSettings)
                                .addGap(29, 29, 29)
                                .addComponent(btnMax_Min)
                                .addGap(30, 30, 30)
                                .addComponent(btnBuidProject)
                                .addGap(35, 35, 35)
                                .addComponent(btnHistoryLog)
                                .addGap(33, 33, 33)
                                .addComponent(btnHelp)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btntemp1)
                                .addGap(33, 33, 33)
                                .addComponent(btnShutdown, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );

        panelSAPTOOLControls.setBackground(new Color(48, 48, 48));

        btnProjects.setBackground(new Color(48, 48, 48));
        btnProjects.setFont(new Font("Tahoma", 0, 24));
        btnProjects.setForeground(new Color(255, 255, 255));
        btnProjects.setIcon(new ImageIcon(getClass().getResource("/icons/Projects_48px.png")));
        btnProjects.setText("   Projects");
        btnProjects.setToolTipText("");

//        btnProjects.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                btnProjectsActionPerformed(evt);
//            }
//        });
        btnProjects.setBorderPainted(false);
        btnProjects.setFocusPainted(false);
        btnProjects.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnProjectsMouseClicked(evt);

            }
//            public void mouseEntered(java.awt.event.MouseEvent evt) {
//                btnProjects.setBackground(new java.awt.Color(0,148,219));
//            }
//            public void mouseExited(java.awt.event.MouseEvent evt) {
//                btnProjects.setBackground(new java.awt.Color(48, 48, 48));
//            }
        });

        btnSmartHub.setBackground(new Color(48, 48, 48));
        btnSmartHub.setFont(new Font("Tahoma", 0, 24));
        btnSmartHub.setForeground(new Color(255, 255, 255));
        btnSmartHub.setIcon(new ImageIcon(getClass().getResource("/icons/smartHUb_56.png")));
        btnSmartHub.setText(" Smart Hub");
        btnSmartHub.setToolTipText("");
//        btnSmartHub.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                btnSmartHubActionPerformed(evt);
//            }
//        });
        btnSmartHub.setBorderPainted(false);
        btnSmartHub.setFocusPainted(false);
        btnSmartHub.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSmartHubMouseClicked(evt);

            }
//            public void mouseEntered(java.awt.event.MouseEvent evt) {
//                btnSmartHub.setBackground(new java.awt.Color(0,148,219));
//            }
//            public void mouseExited(java.awt.event.MouseEvent evt) {
//                btnSmartHub.setBackground(new java.awt.Color(48, 48, 48));
//            }
        });

        btnExecutionLab.setBackground(new Color(48, 48, 48));
        btnExecutionLab.setFont(new Font("Tahoma", 0, 24));
        btnExecutionLab.setForeground(new Color(255, 255, 255));
        btnExecutionLab.setIcon(new ImageIcon(getClass().getResource("/icons/application-run_48px.png")));
        btnExecutionLab.setText("ExecutionLab");
        btnExecutionLab.setToolTipText("");
//        btnExecutionLab.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                btnExecutionLabActionPerformed(evt);
//            }
//        });
        btnExecutionLab.setBorderPainted(false);
        btnExecutionLab.setFocusPainted(false);
        btnExecutionLab.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnExecutionLabMouseClicked(evt);

            }
//            public void mouseEntered(java.awt.event.MouseEvent evt) {
//                btnExecutionLab.setBackground(new java.awt.Color(0,148,219));
//            }
//            public void mouseExited(java.awt.event.MouseEvent evt) {
//                btnExecutionLab.setBackground(new java.awt.Color(48, 48, 48));
//            }
        });

        btnReports.setBackground(new Color(48, 48, 48));
        btnReports.setFont(new Font("Tahoma", 0, 24));
        btnReports.setForeground(new Color(255, 255, 255));
        btnReports.setIcon(new ImageIcon(getClass().getResource("/icons/Results_48px.png")));
        btnReports.setText("  Reports");
        btnReports.setToolTipText("");
//        btnReports.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                btnReportsActionPerformed(evt);
//            }
//        });

        btnReports.setBorderPainted(false);
        btnReports.setFocusPainted(false);
        btnReports.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnReportsMouseClicked(evt);

            }
//            public void mouseEntered(java.awt.event.MouseEvent evt) {
//                btnReports.setBackground(new java.awt.Color(0,148,219));
//            }
//            public void mouseExited(java.awt.event.MouseEvent evt) {
//                btnReports.setBackground(new java.awt.Color(48, 48, 48));
//            }
        });

        GroupLayout panelSAPTOOLControlsLayout = new GroupLayout(panelSAPTOOLControls);
        panelSAPTOOLControls.setLayout(panelSAPTOOLControlsLayout);
        panelSAPTOOLControlsLayout.setHorizontalGroup(
                panelSAPTOOLControlsLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(btnProjects, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSmartHub, GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
                        .addComponent(btnExecutionLab, GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
                        .addComponent(btnReports, GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
        );
        panelSAPTOOLControlsLayout.setVerticalGroup(
                panelSAPTOOLControlsLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(panelSAPTOOLControlsLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(btnProjects, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnSmartHub, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnExecutionLab, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnReports, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(324, Short.MAX_VALUE))
        );

//        javax.swing.GroupLayout panelMainLayout = new javax.swing.GroupLayout(panelMain);
//        panelMain.setLayout(panelMainLayout);
//        panelMainLayout.setHorizontalGroup(
//                panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                        .addComponent(panelHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
//                        .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
//                                .addComponent(panelBody, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
//                                .addGroup(panelMainLayout.createSequentialGroup()
//                                        .addGap(0, 0, Short.MAX_VALUE)
//                                        .addComponent(toolbarUtilControls, javax.swing.GroupLayout.PREFERRED_SIZE, 751, javax.swing.GroupLayout.PREFERRED_SIZE)
//                                        .addGap(1, 1, 1)
//                                        .addComponent(toolBarProjectLoad, javax.swing.GroupLayout.PREFERRED_SIZE, 563, javax.swing.GroupLayout.PREFERRED_SIZE)))
////                        .addGroup(panelMainLayout.createSequentialGroup()
////                                .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
////                                        .addGroup(panelMainLayout.createSequentialGroup()
////                                                .addComponent(panelLeftControls, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
////                                                .addGap(0, 0, 0)
////                                                .addComponent(panelSAPTOOLControls, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
////                                        .addComponent(panelUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
////                                .addGap(0, 0, 0)
////                                .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
////                                        .addComponent(toolbarUtilControls, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
////                                        .addComponent(panelBody, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
//        );
//        panelMainLayout.setVerticalGroup(
//                panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                        .addGroup(panelMainLayout.createSequentialGroup()
//                                .addComponent(panelHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
//                                .addGap(0, 0, 0)
//                                .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                                        .addGroup(panelMainLayout.createSequentialGroup()
//                                                .addComponent(panelUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
//                                                .addGap(0, 0, 0)
//                                                .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                                                        .addComponent(panelLeftControls, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
//                                                        .addComponent(panelSAPTOOLControls, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
//                                        .addGroup(panelMainLayout.createSequentialGroup()
//                                                .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
//                                                        .addComponent(toolbarUtilControls, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
//                                                        .addComponent(toolBarProjectLoad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
//                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
//                                                .addComponent(panelBody, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
////                                        .addGroup(panelMainLayout.createSequentialGroup()
////                                                .addComponent(toolbarUtilControls, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
////                                                .addGap(0, 0, 0)
////                                                .addComponent(panelBody, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
//        );

        toolBarProjectLoad.setRollover(true);

        toolBarProjectLoad.add(txtProjectloaded);

        txtLoadProjectName.setText("");
        txtLoadProjectName.setFont(new Font("Tahoma", 1, 24));
        txtLoadProjectName.setForeground(new Color(102, 0, 153));
        toolBarProjectLoad.add(txtLoadProjectName);

        GroupLayout panelMainLayout = new GroupLayout(panelMain);
        panelMain.setLayout(panelMainLayout);
        panelMainLayout.setHorizontalGroup(
                panelMainLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(panelHeader, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panelMainLayout.createSequentialGroup()
                                .addGroup(panelMainLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(panelMainLayout.createSequentialGroup()
                                                .addComponent(panelLeftControls, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, 0)
                                                .addComponent(panelSAPTOOLControls, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                        .addComponent(panelUser, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, 0)
                                .addGroup(panelMainLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(panelBody, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(panelMainLayout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(toolbarUtilControls, GroupLayout.PREFERRED_SIZE, 751, GroupLayout.PREFERRED_SIZE)
                                                .addGap(1, 1, 1)
                                                .addComponent(toolBarProjectLoad, GroupLayout.PREFERRED_SIZE, 563, GroupLayout.PREFERRED_SIZE))))
        );
        panelMainLayout.setVerticalGroup(
                panelMainLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(panelMainLayout.createSequentialGroup()
                                .addComponent(panelHeader, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addGroup(panelMainLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(panelMainLayout.createSequentialGroup()
                                                .addComponent(panelUser, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, 0)
                                                .addGroup(panelMainLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(panelLeftControls, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(panelSAPTOOLControls, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                        .addGroup(panelMainLayout.createSequentialGroup()
                                                .addGroup(panelMainLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(toolbarUtilControls, GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
                                                        .addComponent(toolBarProjectLoad, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(panelBody, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(panelMain, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(panelMain, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        //setSize(screenSize.width,screenSize.height);
//        if(GlobalConstants.MIN_MAX){
//            pack();
//        }
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public static void onClick(JButton button){
        button.setBackground(new Color(0,148,219));
    }
    public static void onLeaveClick(JButton button){
        button.setBackground(new Color(48, 48, 48));
    }

    public void initLoad(){
        try {
            if (!Generic.verifyFileExist(GlobalConstants.CONFIG_TEMP_FOLDER_PATH)) {
                FileUtils.moveDirectory(new File(System.getProperty("user.dir")+File.separator+"temp"), new File(GlobalConstants.CONFIG_TEMP_FOLDER_PATH));
            }

            btntemp1.setVisible(false);
            username = System.getProperty("user.name");
            if (username.contains("bvatrapu")) {
                username = "Bharath Kumar Reddy V";
            }
            if (GlobalConstants.SELECTED_PROJECT != null) {
                txtProjectloaded.setVisible(true);
                txtProjectloaded.setFont(new Font("Tahoma", 1, 18));
                txtProjectloaded.setText("Project Loaded:   ");
                txtLoadProjectName.setText(GlobalConstants.SELECTED_PROJECT);
            } else {
                txtProjectloaded.setVisible(false);
                txtLoadProjectName.setText("No Project is Loaded in SaaS");
                txtLoadProjectName.setForeground(new Color(255, 127, 39));

            }
            txtUserName.setText(username);
            if (GlobalConstants.HUB_STATUS) {
                hubStatus.setIcon(new ImageIcon(getClass().getResource("/icons/Green_24px.png")));
            } else {
                hubStatus.setIcon(new ImageIcon(getClass().getResource("/icons/Gray_24px.png")));
            }

            if (GlobalConstants.NODE_STATUS) {
                nodeStatus.setIcon(new ImageIcon(getClass().getResource("/icons/Green_24px.png")));
            } else {
                nodeStatus.setIcon(new ImageIcon(getClass().getResource("/icons/Gray_24px.png")));
            }
        }catch(Exception e){
            Log.error(e.toString());
            e.printStackTrace();
        }

    }


    public void btnCloseActionPerformed(java.awt.event.ActionEvent evt){
        close();
    }
    public void btnSublimeTextActionPerformed(java.awt.event.ActionEvent evt){
        Generic.openEXEfile(GlobalConstants.SublimeText_Path);
    }
    public void btnSeleniumGridActionPerformed(java.awt.event.ActionEvent evt){
        panelBody.setBackground(new Color(255, 255, 255));
        setpanelNotVisible();
        grid.setVisible(true);
    }
    public void btnSchedularActionPerformed(java.awt.event.ActionEvent evt){

        setpanelNotVisible();
        panelBody.setBackground(new Color(255, 255, 255));
        schedular.setVisible(true);
    }
    public void btnGitHubActionPerformed(java.awt.event.ActionEvent evt){
        if (GlobalConstants.SELECTED_PROJECT == null || GlobalConstants.SELECTED_PROJECT.isEmpty()) {
            if (Projects.project_warning == null) {
                Projects.project_warning = new Project_Warning();
            }
            //JOptionPane.showMessageDialog(null,"Project is not Selected");
            Project_Warning.txtProjectName.setText("Project is not Loaded");
            Project_Warning.txtMessage.setText("Load project from Projects table...");

        } else {
            Thread object = new Thread(new openGithub());
            object.start();
        }

    }
    public void btnpomCleanerActionPerformed(java.awt.event.ActionEvent evt){
        //DependencyCleanerMain dependencyCleanerMain=new DependencyCleanerMain();
        DependencyCleanerMain.createAndShowGui();
    }
    public void btnIntelliJActionPerformed(java.awt.event.ActionEvent evt){
       // Generic.openEXEfile(GlobalConstants.IntelliJ_Path);
        Thread object = new Thread(new openProject());
        object.start();
    }
    public void btnVoiceCommandsActionPerformed(java.awt.event.ActionEvent evt){
        SpeechToText speechToText=new SpeechToText();
        speechToText.startSpeechRecognition();
    }
    public void btnHomeActionPerformed(java.awt.event.ActionEvent evt){
        setpanelNotVisible();
    }
    public void btnSettingsActionPerformed(java.awt.event.ActionEvent evt){
        if(!Frame_Flag.saas_Configuration){
            Saas_Config saas_config=new Saas_Config();
            saas_config.setVisible(true);
        }
    }
    public void btnMax_MinActionPerformed(java.awt.event.ActionEvent evt){
//        if(GlobalConstants.MIN_MAX){
//////            GlobalConstants.MIN_MAX=false;
//////        } else{
//////            GlobalConstants.MIN_MAX=true;
//////        }
//////        initComponents();
        try {
            Desktop.getDesktop().open(new File(GlobalConstants.SETUP_FOLDER_PATH+File.separator+GlobalConstants.Tool_Name));
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
    public void btnBuidProjectActionPerformed(java.awt.event.ActionEvent evt){
        onLeaveClick(btnSmartHub);
        onLeaveClick(btnProjects);
        onLeaveClick(btnExecutionLab);
        onLeaveClick(btnReports);

        setpanelNotVisible();
        panelBody.setBackground(new Color(255, 255, 255));
        buildProject.setVisible(true);
    }
    public void btnHistoryLogActionPerformed(java.awt.event.ActionEvent evt){
        Thread object = new Thread(new openHistory());
        object.start();
    }
    public void btnShutdownActionPerformed(java.awt.event.ActionEvent evt){
        close();
    }
    public void btntemp1ActionPerformed(java.awt.event.ActionEvent evt){
        JOptionPane.showMessageDialog(null,"UNDER DEVELOPEMNT");
    }
    public void btnHelpActionPerformed(java.awt.event.ActionEvent evt){
        JOptionPane.showMessageDialog(null,"UNDER DEVELOPEMNT");
    }
    public void btnProjectsActionPerformed(java.awt.event.ActionEvent evt){
        setpanelNotVisible();
        panelBody.setBackground(new Color(255, 255, 255));
        projects.setVisible(true);
    }
    public void btnProjectsMouseClicked(java.awt.event.MouseEvent evt){
        onClick(btnProjects);
        onLeaveClick(btnSmartHub);
        onLeaveClick(btnExecutionLab);
        onLeaveClick(btnReports);

        setpanelNotVisible();
        panelBody.setBackground(new Color(255, 255, 255));
        projects.setVisible(true);
    }

    public void btnSmartHubMouseClicked(java.awt.event.MouseEvent evt){
        onClick(btnSmartHub);
        onLeaveClick(btnProjects);
        onLeaveClick(btnExecutionLab);
        onLeaveClick(btnReports);

        setpanelNotVisible();
        panelBody.setBackground(new Color(179, 193, 206));
        smartHub.setVisible(true);
    }
    public void btnExecutionLabMouseClicked(java.awt.event.MouseEvent evt){
        onClick(btnExecutionLab);
        onLeaveClick(btnProjects);
        onLeaveClick(btnSmartHub);
        onLeaveClick(btnReports);

        setpanelNotVisible();
        panelBody.setBackground(new Color(255, 255, 255));
       // seleniumGrid.setVisible(false);
        if(GlobalConstants.SELECTED_PROJECT==null || GlobalConstants.SELECTED_PROJECT.equalsIgnoreCase("")){
            JOptionPane.showMessageDialog(null,"Project is not Selected");
        } else {
            ExecutionLab.init_Load();
            executionLab.setVisible(true);
        }
    }
    public void btnReportsMouseClicked(java.awt.event.MouseEvent evt){
        onClick(btnReports);
        onLeaveClick(btnProjects);
        onLeaveClick(btnSmartHub);
        onLeaveClick(btnExecutionLab);
        setpanelNotVisible();
        panelBody.setBackground(new Color(255, 255, 255));
        reports.setVisible(true);
        Reports.init_Load();
    }

    private void hubStatusMouseClicked(java.awt.event.MouseEvent evt) {
        if(GlobalConstants.HUB_STATUS){
            HubWarning hubWarning=new HubWarning();
            HubWarning.txtMessage.setText("Hub is Already running... Do you want to Stop ?");
            hubWarning.setVisible(true);
        } else {
            generic.startHub();
        }
    }
    private void nodeStatusMouseClicked(java.awt.event.MouseEvent evt) {
        if(GlobalConstants.NODE_STATUS){
            HubWarning hubWarning=new HubWarning();
            HubWarning.txtMessage.setText("Nodes are Already running.. Do you want to Stop ?");
            hubWarning.setVisible(true);
        } else {
            if(!GlobalConstants.HUB_STATUS){
                generic.startHub();
            }
            generic.startNode();
        }
    }


    public void close(){

        Generic.folderDelete(GlobalConstants.EXECUTIONS_FOLDER_PATH);
        dispose();
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    }


    class openHistory implements Runnable{
        @Override
        public void run() {
            try {

                ProcessBuilder pb = new ProcessBuilder(GlobalConstants.SublimeText_Path, GlobalConstants.CONFIG_FOLDER_PATH+File.separator+"SaaS.log");
                pb.start();
            }catch (Exception e)
            {
                // Throwing an exception
                e.printStackTrace();
            }
        }
    }
    static class openProject implements Runnable{
        @Override
        public void run() {
            try {
                ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "C:\\Program Files\\JetBrains\\IntelliJ IDEA Community Edition 2018.3.4\\bin\\idea.exe", "-n", "100");
                Process process = pb.start();
                // ProcessBuilder pb = new ProcessBuilder(GlobalConstants.SublimeText_Path, GlobalConstants.SELECTED_PROJECT_PATH + File.separator + GlobalConstants.TEST_FRAMEWORK_TESTPAGES_FOLDER+File.separator+selected_Page+".java");
                //   pb.start();
            }catch (Exception e)
            {
                // Throwing an exception
                e.printStackTrace();
            }
        }
    }
    class openGithub implements Runnable{
        @Override
        public void run() {
            try {
                if(Generic.verifyFileExist("C:\\Users\\bvatrapu\\AppData\\Local\\GitHubDesktop\\GitHubDesktop.exe")){
                    ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "C:\\Users\\bvatrapu\\AppData\\Local\\GitHubDesktop\\GitHubDesktop.exe", "-n", "100");
//                ProcessBuilder pb = new ProcessBuilder(GlobalConstants.SELECTED_PROJECT_PATH, "C:\\Users\\bvatrapu\\AppData\\Local\\GitHubDesktop\\GitHubDesktop.exe");
                    Process process = pb.start();
                } else {
                    Desktop.getDesktop().browse(new URI("https://desktop.github.com/"));
                }

                // ProcessBuilder pb = new ProcessBuilder(GlobalConstants.SublimeText_Path, GlobalConstants.SELECTED_PROJECT_PATH + File.separator + GlobalConstants.TEST_FRAMEWORK_TESTPAGES_FOLDER+File.separator+selected_Page+".java");
                //   pb.start();
            }catch (Exception e)
            {
                // Throwing an exception
                e.printStackTrace();
            }
        }
    }

    // Variables declaration - do not modify
    private JButton btnClose;
    private JButton btnMax_Min;
    private JButton btnGithub;
    private JButton btnHelp;
    private JButton btnHome;
    private JButton btnBuidProject;
    private JButton btnIntelliJIdea;
    private JButton btnpomCleaner;
    private JButton btnLab;
    private JButton btnPlan;
    public static JButton btnProjects;
    private JButton btnQueue;
    private JButton btnSchedule;
    private JButton btnSeleniumGrid;
    private JButton btnSettings;
    private JButton btnShutdown;
    private JButton btnSublime;

//    private javax.swing.JLabel txtProjectSelected;
//    public static javax.swing.JLabel txtProjectName;
    private JScrollPane jScrollPane1;
    public static JTextArea txtAreaTerminal;
    private JLabel logoSAPTOOL;

    private JPanel panelControls;
    private JPanel panelHeader;
    private JPanel panelLeft;
    private JPanel panelNavigation;
    private JPanel panelTerminal;
    public static JPanel panelBody;
    private JLabel txtHub;
    private JLabel txtNode;
    private JLabel txtTerminal;
    private JLabel txtSAPTOOL;
    private JLabel txtdate;
    private JLabel txtsublineText;
    // End of variables declaration


    public static JButton btnSmartHub;
    private JButton btnVoiceCommands;
    public static JButton btnExecutionLab;

    private JButton btnGitHub;

    private JButton btnHistoryLog;

    private JButton btnIntelliJ;

    public static JButton btnReports;
    private JButton btnSchedular;

    private JButton btnSublimeText;
    private JButton btntemp1;
    private JLabel iconUser;
    public static JLabel nodeStatus;
    public static JLabel hubStatus;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel jLabel7;
    private JLabel jLabel8;
    private JLabel jLabel9;

    private JPanel panelLeftControls;
    private JPanel panelMain;
    private JPanel panelSAPTOOLControls;
    private JPanel panelUser;
    private JToolBar toolbarUtilControls;
    private JLabel txtDate;


    private JLabel txtSmartIntelligentAutomation;

    private JLabel txtUserName;

    private JToolBar toolBarProjectLoad;
    public static JLabel txtProjectloaded;
    public static JLabel txtLoadProjectName;


}
