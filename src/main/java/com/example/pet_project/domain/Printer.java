package com.example.pet_project.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Printer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String vendor;                           // производитель
    private String article;                          //уникальный артикул
    private String model;                            // модель
    private String technology;                       // технология печати
    private String bind_id;                          // id принтера, для поиска

    public Printer() {
    }

    public Printer(String vendor, String article, String model,
                   String technology, String bind_id)
    {
        this.vendor = vendor;
        this.article = article;
        this.model = model;
        this.technology = technology;
        this.bind_id = bind_id;
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

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getTechnology() {
        return technology;
    }

    public void setTechnology(String technology) {
        this.technology = technology;
    }

    public String getBind_id() {
        return bind_id;
    }

    public void setBind_id(String bind_id) {
        this.bind_id = bind_id;
    }
}

