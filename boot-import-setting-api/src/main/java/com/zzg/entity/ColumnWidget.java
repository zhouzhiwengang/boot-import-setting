package com.zzg.entity;

import java.util.Date;
import com.zzg.common.core.model.BaseEntity;

public class ColumnWidget extends BaseEntity {
    private String sid;

    private String widgetName;

    private Integer widgetType;

    private String widgetValue;

    private String widgetSett;

    private String dictCode;

    private String createBy;

    private Date createDt;

    private String updateBy;

    private Date updateDt;

    private Integer version;

    private String deleteFlag;

    private String state;
    
    private Integer valueSource;

    private static final long serialVersionUID = 1L;

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid == null ? null : sid.trim();
    }

    public String getWidgetName() {
        return widgetName;
    }

    public void setWidgetName(String widgetName) {
        this.widgetName = widgetName == null ? null : widgetName.trim();
    }

    public Integer getWidgetType() {
        return widgetType;
    }

    public void setWidgetType(Integer widgetType) {
        this.widgetType = widgetType;
    }

    public String getWidgetValue() {
        return widgetValue;
    }

    public void setWidgetValue(String widgetValue) {
        this.widgetValue = widgetValue == null ? null : widgetValue.trim();
    }

    public String getWidgetSett() {
        return widgetSett;
    }

    public void setWidgetSett(String widgetSett) {
        this.widgetSett = widgetSett == null ? null : widgetSett.trim();
    }

    public String getDictCode() {
        return dictCode;
    }

    public void setDictCode(String dictCode) {
        this.dictCode = dictCode == null ? null : dictCode.trim();
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

    public String getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag == null ? null : deleteFlag.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }
    
    public Integer getValueSource() {
		return valueSource;
	}

	public void setValueSource(Integer valueSource) {
		this.valueSource = valueSource;
	}

	@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", sid=").append(sid);
        sb.append(", widgetName=").append(widgetName);
        sb.append(", widgetType=").append(widgetType);
        sb.append(", widgetValue=").append(widgetValue);
        sb.append(", widgetSett=").append(widgetSett);
        sb.append(", dictCode=").append(dictCode);
        sb.append(", createBy=").append(createBy);
        sb.append(", createDt=").append(createDt);
        sb.append(", updateBy=").append(updateBy);
        sb.append(", updateDt=").append(updateDt);
        sb.append(", version=").append(version);
        sb.append(", deleteFlag=").append(deleteFlag);
        sb.append(", state=").append(state);
        sb.append(", valueSource=").append(valueSource);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}