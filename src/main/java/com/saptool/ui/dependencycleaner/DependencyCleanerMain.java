package com.saptool.ui.dependencycleaner;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 * The entry point of the application
 */
public class DependencyCleanerMain
{
    /**
     * The entry point
     * 
     * @param args Not used
     */
    public static void main(final String[] args)
    {
        SwingUtilities.invokeLater(() -> createAndShowGui());
    }

    /**
     * Creates and shows the GUI, to be called on the Event Dispatch Thread
     */
    public static void createAndShowGui(){
        DependencyCleanerApplication a = new DependencyCleanerApplication();
        JFrame f = a.getFrame();
        f.setVisible(true);
    }
}


