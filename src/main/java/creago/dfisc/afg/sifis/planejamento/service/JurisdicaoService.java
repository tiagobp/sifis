package creago.dfisc.afg.sifis.planejamento.service;

import creago.dfisc.afg.sifis.planejamento.entities.Jurisdicao;
import creago.dfisc.afg.sifis.planejamento.repository.JurisdicaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Tiago Borges Pereira
 */
@Service
@Transactional
public class JurisdicaoService {

    @Autowired
    private JurisdicaoRepository jurisdicaoRepository;
    
    public Iterable<Jurisdicao> findAll() {
        return jurisdicaoRepository.findAll();
    }
    
    public void save(Jurisdicao jurisdicao) {
        jurisdicaoRepository.save(jurisdicao);
    }
    
    public void delete(Jurisdicao jurisdicao) {
        Jurisdicao j = jurisdicaoRepository.findOne(jurisdicao.getIdjurisdicao());
        jurisdicaoRepository.delete(j);
    }
}
