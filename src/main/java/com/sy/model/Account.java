package com.sy.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.elasticsearch.search.DocValueFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "ACCOUNT_DETAIL")
public class  Account {
    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;
    private Integer accountId;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern ="yyyy-MM-dd HH:mm:ss")
    private Date accountDate;
    private Double moneyIn;
    private Double moneyOut;
    private Integer type;
    private String otherAccountId;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public Date getAccountDate() {
        return accountDate;
    }

    public void setAccountDate(Date accountDate) {
        this.accountDate = accountDate;
    }

    public Double getMoneyIn() {
        return moneyIn;
    }

    public void setMoneyIn(Double moneyIn) {
        this.moneyIn = moneyIn;
    }

    public Double getMoneyOut() {
        return moneyOut;
    }

    public void setMoneyOut(Double moneyOut) {
        this.moneyOut = moneyOut;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getOtherAccountId() {
        return otherAccountId;
    }

    public void setOtherAccountId(String otherAccountId) {
        this.otherAccountId = otherAccountId;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", accountId=" + accountId +
                ", accountDate=" + accountDate +
                ", moneyIn=" + moneyIn +
                ", moneyOut=" + moneyOut +
                ", type=" + type +
                ", otherAccountId='" + otherAccountId + '\'' +
                '}';
    }
}
