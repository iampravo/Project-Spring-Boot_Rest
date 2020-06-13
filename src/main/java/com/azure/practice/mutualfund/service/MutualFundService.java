package com.azure.practice.mutualfund.service;

import com.azure.practice.mutualfund.dao.MutualFundDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class MutualFundService {
    @Autowired
    private MutualFundDao mutualFundDao;
    public Map<String, Object> getData(String id) {

        return mutualFundDao.getData(id);
    }
}
