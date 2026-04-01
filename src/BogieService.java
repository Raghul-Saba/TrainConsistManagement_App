import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BogieService {

    // UC8: Filter passenger bogies by capacity
    public List<PassengerBogie> filterByCapacity(List<PassengerBogie> bogies, int threshold) {
        return bogies.stream()
                     .filter(b -> b.getCapacity() > threshold)
                     .collect(Collectors.toList());
    }

    // UC9: Group passenger bogies by type
    public Map<String, List<PassengerBogie>> groupByType(List<PassengerBogie> bogies) {
        return bogies.stream()
                     .collect(Collectors.groupingBy(PassengerBogie::getName));
    }

    // UC10: Total seating capacity
    public int getTotalCapacity(List<PassengerBogie> bogies) {
        return bogies.stream()
                     .map(PassengerBogie::getCapacity)
                     .reduce(0, Integer::sum);
    }
}