package creago.dfisc.afg.sifis.planejamento.dao;

import creago.dfisc.afg.sifis.planejamento.dao.common.GenericDAO;
import creago.dfisc.afg.sifis.planejamento.entities.Inspetoria;

/**
 *
 * @author Tiago Borges Pereira
 */
public class InspetoriaDAO extends GenericDAO<Inspetoria> {

    public InspetoriaDAO() {
        super(Inspetoria.class);
    }

    public void delete(Inspetoria inspetoria) {
        super.delete(inspetoria.getIdinspetoria(), Inspetoria.class);
    }
}
