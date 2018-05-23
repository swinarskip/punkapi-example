package app.entity;

import com.google.gson.annotations.SerializedName;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Beer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;

    private String tagline;

    @SerializedName("first_brewed")
    private String firstBrewed;

    @Lob
    private String description;

    @SerializedName("image_url")
    private String imageUrl;

    private float ibu;

    @ElementCollection
    @SerializedName("food_pairing")
    private Collection<String> foodPairing;

    public Beer() {
        // Empty constructor for Hibernate
    }

    public Beer(String name, String tagline, String firstBrewed, String description, String imageUrl, float ibu, Collection<String> foodPairing) {
        this.name = name;
        this.tagline = tagline;
        this.firstBrewed = firstBrewed;
        this.description = description;
        this.imageUrl = imageUrl;
        this.ibu = ibu;
        this.foodPairing = foodPairing;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTagline() {
        return tagline;
    }

    public void setTagline(String tagline) {
        this.tagline = tagline;
    }

    public String getFirstBrewed() {
        return firstBrewed;
    }

    public void setFirstBrewed(String firstBrewed) {
        this.firstBrewed = firstBrewed;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public float getIbu() {
        return ibu;
    }

    public void setIbu(float ibu) {
        this.ibu = ibu;
    }

    public Collection<String> getFoodPairing() {
        return foodPairing;
    }

    public void setFoodPairing(Collection<String> foodPairing) {
        this.foodPairing = foodPairing;
    }
}