package ph.txtdis.dto;

import java.time.LocalDate;

import ph.txtdis.model.Booking;
import ph.txtdis.model.InvoiceBooklet;
import ph.txtdis.model.Invoicing;
import ph.txtdis.model.InvoicingDetail;
import ph.txtdis.model.Remitted;

public interface InvoicingDTO extends OrderDTO<Invoicing, InvoicingDetail>, Remitted, Audited<Invoicing> {

    int getBookingId();

    Booking getBooking();

    void setBooking(Booking booking);

    InvoiceBooklet getBooklet(int id);

    Integer getBookletLastId(int startId, int endId);

    Integer getIdFromSalesOrder(Booking booking);

    LocalDate getPickDateFromSalesOrder(Booking booking);
}
