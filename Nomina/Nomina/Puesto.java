package Nomina;

public enum Puesto{
    SECRETARIO(2500, "Secretario", "Secretaria"),
    INTENDENTE(2300, "Intendente", "Intendente"),
    OPERADOR(3500, "Operador", "Operadora"),
    PROGRAMADOR(8000, "Programador", "Programadora"),
    JEFE_OFICINA(5000, "Jefe oficina","Jefa oficina"),
    DIRECTOR(12000, "Director","Directora");

    private final float sueldo;
    private final String nombrePuestoMasculino;
    private final String nombrePuestoFemenino;
    private Puesto(float sueldo, String nombrePuestoMasculino, String nombrePuestoFemenino){
        this.sueldo = sueldo;
        this.nombrePuestoMasculino = nombrePuestoMasculino;
        this.nombrePuestoFemenino = nombrePuestoFemenino;
        
    }

    public float getSueldo(){
        return sueldo;
    }

    public String getNombrePuestoMasculino(){
        return nombrePuestoMasculino;
    }

    public String getNombrePuestoFemenino(){
        return nombrePuestoFemenino;
    }
}
