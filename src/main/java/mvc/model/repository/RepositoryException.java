package mvc.model.repository;


public class RepositoryException extends Exception {

    /**
     * Constructor por defecto.
     */
    public RepositoryException() {
        super();
    }

    /**
     *
     * @param message El mensaje que describe el error.
     */
    public RepositoryException(String message) {
        super(message);
    }

    /**
     * @param message El mensaje que describe el error.
     * @param cause   La excepción original (ej. una SQLException) que causó esta.
     */
    public RepositoryException(String message, Throwable cause) {
        super(message, cause);
    }
}