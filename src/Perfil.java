import java.util.ArrayList;
import java.util.List;

public class Perfil {
    private int id;
    private String nivelEducativo;
    private List<String> intereses;

    public Perfil(int id, String nivelEducativo, List<String> intereses) {
        this.id = id;
        this.nivelEducativo = nivelEducativo;
        this.intereses = intereses;
    }

    public String getNivelEducativo() {
        return nivelEducativo;
    }

    public List<String> getIntereses() {
        return intereses;
    }

    // Método para generar recomendaciones de cursos según intereses
    public List<Curso> generarRecomendaciones(List<Curso> cursosDisponibles) {
        List<Curso> cursosRecomendados = new ArrayList<>();
        for (Curso curso : cursosDisponibles) {
            for (String interes : intereses) {
                if (curso.getDescripcion().toLowerCase().contains(interes.toLowerCase())) {
                    cursosRecomendados.add(curso);
                    break;
                }
            }
        }
        return cursosRecomendados;
    }
}
