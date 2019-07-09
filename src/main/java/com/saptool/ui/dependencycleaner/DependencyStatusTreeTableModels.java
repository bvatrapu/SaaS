package com.saptool.ui.dependencycleaner;

import java.nio.file.Path;

import de.javagl.treetable.AbstractTreeTableModel;
import de.javagl.treetable.TreeTableModel;

/**
 * Methods to create TreeTableModel instances for a {@link DependencyStatus}
 */
class DependencyStatusTreeTableModels
{
    /**
     * Creates a TreeTableModel for the given {@link DependencyStatus}
     * @param dependencyStatus The {@link DependencyStatus}. This may
     * be <code>null</code>
     * @return The TreeTableModel
     */
    static TreeTableModel create(
        DependencyStatus dependencyStatus)
    {
        DependencyTreeNode root = null;
        if (dependencyStatus != null)
        {
            root = dependencyStatus.getDependencyTreeNode();
        }
        TreeTableModel treeTableModel = new AbstractTreeTableModel(root)
        {
            @Override
            public int getChildCount(Object node)
            {
                DependencyTreeNode dependencyTreeNode = 
                    (DependencyTreeNode)node;
                return dependencyTreeNode.getChildren().size();
            }

            @Override
            public Object getChild(Object node, int childIndex)
            {
                DependencyTreeNode dependencyTreeNode = 
                    (DependencyTreeNode)node;
                return dependencyTreeNode.getChildren().get(childIndex);
            }

            @Override
            public int getColumnCount()
            {
                return 7;
            }

            @Override
            public Object getValueAt(Object node, int column)
            {
                DependencyTreeNode dependencyTreeNode = 
                    (DependencyTreeNode)node;
                Path path = dependencyTreeNode.getPath();
                ArtifactInfo artifactInfo = 
                    dependencyTreeNode.getArtifactInfo();
                if (artifactInfo == null)
                {
                    artifactInfo = new ArtifactInfo("", "", "");
                }
                switch (column) 
                {
                    case 0:
                        return this;
                    case 1:
                        return artifactInfo.getGroupId();
                    case 2:
                        return artifactInfo.getArtifactId();
                    case 3:
                        return artifactInfo.getVersion();
                    case 4:
                        return dependencyStatus.isValidPath(path);
                    case 5: 
                        return dependencyStatus.isPathToRemove(path);
                    case 6: 
                        return path;
                }
                return "?";
            }
            
            @Override
            public void setValueAt(Object aValue, Object node, int column)
            {
                if (column == 5)
                {
                    DependencyTreeNode dependencyTreeNode =
                        (DependencyTreeNode)node;
                    Path path = dependencyTreeNode.getPath();
                    boolean toRemove = Boolean.valueOf(String.valueOf(aValue));
                    dependencyStatus.setPathToRemove(path, toRemove);
                }
            }
            
            @Override
            public boolean isCellEditable(Object node, int column)
            {
                return super.isCellEditable(node, column) || column == 5;
            }

            @Override
            public String getColumnName(int column)
            {
                switch (column) 
                {
                    case 0: 
                        return "Dependencies";
                    case 1:
                        return "group ID";
                    case 2:
                        return "artifact ID";
                    case 3:
                        return "version";
                    case 4:
                        return "valid?";
                    case 5: 
                        return "remove?";
                    case 6: 
                        return "path";
                }
                return "?";
            }

            @Override
            public Class<?> getColumnClass(int column)
            {
                if (column == 0)
                {
                    return TreeTableModel.class;                    
                }
                if (column == 5)
                {
                    return Boolean.class;
                }
                return Object.class;
            }
        };
        return treeTableModel;
    }
    
    
    
    /**
     * Private constructor to prevent instantiation
     */
    private DependencyStatusTreeTableModels()
    {
        // Private constructor to prevent instantiation
    }
    
    
}
