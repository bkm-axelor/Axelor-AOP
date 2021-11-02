package com.axelor.education.db;

import java.util.Objects;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Type;

import com.axelor.auth.db.AuditableModel;
import com.axelor.db.annotations.NameColumn;
import com.axelor.db.annotations.Widget;
import com.google.common.base.MoreObjects;

@Entity
@Table(name = "EDUCATION_TEST_DEMO3", indexes = { @Index(columnList = "carcode"), @Index(columnList = "car_list") })
public class TestDemo3 extends AuditableModel {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EDUCATION_TEST_DEMO3_SEQ")
	@SequenceGenerator(name = "EDUCATION_TEST_DEMO3_SEQ", sequenceName = "EDUCATION_TEST_DEMO3_SEQ", allocationSize = 1)
	private Long id;

	@NameColumn
	@NotNull
	private String carcode;

	@NotNull
	private String carname;

	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	private TestDemo2 carList;

	@Widget(title = "Attributes")
	@Basic(fetch = FetchType.LAZY)
	@Type(type = "json")
	private String attrs;

	public TestDemo3() {
	}

	public TestDemo3(String carcode, String carname) {
		this.carcode = carcode;
		this.carname = carname;
	}

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	public String getCarcode() {
		return carcode;
	}

	public void setCarcode(String carcode) {
		this.carcode = carcode;
	}

	public String getCarname() {
		return carname;
	}

	public void setCarname(String carname) {
		this.carname = carname;
	}

	public TestDemo2 getCarList() {
		return carList;
	}

	public void setCarList(TestDemo2 carList) {
		this.carList = carList;
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
		if (!(obj instanceof TestDemo3)) return false;

		final TestDemo3 other = (TestDemo3) obj;
		if (this.getId() != null || other.getId() != null) {
			return Objects.equals(this.getId(), other.getId());
		}

		return false;
	}

	@Override
	public int hashCode() {
		return 31;
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this)
			.add("id", getId())
			.add("carcode", getCarcode())
			.add("carname", getCarname())
			.omitNullValues()
			.toString();
	}
}
