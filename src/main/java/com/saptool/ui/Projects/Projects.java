package com.saptool.ui.Projects;


import com.saptool.tables.ViewProjectsTable;
import com.saptool.tables.ViewProjectsTableModel;
import com.saptool.ui.Frame_Flag;
import com.saptool.ui.Projects.config.ConfigProject;
import com.saptool.ui.UI_Design;
import com.saptool.ui.ui_utils.Progressbar;
import com.saptool.utils.Generic;
import com.saptool.utils.GlobalConstants;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Bharath Kumar Reddy Vatrapu
 */
public class Projects extends JPanel {

    public static ViewProjectsTableModel viewProjectsTableModel = null;
    public static String selected_Project = null;

    public static Project_Confirm project_confirm=null;
    public static Project_Warning project_warning=null;
    /**
     * Creates new form Projects
     */
    public Projects() {
        initComponents();
        initLoad();
    }


    private void initComponents() {

        txtProjectName = new JLabel();
        jScrollPane1 = new JScrollPane();
        tblProjects = new JTable();
        btnConfigProject = new JButton();
        btnLoadProject = new JButton();
        btnCreateProject = new JButton();
        btnDeleteProject = new JButton();
        btnImportProject = new JButton();
        chkboxSATProjets = new JCheckBox();
        imgRobo = new JLabel();
        btnExportProject = new JButton();

        setBackground(new Color(255, 255, 255));

        txtProjectName.setFont(new Font("Tahoma", 0, 24));
        txtProjectName.setForeground(new Color(102, 102, 255));
        txtProjectName.setText("Current Project:");
        txtProjectName.setToolTipText("");
        txtProjectName.setBorder(null);
       // txtProjectName.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(102, 153, 255), null));

        tblProjects.setAutoCreateRowSorter(true);
//        tblProjects.setModel(new javax.swing.table.DefaultTableModel(
//                new Object [][] {
//                        {null, null},
//                        {null, null},
//                        {null, null},
//                        {null, null},
//                        {null, null},
//                        {null, null},
//                        {null, null}
//                },
//                new String [] {
//                        "Sno", "Project Name", "Created Date"
//                }
//        ));
        //tblProjects.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 255)));
        UI_Design.table_ui_style_blue(tblProjects);



        tblProjects.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                tblProjectsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblProjects);
        tblProjects.getSelectionModel().addListSelectionListener(new SelectionListener());

        UI_Design.button_ui_style_blue(btnConfigProject,"Config Project");
        btnConfigProject.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                btnConfigProjectActionPerformed(evt);
            }
            public void mouseEntered(MouseEvent evt) {
                btnConfigProject.setBackground(new Color(255, 255, 255));
                btnConfigProject.setFont(new Font("Tahoma", 0, 18));
                btnConfigProject.setForeground(new Color(0, 122, 181));
                btnConfigProject.setIcon(new ImageIcon(getClass().getResource("/icons/projects/config_project.png")));
                btnConfigProject.setBorder(BorderFactory.createLineBorder(new Color(0, 122, 181), 1));
            }
            public void mouseExited(MouseEvent evt) {
                btnConfigProject.setBackground(new Color(0, 122, 181));
                btnConfigProject.setFont(new Font("Tahoma", 1, 24));
                btnConfigProject.setForeground(new Color(255, 255, 255));
                btnConfigProject.setIcon(null);
                btnConfigProject.setBorder(null);
            }
        });

        UI_Design.button_ui_style_blue(btnLoadProject,"Load Project");
        btnLoadProject.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                btnSelectProjectActionPerformed(evt);
            }
            public void mouseEntered(MouseEvent evt) {
                btnLoadProject.setBackground(new Color(255, 255, 255));
                btnLoadProject.setFont(new Font("Tahoma", 0, 18));
                btnLoadProject.setForeground(new Color(0, 122, 181));
                btnLoadProject.setIcon(new ImageIcon(getClass().getResource("/icons/projects/load_project.png")));
                btnLoadProject.setBorder(BorderFactory.createLineBorder(new Color(0, 122, 181), 1));
            }
            public void mouseExited(MouseEvent evt) {
                btnLoadProject.setBackground(new Color(0, 122, 181));
                btnLoadProject.setFont(new Font("Tahoma", 1, 24));
                btnLoadProject.setForeground(new Color(255, 255, 255));
                btnLoadProject.setIcon(null);
                btnLoadProject.setBorder(null);
            }
        });


        UI_Design.button_ui_style_blue(btnCreateProject,"Create Project");
        btnCreateProject.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                btnCreateProjectActionPerformed(evt);
            }
            public void mouseEntered(MouseEvent evt) {
                btnCreateProject.setBackground(new Color(255, 255, 255));
                btnCreateProject.setFont(new Font("Tahoma", 0, 18));
                btnCreateProject.setForeground(new Color(0, 122, 181));
                btnCreateProject.setIcon(new ImageIcon(getClass().getResource("/icons/projects/create_project.png")));
                btnCreateProject.setBorder(BorderFactory.createLineBorder(new Color(0, 122, 181), 1));
            }
            public void mouseExited(MouseEvent evt) {
                btnCreateProject.setBackground(new Color(0, 122, 181));
                btnCreateProject.setFont(new Font("Tahoma", 1, 24));
                btnCreateProject.setForeground(new Color(255, 255, 255));
                btnCreateProject.setIcon(null);
                btnCreateProject.setBorder(null);
            }
        });


        UI_Design.button_ui_style_blue(btnDeleteProject,"Delete Project");
        btnDeleteProject.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                btnDeleteProjectActionPerformed(evt);
            }
            public void mouseEntered(MouseEvent evt) {
                btnDeleteProject.setBackground(new Color(255, 255, 255));
                btnDeleteProject.setFont(new Font("Tahoma", 0, 18));
                btnDeleteProject.setForeground(new Color(0, 122, 181));
                btnDeleteProject.setIcon(new ImageIcon(getClass().getResource("/icons/projects/delete_project.png")));
                btnDeleteProject.setBorder(BorderFactory.createLineBorder(new Color(0, 122, 181), 1));
            }
            public void mouseExited(MouseEvent evt) {
                btnDeleteProject.setBackground(new Color(0, 122, 181));
                btnDeleteProject.setFont(new Font("Tahoma", 1, 24));
                btnDeleteProject.setForeground(new Color(255, 255, 255));
                btnDeleteProject.setIcon(null);
                btnDeleteProject.setBorder(null);
            }
        });

        UI_Design.button_ui_style_blue(btnImportProject,"Import Project");
        btnImportProject.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                btnImportProjectActionPerformed(evt);
            }
            public void mouseEntered(MouseEvent evt) {
                btnImportProject.setBackground(new Color(255, 255, 255));
                btnImportProject.setFont(new Font("Tahoma", 0, 18));
                btnImportProject.setForeground(new Color(0, 122, 181));
                btnImportProject.setIcon(new ImageIcon(getClass().getResource("/icons/projects/import_project.png")));
                btnImportProject.setBorder(BorderFactory.createLineBorder(new Color(0, 122, 181), 1));
            }
            public void mouseExited(MouseEvent evt) {
                btnImportProject.setBackground(new Color(0, 122, 181));
                btnImportProject.setFont(new Font("Tahoma", 1, 24));
                btnImportProject.setForeground(new Color(255, 255, 255));
                btnImportProject.setIcon(null);
                btnImportProject.setBorder(null);
            }
        });

        chkboxSATProjets.setBackground(new Color(255, 255, 255));
        chkboxSATProjets.setFont(new Font("Tahoma", 1, 24));
        chkboxSATProjets.setForeground(new Color(51, 0, 255));
        chkboxSATProjets.setSelected(true);
        chkboxSATProjets.setText("SaaS Projects");
        chkboxSATProjets.setBorder(null);
        chkboxSATProjets.setPreferredSize(new Dimension(100, 40));
        chkboxSATProjets.setFocusPainted(false);
        chkboxSATProjets.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selected_Project = null;
                tblProjects.setModel(getModel(GlobalConstants.PROJECTS_FOLDER_PATH));
                UI_Design.table_dimenetions(tblProjects);
            }
        });



        imgRobo.setIcon(new ImageIcon(getClass().getResource("/icons/projects/projects_robo.png")));


        UI_Design.button_ui_style_blue(btnExportProject,"Export Project");
        btnExportProject.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                btnExportProjectActionPerformed(evt);
            }
            public void mouseEntered(MouseEvent evt) {
                btnExportProject.setBackground(new Color(255, 255, 255));
                btnExportProject.setFont(new Font("Tahoma", 0, 18));
                btnExportProject.setForeground(new Color(0, 122, 181));
                btnExportProject.setIcon(new ImageIcon(getClass().getResource("/icons/projects/export_project.png")));
                btnExportProject.setBorder(BorderFactory.createLineBorder(new Color(0, 122, 181), 1));
            }
            public void mouseExited(MouseEvent evt) {
                btnExportProject.setBackground(new Color(0, 122, 181));
                btnExportProject.setFont(new Font("Tahoma", 1, 24));
                btnExportProject.setForeground(new Color(255, 255, 255));
                btnExportProject.setIcon(null);
                btnExportProject.setBorder(null);
            }
        });

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(106, 106, 106)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 770, GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addGap(1, 1, 1)
                                                                                .addComponent(btnLoadProject, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE))
                                                                        .addComponent(btnCreateProject, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 221, GroupLayout.PREFERRED_SIZE))
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                        .addComponent(btnDeleteProject, GroupLayout.PREFERRED_SIZE, 221, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(btnConfigProject, GroupLayout.PREFERRED_SIZE, 221, GroupLayout.PREFERRED_SIZE))
                                                                .addGap(46, 46, 46)
                                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                        .addComponent(btnExportProject, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 229, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(btnImportProject, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 229, GroupLayout.PREFERRED_SIZE))))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 111, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(txtProjectName)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(chkboxSATProjets, GroupLayout.PREFERRED_SIZE, 197, GroupLayout.PREFERRED_SIZE)
                                                .addGap(119, 119, 119)))
                                .addComponent(imgRobo, GroupLayout.PREFERRED_SIZE, 275, GroupLayout.PREFERRED_SIZE)
                                .addGap(38, 38, 38))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(64, 64, 64)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtProjectName)
                                        .addComponent(chkboxSATProjets, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 214, GroupLayout.PREFERRED_SIZE)
                                .addGap(49, 49, 49)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnCreateProject, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnConfigProject, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnImportProject, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE))
                                .addGap(29, 29, 29)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnDeleteProject, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnLoadProject, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnExportProject, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addComponent(imgRobo, GroupLayout.PREFERRED_SIZE, 605, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(35, Short.MAX_VALUE))
        );
    }

    private void btnConfigProjectActionPerformed(MouseEvent evt) {

        if (selected_Project == null || selected_Project.isEmpty()) {
            if (project_warning == null) {
                project_warning = new Project_Warning();
            }
            Project_Warning.txtProjectName.setText("Project is not selected");
            Project_Warning.txtMessage.setText("Select project from table...");

        } else {
            if(chkboxSATProjets.isSelected()){
                GlobalConstants.SaaS_PROJECTS=true;
                JOptionPane.showMessageDialog(null,"Configuration only for Non-SaaS Projects");
            } else {
                GlobalConstants.SaaS_PROJECTS =false;

                if(!Frame_Flag.projects_ConfigProjects) {
                    ConfigProject configProject = new ConfigProject();
                    configProject.setVisible(true);
                    Frame_Flag.projects_ConfigProjects=true;
                }
            }

        }
    }

    private void btnSelectProjectActionPerformed(MouseEvent evt) {
        if(!Frame_Flag.projects_LoadProject) {
            GlobalConstants.project_Button_clicked_name = "SELECT";
            if (selected_Project == null || selected_Project.isEmpty()) {
                if (project_warning == null) {
                    project_warning = new Project_Warning();
                }
                Project_Warning.txtProjectName.setText("Project is not selected");
                Project_Warning.txtMessage.setText("Select project from table...");

            } else {
                if (project_confirm == null) {
                    project_confirm = new Project_Confirm();
                }
                Project_Confirm.txtProjectName.setText(selected_Project.toUpperCase());
                Project_Confirm.txtMessage.setText("project is Loading .....");
                Generic.createProject_Setup(selected_Project);
                GlobalConstants.SELECTED_PROJECT = GlobalConstants.TABLE_SELECTED_PROJECT;
            }
        }
        Frame_Flag.projects_LoadProject=true;
    }

    private void btnCreateProjectActionPerformed(MouseEvent evt) {
        if(!Frame_Flag.projects_CreateProject) {
            new Project_Create().setVisible(true);
        }
        Frame_Flag.projects_CreateProject=true;
    }

    private void btnDeleteProjectActionPerformed(MouseEvent evt) {
        if(Frame_Flag.projects_CreateProject || Frame_Flag.projects_LoadProject){
            JOptionPane.showMessageDialog(null,"Othet Project activity is in progress");
        } else {
            GlobalConstants.project_Button_clicked_name = "DELETE";
            if (selected_Project == null || selected_Project.isEmpty()) {
                if (project_warning == null) {
                    project_warning = new Project_Warning();
                }
                //JOptionPane.showMessageDialog(null,"Project is not Selected");
                Project_Warning.txtProjectName.setText("Project is not selected");
                Project_Warning.txtMessage.setText("Select project from table...");

            } else {
                if (project_confirm == null) {
                    project_confirm = new Project_Confirm();
                }
                Generic.deleteProject_Setup(selected_Project);
                Project_Confirm.txtProjectName.setText(selected_Project.toUpperCase());
                Project_Confirm.txtMessage.setText("project is Deleting .....");

//            initLoad();

            }
        }

    }

    private void btnImportProjectActionPerformed(MouseEvent evt) {
        String dirPath=null;
        String[] temp1=null;
        dirPath=Generic.choosefolderPath();
        File temp = new File(dirPath);
        String folderName=temp.getName();
        File srcPath = new File(dirPath+File.separator+"src");
        File pompath = new File(dirPath+File.separator+"pom.xml");
        if(srcPath.exists() && pompath.exists()){
            Generic.copyDirectory(new File(dirPath),new File(GlobalConstants.PROJECTS_FOLDER_PATH+File.separator+folderName));
            Progressbar progressbar=new Progressbar();
            progressbar.setVisible(true);
            JOptionPane.showMessageDialog(null, "Project  "+folderName +"  Successfully Imported");
            initLoad();
            GlobalConstants.SELECTED_PROJECT = folderName;
            Generic.createProjectConfig(folderName);
            GlobalConstants.SELECTED_PROJECT_PATH =GlobalConstants.PROJECTS_FOLDER_PATH+ File.separator+folderName;
            Generic.writeProp(GlobalConstants.Prop_Project_Path,GlobalConstants.SELECTED_PROJECT_PATH,GlobalConstants.CONFIG_PROJECTS_FOLDER_PATH+ File.separator+GlobalConstants.SELECTED_PROJECT+File.separator+GlobalConstants.config_properties);

            Generic.writeProp(GlobalConstants.Prop_Selected_Project,folderName);
            if(!Frame_Flag.projects_ConfigProjects) {
                ConfigProject configProject = new ConfigProject();
                configProject.setVisible(true);
                Frame_Flag.projects_ConfigProjects=true;
            }
        } else{
            JOptionPane.showMessageDialog(null, "Project does not contains src or pom files");
//            Project_Warning.txtProjectName.setText("Project does not contains src or pom files");
//            Project_Warning.txtMessage.setText("Select correct project path ....");
        }


    }

    private void tblProjectsMouseClicked(MouseEvent evt) {
        // TODO add your handling code here:
    }

    private void btnExportProjectActionPerformed(MouseEvent evt) {
        String dirPath=null;
        if (selected_Project == null || selected_Project.isEmpty()) {
            if (project_warning == null) {
                project_warning = new Project_Warning();
            }
            //JOptionPane.showMessageDialog(null,"Project is not Selected");
            Project_Warning.txtProjectName.setText("Project is not selected");
            Project_Warning.txtMessage.setText("Select project from table...");

        } else {
            dirPath=Generic.choosefolderPath();
            if (!new File(dirPath+File.separator+selected_Project).exists()) {
                Generic.copyDirectory(new File(GlobalConstants.PROJECTS_FOLDER_PATH+File.separator+selected_Project),new File(dirPath+File.separator+selected_Project));
                Progressbar progressbar=new Progressbar();
                progressbar.setVisible(true);
            } else{
                if (project_warning == null) {
                    project_warning = new Project_Warning();
                }
                //JOptionPane.showMessageDialog(null,"Project is not Selected");
                Project_Warning.txtProjectName.setText(selected_Project);
                Project_Warning.txtMessage.setText("Project Folder already exists...!");
            }
        }
    }

    public static void initLoad(){
        tblProjects.setModel(getModel(GlobalConstants.PROJECTS_FOLDER_PATH));
        UI_Design.table_dimenetions(tblProjects);
        txtProjectName.setText("");
    }
    public static ViewProjectsTableModel getModel(String dirPath) {
        int i=1;
        if(dirPath!=null) {
            File file = new File(dirPath);

            String[] names = file.list();
            //build the list
            List<ViewProjectsTable> viewFileList = new ArrayList<ViewProjectsTable>();
            if (names != null) {
                for (String name : names) {
                    // if (new File(dirPath + name).isFile()) {
                    File saas = new File(dirPath+File.separator+name+File.separator+GlobalConstants.FRAMEWORK_FOLDER);
                    if(chkboxSATProjets.isSelected()) {
                        if (saas.exists()) {
                            ViewProjectsTable viewFileTable = new ViewProjectsTable(i, name, Generic.getFolderCreateDate(dirPath + File.separator + name).toString().substring(0, 10));
                            viewFileList.add(viewFileTable);
                            i = i + 1;
                        }
                    } else{
                        if (!saas.exists()) {
                            ViewProjectsTable viewFileTable = new ViewProjectsTable(i, name, Generic.getFolderCreateDate(dirPath + File.separator + name).toString().substring(0, 10));
                            viewFileList.add(viewFileTable);
                            i = i + 1;
                        }
                    }
                    //  }
                }

            }
            viewProjectsTableModel = new ViewProjectsTableModel(viewFileList);

        }
        return viewProjectsTableModel;
    }

    class SelectionListener implements ListSelectionListener {
        public void valueChanged(ListSelectionEvent e) {
            if(e.getValueIsAdjusting())
                return;
            int row = tblProjects.getSelectedRow();
            if(row < 0)
                return;
            int col = tblProjects.getSelectedColumn();
            if(col < 0)
                return;

            if (tblProjects.getRowSorter()!=null) {
                row = tblProjects.getRowSorter().convertRowIndexToModel(row);
            }
            //tblProjects.clearSelection();
            selected_Project = (String) tblProjects.getModel().getValueAt(row, 1);
            GlobalConstants.TABLE_SELECTED_PROJECT = selected_Project;

            tblProjects.setSelectionBackground(new Color(48, 48, 48));
            tblProjects.setSelectionForeground(new Color(255, 255, 255));
            txtProjectName.setText(selected_Project.toUpperCase());

        }
    }
    public static void loadProjectTable(){
        tblProjects.setModel(getModel(GlobalConstants.PROJECTS_FOLDER_PATH));
        UI_Design.table_dimenetions(tblProjects);
    }

    // Variables declaration - do not modify
    private JButton btnConfigProject;
    public static JButton btnCreateProject;
    public static JButton btnDeleteProject;
    public static JButton btnExportProject;
    public static JButton btnImportProject;
    public static JButton btnLoadProject;
    private static JCheckBox chkboxSATProjets;
    private JLabel imgRobo;
    private JScrollPane jScrollPane1;
    public static JTable tblProjects;
    public static JLabel txtProjectName;
    // End of variables declaration
}

