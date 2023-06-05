// Clase para probar los ojetos

package Nomina;
import java.io.*;
import java.util.*;
public class Menu {    
    private static ArrayList<Empleado> empleados = new ArrayList<Empleado>();
    private static ArrayList<String> nominas = new ArrayList<String>();
    private static Random rnd = new Random();
    private static Scanner sc = new Scanner(System.in);
   
    public static void main(String[]args){
        inicializarListaEmpleados(empleados);
        inicializarEmpladosTemporales(empleados, rnd.nextInt(74)+25);
        Collections.sort(empleados);
        String op;
        do {
            limpiarConsola();
            System.out.println("¿Que desea realizar?\n");
            System.out.println("1. Imprimir nomina");
            System.out.println("2. Siguiente quincena.");
            System.out.println("3. Ver Empleado.");
            System.out.println("4. Modificar Empleado.");
            System.out.println("5. Cantidad de dinero para pagar a empleados temporales.");
            System.out.println("6. Ordenar Nomina");
            System.out.println("7. Salir del programa.\n");
            op = sc.nextLine().trim();
            
            switch(op){
            case "1": // Imprimir nomina
                File archivoNomina = new File("./Nomina/Nomina"+(nominas.size()+1)+".txt");
                if(!archivoNomina.exists()){
                    try {
                        sigQuincena(empleados);
                        imprimirNomina(empleados);
                    } catch (NumberOutOfRangeException e) {
                        System.out.println(e.getMessage());
                    }
                    sc.nextLine(); // El escaner de java haciendo de la suyas...
                }
                else{
                    System.out.println("El archivo Nomina"+nominas.size()+".txt ya existe");
                }
                pausarPrograma();
                break;
            case "2": // Siguiente quincena
                pausarPrograma();
                break;
			case "3": 
                verEmpleado();
                pausarPrograma();
				break;
			case "4": 

				break;
            case "5":

                break;
            case "6":

                break;
            case "7": // Salir
                    System.out.println("Saliendo del programa.");
                    break;
			default: // entrada invalida
				System.out.println("Ingrese una entrada valida.");
				pausarPrograma();
				break;
			}
		} while (!op.equals("7"));
	}

    public static void imprimirNomina(ArrayList<Empleado> e) throws NumberOutOfRangeException{
        System.out.println("Ingrese la fecha de la nomina D/M/AAAA  Nota: El dia maximo es el 30");
        try{
            int d = Integer.parseInt(sc.next()), m = Integer.parseInt(sc.next()), a = Integer.parseInt(sc.next());
            if(d < 0 || d > 30 || m < 0 || m > 12 || (m == 2 && (d < 0 || d > 28)) || a < 2000 || a > 2030){
                NumberOutOfRangeException rangeException = new NumberOutOfRangeException("Los numeros estan fuera de rango");
                throw rangeException;
            }
            File archivo = new File("./Nomina/Nomina"+(nominas.size()+1)+".txt");
            FileWriter fw = new FileWriter(archivo);
            PrintWriter archivoSalida = new PrintWriter(fw);
            String nomina = "Nomina del dia: " +d+"/"+m+"/"+a+"\n";
            nomina += String.format("| %-12s | %-20s | %-4s | %-18s | %-12s | %-10s | %-10s | %-12s |%n","N° Empleado", "Nombre", "Sexo", "Puesto","Sueldo Bruto", "Bono","Impuestos", "Sueldo Total");
            for(int i = 0; i < e.size(); i++){
                nomina += e.get(i).ImprimirDatosNomina();
            }
            nominas.add(nomina);
            archivoSalida.print(nomina);
            archivoSalida.close();
            System.out.println("El archivo " + "Nomina"+(nominas.size())+".txt" + " Ha sido creado");
        }catch(NumberFormatException nfe){
            System.out.println("El dato no es numerico");
        }catch(IOException io){
            System.out.println(io);
        }
    }
    
    public static void sigQuincena(ArrayList<Empleado> e){
    	
    	for (int i=0; i<e.size(); i++) {
			if (e.get(i) instanceof EmpleadoBase) {
				EmpleadoBase bases = (EmpleadoBase) e.get(i);
				bases.setNumFaltas(rnd.nextInt(3));
			}
			if (e.get(i) instanceof EmpleadoComision) {
				EmpleadoComision comisionados = (EmpleadoComision) e.get(i);
				comisionados.setCantidadVendida(rnd.nextInt(40001)+20000);
			}
			if (e.get(i) instanceof EmpleadoDia) {
				EmpleadoDia dias = (EmpleadoDia) e.get(i);
				dias.setDiasTrabajados(rnd.nextInt(4)+10);
			}
			if (e.get(i) instanceof EmpleadoHora) {
				EmpleadoHora horas = (EmpleadoHora) e.get(i);
				horas.setHorasTrabajadas(rnd.nextInt(41)+20);
			}	
			}
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
                if(e instanceof EmpleadoBase){
                    System.out.println("\nEl empleado si existe, es:");
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
        }
         // En caso de que no exista el empleado o se ingrese una entrada no valida
         if (!hayEmpleado) {
            System.out.println("No existe el empleado o no es base.");
        }
	}
    
    // -----------------------------------Metodos inicializadores -----------------------------------------------
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
    
    // -------------------------------------Cantidad billetes--------------------------------------------------
    public static float calcularTotalPagar(ArrayList<Empleado> em){
        float totalSueldoEmpleados = 0;
        for (Empleado e : em) {
            if(!(e instanceof EmpleadoBase)){
                totalSueldoEmpleados += e.sueldo();    
            }
            
        }
        return Math.round(totalSueldoEmpleados * 100) / 100f;
    }

    public static ArrayList<Empleado> CrearListaEmpledosTemporales(ArrayList<Empleado> lista){
        ArrayList<Empleado> temporales = new ArrayList<>();
        for(Empleado e: lista){
            if(!(e instanceof EmpleadoBase)){
                temporales.add(e);
            }
        }
        return temporales;
    }

    public static int [][] CantidadBilletes(ArrayList<Empleado> e){
        int[] denominaciones = {500, 200, 100, 50, 20, 10, 5, 2, 1};
        int[][] cantidadDenominaciones = new int[e.size()][denominaciones.length];

        for (int i = 0; i < cantidadDenominaciones.length; i++) {
            for (int j = 0; j < cantidadDenominaciones[0].length; j++) {
                cantidadDenominaciones[i][j] = 0;
            }
        }
        
        for (int i = 0; i < cantidadDenominaciones.length; i++) {
            int sueldoE = (int)e.get(i).sueldo();
                 for (int j = 0; j < cantidadDenominaciones[0].length; j++) {
                    cantidadDenominaciones[i][j] += sueldoE / denominaciones[j];
                    sueldoE %= denominaciones[j];
                 }
        }
        return cantidadDenominaciones;
    }

    public static int [] CantidadTotalBilletes(ArrayList<Empleado> em){
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
    
    public static String ImprimirTablaDivisas(int [][] divisas, ArrayList<Empleado> e){
        String salida = String.format("| %-14s | %-8s | %-8s | %-8s | %-8s | %-8s | %-8s | %-8s | %-8s | %-8s | %-8s | %-12s |%n","N° Empleado", "500", "200", "100", "50", "20", "10", "5", "2", "1", "Centavos", "Total:");
        int[] cantDenominaciones = CantidadTotalBilletes(empleados);
        double totalCentavos = 0;
        for (int i = 0; i < divisas.length; i++) {
            salida += String.format("| %-14s |", e.get(i).getNumEmpleado());
            for (int j = 0; j < divisas[0].length + 1; j++) {
                if(j < divisas[0].length){
                    salida += String.format( " %-8s |", divisas[i][j]);
                }
                else{
                    salida += String.format( " %-8s |", Math.round((e.get(i).sueldo() - (int)e.get(i).sueldo()) * 100) / 100f);
                    totalCentavos += Math.round((e.get(i).sueldo() - (int)e.get(i).sueldo()) * 100) / 100f;
                    
                }
            }
            salida += String.format(" %-12s |%n", e.get(i).sueldo());
        }

        salida += String.format("| %-14s |", "Total: ");

        for(int i = 0; i < cantDenominaciones.length + 1; i++){
            if(i < cantDenominaciones.length){
                salida += String.format(" %-8s |", cantDenominaciones[i]);
            }
            else{
                salida += String.format(" %-8s |",  Math.round(totalCentavos * 100) / 100f);
            }
        }
        salida += String.format(" %-12s |%n", calcularTotalPagar(empleados));

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
