
package trabajo.teoria.modelos;

import java.util.ArrayList;
import java.util.List;


public class Directivo extends Empleado{
    
    private String categoria;
    List<Empleado> subordinados ;
    
    
    public Directivo(String categoria, String nombre, int edad, double sueldoBruto) {
        super(nombre, edad, sueldoBruto,null);
        this.categoria = categoria;
        this.subordinados = new ArrayList<>();  
    }
    
    public void guardarSubordinados(List<Empleado> subordinadosE){
        this.subordinados.addAll(subordinadosE);
    }
    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    @Override
    public String toString(){
        return "Nombre: "+nombre+"\nEdad: "+edad+"\nSueldo bruto: "+sueldoBruto;
    }
    
}
