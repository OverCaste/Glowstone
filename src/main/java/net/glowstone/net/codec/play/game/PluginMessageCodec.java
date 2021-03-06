package net.glowstone.net.codec.play.game;

import com.flowpowered.networking.Codec;
import com.flowpowered.networking.util.ByteBufUtils;
import io.netty.buffer.ByteBuf;
import net.glowstone.net.message.play.game.PluginMessage;

import java.io.IOException;

public final class PluginMessageCodec implements Codec<PluginMessage> {
    public PluginMessage decode(ByteBuf buf) throws IOException {
        String channel = ByteBufUtils.readUTF8(buf);
        int length = buf.readShort();
        byte[] data = new byte[length];
        buf.readBytes(data);
        return new PluginMessage(channel, data);
    }

    public ByteBuf encode(ByteBuf buf, PluginMessage message) throws IOException {
        ByteBufUtils.writeUTF8(buf, message.getChannel());
        buf.writeShort(message.getData().length);
        buf.writeBytes(message.getData());
        return buf;
    }
}
