// Clase para probar los ojetos

package Nomina;
import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;


public class Menu {    
    private static ArrayList<Empleado> empleados = new ArrayList<Empleado>();
    private static Random rnd = new Random();
    private static Scanner sc = new Scanner(System.in);
   
    public static void main(String[]args){
        inicializarListaEmpleados(empleados);
        int opcion;
        do {
            limpiarConsola();
            opcion = elegirOpcion();
            switch(opcion){
                case 1:
                imprimirNomina(empleados);
                pausarPrograma();
                break;
            case 2: 
                // imprimirNomina(empleados);
                // modificarFaltas(empleados);
                // pausarPrograma();  
                break;
            case 3:
                System.out.println("Saliendo del programa.");
                break;
            default : 
                System.out.println("Ingrese una entra valida.");
                pausarPrograma();
                break;
            }
            
        } while (opcion != 3);
    }
    
    public static int elegirOpcion(){
        Scanner sc = new Scanner(System.in);
        System.out.println("¿Que desea realizar?\n");
        System.out.println("1. Imprimir la nomina de empleados.");
        System.out.println("2. Ver Empleado.");
        System.out.println("3. Modificar Empleado.");
        System.out.println("3. Salir del programa.\n");
        return sc.nextInt();
    }

    public static void imprimirNomina(ArrayList<Empleado> e){
        String salida = String.format("| %-12s | %-10s | %-4s | %-18s | %-12s | %-10s | %-10s | %-12s |%n","N° Empleado", "Nombre", "Sexo", "Puesto","Sueldo Bruto", "Bono","Impuestos", "Sueldo Total");
        for(int i = 0; i < e.size(); i++){
            salida += e.get(i).toString();
        }
        System.out.println("\n-----------------------------------------------------------------------------------------------------------------");
        System.out.print(salida);
        System.out.println("-----------------------------------------------------------------------------------------------------------------");
    }
    
    // public static void modificarFaltas(ArrayList<Empleado> e){
    //      Scanner sc = new Scanner(System.in);
    //      System.out.println("¿Desea modificar las faltas?\n1.Si\n2.No");
    //      int opcionMod = sc.nextInt();
       
    //     switch (opcionMod) {
    //         case 1:
    //             System.out.println("Ingrese el numero de empleado.");
    //             String numEmpleadoBusca = sc.nextLine();
    //             if (e.get(opcionMod).getNumEmpleado().contains(numEmpleadoBusca)) {
    //             }
    //             break; 
    //         case 2:
    //             System.out.println("");
    //             break;
    //         default:
    //             System.out.println("Ingrese una entrada valida.");
    //             pausarPrograma();
    //             break;
    //     }
    // }
    
    public static ArrayList<Empleado> inicializarListaEmpleados(ArrayList<Empleado> e){
        for(int i = 0; i < 13; i++){
            e.add(GenerarEmpleados.crearEmpleadoBase(rnd.nextInt(2)));
        }
        return e;
    }

    // Metodos esteticos
    public static void limpiarConsola() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void pausarPrograma() {
        System.out.print("\nPresiona enter para continuar  . . . ");
        sc.nextLine();
    }
}
