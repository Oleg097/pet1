package com.example.pet_project.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
    private String bind_printer_ids;

    public Cartrige() {
    }

    public Cartrige(String vendor, String article, String description,
                    String technology, String color, String bind_printer_ids)
    {

        this.vendor = vendor;
        this.article = article;
        this.description = description;
        this.technology = technology;
        this.color = color;
        this.bind_printer_ids = bind_printer_ids;
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

    public String getBind_printer_ids() {
        return bind_printer_ids;
    }

    public void setBind_printer_ids(String bind_printer_ids) {
        this.bind_printer_ids = bind_printer_ids;
    }
}
