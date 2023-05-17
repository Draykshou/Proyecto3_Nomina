package Nomina;

public class EmpleadoComision extends Empleado{
    private float cantidadVendida;
    public EmpleadoComision(String nombre, String apellido, byte edad, char sexo, String numEmpleado, float cantidadVendida){
        super(nombre, apellido, edad, sexo, numEmpleado);
        this.cantidadVendida = cantidadVendida;
    }
    public float getCantidadVendida(){
        return cantidadVendida;
    }
    public void setCantidadVendida(float cantidadVendida){
        this.cantidadVendida = cantidadVendida;
    }

    @Override
    public float sueldo() {
        float sueldo = (sueldoBruto()) - calcularImpuestos(sueldoBruto());
        return  Math.round(sueldo * 100) / 100f;
    }

    @Override
    public float sueldoBruto() {
        float sueldoBruto = cantidadVendida * 0.10f;
        return Math.round((sueldoBruto + bonos()) * 100) / 100f;
    }

    public float bonos(){
        float bono = 0;
        if (cantidadVendida>=50000) {
            bono = + 500;
        } else {
            bono = 0;
        }
        return bono;
    }

    @Override
    public String ImprimirDatosNomina() {
         String salida = "";
        salida = String.format("| %-12s | %-20s | %-4s | %-18s | %-12s | %-10s | %-10s | %-12s |%n", numEmpleado, getNombre()+" "+getApellido(), getSexo(), "Empleado Comision", sueldoBruto(), bonos(), calcularImpuestos(sueldoBruto()), sueldo());
        return salida;
    }

    public String toString(){
       String salida = "";
        salida = String.format("| %-12s | %-20s | %-4s | %-4s | %-18s | %-12s | %-10s | %-10s | %-12s |%n","N° Empleado", "Nombre", "Sexo", "Edad","Cantidad Vendida", "Sueldo Bruto", "Bono", "Impuestos", "Sueldo Total");
        salida += super.toString() + String.format(" %-18s | %-12s | %-10s | %-10s | %-12s |", cantidadVendida, sueldoBruto(), bonos(), calcularImpuestos(sueldoBruto()), sueldo())+"\n";
        return salida;
    }
    
}
