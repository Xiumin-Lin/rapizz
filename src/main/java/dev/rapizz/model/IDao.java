package dev.rapizz.model;
import java.util.List;
import java.util.Optional;

/**
 * Interface representing a generic DAO (Data Access Object) for CRUD operations.
 *
 * @param <T> the type of the object handled by the DAO
 */
public interface IDao<T> {
    /**
     * Get an object by its ID.
     * @param id the ID of the object to find
     * @return an optional containing the retrieved object, or empty if not found
     */
    Optional<T> getById(int id);

    /**
     * Get all objects of the given type.
     * @return a list of all objects of the given type
     */
    List<T> getAll();

    /**
     * Creates a new object.
     * @param obj the object to create
     * @return the created object
     */
    T create(T obj);

    /**
     * Updates an existing object.
     * @param obj the object to update
     * @return the updated object
     */
    T update(T obj);

    /**
     * Deletes an object.
     * @param obj the object to delete
     */
    void delete(T obj);
}
