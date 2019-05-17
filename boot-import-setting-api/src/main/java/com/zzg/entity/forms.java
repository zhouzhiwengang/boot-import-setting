package com.zzg.entity;

import java.util.Date;

import com.zzg.common.core.model.BaseEntity;

public class forms extends BaseEntity {
    private String sid;

    private String name;

    private String alias;

    private String createBy;

    private Date createDt;

    private String updateBy;

    private Date updateDt;

    private Integer version;

    private String state;

    private String deleteFlag;

    private String fromText;

    private static final long serialVersionUID = 1L;

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid == null ? null : sid.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias == null ? null : alias.trim();
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    public Date getCreateDt() {
        return createDt;
    }

    public void setCreateDt(Date createDt) {
        this.createDt = createDt;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy == null ? null : updateBy.trim();
    }

    public Date getUpdateDt() {
        return updateDt;
    }

    public void setUpdateDt(Date updateDt) {
        this.updateDt = updateDt;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public String getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag == null ? null : deleteFlag.trim();
    }

    public String getFromText() {
        return fromText;
    }

    public void setFromText(String fromText) {
        this.fromText = fromText == null ? null : fromText.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", sid=").append(sid);
        sb.append(", name=").append(name);
        sb.append(", alias=").append(alias);
        sb.append(", createBy=").append(createBy);
        sb.append(", createDt=").append(createDt);
        sb.append(", updateBy=").append(updateBy);
        sb.append(", updateDt=").append(updateDt);
        sb.append(", version=").append(version);
        sb.append(", state=").append(state);
        sb.append(", deleteFlag=").append(deleteFlag);
        sb.append(", fromText=").append(fromText);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}