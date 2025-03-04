import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

class AviaSoulsTest {

    @Test
    void sortFewTickets() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("CSY", "MSK", 1999, 17, 19);
        Ticket ticket2 = new Ticket("CSY", "MSK", 1799, 12, 13);
        Ticket ticket3 = new Ticket("CSY", "SPB", 2899, 8, 11);
        Ticket ticket4 = new Ticket("MSK", "CSY", 2299, 10, 11);
        Ticket ticket5 = new Ticket("SPB", "CSY", 3999, 7, 19);
        Ticket ticket6 = new Ticket("CSY", "KZN", 999, 7, 8);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);

        Ticket[] actual = manager.search("CSY", "MSK");
        Ticket[] expected = {ticket2, ticket1};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void sortZeroTickets() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("CSY", "MSK", 1999, 17, 19);
        Ticket ticket2 = new Ticket("CSY", "MSK", 1799, 12, 13);
        Ticket ticket3 = new Ticket("CSY", "SPB", 2899, 8, 11);
        Ticket ticket4 = new Ticket("MSK", "CSY", 2299, 10, 11);
        Ticket ticket5 = new Ticket("SPB", "CSY", 3999, 7, 19);
        Ticket ticket6 = new Ticket("CSY", "KZN", 999, 7, 8);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);

        Ticket[] actual = manager.search("KZN", "MSK");
        Ticket[] expected = {};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void sortOneTicket() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("CSY", "MSK", 1999, 17, 19);
        Ticket ticket2 = new Ticket("CSY", "MSK", 1799, 12, 13);
        Ticket ticket3 = new Ticket("CSY", "SPB", 2899, 8, 11);
        Ticket ticket4 = new Ticket("MSK", "CSY", 2299, 10, 11);
        Ticket ticket5 = new Ticket("SPB", "CSY", 3999, 7, 19);
        Ticket ticket6 = new Ticket("CSY", "KZN", 999, 7, 8);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);

        Ticket[] actual = manager.search("CSY", "KZN");
        Ticket[] expected = {ticket6};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void sortFewTicketsWithComparator() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("CSY", "MSK", 1999, 17, 19);
        Ticket ticket2 = new Ticket("CSY", "MSK", 1799, 12, 13);
        Ticket ticket3 = new Ticket("CSY", "SPB", 2899, 8, 11);
        Ticket ticket4 = new Ticket("MSK", "CSY", 2299, 10, 11);
        Ticket ticket5 = new Ticket("SPB", "CSY", 3999, 7, 19);
        Ticket ticket6 = new Ticket("CSY", "KZN", 999, 7, 8);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] actual = manager.search("CSY", "MSK", comparator);
        Ticket[] expected = {ticket2, ticket1};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void sortZeroTicketsWithComparator() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("CSY", "MSK", 1999, 17, 19);
        Ticket ticket2 = new Ticket("CSY", "MSK", 1799, 12, 13);
        Ticket ticket3 = new Ticket("CSY", "SPB", 2899, 8, 11);
        Ticket ticket4 = new Ticket("MSK", "CSY", 2299, 10, 11);
        Ticket ticket5 = new Ticket("SPB", "CSY", 3999, 7, 19);
        Ticket ticket6 = new Ticket("CSY", "KZN", 999, 7, 8);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        Comparator<Ticket> comparator = new TicketTimeComparator();


        Ticket[] actual = manager.search("KZN", "MSK", comparator);
        Ticket[] expected = {};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void sortOneTicketWithComparator() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("CSY", "MSK", 1999, 17, 19);
        Ticket ticket2 = new Ticket("CSY", "MSK", 1799, 12, 13);
        Ticket ticket3 = new Ticket("CSY", "SPB", 2899, 8, 11);
        Ticket ticket4 = new Ticket("MSK", "CSY", 2299, 10, 11);
        Ticket ticket5 = new Ticket("SPB", "CSY", 3999, 7, 19);
        Ticket ticket6 = new Ticket("CSY", "KZN", 999, 7, 8);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        Comparator<Ticket> comparator = new TicketTimeComparator();


        Ticket[] actual = manager.search("CSY", "KZN", comparator);
        Ticket[] expected = {ticket6};
        Assertions.assertArrayEquals(expected, actual);
    }
}