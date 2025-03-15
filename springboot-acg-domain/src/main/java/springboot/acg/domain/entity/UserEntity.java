package springboot.acg.domain.entity;

import lombok.Data;

@Data
public class UserEntity extends BaseEntity {

    private Long id;

    private String name;

    private String nickName;

    private String password;

    private String email;
}
