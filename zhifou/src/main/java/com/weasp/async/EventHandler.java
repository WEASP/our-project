package com.weasp.async;

import java.util.List;

/**
 * Created by JackHui on 2017/6/15.
 */
public interface EventHandler {
    void doHandle(EventModel model);

    List<EventType> getSupportEventTypes();
}
