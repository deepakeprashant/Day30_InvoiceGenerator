public class InvoiceGenerator {

    private static final double MINIMUM_COST_PER_KM = 10;
    private static final int COST_PER_TIME = 1;
    private static final double MINIMUM_FARE = 5;

    public double calculatorFare(double distance, int time) {
        double totalFare = distance * MINIMUM_COST_PER_KM + COST_PER_TIME * time;
        if (totalFare < MINIMUM_FARE) {
            return MINIMUM_FARE;
        }
        return totalFare;
    }

    public InvoiceSummary calculatorRidesFare(Ride[] rides) {
        double totalFare = 0.0;
        for (Ride ride : rides) {
            totalFare += this.calculatorFare(ride.distance , ride.time);
        }
        return new InvoiceSummary(rides.length, totalFare);
    }
}
