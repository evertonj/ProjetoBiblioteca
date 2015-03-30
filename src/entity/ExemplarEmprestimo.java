/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.Objects;

/**
 *
 * @author Alex
 */
public class ExemplarEmprestimo {

    public ExemplarEmprestimo(Exemplar exemplar, Obra obra) {
        this.exemplar = exemplar;
        this.obra = obra;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + Objects.hashCode(this.exemplar);
        hash = 43 * hash + Objects.hashCode(this.obra);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ExemplarEmprestimo other = (ExemplarEmprestimo) obj;
        if (!Objects.equals(this.obra.getTitulo(), other.obra.getTitulo())) {
            return false;
        }
        return true;
    }

        
    
    public ExemplarEmprestimo(){};
 
   private Exemplar exemplar;
   private Obra obra;

    /**
     * @return the exemplar
     */
    public Exemplar getExemplar() {
        return exemplar;
    }

    /**
     * @param exemplar the exemplar to set
     */
    public void setExemplar(Exemplar exemplar) {
        this.exemplar = exemplar;
    }

    /**
     * @return the obra
     */
    public Obra getObra() {
        return obra;
    }

    /**
     * @param obra the obra to set
     */
    public void setObra(Obra obra) {
        this.obra = obra;
    }

}
