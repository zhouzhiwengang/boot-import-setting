package com.zzg.entity;

import java.util.Date;
import com.zzg.common.core.model.BaseEntity;

public class Entity extends BaseEntity {
    private String sid;

    private String state;

    private String deleteFlag;

    private String createBy;

    private Date createDt;

    private String updateBy;

    private Date updateDt;

    private String tableId;

    private String entityPackage;

    private String entityObject;


    private static final long serialVersionUID = 1L;

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid == null ? null : sid.trim();
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

    public String getTableId() {
        return tableId;
    }

    public void setTableId(String tableId) {
        this.tableId = tableId == null ? null : tableId.trim();
    }

    public String getEntityPackage() {
        return entityPackage;
    }

    public void setEntityPackage(String entityPackage) {
        this.entityPackage = entityPackage == null ? null : entityPackage.trim();
    }

    public String getEntityObject() {
        return entityObject;
    }

    public void setEntityObject(String entityObject) {
        this.entityObject = entityObject == null ? null : entityObject.trim();
    }

 

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", sid=").append(sid);
        sb.append(", state=").append(state);
        sb.append(", deleteFlag=").append(deleteFlag);
        sb.append(", createBy=").append(createBy);
        sb.append(", createDt=").append(createDt);
        sb.append(", updateBy=").append(updateBy);
        sb.append(", updateDt=").append(updateDt);
        sb.append(", tableId=").append(tableId);
        sb.append(", entityPackage=").append(entityPackage);
        sb.append(", entityObject=").append(entityObject);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}