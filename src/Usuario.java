import java.util.List;

public class Usuario {
    private int id;
    private String nombre;
    private String email;
    private Perfil perfil;
    private List<Curso> cursosAsignados;

    public Usuario(int id, String nombre, String email, List<Curso> cursosAsignados) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.cursosAsignados = cursosAsignados;
    }

    // Método para asignar el perfil
    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public List<Curso> getCursosAsignados() {
        return cursosAsignados;
    }

    public void asignarCurso(Curso curso) {
        cursosAsignados.add(curso);
    }
}
