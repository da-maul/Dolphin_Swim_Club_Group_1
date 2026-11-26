import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class SwimmerCsvFileHandler {
    private final Path path = Path.of("data/swimmers.csv");
    private final SwimmersCsvMapper mapper = new SwimmersCsvMapper();

    public void saveSwimmers(ArrayList<Swimmer> swimmers) {
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            writer.write("swimmerId,name,birthDay,isCompetitive,isActive,disciplines,unpaidDues,coach");
            writer.newLine();
            for (Swimmer swimmer : swimmers) {
                writer.write(mapper.toCsv(swimmer));
                writer.newLine();
            }

        }
        catch (IOException e) {
            IO.println("Error saving swimmers: " + e.getMessage());
        }

    }

    public ArrayList<Swimmer> loadSwimmers() {
        ArrayList<Swimmer> swimmers = new ArrayList<>();
        if (!Files.exists(path)) {
            return swimmers;
        }
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            reader.readLine();
            String line;

            while ((line = reader.readLine()) != null) {
                Swimmer swimmer = mapper.fromCsv(line);
                swimmers.add(swimmer);
            }
        } catch (IOException e) {
            IO.println("Error loading swimmers: " + e.getMessage());
        }
        return swimmers;
    }

}
//wario