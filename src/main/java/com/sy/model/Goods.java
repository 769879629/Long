package com.sy.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "GOODS_INFO")
public class Goods {

    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;
    private String goodsSN;
    private String goodsName;
    private String goodsFormat;
    private Double marketPrice;
    private Double realPrice;
    private Integer state;
    private String note;
    private Integer num;
    private String unit;



    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern ="yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern ="yyyy-MM-dd HH:mm:ss")
    private Date lastUpdateTime;
    private String createdBy;

    public Goods() {
    }

    public Goods(String goodsSN, String goodsFormat, Double markePrice, Double realPrice, Integer state, String note, Integer num, String unit, Date createTime, Date lastUpdateTime, String createdBy) {
        this.goodsSN = goodsSN;
        this.goodsFormat = goodsFormat;
        this.marketPrice = markePrice;
        this.realPrice = realPrice;
        this.state = state;
        this.note = note;
        this.num = num;
        this.unit = unit;
        this.createTime = createTime;
        this.lastUpdateTime = lastUpdateTime;
        this.createdBy = createdBy;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGoodsSN() {
        return goodsSN;
    }

    public void setGoodsSN(String goodsSN) {
        this.goodsSN = goodsSN;
    }

    public String getGoodsFormat() {
        return goodsFormat;
    }

    public void setGoodsFormat(String goodsFormat) {
        this.goodsFormat = goodsFormat;
    }

    public Double getMarketPrice() {
        return marketPrice;
    }

    public void setMarketPrice(Double markePrice) {
        this.marketPrice = markePrice;
    }

    public Double getRealPrice() {
        return realPrice;
    }

    public void setRealPrice(Double realPrice) {
        this.realPrice = realPrice;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", goodsSN='" + goodsSN + '\'' +
                ", goodsName='" + goodsName + '\'' +
                ", goodsFormat='" + goodsFormat + '\'' +
                ", marketPrice=" + marketPrice +
                ", realPrice=" + realPrice +
                ", state=" + state +
                ", note='" + note + '\'' +
                ", num=" + num +
                ", unit='" + unit + '\'' +
                ", createTime=" + createTime +
                ", lastUpdateTime=" + lastUpdateTime +
                ", createdBy='" + createdBy + '\'' +
                '}';
    }
}
