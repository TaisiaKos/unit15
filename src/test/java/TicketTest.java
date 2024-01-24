import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

public class TicketTest {
    @Test
    public void testTicketSort() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK", "SPB", 200, 10, 12);
        Ticket ticket2 = new Ticket("PRM", "SPB", 400, 13, 15);
        Ticket ticket3 = new Ticket("MSK", "VIE", 600, 8, 14);
        Ticket ticket4 = new Ticket("PRM", "ECB", 300, 5, 7);
        Ticket ticket5 = new Ticket("MSK", "SPB", 200, 17, 18);
        Ticket ticket6 = new Ticket("SPB", "PRM", 400, 14, 17);
        Ticket ticket7 = new Ticket("PRM", "SPB", 500, 3, 6);
        Ticket ticket8 = new Ticket("MSK", "SPB", 500, 11, 12);
        Ticket ticket9 = new Ticket("PRM", "SPB", 500, 10, 13);
        Ticket ticket10 = new Ticket("SPB", "VIE", 800, 16, 20);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);
        manager.add(ticket10);

        Ticket[] actual = manager.search("MSK", "SPB");
        Ticket[] expected = {ticket1, ticket5, ticket8};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testTicketSortNull() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK", "SPB", 200, 10, 12);
        Ticket ticket2 = new Ticket("PRM", "SPB", 400, 13, 15);
        Ticket ticket3 = new Ticket("MSK", "VIE", 600, 8, 14);
        Ticket ticket4 = new Ticket("PRM", "ECB", 300, 5, 7);
        Ticket ticket5 = new Ticket("MSK", "SPB", 200, 17, 18);
        Ticket ticket6 = new Ticket("SPB", "PRM", 400, 14, 17);
        Ticket ticket7 = new Ticket("PRM", "SPB", 500, 3, 6);
        Ticket ticket8 = new Ticket("MSK", "SPB", 500, 11, 12);
        Ticket ticket9 = new Ticket("PRM", "SPB", 500, 10, 13);
        Ticket ticket10 = new Ticket("SPB", "VIE", 800, 16, 20);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);
        manager.add(ticket10);

        Ticket[] actual = manager.search("PRM", "VIE");
        Ticket[] expected = {};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testTicketSortOne() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK", "SPB", 200, 10, 12);
        Ticket ticket2 = new Ticket("PRM", "SPB", 400, 13, 15);
        Ticket ticket3 = new Ticket("MSK", "VIE", 600, 8, 14);
        Ticket ticket4 = new Ticket("PRM", "ECB", 300, 5, 7);
        Ticket ticket5 = new Ticket("MSK", "SPB", 200, 17, 18);
        Ticket ticket6 = new Ticket("SPB", "PRM", 400, 14, 17);
        Ticket ticket7 = new Ticket("PRM", "SPB", 500, 3, 6);
        Ticket ticket8 = new Ticket("MSK", "SPB", 500, 11, 12);
        Ticket ticket9 = new Ticket("PRM", "SPB", 500, 10, 13);
        Ticket ticket10 = new Ticket("SPB", "VIE", 800, 16, 20);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);
        manager.add(ticket10);

        Ticket[] actual = manager.search("SPB", "VIE");
        Ticket[] expected = {ticket10};

        Assertions.assertArrayEquals(expected, actual);
    }


    @Test
    public void testTicketSortComparator() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK", "SPB", 200, 10, 12);
        Ticket ticket2 = new Ticket("PRM", "SPB", 400, 13, 15);
        Ticket ticket3 = new Ticket("MSK", "VIE", 600, 8, 14);
        Ticket ticket4 = new Ticket("PRM", "ECB", 300, 5, 7);
        Ticket ticket5 = new Ticket("MSK", "SPB", 200, 17, 21);
        Ticket ticket6 = new Ticket("SPB", "PRM", 400, 14, 17);
        Ticket ticket7 = new Ticket("PRM", "SPB", 500, 3, 6);
        Ticket ticket8 = new Ticket("MSK", "SPB", 500, 11, 12);
        Ticket ticket9 = new Ticket("PRM", "SPB", 500, 10, 13);
        Ticket ticket10 = new Ticket("SPB", "VIE", 800, 16, 20);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);
        manager.add(ticket10);
        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] actual = manager.search("MSK", "SPB", comparator);
        Ticket[] expected = {ticket8, ticket1, ticket5};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testTicketSortNullComparator() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK", "SPB", 200, 10, 12);
        Ticket ticket2 = new Ticket("PRM", "SPB", 400, 13, 15);
        Ticket ticket3 = new Ticket("MSK", "VIE", 600, 8, 14);
        Ticket ticket4 = new Ticket("PRM", "ECB", 300, 5, 7);
        Ticket ticket5 = new Ticket("MSK", "SPB", 200, 17, 18);
        Ticket ticket6 = new Ticket("SPB", "PRM", 400, 14, 17);
        Ticket ticket7 = new Ticket("PRM", "SPB", 500, 3, 6);
        Ticket ticket8 = new Ticket("MSK", "SPB", 500, 11, 12);
        Ticket ticket9 = new Ticket("PRM", "SPB", 500, 10, 13);
        Ticket ticket10 = new Ticket("SPB", "VIE", 800, 16, 20);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);
        manager.add(ticket10);
        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] actual = manager.search("PRM", "VIE", comparator);
        Ticket[] expected = {};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testTicketSortOneComparator() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK", "SPB", 200, 10, 12);
        Ticket ticket2 = new Ticket("PRM", "SPB", 400, 13, 15);
        Ticket ticket3 = new Ticket("MSK", "VIE", 600, 8, 14);
        Ticket ticket4 = new Ticket("PRM", "ECB", 300, 5, 7);
        Ticket ticket5 = new Ticket("MSK", "SPB", 200, 17, 18);
        Ticket ticket6 = new Ticket("SPB", "PRM", 400, 14, 17);
        Ticket ticket7 = new Ticket("PRM", "SPB", 500, 3, 6);
        Ticket ticket8 = new Ticket("MSK", "SPB", 500, 11, 12);
        Ticket ticket9 = new Ticket("PRM", "SPB", 500, 10, 13);
        Ticket ticket10 = new Ticket("SPB", "VIE", 800, 16, 20);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);
        manager.add(ticket10);
        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] actual = manager.search("SPB", "VIE", comparator);
        Ticket[] expected = {ticket10};

        Assertions.assertArrayEquals(expected, actual);
    }


}
