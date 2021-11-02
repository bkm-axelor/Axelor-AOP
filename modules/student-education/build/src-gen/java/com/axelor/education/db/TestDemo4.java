package com.axelor.education.db;

import java.util.HashSet;
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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import com.axelor.auth.db.AuditableModel;
import com.axelor.db.annotations.NameColumn;
import com.axelor.db.annotations.Widget;
import com.google.common.base.MoreObjects;

@Entity
@Table(name = "EDUCATION_TEST_DEMO4", indexes = { @Index(columnList = "diffCode") })
public class TestDemo4 extends AuditableModel {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EDUCATION_TEST_DEMO4_SEQ")
	@SequenceGenerator(name = "EDUCATION_TEST_DEMO4_SEQ", sequenceName = "EDUCATION_TEST_DEMO4_SEQ", allocationSize = 1)
	private Long id;

	@NameColumn
	private String diffCode;

	private String codeName;

	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	private Set<TestDemo2> codeset;

	@Widget(title = "Attributes")
	@Basic(fetch = FetchType.LAZY)
	@Type(type = "json")
	private String attrs;

	public TestDemo4() {
	}

	public TestDemo4(String codeName, Set<TestDemo2> codeset) {
		this.codeName = codeName;
		this.codeset = codeset;
	}

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	public String getDiffCode() {
		return diffCode;
	}

	public void setDiffCode(String diffCode) {
		this.diffCode = diffCode;
	}

	public String getCodeName() {
		return codeName;
	}

	public void setCodeName(String codeName) {
		this.codeName = codeName;
	}

	public Set<TestDemo2> getCodeset() {
		return codeset;
	}

	public void setCodeset(Set<TestDemo2> codeset) {
		this.codeset = codeset;
	}

	/**
	 * Add the given {@link TestDemo2} item to the {@code codeset}.
	 *
	 * @param item
	 *            the item to add
	 */
	public void addCodeset(TestDemo2 item) {
		if (getCodeset() == null) {
			setCodeset(new HashSet<>());
		}
		getCodeset().add(item);
	}

	/**
	 * Remove the given {@link TestDemo2} item from the {@code codeset}.
	 *
 	 * @param item
	 *            the item to remove
	 */
	public void removeCodeset(TestDemo2 item) {
		if (getCodeset() == null) {
			return;
		}
		getCodeset().remove(item);
	}

	/**
	 * Clear the {@code codeset} collection.
	 *
	 */
	public void clearCodeset() {
		if (getCodeset() != null) {
			getCodeset().clear();
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
		if (!(obj instanceof TestDemo4)) return false;

		final TestDemo4 other = (TestDemo4) obj;
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
			.add("diffCode", getDiffCode())
			.add("codeName", getCodeName())
			.omitNullValues()
			.toString();
	}
}
