package JAXB.model;

import jakarta.xml.bind.annotation.*;
import java.util.List;
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class Catalog {

    private String catalogNo;
    private String catalogName;
    private String location;

    @XmlElementWrapper(name = "animals")
    @XmlElement(name = "animal")
    private List<Animal> animals;

    /**
     * This default constructor is required if there are other constructors.
     */
    public Catalog() {

    }

    public Catalog(String catalogNo, String catalogName, String location) {
        this.catalogNo = catalogNo;
        this.catalogName = catalogName;
        this.location = location;
    }

    public String getCatalogNo() {
        return catalogNo;
    }

    public void setCatalogNo(String catalogNo) {
        this.catalogNo = catalogNo;
    }

    public String getCatalogName() {
        return catalogName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(List<Animal> animals) {
        this.animals = animals;
    }

}
