package assignments.assignment3.storage;

/**
 * A general-purpose container for some entries.
 * Note: there's no prescribed organization in general, but individual
 * implementations might mandate specific relationships between adding/removing
 * sequence.
 *
 * Additionally: concrete classes are designed ad hoc, where required. It might
 * not be possible for client code to arbitrarily instantiate.
 */
public interface Bin<E> extends Iterable<E> {
    /**
     * Removes and returns a single entry from the Bin.
     * @return any single entry within the Bin
     * @throws DisorganizationException if it's empty
     */
    public E grab();

    /**
     * For adding a new entry to the Bin.
     * @param entry new member for the Bin
     * @throws DisorganizationException if it's full, where applicable
     */
    public void add(E entry);

    /**
     * Does this bin still have something left kickin' around in it?
     * @return
     */
    public boolean hasStuff();
}
