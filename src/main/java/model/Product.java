package model;
import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;


/**
 * Created by Mala on 4/12/2017.
 */

@Entity
@Table(name = "products")
public class Product {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name ="price")
    private int price;

    @Column(name = "description")
    private String description;

    @Column(name = "producer")
    private String producer;

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", producer='" + producer + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public void setValue(String name, String value) {
        switch (name){
            case "name": setName(value); break;
            case "price": setPrice(Integer.parseInt(value)); break;
            case "description": setDescription(value); break;
            case "id": setId(Integer.parseInt(value)); break;
            case "producer": setProducer(value); break;
        }
    }
}
