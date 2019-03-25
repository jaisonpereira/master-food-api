package com.masterfood.masterfoodapi.controllers;

import com.masterfood.masterfoodapi.domain.dto.MenuDto;
import com.masterfood.masterfoodapi.services.MenuService;
import com.wirelabs.common.BaseControllerWeb;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/menu")
public class MenuController extends BaseControllerWeb {

    private MenuService service;

    @Autowired
    public MenuController(MenuService service) {
        this.service = service;
    }

    @ApiOperation(value = "Get Menu by id restaurant")
    @ApiResponse(code = 404, message = "Menu not found")
    @GetMapping(value = "/{id}")
    public ResponseEntity<MenuDto> findById(@PathVariable String id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PreAuthorize("hasAnyRole(" + GROUP_ADMIN + ")")
    @ApiOperation(value = "save menu to restaurant")
    @ApiResponse(code = 404, message = "Restaurant not found")
    @PostMapping(value = "/{id}")
    public ResponseEntity<Void> save(@Valid @RequestBody MenuDto dto, @PathVariable String id) {
        service.save(dto, id);
        return ResponseEntity.noContent()
                .build();
    }

}
