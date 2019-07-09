package com.saptool.ui.dependencycleaner;

import java.util.Objects;

/**
 *
 */
class ArtifactInfo
{
    /**
     * The group ID
     */
    private final String groupId;
    
    /**
     * The artifact ID
     */
    private final String artifactId;
    
    /**
     * The version
     */
    private final String version;
    
    /**
     * Create a new instance
     * 
     * @param groupId The group ID
     * @param artifactId The artifact ID
     * @param version The version
     */
    ArtifactInfo(String groupId, String artifactId, String version)
    {
        this.groupId = Objects.requireNonNull(
            groupId, "The groupId may not be null");
        this.artifactId = Objects.requireNonNull(
            artifactId, "The artifactId may not be null");
        this.version = Objects.requireNonNull(
            version, "The version may not be null");
    }
    
    /**
     * Returns the group ID
     * 
     * @return The group ID
     */
    String getGroupId()
    {
        return groupId;
    }
    
    /**
     * Returns the artifact ID
     * 
     * @return The artifact ID
     */
    String getArtifactId()
    {
        return artifactId;
    }
    
    /**
     * Returns the version
     * 
     * @return The version
     */
    String getVersion()
    {
        return version;
    }
    
    @Override
    public String toString()
    {
        return groupId + ":" + artifactId + ":" + version;
    }
}
