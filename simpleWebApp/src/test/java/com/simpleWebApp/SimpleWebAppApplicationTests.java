package com.simpleWebApp;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc(addFilters = false) // 🌟 啟動 MockMvc 幫我們模擬前端發請求
class SimpleWebAppApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void contextLoads() {
        // 保留這個測試，用來檢查 Spring Boot 能不能正常啟動
    }

    @Test
    void testHomePage() throws Exception {
        // 模擬對首頁 "/" 發送 GET 請求
        mockMvc.perform(get("/"))
                // 斷言 1：預期 HTTP 狀態碼要是 200 (OK)
                .andExpect(status().isOk())
                // 斷言 2：預期回傳的文字裡面應該包含 "This is the homepage"
                .andExpect(content().string(org.hamcrest.Matchers.containsString("This is the homepage")));
    }

    @Test
    void testGetProducts() throws Exception{
        mockMvc.perform(get("/products"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$").isArray());
    }
}
