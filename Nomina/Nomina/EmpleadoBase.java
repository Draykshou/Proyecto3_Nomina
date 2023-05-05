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

    public float getSueldoBruto(){
        return this.puesto.getSueldo() - ((puesto.getSueldo()/14) * numfaltas);
    }

    public float calcularSueldo(){
        return getSueldoBruto() - calcularImpuestos(getSueldoBruto());
    }
    
    public String mostrarDatos(){
        String salida = "";
        if(getSexo() == 'M'){
            salida = super.toString() + String.format(" %-18s | %-12s | %-10s | %-10s | %-12s | %-10s |", puesto.getNombrePuestoMasculino(), getSueldoBruto(), 0.0, calcularImpuestos(getSueldoBruto()),calcularSueldo(), getNumFaltas())+"\n";
        } else{
            salida = super.toString() + String.format(" %-18s | %-12s | %-10s | %-10s | %-12s | %-10s |", puesto.getNombrePuestoFemenino(),  getSueldoBruto(), 0.0, calcularImpuestos(getSueldoBruto()), calcularSueldo(), getNumFaltas())+"\n";
        }
        return salida;
    }

    public String toString(){
        String salida = "";
        if(getSexo() == 'M'){
            salida = super.toString() + String.format(" %-18s | %-12s | %-10s | %-10s | %-12s |", puesto.getNombrePuestoMasculino(), getSueldoBruto(), 0.0, calcularImpuestos(getSueldoBruto()),calcularSueldo())+"\n";
        } else{
            salida = super.toString() + String.format(" %-18s | %-12s | %-10s | %-10s | %-12s |", puesto.getNombrePuestoFemenino(),  getSueldoBruto(), 0.0, calcularImpuestos(getSueldoBruto()), calcularSueldo())+"\n";
        }
        return salida;
    }
} 