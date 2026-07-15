package com.example.application.entities;


import java.time.LocalDateTime;
import java.time.LocalDate;

import jakarta.persistence.*;
import java.util.Objects;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "MEMBERSFEESBEAN")
public class MembershipFeesBean {
    
    @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long Id;
    

    @Column(name = "members_Id", length = 25)
    private String membersId;
    
    
    @Column(name = "full_Name", length = 25)
    private String fullName;
    
    
    @Column(name = "start_Date", length = 8)
    private LocalDate startDate;
    
    @Column(name = "end_Date", length = 8)
    private LocalDate endDate;
    
    @Column(name = "amount")
    private String amount;
    
    @Column(name = "payment_Type")
    private String paymentType;
    
    @Column(name = "phone_Number", length = 15)
    private String phoneNumber;
    
    @CreationTimestamp
    @Column(name = "created_At", updatable = false)
     private LocalDateTime createdAt;
    
   // @Column(name = "updated_at")
  //  private LocalDateTime updatedAt;
    
    // Default constructor (required by JPA)
    public MembershipFeesBean() {
    }
    
    // Parameterized constructor
    public MembershipFeesBean(String fullName, LocalDate startDate, LocalDate endDate, String amount,
    	       	String paymentType, String phoneNumber,
    	   	Long Id, String membersId)
    {
    	
        this.fullName = fullName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.amount = amount;
        this.paymentType = paymentType; 
        this.phoneNumber = phoneNumber;
        this.membersId = membersId;
     //   this.Id = UserId;
        }
    
    // Pre-persist callback
    @PrePersist
    protected void onCreate() {
       // createdAt = LocalDateTime.now();
      //  updatedAt = LocalDateTime.now();
    }
    
    // Pre-update callback
    @PreUpdate
    protected void onUpdate() {
    //    updatedAt = LocalDateTime.now();
    }
    
    // Getters and Setters
   public Long getId() {
    return Id;
   }
   
   
	  public void setId(Long Id) {
	     this.Id = Id;
	    }
	  
    
  public void setmembersId(String membersId) {
     this.membersId = membersId;;
    }
    
  public String getmembersId() {
	    return membersId;
	   }
	    
	 
	  
    public String getfullName() {
        return fullName;
    }
    
    public void setfullName(String fullName) {
        this.fullName = fullName;
    }
       
    
    public String getphoneNumber() {
        return phoneNumber;
    }
    
    public void setphoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
    public LocalDate getstartDate() {
        return startDate;
    }
    
    public void setstartDate(LocalDate startDate) {
        this.startDate = startDate;
    }
    
    public LocalDate getendDate() {
        return endDate;
    }
    
    public void setendDate(LocalDate endDate) {
        this.endDate = endDate;
    }
    
    public String getpaymentType() {
        return paymentType;
    }
    
    public void setpaymentType(String paymentType) {
        this.paymentType = paymentType;
    }
    
    public String getamount() {
        return amount;
    }
    
    public void setamount(String amount) {
        this.amount = amount;
    }
  
    
   
    
    public LocalDateTime getcreatedAt() {
        return createdAt;
    }
    
 //   public LocalDateTime getUpdatedAt() {
      //  return updatedAt;
  //  }
    
    // equals() and hashCode()
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MembershipFeesBean user = (MembershipFeesBean) o;
        return Objects.equals(Id, user.Id);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(Id);
    }
    
    // toString()
    @Override
    public String toString() {
        return "MembershipFeesBean{" +
                "id=" + Id +
                ", username='" + fullName + '\'' +
               
                '}';
    }
}
