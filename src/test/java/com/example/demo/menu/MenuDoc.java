package com.example.demo.menu;

import com.example.demo.DemoApplication;
import com.example.demo.dto.MenuDTO;
import com.example.demo.entity.Menu;
import com.example.demo.entity.MenuOptionEnum;
import com.example.demo.entity.Orders;
import com.example.demo.entity.OrdersDetail;
import com.example.demo.repository.OrdersDetailRepository;
import com.example.demo.repository.OrdersRepository;
import com.example.demo.service.MenuService;
import com.example.demo.service.OrderService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.restdocs.RestDocumentationContextProvider;
import org.springframework.restdocs.RestDocumentationExtension;
import org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders;
import org.springframework.restdocs.payload.JsonFieldType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.persistence.EntityManager;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.*;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;
import static org.springframework.restdocs.request.RequestDocumentation.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith({RestDocumentationExtension.class, SpringExtension.class})
@SpringBootTest(classes = DemoApplication.class)
@AutoConfigureMockMvc
@DisplayName("Menu Rest Doc ??????")
public class MenuDoc {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private OrderService orderService;

    @Autowired
    private MenuService menuService;

    @Autowired
    private OrdersRepository ordersRepository;

    @Autowired
    private OrdersDetailRepository ordersDetailRepository;

    @Autowired
    WebApplicationContext context;

    @Autowired
    EntityManager em;

    @BeforeEach
    public void setUpURI(RestDocumentationContextProvider restDocumentationContextProvider){
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context)
                .apply(documentationConfiguration(restDocumentationContextProvider)
                        .operationPreprocessors()
                        .withRequestDefaults(prettyPrint())
                        .withResponseDefaults(prettyPrint())
                        .and()
                        .uris()
                        .withHost("kkstest.com")
                        .withPort(80)
                )
                .build();
    }

    @BeforeEach
    public void setDocData(){
        String menuname = "???????????????";
        int price = 1500;
        Menu menu = new Menu(menuname, price);
        menuService.save(menu);
        menuname = "??????";
        price = 2500;
        Menu menu1 = new Menu(menuname, price);
        menuService.save(menu1);

        menuname = "??????";
        price = 2500;
        Menu menu2 = new Menu(menuname, price);
        menuService.save(menu2);

        Orders order = new Orders(4000, 2);
        OrdersDetail ordersDetail = new OrdersDetail(1500, 1, menu);
        OrdersDetail ordersDetail2 = new OrdersDetail(2500, 2, menu);
        order.addOrdersDetails(ordersDetail);
        order.addOrdersDetails(ordersDetail2);
        ordersRepository.save(order);

        Orders order1 = new Orders(4000, 2);
        OrdersDetail ordersDetail3 = new OrdersDetail(1500, 1, menu1);
        OrdersDetail ordersDetail4 = new OrdersDetail(2500, 2, menu1);
        order1.addOrdersDetails(ordersDetail3);
        order1.addOrdersDetails(ordersDetail4);
        ordersRepository.save(order1);

        Orders order2 = new Orders(4000, 2);
        OrdersDetail ordersDetail5 = new OrdersDetail(1500, 1, menu);
        OrdersDetail ordersDetail6 = new OrdersDetail(2500, 2, menu);
        order2.addOrdersDetails(ordersDetail5);
        order2.addOrdersDetails(ordersDetail6);
        ordersRepository.save(order2);

        Orders order3 = new Orders(4000, 1);
        OrdersDetail ordersDetail7 = new OrdersDetail(1500, 1, menu);
        order3.addOrdersDetails(ordersDetail7);
        ordersRepository.save(order3);

        Orders order4 = new Orders(4000, 1);
        OrdersDetail ordersDetail8 = new OrdersDetail(1500, 1, menu);
        order4.addOrdersDetails(ordersDetail8);
        ordersRepository.save(order4);

        Orders order5 = new Orders(4000, 1);
        OrdersDetail ordersDetail9 = new OrdersDetail(1500, 1, menu);
        order5.addOrdersDetails(ordersDetail9);
        ordersRepository.save(order5);

        Orders order6 = new Orders(4000, 1);
        OrdersDetail ordersDetail10 = new OrdersDetail(1500, 1, menu);
        order6.addOrdersDetails(ordersDetail10);
        ordersRepository.save(order6);


        Orders order7 = new Orders(4000, 1);
        OrdersDetail ordersDetail11 = new OrdersDetail(1500, 1, menu);
        order7.addOrdersDetails(ordersDetail11);
        ordersRepository.save(order7);

        Orders order8 = new Orders(4000, 1);
        OrdersDetail ordersDetail12 = new OrdersDetail(1500, 1, menu);
        order8.addOrdersDetails(ordersDetail12);
        ordersRepository.save(order8);

        Orders order9 = new Orders(4000, 1);
        OrdersDetail ordersDetail13 = new OrdersDetail(1500, 1, menu);
        order9.addOrdersDetails(ordersDetail13);
        ordersRepository.save(order9);


        Orders order10 = new Orders(4000, 1);
        OrdersDetail ordersDetail14 = new OrdersDetail(1500, 1, menu);
        order10.addOrdersDetails(ordersDetail14);
        ordersRepository.save(order10);

        Orders order11 = new Orders(4000, 1);
        OrdersDetail ordersDetail15 = new OrdersDetail(1500, 1, menu);
        order11.addOrdersDetails(ordersDetail15);
        ordersRepository.save(order11);

        Orders order12 = new Orders(4000, 1);
        OrdersDetail ordersDetail16 = new OrdersDetail(1500, 1, menu);
        order11.addOrdersDetails(ordersDetail16);
        ordersRepository.save(order11);

        Orders order13 = new Orders(4000, 1);
        OrdersDetail ordersDetail17 = new OrdersDetail(1500, 1, menu);
        order11.addOrdersDetails(ordersDetail17);
        ordersRepository.save(order11);
    }

    @Test
    @DisplayName("??????????????????")
    public void ??????????????????(){
        try {
            Long id = 1L;
            mockMvc.perform(RestDocumentationRequestBuilders.get("/api/menu/{id}", id)
                    )
                    .andDo(print())
                    .andExpect(status().isOk())
                    .andDo(document("menu-get"
                            , preprocessRequest(prettyPrint())
                            , preprocessResponse(prettyPrint())
                            , pathParameters(
                                    parameterWithName("id").description("?????? ?????????(KEY)")
                            )
                            ,responseFields(
                                    fieldWithPath("message").type(JsonFieldType.STRING).description("?????? ?????????(??????,??????,?????????)")
                                    , fieldWithPath("status").type(JsonFieldType.NUMBER).description("?????? ??????")
                                    , fieldWithPath("data.id")
                                            .type(JsonFieldType.NUMBER).description("?????? ?????????(KEY)")
                                    , fieldWithPath("data.menuName")
                                            .type(JsonFieldType.STRING).description("?????????")
                                    , fieldWithPath("data.price")
                                            .type(JsonFieldType.NUMBER).description("?????? ??????")
                                    , fieldWithPath("data.option")
                                            .type(JsonFieldType.STRING).description("?????? ????????????").optional()
                                    , fieldWithPath("data.useYn")
                                            .type(JsonFieldType.BOOLEAN).description("????????????(true/false)")
                            )
                    ));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    @DisplayName("??????????????????")
    public void ??????????????????(){
        try {
            mockMvc.perform(RestDocumentationRequestBuilders.get("/api/menu")
                            .param("page", "0")
                            .param("size", "4")
                            .param("sort", "createdDate,asc")
                    )
                    .andDo(print())
                    .andExpect(status().isOk())
                    .andDo(document("menu-getAll"
                            , preprocessRequest(prettyPrint())
                            , preprocessResponse(prettyPrint())
                            , requestParameters(
                                    parameterWithName("page").description("page")
                                    , parameterWithName("size").description("size")
                                    , parameterWithName("sort").description("????????????")
                            )
                            ,responseFields(
                                    fieldWithPath("message").type(JsonFieldType.STRING).description("?????? ?????????(??????,??????,?????????)")
                                    , fieldWithPath("status").type(JsonFieldType.NUMBER).description("?????? ??????")
                                    , fieldWithPath("data.totalPage").type(JsonFieldType.NUMBER).description("?????? ????????????")
                                    , fieldWithPath("data.totalCount").type(JsonFieldType.NUMBER).description("?????? ????????????")
                                    , fieldWithPath("data.count").type(JsonFieldType.NUMBER).description("????????????")
                                    , fieldWithPath("data.list.[].id")
                                            .type(JsonFieldType.NUMBER).description("?????? ?????????(KEY)")
                                    , fieldWithPath("data.list.[].menuName")
                                            .type(JsonFieldType.STRING).description("?????????")
                                    , fieldWithPath("data.list.[].price")
                                            .type(JsonFieldType.NUMBER).description("?????? ??????")
                                    , fieldWithPath("data.list.[].option")
                                            .type(JsonFieldType.STRING).description("?????? ????????????").optional()
                                    , fieldWithPath("data.list.[].useYn")
                                            .type(JsonFieldType.BOOLEAN).description("????????????(true/false)")
                            )
                    ));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    @DisplayName("????????????")
    public void ????????????(){
        try {

            //given
            MenuDTO menuDTO = new MenuDTO();
            menuDTO.setMenuName("?????????");
            menuDTO.setPrice(4000);
            menuDTO.setOption(MenuOptionEnum.NONE);

            mockMvc.perform(RestDocumentationRequestBuilders.post("/api/menu")
                            .contentType(MediaType.APPLICATION_JSON)
                            .characterEncoding("UTF-8")
                            .accept(MediaType.APPLICATION_JSON)
                            .content(objectMapper.writeValueAsString(menuDTO))
                    )
                    .andDo(print())
                    .andExpect(status().is2xxSuccessful())
                    .andDo(document("menu-create"
                            , preprocessRequest(prettyPrint())
                            , preprocessResponse(prettyPrint())
                            , requestFields(
                                    fieldWithPath("menuName").description("?????????")
                                            .type(JsonFieldType.STRING)
                                    , fieldWithPath("price").description("?????? ??????")
                                            .type(JsonFieldType.NUMBER)
                                    , fieldWithPath("option").description("??????(OPTION ENUM)")
                                            .type(JsonFieldType.STRING)
                            )
                            ,responseFields(
                                    fieldWithPath("message").type(JsonFieldType.STRING).description("?????? ?????????(??????,??????,?????????)")
                                    , fieldWithPath("status").type(JsonFieldType.NUMBER).description("?????? ??????")
                                    , fieldWithPath("data.id")
                                            .type(JsonFieldType.NUMBER).description("?????? ?????????(KEY)")
                                    , fieldWithPath("data.menuName")
                                            .type(JsonFieldType.STRING).description("?????????")
                                    , fieldWithPath("data.price")
                                            .type(JsonFieldType.NUMBER).description("?????? ??????")
                                    , fieldWithPath("data.option")
                                            .type(JsonFieldType.STRING).description("?????? ????????????").optional()
                                    , fieldWithPath("data.useYn")
                                            .type(JsonFieldType.BOOLEAN).description("????????????(true/false)")
                            )
                    ));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    @DisplayName("????????????")
    public void ????????????(){
        try {
            //given
            MenuDTO menuDTO = new MenuDTO();
            menuDTO.setId(1L);
            menuDTO.setMenuName("???????????????");
            menuDTO.setPrice(3000);
            menuDTO.setOption(MenuOptionEnum.BOTH);
            menuDTO.setUseYn(true);

            mockMvc.perform(RestDocumentationRequestBuilders.patch("/api/menu")
                            .contentType(MediaType.APPLICATION_JSON)
                            .characterEncoding("UTF-8")
                            .accept(MediaType.APPLICATION_JSON)
                            .content(objectMapper.writeValueAsString(menuDTO))
                    )
                    .andDo(print())
                    .andExpect(status().is2xxSuccessful())
                    .andDo(document("menu-update"
                            , preprocessRequest(prettyPrint())
                            , preprocessResponse(prettyPrint())
                            , requestFields(
                                    fieldWithPath("id").description("?????? ?????????(KEY)")
                                            .type(JsonFieldType.NUMBER)
                                    , fieldWithPath("menuName").description("?????????")
                                            .type(JsonFieldType.STRING)
                                    , fieldWithPath("price").description("?????? ??????")
                                            .type(JsonFieldType.NUMBER)
                                    , fieldWithPath("option").description("??????(OPTION ENUM)")
                                            .type(JsonFieldType.STRING)
                                    , fieldWithPath("useYn").description("????????????(true/false)")
                                            .type(JsonFieldType.BOOLEAN)
                            )
                            ,responseFields(
                                    fieldWithPath("message").type(JsonFieldType.STRING).description("?????? ?????????(??????,??????,?????????)")
                                    , fieldWithPath("status").type(JsonFieldType.NUMBER).description("?????? ??????")
                                    , fieldWithPath("data.id")
                                            .type(JsonFieldType.NUMBER).description("?????? ?????????(KEY)")
                                    , fieldWithPath("data.menuName")
                                            .type(JsonFieldType.STRING).description("?????????")
                                    , fieldWithPath("data.price")
                                            .type(JsonFieldType.NUMBER).description("?????? ??????")
                                    , fieldWithPath("data.option")
                                            .type(JsonFieldType.STRING).description("?????? ????????????").optional()
                                    , fieldWithPath("data.useYn")
                                            .type(JsonFieldType.BOOLEAN).description("????????????(true/false)")
                            )
                    ));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    @DisplayName("????????????")
    public void ????????????(){
        try {
            //given
            Long id = 3L;
            mockMvc.perform(RestDocumentationRequestBuilders.delete("/api/menu/{id}", id)
                    )
                    .andDo(print())
                    .andExpect(status().is2xxSuccessful())
                    .andDo(document("menu-delete"
                            , preprocessRequest(prettyPrint())
                            , preprocessResponse(prettyPrint())
                            , pathParameters(
                                    parameterWithName("id").description("?????? ?????????(KEY)")
                            )
                            ,responseFields(
                                    fieldWithPath("message").type(JsonFieldType.STRING).description("?????? ?????????(??????,??????,?????????)")
                                    , fieldWithPath("status").type(JsonFieldType.NUMBER).description("?????? ??????")
                                    , fieldWithPath("data").type(JsonFieldType.OBJECT).description("?????????").optional()
                            )
                    ));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
