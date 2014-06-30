package creago.dfisc.afg.sifis.planejamento.dao;

import creago.dfisc.afg.sifis.planejamento.dao.common.GenericDAO;
import creago.dfisc.afg.sifis.planejamento.entities.Categoria;

/**
 *
 * @author Tiago Borges Pereira
 */
public class CategoriaDAO extends GenericDAO<Categoria> {

    public CategoriaDAO() {
        super(Categoria.class);
    }

    public void delete(Categoria categoria) {
        super.delete(categoria.getIdcategoria(), Categoria.class);
    }
}
