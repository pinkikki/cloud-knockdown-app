package jp.pinkikki.app.crinor;

import org.assertj.core.api.SoftAssertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CrinorControllerTest {

    @Autowired
    private MockMvc mvc;

    @WithMockUser
    @Test
    public void testIndex() throws Exception {
        MockHttpServletResponse response = mvc.perform(
                get("/crinor/index"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("")))
                .andReturn()
                .getResponse();

        SoftAssertions
                .assertSoftly(softly -> {
                    softly.assertThat(response.getHeader("Cache-Control"))
                            .isEqualTo("no-cache, no-store, max-age=0, must-revalidate");
                    softly.assertThat(response.getHeader("Pragma"))
                            .isEqualTo("no-cache");
                    softly.assertThat(response.getHeader("Expires"))
                            .isEqualTo("0");
                    softly.assertThat(response.getHeader("X-Content-Type-Options"))
                            .isEqualTo("nosniff");
                    // HTTPSのみ付与される
//                    softly.assertThat(response.getHeader("Strict-Transport-Security"))
//                            .isEqualTo("max-age=31536000 ; includeSubDomains");
                    softly.assertThat(response.getHeader("X-Frame-Options"))
                            .isEqualTo("DENY");
                    softly.assertThat(response.getHeader("X-XSS-Protection"))
                            .isEqualTo("1; mode=block");
                });
    }
}
