
import java.util.*;

class Reservation {
    private String reservationId;
    private String name;
    private String email;
    private String date;
    private String trainName;
    private String pnrNumber;
    private String classType;
    private String fromPlace;
    private String toDestination;

    public Reservation(String reservationId, String name, String email, String date,
                       String trainName, String pnrNumber, String classType,
                       String fromPlace, String toDestination) {
        this.reservationId = reservationId;
        this.name = name;
        this.email = email;
        this.date = date;
        this.trainName = trainName;
        this.pnrNumber = pnrNumber;
        this.classType = classType;
        this.fromPlace = fromPlace;
        this.toDestination = toDestination;
    }

    public String getReservationId() {
        return reservationId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getDate() {
        return date;
    }

    public String getTrainName() {
        return trainName;
    }

    public String getPnrNumber() {
        return pnrNumber;
    }

    public String getClassType() {
        return classType;
    }

    public String getFromPlace() {
        return fromPlace;
    }

    public String getToDestination() {
        return toDestination;
    }
}

class ReservationSystem {
    private Map<String, Reservation> reservations;

    public ReservationSystem() {
        reservations = new HashMap<>();
    }

    public void makeReservation(String reservationId, String name, String email, String date,
                                String trainName, String pnrNumber, String classType,
                                String fromPlace, String toDestination) {
        Reservation reservation = new Reservation(reservationId, name, email, date,
                trainName, pnrNumber, classType, fromPlace, toDestination);
        reservations.put(reservationId, reservation);
    }

    public Reservation getReservation(String reservationId) {
        return reservations.get(reservationId);
    }

    public List<Reservation> getAllReservations() {
        return new ArrayList<>(reservations.values());
    }

    public void cancelReservation(String pnrNumber) {
        Reservation reservationToCancel = reservations.remove(pnrNumber);
        if (reservationToCancel != null) {
            reservations.remove(reservationToCancel.getReservationId());
            System.out.println("Reservation with PNR " + pnrNumber + " has been canceled.");
        } else {
            System.out.println("No reservation found with PNR " + pnrNumber + ".");
        }
    }
}
