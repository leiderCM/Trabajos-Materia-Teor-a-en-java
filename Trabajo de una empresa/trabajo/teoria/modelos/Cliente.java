
package trabajo.teoria.modelos;

import java.util.ArrayList;
import java.util.List;


public class Cliente extends Persona{
    private double numeroTelefono;
    List<Empresa> empresa;

    public Cliente(double numeroTelefono, String nombre, int edad) {
        super(nombre, edad);
        this.numeroTelefono = numeroTelefono;
        this.empresa = new ArrayList<>();
    }
    public void agregarEpresas(List<Empresa> empresas){
        this.empresa.addAll(empresas);
    }
    public double getNumeroTelefono() {
        return numeroTelefono;
    }

    public void setNumeroTelefono(double numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

    @Override
    public String toString(){
        return "Nombre: "+nombre+"\nEdad: "+edad+"\nNumero de telefono: "+numeroTelefono;
    }
    
}
