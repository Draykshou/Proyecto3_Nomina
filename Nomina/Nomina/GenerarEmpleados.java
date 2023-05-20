package Nomina;
import java.util.ArrayList;
import java.util.Random;

public abstract class GenerarEmpleados {
    static Random rnd = new Random();
    private static ArrayList<Puesto> puestosM = crearListaPuestosM();
    private static ArrayList<Puesto> puestosF = crearListaPuestosF();
    private static ArrayList<Integer> numEmpleados = new ArrayList<Integer>();
    private static String [] nombresMasculinos = {"Pedro","Pablo","Juan","Ignacio","Diego","Mario","Jose","Panfilo","Angel","Saul", "Isaac", "Kevin" , "Martin", "Juan", "Inmanwell", "Emmanuel", "Jorge", "Daniel", "Hugo", "Jesus", "Carlos", "Ricardo", "Antonio", "Alfredo", "Omar", "Fernando"};
    private static String [] nombresFemeninos = {"Carla","Paula","Sofia","Julia","Alma","Maria","Frida","Julieta","Abril","Alexa", "Melania", "Valentina", "Mariana", "Samirah", "Lya", "Dara", "Ana", "Eidi", "Fernanda", "Luna", "Rosa", "Melani", "Joseline", "Camila", "Karla", "Karen", "Gabriela"};
    private static String [] apellidos = {"Lopez", "Heraz","Perez","Meza","Velasco","Garcia","Rojas","Ojeda","Flores","Rivas","Duarte", "Cabanillas", "Urrea", "Lerma", "Portillo", "Obeso", "Quiñonez", "Quintero", "Saldaña", "Gamez", "Camino", "Rodriguez", "Castillo"};

    public static EmpleadoBase crearEmpleadoBase(int sexo){
        // 0 = hombre ; 1 = mujer
        EmpleadoBase eB;
        if(sexo == 0){
            eB = new EmpleadoBase(nombresMasculinos[rnd.nextInt(nombresMasculinos.length)], apellidos[rnd.nextInt(apellidos.length)], (byte)(rnd.nextInt(47)+18), 'm', asignarPuesto(sexo), "2301"+generarNumEmpleado(), rnd.nextInt(3));
        } else {
           eB = new EmpleadoBase(nombresFemeninos[rnd.nextInt(nombresFemeninos.length)], apellidos[rnd.nextInt(apellidos.length)], (byte)(rnd.nextInt(47)+18), 'f', asignarPuesto(sexo), "2301"+generarNumEmpleado(), rnd.nextInt(3));
        }
        return eB;
    }

    public static EmpleadoDia crearEmpleadoDia(int sexo){
        EmpleadoDia eD;
        if(sexo == 0){
            eD = new EmpleadoDia(nombresMasculinos[rnd.nextInt(nombresMasculinos.length)], apellidos[rnd.nextInt(apellidos.length)], (byte)(rnd.nextInt(47)+18), 'm', "2302"+generarNumEmpleado(), rnd.nextInt(4)+10);     
        }
        else{
            eD = new EmpleadoDia(nombresFemeninos[rnd.nextInt(nombresMasculinos.length)], apellidos[rnd.nextInt(apellidos.length)], (byte)(rnd.nextInt(47)+18), 'f', "2302"+generarNumEmpleado(), rnd.nextInt(4)+10);  
        }
        return eD;
    }

    public static EmpleadoHora crearEmpleadoHora(int sexo){
        EmpleadoHora eH;
        if(sexo == 0){
            eH = new EmpleadoHora(nombresMasculinos[rnd.nextInt(nombresMasculinos.length)], apellidos[rnd.nextInt(apellidos.length)], (byte)(rnd.nextInt(47)+18), 'm', "2303"+generarNumEmpleado(), rnd.nextInt(101)+20);     
        }
        else{
            eH = new EmpleadoHora(nombresFemeninos[rnd.nextInt(nombresMasculinos.length)], apellidos[rnd.nextInt(apellidos.length)], (byte)(rnd.nextInt(47)+18), 'f', "2303"+generarNumEmpleado(), rnd.nextInt(101)+20);  
        }
        return eH;
    }

    public static EmpleadoComision crearEmpleadoComision(int sexo){
        EmpleadoComision eC;
        if(sexo == 0){
            eC = new EmpleadoComision(nombresMasculinos[rnd.nextInt(nombresMasculinos.length)], apellidos[rnd.nextInt(apellidos.length)], (byte)(rnd.nextInt(47)+18), 'm', "2304"+generarNumEmpleado(), rnd.nextInt(40001)+20000);     
        }
        else{
            eC = new EmpleadoComision(nombresFemeninos[rnd.nextInt(nombresMasculinos.length)], apellidos[rnd.nextInt(apellidos.length)], (byte)(rnd.nextInt(47)+18), 'f', "2304"+generarNumEmpleado(), rnd.nextInt(40001)+20000);  
        }
        return eC;
    }

    public static Puesto asignarPuesto(int sexo){
        Puesto p;
        if(puestosM.size() != 0){
            int random = rnd.nextInt(puestosM.size());
            if(sexo == 0){
                p = puestosM.get(random);
            }else{
                p = puestosF.get(random);
            }
            puestosM.remove(random);
            puestosF.remove(random);
        }else{
            p = null; // Solo en caso de que se use el metodo y ya no haya puestos
        }
        return p;
    }

    public static ArrayList<Puesto> crearListaPuestosM(){
        ArrayList<Puesto> puestos = new ArrayList<Puesto>();
        Puesto [] p = {Puesto.DIRECTOR, Puesto.JEFE_OFICINA, Puesto.PROGRAMADOR, Puesto.PROGRAMADOR, Puesto.PROGRAMADOR, Puesto.PROGRAMADOR, Puesto.OPERADOR, Puesto.OPERADOR, Puesto.OPERADOR, Puesto.INTENDENTE, Puesto.INTENDENTE, Puesto.INTENDENTE, Puesto.SECRETARIO};
        for(int i = 0; i < p.length; i++){
            puestos.add(i, p[i]);
        }
        return puestos;
    }

    public static ArrayList<Puesto> crearListaPuestosF(){
        ArrayList<Puesto> puestos = new ArrayList<Puesto>();
        Puesto [] p = {Puesto.DIRECTORA, Puesto.JEFA_OFICINA, Puesto.PROGRAMADORA, Puesto.PROGRAMADORA, Puesto.PROGRAMADORA, Puesto.PROGRAMADORA, Puesto.OPERADORA, Puesto.OPERADORA, Puesto.OPERADORA, Puesto.INTENDENTE, Puesto.INTENDENTE, Puesto.INTENDENTE, Puesto.SECRETARIA};
        for(int i = 0; i < p.length; i++){
            puestos.add(i, p[i]);
        }
        return puestos;
    }

    public static int generarNumEmpleado(){
        boolean EsDiferente = true;
        int np;
        do{
            np = rnd.nextInt(8999)+1000;
            for (int i = 0; i < numEmpleados.size(); i++) {
                if(np == numEmpleados.get(i)){
                    EsDiferente = false;
                }
            }
        }while(!EsDiferente);
        numEmpleados.add(np);
        return np;
    }
}