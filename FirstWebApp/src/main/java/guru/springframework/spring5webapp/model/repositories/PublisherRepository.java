package guru.springframework.spring5webapp.model.repositories;

import guru.springframework.spring5webapp.model.Publisher;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
