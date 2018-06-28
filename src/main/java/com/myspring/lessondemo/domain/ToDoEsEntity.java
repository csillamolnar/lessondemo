package com.myspring.lessondemo.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import com.myspring.lessondemo.dto.ToDoDto;

@Document(indexName = "todo", type = "TODO")
public class ToDoEsEntity extends ToDoDto {
	@Id
	private String esId;

	public String getEsId() {
		return esId;
	}

	public void setEsId(String esId) {
		this.esId = esId;
	}

}
