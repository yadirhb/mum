package prob2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AdminTestCase {
    Admin admin;

    @BeforeEach
    void setup(){
        Department bill = mock(BillingDept.class);
        Department mark = mock(MarketingDept.class);
        Department sale = mock(SalesDept.class);

        when(bill.getName()).thenReturn("B");
        when(mark.getName()).thenReturn("M");
        when(sale.getName()).thenReturn("S");

        when(bill.nextMessage()).thenReturn("Billing message");
        when(mark.nextMessage()).thenReturn("Marketing message");
        when(sale.nextMessage()).thenReturn("Sales message");

        this.admin = new Admin(new Department[]{bill, mark, sale});
    }

    @Test
    void testHourlyCompanyMessage(){
        assertThat(this.admin.hourlyCompanyMessage(), is(equalTo("B: Billing message\nM: Marketing message\nS: Sales message\n")));
    }
}
