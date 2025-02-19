public class Curso {
    private int id;
    private String titulo;
    private String descripcion;
    private String nivel;

    public Curso(int id, String titulo, String descripcion, String nivel) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.nivel = nivel;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void asignarUsuario(Usuario usuario) {
        usuario.asignarCurso(this);
    }
}
