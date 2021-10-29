package com.axelor.education.db;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Type;

import com.axelor.auth.db.AuditableModel;
import com.axelor.db.annotations.Widget;
import com.axelor.meta.db.MetaFile;
import com.google.common.base.MoreObjects;

@Entity
@Cacheable
@Table(name = "EDUCATION_STUDENTS_EDUCATION", indexes = { @Index(columnList = "image"), @Index(columnList = "name") })
public class StudentsEducation extends AuditableModel {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EDUCATION_STUDENTS_EDUCATION_SEQ")
	@SequenceGenerator(name = "EDUCATION_STUDENTS_EDUCATION_SEQ", sequenceName = "EDUCATION_STUDENTS_EDUCATION_SEQ", allocationSize = 1)
	private Long id;

	@Widget(title = "Photo")
	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	private MetaFile image;

	@Widget(translatable = true)
	@Lob
	@Basic(fetch = FetchType.LAZY)
	@Type(type = "text")
	private String notes;

	private String email;

	private String phone;

	@NotNull
	@Size(max = 255)
	private String name;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "educationList", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Education> educations;

	private String rollno;

	@Widget(selection = "education.higherstudies.select")
	@NotNull
	private String higherstudies;

	private Boolean job = Boolean.FALSE;

	@Widget(selection = "education.gender.select")
	private String gender;

	private LocalDate todaydate;

	private String currentuser;

	private String details;

	@Widget(title = "Attributes")
	@Basic(fetch = FetchType.LAZY)
	@Type(type = "json")
	private String attrs;

	public StudentsEducation() {
	}

	public StudentsEducation(String name) {
		this.name = name;
	}

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	public MetaFile getImage() {
		return image;
	}

	public void setImage(MetaFile image) {
		this.image = image;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Education> getEducations() {
		return educations;
	}

	public void setEducations(List<Education> educations) {
		this.educations = educations;
	}

	/**
	 * Add the given {@link Education} item to the {@code educations}.
	 *
	 * <p>
	 * It sets {@code item.educationList = this} to ensure the proper relationship.
	 * </p>
	 *
	 * @param item
	 *            the item to add
	 */
	public void addEducation(Education item) {
		if (getEducations() == null) {
			setEducations(new ArrayList<>());
		}
		getEducations().add(item);
		item.setEducationList(this);
	}

	/**
	 * Remove the given {@link Education} item from the {@code educations}.
	 *
 	 * @param item
	 *            the item to remove
	 */
	public void removeEducation(Education item) {
		if (getEducations() == null) {
			return;
		}
		getEducations().remove(item);
	}

	/**
	 * Clear the {@code educations} collection.
	 *
	 * <p>
	 * If you have to query {@link Education} records in same transaction, make
	 * sure to call {@link javax.persistence.EntityManager#flush() } to avoid
	 * unexpected errors.
	 * </p>
	 */
	public void clearEducations() {
		if (getEducations() != null) {
			getEducations().clear();
		}
	}

	public String getRollno() {
		return rollno;
	}

	public void setRollno(String rollno) {
		this.rollno = rollno;
	}

	public String getHigherstudies() {
		return higherstudies;
	}

	public void setHigherstudies(String higherstudies) {
		this.higherstudies = higherstudies;
	}

	public Boolean getJob() {
		return job == null ? Boolean.FALSE : job;
	}

	public void setJob(Boolean job) {
		this.job = job;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public LocalDate getTodaydate() {
		return todaydate;
	}

	public void setTodaydate(LocalDate todaydate) {
		this.todaydate = todaydate;
	}

	public String getCurrentuser() {
		return currentuser;
	}

	public void setCurrentuser(String currentuser) {
		this.currentuser = currentuser;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
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
		if (!(obj instanceof StudentsEducation)) return false;

		final StudentsEducation other = (StudentsEducation) obj;
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
			.add("email", getEmail())
			.add("phone", getPhone())
			.add("name", getName())
			.add("rollno", getRollno())
			.add("higherstudies", getHigherstudies())
			.add("job", getJob())
			.add("gender", getGender())
			.add("todaydate", getTodaydate())
			.add("currentuser", getCurrentuser())
			.add("details", getDetails())
			.omitNullValues()
			.toString();
	}
}
