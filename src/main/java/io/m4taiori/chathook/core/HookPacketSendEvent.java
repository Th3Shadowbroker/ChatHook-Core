package io.m4taiori.chathook.core;

public abstract class HookPacketSendEvent implements ChatHookEvent
{

    private final int httpResponse;

    private final HookPacket packet;

    private final ChatHook hook;

    public HookPacketSendEvent(int httpResponse, HookPacket packet, ChatHook hook)
    {
        this.httpResponse = httpResponse;
        this.packet = packet;
        this.hook = hook;
    }

    protected int getHttpResponse()
    {
        return httpResponse;
    }

    protected HookPacket getPacket()
    {
        return packet;
    }

    protected ChatHook getHook()
    {
        return hook;
    }

}
