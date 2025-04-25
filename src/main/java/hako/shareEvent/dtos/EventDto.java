package hako.shareEvent.dtos;

import java.security.Timestamp;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class EventDto {
    private final CityDto city;
    private String title;
    private String description;
    private String coordinates;
    private Timestamp beginIn;
}
