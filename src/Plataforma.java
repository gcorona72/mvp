import java.util.List;

public class Plataforma {
    private List<Usuario> usuarios;
    private List<Curso> cursos;

    public Plataforma(List<Usuario> usuarios, List<Curso> cursos) {
        this.usuarios = usuarios;
        this.cursos = cursos;
    }

    public List<Curso> personalizarContenido(Usuario usuario) {
        // Implementación pendiente
        return null;
    }

    // Getters y Setters
    public List<Usuario> getUsuarios() { return usuarios; }
    public void setUsuarios(List<Usuario> usuarios) { this.usuarios = usuarios; }

    public List<Curso> getCursos() { return cursos; }
    public void setCursos(List<Curso> cursos) { this.cursos = cursos; }
}
