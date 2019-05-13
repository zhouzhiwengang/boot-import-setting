package com.zzg.entity;


import java.util.Date;

import com.zzg.common.core.model.BaseEntity;

public class Column extends BaseEntity{
    private String sid;

    private String alias;

    private String name;

    private String type;

    private Integer length;

    private Integer decimal;

    private String required;

    private String primary;

    private String defaultValue;

    private String comment;

    private Date createDt;

    private String createBy;

    private Date updateDt;

    private String updateBy;

    private String busTableId;

    private Integer version;

    private String state;

    private String deleteFlag;

    private String code;

    private static final long serialVersionUID = 1L;

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid == null ? null : sid.trim();
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias == null ? null : alias.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public Integer getDecimal() {
        return decimal;
    }

    public void setDecimal(Integer decimal) {
        this.decimal = decimal;
    }

    public String getRequired() {
        return required;
    }

    public void setRequired(String required) {
        this.required = required == null ? null : required.trim();
    }

    public String getPrimary() {
        return primary;
    }

    public void setPrimary(String primary) {
        this.primary = primary == null ? null : primary.trim();
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue == null ? null : defaultValue.trim();
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
    }

    public Date getCreateDt() {
        return createDt;
    }

    public void setCreateDt(Date createDt) {
        this.createDt = createDt;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    public Date getUpdateDt() {
        return updateDt;
    }

    public void setUpdateDt(Date updateDt) {
        this.updateDt = updateDt;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy == null ? null : updateBy.trim();
    }

    public String getBusTableId() {
        return busTableId;
    }

    public void setBusTableId(String busTableId) {
        this.busTableId = busTableId == null ? null : busTableId.trim();
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", sid=").append(sid);
        sb.append(", alias=").append(alias);
        sb.append(", name=").append(name);
        sb.append(", type=").append(type);
        sb.append(", length=").append(length);
        sb.append(", decimal=").append(decimal);
        sb.append(", required=").append(required);
        sb.append(", primary=").append(primary);
        sb.append(", defaultValue=").append(defaultValue);
        sb.append(", comment=").append(comment);
        sb.append(", createDt=").append(createDt);
        sb.append(", createBy=").append(createBy);
        sb.append(", updateDt=").append(updateDt);
        sb.append(", updateBy=").append(updateBy);
        sb.append(", busTableId=").append(busTableId);
        sb.append(", version=").append(version);
        sb.append(", state=").append(state);
        sb.append(", deleteFlag=").append(deleteFlag);
        sb.append(", code=").append(code);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}