package com.zzg.entity;

import com.zzg.common.core.model.BaseEntity;

public class formRelation extends BaseEntity {
    private String sid;

    private String busObjectId;

    private String busFormId;

    private static final long serialVersionUID = 1L;

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid == null ? null : sid.trim();
    }

    public String getBusObjectId() {
        return busObjectId;
    }

    public void setBusObjectId(String busObjectId) {
        this.busObjectId = busObjectId == null ? null : busObjectId.trim();
    }

    public String getBusFormId() {
        return busFormId;
    }

    public void setBusFormId(String busFormId) {
        this.busFormId = busFormId == null ? null : busFormId.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", sid=").append(sid);
        sb.append(", busObjectId=").append(busObjectId);
        sb.append(", busFormId=").append(busFormId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}