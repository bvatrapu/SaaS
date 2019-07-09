package com.saptool.ui.SmartHub.SmartBuilder.SmartComponent.Templates;


import com.saptool.frameworkbuilder.PageBuilder;
import com.saptool.tables.ViewPageObjectsTable;
import com.saptool.tables.ViewPageObjectsTableModel;
import com.saptool.ui.Frame_Flag;
import com.saptool.ui.Init;
import com.saptool.ui.UI_Design;
import com.saptool.utils.Generic;
import com.saptool.utils.GlobalConstants;
import org.apache.commons.lang3.StringUtils;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Bharath Kumar Reddy Vatrapu
 */
public class Click_Link_Verify_TargetPage extends JFrame {
    public static ViewPageObjectsTableModel viewPageObjectsTableModel = null;
    private static final String upString = "Move up";
    private static final String downString = "Move down";
    private static final String deleteString = "Delete";

    public static String selected_table_row = null;

    static DefaultTableModel defaultTableModel;
    /**
     * Creates new form objects_existance
     */
    public Click_Link_Verify_TargetPage() {
        initComponents();
    }


    private void initComponents() {

        mainPanel = new JPanel();
        headerPanel = new JPanel();
        inputMethodName = new JTextField();
        inputMethodDesc = new JTextField();
        inputSearch = new JTextField();
        btnSearch = new JButton();
        btnClose = new JButton();
        tablePanel = new JPanel();
        jScrollPane2 = new JScrollPane();
        tblLoad = new JTable();
        jPanel1 = new JPanel();
        btnAdd = new JButton();
        btnCreate = new JButton();
        jPanel2 = new JPanel();
        btnUp = new JButton();
        btnDown = new JButton();
        btnDelete = new JButton();
        btnSwap = new JButton();
        MethodStepPanel = new JPanel();
        jScrollPane1 = new JScrollPane();
        listMethodSteps = new JList<>();

        UI_Design.frame_boarder(this);

        mainPanel.setBackground(new Color(255, 255, 255));

        headerPanel.setBackground(new Color(255, 255, 255));

        inputMethodName.setFont(new Font("Tahoma", 0, 22));
        inputMethodName.setForeground(new Color(153, 153, 255));
        inputMethodName.setText("  Method Name");
        inputMethodName.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                inputMethodName.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
                if(inputMethodName.getText().trim().contains("Method Name")){
                    inputMethodName.setText("");
                }
            }
            public void focusLost(FocusEvent e) {
                if(StringUtils.isEmpty(inputMethodName.getText())){
                    inputMethodName.setText("  Method Name");
                }
            }

        });

        inputMethodDesc.setFont(new Font("Tahoma", 0, 22));
        inputMethodDesc.setForeground(new Color(153, 153, 255));
        inputMethodDesc.setText("  Method Description");
        inputMethodDesc.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                if(inputMethodDesc.getText().trim().contains("Method Description")){
                    inputMethodDesc.setText("");
                }
            }
            public void focusLost(FocusEvent e) {
                if(StringUtils.isEmpty(inputMethodDesc.getText())){
                    inputMethodDesc.setText("  Method Description");
                }
            }

        });


        inputSearch.setFont(new Font("Tahoma", 0, 22));
        inputSearch.setForeground(new Color(153, 0, 153));
        inputSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                inputSearchKeyReleased(evt);
            }
        });

        btnSearch.setFocusPainted(false);
        btnSearch.setBorder(null);
        btnSearch.setBackground(new Color(255, 255, 255));
        btnSearch.setIcon(new ImageIcon(getClass().getResource("/icons/smarthub/Search_32px.png")));
        btnSearch.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        btnClose.setFocusPainted(false);
        btnClose.setBorder(null);
        btnClose.setBackground(new Color(255, 255, 255));
        btnClose.setIcon(new ImageIcon(getClass().getResource("/icons/smarthub/Close_Window_32px.png")));
        btnClose.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        GroupLayout headerPanelLayout = new GroupLayout(headerPanel);
        headerPanel.setLayout(headerPanelLayout);
        headerPanelLayout.setHorizontalGroup(
                headerPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(headerPanelLayout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(inputMethodName, GroupLayout.PREFERRED_SIZE, 306, GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(inputMethodDesc, GroupLayout.PREFERRED_SIZE, 306, GroupLayout.PREFERRED_SIZE)
                                .addGap(58, 58, 58)
                                .addComponent(inputSearch, GroupLayout.PREFERRED_SIZE, 306, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSearch, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                                .addComponent(btnClose, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
        );
        headerPanelLayout.setVerticalGroup(
                headerPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(headerPanelLayout.createSequentialGroup()
                                .addComponent(btnClose, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                        .addGroup(GroupLayout.Alignment.TRAILING, headerPanelLayout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addGroup(headerPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(btnSearch, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                        .addGroup(headerPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                .addComponent(inputMethodName)
                                                .addComponent(inputMethodDesc)
                                                .addComponent(inputSearch)))
                                .addContainerGap())
        );

        tablePanel.setBackground(new Color(102, 102, 255));

        tblLoad.setModel(new DefaultTableModel(
                new Object [][] {
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null}
                },
                new String [] {
                        "Title 1", "Title 2", "Title 3", "Title 4"
                }
        ));
        jScrollPane2.setViewportView(tblLoad);
        UI_Design.table_ui_style_blue(tblLoad);
        tblLoad.setModel(getObjectsModel());
        UI_Design.table_dimenetions_newMethod(tblLoad);
        tblLoad.getSelectionModel().addListSelectionListener(new SelectionListener());

        GroupLayout tablePanelLayout = new GroupLayout(tablePanel);
        tablePanel.setLayout(tablePanelLayout);
        tablePanelLayout.setHorizontalGroup(
                tablePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane2)
        );
        tablePanelLayout.setVerticalGroup(
                tablePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 299, GroupLayout.PREFERRED_SIZE)
        );

        jPanel1.setBackground(new Color(255, 255, 255));


        UI_Design.button_ui_style_violet(btnAdd,"ADD");
        btnAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        UI_Design.button_ui_style_violet(btnCreate,"CREATE");
        btnCreate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnCreateActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new Color(255, 255, 255));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new Color(204, 204, 204), 1, true));

        btnUp.setFocusPainted(false);
        btnUp.setBorder(null);
        btnUp.setBackground(new Color(255, 255, 255));
        btnUp.setIcon(new ImageIcon(getClass().getResource("/icons/smarthub/Up_Squared_48px.png")));
        btnUp.setToolTipText("UP");
        btnUp.setActionCommand(upString);
        btnUp.addActionListener(new UpDownListener());

        btnDown.setFocusPainted(false);
        btnDown.setBorder(null);
        btnDown.setBackground(new Color(255, 255, 255));
        btnDown.setIcon(new ImageIcon(getClass().getResource("/icons/smarthub/Drop_Down_48px.png")));
        btnDown.setToolTipText("DOWN");
        btnDown.setActionCommand(downString);
        btnDown.addActionListener(new UpDownListener());

        btnDelete.setFocusPainted(false);
        btnDelete.setBorder(null);
        btnDelete.setBackground(new Color(255, 255, 255));
        btnDelete.setIcon(new ImageIcon(getClass().getResource("/icons/smarthub/Reduce_48px.png")));
        btnDelete.setToolTipText("DELETE");
        btnDelete.setActionCommand(deleteString);
        btnDelete.addActionListener(new DeleteButtonListener());

        btnSwap.setFocusPainted(false);
        btnSwap.setBorder(null);
        btnSwap.setBackground(new Color(255, 255, 255));
        btnSwap.setIcon(new ImageIcon(getClass().getResource("/icons/smarthub/Root_48px.png")));
        btnSwap.setToolTipText("SWAP");
        btnSwap.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnSwapActionPerformed(evt);
            }
        });

        GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(btnUp, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                                .addGap(47, 47, 47)
                                .addComponent(btnDown, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                                .addGap(51, 51, 51)
                                .addComponent(btnDelete, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                                .addGap(39, 39, 39)
                                .addComponent(btnSwap, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(btnUp, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnDown, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnDelete, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnSwap, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(79, 79, 79)
                                .addComponent(btnAdd, GroupLayout.PREFERRED_SIZE, 183, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnCreate, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE)
                                .addGap(138, 138, 138)
                                .addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(jPanel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnCreate, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnAdd, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );

        MethodStepPanel.setBackground(new Color(255, 255, 255));

        listMethodSteps.setFont(new Font("Tahoma", 0, 18));
        listMethodSteps.setForeground(new Color(51, 0, 153));
        jScrollPane1.setViewportView(listMethodSteps);

        GroupLayout MethodStepPanelLayout = new GroupLayout(MethodStepPanel);
        MethodStepPanel.setLayout(MethodStepPanelLayout);
        MethodStepPanelLayout.setHorizontalGroup(
                MethodStepPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1)
        );
        MethodStepPanelLayout.setVerticalGroup(
                MethodStepPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE)
        );

        GroupLayout mainPanelLayout = new GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
                mainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(headerPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tablePanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(MethodStepPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        mainPanelLayout.setVerticalGroup(
                mainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(mainPanelLayout.createSequentialGroup()
                                .addComponent(headerPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tablePanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(MethodStepPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    public static void init_Load(){
        Init.page_method_steps_ListModel.removeAllElements();
//        defaultTableModel = (DefaultTableModel) tblLoad.getModel();
    }
    private void btnAddActionPerformed(ActionEvent evt) {
        boolean flag = true;
        String read_args=null;
        if (selected_table_row==null){
            JOptionPane.showMessageDialog(null,"Select Operation or Method !!!");
            flag=false;
            return;
        }
        if(flag) {
           if(Generic.veirfyDuplicateListValues(Init.page_method_steps_ListModel,selected_table_row)){
               JOptionPane.showMessageDialog(null,"Already added :: "+selected_table_row);
           } else {
               Init.page_method_steps_ListModel.addElement(selected_table_row);
               listMethodSteps.setModel(Init.page_method_steps_ListModel);
           }
        }
    }

    private void btnCreateActionPerformed(ActionEvent evt) {
        if(StringUtils.isEmpty(inputMethodName.getText())||inputMethodName.getText().trim().contains("Method Name")||StringUtils.isEmpty(inputMethodDesc.getText())||inputMethodDesc.getText().trim().contains("Method Desciption")){
            JOptionPane.showMessageDialog(null,"Enter Correct MethodName");
            inputMethodName.setBorder(BorderFactory.createLineBorder(new Color(255, 0, 0)));
        } else {

            if (listMethodSteps.getModel().getSize() == 0) {
                JOptionPane.showMessageDialog(null, "Develop Method steps");
            } else {
                GlobalConstants.Method_Name = Generic.removeSpecialChars(inputMethodName.getText());
                GlobalConstants.Method_Description = inputMethodDesc.getText();

                DefaultListModel defaultListModel = new DefaultListModel();
                defaultListModel.clear();
                for (int i = 0; i < listMethodSteps.getModel().getSize(); i++) {
                    defaultListModel.addElement(String.valueOf(listMethodSteps.getModel().getElementAt(i)));
                }
                String pagePath = GlobalConstants.SELECTED_PROJECT_PATH + File.separator +GlobalConstants.TEST_FRAMEWORK_TESTPAGES_FOLDER+File.separator+GlobalConstants.TestScript_Selected_Page_Name+".java";
                String readPageModel = Generic.readText(pagePath);
                if(readPageModel.contains("public String "+GlobalConstants.Method_Name)){
                    JOptionPane.showMessageDialog(null,"Already exist Mehthod with Name::"+GlobalConstants.Method_Name);
                }else{
                    PageBuilder.pageBuilder(PageBuilder.method_temp_click_link_verify_TargetPage_Builder(defaultListModel,inputMethodDesc.getText()), "METHOD");
                    Frame_Flag.template_click_link_verify_targetpage=false;
                    Frame_Flag.smartBuilder_smartComponent=false;
                    Frame_Flag.smartBuilder_smartComponent_temlpate=false;
                    dispose();
                }
            }
        }

    }
    private void btnSwapActionPerformed(ActionEvent evt) {
        int swapEle[]=listMethodSteps.getSelectedIndices();
        swap(swapEle[0], swapEle[1]);
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        /* Create and display the form */
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Click_Link_Verify_TargetPage().setVisible(true);
            }
        });
    }

    public static ViewPageObjectsTableModel getObjectsModel() {
        int i=1;
        List<String> listObjects = new ArrayList<String>();
        listObjects = getObjects();
        List<ViewPageObjectsTable> viewObjects = new ArrayList<ViewPageObjectsTable>();
        for (int j=0;j<=listObjects.size()-1;j++) {
            if(getObjectType(listObjects.get(j)).equalsIgnoreCase("Link")) {
                ViewPageObjectsTable viewFileTable = new ViewPageObjectsTable(i, listObjects.get(j), getObjectType(listObjects.get(j)));
                viewObjects.add(viewFileTable);
                i = i + 1;
            }
        }
        viewPageObjectsTableModel = new ViewPageObjectsTableModel(viewObjects);


        return viewPageObjectsTableModel;
    }
    public static List<String> getObjects() {
        List<String> listObjects = new ArrayList<String>();
        String readPageModel = Generic.readText(GlobalConstants.SELECTED_PROJECT_PATH+ File.separator+GlobalConstants.TEST_FRAMEWORK_TESTPAGES_FOLDER+ File.separator+GlobalConstants.SELECTED_PAGE+".java");

        String objects=null;
        objects=readPageModel.substring(readPageModel.indexOf("//SAP-START - OBJECT DECLARAITON"),readPageModel.indexOf("//SAP-END - OBJECT DECLARAITON"));

        objects = objects.replaceAll("//SAP-START - OBJECT DECLARAITON","");

//        String[] lines = operations.split(System.getProperty("line.separator"));

        Scanner scanner = new Scanner(objects);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();

            if(line.contains("public WebElement")){
                listObjects.add(line.substring(line.indexOf("\tpublic WebElement "), line.indexOf(";")).replaceAll("public WebElement ",""));
            }
        }
        scanner.close();
        return listObjects;
    }
    public static String getObjectType(String obj){
        if(obj.contains("lnk")){
            return "Link";
        } if(obj.contains("btn")){
            return "Button";
        } if(obj.contains("chkbox")){
            return "CheckBox";
        } if(obj.contains("input")){
            return "EditBox";
        } if(obj.contains("img")){
            return "Image";
        } if(obj.contains("textarea")){
            return "TextArea";
        } if(obj.contains("radio")){
            return "RadioButton";
        } if(obj.contains("txt")){
            return "Text";
        } else{
            return "Other";
        }
    }
    class UpDownListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            //This method can be called only when
            //there's a valid selection,
            //so go ahead and move the list item.

            int moveMe = listMethodSteps.getSelectedIndex();

            if (e.getActionCommand().equals(upString)) {
                //UP ARROW BUTTON
                if (moveMe != 0) {
                    //not already at top
                    swap(moveMe, moveMe - 1);
                    listMethodSteps.setSelectedIndex(moveMe - 1);
                    listMethodSteps.ensureIndexIsVisible(moveMe - 1);
                }
            } else {
                //DOWN ARROW BUTTON
                if (moveMe != Init.page_method_steps_ListModel.getSize() - 1) {
                    //not already at bottom
                    swap(moveMe, moveMe + 1);
                    listMethodSteps.setSelectedIndex(moveMe + 1);
                    listMethodSteps.ensureIndexIsVisible(moveMe + 1);
                }
            }
        }
    }
    class DeleteButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            /*
             * This method can be called only if there's a valid selection, so
             * go ahead and remove whatever's selected.
             */

            ListSelectionModel lsm = listMethodSteps.getSelectionModel();
            int firstSelected = lsm.getMinSelectionIndex();
            int lastSelected = lsm.getMaxSelectionIndex();
            Init.page_method_steps_ListModel.removeRange(firstSelected, lastSelected);

            int size = Init.page_method_steps_ListModel.size();

            if (size == 0) {
                //List is empty: disable delete, up, and down buttons.
//                btnDelete.setEnabled(false);
//                btnUp.setEnabled(false);
//                btnDown.setEnabled(false);
//                btnSwap.setEnabled(false);

            } else {
                //Adjust the selection.
                if (firstSelected == Init.page_method_steps_ListModel.getSize()) {
                    //Removed item in last position.
                    firstSelected--;
                }
                listMethodSteps.setSelectedIndex(firstSelected);
            }
        }
    }
    private void swap(int a, int b) {
        Object aObject = Init.page_method_steps_ListModel.getElementAt(a);
        Object bObject = Init.page_method_steps_ListModel.getElementAt(b);
        Init.page_method_steps_ListModel.set(a, bObject);
        Init.page_method_steps_ListModel.set(b, aObject);
    }
    class SelectionListener implements ListSelectionListener {
        public void valueChanged(ListSelectionEvent e) {
            if(e.getValueIsAdjusting())
                return;
            int row = tblLoad.getSelectedRow();
            if(row < 0)
                return;
            int col = tblLoad.getSelectedColumn();
            if(col < 0)
                return;

            if (tblLoad.getRowSorter()!=null) {
                row = tblLoad.getRowSorter().convertRowIndexToModel(row);
            }
            //tblProjects.clearSelection();
            selected_table_row = (String) tblLoad.getModel().getValueAt(row, 1);
            GlobalConstants.TABLE_SELECTED_PROJECT = selected_table_row;

            tblLoad.setSelectionBackground(Color.ORANGE);
            //  txtProjectName.setText(selected_TestScript.toUpperCase());

        }
    }

    public static void filter(String query){
        TableRowSorter<ViewPageObjectsTableModel> tr=new TableRowSorter<ViewPageObjectsTableModel>(viewPageObjectsTableModel);
        tblLoad.setRowSorter(tr);

        tr.setRowFilter(RowFilter.regexFilter(query));
    }

    private void inputSearchKeyReleased(java.awt.event.KeyEvent evt) {
        filter(inputSearch.getText());
    }
    private void btnSearchActionPerformed(ActionEvent evt) {
        filter(inputSearch.getText());
    }
    private void btnCloseActionPerformed(ActionEvent evt) {

        Frame_Flag.template_Object_existance=false;
        Frame_Flag.smartBuilder_smartComponent=false;

        Frame_Flag.smartBuilder_smartComponent_temlpate=false;
        dispose();
    }
    // Variables declaration - do not modify
    private JPanel MethodStepPanel;
    private JButton btnAdd;
    private JButton btnClose;
    private JButton btnCreate;
    private JButton btnDown;
    private JButton btnDelete;
    private JButton btnSwap;
    private JButton btnSearch;
    private JButton btnUp;
    private JPanel headerPanel;
    private JTextField inputMethodDesc;
    private JTextField inputMethodName;
    private JTextField inputSearch;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private JList<String> listMethodSteps;
    private JPanel mainPanel;
    private JPanel tablePanel;
    public static JTable tblLoad;
    // End of variables declaration
}

