package com.javaweb.model;

public class BuildingDTO {
	    private String name;              // Tên sản phẩm (tòa nhà)
	    private String direction;
	    private String address;           // Địa chỉ
	    private Integer numberOfBasement; // Số tầng hầm
	    private String managerName;       // Tên quản lý
	    private String managerPhone;      // Số điện thoại
	    private Integer floorArea;        // D.T sàn
	    private Integer emptyArea;        // D.T trống
	    private Integer rentPrice;        // Giá thuê
	    private Integer serviceFee;       // Phí dịch vụ
	    private Double brokerageFee;     // Phí môi giới
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getDirection() {
			return direction;
		}
		public void setDirection(String direction) {
			this.direction = direction;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public Integer getNumberOfBasement() {
			return numberOfBasement;
		}
		public void setNumberOfBasement(Integer numberOfBasement) {
			this.numberOfBasement = numberOfBasement;
		}
		public String getManagerName() {
			return managerName;
		}
		public void setManagerName(String managerName) {
			this.managerName = managerName;
		}
		public String getManagerPhone() {
			return managerPhone;
		}
		public void setManagerPhone(String managerPhone) {
			this.managerPhone = managerPhone;
		}
		public Integer getFloorArea() {
			return floorArea;
		}
		public void setFloorArea(Integer floorArea) {
			this.floorArea = floorArea;
		}
		public Integer getEmptyArea() {
			return emptyArea;
		}
		public void setEmptyArea(Integer emptyArea) {
			this.emptyArea = emptyArea;
		}
		public Integer getRentPrice() {
			return rentPrice;
		}
		public void setRentPrice(Integer rentPrice) {
			this.rentPrice = rentPrice;
		}
		public Integer getServiceFee() {
			return serviceFee;
		}
		public void setServiceFee(Integer serviceFee) {
			this.serviceFee = serviceFee;
		}
		public Double getBrokerageFee() {
			return brokerageFee;
		}
		public void setBrokerageFee(Double brokerageFee) {
			this.brokerageFee = brokerageFee;
		}
	
	    
		
		
   
}
