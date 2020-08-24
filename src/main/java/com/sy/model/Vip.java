package com.sy.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "order_user")
public class Vip {
    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;
    private Integer orderinfoId;
    private String rolename;
    private Double rolePrice;
    private Integer roleId;
    private String createBy;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern ="yyyy-MM-dd HH:mm:ss")
    private Date createDateTime;

    @Override
    public String toString() {
        return "Vip{" +
                "id=" + id +
                ", orderinfoId=" + orderinfoId +
                ", rolename='" + rolename + '\'' +
                ", rolePrice=" + rolePrice +
                ", roleId=" + roleId +
                ", createBy='" + createBy + '\'' +
                ", createDateTime=" + createDateTime +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrderinfoId() {
        return orderinfoId;
    }

    public void setOrderinfoId(Integer orderinfoId) {
        this.orderinfoId = orderinfoId;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    public Double getRolePrice() {
        return rolePrice;
    }

    public void setRolePrice(Double rolePrice) {
        this.rolePrice = rolePrice;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(Date createDateTime) {
        this.createDateTime = createDateTime;
    }
}
