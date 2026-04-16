package application.FarmCrew.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import tools.jackson.databind.annotation.JsonSerialize;
import tools.jackson.databind.ser.std.ToStringSerializer;


@Data
@NoArgsConstructor
@Document(collection = "work")
public class Work {
    @Id
    @JsonSerialize(using = ToStringSerializer.class)
    private ObjectId workId;



    public ObjectId getFarmerId() {
        return farmerId;
    }

    public ObjectId getWorkId() {
        return workId;
    }

    public void setWorkId(ObjectId workId) {
        this.workId = workId;
    }

    public void setFarmerId(ObjectId farmerId) {
        this.farmerId = farmerId;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getTypeOfWork() {
        return typeOfWork;
    }

    public void setTypeOfWork(String typeOfWork) {
        this.typeOfWork = typeOfWork;
    }

    public WorkStatus getWorkStatus() {
        return workStatus;
    }

    public void setWorkStatus(WorkStatus workStatus) {
        this.workStatus = workStatus;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    @NonNull
    @JsonSerialize(using = ToStringSerializer.class)
    private ObjectId farmerId;
    @NonNull
    String duration;
    private String typeOfWork;
    @NonNull
    private WorkStatus workStatus;
    @NonNull
    private PaymentStatus paymentStatus;
}