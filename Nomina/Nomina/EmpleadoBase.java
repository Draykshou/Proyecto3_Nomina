package Nomina;
public class EmpleadoBase extends Empleado{
    private Puesto puesto;
    private int numfaltas;

    public EmpleadoBase(String nombre, String apellido, byte edad, char sexo, Puesto puesto, String numEmpleado, int numfaltas){
        super(nombre, apellido, edad, sexo, numEmpleado);
        this.puesto = puesto;
        this.numfaltas = numfaltas;
    }

    public int getNumFaltas(){
        return numfaltas;
    }

    public void setNumFaltas(int numfaltas){
        this.numfaltas = numfaltas;
    }
    
    @Override
    public float sueldo(){
        float sueldo = sueldoBruto() - calcularImpuestos(sueldoBruto());
        return  Math.round(sueldo * 100) / 100f;
    }

    @Override
    public float sueldoBruto(){
        float bruto = this.puesto.getSueldo() - ((puesto.getSueldo()/14) * numfaltas);
        return Math.round(bruto * 100) / 100f;
    }

    @Override    
    public String ImprimirDatosNomina(){
        return String.format("| %-12s | %-20s | %-4s | %-18s | %-12s | %-10s | %-10s | %-12s |%n", numEmpleado, getNombre()+" "+getApellido(), getSexo(), puesto.getPuesto(), sueldoBruto(), 0.0, calcularImpuestos(sueldoBruto()), sueldo());
    }

    public String toString(){
        String salida = String.format("| %-12s | %-20s | %-4s | %-4s | %-18s | %-12s | %-10s | %-10s | %-12s | %-10s |%n","N° Empleado", "Nombre", "Sexo", "Edad", "Puesto", "Sueldo Bruto", "Bono", "Impuestos", "Sueldo Total", "N° Faltas");
        return salida += super.toString() + String.format(" %-18s | %-12s | %-10s | %-10s | %-12s | %-10s |", puesto.getPuesto(), sueldoBruto(), 0.0, calcularImpuestos(sueldoBruto()), sueldo(), getNumFaltas())+"\n";
    }
}