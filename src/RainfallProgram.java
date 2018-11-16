import java.io.*;

public class RainfallProgram {
	public static void main(String[] args) throws IOException {
		BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));

		RainfallStats stats = new RainfallStats();
		System.out.println("Enter rainfall measurements (in mm), or \"end\" to stop.");

		while (true) {
			System.out.print("> ");
			String line = keyboard.readLine();
			if ("end".equals(line)) {
				break;
			}
			try {
				double number = Double.parseDouble(line);
				if (number < 0) {
					System.out.println("Invalid number entered, cannot input negative numbers");
				} else {
					stats.addMeasurement(number);
				}
			} catch (Exception e) {
				System.out.println("Invalid number entered, please try again");
			}
		}

		System.out.println(stats.getCount() + " measurement(s) entered.");

		if (stats.getCount() == 0) {
			System.out.println("No measurements have been added, cannot print mean and maximum");
		} else {
			System.out.println("Mean rainfall: " + stats.getMean() + " mm");
			System.out.println("Maximum rainfall: " + stats.getMax() + " mm");
		}
	}
}
