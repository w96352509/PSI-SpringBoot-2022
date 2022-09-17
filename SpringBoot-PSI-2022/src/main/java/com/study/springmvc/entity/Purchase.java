package com.study.springmvc.entity;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "purchase")
public class Purchase {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
	private Date date;
	
	@ManyToOne
	@JoinColumn(name = "supplier_id" , referencedColumnName = "id")
	private Supplier supplier;
	
	@ManyToOne
	@JoinColumn(name = "employee_id" , referencedColumnName = "id")
	private Employee employee;

	@OneToMany(mappedBy = "purchase")
	@OrderBy("id ASC")
	private List<PurchaseItem> purchaseItems = new LinkedList<>(); 
	
	public int getTotal() {
		Integer total = purchaseItems.stream().mapToInt(c -> c.getAmount() * c.getProduct().getCost()).sum();
	    // 訂單 size 如果 = 0
		if(purchaseItems.size() == 0) {
	    	return 0;
	    }else {
			return total;
		}
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public List<PurchaseItem> getPurchaseItems() {
		return purchaseItems;
	}

	public void setPurchaseItems(List<PurchaseItem> purchaseItems) {
		this.purchaseItems = purchaseItems;
	}
	
	
}
