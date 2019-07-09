package com.saptool.ui.dependencycleaner;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;

import javax.swing.TransferHandler;

/**
 * Implementation of a transfer handler that allows transferring files or
 * links into the application using drag-and-drop 
 */
class FileTransferHandler extends TransferHandler 
{
    /**
     * Serial UID 
     */
    private static final long serialVersionUID = 8076904632972988378L;
    
    /**
     * The consumer for the files
     */
    private final Consumer<? super List<? extends File>> fileConsumer;
    
    /**
     * Default constructor
     * 
     * @param fileConsumer The consumer for the files 
     */
    FileTransferHandler(Consumer<? super List<? extends File>> fileConsumer)
    {
        this.fileConsumer = Objects.requireNonNull(fileConsumer);
    }
    
    @Override
    public boolean canImport(TransferSupport support)
    {
        if (!support.isDataFlavorSupported(DataFlavor.javaFileListFlavor)) 
        {
            return false;
        }
        support.setDropAction(COPY);
        return true;
    }

    @Override
    public boolean importData(TransferSupport support)
    {
        if (!canImport(support)) 
        {
            return false;
        }
        Transferable transferable = support.getTransferable();
        List<File> fileList = getFileListOptional(transferable);
        if (fileList != null)
        {
            fileConsumer.accept(fileList);
            return true;
        }
        return false;
    }
    
    /**
     * Obtains the transfer data from the given Transferable as a file list,
     * or returns <code>null</code> if the data can not be obtained
     * 
     * @param transferable The transferable
     * @return The file list, or <code>null</code>
     */
    private static List<File> getFileListOptional(Transferable transferable)
    {
        try
        {
            Object transferData = 
                transferable.getTransferData(DataFlavor.javaFileListFlavor);
            @SuppressWarnings("unchecked")
            List<File> fileList = (List<File>)transferData;
            return fileList;
        } 
        catch (UnsupportedFlavorException e)
        {
            return null;
        } 
        catch (IOException e)
        {
            return null;
        }
    }
    
    
}