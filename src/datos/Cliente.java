/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

/**
 *
 * @author Usuario
 */
public class Cliente  implements Comparable<Cliente> {
    public String nombre;
    public String apellido;
    public char sex;
    public long dni;
    public String prov;

    public Cliente(String nombre, String apellido, char sex, long dni, String prov) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.sex = sex;
        this.dni = dni;
        this.prov = prov;
    }

    public Cliente() {
       this.nombre = "";
        this.apellido = "";
        this.sex = ' ';
        this.dni = 0;
        this.prov = "";
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public long getDni() {
        return dni;
    }

    public void setDni(long dni) {
        this.dni = dni;
    }

    public String getProv() {
        return prov;
    }

    public void setProv(String prov) {
        this.prov = prov;
    }
    
    public String toString(){
        return nombre;
    }

    @Override
    public int compareTo(Cliente o) {
    //        int resultado = 0;
        int resultado = -1;
        if (this.dni == o.getDni()) {
            resultado = 0;
        } else {
            if (this.dni > o.getDni()) {
                resultado = 1;
            }
//            else{
//                resultado = -1;
//            }
        }
        return resultado;   
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + (int) (this.dni ^ (this.dni >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cliente other = (Cliente) obj;
        if (this.dni != other.dni) {
            return false;
        }
        return true;
    }

   

 
    
    
}
