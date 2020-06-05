package com.integration.system;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class SystemMetaData {
    private Integer Id;
    private String systemId;
    private Set<SystemParameter> parameterSet;
}
