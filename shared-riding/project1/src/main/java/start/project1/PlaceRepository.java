package start.project1;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface PlaceRepository extends CrudRepository<Place, String> {

}
