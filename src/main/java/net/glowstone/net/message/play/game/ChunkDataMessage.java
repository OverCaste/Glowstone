package net.glowstone.net.message.play.game;

import com.flowpowered.networking.Message;

public final class ChunkDataMessage implements Message {

    final int x, z;
    final boolean continuous;
    final int primaryMask, addMask;
    final byte[] data;

    public ChunkDataMessage(int x, int z, boolean continuous, int primaryMask, int addMask, byte[] data) {
        this.x = x;
        this.z = z;
        this.continuous = continuous;
        this.primaryMask = primaryMask;
        this.addMask = addMask;
        this.data = data;
    }

    public static ChunkDataMessage empty(int x, int z) {
        return new ChunkDataMessage(x, z, true, 0, 0, new byte[0]);
    }

    public int getX() {
        return x;
    }

    public int getZ() {
        return z;
    }

    public boolean isContinuous() {
        return continuous;
    }

    public int getPrimaryMask() {
        return primaryMask;
    }

    public int getAddMask() {
        return addMask;
    }

    public byte[] getData() {
        return data;
    }

    @Override
    public String toString() {
        return "ChunkDataMessage{" +
                "x=" + x +
                ", z=" + z +
                ", continuous=" + continuous +
                ", primaryMask=" + primaryMask +
                ", addMask=" + addMask +
                ", data[" + data.length + ']' +
                '}';
    }

}
