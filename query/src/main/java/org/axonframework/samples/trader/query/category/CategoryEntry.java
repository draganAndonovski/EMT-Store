package org.axonframework.samples.trader.query.category;

import org.springframework.data.annotation.Id;

import javax.persistence.Entity;

/**
 * Created by DELL-PC on 6/13/2016.
 */
@Entity
public class CategoryEntry {
    @Id
    @javax.persistence.Id
    private String identifier;
    private String categoryName;
    private boolean mainCategory;
    private String parentCategory;

    public String getCategoryName() { return categoryName; }

    public void setCategoryName(String categoryName) { this.categoryName = categoryName; }

    public String getIdentifier() { return identifier; }

    public void setIdentifier(String identifier) { this.identifier = identifier; }

    public boolean isMainCategory() { return mainCategory; }

    public void setMainCategory(boolean mainCategory) { this.mainCategory = mainCategory; }

    public String getParentCategory() { return parentCategory; }

    public void setParentCategory(String parentCategory) { this.parentCategory = parentCategory; }
}