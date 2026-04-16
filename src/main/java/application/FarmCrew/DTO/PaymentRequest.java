package application.FarmCrew.DTO;

public class PaymentRequest
{
    private String farmerId;
    private String laborId;
    private String agentId; // optional
    private String workId;

    private double amount;

    private String paymentMethod;   // "UPI" or "CASH"

    public String getFarmerUpiId() {
        return farmerUpiId;
    }

    public void setFarmerUpiId(String farmerUpiId) {
        this.farmerUpiId = farmerUpiId;
    }

    public String getLaborUpiId() {
        return laborUpiId;
    }

    public void setLaborUpiId(String laborUpiId) {
        this.laborUpiId = laborUpiId;
    }

    public String getAgentUpiId() {
        return agentUpiId;
    }

    public void setAgentUpiId(String agentUpiId) {
        this.agentUpiId = agentUpiId;
    }

    private String farmerUpiId;
    private String laborUpiId;
    private String agentUpiId;       // optional, if UPI used
    private String transactionId;// optional, for UPI reference


    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getWorkId() {
        return workId;
    }

    public void setWorkId(String workId) {
        this.workId = workId;
    }

    public String getFarmerId() {
        return farmerId;
    }

    public void setFarmerId(String farmerId) {
        this.farmerId = farmerId;
    }

    public String getLaborId() {
        return laborId;
    }

    public void setLaborId(String laborId) {
        this.laborId = laborId;
    }

    public String getAgentId() {
        return agentId;
    }

    public void setAgentId(String agentId) {
        this.agentId = agentId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
