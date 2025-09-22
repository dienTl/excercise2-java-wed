package com.javaweb.Builder;

import java.util.ArrayList;
import java.util.List;

public class BuildingSearchBuilder {
    private final String name;
    private final Integer floorArea;
    private final String ward;
    private final String street;
    private final String districtId;
    private final Integer numberOfBasement;
    private final List<String> typeCode;
    private final String managerName;
    private final String managerPhone;
    private final Integer rentPriceFrom;
    private final Integer rentPriceTo;
    private final Integer areaFrom;
    private final Integer areaTo;
    private final Integer staffId;
    private final Integer cafee;
    private final Integer brokerageFee;
    private final String direction;
    private final Integer serviceFee;

    // Constructor nhận Builder
    private BuildingSearchBuilder(Builder builder) {
        this.name = builder.name;
        this.floorArea = builder.floorArea;
        this.ward = builder.ward;
        this.street = builder.street;
        this.districtId = builder.districtId;
        this.numberOfBasement = builder.numberOfBasement;
        this.typeCode = builder.typeCode;
        this.managerName = builder.managerName;
        this.managerPhone = builder.managerPhone;
        this.rentPriceFrom = builder.rentPriceFrom;
        this.rentPriceTo = builder.rentPriceTo;
        this.areaFrom = builder.areaFrom;
        this.areaTo = builder.areaTo;
        this.staffId = builder.staffId;
        this.brokerageFee = builder.brokerageFee;
        this.direction = builder.direction;
        this.serviceFee = builder.serviceFee;
        this.cafee = builder.carfee;
    }

    // Getter
    
    public String getName() { return name; }
    public Integer getFloorArea() { return floorArea; }
    public String getWard() { return ward; }
    public String getStreet() { return street; }
    public String getDistrictCode() { return districtId; }
    public Integer getNumberOfBasement() { return numberOfBasement; }
    public List<String> getTypeCode() { return typeCode; }
    public String getManagerName() { return managerName; }
    public String getManagerPhone() { return managerPhone; }
    public Integer getRentPriceFrom() { return rentPriceFrom; }
    public Integer getRentPriceTo() { return rentPriceTo; }
    public Integer getAreaFrom() { return areaFrom; }
    public Integer getAreaTo() { return areaTo; }
    public Integer getStaffId() { return staffId; }
    public Integer getBrokerageFee() { return brokerageFee; }
    public String getDirection() { return direction; }
    public Integer getServiceFee() { return serviceFee; }
    
    public String getDistrictId() {
		return districtId;
	}

	public Integer getCafee() {
		return cafee;
	}

	// Builder
    public static class Builder {
        private String name;
        private Integer floorArea;
        private String ward;
        private String street;
        private String districtId;
        private Integer numberOfBasement;
        private List<String> typeCode = new ArrayList<>();
        private String managerName;
        private String managerPhone;
        private Integer rentPriceFrom;
        private Integer rentPriceTo;
        private Integer areaFrom;
        private Integer areaTo;
        private Integer staffId;
        private Integer brokerageFee;
        private String direction;
        private Integer carfee ;
        private Integer serviceFee;

        public Builder setName(String name) {
            this.name = name; return this;
        }
        public Builder setFloorArea(Integer floorArea) {
            this.floorArea = floorArea; return this;
        }
        public Builder setWard(String ward) {
            this.ward = ward; return this;
        }
        public Builder setStreet(String street) {
            this.street = street; return this;
        }
        public Builder setDistrictCode(String districtId) {
            this.districtId = districtId; return this;
        }
        public Builder setNumberOfBasement(Integer numberOfBasement) {
            this.numberOfBasement = numberOfBasement; return this;
        }
        public Builder setTypeCode(List<String> typeCode) {
            this.typeCode = typeCode; return this;
        }
        public Builder setManagerName(String managerName) {
            this.managerName = managerName; return this;
        }
        public Builder setManagerPhone(String managerPhone) {
            this.managerPhone = managerPhone; return this;
        }
        public Builder setRentPriceFrom(Integer rentPriceFrom) {
            this.rentPriceFrom = rentPriceFrom; return this;
        }
        public Builder setRentPriceTo(Integer rentPriceTo) {
            this.rentPriceTo = rentPriceTo; return this;
        }
        public Builder setAreaFrom(Integer areaFrom) {
            this.areaFrom = areaFrom; return this;
        }
        public Builder setAreaTo(Integer areaTo) {
            this.areaTo = areaTo; return this;
        }
        public Builder setStaffId(Integer staffId) {
            this.staffId = staffId; return this;
        }
        public Builder setBrokerageFee(Integer brokerageFee) {
            this.brokerageFee = brokerageFee; return this;
        }
        public Builder setDirection(String direction) {
            this.direction = direction; return this;
        }
        public Builder setServiceFee(Integer serviceFee) {
            this.serviceFee = serviceFee; return this;
        }

        public BuildingSearchBuilder build() {
            return new BuildingSearchBuilder(this);
        }
		public void setDistrictId(String districtId) {
			this.districtId = districtId;
		}
		public void setCarfee(Integer carfee) {
			this.carfee = carfee;
		}
        
        
    }
}
