package com.mokylin.game.core.message;

import io.netty.channel.ChannelHandlerContext;

/**
 * Created by game on 3/31/14.
 */
public abstract class Handler implements Command {
    private Message message; // message
    private ChannelHandlerContext context;

    public ChannelHandlerContext getContext() {
        return context;
    }

    public void setContext(ChannelHandlerContext context) {
        this.context = context;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }
}
