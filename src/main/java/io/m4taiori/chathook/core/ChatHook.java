package io.m4taiori.chathook.core;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ChatHook
{

    private final URL hookUrl;

    private List<ChatHookEvent> listeners = new ArrayList<>();

    public ChatHook(URL hookUrl)
    {
        this.hookUrl = hookUrl;
    }

    public void addListener(ChatHookEvent event)
    {
        listeners.add(event);
    }

    public URL getHookUrl()
    {
        return hookUrl;
    }

    private void notifyListeners(HookPacket packet, int httpResponse )
    {
        listeners.forEach( listener -> listener.post( httpResponse, packet, this ) );
    }

    public void sendPacket(HookPacket packet) throws IOException
    {

        HttpURLConnection connection = (HttpURLConnection) hookUrl.openConnection();

        connection.setRequestMethod("POST");
        connection.setRequestProperty("User-Agent", "ChatHook/1.0");
        connection.setDoOutput(true);

        OutputStream outputStream = connection.getOutputStream();
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);

        outputStreamWriter.write(packet.toString());

        outputStreamWriter.flush();
        outputStreamWriter.close();
        outputStream.close();
        connection.connect();

        notifyListeners(packet, connection.getResponseCode());

    }

}
