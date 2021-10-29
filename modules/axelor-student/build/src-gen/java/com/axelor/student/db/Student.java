package com.axelor.student.db;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
@Table(name = "STUDENT_STUDENT", indexes = { @Index(columnList = "studentimage"), @Index(columnList = "std_ph"), @Index(columnList = "std_dept") })
public class Student extends AuditableModel {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "STUDENT_STUDENT_SEQ")
	@SequenceGenerator(name = "STUDENT_STUDENT_SEQ", sequenceName = "STUDENT_STUDENT_SEQ", allocationSize = 1)
	private Long id;

	@Widget(title = "Photo")
	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	private MetaFile studentimage;

	private String title;

	@NotNull
	@Size(max = 255)
	private String stdName;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private Phone stdPh;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "stdAdd", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<SAddress> stdAdds;

	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	private Department stdDept;

	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	private Set<Subject> stdSub;

	private LocalDate joinDate;

	@Widget(selection = "student.result.type")
	private Integer result = 0;

	@Widget(title = "Attributes")
	@Basic(fetch = FetchType.LAZY)
	@Type(type = "json")
	private String attrs;

	public Student() {
	}

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	public MetaFile getStudentimage() {
		return studentimage;
	}

	public void setStudentimage(MetaFile studentimage) {
		this.studentimage = studentimage;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getStdName() {
		return stdName;
	}

	public void setStdName(String stdName) {
		this.stdName = stdName;
	}

	public Phone getStdPh() {
		return stdPh;
	}

	public void setStdPh(Phone stdPh) {
		this.stdPh = stdPh;
	}

	public List<SAddress> getStdAdds() {
		return stdAdds;
	}

	public void setStdAdds(List<SAddress> stdAdds) {
		this.stdAdds = stdAdds;
	}

	/**
	 * Add the given {@link SAddress} item to the {@code stdAdds}.
	 *
	 * <p>
	 * It sets {@code item.stdAdd = this} to ensure the proper relationship.
	 * </p>
	 *
	 * @param item
	 *            the item to add
	 */
	public void addStdAdd(SAddress item) {
		if (getStdAdds() == null) {
			setStdAdds(new ArrayList<>());
		}
		getStdAdds().add(item);
		item.setStdAdd(this);
	}

	/**
	 * Remove the given {@link SAddress} item from the {@code stdAdds}.
	 *
 	 * @param item
	 *            the item to remove
	 */
	public void removeStdAdd(SAddress item) {
		if (getStdAdds() == null) {
			return;
		}
		getStdAdds().remove(item);
	}

	/**
	 * Clear the {@code stdAdds} collection.
	 *
	 * <p>
	 * If you have to query {@link SAddress} records in same transaction, make
	 * sure to call {@link javax.persistence.EntityManager#flush() } to avoid
	 * unexpected errors.
	 * </p>
	 */
	public void clearStdAdds() {
		if (getStdAdds() != null) {
			getStdAdds().clear();
		}
	}

	public Department getStdDept() {
		return stdDept;
	}

	public void setStdDept(Department stdDept) {
		this.stdDept = stdDept;
	}

	public Set<Subject> getStdSub() {
		return stdSub;
	}

	public void setStdSub(Set<Subject> stdSub) {
		this.stdSub = stdSub;
	}

	/**
	 * Add the given {@link Subject} item to the {@code stdSub}.
	 *
	 * @param item
	 *            the item to add
	 */
	public void addStdSub(Subject item) {
		if (getStdSub() == null) {
			setStdSub(new HashSet<>());
		}
		getStdSub().add(item);
	}

	/**
	 * Remove the given {@link Subject} item from the {@code stdSub}.
	 *
 	 * @param item
	 *            the item to remove
	 */
	public void removeStdSub(Subject item) {
		if (getStdSub() == null) {
			return;
		}
		getStdSub().remove(item);
	}

	/**
	 * Clear the {@code stdSub} collection.
	 *
	 */
	public void clearStdSub() {
		if (getStdSub() != null) {
			getStdSub().clear();
		}
	}

	public LocalDate getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(LocalDate joinDate) {
		this.joinDate = joinDate;
	}

	public Integer getResult() {
		return result == null ? 0 : result;
	}

	public void setResult(Integer result) {
		this.result = result;
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
		if (!(obj instanceof Student)) return false;

		final Student other = (Student) obj;
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
			.add("title", getTitle())
			.add("stdName", getStdName())
			.add("joinDate", getJoinDate())
			.add("result", getResult())
			.omitNullValues()
			.toString();
	}
}
