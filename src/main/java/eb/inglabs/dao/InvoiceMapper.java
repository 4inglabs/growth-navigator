package eb.inglabs.dao;

import eb.inglabs.model.AmountDaily;
import eb.inglabs.model.AmountWeekly;
import eb.inglabs.model.Invoice;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Component
@Mapper
public interface InvoiceMapper {

    @Select("select * from invoice where due_date >= #{from} and due_date <= #{to} order by due_date desc")
    List<Invoice> findInvoiceByDateRange(LocalDateTime from, LocalDateTime to);


    @Results({
            @Result(property = "amount", column = "dailyAmount"),
            @Result(property = "dateTime", column = "due_date")
    })
    @Select("select sum(amount) as dailyAmount, due_date from invoice where ledger=#{ledger} and due_date >= '2018-07-01 00:00:00' group by due_date order by due_date desc")
    List<AmountDaily> amountsByDay(String ledger);

    @Results({
            @Result(property = "amount", column = "weeklyAmount"),
            @Result(property = "week", column = "week")
    })
    @Select("select sum(amount) as weeklyAmount, week(due_date) as week from invoice where ledger=#{ledger} and due_date >= '2018-07-01 00:00:00' group by week(due_date) order by week(due_date) desc")
    List<AmountWeekly> totalAmountsByWeek(String ledger);

    @Select("select sum(amount) from invoice where ledger=#{ledger}")
    BigDecimal totalAmount(String ledger);
}
