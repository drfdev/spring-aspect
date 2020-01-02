package drf.dev.sp.aspect.controller;

import drf.dev.sp.aspect.annotation.MakeGlobalLogging;
import drf.dev.sp.aspect.annotation.MakeTransactional;
import org.springframework.http.MediaType;
import drf.dev.sp.aspect.dto.ServiceDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicInteger;

@RestController
@Slf4j
@RequestMapping("app")
public class ApplicationController {

    private final AtomicInteger counter = new AtomicInteger(0);

    @GetMapping(
            value = "/",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @MakeGlobalLogging
    public ServiceDto index() {
        return ServiceDto.builder()
                .name("index")
                .description("Index: app/")
                .value(0)
                .build();
    }

    @GetMapping(
            value = "/transaction",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @MakeTransactional
    public ServiceDto transaction(
            @RequestParam String value
    ) {
        return ServiceDto.builder()
                .name("transaction " + value)
                .description("Index: app/transaction")
                .value(counter.getAndIncrement())
                .build();
    }
}
