package Nomina;

public class EmpleadoHora extends Empleado{
    private int horasTrabajadas;
    public EmpleadoHora(String nombre, String apellido, byte edad, char sexo, String numEmpleado, int horasTrabajadas){
        super(nombre, apellido, edad, sexo, numEmpleado);
        this.horasTrabajadas = horasTrabajadas;
    }

    public int getHorasTrabajadas(){
        return horasTrabajadas;
    }
    public void setHorasTrabajadas(int horasTrabajadas){
        this.horasTrabajadas = horasTrabajadas;
    }
    
    public float bonos(){
      float bono = 0;
        if (horasTrabajadas >= 80) {
            if (getSexo() == 'M') {
                bono = + 1200;
            } else {
                bono = + 600;
            }
        }
        return bono;
    }

    @Override
    public float sueldoBruto(){
        float sueldoBruto = 0;
        int horasExtras = 0;
        if (horasTrabajadas<=80) {
            sueldoBruto = 40 * horasTrabajadas;
        } else {
            horasExtras = horasTrabajadas - 80;
            sueldoBruto = (80 * 40) + (horasExtras * 50);
        }
        return sueldoBruto + bonos();
    }

    @Override
    public float sueldo(){
        float sueldo = (sueldoBruto()) - calcularImpuestos(sueldoBruto());
        return Math.round(sueldo * 100) / 100f;
    }
    
    @Override
    public String ImprimirDatosNomina(){
        return String.format("| %-12s | %-20s | %-4s | %-18s | %-12s | %-10s | %-10s | %-12s |%n", numEmpleado, getNombre()+" "+getApellido(), getSexo(), "Empleado por Horas", sueldoBruto(), bonos(), calcularImpuestos(sueldoBruto()), sueldo());
    }

      public String toString(){
        String salida = String.format("| %-12s | %-20s | %-4s | %-4s | %-18s | %-12s | %-10s | %-10s | %-12s |%n","N° Empleado", "Nombre", "Sexo", "Edad","Horas Trabajadas", "Sueldo Bruto", "Bono", "Impuestos", "Sueldo Total");
        salida += super.toString() + String.format(" %-18s | %-12s | %-10s | %-10s | %-12s |", horasTrabajadas, sueldoBruto(), bonos(), calcularImpuestos(sueldoBruto()), sueldo())+"\n";
        return salida;
    }
}
