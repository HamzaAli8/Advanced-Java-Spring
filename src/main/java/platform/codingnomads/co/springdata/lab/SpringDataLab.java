package platform.codingnomads.co.springdata.lab;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import platform.codingnomads.co.springdata.lab.complete.domain.Area;
import platform.codingnomads.co.springdata.lab.repository.AreaRepository;
import platform.codingnomads.co.springdata.lab.repository.RouteRepository;
import platform.codingnomads.co.springdata.lab.complete.domain.Route;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
public class SpringDataLab implements CommandLineRunner {

    private final AreaRepository areaRepository;
    private final RouteRepository routeRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringDataLab.class);
    }

    @Override
    public void run(String... args) throws Exception {
        if (areaRepository.findAll().size() == 0) {
            final List<Area> areas = (
                    Arrays.asList(
                            Area.builder().code("G").build(),
                            Area.builder().code("H").build(),
                            Area.builder().code("Y").build(),
                            Area.builder().code("Z").build(),
                            Area.builder().code("M").build(),
                            Area.builder().code("L").build(),
                            Area.builder().code("N").build(),
                            Area.builder().code("P").build(),
                            Area.builder().code("X").build()
                    )
            );
            areaRepository.saveAll(areas);
        }

        if (routeRepository.findAll().size() == 0) {
            final List<Route> routes = (
                    Arrays.asList(
                           Route.builder().origin(areaRepository.findByCode("G"))
                            .destination(areaRepository.findByCode("Y")).build(),
                            Route.builder().origin(areaRepository.findByCode("P"))
                            .destination(areaRepository.findByCode("X")).build(),
                            Route.builder().origin(areaRepository.findByCode("L"))
                            .destination(areaRepository.findByCode("N")).build(),
                            Route.builder().origin(areaRepository.findByCode("H"))
                            .destination(areaRepository.findByCode("M")).build(),
                            Route.builder().origin(areaRepository.findByCode("H"))
                            .destination(areaRepository.findByCode("P")).build()
                    )

            );
            routeRepository.saveAll(routes);

        }



    }




}
