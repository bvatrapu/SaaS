package com.saptool.ui.dependencycleaner;

import java.nio.file.Path;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.aether.artifact.Artifact;
import org.eclipse.aether.graph.DependencyNode;
import org.eclipse.aether.resolution.DependencyResult;

/**
 * Methods to create {@link DependencyStatus} instances
 */
class DependencyStatuses
{
    /**
     * Compute the {@link DependencyStatus} for the given {@link ArtifactInfo}
     * objects
     * 
     * @param artifactInfos The {@link ArtifactInfo} objects
     * @return The {@link DependencyStatus}
     */
    static DependencyStatus compute(
        Iterable<? extends ArtifactInfo> artifactInfos) 
    {
        DependencyTreeNode root = new DependencyTreeNode("Root", null, null);
        for (ArtifactInfo artifactInfo : artifactInfos)
        {
            DependencyResult dependencyResult = 
                DependencyUtils.resolveDependencies(artifactInfo);
            DependencyNode dependencyNode = dependencyResult.getRoot();
            DependencyTreeNode dependencyTreeNode = buildTree(dependencyNode);
            root.addChild(dependencyTreeNode);
        }
        
        Set<Path> paths = computePaths(root);
        
        Set<Path> pathsToRefresh = new LinkedHashSet<Path>();
        Map<Path, Boolean> validPaths = new LinkedHashMap<Path, Boolean>();
        for (Path path : paths)
        {
            boolean valid = Utils.isValidJar(path);
            validPaths.put(path, valid);
            if (!valid)
            {
                pathsToRefresh.add(path);
            }
        }
        DependencyStatus dependencyStatus = 
            new DependencyStatus(root, validPaths, pathsToRefresh);
        return dependencyStatus;
    }
    
    /**
     * Recursively build the {@link DependencyTreeNode} tree based on the
     * given DependencyNode
     * 
     * @param node The node
     * @return The resulting node
     */
    private static DependencyTreeNode buildTree(DependencyNode node)
    {
        Artifact artifact = node.getArtifact();
        String name = artifact.toString();
        String groupId = artifact.getGroupId();
        String artifactId = artifact.getArtifactId();
        String version = artifact.getVersion();
        Path path = null;
        if (artifact.getFile() != null)
        {
            path = artifact.getFile().toPath();
        }
        ArtifactInfo artifactInfo = 
            new ArtifactInfo(groupId, artifactId, version);
        DependencyTreeNode result = 
            new DependencyTreeNode(name, artifactInfo, path);
        for (DependencyNode child : node.getChildren())
        {
            DependencyTreeNode childTree = buildTree(child);
            result.addChild(childTree);
        }
        return result;
    }
    
    /**
     * Compute all paths that appear in the given {@link DependencyTreeNode}
     * 
     * @param dependencyTreeNode The {@link DependencyTreeNode}
     * @return The paths
     */
    private static Set<Path> computePaths(
        DependencyTreeNode dependencyTreeNode)
    {
        Set<Path> paths = new LinkedHashSet<Path>();
        computePaths(dependencyTreeNode, paths);
        return paths;
    }
    
    /**
     * Compute all paths that appear in the given {@link DependencyTreeNode}
     * 
     * @param dependencyTreeNode The {@link DependencyTreeNode}
     * @param paths The target set
     */
    private static void computePaths(
        DependencyTreeNode dependencyTreeNode, Set<Path> paths)
    {
        Path path = dependencyTreeNode.getPath();
        if (path != null)
        {
            paths.add(path);
        }
        for (DependencyTreeNode child : dependencyTreeNode.getChildren())
        {
            computePaths(child, paths);
        }
    }
    

    /**
     * Private constructor to prevent instantiation
     */
    private DependencyStatuses()
    {
        // Private constructor to prevent instantiation
    }
}
