import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

class Flight {
    private String flightNumber;
    private String destination;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;

    public Flight(String flightNumber, String destination, LocalDateTime departureTime, LocalDateTime arrivalTime) {
        this.flightNumber = flightNumber;
        this.destination = destination;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
    }

    private boolean isUpcoming() {
        return departureTime.isAfter(LocalDateTime.now());
    }

    public void updateDepartureTime(LocalDateTime newDepartureTime) {
        this.departureTime = newDepartureTime;
    }

    public void updateArrivalTime(LocalDateTime newArrivalTime) {
        this.arrivalTime = newArrivalTime;
    }

    public void displayFlightDetails() {
        System.out.println("Flight Number: " + flightNumber);
        System.out.println("Destination: " + destination);
        System.out.println("Departure Time: " + departureTime);
        System.out.println("Arrival Time: " + arrivalTime);
        System.out.println("Upcoming Flight: " + (isUpcoming() ? "Yes" : "No"));
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public boolean isFlightUpcoming() {
        return isUpcoming();
    }
}


class Airport {
    private String name;
    private List<Flight> flights;

    public Airport(String name) {
        this.name = name;
        this.flights = new ArrayList<>();
    }

    private Flight findFlightByNumber(String flightNumber) {
        for (Flight flight : flights) {
            if (flight.getFlightNumber().equals(flightNumber)) {
                return flight;
            }
        }
        return null;
    }

    public void addFlight(Flight flight) {
        flights.add(flight);
        System.out.println("Flight added: " + flight.getFlightNumber());
    }

    public void removeFlight(String flightNumber) {
        Flight flight = findFlightByNumber(flightNumber);
        if (flight != null) {
            flights.remove(flight);
            System.out.println("Flight removed: " + flightNumber);
        } else {
            System.out.println("Flight not found.");
        }
    }

    public List<Flight> getUpcomingFlights() {
        List<Flight> upcomingFlights = new ArrayList<>();
        for (Flight flight : flights) {
            if (flight.isFlightUpcoming()) {
                upcomingFlights.add(flight);
            }
        }
        return upcomingFlights;
    }

    public List<Flight> getCompletedFlights() {
        List<Flight> completedFlights = new ArrayList<>();
        for (Flight flight : flights) {
            if (!flight.isFlightUpcoming()) {
                completedFlights.add(flight);
            }
        }
        return completedFlights;
    }

    public void displayAllFlights() {
        System.out.println("All flights at " + name + " Airport:");
        for (Flight flight : flights) {
            flight.displayFlightDetails();
            System.out.println("----------------------");
        }
    }
}


public class Airport_Management_System {
    public static void main(String[] args) {
        Airport airport = new Airport("International Airport");

        Flight flight1 = new Flight("AA123", "New York", LocalDateTime.of(2024, 9, 28, 10, 30), LocalDateTime.of(2024, 9, 28, 18, 45));
        Flight flight2 = new Flight("BA456", "London", LocalDateTime.of(2024, 9, 29, 14, 0), LocalDateTime.of(2024, 9, 29, 22, 15));

        airport.addFlight(flight1);
        airport.addFlight(flight2);

        airport.displayAllFlights();

        flight1.updateDepartureTime(LocalDateTime.of(2024, 9, 28, 11, 0));
        flight1.updateArrivalTime(LocalDateTime.of(2024, 9, 28, 19, 0));

        airport.removeFlight("BA456");

        airport.displayAllFlights();

        System.out.println("Upcoming Flights:");
        for (Flight flight : airport.getUpcomingFlights()) {
            flight.displayFlightDetails();
        }
    }
}
