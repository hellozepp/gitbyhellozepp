package org.service;

import org.dao.EmpDAO;
import org.entity.Emp;
import org.entity.EmpMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by andilyliao on 17-1-7.
 */
@Service
public class EmpServiceImpl implements EmpService {
    private EmpDAO dao;
    @Autowired
    public void setDao(EmpDAO dao) {
        this.dao = dao;
    }
    @Override
    public List<Emp> findAll() {
        List<Emp> list = dao.findAll();
        return list;
    }
}
