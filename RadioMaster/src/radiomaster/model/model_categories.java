/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package radiomaster.model;

/**
 *
 * @author Ema
 */
public class model_categories {
    
    private int id;
    private String title;
    private String description;
    private date_time created_at;
    private date_time updated_at;
    private String slug;
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public date_time getCreated_at() {
        return created_at;
    }

    public void setCreated_at(date_time created_at) {
        this.created_at = created_at;
    }

    public date_time getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(date_time updated_at) {
        this.updated_at = updated_at;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }
    
    @Override
    public String toString() {
        return getTitle(); //To change body of generated methods, choose Tools | Templates.
    }

    
    
    
}
