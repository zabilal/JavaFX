package ph.txtdis.service;

import ph.txtdis.model.Booking;
import ph.txtdis.model.InvoiceBooklet;
import ph.txtdis.model.Invoicing;
import ph.txtdis.model.InvoicingDetail;

public interface InvoicingService extends OrderService<Invoicing, InvoicingDetail> {

    InvoiceBooklet getBooklet(int id);

    Integer getBookletLastId(int startId, int endId);

    Integer getIdFromSalesOrder(Booking booking);
}