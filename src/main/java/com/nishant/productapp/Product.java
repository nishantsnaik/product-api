package com.nishant.productapp;
/*
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
*/
import java.util.UUID;


import com.fasterxml.jackson.annotation.JsonIgnore;
/*
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
*/
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import javax.validation.constraints.Size;
import java.util.UUID;

//@ApiModel(description = "Product model")
@Entity
public class Product {

    /*
     TODO update to not send id out in response beyond zuul, only with the application
     */
    @Id
    @Column(length = 36)
    @JsonIgnore
    private String id;
//    @ApiModelProperty(notes="model number")
    @Size(min = 6, max = 8, message = "must have minimum of 6 amd maximum of 8 charecters")
    @Column(length = 8, unique = true)
    private String itemCode;
    @Column(length = 20)
    private String itemCategory;
    @Column(length = 20)
    private String itemType;
    private Double price;
    @Column(length = 3)
    private String currency;
    @Column(length = 20)
    private String summary;
    @Column(length = 100)
    private String details;

    public Product(){
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getItemCategory() {
        return itemCategory;
    }

    public void setItemCategory(String itemCategory) {
        this.itemCategory = itemCategory;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", itemCode='" + itemCode + '\'' +
                ", itemCategory='" + itemCategory + '\'' +
                ", itemType='" + itemType + '\'' +
                ", price=" + price +
                ", currency='" + currency + '\'' +
                ", summary='" + summary + '\'' +
                ", details='" + details + '\'' +
                '}';
    }
}






