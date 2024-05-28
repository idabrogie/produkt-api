package com.example.produktapi.controller;

import com.example.produktapi.model.Product;
import com.example.produktapi.service.ProductService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import java.util.Locale;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;



@SpringBootTest
class ProductControllerTest {

    private MockMvc mockMvc;

    @InjectMocks
    private ProductController productController;

    @Mock
    private ProductService productService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(productController)
                .build();
    }



    @Test
    void hello() throws Exception {
        mockMvc.perform(get("/my-endpoint"))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello, world!"));

    }

    @Test
    void testGetProductById_Exists() throws Exception {
        Integer productId = 1;
        Product mockProduct = createMockProduct(productId);

        when(productService.getProductById(productId)).thenReturn(mockProduct);

        String expectedJson = getExpectedProductJson(mockProduct);
        System.out.println("Expected JSON: " + expectedJson);

        mockMvc.perform(get("/products/{id}", productId)
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("utf-8"))
                .andDo(print()) // Print the request and response details
                .andExpect(status().isOk());

        Assertions.assertEquals(1, mockProduct.getId());
    }

    @Test
    void testGetProductById_NotExists() throws Exception {
        Integer productId = 2;
        Product mockProduct = createMockProduct(productId);

        when(productService.getProductById(productId)).thenReturn(mockProduct);

        String expectedJson = getExpectedProductJson(mockProduct);
        System.out.println("Expected JSON: " + expectedJson);

        mockMvc.perform(get("/products/{id}", productId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .characterEncoding("utf-8"))
                .andDo(print()) // Print the request and response details
                .andExpect(status().isOk());

        Assertions.assertNotEquals(1, mockProduct.getId());
    }

    private Product createMockProduct(Integer productId) {
        Product product = new Product();
        product.setId(productId);
        product.setTitle("Test Product");
        product.setPrice(100.0);
        product.setCategory("Test Category");
        product.setDescription("Test Description");
        product.setImage("test_image.png");
        return product;
    }

    private String getExpectedProductJson(Product product) {
        return String.format(Locale.US,"{\"id\":%d,\"title\":\"%s\",\"price\":%.2f,\"category\":\"%s\",\"description\":\"%s\",\"image\":\"%s\"}",
                product.getId(), product.getTitle(), product.getPrice(), product.getCategory(), product.getDescription(), product.getImage());
    }
}
