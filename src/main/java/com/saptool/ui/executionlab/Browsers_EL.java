package com.saptool.ui.executionlab;


import com.saptool.ui.Init;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author Bharath Kumar Reddy Vatrapu
 */
public class Browsers_EL extends JPanel {

    public static ButtonGroup bgBrowsers = new ButtonGroup();
    /**
     * Creates new form Browsers_EL
     */
    public Browsers_EL() {
        initComponents();
    }


    private void initComponents() {

        iconChrome = new JLabel();
        rbChrome = new JRadioButton();
        iconFirefox = new JLabel();
        rbFirefox = new JRadioButton();
        iconIE11 = new JLabel();
        rbIE11 = new JRadioButton();
        iconSafari = new JLabel();
        rbSafari = new JRadioButton();
        iconEdge = new JLabel();
        rbEdge = new JRadioButton();
        checkboxHeadless = new JCheckBox();
        btnRight = new JButton();
        btnLeft = new JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        iconChrome.setIcon(new ImageIcon(getClass().getResource("/icons/ExecutionLab/Chrome_62px.png")));
        iconChrome.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                rbChrome.setSelected(true);
            }
        });
        rbChrome.setBackground(new java.awt.Color(255, 255, 255));
        rbChrome.setFont(new java.awt.Font("Tahoma", 1, 18));
        rbChrome.setForeground(new java.awt.Color(51, 0, 153));
        rbChrome.setText("CHROME");
        rbChrome.setSelected(true);

        iconFirefox.setIcon(new ImageIcon(getClass().getResource("/icons/ExecutionLab/Firefox_62px.png")));
        iconFirefox.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                rbFirefox.setSelected(true);
            }
        });
        rbFirefox.setBackground(new java.awt.Color(255, 255, 255));
        rbFirefox.setFont(new java.awt.Font("Tahoma", 1, 18));
        rbFirefox.setForeground(new java.awt.Color(51, 0, 153));
        rbFirefox.setText("FIREFOX");

        iconIE11.setIcon(new ImageIcon(getClass().getResource("/icons/ExecutionLab/Internet_Explorer_62px.png")));
        iconIE11.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                rbIE11.setSelected(true);
            }
        });
        rbIE11.setBackground(new java.awt.Color(255, 255, 255));
        rbIE11.setFont(new java.awt.Font("Tahoma", 1, 18));
        rbIE11.setForeground(new java.awt.Color(51, 0, 153));
        rbIE11.setText("IE11");

        iconSafari.setIcon(new ImageIcon(getClass().getResource("/icons/ExecutionLab/Safari_62px.png")));
        iconSafari.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                rbSafari.setSelected(true);
            }
        });
        rbSafari.setBackground(new java.awt.Color(255, 255, 255));
        rbSafari.setFont(new java.awt.Font("Tahoma", 1, 18));
        rbSafari.setForeground(new java.awt.Color(51, 0, 153));
        rbSafari.setText("SAFARI");

        iconEdge.setIcon(new ImageIcon(getClass().getResource("/icons/ExecutionLab/Microsoft_Edge_62px.png")));
        iconEdge.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                rbEdge.setSelected(true);
            }
        });
        rbEdge.setBackground(new java.awt.Color(255, 255, 255));
        rbEdge.setFont(new java.awt.Font("Tahoma", 1, 18));
        rbEdge.setForeground(new java.awt.Color(51, 0, 153));
        rbEdge.setText("EDGE");

        bgBrowsers.add(rbChrome);
        bgBrowsers.add(rbFirefox);
        bgBrowsers.add(rbEdge);
        bgBrowsers.add(rbIE11);
        bgBrowsers.add(rbSafari);

        checkboxHeadless.setBackground(new java.awt.Color(255, 255, 255));
        checkboxHeadless.setFont(new java.awt.Font("Tahoma", 1, 24));
        checkboxHeadless.setForeground(new java.awt.Color(204, 102, 0));
        checkboxHeadless.setText("Headless");
        checkboxHeadless.addActionListener(actionListener);

        btnRight.setBackground(new java.awt.Color(255, 255, 255));
        btnRight.setIcon(new ImageIcon(getClass().getResource("/icons/ExecutionLab/Sort_Right_100px.png")));
        btnRight.setBorder(null);
        btnRight.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnRightActionPerformed(evt);
            }
        });

        btnLeft.setBackground(new java.awt.Color(255, 255, 255));
        btnLeft.setIcon(new ImageIcon(getClass().getResource("/icons/ExecutionLab/Sort_Left_100px_1.png")));
        btnLeft.setBorder(null);
        btnLeft.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnLeftActionPerformed(evt);
            }
        });

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(btnLeft, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
                                .addGap(85, 85, 85)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addComponent(iconChrome))
                                        .addComponent(rbChrome))
                                .addGap(46, 46, 46)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addComponent(iconFirefox))
                                        .addComponent(rbFirefox))
                                .addGap(58, 58, 58)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(iconIE11)
                                        .addComponent(rbIE11))
                                .addGap(49, 49, 49)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addComponent(iconSafari))
                                        .addComponent(rbSafari))
                                .addGap(66, 66, 66)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(rbEdge)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(14, 14, 14)
                                                .addComponent(iconEdge)))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 137, Short.MAX_VALUE)
                                .addComponent(btnRight, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(checkboxHeadless)
                                .addGap(96, 96, 96))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(80, 80, 80)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                        .addComponent(btnRight, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(btnLeft, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addContainerGap(65, Short.MAX_VALUE)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(iconChrome)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(rbChrome))
                                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                .addGroup(layout.createSequentialGroup()
                                                                        .addComponent(iconFirefox)
                                                                        .addGap(18, 18, 18)
                                                                        .addComponent(rbFirefox))
                                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                                .addComponent(iconEdge)
                                                                                .addGroup(layout.createSequentialGroup()
                                                                                        .addGap(80, 80, 80)
                                                                                        .addComponent(rbEdge)))
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addComponent(iconSafari)
                                                                                .addGap(18, 18, 18)
                                                                                .addComponent(rbSafari))
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addComponent(iconIE11)
                                                                                .addGap(18, 18, 18)
                                                                                .addComponent(rbIE11)))))
                                                .addGap(40, 40, 40)))
                                .addComponent(checkboxHeadless)
                                .addContainerGap())
        );
    }

    private void btnRightActionPerformed(ActionEvent evt) {
        Init.testBrowser = getBrowser().toLowerCase();
        ExecutionLab.setpanelNotVisible();
        ExecutionLab.testNgParams.setVisible(true);
        TestNgParams_EL.init_Load();
    }

    private void btnLeftActionPerformed(ActionEvent evt) {
        ExecutionLab.setpanelNotVisible();
        ExecutionLab.platform.setVisible(true);
    }
    ActionListener actionListener = new ActionListener() {
        public void actionPerformed(ActionEvent actionEvent) {
            AbstractButton abstractButton = (AbstractButton) actionEvent.getSource();
            boolean selected = abstractButton.getModel().isSelected();

            if(selected){
                Init.testPlatform = "headless";
                rbEdge.setEnabled(false);
                rbIE11.setEnabled(false);
                rbSafari.setEnabled(false);
            } else {
                Init.testPlatform = "desktop";
                rbEdge.setEnabled(true);
                rbIE11.setEnabled(true);
                rbSafari.setEnabled(true);
            }
            rbChrome.setSelected(true);
            // abstractButton.setText(newLabel);
        }
    };
    public static String getBrowser(){
        if(rbSafari.isSelected()){
            return rbEdge.getText();
        }else if(rbEdge.isSelected()){
            return rbEdge.getText();
        } else if(rbIE11.isSelected()){
            return rbIE11.getText();
        } else if (rbFirefox.isSelected()){
            return rbFirefox.getText();
        } else{
            return rbChrome.getText();
        }
    }
    // Variables declaration - do not modify
    private JButton btnLeft;
    private JButton btnRight;
    private JCheckBox checkboxHeadless;
    private JLabel iconChrome;
    private JLabel iconEdge;
    private JLabel iconFirefox;
    private JLabel iconIE11;
    private JLabel iconSafari;
    public static JRadioButton rbChrome;
    public static JRadioButton rbEdge;
    public static JRadioButton rbFirefox;
    public static JRadioButton rbIE11;
    public static JRadioButton rbSafari;
    // End of variables declaration
}
