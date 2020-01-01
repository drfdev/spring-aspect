package drf.dev.sp.aspect.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ServiceDto {
    private final String name;
    private String description;
    private int value;
}
