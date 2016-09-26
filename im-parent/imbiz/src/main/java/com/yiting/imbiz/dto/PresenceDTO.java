package com.yiting.imbiz.dto;


import com.yiting.im.core.ex.UnReadableException;
import com.yiting.im.core.ex.UnWritableException;
import com.yiting.im.core.transport.DataBuffer;
import com.yiting.im.core.transport.IMSerializer;
import com.yiting.imbiz.bean.Presence;

/**
 * Created by Tony on 2/24/15.
 */
public class PresenceDTO implements IMSerializer {

    private Presence presence;

    public PresenceDTO() {
    }

    public PresenceDTO(Presence presence) {
        this.presence = presence;
    }

    public Presence getPresence() {
        return presence;
    }

    public void setPresence(Presence presence) {
        this.presence = presence;
    }

    @Override
    public DataBuffer encode(short version) throws UnWritableException{
        DataBuffer buffer = new DataBuffer();
        buffer.writeLong(presence.getUin());
        buffer.writeByte(presence.getMode());
        buffer.writeString(presence.getStatus());
        return buffer;
    }

    @Override
    public void decode(DataBuffer buffer, short version) throws UnReadableException{
        presence = new Presence();
        presence.setUin(buffer.readLong());
        presence.setMode(buffer.readByte());
        presence.setStatus(buffer.readString());
    }
}
