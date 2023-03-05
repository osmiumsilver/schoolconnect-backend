package com.osmium.schoolconnect.backend.misc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.osmium.schoolconnect.backend.utils.annotations.NotControllerResponseAdvice;
import lombok.SneakyThrows;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.util.Arrays;

/**
 * @author Abel
 * @date 2023/3/1 10:10 上午
 */
@RestControllerAdvice
public class GlobalResult implements ResponseBodyAdvice<Object> {

    private static final String[] exclude = {"Swagger2Controller", //排除Swagger API
            "Swagger2ControllerWebMvc",
            "ApiResourceController", "SwaggerConfigResource", "MultipleOpenApiWebMvcResource"};
    private final ObjectMapper objectMapper;

    public GlobalResult(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {

        return !(methodParameter.getParameterType().isAssignableFrom(Result.class))
                || (methodParameter.hasMethodAnnotation(NotControllerResponseAdvice.class));
    }

    @SneakyThrows
    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        if (Arrays.asList(exclude).contains(methodParameter.getDeclaringClass().getSimpleName())) {
            return o;
        }
        if (o instanceof Result) { //我写这一段是因为适配GREH里面 特殊异常处理直接ResponseBody抛出Result为内容的时候 不会再抛个code 200出来 他妈的花了我2个小时才搞明白其中的原理
            return o;
        }
        if (o instanceof String) {
            try {
                return objectMapper.writeValueAsString(Result.success(o));
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        }

        return Result.success(o);
    }

}
