import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class HTMLGenerator {
    FileWriter file;
    private PrintWriter writer;

    public HTMLGenerator() {

    }

    public HTMLGenerator(PrintWriter writer) {
        this.writer = writer;
    }

    public void generateHTML(List<Movie> movies) {

        try {
            file = new FileWriter("index.html");
            writer = new PrintWriter(file);

            writer.println("<!DOCTYPE html>\n" +
                    "<html lang=\"pt-BR\">\n" +
                    "<head>\n" +
                    "    <meta charset=\"UTF-8\">\n" +
                    "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                    "    <title>Movies</title>\n" +
                    " <link rel=\"stylesheet\" href=\"/styles/styles.css\">" +
                    " <link rel=\"stylesheet\" href=\"/styles/reset.css\">" +
                    "</head>\n" +
                    "<body>\n");
            for (Movie movie : movies) {
                String div = """
                        <div class="card__filmes">
                            <h4 class="poster__title"> %s </h4>
                            <div class="poster__description">
                                <img src=%sr alt=%s class="poster__image">
                                <p class="poster__paragraph"> Rating: %s </p>
                                <p class="poster__paragraph"> Release Date: %s </p>
                            </div>
                        </div>

                        """;

                writer.println(String.format(div, movie.title(), movie.urlImage(), movie.title(), movie.rating(),
                        movie.releaseDate()));

            }
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
