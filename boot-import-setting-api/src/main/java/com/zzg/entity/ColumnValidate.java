package com.zzg.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.zzg.common.core.model.BaseEntity;

public class ColumnValidate extends BaseEntity {
	private String sid;

	private String createBy;

	private Date createDt;

	private String updateBy;

	private Date updateDt;

	private Integer version;

	private String validateName;

	private String validateContent;

	private String state;

	private String deleteFlag;

	private static final long serialVersionUID = 1L;

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid == null ? null : sid.trim();
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

	public String getValidateName() {
		return validateName;
	}

	public void setValidateName(String validateName) {
		this.validateName = validateName;
	}

	public String getValidateContent() {
		return validateContent;
	}

	public void setValidateContent(String validateContent) {
		this.validateContent = validateContent;
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

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getClass().getSimpleName());
		sb.append(" [");
		sb.append("Hash = ").append(hashCode());
		sb.append(", sid=").append(sid);
		sb.append(", createBy=").append(createBy);
		sb.append(", createDt=").append(createDt);
		sb.append(", updateBy=").append(updateBy);
		sb.append(", updateDt=").append(updateDt);
		sb.append(", version=").append(version);
		sb.append(", validateName=").append(validateName);
		sb.append(", validateContent=").append(validateContent);
		sb.append(", state=").append(state);
		sb.append(", deleteFlag=").append(deleteFlag);
		sb.append("]");
		return sb.toString();
	}
}