package testing.mvc
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.ResultActions
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import spock.lang.Specification

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
/**
 * @author Piotrek
 */
class UserControllerSpec extends Specification {
    UserRepository repository = Mock()

    UserController userController = new UserController(repository)

    MockMvc mockMvc = MockMvcBuilders.standaloneSetup(userController).build()

    def 'should call rest controller'() {
        when:
            ResultActions result = mockMvc.perform(get('/users'))

        then:
            1 * repository.getAll() >> [new User(1, 'piotrus')]
            result.andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().string('[{"id":1,"name":"piotrus"}]'))
    }
}
