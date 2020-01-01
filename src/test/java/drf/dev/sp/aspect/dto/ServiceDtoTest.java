package drf.dev.sp.aspect.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ServiceDtoTest {
    @Test
    public void testToString() {
        ServiceDto dto = new ServiceDto("TestName", "TestDescription", 10);

        assertEquals("ServiceDto(name=TestName, description=TestDescription, value=10)",
                dto.toString());
    }

    @Test
    public void testBuilder() {
        ServiceDto dto = ServiceDto.builder()
                .name("BuildName")
                .description("BuildDescription")
                .value(12)
                .build();

        assertEquals("ServiceDto(name=BuildName, description=BuildDescription, value=12)",
                dto.toString());
    }
}
