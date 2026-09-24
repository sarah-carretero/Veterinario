public class mascota {
    String nombre, tipo, edad;

    mascota(String nombre, String tipo, String edad){
        this.nombre = nombre;
        this.tipo = tipo;
        this.edad = edad;
    }

    public String getNombre(){
        return nombre;
    }

    public String toString(){
        return "Nombre: " + nombre + ", Tipo: " + tipo + ", Edad: " + edad;
    }

    public String getType(){
        return tipo;
    }

    public String getOld(){
        return edad;
    }

}
