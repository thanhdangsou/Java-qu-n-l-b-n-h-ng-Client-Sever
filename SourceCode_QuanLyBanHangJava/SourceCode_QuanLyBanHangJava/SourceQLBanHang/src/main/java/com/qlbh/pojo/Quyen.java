package com.qlbh.pojo;
// Generated 26/10/2016 3:07:02 PM by Hibernate Tools 4.3.1

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Quyen generated by hbm2java
 */
@Entity
@Table(name = "quyen", catalog = "qlbh")
public class Quyen implements java.io.Serializable {

	private int id;
	private String ten;
	private String diengiai;
	private Boolean activity;
	private Set<Nguoidung> nguoidungs = new HashSet<Nguoidung>(0);

	public Quyen() {
	}

	public Quyen(int id) {
		this.id = id;
	}

	public Quyen(int id, String ten, String diengiai, Boolean activity, Set<Nguoidung> nguoidungs) {
		this.id = id;
		this.ten = ten;
		this.diengiai = diengiai;
		this.activity = activity;
		this.nguoidungs = nguoidungs;
	}

	@Id

	@Column(name = "id", unique = true, nullable = false)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "ten")
	public String getTen() {
		return this.ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	@Column(name = "diengiai")
	public String getDiengiai() {
		return this.diengiai;
	}

	public void setDiengiai(String diengiai) {
		this.diengiai = diengiai;
	}

	@Column(name = "activity")
	public Boolean getActivity() {
		return this.activity;
	}

	public void setActivity(Boolean activity) {
		this.activity = activity;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "quyen")
	public Set<Nguoidung> getNguoidungs() {
		return this.nguoidungs;
	}

	public void setNguoidungs(Set<Nguoidung> nguoidungs) {
		this.nguoidungs = nguoidungs;
	}

	@Override
	public String toString() {
		return this.getTen();
	}

}
