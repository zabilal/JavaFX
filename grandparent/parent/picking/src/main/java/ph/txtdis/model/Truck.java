package ph.txtdis.model;

import javax.persistence.Entity;

@Entity
public class Truck extends AbstractTyped {
    
    private static final long serialVersionUID = 7715000847451554321L;

    protected Truck() {
    }

    public Truck(String name) {
        super(name);
    }
}