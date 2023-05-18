// Clase para probar los ojetos

package Nomina;
import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
public class Menu {    
    private static ArrayList<Empleado> empleados = new ArrayList<Empleado>();
    private static Random rnd = new Random();
    private static Scanner sc = new Scanner(System.in);
   
    public static void main(String[]args){
        inicializarListaEmpleados(empleados);
        inicializarEmpladosTemporales(empleados, rnd.nextInt(74)+25);
        String opcion;
        do {
            limpiarConsola();
            opcion = elegirOpcion();
            switch(opcion){
                case "1": // Imprimir Nomina
				imprimirNomina(empleados);
				pausarPrograma();
				break;
			case "2": // Ver empleado
				imprimirNomina(empleados);
				verEmpleado();
				pausarPrograma();
				break;
			case "3": // Modificar empleado
                imprimirNomina(empleados);
				modificarFaltasEmpleado();
				pausarPrograma();
				break;
            case "4":
                System.out.println(ImprimirTablaDivisas(CantidadBilletes(empleados)));
                pausarPrograma();
                break;
            case "5": // Salir
                    System.out.println("Saliendo del programa.");
                    break;
			default: // entrada invalida
				System.out.println("Ingrese una entrada valida.");
				pausarPrograma();
				break;
			}
		} while (!opcion.equals("4"));
	}
    
    public static String elegirOpcion(){
        System.out.println("¿Que desea realizar?\n");
        System.out.println("1. Imprimir la nomina de empleados.");
        System.out.println("2. Ver Empleado.");
        System.out.println("3. Modificar Empleado.");
        System.out.println("4. Cantidad de dinero para pagar a empleados temporales.\n");
        System.out.println("5. Salir del programa.\n");
        return sc.nextLine().trim();
    }

      public static void imprimirNomina(ArrayList<Empleado> e){
        String salida = String.format("| %-12s | %-20s | %-4s | %-18s | %-12s | %-10s | %-10s | %-12s |%n","N° Empleado", "Nombre", "Sexo", "Puesto","Sueldo Bruto", "Bono","Impuestos", "Sueldo Total");
        for(int i = 0; i < e.size(); i++){
            salida += e.get(i).ImprimirDatosNomina();
        }
        System.out.println("\n---------------------------------------------------------------------------------------------------------------------------");
        System.out.print(salida);
        System.out.println("---------------------------------------------------------------------------------------------------------------------------");
    }
    
    public static void verEmpleado(){
        System.out.println("Ingrese el numero de empleado: ");
        String numEmpleado = sc.nextLine().trim();
        boolean hayEmpleado = false;
        for(Empleado e : empleados){
            if(e.getNumEmpleado().equals(numEmpleado)){
                limpiarConsola();
                System.out.println("El empleado si existe, es:");
                System.out.println(e.toString());
                hayEmpleado = true;
            }
        }
        // En caso de que no exista el empleado o se ingrese una entrada no valida
        if(!hayEmpleado){
            System.out.println("No existe el empleado.");
        }
    }

    public static void modificarFaltasEmpleado() {
		System.out.println("Ingrese el numero de empleado: ");
		String numEmpleado = sc.nextLine().trim();
		boolean hayEmpleado = false;
		for (Empleado e : empleados) {
			if (e.getNumEmpleado().equals(numEmpleado)) {
				limpiarConsola();
				System.out.println("\nEl empleado si existe, es:");
				System.out.format("| %-12s | %-20s | %-4s | %-18s | %-12s | %-10s | %-10s | %-12s | %-10s |%n","N° Empleado", "Nombre", "Sexo", "Puesto", "Sueldo Bruto", "Bono", "Impuestos", "Sueldo Total","N° Faltas");
				System.out.println(e.toString());
				hayEmpleado = true;
				String opcionModifFaltas;
				System.out.println("¿Desea modificar el numero de faltas?\n1.Si\n2.No" );
				opcionModifFaltas = sc.nextLine().trim();
                limpiarConsola();
                switch (opcionModifFaltas) {
                    case "1":
                        System.out.println("Ingrese el numero de faltas:");
                        int nwNumFaltas = sc.nextInt();
                        sc.nextLine();
                        ((EmpleadoBase) e).setNumFaltas(nwNumFaltas);
                        System.out.println("\n");
                        System.out.println("Se ha modificado dejando al trabajador con lo siguiente: ");
                        System.out.format("| %-12s | %-20s | %-4s | %-18s | %-12s | %-10s | %-10s | %-12s | %-10s |%n","N° Empleado", "Nombre", "Sexo", "Puesto", "Sueldo Bruto", "Bono", "Impuestos", "Sueldo Total","N° Faltas");
                        System.out.println(e.toString());
                        break;
                    case "2":
                        System.out.println("Regresando al menu...");
                        break;
                    default:
                        System.out.println("Ingrese una entrada valida.");
                        break;
                }
            }
        }
         // En caso de que no exista el empleado o se ingrese una entrada no valida
         if (!hayEmpleado) {
            System.out.println("No existe el empleado.");
        }
	}
    
    // -----------------------------------Metodos inicializador -----------------------------------------------
    public static ArrayList<Empleado> inicializarListaEmpleados(ArrayList<Empleado> e){
        for(int i = 0; i < 13; i++){
            e.add(GenerarEmpleados.crearEmpleadoBase(rnd.nextInt(2)));
        }
        return e;
    }

    public static ArrayList<Empleado> inicializarEmpladosTemporales(ArrayList<Empleado> e, int numEmpleados){
        for(int i = 0; i < numEmpleados; i++){
            int n = rnd.nextInt(3);
            switch (n) {
                case 0:
                    e.add(GenerarEmpleados.crearEmpleadoDia(rnd.nextInt(2)));
                    break;
                case 1:
                    e.add(GenerarEmpleados.crearEmpleadoHora(rnd.nextInt(2)));
                    break;
                case 2:
                    e.add(GenerarEmpleados.crearEmpleadoComision(rnd.nextInt(2)));
                    break;
                default:
                    e.add(GenerarEmpleados.crearEmpleadoDia(rnd.nextInt(2)));
                    break;
            }
        }
        return e;
    }
    
    public static float calcularTotalPagar(ArrayList<Empleado> em){
        float totalSueldoEmpleados = 0;
        for (Empleado e : em) {
            if(!(e instanceof EmpleadoBase)){
                totalSueldoEmpleados += e.sueldo();    
            }
            
        }
        return Math.round(totalSueldoEmpleados * 100) / 100f;
    }

    public static int [] CantidadBilletes(ArrayList<Empleado> em){
        float totalS = calcularTotalPagar(empleados);
        int[] denominaciones = {500, 200, 100, 50, 20, 10, 5, 2, 1};
        int[] cantidadDenominaciones = {0, 0, 0, 0, 0, 0, 0, 0, 0};

        for (Empleado e : em) {
            float sueldoE = e.sueldo();
            if(!(e instanceof EmpleadoBase)){
                 for (int i = 0; i < denominaciones.length; i++) {
                    cantidadDenominaciones [i] += (int)sueldoE / denominaciones[i];
                    sueldoE %= denominaciones[i];
                 }
            }
        }
        return cantidadDenominaciones;
    }

    public static String ImprimirTablaDivisas(int [] divisas){
        String salida = String.format("| %-14s | %-14s | %-14s |%n","Denominacion", "Cantidad", "Total");
        int[] denominaciones = {500, 200, 100, 50, 20, 10, 5, 2, 1};
        for(int i = 0; i < denominaciones.length; i++){
            salida += String.format("| %-14s | %-14s | %-14s |%n", denominaciones[i], divisas[i], denominaciones[i] * divisas[i]);
        }

        int totalDenominaciones = 0;
        for (int i = 0; i < denominaciones.length; i++) {
            totalDenominaciones += denominaciones[i];
        }

        salida += String.format("| %-14s | %-14s | %-14s |%n", "", totalDenominaciones, (int)calcularTotalPagar(empleados));
        return salida;
    }

    // -------------------------------------Metodos esteticos--------------------------------------------------
    public static void limpiarConsola() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void pausarPrograma() {
        System.out.print("\nPresiona enter para continuar  . . . ");
        sc.nextLine();
    }

}
