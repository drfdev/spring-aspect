package drf.dev.sp.aspect.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ServiceDtoTest {
    private ServiceDto dto = new ServiceDto("TestName");

    @Test
    public void testToString() {
        dto.setDescription("TestDescription");
        dto.setValue(10);

        assertEquals("ServiceDto(name=TestName, description=TestDescription, value=10)",
                dto.toString());
    }
}
