package creago.dfisc.afg.sifis.planejamento.service;

import creago.dfisc.afg.sifis.planejamento.entities.Bairro;
import creago.dfisc.afg.sifis.planejamento.repository.BairroRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Tiago Borges Pereira
 */
@Service
@Transactional
public class BairroService {

    @Autowired
    private BairroRepository bairroRepository;

    public Iterable<Bairro> findAll() {
        return bairroRepository.findAll();
    }
    
    public void save(Bairro bairro) {
        bairroRepository.save(bairro);
    }
}
