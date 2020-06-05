package com.integration.system;

import com.integration.service.SystemManagerService;
import org.apache.camel.builder.RouteBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

public abstract class RouteSubscriber extends RouteBuilder {
    private static final Logger logger = LoggerFactory.getLogger(RouteSubscriber.class);
    private final SystemManagerService systemManagerService;

    protected RouteSubscriber(final SystemManagerService systemManagerService) {
        String systemId = systemId();
        this.systemManagerService = Objects.requireNonNull(systemManagerService, "SystemManagerService should not null");
        systemManagerService.subscribe(systemId);
        logger.info("Subscribing System: {} with SystemManagerService", systemId);
    }

    protected abstract String systemId();

    protected abstract void createRoute(SystemMetaData systemMetaData);

    @Override
    public void configure() throws Exception {
        String systemId = systemId();
        SystemMetaData systemMetaData = systemManagerService.getSystemById(systemId);
        if (systemMetaData == null) {
            logger.error("System: {} not having any  System information from DB, So Cannot initiate Routes", systemId);
        }
        createRoute(systemMetaData);
    }
}
