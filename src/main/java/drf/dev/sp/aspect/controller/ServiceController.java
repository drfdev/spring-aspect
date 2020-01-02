package drf.dev.sp.aspect.controller;

import drf.dev.sp.aspect.annotation.MakeGlobalLogging;
import drf.dev.sp.aspect.annotation.MakeThrowable;
import drf.dev.sp.aspect.annotation.MakeTransactional;
import drf.dev.sp.aspect.dto.ServiceDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("service")
public class ServiceController {

    @GetMapping(
            value = "/error",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @MakeGlobalLogging
    @MakeTransactional
    @MakeThrowable
    public ServiceDto error(
            @RequestParam String value
    ) {
        if ("error".equals(value)) {
            throw new RuntimeException("Error!!!");
        }
        return ServiceDto.builder()
                .name(value)
                .description("Index: service/error")
                .value(666)
                .build();
    }
}
