package com.saptool.ui.dependencycleaner;

/**
 * A class indicating an exception in this library
 */
final class DependencyCleanerException extends RuntimeException
{
    /**
     * Serial UID
     */
    private static final long serialVersionUID = -3376932928438924066L;

    /**
     * Creates a new instance
     * 
     * @param message The message
     */
    DependencyCleanerException(String message)
    {
        super(message);
    }

    /**
     * Creates a new instance
     * 
     * @param cause The cause
     */
    DependencyCleanerException(Throwable cause)
    {
        super(cause);
    }

    /**
     * Creates a new instance
     * 
     * @param message The message
     * @param cause The cause
     */
    DependencyCleanerException(String message, Throwable cause)
    {
        super(message, cause);
    }
}
