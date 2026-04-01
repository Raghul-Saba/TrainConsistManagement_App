import java.util.List;

public class SafetyService {

    // UC12: Safety compliance check
    public boolean isTrainSafe(List<GoodsBogie> bogies) {
        return bogies.stream().allMatch(b -> {
            if ("Cylindrical".equalsIgnoreCase(b.getType())) {
                return "Petroleum".equalsIgnoreCase(b.getCargo());
            }
            return true; // other bogies are flexible
        });
    }
}