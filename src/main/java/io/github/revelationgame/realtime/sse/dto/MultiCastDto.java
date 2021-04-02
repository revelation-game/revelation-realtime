package io.github.revelationgame.realtime.sse.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MultiCastDto {

    @NotEmpty
    private List<String> receiverSecretUIDs;

    @NotEmpty
    @Length(max = 50)
    private String eventType;

    @NotNull
    private Object message;

}
