package platform.codingnomads.co.lab;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import platform.codingnomads.co.TestUtil;
import platform.codingnomads.co.springtest.lab.SpringTestLab;
import platform.codingnomads.co.springtest.lab.entity.Movie;
import platform.codingnomads.co.springtest.lab.repository.MovieRepository;
import platform.codingnomads.co.springtest.lab.service.MovieService;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.hamcrest.core.StringContains.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.junit.Assert.*;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(classes = SpringTestLab.class)
@AutoConfigureMockMvc
public class MovieControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    MovieRepository movieRepository;


    MovieService movieService;

    @Test
    @Order(3)
    public void testGetAllMoviesSuccess() throws Exception {

        mockMvc.perform(get("/movies/all"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(jsonPath("$",hasSize(2)))
                .andExpect(jsonPath("$[0].name").value("The Shawshank Redemption"))
                .andExpect(jsonPath("$[1].name").value("The Pursuit of Happyness"));
    }

    @Test
    @Order(11)
    public void testGetAllMoviesFailure() throws Exception {

         movieRepository.deleteAll();


         this.mockMvc.perform(get("/movies/all"))
                 .andDo(print())
                 .andExpect(status().isOk())
                 .andExpect(jsonPath("$",hasSize(0)));


    }


    @Test
    public void testGetAllMoviesSuccessMockService() throws Exception {

        List<Movie> movies =  Arrays.asList(

                Movie.builder().name("Matrix").rating(8.9).build(),

                Movie.builder().name("12 Angry Men").rating(7.8).build());

        when(movieService.getAllMovies())
                .thenReturn(movies);

        mockMvc.perform(get("/movies/all"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(content().string(TestUtil.convertObjectToJsonString(movies)));
    }

    @Test
    public void testGetAllMoviesWithNonJsonPath() throws Exception{

        MvcResult mvcResult = this.mockMvc.perform(get("/movies/all"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();


        byte[] jsonByteArray = mvcResult.getResponse().getContentAsByteArray();
        Movie [] returnedMovies = TestUtil.convertJsonBytesToObject(jsonByteArray,Movie[].class);

        assertThat(returnedMovies.length, is(2));

        for(Movie r: returnedMovies) {
            //confirm none of the recipes are null
            assertThat(r, notNullValue());
            //confirm they all have IDs
            assertThat(r.getId(), notNullValue());
            //confirm they all contain recipe in the name
            assertThat(r.getName(), containsString("The"));
        }

    }


    @Test
    public void testGetAllMoviesWithMinimumRating() throws Exception{

        this.mockMvc.perform(get("/movies/{rating}", 7))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$",hasSize(2)))
                .andExpect(jsonPath("$[0].name").value("The Shawshank Redemption"))
                .andExpect(jsonPath("$[0].rating").value(9.3));
    }

    @Test
    public void testFailureGetAllMoviesWithMinimumRating() throws Exception{

        this.mockMvc.perform(get("/all/movies/{rating}", 25))
                .andExpect(status().isNotFound());

    }




}
