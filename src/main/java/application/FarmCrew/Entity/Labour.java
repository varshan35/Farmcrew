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
    private String role;
    private int age;
    private String contact;
    private String place;
    private String pan;
    private String aadhar;
    private String labor_upiId;
}
