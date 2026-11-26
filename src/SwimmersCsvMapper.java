import java.time.LocalDate;
import java.util.ArrayList;
import java.util.StringJoiner;
public class SwimmersCsvMapper {
    private String disciplinesToCsv(Swimmer swimmer) {
        StringJoiner joiner = new StringJoiner(";");

        if (swimmer.disciplines != null) {
            for (Discipline discipline : swimmer.disciplines) {
                joiner.add(discipline.name());
            }
        }

        return joiner.toString();
    }
    private String coachToCsv(Swimmer swimmer) {
        if (swimmer.coach == null) {
            return "";
        }

        return swimmer.coach.name();
    }
    public String toCsv(Swimmer swimmer) {
        return swimmer.getSwimmerId() + "," +
                swimmer.name + "," +
                swimmer.birthDay + "," +
                swimmer.isCompetitive + "," +
                swimmer.isActive + "," +
                disciplinesToCsv(swimmer) + "," +
                swimmer.unpaidDues + "," +
                coachToCsv(swimmer);
    }


    public Swimmer fromCsv(String line) {
        String[] parts = line.split(",", -1);

        int swimmerId = Integer.parseInt(parts[0]);
        String name = parts[1];
        LocalDate birthDay = LocalDate.parse(parts[2]);
        boolean isCompetitive = Boolean.parseBoolean(parts[3]);
        boolean isActive = Boolean.parseBoolean(parts[4]);
        double unpaidDues = Double.parseDouble(parts[6]);

        Swimmer swimmer = new Swimmer(swimmerId, name, birthDay);

        swimmer.setCompetitive(isCompetitive);
        swimmer.setActive(isActive);
        swimmer.unpaidDues = unpaidDues;

        swimmer.disciplines = new ArrayList<>();

        if (!parts[5].isEmpty()) {
            for (String discipline : parts[5].split(";")) {
                swimmer.disciplines.add(Discipline.valueOf(discipline));
            }
        }

        return swimmer;
    }



}
//wario