import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class ReservationSystem {
    private List<String> availableFlights;
    private List<String> availableHotels;
    private List<String> bookedFlights;
    private List<String> bookedHotels;

    public ReservationSystem() {
        availableFlights = new ArrayList<>();
        availableHotels = new ArrayList<>();
        bookedFlights = new ArrayList<>();
        bookedHotels = new ArrayList<>();
        
        availableFlights.add("Banaras To Lucknow");
        availableFlights.add("Delhi To Mumbai");
        availableFlights.add("Lucknow To Delhi");
        
        availableHotels.add("Hotel Taj in Lucknow");
        availableHotels.add("Hotel Leela in Delhi");
        availableHotels.add("Hotel Sheraton in Mumbai");
    }

    
    public void searchFlights(String source, String destination) {
        System.out.println("Available Flights from " + source + " to " + destination + ":");
        for (String flight : availableFlights) {
            if (flight.contains(source) && flight.contains(destination)) {
                System.out.println(flight);
            }
        }
    }

   
    public void searchHotels(String city) {
        System.out.println("Hotels in " + city + ":");
        for (String hotel : availableHotels) {
            if (hotel.contains(city)) {
                System.out.println(hotel);
            }
        }
    }

   
    public void bookFlight(String flight) {
        if (availableFlights.contains(flight)) {
            bookedFlights.add(flight);
            System.out.println("Flight Booked: " + flight);
            availableFlights.remove(flight);
        } else {
            System.out.println("Sorry flight not available.");
        }
    }

    
    public void bookHotel(String hotel) {
        if (availableHotels.contains(hotel)) {
            bookedHotels.add(hotel);
            System.out.println("Hotel booked: " + hotel);
            availableHotels.remove(hotel);
        } else {
            System.out.println("Sorry hotel not available.");
        }
    }

   
    public void cancelFlight(String flight) {
        if (bookedFlights.contains(flight)) {
            bookedFlights.remove(flight);
            availableFlights.add(flight);
            System.out.println("Flight Cancelled: " + flight);
        } else {
            System.out.println("No flight booked.");
        }
    }

    
    public void cancelHotel(String hotel) {
        if (bookedHotels.contains(hotel)) {
            bookedHotels.remove(hotel);
            availableHotels.add(hotel);
            System.out.println("Hotel cancelled: " + hotel);
        } else {
            System.out.println("No hotel booked.");
        }
    }

   
    public void displayMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Reservation System");
            System.out.println("1. Search Flights");
            System.out.println("2. Search Hotels");
            System.out.println("3. Book Flight");
            System.out.println("4. Book Hotel");
            System.out.println("5. Cancel Flight");
            System.out.println("6. Cancel Hotel");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");
            choice = scanner.nextInt();
            scanner.nextLine();  

            switch (choice) {
                case 1:
                    System.out.print("Enter source city: ");
                    String source = scanner.nextLine();
                    System.out.print("Enter destination city: ");
                    String destination = scanner.nextLine();
                    searchFlights(source, destination);
                    break;

                case 2:
                    System.out.print("Enter city to search hotels: ");
                    String city = scanner.nextLine();
                    searchHotels(city);
                    break;

                case 3:
                    System.out.print("Enter flight to book: ");
                    String flightToBook = scanner.nextLine();
                    bookFlight(flightToBook);
                    break;

                case 4:
                    System.out.print("Enter hotel to book: ");
                    String hotelToBook = scanner.nextLine();
                    bookHotel(hotelToBook);
                    break;

                case 5:
                    System.out.print("Enter flight to cancel: ");
                    String flightToCancel = scanner.nextLine();
                    cancelFlight(flightToCancel);
                    break;

                case 6:
                    System.out.print("Enter hotel to cancel: ");
                    String hotelToCancel = scanner.nextLine();
                    cancelHotel(hotelToCancel);
                    break;

                case 7:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid option, please try again.");
            }

        } while (choice != 7);

        scanner.close();
    }

    public static void main(String[] args) {
        ReservationSystem system = new ReservationSystem();
        system.displayMenu();  // Display the menu and start the interaction
    }
}
