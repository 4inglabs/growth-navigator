package eb.inglabs.rest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDate;

import static eb.inglabs.rest.RestOpsController.FROM;
import static eb.inglabs.rest.RestOpsController.TO;
import static java.time.LocalDate.now;
import static java.time.LocalDate.parse;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class RestOpsControllerTest {

    public static final String SAMPLE_INVOICE_DATE = "2018-08-14";
    @Autowired
    private MockMvc mvc;

    @Test
    public void invoiceFromTo() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/querydata")
                .param(FROM, parse(SAMPLE_INVOICE_DATE).toString())
                .param(TO, parse(SAMPLE_INVOICE_DATE).toString())
                .accept(MediaType.APPLICATION_JSON))

                .andExpect(status().isOk())
                .andExpect(content().json(("[{\"id\":512,\"party_id\":10535,\"invoice_number\":90069,\"amount\":267.5673,\"due_date\":\"2018-08-14T00:00:00\",\"ledger\":\"R\"},{\"id\":938,\"party_id\":11901,\"invoice_number\":90765,\"amount\":2766.2661,\"due_date\":\"2018-08-14T00:00:00\",\"ledger\":\"P\"},{\"id\":967,\"party_id\":11188,\"invoice_number\":90292,\"amount\":150.9300,\"due_date\":\"2018-08-14T00:00:00\",\"ledger\":\"P\"},{\"id\":1003,\"party_id\":12108,\"invoice_number\":90893,\"amount\":965.8818,\"due_date\":\"2018-08-14T00:00:00\",\"ledger\":\"P\"}]")));

    }
}