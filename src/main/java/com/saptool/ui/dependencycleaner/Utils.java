package com.saptool.ui.dependencycleaner;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 * Utility methods
 */
class Utils
{
    /**
     * Returns whether the given path describes a valid JAR file
     * 
     * @param path The path
     * @return Whether the path is a valid ZIP file
     */
    static boolean isValidJar(Path path)
    {
        try (JarFile jarFile = new JarFile(path.toFile()))
        {
            // Try to read a single byte from each entry. This may cause the
            // java.util.zip.ZipException: invalid LOC header (bad signature)
            // that indicates that the JAR is broken.
            Enumeration<JarEntry> entries = jarFile.entries();
            while (entries.hasMoreElements())
            {
                JarEntry entry = entries.nextElement();
                InputStream inputStream = jarFile.getInputStream(entry);
                inputStream.read();
            }
            return true;
        }
        catch (IOException e)
        {
            //e.printStackTrace();
            return false;
        }
    }

    /**
     * Private constructor to prevent instantiation
     */
    private Utils()
    {
        // Private constructor to prevent instantiation
    }

}
