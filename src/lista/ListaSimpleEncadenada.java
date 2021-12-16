/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lista;

import datos.Cliente;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

/**
 *
 * 
 * @param <T>
 */
public class ListaSimpleEncadenada<T extends Comparable<T>> implements Iterable<T> {

    private Nodo<T> list;

    public ListaSimpleEncadenada() {
        this.list = null;
    }

    public Nodo<T> getList() {
        return list;
    }

    public void setList(Nodo<T> list) {
        this.list = list;
    }

    public Nodo inicio() {
        return this.list;
    }

    public boolean listaVacia() {
        return (this.list == null);
    }

    public void insertarPrincipio(Nodo<T> x) {
        x.setPs(this.list);
        this.list = x;
    }

    public void insertarMedio(Nodo<T> ant, Nodo<T> x) {
        x.setPs(ant.getPs());
        ant.setPs(x);
    }

    public void insertarFinal(Nodo<T> ant, Nodo<T> x) {
        ant.setPs(x);
    }

//   public void insertar(Nodo x) {
//        Nodo p = list;
//        Nodo ant = null;
//        while (p != null ) {
//                ant = p;
//                p = p.getPs();
//        }
//        if (ant == null) {
//            //prt("Principio");
//            insertarpri(elem);
//        } else {
//                //prt("Ultimo " + elem + " " + ant.getDato());
//                insertarUlt(elem, ant);
//        }
//    }    
    public void quitarPrincipio() {
//        T elem = this.list.getElemento();
        this.list = this.list.getPs();
//        return elem;
    }

    public void quitarMedio(Nodo<T> ant) {
//        T elem = (ant.getPs()).getElemento();
        ant.setPs((ant.getPs()).getPs());
//        return elem;
    }

    public void quitarFinal(Nodo<T> ant) {
//        T elem = (ant.getPs()).getElemento();
        ant.setPs(null);
//        return elem;
    }
  
    public void insertarElemento(T dato) {
        if (!listaVacia()) {
            Nodo<T> puntero = inicio();
            Nodo<T> anterior = null;
            int bandera = 0;
            while ((puntero != null) && (bandera == 0)) {
                int comparacion = dato.compareTo(puntero.getElemento());
                if (comparacion == 0) {
                    bandera = 2;
                } else {
                    if (comparacion == 1) {
                        anterior = puntero;
                        puntero = puntero.getPs();
                    } else {
                        bandera = 1;
                    }
                }
            }
            if (bandera != 2) {
                Nodo<T> elem = new Nodo<>(dato);
                if (puntero == null) {
                    insertarFinal(anterior, elem);
                } else {
                    if (puntero == inicio()) {
                        insertarPrincipio(elem);
                    } else {
                        insertarMedio(anterior, elem);
                    }
                }
            } else {
                System.out.println("El Elemento Ya Existe");
            }
        } else {
            Nodo<T> elem = new Nodo<>(dato);
            insertarPrincipio(elem);
        }
    }

    public T eliminarElemento(T dato) {
        Nodo<T> puntero = inicio();
        Nodo<T> anterior = null;
        int bandera = 0;
        if (inicio() != null) {
            while ((puntero != null) && (bandera == 0)) {
                int comparacion = dato.compareTo(puntero.getElemento());
                if (comparacion == 0) {
                    bandera = 1;
                } else {
                    if (comparacion == -1) {
                        bandera = 2;
                    } else {
                        anterior = puntero;
                        puntero = puntero.getPs();
                    }
                }
            }         
            if (bandera == 1) {
                if (puntero == inicio()) {
                    quitarPrincipio();
                } else {
                    if (puntero.getPs() == null) {
                        quitarFinal(anterior);
                    } else {
                        quitarMedio(anterior);
                    }
                }
               // System.out.println("-. Elemento Eliminado Correctamente");
                return puntero.getElemento();
            } else {
                System.out.println("-.ERROR: Elemento Inexistente");
            }
        } else {
            System.out.println("-.ERROR: Lista Vacia");
        }
        return null;
    }
    
    
    
    public void imprimirLista() {
        Nodo puntero = inicio();
        while (puntero != null) {
            T var = (T) puntero.getElemento();
            System.out.println(var.toString());
            puntero = puntero.getPs();
        }
    }

    @Override
    public Iterator<T> iterator() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void forEach(Consumer<? super T> action) {
        Iterable.super.forEach(action); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Spliterator<T> spliterator() {
        return Iterable.super.spliterator(); //To change body of generated methods, choose Tools | Templates.
    }

    public int obtenerCantidadElementos() {
    Nodo puntero = inicio();
    int contador = 0;
        while (puntero != null) {
           contador++;
            puntero = puntero.getPs();
        }
        return contador;
    }

    public T obtenerElemento(int valor) {
    Nodo puntero = inicio();
    int contador = 1;
    T var = null;
        while (puntero != null) {
            if(valor == contador){
                var = (T) puntero.getElemento();
            //System.out.println(var.toString());
            }  
            contador++;
            puntero = puntero.getPs();
        }    
    return var;
    }

    public T buscarElemento(T valor) {
        Nodo puntero = inicio();
        T var = null;
        while (puntero != null) {
            var = (T) puntero.getElemento();
            if(var.equals(valor)){
                return var;
            }else{
               var = null;
            }            
            puntero = puntero.getPs();
        }
        return var;
    }

}
