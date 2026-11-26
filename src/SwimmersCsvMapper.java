import java.time.LocalDate;
import java.util.ArrayList;
import java.util.StringJoiner;
public class SwimmersCsvMapper {
    public String toCsv(Swimmer swimmer){
        StringJoiner joiner = new StringJoiner(";");
        for (Discipline discipline : swimmer.disciplines()) {
            joiner.add(discipline.name());
        }
        String coach = swimmer.coach() == null ? "" : swimmer.coach().name();

        return swimmer.swimmerId() + "," +
                swimmer.name() + "," +
                swimmer.birthDay() + ","+
                swimmer.isCompetitive() + "," +
                swimmer.isActive() + "," +
                joiner + "," +
                swimmer.unpaidDues()+ "," +
                coach;
    }


    public Swimmer fromCsv(String line){
        ArrayList<Discipline> disciplines = new ArrayList<>();
        String[] parts = line.split(",", -1);
        int swimmerId = Integer.parseInt(parts[0]);
        String name = parts[1];
        LocalDate birthDay = LocalDate.parse(parts[2]);
        boolean isCompetitive = Boolean.parseBoolean(parts[3]);
        boolean isActive = Boolean.parseBoolean(parts[4]);
        String[] disciplineNames = parts[5].split(";");
        double unpaidDues = Double.parseDouble(parts[6]);
        Coach coach = parts[7].isEmpty() ? null : new Coach(parts[7]);


        if (!parts[5].isEmpty()) {
            for (String disciplineName : disciplineNames) {
                disciplines.add(Discipline.valueOf(disciplineName));
            }
        }
        return new Swimmer(
                birthDay,
                name,
                isCompetitive,
                isActive,
                disciplines,
                unpaidDues,
                coach,
                swimmerId);

    }




}
//wario