package com.masterfood.masterfoodapi.domain;

import com.masterfood.masterfoodapi.domain.enums.CategoryType;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Document
@Data
@AllArgsConstructor
public class Category implements Serializable {

    private static final long serialVersionUID = -555849179487885922L;

    @Id
    private String id;
    private String name;
    private CategoryType categoryType;
    private String descricao;

}
