package com.masterfood.masterfoodapi.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.masterfood.masterfoodapi.domain.enums.PerfilType;
import com.masterfood.masterfoodapi.domain.restaurant.Restaurant;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {

    private static final long serialVersionUID = -8591051811033255610L;

    public void addPerfil(PerfilType perfil) {
        if (perfis == null) {
            perfis = new HashSet<>();
        }
        perfis.add(perfil);
    }

    @Id
    private String id;
    @Indexed
    private String name;
    private String email;
    @JsonIgnore
    private String password;
    private Set<PerfilType> perfis;
    @DBRef
    private Restaurant restaurant;

}
