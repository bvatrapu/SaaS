package com.saptool.tables;

import javax.swing.table.AbstractTableModel;
import java.util.List;

/**
 *
 * @author Bharath Kumar Reddy Vatrapu
 */

public class ViewQueueTableModel extends AbstractTableModel {
    private final List<ViewQueueTable> viewQueueTables;

    private final String[] columnNames = new String[] {
            "Sno", "Queue"
    };
    private final Class[] columnClass = new Class[] {
            Integer.class, String.class
    };

    public ViewQueueTableModel(List<ViewQueueTable> viewFileList)
    {
        this.viewQueueTables = viewFileList;
    }

    @Override
    public String getColumnName(int column)
    {
        return columnNames[column];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex)
    {

        return columnClass[columnIndex];
    }

    @Override
    public int getColumnCount()
    {
        return columnNames.length;
    }

    @Override
    public int getRowCount()
    {
        return viewQueueTables.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex)    {
        ViewQueueTable row = viewQueueTables.get(rowIndex);
        if(0 == columnIndex) {
            return row.getSno();
        }
        else if(1 == columnIndex) {
            return row.getPageName();
        }

        return null;
    }
}
