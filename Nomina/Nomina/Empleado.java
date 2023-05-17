package Nomina;
public abstract class Empleado extends Persona{
    protected String numEmpleado;

    public Empleado(String nombre, String apellido,byte edad, char sexo, String numEmpleado){
        super(nombre, apellido, edad,sexo);
        this.numEmpleado = numEmpleado;
    }

    public String getNumEmpleado(){
        return numEmpleado;
    }

    // Metodos Abstractos
    abstract public float sueldo();
    abstract public float sueldoBruto();
    abstract public String ImprimirDatosNomina();

    public float calcularImpuestos(float sueldoBruto){
        float impuestos = 0;
        if(sueldoBruto < 800){
            impuestos = 0;
        }
        else{
            impuestos = 0.03f;
        }
        float impuestoTotal = (sueldoBruto * impuestos);
        return Math.round(impuestoTotal * 100) / 100f;
    }

    public String toString(){
        return String.format("| %-12s |", this.numEmpleado) + super.toString();
    }
}