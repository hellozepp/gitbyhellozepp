package org.ditest.dao;

import org.springframework.stereotype.Repository;

/**
 * Created by andilyliao on 17-1-4.
 */
@Repository
public class TestDao implements ITestDao {
    @Override
    public int testdao() {
        return 100;
    }
}
