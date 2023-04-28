package Nomina;
import java.util.ArrayList;
import java.util.Random;
public abstract class GenerarEmpleados {
    static Random rnd = new Random();
    private static ArrayList<Puesto> puestos = crearListaPuestos();
    private static String [] nombresMasculinos = {"Pedro","Pablo","Juan","Ignacio","Diego","Mario","Jose","Panfilo","Angel","Saul"};
    private static String [] nombresFemeninos = {"Carla","Paula","Sofia","Julia","Alma","Maria","Frida","Julieta","Abril","Alexa"};

    public static EmpleadoBase crearEmpleadoBase(int sexo){
        // 0 = hombre ; 1 = mujer
        EmpleadoBase eB;
        if(sexo == 0){
           eB = new EmpleadoBase(nombresMasculinos[rnd.nextInt(10)], (byte)(rnd.nextInt(47)+18), 'm', AsigarPuesto(), "2301" + (rnd.nextInt(5001)+1001));
        } else {
           eB = new EmpleadoBase(nombresFemeninos[rnd.nextInt(10)], (byte)(rnd.nextInt(47)+18), 'f', AsigarPuesto(), "2301" + (rnd.nextInt(5001)+1001));
        }
        return eB;
    }

    public static Puesto AsigarPuesto(){
        Puesto p;
        if(puestos.size() != 0){
            int n = puestos.size();
            int random = rnd.nextInt(n);
            p = puestos.get(random);
            puestos.remove(random);
            
        }else{
            p = Puesto.INTENDENTE;
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