package io.vimero.sovio.api.data;

import lombok.Data;

@Data
public class PersonData {

    private String name;
    private String fatherLastName;
    private String motherLastName;
    private String email;
    private String documentNumber;
    private Integer documentType;
    private Integer job;
    private Integer gender;
    private String birthdayDate;
    private Integer level;
    private String mobile;
    private String address;
    private Integer geocode;
    private Integer country;
    private Integer type;
    private String status;
    private Integer createdUser;

}
