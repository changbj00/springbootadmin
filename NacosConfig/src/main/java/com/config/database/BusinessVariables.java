package com.config.database;


import lombok.Data;

@Data
public class BusinessVariables {
    private int id;
    private String project_name;
    private int project_id;
    private int type;
    private String testplan_name;
    private int testplan_id;
    private String variable_key;
    private String variable_value;
    private String remark;
    private String testcase;
    private String createtime;
    private String updatetime;


}
