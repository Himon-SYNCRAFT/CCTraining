package pl.eltrox.core.entities;

/**
 * @author Daniel Zawlocki
 * @date 2018/02/19
 */
public class Article {
    private Long id;
    private String name;
    private String sku;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }
}
