package eu.solidcraft.starter.examples.example1
import base.MvcIntegrationTest
import org.junit.Test
import org.springframework.http.MediaType

import static org.hamcrest.Matchers.equalTo
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*

public class SomeControllerMvcIntegrationTest extends MvcIntegrationTest {

    @Test
    public void shouldRedirectAfterAdd() {
        mockMvc.perform(get('/some/add').
                param('amount', "100").
                accept(MediaType.TEXT_HTML)).
                andExpect(status().isFound()).
                andExpect(redirectedUrl("/some/mine"));
    }

    @Test
    public void shouldGetMine() {
        mockMvc.perform(get('/some/mine').
                accept(MediaType.TEXT_HTML)).
                andExpect(status().isOk()).
                andExpect(model().attributeExists("entities"));
    }

    @Test
    public void shouldGetMineInJson() {
        //given
        mockMvc.perform(get('/some/add').
                param('amount', "100").
                accept(MediaType.TEXT_HTML))

        //when then
        mockMvc.perform(get('/some/mine.json').
                accept(MediaType.APPLICATION_JSON)).
                andExpect(status().isOk()).
                andExpect(model().attributeExists("entities")).
                andExpect(jsonPath('$.entities[0].someAmount').value(equalTo(100)))
    }
}
