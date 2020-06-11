package com.azure.practice.mutualfund.dao;

import com.azure.practice.mutualfund.rest.RestAPIExchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class MutualFundDao {
    @Autowired
    private RestAPIExchange restAPIExchange;
    public Map<String, Object> getData(String id) {
        try {
            return restAPIExchange.getExchange(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
