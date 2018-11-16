import java.util.ArrayList;
import java.util.List;

public class RainfallStats {

    private final List<Double> entries = new ArrayList<>();

    public void addMeasurement(double entry) {
        if (entry < 0) {
            throw new InvalidRainfallException("Cannot add negative measurement " + entry);
        }
        entries.add(entry);
    }

    public int getCount() {
        return entries.size();
    }

    public double getMean() {
        if (entries.isEmpty()) {
            throw new IllegalStateException("Entries is empty");
        }
        double count = entries.size();
        double sum = 0.0;
        for (double entry : entries) {
            sum+= entry;
        }

        return sum / count;
    }

    public double getMax() {
        if (entries.isEmpty()) {
            throw new IllegalStateException("Entries is empty");
        }
        double currentMax = 0;
        for (double entry : entries) {
            if (entry > currentMax) {
                currentMax = entry;
            }
        }
        return currentMax;
    }
}
