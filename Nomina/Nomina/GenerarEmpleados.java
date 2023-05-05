package Nomina;
import java.util.ArrayList;
import java.util.Random;
public abstract class GenerarEmpleados {
    static Random rnd = new Random();
    private static ArrayList<Puesto> puestos = crearListaPuestos();
    private static int numEmpleados = 1;
    private static String [] nombresMasculinos = {"Pedro","Pablo","Juan","Ignacio","Diego","Mario","Jose","Panfilo","Angel","Saul", "Isaac", "Kevin" , "Martin", "Juan", "Inmanwell", "Emmanuel", "Jorge", "Daniel"};
    private static String [] nombresFemeninos = {"Carla","Paula","Sofia","Julia","Alma","Maria","Frida","Julieta","Abril","Alexa", "Melania", "Valentina", "Mariana", "Samirah", "Lya", "Dara", "Ana", "Eidi"};
    private static String [] apellidos = {"Lopez", "Heraz","Perez","Meza","Velasco","Garcia","Rojas","Ojeda","Flores","Rivas","Duarte", "Cabanillas", "Urrea", "Lerma", "Portillo"};

    public static EmpleadoBase crearEmpleadoBase(int sexo){
        // 0 = hombre ; 1 = mujer
        EmpleadoBase eB;
        if(sexo == 0){
            eB = new EmpleadoBase(nombresMasculinos[rnd.nextInt(nombresMasculinos.length)], apellidos[rnd.nextInt(apellidos.length)], (byte)(rnd.nextInt(47)+18), 'm', asignarPuesto(), Integer.toString(numEmpleados), rnd.nextInt(4));
        } else {
           eB = new EmpleadoBase(nombresFemeninos[rnd.nextInt(nombresFemeninos.length)], apellidos[rnd.nextInt(apellidos.length)], (byte)(rnd.nextInt(47)+18), 'f', asignarPuesto(), Integer.toString(numEmpleados), rnd.nextInt(4));
        }
        numEmpleados++;
        return eB;
    }

    public static Puesto asignarPuesto(){
        Puesto p;
        if(puestos.size() != 0){
            int n = puestos.size();
            int random = rnd.nextInt(n);
            p = puestos.get(random);
            puestos.remove(random);
            
        }else{
            p = null; // Solo en caso de que se use el metodo y ya no haya puestos
        }
        return p;

    }

    public static ArrayList<Puesto> crearListaPuestos(){
        ArrayList<Puesto> puestos = new ArrayList<Puesto>();
        Puesto [] p = {Puesto.DIRECTOR, Puesto.JEFE_OFICINA, Puesto.PROGRAMADOR, Puesto.PROGRAMADOR, Puesto.PROGRAMADOR, Puesto.PROGRAMADOR, Puesto.OPERADOR, Puesto.OPERADOR, Puesto.OPERADOR, Puesto.INTENDENTE, Puesto.INTENDENTE, Puesto.INTENDENTE, Puesto.SECRETARIO};
        for(int i = 0; i < p.length; i++){
            puestos.add(i, p[i]);
        }
        return puestos;
    }
}