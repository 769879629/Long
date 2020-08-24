package com.sy.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "AU_ROLE")
public class Dd {

    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;
    private String typeCode;
    private String typeName;
    private Integer valueId;
    private String valueName;

    @Override
    public String toString() {
        return "Dd{" +
                "id=" + id +
                ", typeCode='" + typeCode + '\'' +
                ", typeName='" + typeName + '\'' +
                ", valueId=" + valueId +
                ", valueName='" + valueName + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Integer getValueId() {
        return valueId;
    }

    public void setValueId(Integer valueId) {
        this.valueId = valueId;
    }

    public String getValueName() {
        return valueName;
    }

    public void setValueName(String valueName) {
        this.valueName = valueName;
    }

    public Dd(String typeCode, String typeName, Integer valueId, String valueName) {
        this.typeCode = typeCode;
        this.typeName = typeName;
        this.valueId = valueId;
        this.valueName = valueName;
    }

    public Dd() {
    }
}
