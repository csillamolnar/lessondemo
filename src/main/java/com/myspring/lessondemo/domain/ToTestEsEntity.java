package com.myspring.lessondemo.domain;

import com.myspring.lessondemo.dto.ToTestDto;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "totest", type = "TOTEST")
public class ToTestEsEntity extends ToTestDto {
    @Id
    private String esId;

    public String getEsId() {
        return esId;
    }

    public void setEsId(String esId) {
        this.esId = esId;
    }

}
