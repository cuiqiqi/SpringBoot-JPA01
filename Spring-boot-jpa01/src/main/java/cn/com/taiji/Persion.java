package cn.com.taiji;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Persion {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable = false, length = 20, unique = true)
	private String name;
	
	@ManyToMany
    @JoinTable(name = "bank",joinColumns = @JoinColumn(name = "perList"),
    inverseJoinColumns = @JoinColumn(name = "authority_id"))
	private List<Bank> bankList;

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

	public List<Bank> getBankList() {
		return bankList;
	}

	public void setBankList(List<Bank> bankList) {
		this.bankList = bankList;
	}

	@Override
	public String toString() {
		return "Persion [id=" + id + ", name=" + name + ", bankList=" + bankList + "]";
	}
	
	
}
