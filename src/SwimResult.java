import java.time.Duration;
import java.time.LocalDate;

//swim results tabulate information regarding a particular training/competition time
//including the swimmer, competition, and if the time was during training or
//a competition
public record SwimResult(
        LocalDate date,
        boolean isCompetitive, // could be replaced by an Enum
        Event event,
        Swimmer swimmer,
        int placement,
        Duration time //TODO research this type more thoroughly
) {}
