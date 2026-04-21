package application.FarmCrew.DTO;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class PaymentRequest {

    @NotNull
    private String farmerId;

    @NotNull
    private String laborId;

    private String agentId; // optional

    @NotNull
    private String workId;

    @Positive
    private double amount;

    @NotNull
    private String paymentMethod; // UPI or CASH

    private String farmerUpiId;
    private String laborUpiId;
    private String agentUpiId;

    // getters & setters
    public String getFarmerId() { return farmerId; }
    public void setFarmerId(String farmerId) { this.farmerId = farmerId; }

    public String getLaborId() { return laborId; }
    public void setLaborId(String laborId) { this.laborId = laborId; }

    public String getAgentId() { return agentId; }
    public void setAgentId(String agentId) { this.agentId = agentId; }

    public String getWorkId() { return workId; }
    public void setWorkId(String workId) { this.workId = workId; }

    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }

    public String getPaymentMethod() { return paymentMethod; }
    public void setPaymentMethod(String paymentMethod) { this.paymentMethod = paymentMethod; }

    public String getFarmerUpiId() { return farmerUpiId; }
    public void setFarmerUpiId(String farmerUpiId) { this.farmerUpiId = farmerUpiId; }

    public String getLaborUpiId() { return laborUpiId; }
    public void setLaborUpiId(String laborUpiId) { this.laborUpiId = laborUpiId; }

    public String getAgentUpiId() { return agentUpiId; }
    public void setAgentUpiId(String agentUpiId) { this.agentUpiId = agentUpiId; }
}