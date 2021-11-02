package platform.codingnomads.co.springdata.lab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import platform.codingnomads.co.springdata.lab.domain.Route;

import java.util.List;

public interface RouteRepository extends JpaRepository<Route,Long> {

    List<Route>FindByOrigin_code(String code);

    List<Route>FindByDestination_code(String code);

    Route FindByCode(String code);
}
