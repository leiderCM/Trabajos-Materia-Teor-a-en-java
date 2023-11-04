package trabajo.teoria;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import trabajo.teoria.modelos.Cliente;
import trabajo.teoria.modelos.Directivo;
import trabajo.teoria.modelos.Empleado;
import trabajo.teoria.modelos.Empresa;

public class Main {

    public static void main(String[] args) {

        int opcion;
        Scanner entrada = new Scanner(System.in);
        boolean primeraVez = true;
        //listas
        List<Empresa> empresasGuardadas = new ArrayList<>();
        List<Directivo> directivosGuardados = new ArrayList<>();
        do {
            System.out.println("------MENU PRINCIPAL------ ");
            System.out.println("1.Crear empresas ");
            System.out.println("2.Crear empleados directivos asociados a la empresa");
            System.out.println("3.Crear empleados subordinados asociados a la empresa(deben tener un directivo de jefe)");
            System.out.println("4.Crear clientes asociados con una empresa");
            System.out.println("5.Calcular la nomina total de los empleados(subordinados y directivos)");
            System.out.println("6.Mostrar todos los clientes con su respectiva informacion");
            System.out.println("7.Mostrar todos los empleados(subordinados y directivos)con su respectiva informacion");
            System.out.println("8.Salir");
            System.out.println("Digite la opcion a ejecutar");
            opcion = entrada.nextInt();
            //la variable primera vez nos verifiaca que el usuario mira por primera ves el 
            // el menu luego se cambia a false
            if (primeraVez && opcion != 1) {
                System.out.println("por favor seleccione la opcion (1)");
            } else {
                primeraVez = false;
                switch (opcion) {
                    case 1:
                        
                        int numeroEmpresa;
                        String nombreEmpresasCreadas;
                         //se guarda los objetos de empresas creados
                        
                        //con un for creamos empresas 
                        System.out.println("Cuantas empresas va a crear ");
                        numeroEmpresa=entrada.nextInt();
                        for(int i=0; i<numeroEmpresa;i++){
                            System.out.println("Nombre: ");
                            nombreEmpresasCreadas=entrada.next();
                            Empresa empresasCreadas = new Empresa(nombreEmpresasCreadas);
                            empresasGuardadas.add(empresasCreadas);   
                        }
                        
                        System.out.println("Se guardo con exito la informacion");
                        
                       
                        break;

                    case 2:
                        
                        System.out.println("Cuantos empleados directivos va a crear");
                        int cantidadDirectivos = entrada.nextInt();
                        // Mostrar la lista de empresas disponibles
                        System.out.println("Empresas disponibles:");
                        for (int i = 0; i < empresasGuardadas.size(); i++) {
                            System.out.println(i + "." + empresasGuardadas.get(i).getNombre());
                        }

                        System.out.println("Seleccione la empresa a la que desea asociar directivos (Ingrese el numero):");
                        int empresaSeleccionada = entrada.nextInt();

                            if (empresaSeleccionada >= 0 && empresaSeleccionada < empresasGuardadas.size()) {
                                for (int i = 0; i < cantidadDirectivos; i++) {
                                    
                                    System.out.println("Ingrese la categoria");
                                    String categoria=entrada.next();
                                    System.out.println("Ingrese el nombre");
                                    String nombre=entrada.next();
                                    System.out.println("Ingrese la edad");
                                    int edad=entrada.nextInt();
                                    System.out.println("Ingrese el sueldo");
                                    double sueldo=entrada.nextDouble();

                                    Directivo directivo = new Directivo(categoria, nombre, edad, sueldo);

                                    // Asociar el directivo a la empresa seleccionada
                                    empresasGuardadas.get(empresaSeleccionada).agregarDirectivo(directivo);
                                    System.out.println("Directivo asociado con exito a la empresa " + empresasGuardadas.get(empresaSeleccionada).getNombre());
                                }
                            } else {
                                System.out.println("La seleccion de empresa no es valida.");
                            }
                        
                        break;

                    case 3:
                        //mostrar la lista de empresas disponibles
                        System.out.println("Empresas disponibles: ");
                        for(int i=0; i<empresasGuardadas.size(); i++){
                            System.out.println(i+"."+empresasGuardadas.get(i).getNombre());
                        }
                        //se selecciona a la empresa que se quiere asociar al empleado subordinado
                        System.out.println("Seleccione la empresa a la que quiere asociar el empleaso subordinado(Digite el nuemero)");
                        int seleccionarEmpresa=entrada.nextInt();
                        //me berifica de que el usuario agregue a las empresas existentes con este (if)
                        if(seleccionarEmpresa>=0 && seleccionarEmpresa<empresasGuardadas.size()){
                            //crear empleados subordinados
                            System.out.println("Cuantos empleados subordinados va a crear");
                             int numeroSubordinados= entrada.nextInt();
                            for(int i=0; i<numeroSubordinados;i++){
                                System.out.println("Ingrese nombre del subordinado");
                                String nombreSubordinado=entrada.next();
                                System.out.println("Ingrese la edad del empleado subordinado");
                                int edadSubordinado= entrada.nextInt();
                                System.out.println("Ingrese el sueldo del empleado subordinado");
                                double sueldoSubordinado=entrada.nextDouble();
                                
                                   //optener un directivo jefe seleccionado
                                   //correjir
                                 System.out.println("Seleccione el directivo jefe para este empleado(ingrese el numero)");
                                for (int j = 0; j < empresasGuardadas.get(seleccionarEmpresa).getDirectivos().size(); j++) {
                                    System.out.println(j + ". " + empresasGuardadas.get(seleccionarEmpresa).getDirectivos().get(j).getNombre());
                                     
                                }
                                //pedimos el nuemero del jefe a 
                                int jefeSeleccionado = entrada.nextInt();
                                
                                if (jefeSeleccionado >= 0 && jefeSeleccionado < empresasGuardadas.get(seleccionarEmpresa).getDirectivos().size()) {
                                    Directivo jefe = empresasGuardadas.get(seleccionarEmpresa).getDirectivos().get(jefeSeleccionado);
                                    //creamos el objeto de empleaso subordinado
                                    Empleado subordinado = new Empleado(nombreSubordinado, edadSubordinado, sueldoSubordinado, jefe);
                                    empresasGuardadas.get(seleccionarEmpresa).agregarEmpleados(subordinado);
                                    System.out.println("Empleado subordinado asociado con exito a la empresa " + empresasGuardadas.get(seleccionarEmpresa).getNombre());
                                } else {
                                    System.out.println("La selecc1ion de directivo jefe no es valida.");
                                }
                                  
                            }   
                        }else{
                            System.out.println("error empresas no existe");
                        }
                        
                        break;
                    case 4:
                        //mostrar empresas 
                         System.out.println(" Empresas existentes");
                         for(int i=0; i< empresasGuardadas.size();i++){
                             System.out.println(i+"."+empresasGuardadas.get(i).toString());
                         }
                         // se selcciona a la la empresa a la que quiere asociar a cliente 
                         System.out.println("Seleccione a la empresa que quiere asociar al cliente(digeite el numero)");
                         int numeroEmpres=entrada.nextInt();
                         // se hace la condicion para que el susuario solo ingrese el nuemro de empresas y no se pase 
                         if(numeroEmpres>=0 && numeroEmpres<empresasGuardadas.size() ){
                             System.out.println("Cuantos clientes va a crear");
                             int clientes=entrada.nextInt();
                             for(int i=0; i<clientes;i++){
                                 System.out.println("Ingrese el nombre");
                                 String nombreCliente=entrada.next();
                                 System.out.println("Ingrese la edad");
                                 int edadCliente=entrada.nextInt();
                                 System.out.println("Ingrese el numero de telefono");
                                 double numeroCliente=entrada.nextInt();
                                 //creamos el objeto
                                 Cliente clientesCreados = new Cliente(numeroCliente,nombreCliente,edadCliente);
                                 
                                  // Asociar el cliente a la empresa seleccionada
                                    Empresa empresaSelec = empresasGuardadas.get(numeroEmpres);
                                    empresaSelec.agregarClientes(clientesCreados);
                             }    
                         }else{
                             System.out.println("Rango de numero no aceptado ");
                         }
                         
                        break;
                    case 5:
                        //recorremos epresas guardadas
                        double nominaTotal=0;
                        for(Empresa empresas:empresasGuardadas){
                            for(Directivo directivos: empresas.getDirectivos()){
                                nominaTotal+=directivos.getSueldoBruto();
                            }
                            for (Empleado subordinado : empresas.getEmpleados()) {
                                nominaTotal += subordinado.getSueldoBruto();
                            }
                        }
                        System.out.println("Nomina total de todos los empleados es: "+nominaTotal);
                        
                        break;
                    case 6:
                        for (Empresa empresa : empresasGuardadas) {
                            for (Cliente cliente : empresa.getClientes()) {
                                System.out.println("Clientes de la empresa " + empresa.getNombre() + ":");
                                System.out.println(cliente.toString());
                            }
                        }

                        break;
                    case 7:
                       for (Empresa empresa : empresasGuardadas) {
                            System.out.println("Empleados de la empresa " + empresa.getNombre() + ":");
                            for (Directivo directivo : empresa.getDirectivos()) {
                                System.out.println(directivo.toString());
                            }
                            for (Empleado subordinado : empresa.getEmpleados()) {
                                System.out.println(subordinado.toString());
                            }
                        }

                        break;
                    case 8:
                        System.out.println("Salio del programa");
                        break;
                    default:
                        System.out.println("Opcion icorrecta dijite nuevamente ");
                        break;
                }
            }

        } while (opcion != 8);

    }

}
