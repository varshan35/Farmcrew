package application.FarmCrew.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import tools.jackson.databind.annotation.JsonSerialize;
import tools.jackson.databind.ser.std.ToStringSerializer;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "payments")
public class Payment
{
    @Id
    @JsonSerialize(using = ToStringSerializer.class)
    private ObjectId paymentid;
    @NonNull
    private ObjectId workId;
    private ObjectId farmerId;
    private ObjectId laborId;
    private ObjectId agentId;// optional

    private double amount;
    private double agentCommission;
    private double laborNetAmount;

    private String farmerUpiId;
    private String laborUpiId;
    private String agentUpiId;

    private PaymentMethod paymentMethod; // ✅ CASH or UPI
    private String transactionId;        // optional, for UPI reference
    private PaymentStatus paymentStatus; // PENDING, COMPLETED, FAILED

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getAgentUpiId() {
        return agentUpiId;
    }

    public void setAgentUpiId(String agentUpiId) {
        this.agentUpiId = agentUpiId;
    }

    public String getLaborUpiId() {
        return laborUpiId;
    }

    public void setLaborUpiId(String laborUpiId) {
        this.laborUpiId = laborUpiId;
    }

    public String getFarmerUpiId() {
        return farmerUpiId;
    }

    public void setFarmerUpiId(String farmerUpiId) {
        this.farmerUpiId = farmerUpiId;
    }

    public double getLaborNetAmount() {
        return laborNetAmount;
    }

    public void setLaborNetAmount(double laborNetAmount) {
        this.laborNetAmount = laborNetAmount;
    }

    public double getAgentCommission() {
        return agentCommission;
    }

    public void setAgentCommission(double agentCommission) {
        this.agentCommission = agentCommission;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public ObjectId getAgentId() {
        return agentId;
    }

    public void setAgentId(ObjectId agentId) {
        this.agentId = agentId;
    }

    public ObjectId getLaborId() {
        return laborId;
    }

    public void setLaborId(ObjectId laborId) {
        this.laborId = laborId;
    }

    public ObjectId getFarmerId() {
        return farmerId;
    }

    public void setFarmerId(ObjectId farmerId) {
        this.farmerId = farmerId;
    }

    public ObjectId getWorkId() {
        return workId;
    }

    public void setWorkId(ObjectId workId) {
        this.workId = workId;
    }

    public ObjectId getPaymentid() {
        return paymentid;
    }

    public void setPaymentid(ObjectId paymentid) {
        this.paymentid = paymentid;
    }

    private LocalDateTime timestamp;

}
