package ch.cresoft.cresoftvue.model;

import lombok.Data;

import java.util.Date;

@Data
public class Adviser {
    private Integer id;
    private String code;
    private String name;
    private String shortName;
    private Integer ddlId;
    private String department;
    private String telNumber;
    private Integer ateId;
    private String username;
    private String recTyp;
    private String departmentId;
    private Integer recordStatus;
    private String requestToDelete;
    private String requestUser;
    private Date requestDate;
    private String approveUser;
    private Date approveDate;
    private String region;
    private String market;
}
