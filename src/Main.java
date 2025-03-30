import java.util.Collections;
import java.util.Comparator;

public class Main {
        public static void main(String[] args) throws Exception {
                String json = new TmdbApiClient().apiConnectionAndResponse();

                String[] jsonMoviesAtributtes = json.split(",");

                Movie controllerMovie = new Movie();
                controllerMovie.organizeMovies(jsonMoviesAtributtes);

                Collections.sort(controllerMovie.organizeMovies(jsonMoviesAtributtes),
                                Comparator.comparing(Movie::rating).reversed());

                System.out.println(controllerMovie.organizeMovies(jsonMoviesAtributtes));
                HTMLGenerator html = new HTMLGenerator();
                html.generateHTML(controllerMovie.organizeMovies(jsonMoviesAtributtes));

        }
}
