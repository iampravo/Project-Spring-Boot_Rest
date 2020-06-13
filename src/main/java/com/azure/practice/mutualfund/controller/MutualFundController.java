package com.azure.practice.mutualfund.controller;

import com.azure.practice.mutualfund.service.MutualFundService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Random;

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
    public String healthCheck() {
        logger.info("invoked endpoint = {} , id = {}", "/mutualfund/healthcheck");
        return "Server is up and runnning";
    }

    @RequestMapping("/mutualfund/loop")
    public void loopCall() throws InterruptedException {
        Random random = new Random();
        logger.info("invoked endpoint = {} , id = {}", "/mutualfund/loop");
        int i = 1000;
        while (i > 0) {
            int sleepSec = random.nextInt(10);
            Thread.sleep(sleepSec * 1000);
            Map<String, Object> response = this.mutualFundData("120503");
            logger.info("Data Fetched after {} secs", sleepSec);
        }
    }
}
