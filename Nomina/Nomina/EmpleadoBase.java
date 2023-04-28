package Nomina;
public class EmpleadoBase extends Empleado{
    private Puesto puesto;
    private int numfaltas = 0;
    

    public EmpleadoBase(String nombre, byte edad, char sexo, Puesto puesto, String numEmpleado){
        super(nombre, edad, sexo, numEmpleado);
        this.puesto = puesto;
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