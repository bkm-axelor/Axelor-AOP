package com.axelor.student.db;

import java.util.Objects;

import javax.persistence.Basic;
import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import com.axelor.auth.db.AuditableModel;
import com.axelor.db.annotations.EqualsInclude;
import com.axelor.db.annotations.NameColumn;
import com.axelor.db.annotations.Widget;
import com.google.common.base.MoreObjects;

@Entity
@Cacheable
@Table(name = "STUDENT_CITY", indexes = { @Index(columnList = "state") })
public class City extends AuditableModel {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "STUDENT_CITY_SEQ")
	@SequenceGenerator(name = "STUDENT_CITY_SEQ", sequenceName = "STUDENT_CITY_SEQ", allocationSize = 1)
	private Long id;

	@EqualsInclude
	@NameColumn
	@Column(unique = true)
	private String cityname;

	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	private State state;

	@Widget(title = "Attributes")
	@Basic(fetch = FetchType.LAZY)
	@Type(type = "json")
	private String attrs;

	public City() {
	}

	public City(String cityname) {
		this.cityname = cityname;
	}

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	public String getCityname() {
		return cityname;
	}

	public void setCityname(String cityname) {
		this.cityname = cityname;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public String getAttrs() {
		return attrs;
	}

	public void setAttrs(String attrs) {
		this.attrs = attrs;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) return false;
		if (this == obj) return true;
		if (!(obj instanceof City)) return false;

		final City other = (City) obj;
		if (this.getId() != null || other.getId() != null) {
			return Objects.equals(this.getId(), other.getId());
		}

		return Objects.equals(getCityname(), other.getCityname())
			&& (getCityname() != null);
	}

	@Override
	public int hashCode() {
		return 31;
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this)
			.add("id", getId())
			.add("cityname", getCityname())
			.omitNullValues()
			.toString();
	}
}
