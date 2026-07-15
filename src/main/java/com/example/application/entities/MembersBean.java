package com.example.application.entities;

import java.time.LocalDateTime;
import org.hibernate.annotations.CreationTimestamp;
import jakarta.persistence.*;
//import java.util.Objects;

@Entity
@Table(name = "MEMBERSBEAN")
public class MembersBean {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "iD")
    private Long id;
    
    @Column(name = "first_Name", length = 25)
    private String firstName;
    
    @Column(name = "last_Name", length = 25)
    private String lastName;
    
    
    @Column(name = "phone_Number", length = 15)
    private String phoneNumber;
    
    @Column(name = "e_Mail", length = 50)
    private String eMail;
    
   
    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
   private LocalDateTime createdAt;
    
   // @Column(name = "updated_at")
  //  private LocalDateTime updatedAt;
    
    // Default constructor (required by JPA)
    public MembersBean() {
    }
    
    // Parameterized constructor
    public void MemberBean(String firstName, String lastName, String phoneNumber, String eMail,
    	   	 Long id)
    		{
    	
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.eMail = eMail;        
        this.id = id;
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
   public Long getid() {
       return id;
   }
    
   public void setid(Long id) {
     this.id = id;
  }
    
    public String getfirstName() {
        return firstName;
    }
    
    public void setfirstName(String firstName) {
        this.firstName = firstName;
    }
    
    
    public String getlastName() {
        return lastName;
    }
    
    public void setlastName(String lastName) {
        this.lastName = lastName;
    }
       
    
    public String getphoneNumber() {
        return phoneNumber;
    }
    
    public void setphoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
    
    public String geteMail() {
        return eMail;
    }
    
    public void seteMail(String eMail) {
        this.eMail = eMail;
    }
    
    public LocalDateTime getcreatedAt() { return createdAt; }
  
 
  //  @Override
  //  public boolean equals(Object o) {
   //     if (this == o) return true;
   //     if (o == null || getClass() != o.getClass()) return false;
    //    MembersBean user = (MembersBean) o;
     //   return Objects.equals(Id, user.Id);
   // }
    
  //  @Override
  //  public int hashCode() {
  //      return Objects.hash(Id);
 //   }
    
    // toString()
    @Override
    public String toString() {
        return "MembersBean{" +
  //              "id=" + Id +
                ", username='" + firstName + '\'' +
               
                '}';
    }
}
