package eb.inglabs.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Invoice {

    int id;
    int party_id;
    int invoice_number;
    BigDecimal amount;
    LocalDateTime due_date;
    String ledger;

    public int getId() {
        return id;
    }

    public int getParty_id() {
        return party_id;
    }

    public int getInvoice_number() {
        return invoice_number;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public LocalDateTime getDue_date() {
        return due_date;
    }

    public String getLedger() {
        return ledger;
    }

    public Invoice setId(int id) {
        this.id = id;
        return this;
    }

    public Invoice setParty_id(int party_id) {
        this.party_id = party_id;
        return this;
    }

    public Invoice setInvoice_number(int invoice_number) {
        this.invoice_number = invoice_number;
        return this;
    }

    public Invoice setAmount(BigDecimal amount) {
        this.amount = amount;
        return this;
    }

    public Invoice setDue_date(LocalDateTime due_date) {
        this.due_date = due_date;
        return this;
    }

    public Invoice setLedger(String ledger) {
        this.ledger = ledger;
        return this;
    }
}
