package creago.dfisc.afg.sifis.planejamento.beans;

import creago.dfisc.afg.sifis.planejamento.entities.Categoria;
import creago.dfisc.afg.sifis.planejamento.facade.CategoriaFacade;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author Tiago Borges Pereira
 */
@SessionScoped
@ManagedBean
public class CategoriaBean extends AbstractBean implements Serializable {

    //CATEGORIA
    private Categoria categoria;
    private List<Categoria> categorias;
    private Categoria selectedCategoria;
    private List<Categoria> filteredCategorias;
    private String color;

    //FACADE
    private CategoriaFacade categoriaFacade;

    public CategoriaFacade getCategoriaFacade() {
        if (categoriaFacade == null) {
            categoriaFacade = new CategoriaFacade();
        }
        return categoriaFacade;
    }

    //CRUD
    public String create() {
        try {
            categoria.setNome(categoria.getNome().toUpperCase());
            getCategoriaFacade().create(categoria);
            displayInfoMessageToUser("Categoria cadastrada com sucesso!");
            loadCategorias();
            resetCategoria();
            return "categorias-list";
        } catch (Exception e) {
            displayErrorMessageToUser("Erro ao cadastrar o nova categoria!");
            return "categorias-new";
        }
    }

    public String newCategoria() {
        return "categorias-new";
    }

    public List<Categoria> findAll() {
        loadCategorias();
        return categorias;
    }
    
    public String remove() {
        try {
            getCategoriaFacade().delete(this.selectedCategoria);
            displayInfoMessageToUser("Categoria excluída com sucesso!");
            loadCategorias();
            resetCategoria();
        } catch (Exception e) {
            displayErrorMessageToUser("Erro ao excluir categoria!");
            e.printStackTrace();
        }
        return "categorias-list";
    }
    
    public void onRowEdit(RowEditEvent event) {
        Categoria categoriaAlterada = (Categoria) event.getObject();
        categoriaAlterada.setNome(categoriaAlterada.getNome().toUpperCase());
        getCategoriaFacade().update(categoriaAlterada);
        displayInfoMessageToUser("Categoria Atualizada.");
    }
    
    public void onCancel(RowEditEvent event) {
        displayInfoMessageToUser("Atualização Cancelada.");
    }

    // GETTERS AND SETTERS
    public Categoria getCategoria() {
        if (categoria == null) {
            resetCategoria();
        }
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public List<Categoria> getCategorias() {
        categorias = findAll();
        return categorias;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }

    public Categoria getSelectedCategoria() {
        return selectedCategoria;
    }

    public void setSelectedCategoria(Categoria selectedCategoria) {
        this.selectedCategoria = selectedCategoria;
    }

    public List<Categoria> getFilteredCategorias() {
        return filteredCategorias;
    }

    public void setFilteredCategorias(List<Categoria> filteredCategorias) {
        this.filteredCategorias = filteredCategorias;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    //LOADDERS AND RESETTERS
    //CATEGORIAS
    private void loadCategorias() {
        categorias = getCategoriaFacade().listAll();
    }

    private void resetCategoria() {
        categoria = new Categoria();
    }
}
