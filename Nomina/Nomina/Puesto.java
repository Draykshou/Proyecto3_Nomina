package Nomina;

public enum Puesto{
    SECRETARIO(2500, "Secretario"),
    SECRETARIA(2500, "Secretaria"),
    INTENDENTE(2300, "Intendente"),
    OPERADOR(3500, "Operador"),
    OPERADORA(3500, "Operadora"),
    PROGRAMADOR(8000, "Programador"),
    PROGRAMADORA(8000, "Programadora"),
    JEFE_OFICINA(5000, "Jefe oficina"),
    JEFA_OFICINA(5000, "Jefa Oficina"),
    DIRECTOR(12000, "Director"),
    DIRECTORA(12000, "Directora");

    private final float sueldo;
    private final String nombrePuestoGenero;
    private Puesto(float sueldo, String nombrePuestoGenero){
        this.sueldo = sueldo;
        this.nombrePuestoGenero = nombrePuestoGenero;
        
    }

    public float getSueldo(){
        return sueldo;
    }

    public String getPuesto(){
        return nombrePuestoGenero;
    }

}
