package net.javaemployee.springboot.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Dependants")
public class Dependant {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Dep_id")
	private long Dep_id;
	
	@Column(name = "Dep_relation")
	private String Dep_relation;
	
	@Column(name = "Dep_name")
	private String Dep_name;
	
	/** @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "dependat")
	private Employee employee;
	
	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
**/
	public Dependant() {
		
	}
	
	public Dependant(String dep_relation, String dep_name) {
		super();
		Dep_relation = dep_relation;
		Dep_name = dep_name;
	}

	public long getDep_id() {
		return Dep_id;
	}

	public void setDep_id(long dep_id) {
		Dep_id = dep_id;
	}

	public String getDep_relation() {
		return Dep_relation;
	}

	public void setDep_relation(String dep_relation) {
		Dep_relation = dep_relation;
	}

	public String getDep_name() {
		return Dep_name;
	}

	public void setDep_name(String dep_name) {
		Dep_name = dep_name;
	}
	
	

}
