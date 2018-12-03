package cn.com.taiji;

import java.awt.print.PrinterAbortException;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Bank {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(length=20,nullable=false,unique=true)
	private String name;
	
	@ManyToMany(mappedBy = "perList")
	private List<Persion> perList ;

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

	

	public List<Persion> getPerList() {
		return perList;
	}

	public void setPerList(List<Persion> perList) {
		this.perList = perList;
	}

	@Override
	public String toString() {
		return "Bank [id=" + id + ", name=" + name + ", perList=" + perList + "]";
	}

}
