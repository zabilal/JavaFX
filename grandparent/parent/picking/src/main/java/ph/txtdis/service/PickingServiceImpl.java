package ph.txtdis.service;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ph.txtdis.model.Booking;
import ph.txtdis.model.PickList;
import ph.txtdis.model.Picking;
import ph.txtdis.model.PickingDetail;
import ph.txtdis.model.PickingSummary;
import ph.txtdis.model.Route;
import ph.txtdis.model.Truck;
import ph.txtdis.repository.PickingRepository;
import ph.txtdis.repository.PickingSummaryRepository;

@Service
@Transactional()
public class PickingServiceImpl extends AbstractService<Picking, Integer> implements PickingService {

    @Autowired
    private PickingRepository repository;

    @Autowired
    private PickingSummaryRepository summaryRepository;

    protected PickingServiceImpl() {
    }

    @Override
    public Integer getMinId() {
        return repository.getMinId();
    }

    @Override
    public Integer getMaxId() {
        return repository.getMaxId();
    }

    @Override
    public List<PickingDetail> getDetails(int id) {
        return repository.getDetails(id);
    }

    @Override
    public List<Booking> getUnpickedBookings(LocalDate date, Route route) {
        return repository.getUnpickedBookings(date, route);
    }

    @Override
    public List<Route> getNotFullyPickedRoutes(LocalDate date) {
        return repository.getNotFullyPickedRoutes(date);
    }

    @Override
    public List<Truck> getEmptyTrucks(LocalDate date) {
        return repository.getEmptyTrucks(date);
    }

    @Override
    public List<Truck> getLoadedTrucks(LocalDate date) {
        return repository.getLoadedTrucks(date);
    }

    @Override
    public List<PickList> generatePickList(int id) {
        return repository.generatePickList(id);
    }

    @Override
    public List<PickingSummary> getSummary(LocalDate startDate, LocalDate endDate) {
        return summaryRepository.findByPickDateBetween(startDate, endDate);
    }

    @Override
    public LocalDate getPickDateFromSalesOrder(Booking booking) {
        return repository.getPickDateFromSalesOrder(booking);
    }
}
