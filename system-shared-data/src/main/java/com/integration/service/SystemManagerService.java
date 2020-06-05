package com.integration.service;

import com.integration.system.RouteUpdateResponse;
import com.integration.system.SystemMetaData;

import java.util.List;

public interface SystemManagerService {
    SystemMetaData getSystemById(String systemId);

    void subscribe(String systemId);

    RouteUpdateResponse emitSystemDataChange();

    RouteUpdateResponse emitSystemDataChange(List<String> system);
}
