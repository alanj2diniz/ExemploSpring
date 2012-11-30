package posjava.exception;

/**
 *
 * @author Cesumar
 */
public class CustomRollbackException extends RuntimeException {

    public CustomRollbackException(Throwable erro) {
        super(erro);
    }
    
}
