

interface TrafficController {
	void controlTraffic(int vehicleCount);
}


abstract class TrafficSignal implements TrafficController {
	protected String location;
	protected String currentColor;

	public TrafficSignal(String location) {
		this.location = location;
		this.currentColor = "RED"; 
	}


	public void showSignal() {
		System.out.println("Location: " + location + ", Signal: " + currentColor);
	}

	
	protected abstract void decideSignal(int vehicleCount);

	
	@Override
	public void controlTraffic(int vehicleCount) {
		decideSignal(vehicleCount);
		showSignal();
	}
}


class CityTrafficSignal extends TrafficSignal {

	public CityTrafficSignal(String location) {
		super(location);
	}

	@Override
	protected void decideSignal(int vehicleCount) {
		if (vehicleCount == 0) {
			currentColor = "GREEN";      
		} else if (vehicleCount <= 5) {
			currentColor = "YELLOW";     // few vehicles, caution
		} else {
			currentColor = "RED";        // many vehicles, stop
		}
	}
}

class TrafficManagementDemo {
	public static void main(String[] args) {
		CityTrafficSignal signal = new CityTrafficSignal("Main Road");

		int[] vehiclesAtSignal = {0, 3, 10};

		for (int count : vehiclesAtSignal) {
			System.out.println("\nVehicles waiting: " + count);
			signal.controlTraffic(count);
		}
	}
}
