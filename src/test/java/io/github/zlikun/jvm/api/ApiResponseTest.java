package io.github.zlikun.jvm.api;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author zlikun
 * @since 2023/9/13
 */
class ApiResponseTest {


    @Test
    void usage() {

        {
            ApiResponse<String> res = ApiResponse.of("20001", "随便定义的响应码", "Ashe");
            assertFalse(res.successful());
            assertEquals("20001", res.getCode());
            assertEquals("随便定义的响应码", res.getMessage());
            assertEquals("Ashe", res.getBody());
        }

        {
            ApiResponse<String> res = ApiResponse.success("Ashe");
            assertEquals("Ashe", res.getBody());
        }

        {
            ApiResponse<?> res = ApiResponse.empty("30001", "手机号不能为空");
            assertFalse(res.successful());
            assertEquals("30001", res.getCode());
            assertNull(res.getBody());
        }

        {
            ApiResponse<?> res = ApiResponse.success();
            assertTrue(res.successful());
            assertNull(res.getBody());
        }

    }

}