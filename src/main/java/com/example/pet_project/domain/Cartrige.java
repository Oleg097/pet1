package com.example.pet_project.domain;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Cartrige {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String vendor;
    private String article;
    private String description;
    private String technology;
    private String color;
    private String filename;



    @ManyToMany
    @JoinTable (name = "printer_cartrige",
            joinColumns = @JoinColumn(name = "cart_id"),
            inverseJoinColumns = @JoinColumn(name="print_id"))
    private List<Printer> printers;

    public Cartrige() {
    }

    public Cartrige(String vendor, String article, String description, String technology, String color, List<Printer> printers) {
        this.vendor = vendor;
        this.article = article;
        this.description = description;
        this.technology = technology;
        this.color = color;
        this.printers = printers;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTechnology() {
        return technology;
    }

    public void setTechnology(String technology) {
        this.technology = technology;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public List<Printer> getPrinters() {
        return printers;
    }

    public void setPrinters(List<Printer> printers) {
        this.printers = printers;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cartrige cartrige = (Cartrige) o;
        return Objects.equals(id, cartrige.id) &&
                Objects.equals(vendor, cartrige.vendor) &&
                Objects.equals(article, cartrige.article) &&
                Objects.equals(description, cartrige.description) &&
                Objects.equals(technology, cartrige.technology) &&
                Objects.equals(color, cartrige.color) &&
                Objects.equals(printers, cartrige.printers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, vendor, article, description, technology, color, printers);
    }
}

