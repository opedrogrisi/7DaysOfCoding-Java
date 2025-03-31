import java.util.ArrayList;
import java.util.List;

public record Movie(String title, String urlImage, String rating, String releaseDate) implements Content {

    public Movie() {
        this("", "", "", "");
    }

    public List<Movie> organizeMovies(String[] jsonMoviesAtributtes) {
        List<String> titles = new ArrayList<>();
        List<String> urlList = new ArrayList<>();
        List<String> ratingList = new ArrayList<>();
        List<String> releaseDate = new ArrayList<>();
        List<Movie> movies = new ArrayList<>();
        String[] jsonMoviesAttributes = jsonMoviesAtributtes;
        for (String attribute : jsonMoviesAttributes) {
            if (attribute.contains("title") && !attribute.contains("original_title")) {
                titles.add(getValue(attribute));
            }
        }
        for (String attribute : jsonMoviesAttributes) {
            if (attribute.contains("poster_path")) {
                urlList.add(getValue(attribute));
            }
        }

        for (String attribute : jsonMoviesAttributes) {
            if (attribute.contains("vote_average")) {
                ratingList.add(getValue(attribute));
            }
        }

        for (String attribute : jsonMoviesAttributes) {
            if (attribute.contains("release_date")) {
                releaseDate.add(getValue(attribute));
            }
        }

        for (int i = 0; i < titles.size(); i++) {
            movies.add(new Movie(titles.get(i), urlList.get(i), ratingList.get(i), releaseDate.get(i)));
        }

        return movies;

    }

    private String getValue(String attribute) {
        int startIndex = attribute.indexOf(":") + 1;
        String value = attribute.substring(startIndex).trim().replaceAll("^'|'$", "");
        return value;
    }

    public int compareTo(Content c) {
        return this.rating().compareTo(c.rating());

    }
}
