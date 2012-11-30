package posjava.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;
import posjava.modelo.Cidade;
import posjava.modelo.Pessoa;

/**
 *
 * @author Cesumar
 */
@Repository
public class DAOPessoa {

    public DAOPessoa() {
        dados.put(1L, new Pessoa(1L, "Larry", new Cidade(1l, "Maringá")));
        dados.put(2L, new Pessoa(2L, "Curly", new Cidade(2l, "Cianorte")));
        dados.put(3L, new Pessoa(3L, "Moe", new Cidade(1l, "Maringá")));
    }
    private Map<Long, Pessoa> dados = new HashMap<Long, Pessoa>();

    public List list() {
        return new ArrayList(dados.values());
    }

    public void delete(Pessoa pessoa) {
        dados.remove(pessoa.getId());
    }

    public void save(Pessoa pessoa) {
        dados.put(pessoa.getId(), pessoa);
    }

    public Pessoa consulta(Pessoa pessoa) {
        return dados.get(pessoa.getId());
    }
}
