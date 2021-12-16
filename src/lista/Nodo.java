/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lista;

/**
 *
 *
 * @param <T>
 */
public class Nodo <T extends Comparable<T>>{
    private T elemento;
    private Nodo ps;
    
    public Nodo(T elem){
        this.elemento = elem;
        this.ps = null;
    }

    public Nodo(){
        this.elemento = null;
        this.ps = null;
    }
     /**
     * @return el elemento
     */
    public T getElemento() {
        return elemento;
    }

    /**
     * @param elemento el elemento a establecer
     */
    public void setElemento(T elemento) {
        this.elemento = elemento;
    }

    /**
     * @return el ps
     */
    public Nodo<T> getPs() {
        return ps;
    }

    /**
     * @param ps el ps a establecer
     */
    public void setPs(Nodo<T> ps) {
        this.ps = ps;
    }
        
}
