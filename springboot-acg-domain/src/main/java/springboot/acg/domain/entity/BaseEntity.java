package springboot.acg.domain.entity;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class BaseEntity implements Serializable {
    /**
     *
     */
    private String createdPin;
    /**
     *
     */
    private String updatedPin;
    /**
     *
     */
    private LocalDateTime createdAt;
    /**
     *
     */
    private LocalDateTime updatedAt;
    /**
     *
     */
    private Boolean izDel;
}
