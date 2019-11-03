package com.example.appandcomponents.book;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static java.util.Collections.singletonList;
import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class BookControllerTest {
    private MockMvc mockMvc;
    private StubBooksRepository stubBooksRepository;

    @Before
    public void setUp() throws Exception {
        stubBooksRepository = new StubBooksRepository();
        BookController bookController = new BookController(stubBooksRepository);

        mockMvc = MockMvcBuilders
                .standaloneSetup(bookController)
                .build();
    }

    @Test
    public void test_getBooksController_returnsOkHttpStatus_dynamic() throws Exception {
        mockMvc.perform(get("/api/books"))
                .andExpect(status().isOk());
    }

    @Test
    public void test_getBooksController_returnsASingleBook_dynamic() throws Exception {
        stubBooksRepository.setGetAll_returnValue(
                singletonList(new Book("Clean Code", "Robert Martin"))
        );

        mockMvc.perform(get("/api/books"))
                .andExpect(jsonPath("$[0].name", equalTo("Clean Code")))
                .andExpect(jsonPath("$[0].author", equalTo("Robert Martin")))
        ;
    }
}
