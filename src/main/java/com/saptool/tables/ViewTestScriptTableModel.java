package com.saptool.tables;

import javax.swing.table.AbstractTableModel;
import java.util.List;

/**
 *
 * @author Bharath Kumar Reddy Vatrapu
 */
public class ViewTestScriptTableModel extends AbstractTableModel {
    private final List<ViewTestScriptTable> viewTestScriptList;

    private final String[] columnNames = new String[] {
            "Step No", "Description", "Expected"
    };
    private final Class[] columnClass = new Class[] {
            Integer.class, String.class,String.class
    };

    public ViewTestScriptTableModel(List<ViewTestScriptTable> viewFileList)
    {
        this.viewTestScriptList = viewFileList;
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
        return viewTestScriptList.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex)    {
        ViewTestScriptTable row = viewTestScriptList.get(rowIndex);
        if(0 == columnIndex) {
            return row.getStepno();
        }
        else if(1 == columnIndex) {
            return row.getStepDesc();
        }
        else if(2 == columnIndex){
            return row.getStepExpected();
        }
        return null;
    }
}
