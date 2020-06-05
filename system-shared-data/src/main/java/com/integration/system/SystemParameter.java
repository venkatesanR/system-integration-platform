package com.integration.system;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SystemParameter {
    private Integer id;
    private String systemId;
    private String name;
    private String value;
}