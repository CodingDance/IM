package com.yiting.imbiz.dto;


import com.yiting.im.core.ex.UnReadableException;
import com.yiting.im.core.ex.UnWritableException;
import com.yiting.im.core.transport.DataBuffer;
import com.yiting.im.core.transport.IMSerializer;
import com.yiting.imbiz.entity.UserDetail;

/**
 * Created by Tony on 2/19/15.
 */
public class UserDetailDTO implements IMSerializer {

    private UserDetail userDetail;

    public UserDetailDTO() {
    }

    public UserDetailDTO(UserDetail userDetail) {
        this.userDetail = userDetail;
    }

    public UserDetail getUserDetail() {
        return userDetail;
    }

    public void setUserDetail(UserDetail userDetail) {
        this.userDetail = userDetail;
    }

    @Override
    public DataBuffer encode(short version) throws UnWritableException{
        DataBuffer data = new DataBuffer();
        data.writeString(userDetail.getId());
        data.writeString(userDetail.getEmail());
        data.writeString(userDetail.getTelphone());
        data.writeString(userDetail.getBirthDate());
        data.writeString(userDetail.getCity());
        data.writeString(userDetail.getProvince());
        data.writeString(userDetail.getPosition());
        return null;
    }

    @Override
    public void decode(DataBuffer buffer, short version) throws UnReadableException{
        if (userDetail == null) {
            userDetail = new UserDetail();
        }
        userDetail.setId(buffer.readString());
        userDetail.setEmail(buffer.readString());
        userDetail.setTelphone(buffer.readString());
        userDetail.setBirthDate(buffer.readString());
        userDetail.setCity(buffer.readString());
        userDetail.setProvince(buffer.readString());
        userDetail.setPosition(buffer.readString());
    }
}
