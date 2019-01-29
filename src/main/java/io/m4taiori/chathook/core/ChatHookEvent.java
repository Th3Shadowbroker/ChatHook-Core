package io.m4taiori.chathook.core;

public interface ChatHookEvent
{

    void post(int httpResponse, HookPacket packet, ChatHook hook);

}
