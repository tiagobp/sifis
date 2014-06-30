package creago.dfisc.afg.sifis.planejamento.dao;

import creago.dfisc.afg.sifis.planejamento.dao.common.GenericDAO;
import creago.dfisc.afg.sifis.planejamento.entities.Viagem;

/**
 *
 * @author Tiago Borges Pereira
 */
public class ViagemDAO extends GenericDAO<Viagem> {

    public ViagemDAO() {
        super(Viagem.class);
    }

    public void delete(Viagem viagem) {
        super.delete(viagem.getIdviagem(), Viagem.class);
    }
}
