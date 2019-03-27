package eb.inglabs.rest;


import eb.inglabs.InvoiceOps;
import eb.inglabs.model.Invoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
public class RestOpsController {

    public static final String DATE_PATTERN = "yyyy-MM-dd";
    public static final String FROM = "from";
    public static final String TO = "to";
    private final InvoiceOps invoiceOps;

    @Autowired
    public RestOpsController(InvoiceOps invoiceOps) {
        this.invoiceOps = invoiceOps;
    }

    @GetMapping("/querydata")
    @ResponseBody
    public List<Invoice> invoiceFromTo(@RequestParam(FROM) @DateTimeFormat(pattern = DATE_PATTERN) LocalDate from, @RequestParam(TO) @DateTimeFormat(pattern = DATE_PATTERN) LocalDate to) {
        return invoiceOps.findInvoiceByDateRange(from.atStartOfDay(), to.atStartOfDay());
    }
}
