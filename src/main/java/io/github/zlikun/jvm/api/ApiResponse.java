package io.github.zlikun.jvm.api;

import lombok.Data;

/**
 * @author zlikun
 * @since 2023/9/13
 */
@Data
public class ApiResponse<T> {

    private String code;
    private String message;
    private T body;

    public ApiResponse() {
    }

    public ApiResponse(String code, String message, T body) {
        this.code = code;
        this.message = message;
        this.body = body;
    }

    public static <T> ApiResponse<T> of(String code, String message, T body) {
        return new ApiResponse<>(code, message, body);
    }

    public static <T> ApiResponse<T> empty(String code, String message) {
        return of(code, message, null);
    }

    public static <T> ApiResponse<T> success(T body) {
        return of("20000", "OK", body);
    }

    public static <T> ApiResponse<T> success() {
        return empty("20000", "OK");
    }

    public boolean successful() {
        return this.code != null && this.code.equals("20000");
    }

}
