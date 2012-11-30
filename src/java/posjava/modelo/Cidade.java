package posjava.modelo;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import org.hibernate.validator.constraints.NotEmpty;
/**
 *
 * @author alan
 */
@Entity
public class Cidade implements Serializable {
 
    @Id
    private Long id;
    @NotEmpty
    private String nome;

    public Cidade() {
    }

    public Cidade(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}