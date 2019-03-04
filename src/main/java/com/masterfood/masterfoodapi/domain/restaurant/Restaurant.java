package com.masterfood.masterfoodapi.domain.restaurant;

import com.masterfood.masterfoodapi.domain.Address;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.List;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Restaurant implements Serializable {

    private static final long serialVersionUID = 5226996471611433328L;

    @Id
    private String id;
    @Indexed
    private String name;
    @Indexed
    private Address address;
    private String email;
    private String describe;
    private Double timeEstimate;
    private Float priceMinimum;
    private Float rating;
    private List<Category> menu;

}
