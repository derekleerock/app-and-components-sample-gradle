package com.example.appandcomponents.magazine;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static java.util.Collections.singletonList;
import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class MagazineControllerTest {
    private MockMvc mockMvc;
    private StubMagazineRepository stubMagazineRepository;

    @Before
    public void setUp() throws Exception {
        stubMagazineRepository = new StubMagazineRepository();
        MagazineController bookController = new MagazineController(stubMagazineRepository);

        mockMvc = MockMvcBuilders
                .standaloneSetup(bookController)
                .build();
    }

    @Test
    public void test_getBooksController_returnsOkHttpStatus_dynamic() throws Exception {
        mockMvc.perform(get("/api/magazines"))
                .andExpect(status().isOk());
    }

    @Test
    public void test_getBooksController_returnsASingleBook_dynamic() throws Exception {
        stubMagazineRepository.setGetAll_returnValue(
                singletonList(new Magazine("Modern Drummer", "December, 2019"))
        );

        mockMvc.perform(get("/api/magazines"))
                .andExpect(jsonPath("$[0].name", equalTo("Modern Drummer")))
                .andExpect(jsonPath("$[0].issue", equalTo("December, 2019")))
        ;
    }
}
