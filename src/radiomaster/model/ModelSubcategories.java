/**
 * Model SubCategories
 * 
* This model class represents the SubCategories object and also have logic to
 * update controller if its data changes.
 * 
* @author Ema Božić
 * @version 1.0
 * 
* Jul 8, 2016
 * 
* This code and information is provided "as is" without warranty of any kind,
 * either expressed or implied, including but not limited to the implied
 * warranties of merchantability and/or fitness for a particular purpose.
 * 
* Copyright (c) Gauss d.o.o. All rights reserved
 */
package radiomaster.model;

public class ModelSubcategories {

    //region CLASS PARAMETERS

    private int id;
    private int parent_id;
    private String title;
    private String description;
    private ModelDateTime created_at;
    private ModelDateTime updated_at;
    private String slug;

    //endregion
    //region GETTERS AND SETTERS
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getParent_id() {
        return parent_id;
    }

    public void setParent_id(int parent_id) {
        this.parent_id = parent_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ModelDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(ModelDateTime created_at) {
        this.created_at = created_at;
    }

    public ModelDateTime getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(ModelDateTime updated_at) {
        this.updated_at = updated_at;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    //endregion 
    //region CUSTOM METHOD
    /**
     * * This method overrides toString method
     *
     * @return Title
     */
    @Override
    public String toString() {
        return getTitle(); //To change body of generated methods, choose Tools | Templates.
    }
    //endregion

}
