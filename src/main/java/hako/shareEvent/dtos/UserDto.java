package hako.shareEvent.dtos;

import java.security.Timestamp;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;

@RequiredArgsConstructor
@Data
@Accessors(chain = true)
public class UserDto {
    private final CityDto city;
    private final Long chat_id;
    private final String name;
    private final Timestamp registeredAt;
}
