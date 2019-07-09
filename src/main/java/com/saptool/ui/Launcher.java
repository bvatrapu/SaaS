package com.saptool.ui;

/**
 * Created by bvatrapu on 8/9/2017.
 */

import com.saptool.ui.main.Main;
import com.saptool.utils.*;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Launcher extends JFrame {

    private JLabel imglabel;
    private ImageIcon img;
    private static JProgressBar pbar;
    Thread t = null;

    public Launcher() {
        super("Splash");
        setSize(580, 310);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setUndecorated(true);
        img = new ImageIcon(getClass().getResource("/images/SplashScreen_Pro.png"));
        imglabel = new JLabel(img);
        add(imglabel);
        setLayout(null);
        pbar = new JProgressBar();
        pbar.setMinimum(0);
        pbar.setMaximum(100);
        pbar.setStringPainted(true);
        pbar.setForeground(Color.LIGHT_GRAY);
        imglabel.setBounds(0, 0, 580, 310);
        add(pbar);
        pbar.setPreferredSize(new Dimension(310, 30));
        pbar.setBounds(0, 290, 580, 20);

        Thread t = new Thread() {

            public void run() {
                int i = 0;
                while (i <= 100) {
                    pbar.setValue(i);
                    try {
                        sleep(90);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Launcher.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    i++;
                }
            }
        };
        t.start();
    }

    public static void main(String args[])throws Exception{
        Launcher ss=new Launcher();
        ss.setVisible(true);
        Thread t=Thread.currentThread();
        t.sleep(10000);
        ss.dispose();
        if(setupExtractor()){
            initLoad();
            //t.sleep(500);
            new Main().setVisible(true);
            ss.dispose();
        } else{
            JOptionPane.showMessageDialog(null, "Setup Incomplete", "Terminating.. " , JOptionPane.INFORMATION_MESSAGE);
            ss.dispose();
        }
    }
    public static boolean setupExtractor(){
        boolean flag=true;
        if(!Generic.createFolder(GlobalConstants.ROOT_FOLDER_PATH)){
            flag=false;
        }
        if(!Generic.createFolder(GlobalConstants.PROJECTS_FOLDER_PATH)){
            flag=false;
        }
        if(!Generic.createFolder(GlobalConstants.CONFIG_FOLDER_PATH)){
            flag=false;
        }
        if(!Generic.createFolder(GlobalConstants.CONFIG_PROJECTS_FOLDER_PATH)){
            flag=false;
        }
//        if(!Generic.createFolder(GlobalConstants.CONFIG_TEMP_FOLDER_PATH)){
//            flag=false;
//        }
        if(!Generic.createFolder(GlobalConstants.EXECUTIONS_FOLDER_PATH)){
            flag=false;
        }

        if (!Generic.verifyFileExist(GlobalConstants.CONFIG_PROJECT_PATH)) {
            Generic.createNewFile(GlobalConstants.CONFIG_PROJECT_PATH);
        }

        return flag;
    }

    public static void initLoad(){
        String hubStatus=null;
        CustomTask customTask=new CustomTask();
        customTask.runTask();
        try {
            GlobalConstants.SELECTED_PROJECT = Generic.readProp(GlobalConstants.Prop_Selected_Project);
            if(GlobalConstants.SELECTED_PROJECT!=null) {
                GlobalConstants.SELECTED_PROJECT_PATH = Generic.readProp(GlobalConstants.Prop_Project_Path, GlobalConstants.CONFIG_PROJECTS_FOLDER_PATH + File.separator + GlobalConstants.SELECTED_PROJECT + File.separator + GlobalConstants.config_properties);
            }
            hubStatus = RestApi.callRestApi("http://localhost:4444/grid/api/hub");
            if(!hubStatus.contains("no resp")){
                GlobalConstants.HUB_STATUS=true;
            }
            if(hubStatus.contains("\"total\":20")){
                GlobalConstants.NODE_STATUS=true;
            }

        }catch (Exception e){
            System.out.println("ERROR");
            Log.info(e.getMessage());
            e.printStackTrace();
        }
    }


}