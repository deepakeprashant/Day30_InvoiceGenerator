import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class InvoiceGeneratorTest {

    InvoiceGenerator invoiceGenerator;

    @BeforeEach
    void setUp() {
        invoiceGenerator = new InvoiceGenerator();
    }

    @Test
    public void givenDistanceAndTime_ShouldReturnFare() {
        invoiceGenerator = new InvoiceGenerator();
        double distance = 2.0;
        int time = 5;
        double fare = invoiceGenerator.calculatorFare(distance, time);
        Assertions.assertEquals(25.0, fare);
    }

    @Test
    public void givenDistanceAndTime_ShouldReturnMinimumFare() {
        double distance = 0.1;
        int time = 1;
        double fare = invoiceGenerator.calculatorFare(distance, time);
        Assertions.assertEquals(5.0, fare);
    }

    @Test
    void givenMultipleRides_ShouldReturnAggregateTotalFare() {
        Ride rides[] =
                {
                        new Ride(2.0, 5),
                        new Ride(0.1, 1)
                };
        double totalFare = invoiceGenerator.calculatorRidesFare(rides);
        Assertions.assertEquals(30, totalFare);
    }
}
