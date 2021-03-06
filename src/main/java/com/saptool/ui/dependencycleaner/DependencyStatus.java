package com.saptool.ui.dependencycleaner;

import java.nio.file.Path;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

/**
 * Simple representation of the status of a hierarchy of dependencies
 */
class DependencyStatus
{
    /**
     * The {@link DependencyTreeNode}
     */
    private final DependencyTreeNode dependencyTreeNode;
    
    /**
     * The mapping from paths to their status. The status may either
     * be <code>true</code> or <code>false</code> indicating whether
     * the path is valid, or <code>null</code> if the path does not
     * exist
     */
    private final Map<Path, Boolean> validPaths;
    
    /**
     * The paths that should be removed
     */
    private final Set<Path> pathsToRemove;
    
    /**
     * Creates a new instance
     * 
     * @param dependencyTreeNode The {@link DependencyTreeNode}
     * @param validPaths The valid paths
     * @param pathsToRemove The paths to remove
     */
    DependencyStatus(DependencyTreeNode dependencyTreeNode,
        Map<Path, Boolean> validPaths, Set<Path> pathsToRemove)
    {
        this.dependencyTreeNode = dependencyTreeNode;
        this.validPaths = validPaths;
        this.pathsToRemove = pathsToRemove;
    }
    
    /**
     * Returns the {@link DependencyTreeNode}
     * 
     * @return The {@link DependencyTreeNode}
     */
    DependencyTreeNode getDependencyTreeNode()
    {
        return dependencyTreeNode;
    }
    
    /**
     * Returns whether the given path is valid, or <code>null</code> if the
     * given path does not exist
     * 
     * @param path The path
     * @return Whether the path is valid
     */
    Boolean isValidPath(Path path) 
    {
        return validPaths.get(path);
    }
    
    /**
     * Set whether the given path is valid
     * 
     * @param path The path
     * @param state The state
     */
    void setValidPath(Path path, Boolean state)
    {
        if (state == null)
        {
            validPaths.remove(path);
        }
        else
        {
            validPaths.put(path, state);
        }
    }
    
    /**
     * Returns whether the given path should be removed
     * 
     * @param path The path
     * @return Whether the path should be removed. Returns <code>null</code>
     * if the path is not known
     */
    Boolean isPathToRemove(Path path) 
    {
        if (path == null)
        {
            return null;
        }
        return pathsToRemove.contains(path);
    }
    
    /**
     * Set whether the given path should be removed
     * 
     * @param path The path
     * @param toRemove Whether the path should be removed
     */
    void setPathToRemove(Path path, boolean toRemove) 
    {
        if (toRemove) 
        {
            pathsToRemove.add(path);
        }
        else
        {
            pathsToRemove.remove(path);
        }
    }
    
    /**
     * Returns an unmodifiable view on the paths that should be removed
     * 
     * @return The paths
     */
    Set<Path> getPathsToRemove()
    {
        return Collections.unmodifiableSet(pathsToRemove);
    }
    
}