package ksy.errorproj.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import ksy.errorproj.domain.Order;
import ksy.errorproj.service.OrderService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.mockito.BDDMockito.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;


@ExtendWith(SpringExtension.class)
@WebMvcTest(OrderRestController.class)
class OrderRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private OrderService orderService;

    @Test
    void findByOrderId() throws Exception {
        given(orderService.findByOrderId(any()))
                .willReturn(Order.builder()
                                       .id("232")
                                       .name("11").build()
                            );


        mockMvc.perform(get("/order/3"))
                .andDo(print());
    }

    @Test
    void insert() throws Exception {

        String data = objectMapper.writeValueAsString(Order.builder().id("1122").name("1111").build());

        ResultActions actions = mockMvc.perform(post("/order")
                .content(data)
                .contentType(MediaType.APPLICATION_JSON)
        ).andDo(print());


        actions.andExpect(jsonPath("code").value(400));

    }
}