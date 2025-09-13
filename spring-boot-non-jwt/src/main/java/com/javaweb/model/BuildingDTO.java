package com.javaweb.model;

public class BuildingDTO {
    private String name;
    private Integer numberofbasement;
    private String address;
    private Integer districtid;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumberofbasement() {
        return numberofbasement;
    }
    public void setNumberofbasement(Integer numberofbasement) {
        this.numberofbasement = numberofbasement;
    }

    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getDistrictid() {
        return districtid;
    }
    public void setDistrictid(Integer districtid) {
        this.districtid = districtid;
    }
}
