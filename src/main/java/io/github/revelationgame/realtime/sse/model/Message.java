package io.github.revelationgame.realtime.sse.model;

public interface Message {

    boolean isReceiver(String receiverUID);

    String getEventType();

    Object getMessage();

}
