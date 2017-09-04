package controle;

import dao.ModeloDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import modelo.Marca;
import modelo.Modelo;

@ManagedBean
@SessionScoped
public class ModeloControle {

    private List<Modelo> modelos = new ArrayList<Modelo>();
    private Modelo modelo = new Modelo();
    private boolean salvar = false;
    private int idMarca = 0;

    public int getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(int idMarca) {
        this.idMarca = idMarca;
    }
    
    

    @PostConstruct
    public void atualizaModelos() {
        try {
            modelos = ModeloDAO.getLista();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void preparaIncluir() {
        salvar = true;
        modelo = new Modelo();
        idMarca = 0;
    }

    public void preparaAlterar() {
        salvar = false;
        idMarca = modelo.getMarca().getIdMarca();
    }

    public void salvar() {
        Marca marca = new Marca();
        marca.setIdMarca(idMarca);
        
        modelo.setMarca(marca);
        
        if (salvar) {
            try {
                ModeloDAO.inserir(modelo);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            try {
                ModeloDAO.alterar(modelo);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
     
        atualizaModelos();
    }

    public void excluir() {
        try {
            ModeloDAO.excluir(modelo);
            atualizaModelos();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Modelo> getModelos() {
        return modelos;
    }

    public void setModelos(List<Modelo> modelos) {
        this.modelos = modelos;
    }

    public Modelo getModelo() {
        return modelo;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }


}
