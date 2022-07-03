package ru.btwlav.demo1.xmlparsingcatatog;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.btwlav.demo1.xmlparsingcatatog.models.Catalog;
import ru.btwlav.demo1.xmlparsingcatatog.models.Plant;
import ru.btwlav.demo1.xmlparsingcatatog.repos.CatalogRepo;
import ru.btwlav.demo1.xmlparsingcatatog.repos.PlantRepo;

import java.util.List;

@SpringBootApplication
public class Application implements CommandLineRunner {

    private final CatalogRepo catalogRepo;
    private final PlantRepo plantRepo;

    public Application(CatalogRepo catalogRepo, PlantRepo plantRepo) {
        this.catalogRepo = catalogRepo;
        this.plantRepo = plantRepo;
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        catalogRepo.saveAll(List.of(
                Catalog.builder()
                        .name("catalog1")
                        .build(),
                Catalog.builder()
                        .name("catalog2")
                        .build()));
        plantRepo.saveAll(List.of(
                Plant.builder()
                        .name("plant1")
                        .catalog(catalogRepo.findById(1).get())
                        .build(),
                Plant.builder()
                        .name("plant2")
                        .catalog(catalogRepo.findById(2).get())
                        .build()));
    }
}
