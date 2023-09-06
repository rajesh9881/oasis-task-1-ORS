import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
    private static int reservationCounter = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ReservationSystem reservationSystem = new ReservationSystem();

        System.out.println("Welcome to the Online Reservation System!");
        try {
            while (true) {
                System.out.println("Main Menu:");
                System.out.println("1. Make a Reservation");
                System.out.println("2. View Reservations");
                System.out.println("3. Cancel Reservation");
                System.out.println("4. Exit");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); 

                switch (choice) {
                    case 1:
                    System.out.print("Enter your name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter your email: ");
                    String email = scanner.nextLine();
                    System.out.print("Enter the reservation date (yyyy-MM-dd): ");
                    String date = scanner.nextLine();
                    System.out.print("Choose a train number ");
                    String trainNumber = scanner.nextLine();
                    String trainName = getTrainName(trainNumber);
                    System.out.print("Enter class type (e.g., First Class): ");
                    String classType = scanner.nextLine();
                    System.out.print("Enter from place: ");
                    String fromPlace = scanner.nextLine();
                    System.out.print("Enter to destination: ");
                    String toDestination = scanner.nextLine();
                    String pnrNumber = generateUniquePnrNumber();

                    reservationSystem.makeReservation(generateUniqueReservationId(), name, email, date, trainName, pnrNumber, classType, fromPlace, toDestination);
                    System.out.println("Reservation successfully created!");
                    break;
                    case 2:
                        List<Reservation> allReservations = reservationSystem.getAllReservations();
                        System.out.println("All Reservations:");
                        for (Reservation reservation : allReservations) {
                            System.out.println("Reservation ID: " + reservation.getReservationId());
                            System.out.println("Name: " + reservation.getName());
                            System.out.println("Email: " + reservation.getEmail());
                            System.out.println("Date: " + reservation.getDate());
                            System.out.println("Train Name: " + reservation.getTrainName());
                            System.out.println("PNR Number: " + reservation.getPnrNumber());
                            System.out.println("Class Type: " + reservation.getClassType());
                            System.out.println("From Place: " + reservation.getFromPlace());
                            System.out.println("To Destination: " + reservation.getToDestination());
                            System.out.println();
                        }
                        break;
                    case 3:
                        System.out.print("Enter PNR number to cancel reservation: ");
                        String pnrToCancel = scanner.nextLine();
                        reservationSystem.cancelReservation(pnrToCancel);
                        break;
                    case 4:
                        System.out.println("Thank you for using the Online Reservation System. Goodbye!");
                        return;
                    default:
                        System.out.println("Invalid choice. Please enter a valid option.");
                }
            }
        } finally {
            scanner.close();
        }
    }

    private static String getTrainName(String trainNumber) {
       
        if ("123".equals(trainNumber)) {
            return "Sample Train";
        } else {
            return "Unknown Train";
        }
    }

    private static String generateUniqueReservationId() {

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMM");
        String timestamp = dateFormat.format(new Date());
        String uniqueId = timestamp + "_" + reservationCounter;
        reservationCounter++;
        return uniqueId;
    }

    private static String generateUniquePnrNumber() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMdd");
        String timestamp = dateFormat.format(new Date());
        return "PNR" + timestamp;
    }
}