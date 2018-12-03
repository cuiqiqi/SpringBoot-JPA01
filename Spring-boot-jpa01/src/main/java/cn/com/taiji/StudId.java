package cn.com.taiji;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class StudId {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) //主键策略 自增长
	private Integer id;
	
	@Column(unique=true,length=15, nullable=false)
	private Integer studId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getStudId() {
		return studId;
	}

	public void setStudId(Integer studId) {
		this.studId = studId;
	}

	@Override
	public String toString() {
		return "StudId [id=" + id + ", studId=" + studId + "]";
	}
	
	
	

}
