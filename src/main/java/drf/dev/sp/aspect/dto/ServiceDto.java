package drf.dev.sp.aspect.dto;

import lombok.Data;

@Data
public class ServiceDto {
    private final String name;
    private String description;
    private int value;
}
