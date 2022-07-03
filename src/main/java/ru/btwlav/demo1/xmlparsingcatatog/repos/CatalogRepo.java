package ru.btwlav.demo1.xmlparsingcatatog.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.btwlav.demo1.xmlparsingcatatog.models.Catalog;

public interface CatalogRepo extends JpaRepository<Catalog, Integer> {
}
