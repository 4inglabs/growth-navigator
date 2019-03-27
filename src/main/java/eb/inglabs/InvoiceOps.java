package eb.inglabs;

import eb.inglabs.dao.InvoiceMapper;
import eb.inglabs.model.AmountDaily;
import eb.inglabs.model.AmountWeekly;
import eb.inglabs.model.Invoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Component
public class InvoiceOps {

    final
    InvoiceMapper invoiceMapper;

    @Autowired
    public InvoiceOps(InvoiceMapper invoiceMapper) {
        this.invoiceMapper = invoiceMapper;
    }

    public List<Invoice> findInvoiceByDateRange(LocalDateTime from, LocalDateTime to) {
        return invoiceMapper.findInvoiceByDateRange(from, to);
    }

    public List<AmountDaily> amountDailyList(String ledger) {
        return invoiceMapper.amountsByDay(ledger);
    }

    public List<AmountWeekly> amountWeeklyList(String ledger) {
        return invoiceMapper.totalAmountsByWeek(ledger);
    }

    public BigDecimal totalAmount(String ledger) {
        return invoiceMapper.totalAmount(ledger);
    }
}
