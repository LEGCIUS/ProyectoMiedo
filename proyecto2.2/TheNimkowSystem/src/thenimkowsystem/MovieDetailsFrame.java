
package thenimkowsystem;

/**
 *
 * @author Julieth
 */
import javax.swing.*;
import java.awt.*;
import java.util.List;

public class MovieDetailsFrame extends JFrame {
    private static final int LINE_LENGTH_LIMIT = 50;
    private static final int MAX_CAST_HEIGHT = 150;
    private static final int CAST_PER_LINE = 3;

    public MovieDetailsFrame(String title, String overview, String director, String releaseDate, List<String> genres, List<String> cast) {
        setTitle(title);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel titleLabel = new JLabel("Title: " + title);
        JLabel overviewLabel = new JLabel("Overview: ");
        JTextArea overviewTextArea = new JTextArea(insertLineBreaks(overview, LINE_LENGTH_LIMIT));
        overviewTextArea.setEditable(false);
        overviewTextArea.setLineWrap(true);
        overviewTextArea.setWrapStyleWord(true);

        JLabel directorLabel = new JLabel("Director: " + director);
        JLabel releaseDateLabel = new JLabel("Release Date: " + releaseDate);
        JLabel genresLabel = new JLabel("Genres: " + String.join(", ", genres));

        JPanel castPanel = new JPanel(new GridLayout(0, CAST_PER_LINE, 5, 5));
        for (String actor : cast) {
            JLabel actorLabel = new JLabel("Actor: " + actor);
            castPanel.add(actorLabel);
        }

        JScrollPane castScrollPane = new JScrollPane(castPanel);
        castScrollPane.setMaximumSize(new Dimension(Integer.MAX_VALUE, MAX_CAST_HEIGHT));

        panel.add(titleLabel);
        panel.add(overviewLabel);
        panel.add(overviewTextArea);
        panel.add(directorLabel);
        panel.add(releaseDateLabel);
        panel.add(genresLabel);
        panel.add(castScrollPane);

        add(panel);
        setSize(400, 400); // Establecer manualmente el tamaño del frame
        setLocationRelativeTo(null); // Centrar el frame en la pantalla
        setVisible(true);
    }

    private String insertLineBreaks(String input, int lineLength) {
        StringBuilder result = new StringBuilder();
        int length = input.length();

        for (int i = 0; i < length; i++) {
            result.append(input.charAt(i));

            if ((i + 1) % lineLength == 0 && i < length - 1) {
                result.append("\n");
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            String title = "Movie Title";
            String overview = "This is a long overview that needs line breaks to fit in the frame.";
            String director = "Director Name";
            String releaseDate = "2023-01-01";
            List<String> genres = List.of("Genre 1", "Genre 2");
            List<String> cast = List.of("Actor 1", "Actor 2", "Actor 3", "Actor 4", "Actor 5", "Actor 6", "Actor 7");

            new MovieDetailsFrame(title, overview, director, releaseDate, genres, cast);
        });
    }
}
