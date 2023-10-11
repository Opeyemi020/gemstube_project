package io.sulty.gemstube.dtos.response;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter @Getter @Data public class EmailResponse {
    private Integer code;
    private String messageId;
}
