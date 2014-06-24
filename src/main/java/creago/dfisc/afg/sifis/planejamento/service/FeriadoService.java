package creago.dfisc.afg.sifis.planejamento.service;

import creago.dfisc.afg.sifis.planejamento.entities.Feriado;
import creago.dfisc.afg.sifis.planejamento.repository.FeriadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Tiago Borges Pereira
 */
@Service
@Transactional
public class FeriadoService {

    @Autowired
    private FeriadoRepository feriadoRepository;
    
    public Iterable<Feriado> findAll() {
        return feriadoRepository.findAll();
    }

    public void save(Feriado feriado) {
        feriadoRepository.save(feriado);
    }
    
    public void delete(Feriado feriado) {
        feriadoRepository.delete(feriado);
    }

}
