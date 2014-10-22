package ph.txtdis.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import ph.txtdis.model.CreditDetail;
import ph.txtdis.model.Customer;
import ph.txtdis.model.CustomerDiscount;
import ph.txtdis.model.Routing;
import ph.txtdis.model.SystemUser;
import ph.txtdis.type.CustomerType;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {

    @Query("select min(c.id) from Customer c")
    int getMinId();

    @Query("select max(c.id) from Customer c")
    int getMaxId();

    @Query("select c.routeHistory from Customer c where c.id = ?1")
    List<Routing> getRouteHistory(int id);

    @Query("select c.creditDetails from Customer c where c.id = ?1")
    List<CreditDetail> getCreditDetails(int id);

    @Query("select c.discounts from Customer c where c.id = ?1")
    List<CustomerDiscount> getDiscounts(int id);

    @Query("select c.type from Customer c where c.id = ?1")
    CustomerType getType(int id);

    List<Customer> findByNameContaining(String name);

    List<Customer> findByName(String name);

    List<Customer> findByDisabledByOrderByNameAsc(SystemUser disabledBy);
}
