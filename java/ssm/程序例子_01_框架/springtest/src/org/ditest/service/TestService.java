package org.ditest.service;

import org.ditest.dao.ITestDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by andilyliao on 17-1-4.
 */
@Service
public class TestService {
    private ITestDao testDao;
    @Resource
    public void setTestDao(ITestDao testDao) {
        this.testDao = testDao;
    }


    public int testservice() {
        return testDao.testdao();
    }
}
