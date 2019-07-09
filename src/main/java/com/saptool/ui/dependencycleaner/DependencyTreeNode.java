package com.saptool.ui.dependencycleaner;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * A simple model for a node in a dependency hierarchy
 */
class DependencyTreeNode
{
    /**
     * The name of this node
     */
    private final String name;

    /**
     * The {@link ArtifactInfo}
     */
    private final ArtifactInfo artifactInfo;
    
    /**
     * The path that is represented by this node
     */
    private final Path path;
    
    /**
     * The children of this node
     */
    private final List<DependencyTreeNode> children;
    
    /**
     * Creates a new instance
     * @param name The name 
     * @param artifactInfo The {@link ArtifactInfo}
     * @param path The path
     */
    DependencyTreeNode(String name, ArtifactInfo artifactInfo, Path path)
    {
        this.name = name;
        this.artifactInfo = artifactInfo;
        this.path = path;
        this.children = new ArrayList<DependencyTreeNode>();
    }
    
    /**
     * Returns the name
     * 
     * @return The name
     */
    String getName()
    {
        return name;
    }
    
    /**
     * Returns the {@link ArtifactInfo}
     * 
     * @return The {@link ArtifactInfo}
     */
    ArtifactInfo getArtifactInfo()
    {
        return artifactInfo;
    }
    
    /**
     * Returns the path
     * 
     * @return The path
     */
    Path getPath()
    {
        return path;
    }
    
    /**
     * Add the given child
     * 
     * @param child The child
     */
    void addChild(DependencyTreeNode child)
    {
        children.add(child);
    }

    /**
     * Returns an unmodifiable view on the list of children
     * 
     * @return The children
     */
    List<DependencyTreeNode> getChildren()
    {
        return Collections.unmodifiableList(children);
    }
    
    @Override
    public String toString()
    {
        return getName();
    }

}
