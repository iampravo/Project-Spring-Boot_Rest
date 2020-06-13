package com.azure.practice.mutualfund.controller;

import com.azure.practice.mutualfund.service.MutualFundService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class MutualFundController {
    private static Logger logger = LoggerFactory.getLogger(MutualFundController.class);
    @Autowired
    private MutualFundService mutualFundService;

    @RequestMapping("/mutualfund/{id}")
    public Map<String, Object> mutualFundData(@PathVariable String id) {
        logger.info("invoked endpoint = {} , id = {}", "/mutualfund", id);
        return mutualFundService.getData(id);
    }


    @RequestMapping("/mutualfund/healthcheck")
    public String healthCheck(@PathVariable String id) {
        logger.info("invoked endpoint = {} , id = {}", "/mutualfund/healthcheck", id);
        return "Server is up and runnning";
    }
}
