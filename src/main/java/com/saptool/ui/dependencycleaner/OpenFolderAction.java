package com.saptool.ui.dependencycleaner;

import java.awt.Component;
import java.awt.Desktop;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

import javax.swing.JTable;

import de.javagl.common.ui.LocationBasedAction;

/**
 * A location based action, to be attached to a JTable, that allows
 * opening the folder that contains a file whose name is found in
 * a certain column in the table
 */
class OpenFolderAction extends LocationBasedAction
{
    /**
     * The logger used in this class
     */
    private static final Logger logger = 
        Logger.getLogger(OpenFolderAction.class.getName());
    
    /**
     * Serial UID
     */
    private static final long serialVersionUID = -216441085618613845L;
    
    /**
     * The column containing the file name
     */
    private final int fileNameColumnIndex;
    
    /**
     * The directory that will be opened
     */
    private File directory;
    
    /**
     * Creates a new action
     * 
     * @param fileNameColumnIndex The column containing the file name
     */
    OpenFolderAction(int fileNameColumnIndex)
    {
        this.fileNameColumnIndex = fileNameColumnIndex;
    }

    @Override
    protected void prepareShow(Component component, int x, int y)
    {
        Point p = new Point(x,y);
        JTable table = (JTable)component;
        int viewRow = table.rowAtPoint(p);
        int modelRow = table.convertRowIndexToModel(viewRow);
        Object value = table.getModel().getValueAt(
            modelRow, fileNameColumnIndex);
        String fileName = String.valueOf(value);
        File file = new File(fileName);
        directory = file.getParentFile();
        if (!directory.exists())
        {
            setEnabled(false);
            putValue(NAME, 
                "Folder not found: "+directory.getAbsolutePath());
        }
        else
        {
            setEnabled(true);
            putValue(NAME, 
                "Open folder containing "+file.getName());
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        try
        {
            Desktop.getDesktop().open(directory);
        }
        catch (IOException ex)
        {
            logger.warning(ex.getMessage());
        }
    }
}