package com.sr.groupbynumber;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class allgroups {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    Integer ID;
    Integer gorupID;
    Integer count;
    Integer NumberIneachGroup;
    Integer NumberofMembers;

    public Integer getgroupID() {
        return gorupID;
    }
    public void setgroupID(Integer gorupID) {
        this.gorupID = gorupID;
    }


    public Integer getCount() {
        return count;
    }

    public void setCount( Integer count) {
         this.count =count;
    }

    public Integer getNumberIneachGroup() {
        return NumberIneachGroup;
    }
    public void setNumberIneachGroup(Integer numberIneachGroup) {
        NumberIneachGroup = numberIneachGroup;
    }
    public Integer getNumberofMembers() {
        return NumberofMembers;
    }
    public void setNumberofMembers(Integer numberofMembers) {
        NumberofMembers = numberofMembers;
    }
    
}
