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
import javax.persistence.OneToOne;
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
@Table(name = "STUDENT_ZIPCODE", indexes = { @Index(columnList = "zipcodes") })
public class Zipcode extends AuditableModel {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "STUDENT_ZIPCODE_SEQ")
	@SequenceGenerator(name = "STUDENT_ZIPCODE_SEQ", sequenceName = "STUDENT_ZIPCODE_SEQ", allocationSize = 1)
	private Long id;

	@EqualsInclude
	@NameColumn
	@Column(unique = true)
	private String zipcodename;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private City zipcodes;

	@Widget(title = "Attributes")
	@Basic(fetch = FetchType.LAZY)
	@Type(type = "json")
	private String attrs;

	public Zipcode() {
	}

	public Zipcode(String zipcodename, City zipcodes) {
		this.zipcodename = zipcodename;
		this.zipcodes = zipcodes;
	}

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	public String getZipcodename() {
		return zipcodename;
	}

	public void setZipcodename(String zipcodename) {
		this.zipcodename = zipcodename;
	}

	public City getZipcodes() {
		return zipcodes;
	}

	public void setZipcodes(City zipcodes) {
		this.zipcodes = zipcodes;
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
		if (!(obj instanceof Zipcode)) return false;

		final Zipcode other = (Zipcode) obj;
		if (this.getId() != null || other.getId() != null) {
			return Objects.equals(this.getId(), other.getId());
		}

		return Objects.equals(getZipcodename(), other.getZipcodename())
			&& (getZipcodename() != null);
	}

	@Override
	public int hashCode() {
		return 31;
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this)
			.add("id", getId())
			.add("zipcodename", getZipcodename())
			.omitNullValues()
			.toString();
	}
}
