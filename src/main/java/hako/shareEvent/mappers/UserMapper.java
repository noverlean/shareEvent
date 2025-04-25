package hako.shareEvent.mappers;

import org.mapstruct.Mapper;

import hako.shareEvent.dtos.UserDto;
import hako.shareEvent.entities.User;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User dtoToModel(UserDto userDto);

    UserDto modelToDto(User user);
}