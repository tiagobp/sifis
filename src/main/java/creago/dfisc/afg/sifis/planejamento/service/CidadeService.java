package creago.dfisc.afg.sifis.planejamento.service;

import creago.dfisc.afg.sifis.planejamento.entities.Cidade;
import creago.dfisc.afg.sifis.planejamento.repository.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Tiago Borges Pereira
 */
@Service
@Transactional
public class CidadeService {

    @Autowired
    private CidadeRepository cidadeRepository;

    public Iterable<Cidade> findAll() {
        return cidadeRepository.findAll();
    }

    public void save(Cidade cidade) {
        cidadeRepository.save(cidade);
    }

    public void delete(Cidade cidade) {
        cidadeRepository.delete(cidade);
    }
}
