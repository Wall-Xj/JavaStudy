package com.xj.sorm.bean;

import java.util.List;
import java.util.Map;

/**
 * �洢��ṹ��Ϣ
 * 
 * @author WanYin
 *
 */
public class TableInfo {
	/**
	 * ����
	 */
	private String tname;
	/**
	 * �����ֶ���Ϣ
	 */
	private Map<String, ColumnInfo> columns;
	/**
	 * Ψһ����
	 */
	private ColumnInfo onlyPriKey;
	/**
	 * ����z�����I����������洢
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
