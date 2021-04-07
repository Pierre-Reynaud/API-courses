package fr.pr.coursesrapides.coursesrapides;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import fr.pr.coursesrapides.coursesrapides.web.controller.CategorieController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(controllers = CategorieController.class)
public class NewCategorie {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CategorieController categorieController;

    @Test
    public void testGetCategorie() throws Exception {
        mockMvc.perform(get("/Categories"))
                .andExpect(status().isOk());
                //.andExpect(jsonPath("$[0].libelle", is("Fruit")));
    }

    @Test
    public void testetCategorie() throws Exception {
        mockMvc.perform(get("/Categories"))
                .andExpect(jsonPath("$.lenght()", is(5)));
    }
}
