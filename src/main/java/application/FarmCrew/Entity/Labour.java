package application.FarmCrew.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "labour")
public class Labour
{
    @Id
    @JsonSerialize(using = ToStringSerializer.class)
    private ObjectId laborId;

    @NonNull
    private String name;
    private String gender;
    private String pwd;

    public ObjectId getLaborId() {
        return laborId;
    }

    public void setLaborId(ObjectId laborId) {
        this.laborId = laborId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getPan() {
        return pan;
    }

    public void setPan(String pan) {
        this.pan = pan;
    }

    public String getAadhar() {
        return aadhar;
    }

    public void setAadhar(String aadhar) {
        this.aadhar = aadhar;
    }

    public String getLabor_upiId() {
        return labor_upiId;
    }

    public void setLabor_upiId(String labor_upiId) {
        this.labor_upiId = labor_upiId;
    }

    private String role;
    private int age;
    private String contact;
    private String place;
    private String pan;
    private String aadhar;
    private String labor_upiId;


}
