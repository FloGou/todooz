package fr.todooz.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang.StringUtils;



@Entity
@Table(name = "task")
public class Task {
	
	@Column
	private Date createdAt = new Date();
	@Column
    private String title;

	@Column
    private String text;

	@Column
    private Date date;

	@Column(nullable=true)
    private String tags;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
    
	
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String[] getTagArray() {
    	return StringUtils.split(tags, ",");
    }

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}
}
