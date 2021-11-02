package com.axelor.education.db;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Basic;
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

import org.hibernate.annotations.Type;

import com.axelor.auth.db.AuditableModel;
import com.axelor.db.annotations.Widget;
import com.google.common.base.MoreObjects;

@Entity
@Table(name = "EDUCATION_TEST_DEMO2", indexes = { @Index(columnList = "name"), @Index(columnList = "code"), @Index(columnList = "phone"), @Index(columnList = "testdemo") })
public class TestDemo2 extends AuditableModel {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EDUCATION_TEST_DEMO2_SEQ")
	@SequenceGenerator(name = "EDUCATION_TEST_DEMO2_SEQ", sequenceName = "EDUCATION_TEST_DEMO2_SEQ", allocationSize = 1)
	private Long id;

	@NotNull
	private String name;

	private String code;

	@OneToOne(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	private Phonies phone;

	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	private TestDemo testdemo;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "carList", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<TestDemo3> carLists;

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "codeset", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	private Set<TestDemo4> codesets;

	@Widget(title = "Attributes")
	@Basic(fetch = FetchType.LAZY)
	@Type(type = "json")
	private String attrs;

	public TestDemo2() {
	}

	public TestDemo2(String name, String code, Set<TestDemo4> codesets) {
		this.name = name;
		this.code = code;
		this.codesets = codesets;
	}

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Phonies getPhone() {
		return phone;
	}

	public void setPhone(Phonies phone) {
		this.phone = phone;
	}

	public TestDemo getTestdemo() {
		return testdemo;
	}

	public void setTestdemo(TestDemo testdemo) {
		this.testdemo = testdemo;
	}

	public List<TestDemo3> getCarLists() {
		return carLists;
	}

	public void setCarLists(List<TestDemo3> carLists) {
		this.carLists = carLists;
	}

	/**
	 * Add the given {@link TestDemo3} item to the {@code carLists}.
	 *
	 * <p>
	 * It sets {@code item.carList = this} to ensure the proper relationship.
	 * </p>
	 *
	 * @param item
	 *            the item to add
	 */
	public void addCarList(TestDemo3 item) {
		if (getCarLists() == null) {
			setCarLists(new ArrayList<>());
		}
		getCarLists().add(item);
		item.setCarList(this);
	}

	/**
	 * Remove the given {@link TestDemo3} item from the {@code carLists}.
	 *
 	 * @param item
	 *            the item to remove
	 */
	public void removeCarList(TestDemo3 item) {
		if (getCarLists() == null) {
			return;
		}
		getCarLists().remove(item);
	}

	/**
	 * Clear the {@code carLists} collection.
	 *
	 * <p>
	 * If you have to query {@link TestDemo3} records in same transaction, make
	 * sure to call {@link javax.persistence.EntityManager#flush() } to avoid
	 * unexpected errors.
	 * </p>
	 */
	public void clearCarLists() {
		if (getCarLists() != null) {
			getCarLists().clear();
		}
	}

	public Set<TestDemo4> getCodesets() {
		return codesets;
	}

	public void setCodesets(Set<TestDemo4> codesets) {
		this.codesets = codesets;
	}

	/**
	 * Add the given {@link TestDemo4} item to the {@code codesets}.
	 *
	 * @param item
	 *            the item to add
	 */
	public void addCodeset(TestDemo4 item) {
		if (getCodesets() == null) {
			setCodesets(new HashSet<>());
		}
		getCodesets().add(item);
	}

	/**
	 * Remove the given {@link TestDemo4} item from the {@code codesets}.
	 *
 	 * @param item
	 *            the item to remove
	 */
	public void removeCodeset(TestDemo4 item) {
		if (getCodesets() == null) {
			return;
		}
		getCodesets().remove(item);
	}

	/**
	 * Clear the {@code codesets} collection.
	 *
	 */
	public void clearCodesets() {
		if (getCodesets() != null) {
			getCodesets().clear();
		}
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
		if (!(obj instanceof TestDemo2)) return false;

		final TestDemo2 other = (TestDemo2) obj;
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
			.add("name", getName())
			.add("code", getCode())
			.omitNullValues()
			.toString();
	}
}
