package com.zzg.entity.pack;

import com.zzg.entity.ObjectRelation;
import com.zzg.entity.Objects;
import com.zzg.entity.Table;

public class ObjectRelationPack extends ObjectRelation {
	
	private Objects objects;
	
	private Table table;

	public Objects getObjects() {
		return objects;
	}

	public void setObjects(Objects objects) {
		this.objects = objects;
	}

	public Table getTable() {
		return table;
	}

	public void setTable(Table table) {
		this.table = table;
	}
}
