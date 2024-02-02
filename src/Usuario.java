public class Usuario {
    // Atributos
    private String nombre;
    private String genero;

    public Usuario(String nombre, String genero) {
        this.nombre = nombre;
        this.genero = genero;
    }

    public String getNombre() {
        return nombre;
    }

    public String getGenero() {
        return genero;
    }
}
