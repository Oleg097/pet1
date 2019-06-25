package com.example.pet_project.domain;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Printer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String vendor;                           // производитель
    private String article;                          //уникальный артикул
    private String model;                            // модель
    private String technology;                       // технология печати


    @ManyToMany
    @JoinTable (name = "printer_cartrige",
    joinColumns = @JoinColumn(name = "print_id"),
    inverseJoinColumns = @JoinColumn(name="cart_id"))
    private List<Cartrige> cartriges;



    public Printer() {
    }

    public Printer(String vendor, String article, String model, String technology, List<Cartrige> cartriges) {
        this.vendor = vendor;
        this.article = article;
        this.model = model;
        this.technology = technology;
        this.cartriges = cartriges;
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

    public List<Cartrige> getCartriges() {
        return cartriges;
    }

    public void setCartriges(List<Cartrige> cartriges) {
        this.cartriges = cartriges;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Printer printer = (Printer) o;
        return Objects.equals(id, printer.id) &&
                Objects.equals(vendor, printer.vendor) &&
                Objects.equals(article, printer.article) &&
                Objects.equals(model, printer.model) &&
                Objects.equals(technology, printer.technology) &&
                Objects.equals(cartriges, printer.cartriges);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, vendor, article, model, technology, cartriges);
    }
}

