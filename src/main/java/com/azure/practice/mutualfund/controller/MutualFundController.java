package com.azure.practice.mutualfund.controller;

import com.azure.practice.mutualfund.service.MutualFundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class MutualFundController {
    @Autowired
    private MutualFundService mutualFundService;

    @RequestMapping("/mutualfund/{id}")
    public Map<String, Object> mutualFundData(@PathVariable String id) {
        return mutualFundService.getData(id);
    }
}
