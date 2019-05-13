package com.zzg.entity;

import java.io.Serializable;

import com.zzg.common.core.model.BaseEntity;

public class ColumnValidateRelationship extends BaseEntity {
    private String sid;

    private String columnSid;

    private String columnValidateSid;

    private static final long serialVersionUID = 1L;

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid == null ? null : sid.trim();
    }

    public String getColumnSid() {
        return columnSid;
    }

    public void setColumnSid(String columnSid) {
        this.columnSid = columnSid == null ? null : columnSid.trim();
    }

    public String getColumnValidateSid() {
        return columnValidateSid;
    }

    public void setColumnValidateSid(String columnValidateSid) {
        this.columnValidateSid = columnValidateSid == null ? null : columnValidateSid.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", sid=").append(sid);
        sb.append(", columnSid=").append(columnSid);
        sb.append(", columnValidateSid=").append(columnValidateSid);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}