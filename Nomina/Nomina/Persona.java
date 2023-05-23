package Nomina;
public class Persona{
    private String nombre;
    private String apellido;
    private byte edad;
    private char sexo;

    public Persona(String nombre, String apellido, byte edad, char sexo){
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.sexo = Character.toUpperCase(sexo);
    }

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }
   
    public String getApellido() {
		return apellido;
	}
	
    public void setApellido(String apellido) {
		this.apellido = apellido;
	}

    public byte getEdad(){
        return edad;
    }

    public void setEdad(byte edad){
        this.edad = edad;
    }

    public char getSexo(){
        return sexo;
    }

    public void setSexo(char sexo){
        this.sexo = sexo;
    }

    public String toString(){
        return String.format(" %-20.20s | %-4s | %-4s |", this.nombre+" "+this.apellido, this.sexo, this.edad);
    }

    public boolean equals(Object o){
        boolean e = false;
        if(o instanceof Persona){
            Persona p = (Persona) o;
            e = this.nombre.equals(p.nombre) && this.apellido.equals(p.apellido) && this.edad == p.edad && Character.toString(sexo).equals(Character.toString(p.sexo));
        }
        return e;
    }
}