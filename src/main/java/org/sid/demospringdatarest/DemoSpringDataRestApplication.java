package org.sid.demospringdatarest;

import org.sid.demospringdatarest.controllers.ClientController;
import org.sid.demospringdatarest.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;

@SpringBootApplication
public class DemoSpringDataRestApplication implements CommandLineRunner {

    @Autowired
    private RepositoryRestConfiguration repositoryRestConfiguration;

    public static void main(String[] args) {
        SpringApplication.run(DemoSpringDataRestApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        repositoryRestConfiguration.exposeIdsFor(Client.class);
    }

    @Bean
    public RepresentationModelProcessor<EntityModel<Client>> personProcessor() {
        return new RepresentationModelProcessor<EntityModel<Client>>() {
            @Override
            public EntityModel<Client> process(EntityModel<Client> model) {
                model.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ClientController.class).salaireAnnuel(model.getContent().getId())).withRel("salaireAnnuel"));
                return model;
            }
        };
    }
}
