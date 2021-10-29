package com.axelor.education.db;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Basic;
import javax.persistence.Cacheable;
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
@Cacheable
@Table(name = "EDUCATION_EDUCATION", indexes = { @Index(columnList = "education_list"), @Index(columnList = "examination") })
public class Education extends AuditableModel {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EDUCATION_EDUCATION_SEQ")
	@SequenceGenerator(name = "EDUCATION_EDUCATION_SEQ", sequenceName = "EDUCATION_EDUCATION_SEQ", allocationSize = 1)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	private StudentsEducation educationList;

	@Widget(selection = "education.examination.type")
	@NameColumn
	@NotNull
	private String examination;

	@NotNull
	private String university;

	@NotNull
	private String institute;

	@NotNull
	private LocalDate yearOfPassing;

	private Integer percentage = 0;

	private String status;

	@Widget(title = "Attributes")
	@Basic(fetch = FetchType.LAZY)
	@Type(type = "json")
	private String attrs;

	public Education() {
	}

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	public StudentsEducation getEducationList() {
		return educationList;
	}

	public void setEducationList(StudentsEducation educationList) {
		this.educationList = educationList;
	}

	public String getExamination() {
		return examination;
	}

	public void setExamination(String examination) {
		this.examination = examination;
	}

	public String getUniversity() {
		return university;
	}

	public void setUniversity(String university) {
		this.university = university;
	}

	public String getInstitute() {
		return institute;
	}

	public void setInstitute(String institute) {
		this.institute = institute;
	}

	public LocalDate getYearOfPassing() {
		return yearOfPassing;
	}

	public void setYearOfPassing(LocalDate yearOfPassing) {
		this.yearOfPassing = yearOfPassing;
	}

	public Integer getPercentage() {
		return percentage == null ? 0 : percentage;
	}

	public void setPercentage(Integer percentage) {
		this.percentage = percentage;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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
		if (!(obj instanceof Education)) return false;

		final Education other = (Education) obj;
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
			.add("examination", getExamination())
			.add("university", getUniversity())
			.add("institute", getInstitute())
			.add("yearOfPassing", getYearOfPassing())
			.add("percentage", getPercentage())
			.add("status", getStatus())
			.omitNullValues()
			.toString();
	}
}
