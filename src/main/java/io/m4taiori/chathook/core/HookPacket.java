package io.m4taiori.chathook.core;

import org.json.JSONObject;

public class HookPacket
{

    private final String content;

    private final String username;

    private final String avatarUrl;

    public HookPacket(String content, String username, String avatarUrl)
    {
        this.content = content;
        this.username = username;
        this.avatarUrl = avatarUrl;
    }

    public String getContent()
    {
        return content;
    }

    public String getUsername()
    {
        return username;
    }

    public String getAvatarUrl()
    {
        return avatarUrl;
    }

    public JSONObject getAsJson()
    {
        JSONObject json = new JSONObject();

        json.accumulate("content", content);
        json.accumulate("username", username);
        json.accumulate("avatar", avatarUrl);

        return json;
    }

    @Override
    public String toString()
    {
        return getAsJson().toString();
    }

}
