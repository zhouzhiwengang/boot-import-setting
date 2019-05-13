package com.zzg.entity;

import com.zzg.common.core.model.BaseEntity;

public class ColumnWidgetRelationship extends BaseEntity {
    private String sid;

    private String columnWidgetSid;

    private String columnSid;

    private static final long serialVersionUID = 1L;

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid == null ? null : sid.trim();
    }

    public String getColumnWidgetSid() {
        return columnWidgetSid;
    }

    public void setColumnWidgetSid(String columnWidgetSid) {
        this.columnWidgetSid = columnWidgetSid == null ? null : columnWidgetSid.trim();
    }

    public String getColumnSid() {
        return columnSid;
    }

    public void setColumnSid(String columnSid) {
        this.columnSid = columnSid == null ? null : columnSid.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", sid=").append(sid);
        sb.append(", columnWidgetSid=").append(columnWidgetSid);
        sb.append(", columnSid=").append(columnSid);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}