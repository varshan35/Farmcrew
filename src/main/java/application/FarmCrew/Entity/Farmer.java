package application.FarmCrew.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import tools.jackson.databind.annotation.JsonSerialize;
import tools.jackson.databind.ser.std.ToStringSerializer;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "farmer")
public class Farmer {


    public String getName() {
        return name;
    }

    public ObjectId getFarmer_id() {
        return farmer_id;
    }

    public void setFarmer_id(ObjectId farmer_id) {
        this.farmer_id = farmer_id;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getFarmer_upiId() {
        return farmer_upiId;
    }

    public void setFarmer_upiId(String farmer_upiId) {
        this.farmer_upiId = farmer_upiId;
    }


    @Id
    @JsonSerialize(using = ToStringSerializer.class)
    private ObjectId farmer_id;


    @NonNull
    private String name;
    private String gender;
    private String pwd;
    private String role;
    private int age;
    private String contact;
    private String address;
    private String pan;
    private String aadhar;
    private String farmer_upiId;
}
