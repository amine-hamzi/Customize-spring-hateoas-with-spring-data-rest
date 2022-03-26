package org.sid.demospringdatarest.controllers;

import org.sid.demospringdatarest.model.Client;
import org.sid.demospringdatarest.repositories.ClientRepository;
import org.sid.demospringdatarest.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.BasePathAwareController;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resources;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RepositoryRestController
public class ClientController {

    @Autowired
    private ClientService clientService;

    @Autowired
    private ClientRepository clientRepository;

    @GetMapping("clients/salaireAnnuel/{id}")
    public ResponseEntity<Double> salaireAnnuel(@PathVariable Long id){
        Client client = clientRepository.getById(id);
        double salaireAnnuel = clientService.salaireAnnuel(client.getSalaire());
        return  ResponseEntity.ok(salaireAnnuel);
    }

    /*@RequestMapping(method = RequestMethod.GET, value = "/clients/{id}")
    public ResponseEntity<?> getClient(@PathVariable Long id) {
        Optional<Client> client = clientRepository.findById(id);
        // add other links as needed
        Link link = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ClientController.class).salaireAnnuel(id)).withRel("salaireAnnuel");
        client.get().add(link);
        link = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ClientController.class).getClient(id)).withSelfRel();
        client.get().add(link);
        EntityModel<Client> model = EntityModel.of(client.get());
        return ResponseEntity.ok(model);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/clients")
    public ResponseEntity<?> getClients() {
        List<Client> clients = clientRepository.findAll();
        // add other links as needed
        clients.forEach(client -> {
            Link link = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ClientController.class).salaireAnnuel(client.getId())).withRel("salaireAnnuel");
            client.add(link);
            link = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ClientController.class).getClient(client.getId())).withSelfRel();
            client.add(link);
        });
        CollectionModel<Client> model = CollectionModel.of(clients);
        Link link = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ClientController.class).getClients()).withSelfRel();
        model.add(link);
        return ResponseEntity.ok(model);
    }*/



}
