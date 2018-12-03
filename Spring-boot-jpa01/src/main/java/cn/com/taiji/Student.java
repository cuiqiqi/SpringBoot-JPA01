package cn.com.taiji;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Student {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable=false,length=32,unique=true)
	private String name;
	
	@OneToOne(cascade = CascadeType.ALL) 
	@JoinColumn(name = "stu_id", referencedColumnName = "id") //外键
	private StudId studId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	public StudId getStudId() {
		return studId;
	}

	public void setStudId(StudId studId) {
		this.studId = studId;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", studId=" + studId + "]";
	}
	
	
	

}
