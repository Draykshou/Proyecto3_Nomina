package Nomina;

public class EmpleadoDia extends Empleado{
    private int diasTrabajados;

    public EmpleadoDia(String nombre, String apellido,byte edad, char sexo, String numEmpleado, int diasTrabajados){
        super(nombre, apellido, edad, sexo, numEmpleado);
        this.diasTrabajados = diasTrabajados;
    }
    public int getDiasTrabajados(){
        return diasTrabajados;
    }
    public void setDiasTrabajados(int diasTrabajados){
        this.diasTrabajados = diasTrabajados;
    }
    
    @Override
    public float sueldo() {
        float sueldo = sueldoBruto() - calcularImpuestos(sueldoBruto());
        return Math.round(sueldo * 100) / 100f;
    }

    @Override
    public float sueldoBruto() {
        float bruto = diasTrabajados * 300;
        return Math.round((bruto + bonos()) * 100) / 100f;
    }

    public float bonos(){
        float bono = 0;
        if (diasTrabajados>=10) {
            bono = + 400;
        } else {
            bono = 0;
        }
        return bono;
    }

    @Override
    public String ImprimirDatosNomina() {
        String salida = "";
        salida = String.format("| %-12s | %-20s | %-4s | %-18s | %-12s | %-10s | %-10s | %-12s |%n", numEmpleado, getNombre()+" "+getApellido(), getSexo(), "Empleado por Dia", sueldoBruto(), bonos(), calcularImpuestos(sueldoBruto()), sueldo());
        return salida;
    }
     public String toString(){
       String salida = "";
        salida = String.format("| %-12s | %-20s | %-4s | %-4s | %-18s | %-12s | %-10s | %-10s | %-12s |%n","N° Empleado", "Nombre", "Sexo", "Edad","Dias Trabajados", "Sueldo Bruto", "Bono", "Impuestos", "Sueldo Total");
        salida += super.toString() + String.format(" %-18s | %-12s | %-10s | %-10s | %-12s |", diasTrabajados, sueldoBruto(), bonos(), calcularImpuestos(sueldoBruto()), sueldo())+"\n";
        return salida;
    }
}