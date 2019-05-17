package com.zzg.entity;

import com.zzg.common.core.model.BaseEntity;

public class ObjectRelation extends BaseEntity  {
    private String sid;

    private String busObjectId;

    private String parentId;

    private String path;
    
    private Integer depath;

    private String relaType;

    private String busTableId;

    private String tableType;

    private String relaText;

    private static final long serialVersionUID = 1L;
    
    

    public Integer getDepath() {
		return depath;
	}

	public void setDepath(Integer depath) {
		this.depath = depath;
	}

	public String getTableType() {
		return tableType;
	}

	public void setTableType(String tableType) {
		this.tableType = tableType;
	}

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

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId == null ? null : parentId.trim();
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path == null ? null : path.trim();
    }

    public String getRelaType() {
        return relaType;
    }

    public void setRelaType(String relaType) {
        this.relaType = relaType == null ? null : relaType.trim();
    }

    public String getBusTableId() {
        return busTableId;
    }

    public void setBusTableId(String busTableId) {
        this.busTableId = busTableId == null ? null : busTableId.trim();
    }
    
    public String getRelaText() {
        return relaText;
    }

    public void setRelaText(String relaText) {
        this.relaText = relaText == null ? null : relaText.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", sid=").append(sid);
        sb.append(", busObjectId=").append(busObjectId);
        sb.append(", parentId=").append(parentId);
        sb.append(", path=").append(path);
        sb.append(", relaType=").append(relaType);
        sb.append(", busTableId=").append(busTableId);
        sb.append(", relaText=").append(relaText);
        sb.append(", depath=").append(depath);
        sb.append(", tableType=").append(tableType);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}