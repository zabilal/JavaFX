package ph.txtdis.model;

import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import ph.txtdis.type.UomType;

@Entity
public class StockTakeDetail extends AbstractAudited {

    private static final long serialVersionUID = 4692138441515885681L;

    @ManyToOne(optional = false, cascade = CascadeType.REFRESH)
    private StockTake stockTake;

    @ManyToOne(optional = false, cascade = CascadeType.REFRESH)
    private Item item;

    @Transient
    private Integer itemId;

    @Transient
    private String itemName;

    @Transient
    private String itemDescription;

    @Column(nullable = false)
    private UomType uom;

    @Column(nullable = false, precision = 10, scale = 4)
    private BigDecimal qty;

    @ManyToOne(optional = false, cascade = CascadeType.REFRESH)
    private Quality quality;

    protected StockTakeDetail() {
    }

    public StockTakeDetail(StockTake stockTake, Item item, UomType uom, BigDecimal qty, Quality quality) {
        this.stockTake = stockTake;
        this.item = item;
        this.uom = uom;
        this.qty = qty;
        this.quality = quality;
    }

    public StockTake getStockTake() {
        return stockTake;
    }

    public void setStockTake(StockTake stockTake) {
        this.stockTake = stockTake;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Integer getItemId() {
        return item.getId();
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return item.getName();
    }

    public String getItemDescription() {
        return item.getDescription();
    }

    public UomType getUom() {
        return uom;
    }

    public void setUom(UomType uom) {
        this.uom = uom;
    }

    public BigDecimal getQty() {
        return qty;
    }

    public void setQty(BigDecimal qty) {
        this.qty = qty;
    }

    public Quality getQuality() {
        return quality;
    }

    public void setQuality(Quality quality) {
        this.quality = quality;
    }

    @Override
    public String toString() {
        return stockTake + ": " + qty + uom + " " + quality + " " + item;
    }
}
