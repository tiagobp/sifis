package creago.dfisc.afg.sifis.planejamento.service;

import creago.dfisc.afg.sifis.planejamento.repository.RotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Tiago Borges Pereira
 */
@Service
@Transactional
public class RotaService {

    @Autowired
    private RotaRepository rotaRepository;
}
