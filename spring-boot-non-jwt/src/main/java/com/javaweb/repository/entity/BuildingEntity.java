package com.javaweb.repository.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "building")
public class BuildingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    
    @ManyToOne
    @JoinColumn(name = "districtid", insertable = false, updatable = false)
    private DistricEntity district;

    
    @Column(name = "districtid")
    private Integer districtId;

    @OneToMany(mappedBy = "building", fetch = FetchType.LAZY)
    private List<RentAreaEntity> items = new ArrayList<>();

    @Column(name = "name")
    private String name;

    @Column(name = "street")
    private String street;

    @Column(name = "ward")
    private String ward;

    @Column(name = "structure")
    private String structure;

    @Column(name = "numberofbasement")
    private Integer numberOfBasement;

    @Column(name = "floorarea")
    private Integer floorarea;

    @Column(name = "direction")
    private String direction;

    @Column(name = "level")
    private Integer level;

    @Column(name = "emptyarea")
    private String emptyarea;

    @Column(name = "rentprice")
    private Integer rentprice;

    @Column(name = "rentpricedescription")
    private String rentpricedescription;

    @Column(name = "servicefee")
    private Integer servicefee;

    @Column(name = "carfee")
    private Integer carfee;

    @Column(name = "motorbikefee")
    private Integer motorbikefee;

    @Column(name = "overtimefee")
    private Integer overtimefee;

    @Column(name = "waterfee")
    private Integer waterfee;

    @Column(name = "electricityfee")
    private Integer electricityfee;

    @Column(name = "deposit")
    private Integer deposit;

    @Column(name = "payment")
    private Integer payment;

    @Column(name = "renttime")
    private String renttime;

    @Column(name = "decorationtime")
    private String decorationtime;

    @Column(name = "brokeragefee")
    private Double brokeragefee;

    @Column(name = "note")
    private String note;

    @Column(name = "linkofbuilding")
    private String linkofbuilding;

    @Column(name = "createdby")
    private Integer createdby;

    @Column(name = "modifiedby")
    private Integer modifiedby;

    @Column(name = "managername")
    private String managername;

    @Column(name = "managerphonenumber")
    private String managephonenumber;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public DistricEntity getDistrict() {
		return district;
	}

	public void setDistrict(DistricEntity district) {
		this.district = district;
	}

	public Integer getDistrictId() {
		return districtId;
	}

	public void setDistrictId(Integer districtId) {
		this.districtId = districtId;
	}

	public List<RentAreaEntity> getItems() {
		return items;
	}

	public void setItems(List<RentAreaEntity> items) {
		this.items = items;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getWard() {
		return ward;
	}

	public void setWard(String ward) {
		this.ward = ward;
	}

	public String getStructure() {
		return structure;
	}

	public void setStructure(String structure) {
		this.structure = structure;
	}

	public Integer getNumberOfBasement() {
		return numberOfBasement;
	}

	public void setNumberOfBasement(Integer numberOfBasement) {
		this.numberOfBasement = numberOfBasement;
	}

	public Integer getFloorarea() {
		return floorarea;
	}

	public void setFloorarea(Integer floorarea) {
		this.floorarea = floorarea;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
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

	public String getRentpricedescription() {
		return rentpricedescription;
	}

	public void setRentpricedescription(String rentpricedescription) {
		this.rentpricedescription = rentpricedescription;
	}

	public Integer getServicefee() {
		return servicefee;
	}

	public void setServicefee(Integer servicefee) {
		this.servicefee = servicefee;
	}

	public Integer getCarfee() {
		return carfee;
	}

	public void setCarfee(Integer carfee) {
		this.carfee = carfee;
	}

	public Integer getMotorbikefee() {
		return motorbikefee;
	}

	public void setMotorbikefee(Integer motorbikefee) {
		this.motorbikefee = motorbikefee;
	}

	public Integer getOvertimefee() {
		return overtimefee;
	}

	public void setOvertimefee(Integer overtimefee) {
		this.overtimefee = overtimefee;
	}

	public Integer getWaterfee() {
		return waterfee;
	}

	public void setWaterfee(Integer waterfee) {
		this.waterfee = waterfee;
	}

	public Integer getElectricityfee() {
		return electricityfee;
	}

	public void setElectricityfee(Integer electricityfee) {
		this.electricityfee = electricityfee;
	}

	public Integer getDeposit() {
		return deposit;
	}

	public void setDeposit(Integer deposit) {
		this.deposit = deposit;
	}

	public Integer getPayment() {
		return payment;
	}

	public void setPayment(Integer payment) {
		this.payment = payment;
	}

	public String getRenttime() {
		return renttime;
	}

	public void setRenttime(String renttime) {
		this.renttime = renttime;
	}

	public String getDecorationtime() {
		return decorationtime;
	}

	public void setDecorationtime(String decorationtime) {
		this.decorationtime = decorationtime;
	}

	public Double getBrokeragefee() {
		return brokeragefee;
	}

	public void setBrokeragefee(Double brokeragefee) {
		this.brokeragefee = brokeragefee;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getLinkofbuilding() {
		return linkofbuilding;
	}

	public void setLinkofbuilding(String linkofbuilding) {
		this.linkofbuilding = linkofbuilding;
	}

	public Integer getCreatedby() {
		return createdby;
	}

	public void setCreatedby(Integer createdby) {
		this.createdby = createdby;
	}

	public Integer getModifiedby() {
		return modifiedby;
	}

	public void setModifiedby(Integer modifiedby) {
		this.modifiedby = modifiedby;
	}

	public String getManagername() {
		return managername;
	}

	public void setManagername(String managername) {
		this.managername = managername;
	}

	public String getManagephonenumber() {
		return managephonenumber;
	}

	public void setManagephonenumber(String managephonenumber) {
		this.managephonenumber = managephonenumber;
	}

    // --- Getters and Setters ---

  
}
