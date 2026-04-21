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

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "agent")
public class Agent
{

    @Id
    @JsonSerialize(using = ToStringSerializer.class)
    private ObjectId agentId;

    @NonNull
    private String name;
    private String pwd;
    private String contactInfo;
    private double commissionRate; // percentage
    private double totalEarnings;
    private List<String> connectedFarmers;

    public ObjectId getAgentId() {
        return agentId;
    }

    public void setAgentId(ObjectId agentId) {
        this.agentId = agentId;
    }

    public String getName() {
        return name;
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

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public double getCommissionRate() {
        return commissionRate;
    }

    public void setCommissionRate(double commissionRate) {
        this.commissionRate = commissionRate;
    }

    public double getTotalEarnings() {
        return totalEarnings;
    }

    public void setTotalEarnings(double totalEarnings) {
        this.totalEarnings = totalEarnings;
    }

    public List<String> getConnectedFarmers() {
        return connectedFarmers;
    }

    public void setConnectedFarmers(List<String> connectedFarmers) {
        this.connectedFarmers = connectedFarmers;
    }

    public List<String> getConnectedLabors() {
        return connectedLabors;
    }

    public void setConnectedLabors(List<String> connectedLabors) {
        this.connectedLabors = connectedLabors;
    }

    public String getAgent_upiId() {
        return agent_upiId;
    }

    public void setAgent_upiId(String agent_upiId) {
        this.agent_upiId = agent_upiId;
    }

    private List<String> connectedLabors;
    private String agent_upiId;

}
