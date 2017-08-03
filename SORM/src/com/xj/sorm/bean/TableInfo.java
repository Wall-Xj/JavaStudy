package com.xj.sorm.bean;

import java.util.List;
import java.util.Map;

/**
 * 存储表结构信息
 * 
 * @author WanYin
 *
 */
public class TableInfo {
	/**
	 * 表名
	 */
	private String tname;
	/**
	 * 所有字段信息
	 */
	private Map<String, ColumnInfo> columns;
	/**
	 * 唯一主键
	 */
	private ColumnInfo onlyPriKey;
	/**
	 * 如果倆和主鍵，则在这里存储
	 */
	private List<ColumnInfo> priKeys;

	
	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	public Map<String, ColumnInfo> getColumns() {
		return columns;
	}

	public void setColumns(Map<String, ColumnInfo> columns) {
		this.columns = columns;
	}

	public ColumnInfo getOnlyPriKey() {
		return onlyPriKey;
	}

	public void setOnlyPriKey(ColumnInfo onlyPriKey) {
		this.onlyPriKey = onlyPriKey;
	}

	public List<ColumnInfo> getPriKeys() {
		return priKeys;
	}

	public void setPriKeys(List<ColumnInfo> priKeys) {
		this.priKeys = priKeys;
	}

	public TableInfo(String name, List<ColumnInfo> priKeys, Map<String, ColumnInfo> columns) {
		super();
		this.tname = name;
		this.columns = columns;
		this.priKeys = priKeys;
	}

	public TableInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

}
