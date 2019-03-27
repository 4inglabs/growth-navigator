package eb.inglabs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static java.lang.invoke.MethodHandles.lookup;

@SpringBootApplication
public class App implements CommandLineRunner {
    private static final Class klass = lookup().lookupClass();
    private static final Logger LOG = LoggerFactory.getLogger(klass);

    public static final String RECEIVABLE = "R";
    public static final String PAYABLE = "P";

    private final InvoiceOps invoiceOps;

    @Autowired
    public App(InvoiceOps invoiceOps) {
        this.invoiceOps = invoiceOps;
    }


    public static void main(String... args) {
        SpringApplication.run(lookup().lookupClass(), args);
    }

    @Override
    public void run(String... args) {
        LOG.info("--------------------------------------------", invoiceOps.totalAmount(RECEIVABLE));
        LOG.info("Total incoming amounts historic invoices: {}", invoiceOps.totalAmount(RECEIVABLE));
        LOG.info("Total outgoing amounts historic invoices: {}", invoiceOps.totalAmount(PAYABLE));

        LOG.info("--------------------------------------------", invoiceOps.totalAmount(RECEIVABLE));
        LOG.info("Aggregate incoming amounts by day:");
        invoiceOps.amountDailyList(RECEIVABLE).forEach(amountDaily -> LOG.info("Date: {}, amount: {}", amountDaily.getDateTime(), amountDaily.getAmount()));
        LOG.info("--------------------------------------------", invoiceOps.totalAmount(RECEIVABLE));
        LOG.info("Aggregate incoming amounts by week:");
        invoiceOps.amountWeeklyList(RECEIVABLE).forEach(amountWeekly -> LOG.info("Week: {}, amount: {}", amountWeekly.getWeek(), amountWeekly.getAmount()));

        LOG.info("--------------------------------------------", invoiceOps.totalAmount(PAYABLE));
        LOG.info("Aggregate outgoing amounts by day:");
        invoiceOps.amountDailyList(PAYABLE).forEach(amountDaily -> LOG.info("Date: {}, amount: {}", amountDaily.getDateTime(), amountDaily.getAmount()));
        LOG.info("--------------------------------------------", invoiceOps.totalAmount(PAYABLE));
        LOG.info("Aggregate outgoing amounts by week:");
        invoiceOps.amountWeeklyList(PAYABLE).forEach(amountWeekly -> LOG.info("Week: {}, amount: {}", amountWeekly.getWeek(), amountWeekly.getAmount()));
    }
}
