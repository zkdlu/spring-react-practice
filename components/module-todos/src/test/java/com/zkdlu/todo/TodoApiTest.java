package com.zkdlu.todo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class TodoApiTest {

    private MockMvc mockMvc;
    private TodoService spyTodoService;

    @BeforeEach
    void setUp() {
        spyTodoService = mock(TodoService.class);

        mockMvc = MockMvcBuilders.standaloneSetup(new TodoApi(spyTodoService)).build();
    }

    @Test
    void getTodos_returnsOkHttpStatus() throws Exception {
        mockMvc.perform(get("/todos"))
                .andExpect(status().isOk());
    }

    @Test
    void getTodos_returnsTodos() throws Exception {
        given(spyTodoService.getTodos()).willReturn(List.of(
                new Todo(1, "content", true)
        ));

        mockMvc.perform(get("/todos"))
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].id", equalTo(1)))
                .andExpect(jsonPath("$[0].content", equalTo("content")))
                .andExpect(jsonPath("$[0].complete", equalTo(true)))
        ;
    }

    @Test
    void createTodo_returnsCreatedHttpStatus() throws Exception {
        mockMvc.perform(post("/todos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{}"))
                .andExpect(status().isCreated());
    }

    @Test
    void createTodo_passesDataToService() throws Exception {
        mockMvc.perform(post("/todos")
                .contentType(MediaType.APPLICATION_JSON)
                .content("""
                        {
                            "content": "content 1"
                        }
                        """));

        ArgumentCaptor<TodoRequest> todoRequestArgumentCaptor = ArgumentCaptor.forClass(TodoRequest.class);
        verify(spyTodoService, times(1)).createTodo(todoRequestArgumentCaptor.capture());
    }

    @Test
    void updateTodo_returnsOkHttpStatus() throws Exception {
        mockMvc.perform(patch("/todos/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{}"))
                .andExpect(status().isOk());
    }

    @Test
    void updateTodo_passesDataToService() throws Exception {
        mockMvc.perform(patch("/todos/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                {
                                    "complete": true
                                }
                                """));

        ArgumentCaptor<Long> longArgumentCaptor = ArgumentCaptor.forClass(Long.class);
        ArgumentCaptor<Boolean> booleanArgumentCaptor = ArgumentCaptor.forClass(Boolean.class);

        verify(spyTodoService, times(1))
                .updateTodo(
                        longArgumentCaptor.capture(),
                        booleanArgumentCaptor.capture());
    }

    @Test
    void deleteTodo_returnsOkHttpStatus() throws Exception {
        mockMvc.perform(delete("/todos/1"))
                .andExpect(status().isOk());
    }

    @Test
    void deleteTodo_passesDataToService() throws Exception {
        mockMvc.perform(delete("/todos/1"));

        ArgumentCaptor<Long> longArgumentCaptor = ArgumentCaptor.forClass(Long.class);
        verify(spyTodoService, times(1))
                .deleteTodo(longArgumentCaptor.capture());
    }
}