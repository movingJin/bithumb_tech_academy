package net.movingjin.api.user.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Component
public class UserDto {  //보안을 위해 분리시켜 둠(Web용)
    @ApiModelProperty(position = 0) private long userId;
    @ApiModelProperty(position = 1) private long username;
    @ApiModelProperty(position = 2) private long password;
    @ApiModelProperty(position = 3) private long name;
    @ApiModelProperty(position = 4) private long email;
    @ApiModelProperty(position = 5) private long regDate;
    @ApiModelProperty(position = 6) private long token;
    @ApiModelProperty(position = 7) private List<Role> roles;
}
