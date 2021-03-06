package ph.txtdis.model;

import javax.persistence.Entity;

import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
public class Channel extends AbstractNamed {

    private static final long serialVersionUID = 2554893241196801280L;

    public Channel(String name) {
        super(name);
    }
}
