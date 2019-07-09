package com.saptool.ui.SmartHub.SmartBuilder.CreateNewPage;

import bsh.StringUtil;
import com.saptool.frameworkbuilder.FrameworkBuilder;
import com.saptool.frameworkbuilder.PageBuilder;
import com.saptool.ui.Frame_Flag;
import com.saptool.ui.Init;
import com.saptool.ui.SmartHub.SmartBuilder.SmartBuilder;
import com.saptool.ui.UI_Design;
import com.saptool.utils.DomExtractor;
import com.saptool.utils.Generic;
import com.saptool.utils.GlobalConstants;
import com.saptool.utils.Log;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.JavascriptExecutor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

/**
 *
 * @author Bharath Kumar Reddy Vatrapu
 */
public class ObjectBuilder extends JFrame {

    /**
     * Creates new form ObjectBuilder
     */
    public ObjectBuilder() {
        initComponents();
        cbImage.setSelected(true);
        cbSelectAll.setSelected(true);
        cblink.setSelected(true);
        cbButton.setSelected(true);
        cbCheckBox.setSelected(true);
        cbRadioButton.setSelected(true);
        cbComboBox.setSelected(true);
        cbEditBox.setSelected(true);
        cbText.setSelected(true);
    }


    private void initComponents() {

        panelMain = new javax.swing.JPanel();
        panelObjectControls = new javax.swing.JPanel();
        cblink = new javax.swing.JCheckBox();
        cbButton = new javax.swing.JCheckBox();
        cbRadioButton = new javax.swing.JCheckBox();
        cbCheckBox = new javax.swing.JCheckBox();
        cbEditBox = new javax.swing.JCheckBox();
        cbComboBox = new javax.swing.JCheckBox();
        cbText = new javax.swing.JCheckBox();
        cbImage = new javax.swing.JCheckBox();
        cbSelectAll = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAreaHtmlCodeEditor = new javax.swing.JTextArea();
        btnGenerate = new javax.swing.JButton();
        inputPageName = new javax.swing.JTextField();
        inputPageDesc = new javax.swing.JTextField();

        UI_Design.frame_boarder(this);

        panelMain.setBackground(new java.awt.Color(255, 255, 255));

        panelObjectControls.setBackground(new java.awt.Color(255, 255, 255));
        panelObjectControls.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Controls", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 16), new java.awt.Color(0, 204, 204)));

        cblink.setBackground(new java.awt.Color(255, 255, 255));
        cblink.setFont(new java.awt.Font("Tahoma", 0, 24));
        cblink.setForeground(new java.awt.Color(0, 153, 102));
        cblink.setText("Link");

        cbButton.setBackground(new java.awt.Color(255, 255, 255));
        cbButton.setFont(new java.awt.Font("Tahoma", 0, 24));
        cbButton.setForeground(new java.awt.Color(0, 153, 102));
        cbButton.setText("Button");

        cbRadioButton.setBackground(new java.awt.Color(255, 255, 255));
        cbRadioButton.setFont(new java.awt.Font("Tahoma", 0, 24));
        cbRadioButton.setForeground(new java.awt.Color(0, 153, 102));
        cbRadioButton.setText("Radio Button");

        cbCheckBox.setBackground(new java.awt.Color(255, 255, 255));
        cbCheckBox.setFont(new java.awt.Font("Tahoma", 0, 24));
        cbCheckBox.setForeground(new java.awt.Color(0, 153, 102));
        cbCheckBox.setText("CheckBox");

        cbEditBox.setBackground(new java.awt.Color(255, 255, 255));
        cbEditBox.setFont(new java.awt.Font("Tahoma", 0, 24));
        cbEditBox.setForeground(new java.awt.Color(0, 153, 102));
        cbEditBox.setText("EditBox");

        cbComboBox.setBackground(new java.awt.Color(255, 255, 255));
        cbComboBox.setFont(new java.awt.Font("Tahoma", 0, 24));
        cbComboBox.setForeground(new java.awt.Color(0, 153, 102));
        cbComboBox.setText("ComboBox");

        cbText.setBackground(new java.awt.Color(255, 255, 255));
        cbText.setFont(new java.awt.Font("Tahoma", 0, 24));
        cbText.setForeground(new java.awt.Color(0, 153, 102));
        cbText.setText("Text (Headers)");

        cbImage.setBackground(new java.awt.Color(255, 255, 255));
        cbImage.setFont(new java.awt.Font("Tahoma", 0, 24));
        cbImage.setForeground(new java.awt.Color(0, 153, 102));
        cbImage.setText("Image");

        cbSelectAll.setBackground(new java.awt.Color(255, 255, 255));
        cbSelectAll.setFont(new java.awt.Font("Tahoma", 0, 24));
        cbSelectAll.setForeground(new java.awt.Color(0, 51, 255));
        cbSelectAll.setText("Select All");
        cbSelectAll.addActionListener(actionListener);

        SwingUtilities.invokeLater( new Runnable() {
            public void run() {
                txtAreaHtmlCodeEditor.requestFocus();
            }
        } );

        javax.swing.GroupLayout panelObjectControlsLayout = new javax.swing.GroupLayout(panelObjectControls);
        panelObjectControls.setLayout(panelObjectControlsLayout);
        panelObjectControlsLayout.setHorizontalGroup(
                panelObjectControlsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelObjectControlsLayout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addGroup(panelObjectControlsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(panelObjectControlsLayout.createSequentialGroup()
                                                .addComponent(cbSelectAll)
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(panelObjectControlsLayout.createSequentialGroup()
                                                .addGroup(panelObjectControlsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(cblink)
                                                        .addComponent(cbButton))
                                                .addGap(109, 109, 109)
                                                .addGroup(panelObjectControlsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(cbRadioButton)
                                                        .addComponent(cbCheckBox))
                                                .addGap(123, 123, 123)
                                                .addGroup(panelObjectControlsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(cbEditBox)
                                                        .addComponent(cbComboBox))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 96, Short.MAX_VALUE)
                                                .addGroup(panelObjectControlsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(cbText)
                                                        .addComponent(cbImage))
                                                .addGap(67, 67, 67))))
        );
        panelObjectControlsLayout.setVerticalGroup(
                panelObjectControlsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelObjectControlsLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cbSelectAll)
                                .addGap(18, 18, 18)
                                .addGroup(panelObjectControlsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(cblink)
                                        .addComponent(cbRadioButton)
                                        .addComponent(cbEditBox)
                                        .addComponent(cbText))
                                .addGap(27, 27, 27)
                                .addGroup(panelObjectControlsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(cbButton)
                                        .addComponent(cbCheckBox)
                                        .addComponent(cbComboBox)
                                        .addComponent(cbImage))
                                .addGap(21, 21, 21))
        );

        txtAreaHtmlCodeEditor.setColumns(20);
        txtAreaHtmlCodeEditor.setRows(5);
        txtAreaHtmlCodeEditor.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Html Code", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        jScrollPane1.setViewportView(txtAreaHtmlCodeEditor);

        btnGenerate.setBackground(new java.awt.Color(255, 255, 255));
        btnGenerate.setFont(new java.awt.Font("Tahoma", 1, 24));
        btnGenerate.setText("Generate");
        btnGenerate.setFocusPainted(false);
        btnGenerate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerateActionPerformed(evt);
            }
        });

        inputPageName.setFont(new java.awt.Font("Tahoma", 0, 20));
        inputPageName.setForeground(new java.awt.Color(0, 0, 255));
        inputPageName.setText("Page Name");
        inputPageName.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                inputPageName.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
                if(inputPageName.getText().trim().contains("Page Name")){
                    inputPageName.setText("");
                }
            }
            public void focusLost(FocusEvent e) {
                if(StringUtils.isEmpty(inputPageName.getText())){
                    inputPageName.setText("  Page Name");
                }
            }

        });

        inputPageDesc.setFont(new java.awt.Font("Tahoma", 0, 20));
        inputPageDesc.setForeground(new java.awt.Color(0, 0, 255));
        inputPageDesc.setText("Page Description");
        inputPageDesc.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                inputPageDesc.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
                if(inputPageDesc.getText().trim().contains("Page Description")){
                    inputPageDesc.setText("");
                }
            }
            public void focusLost(FocusEvent e) {
                if(StringUtils.isEmpty(inputPageDesc.getText())){
                    inputPageDesc.setText("  Page Description");
                }
            }

        });

        javax.swing.GroupLayout panelMainLayout = new javax.swing.GroupLayout(panelMain);
        panelMain.setLayout(panelMainLayout);
        panelMainLayout.setHorizontalGroup(
                panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelMainLayout.createSequentialGroup()
                                .addGap(52, 52, 52)
                                .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(panelMainLayout.createSequentialGroup()
                                                .addComponent(inputPageName, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(55, 55, 55)
                                                .addComponent(inputPageDesc))
                                        .addComponent(jScrollPane1)
                                        .addComponent(panelObjectControls, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap(65, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMainLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnGenerate, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(425, 425, 425))
        );
        panelMainLayout.setVerticalGroup(
                panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelMainLayout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(inputPageName, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(inputPageDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(26, 26, 26)
                                .addComponent(panelObjectControls, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40)
                                .addComponent(btnGenerate, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(44, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(panelMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(panelMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                new ObjectBuilder().setVisible(true);
            }
        });
    }
    ActionListener PageSourceactionListener = new ActionListener() {
        public void actionPerformed(ActionEvent actionEvent) {
            AbstractButton abstractButton = (AbstractButton) actionEvent.getSource();
            boolean selected = abstractButton.getModel().isSelected();
            if(selected){
                txtAreaHtmlCodeEditor.setEnabled(false);
            } else{
                txtAreaHtmlCodeEditor.setEnabled(true);
            }
        }
    };

    ActionListener actionListener = new ActionListener() {
        public void actionPerformed(ActionEvent actionEvent) {
            AbstractButton abstractButton = (AbstractButton) actionEvent.getSource();
            boolean selected = abstractButton.getModel().isSelected();

            if(selected){
                cblink.setSelected(true);
                cbButton.setSelected(true);
                cbCheckBox.setSelected(true);
                cbRadioButton.setSelected(true);
                cbComboBox.setSelected(true);
                cbEditBox.setSelected(true);
                cbText.setSelected(true);
                cbImage.setSelected(true);
            } else {
                cblink.setSelected(false);
                cbButton.setSelected(false);
                cbCheckBox.setSelected(false);
                cbRadioButton.setSelected(false);
                cbComboBox.setSelected(false);
                cbEditBox.setSelected(false);
                cbText.setSelected(false);
                cbImage.setSelected(false);
            }
            // abstractButton.setText(newLabel);
        }
    };

    private void btnGenerateActionPerformed(ActionEvent evt) {
        ArrayList<String> objList=new ArrayList<String>();
        String newfileName = inputPageName.getText();
        newfileName= Generic.removeSpecialChars(newfileName).trim();
        String pageName=null;
        try {
            if(newfileName.isEmpty()||newfileName.equalsIgnoreCase("PageName")){
                newfileName= JOptionPane.showInputDialog("Enter page name");
                inputPageName.setText(newfileName);
            } else {
                if (cblink.isSelected()) {
                    objList.add(cblink.getText());
                }
                if (cbButton.isSelected()) {
                    objList.add(cbButton.getText());
                }
                if (cbCheckBox.isSelected()) {
                    objList.add(cbCheckBox.getText());
                }
                if (cbEditBox.isSelected()) {
                    objList.add(cbEditBox.getText());
                }
                if (cbImage.isSelected()) {
                    objList.add(cbImage.getText());
                }

                if (cbRadioButton.isSelected()) {
                    objList.add(cbRadioButton.getText());
                }
                if (cbText.isSelected()) {
                    objList.add(cbText.getText());
                }
                if (cbComboBox.isSelected()) {
                    objList.add(cbComboBox.getText());
                }

                if(objList.size()>0) {
                    pageName = newfileName + "Page";
                    Path source = Paths.get(GlobalConstants.CONFIG_TEMP_FOLDER_PATH + File.separator + "Temp_PageModel.java");
                    Path newdir = Paths.get(GlobalConstants.SELECTED_PROJECT_PATH + File.separator + GlobalConstants.TEST_FRAMEWORK_TESTPAGES_FOLDER);

                    Log.info("source:" + source);
                    Log.info("newdir:" + newdir);
                    if (Generic.verifyFileExist(newdir + File.separator + pageName + ".java")) {
                        JOptionPane.showMessageDialog(null, "Already Page name " + pageName + ".java  " + "Exist !!!");
                    } else {
                        String htmlContent=null;
                        htmlContent=txtAreaHtmlCodeEditor.getText();
                        if(!StringUtils.isEmpty(htmlContent)) {
                        // UnZip.unZipIt(GlobalConstants.Temp_PAGE_MODEL_Path, GlobalConstants.PROJECTS_FOLDER_PATH + File.separator + GlobalConstants.SELECTED_PROJECT+File.separator+"src/test/java/com/testProject/pages");
                        //UnZip.unZipIt(GlobalConstants.Config_Temp_page_model_Path, GlobalConstants.CONFIG_TEMP_FOLDER_PATH);

                        Files.copy(source, newdir.resolve(pageName + ".java"), REPLACE_EXISTING);
                        String readPage = Generic.readText(GlobalConstants.SELECTED_PROJECT_PATH + File.separator + GlobalConstants.TEST_FRAMEWORK_TESTPAGES_FOLDER + File.separator + pageName + ".java");

                        readPage = readPage.replace("Temp_PageModel", pageName);

                        Generic.writeText(readPage, GlobalConstants.SELECTED_PROJECT_PATH + File.separator + GlobalConstants.TEST_FRAMEWORK_TESTPAGES_FOLDER + File.separator + pageName + ".java", false);
                        GlobalConstants.New_Created_Page_Name = pageName;
                        FrameworkBuilder.updatePageInit_TestBase(newfileName);

                        GlobalConstants.PAGE_NAME = newfileName;
                        GlobalConstants.PAGE_PATH = GlobalConstants.SELECTED_PROJECT_PATH + File.separator + GlobalConstants.TEST_FRAMEWORK_TESTPAGES_FOLDER + File.separator + pageName + ".java";

                        DomExtractor domExtractor = new DomExtractor();


                            PageBuilder.init_PageBuilder(GlobalConstants.PAGE_PATH, Init.Nav_Url_BySteps_ListModel, GlobalConstants.PAGE_NAME, domExtractor.smartExtractor(txtAreaHtmlCodeEditor.getText(), objList));
                            Frame_Flag.smartbuilder_CreateNewPage_pageNavigation = false;
                            SmartBuilder.initLoad();
                            dispose();
                            JOptionPane.showMessageDialog(null,GlobalConstants.PAGE_NAME+"Page is created ...");
                        } else {
                            JOptionPane.showMessageDialog(null,"Enter Url or Html Content");
                        }

                    }
                } else {
                    JOptionPane.showMessageDialog(null,"Select objects ");
                }
            }
        } catch(Exception e){
            Log.info(e.toString());
            e.printStackTrace();
        }
    }

//
    public synchronized void generic_PageWaitLoad() {
        String str = null;
        try {
            str = (String) ((JavascriptExecutor) GlobalConstants.webDriver)
                    .executeScript("return document.readyState");

        } catch (Exception e) {
            // it's need when JS isn't worked
            generic_PageWaitLoad();
            return;
        }
        while (!str.equals("complete")) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            str = (String) ((JavascriptExecutor) GlobalConstants.webDriver)
                    .executeScript("return document.readyState");
        }
    }
    // Variables declaration - do not modify
    private JButton btnSkip;
    private JButton btnGenerate;
    private JCheckBox cbButton;
    private JCheckBox cbCheckBox;
    private JCheckBox cbComboBox;
    private JCheckBox cbEditBox;
    private JCheckBox cbImage;
    private JCheckBox cbRadioButton;
    private JCheckBox cbSelectAll;
    private JCheckBox cbPageSource;
    private JCheckBox cbText;
    private JCheckBox cblink;
    private javax.swing.JTextField inputPageDesc;
    private javax.swing.JTextField inputPageName;
    private JScrollPane jScrollPane1;
    private JPanel panelMain;
    private JPanel panelObjectControls;
    private JTextArea txtAreaHtmlCodeEditor;
    // End of variables declaration
}

