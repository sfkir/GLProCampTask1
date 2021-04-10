package model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserModel {

    private int id;
    private String name;
    private String email;
    private String gender;
    private String status;
    private String created_at;
    private String updated_at;

}
