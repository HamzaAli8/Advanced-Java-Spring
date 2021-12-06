package platform.codingnomads.co.springtest.lab.service;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import platform.codingnomads.co.springtest.lab.entity.Movie;
import platform.codingnomads.co.springtest.lab.repository.MovieRepository;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
class MovieServiceTest {

    @Autowired
    private MovieService movieService;

    @MockBean
    private MovieRepository movieRepository;

    @Test
    public void TestGetAllMovies() {

        List<Movie> movieList = Arrays.asList(
                Movie.builder().name("The Shawshank Redemption").rating(9.3).build(),
                Movie.builder().name("The Pursuit of Happyness").rating(8.0).build(),
                Movie.builder().name("The Matrix").rating(7.6).build()

        );

        Mockito.when(movieRepository.findAll()).thenReturn(movieList);

        assertThat(movieService.getAllMovies()).isEqualTo(movieList);
    }

    @Test
    public void getAllMoviesByMinimumRating() {

        List<Movie> movieList = Arrays.asList(
                Movie.builder().name("The Shawshank Redemption").rating(9.3).build(),
                Movie.builder().name("The Pursuit of Happyness").rating(8.0).build(),
                Movie.builder().name("The Matrix").rating(7.6).build()

        );

        Mockito.when(movieRepository.findByRatingGreaterThanEqual(9.0)).thenReturn(movieList);

        assertThat(movieService.getAllMoviesByMinimumRating(9.0)).isEqualTo(movieList);



    }
}