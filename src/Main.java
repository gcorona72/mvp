import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Plataforma plataforma = new Plataforma(new ArrayList<>(), generarCursosEjemplo());

        // Paso 1: Registrar usuario
        System.out.println("Bienvenido a la plataforma de cursos");
        System.out.print("Ingrese su nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese su email: ");
        String email = scanner.nextLine();

        Usuario usuario = new Usuario(1, nombre, email, new ArrayList<>());
        plataforma.getUsuarios().add(usuario);
        System.out.println("\nUsuario registrado con éxito.");

        // Paso 2: Completar perfil
        System.out.println("\nComplete su perfil");
        System.out.print("Ingrese su nivel educativo: ");
        String nivelEducativo = scanner.nextLine();
        System.out.print("Ingrese sus intereses (separados por comas): ");
        String[] interesesArray = scanner.nextLine().split(",");
        List<String> intereses = new ArrayList<>();
        for (String interes : interesesArray) {
            intereses.add(interes.trim());
        }

        Perfil perfil = new Perfil(1, nivelEducativo, intereses);
        usuario.setPerfil(perfil);

        // Paso 3: Validar si el perfil está completo
        if (perfil.getIntereses().isEmpty() || perfil.getNivelEducativo().isBlank()) {
            System.out.println("\nFalta información en su perfil. Por favor, complételo antes de continuar.");
        } else {
            System.out.println("\nPerfil completado. Generando recomendaciones...");
            List<Curso> cursosRecomendados = perfil.generarRecomendaciones(plataforma.getCursos());

            if (cursosRecomendados.isEmpty()) {
                System.out.println("No se encontraron cursos que coincidan con sus intereses.");
            } else {
                System.out.println("\nLista de cursos recomendados:");
                for (int i = 0; i < cursosRecomendados.size(); i++) {
                    System.out.println((i + 1) + ". " + cursosRecomendados.get(i).getTitulo());
                }

                // Paso 4: Seleccionar un curso
                System.out.print("\nSeleccione un curso ingresando el número correspondiente: ");
                int seleccion = scanner.nextInt();
                scanner.nextLine(); // Limpiar buffer

                if (seleccion > 0 && seleccion <= cursosRecomendados.size()) {
                    Curso cursoSeleccionado = cursosRecomendados.get(seleccion - 1);
                    cursoSeleccionado.asignarUsuario(usuario);
                    System.out.println("\nCurso asignado con éxito. ¡Ahora puedes iniciarlo!");

                    // Paso 5: Iniciar el curso
                    System.out.println("Iniciando el curso: " + cursoSeleccionado.getTitulo() + "...");
                } else {
                    System.out.println("\nSelección inválida.");
                }
            }
        }

        scanner.close();
    }

    // Método auxiliar para generar cursos de ejemplo
    public static List<Curso> generarCursosEjemplo() {
        List<Curso> cursos = new ArrayList<>();
        cursos.add(new Curso(1, "Introducción a Java", "Aprende los fundamentos de Java", "Principiante"));
        cursos.add(new Curso(2, "Desarrollo Web con HTML y CSS", "Crea sitios web con HTML y CSS", "Principiante"));
        cursos.add(new Curso(3, "Spring Boot Avanzado", "Desarrolla microservicios con Spring Boot", "Avanzado"));
        cursos.add(new Curso(4, "Machine Learning con Python", "Explora el mundo del aprendizaje automático", "Intermedio"));
        return cursos;
    }
}
