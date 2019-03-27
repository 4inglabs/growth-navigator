package eb.inglabs;

import eb.inglabs.dao.InvoiceMapper;
import eb.inglabs.model.AmountDaily;
import eb.inglabs.model.AmountWeekly;
import eb.inglabs.model.Invoice;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static eb.inglabs.App.RECEIVABLE;
import static java.time.LocalDateTime.now;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class InvoiceOpsTest {

    private static final BigDecimal TOTAL_INVOICES_AMOUNT = new BigDecimal("112.23");

    @Mock
    private InvoiceMapper invoiceMapper;

    @InjectMocks
    InvoiceOps invoiceOps;

    @Test
    public void findInvoiceByDateRange() {
        List<Invoice> sampleInvoiceList = sampleInvoiceList();
        LocalDateTime from = now();
        LocalDateTime to = now().plusDays(1);

        when(invoiceMapper.findInvoiceByDateRange(from, to)).thenReturn(sampleInvoiceList);
        assertThat(invoiceOps.findInvoiceByDateRange(from, to)).isEqualTo(sampleInvoiceList);
    }

    @Test
    public void incomeDailyList() {
        List<AmountDaily> sampleDailyList = sampleDailyList();
        when(invoiceMapper.amountsByDay(RECEIVABLE)).thenReturn(sampleDailyList);
        assertThat(invoiceOps.amountDailyList(RECEIVABLE)).isEqualTo(sampleDailyList);
    }

    @Test
    public void incomeWeeklyList() {
        List<AmountWeekly> sampleAmountWeeklyList = sampleAmountWeeklyList();
        when(invoiceMapper.totalAmountsByWeek(RECEIVABLE)).thenReturn(sampleAmountWeeklyList);
        assertThat(invoiceOps.amountWeeklyList(RECEIVABLE)).isEqualTo(sampleAmountWeeklyList);
    }

    @Test
    public void totalAmount() {
        when(invoiceMapper.totalAmount(RECEIVABLE)).thenReturn(TOTAL_INVOICES_AMOUNT);
        assertThat(invoiceOps.totalAmount(RECEIVABLE)).isEqualTo(TOTAL_INVOICES_AMOUNT);
    }

    private List<AmountWeekly> sampleAmountWeeklyList() {
        List<AmountWeekly> amountWeeklyList = new ArrayList<>();
        amountWeeklyList.add(new AmountWeekly().setAmount(new BigDecimal("432.90")).setWeek(10));
        amountWeeklyList.add(new AmountWeekly().setAmount(new BigDecimal("125.33")).setWeek(7));
        return amountWeeklyList;
    }

    private List<AmountDaily> sampleDailyList() {
        List<AmountDaily> amountDaylyList = new ArrayList<>();
        amountDaylyList.add(new AmountDaily().setAmount(new BigDecimal("254.26")).setDateTime(now()));
        amountDaylyList.add(new AmountDaily().setAmount(new BigDecimal("84.23")).setDateTime(now()));
        amountDaylyList.add(new AmountDaily().setAmount(new BigDecimal("457.19")).setDateTime(now()));
        return amountDaylyList;
    }

    private List<Invoice> sampleInvoiceList() {
        List<Invoice> invoiceList = new ArrayList<>();
        invoiceList.add(new Invoice().setAmount(new BigDecimal("152.54")).setDue_date(now()).setId(1).setInvoice_number(11).setParty_id(15));
        invoiceList.add(new Invoice().setAmount(new BigDecimal("432.22")).setDue_date(now()).setId(2).setInvoice_number(21).setParty_id(91));
        return invoiceList;
    }
}