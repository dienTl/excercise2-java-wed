package com.javaweb.model;

public class RequestBuilding {
	 	private String name;              // Tên sản phẩm (tòa nhà)
	    private String direction;
	    private String address;           // Địa chỉ
	    private Integer numberofbasement; // Số tầng hầm
	    private String managername;       // Tên quản lý
	    private String managerphonenumber;      // Số điện thoại
	    private Integer floorarea;        // D.T sàn
	    private String emptyarea;        // D.T trống
	    private Integer rentprice;        // Giá thuê
	    private Integer servicefee;       // Phí dịch vụ
	    private Double brokeragefee;     // Phí môi giới
	    private String rentarea;
	    private Integer districtid ;
	    private Integer staffid ;
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
		public Integer getNumberofbasement() {
			return numberofbasement;
		}
		public void setNumberofbasement(Integer numberofbasement) {
			this.numberofbasement = numberofbasement;
		}
		public String getManagername() {
			return managername;
		}
		public void setManagername(String managername) {
			this.managername = managername;
		}
		public String getManagerphonenumber() {
			return managerphonenumber;
		}
		public void setManagerphonenumber(String managerphonenumber) {
			this.managerphonenumber = managerphonenumber;
		}
		public Integer getFloorarea() {
			return floorarea;
		}
		public void setFloorarea(Integer floorarea) {
			this.floorarea = floorarea;
		}
		public String getEmptyarea() {
			return emptyarea;
		}
		public void setEmptyarea(String emptyarea) {
			this.emptyarea = emptyarea;
		}
		public Integer getRentprice() {
			return rentprice;
		}
		public void setRentprice(Integer rentprice) {
			this.rentprice = rentprice;
		}
		public Integer getServicefee() {
			return servicefee;
		}
		public void setServicefee(Integer servicefee) {
			this.servicefee = servicefee;
		}
		public Double getBrokeragefee() {
			return brokeragefee;
		}
		public void setBrokeragefee(Double brokeragefee) {
			this.brokeragefee = brokeragefee;
		}
		public String getRentarea() {
			return rentarea;
		}
		public void setRentarea(String rentarea) {
			this.rentarea = rentarea;
		}
		public Integer getDistrictid() {
			return districtid;
		}
		public void setDistrictid(Integer districtid) {
			this.districtid = districtid;
		}
		public Integer getStaffid() {
			return staffid;
		}
		public void setStaffid(Integer staffid) {
			this.staffid = staffid;
		}
	    
}
