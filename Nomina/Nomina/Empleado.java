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

    abstract public float calcularSueldo();
    abstract public String mostrarDatos();

    // calcular si el impuesto sera del 0% o del 3%
    public float AsignarImpuesto(float sueldoBruto){
        float impuestos;
        if(sueldoBruto < 800){
            impuestos = 0;
        }
        else{
            impuestos = 0.03f;
        }
        return impuestos;
    }

    public float calcularImpuestos(float sueldoBruto){
        return (sueldoBruto * AsignarImpuesto(sueldoBruto));
    }

    public String toString(){
        return String.format("| %-12s |", this.numEmpleado) + super.toString();
    }
}