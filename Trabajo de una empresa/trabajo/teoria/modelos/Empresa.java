
package trabajo.teoria.modelos;

import java.util.ArrayList;
import java.util.List;


public class Empresa {
    private String nombre;
    List<Empleado>  empleados;
    List<Cliente> clientes;
     List<Directivo> directivos;
    
    public Empresa(String nombre) {
        this.nombre = nombre;
        this.empleados = new ArrayList<>();
        this.clientes = new  ArrayList<>();
        this.directivos = new ArrayList<>();
    }

   
    
    public void agregarDirectivo(Directivo directivo) {
    directivos.add(directivo);
    }
    public void agregarClientes(Cliente clientes){
        this.clientes.add(clientes);
    }
    public void agregarEmpleados(Empleado empleados){
        this.empleados.add(empleados);
    }
     public List<Directivo> getDirectivos() {
        return directivos;
    }

    public void setDirectivos(List<Directivo> directivos) {
        this.directivos = directivos;
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(List<Empleado> empleados) {
        this.empleados = empleados;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }
     @Override
    public String toString(){
        return "Nombre: "+nombre;
    }

    
    
}
