package us.codecraft.webmagic.samples;

public class Ershoufang {

    private String title; //房源标题

    private String location; //房源地点

    private String desc; //房源简介

    private String price; //总价

    private String houseType; //格局 三室一厅

    private String floor; //楼层

    private String houseAge; //建筑年代(房龄)

    private String unitPrice; //单价

    private String areaByChina; //地域 e.g. 东北 华北

    private String size; //大小 建筑面积xx平米

    private String renovationCondition; //装修状况  精装

    private String localArea; //小区

    private String houseCode; //房源编码 七位数字 3133014

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getHouseAge() {
        return houseAge;
    }

    public void setHouseAge(String houseAge) {
        this.houseAge = houseAge;
    }

    public String getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(String unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getAreaByChina() {
        return areaByChina;
    }

    public void setAreaByChina(String areaByChina) {
        this.areaByChina = areaByChina;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getRenovationCondition() {
        return renovationCondition;
    }

    public void setRenovationCondition(String renovationCondition) {
        this.renovationCondition = renovationCondition;
    }

    public String getLocalArea() {
        return localArea;
    }

    public void setLocalArea(String localArea) {
        this.localArea = localArea;
    }

    public String getHouseCode() {
        return houseCode;
    }

    public void setHouseCode(String houseCode) {
        this.houseCode = houseCode;
    }

    public String getHouseType() {
        return houseType;
    }

    public void setHouseType(String houseType) {
        this.houseType = houseType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "二手房{" +
                "标题='" + title + '\'' +
                ", 地点='" + location + '\'' +
                ", 描述='" + desc + '\'' +
                ", 总价='" + price + '\'' +
                ", 格局='" + houseType + '\'' +
                ", 楼层='" + floor + '\'' +
                ", 房龄='" + houseAge + '\'' +
                ", 单价='" + unitPrice + '\'' +
                ", 地域='" + areaByChina + '\'' +
                ", 大小='" + size + '\'' +
                ", 装修状况='" + renovationCondition + '\'' +
                ", 小区='" + localArea + '\'' +
                ", 房源码='" + houseCode + '\'' +
                '}';
    }
}
