package posjava.exemplo;

import posjava.exception.CustomRollbackException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Cesumar
 */
@Service
@Transactional(propagation=Propagation.REQUIRED, readOnly=true, rollbackFor=CustomRollbackException.class)
public class ExemploService {
    
    
    public List leAlgumaCoisa() {
        
        //Le coisa 1
        //Le coisa 2
        //Le coisa 1 relacionada a coisa 2
        
        return new ArrayList();
    }
    
    
    @Transactional(readOnly=false)
    public void fazAlgumaCoisa() {
        
        try {
            
            //Metodo 1
            //Metodo 2
            //Metodo 3 com erro
            
        } catch (Throwable erro) {
            
            throw new CustomRollbackException(erro);
            
        }
        
    }
    
    
}
