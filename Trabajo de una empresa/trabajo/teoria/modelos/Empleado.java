
package trabajo.teoria.modelos;


public class Empleado extends Persona {
    
    protected double sueldoBruto;
    //asociacion
    
    private Directivo directivo;
    private Empresa empresa;
    
    public Empleado( String nombre, int edad,double sueldoBruto,Directivo directivo) {
        super(nombre, edad);
        this.sueldoBruto=sueldoBruto;
        this.directivo=directivo;
        
    }

   
    public double getSueldoBruto() {
        return sueldoBruto;
    }

    public void setSueldoBruto(double sueldoBruto) {
        this.sueldoBruto = sueldoBruto;
    }
    
    public double salarioNeto(){
        return sueldoBruto*0.9;
    }
    @Override
    public String toString(){
        return "Nombre: "+nombre+"\nEdad: "+edad+"\nSueldo bruto: "+sueldoBruto+"jefe"+directivo;
    }
    
}
