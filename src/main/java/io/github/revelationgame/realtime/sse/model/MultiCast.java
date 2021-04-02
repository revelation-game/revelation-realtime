package io.github.revelationgame.realtime.sse.model;

import brave.internal.Nullable;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class MultiCast implements Message {

    private List<String> receiverSecretUIDs;
    private String eventType;
    private Object message;

    @Override
    public boolean isReceiver(@Nullable String receiverUID) {
        if (receiverUID == null) return false;
        return receiverSecretUIDs.contains(receiverUID);
    }
}
