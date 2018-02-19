package pl.eltrox.data.entities;

import javax.persistence.*;

/**
 * @author Daniel Zawłocki
 * @date 2018/02/19
 */

@Entity
@Table(name = "Article")
public class ArticleEntity {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String sku;

    @ManyToOne
    private CategoryEntity category;

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

    public CategoryEntity getCategory() {
        return category;
    }

    public void setCategory(CategoryEntity category) {
        this.category = category;
    }
}
