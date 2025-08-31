package com.fiap.lojaDeBrinquedos.model;

import com.fiap.lojaDeBrinquedos.controller.BrinquedoController;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class BrinquedoAssembler extends RepresentationModelAssemblerSupport<Brinquedo, EntityModel<Brinquedo>> {

    public BrinquedoAssembler() {
        super(BrinquedoAssembler.class, (Class<EntityModel<Brinquedo>>)(Class<?>)EntityModel.class);
    }


    @Override
    public EntityModel<Brinquedo> toModel(Brinquedo brinquedo) {
        EntityModel<Brinquedo> usuarioModel = EntityModel.of(brinquedo,
                linkTo(methodOn(BrinquedoController.class).buscarPorId(brinquedo.getId())).withSelfRel(),
                linkTo(methodOn(BrinquedoController.class).listar()).withRel("brinquedos"));

        return usuarioModel;
    }
}
