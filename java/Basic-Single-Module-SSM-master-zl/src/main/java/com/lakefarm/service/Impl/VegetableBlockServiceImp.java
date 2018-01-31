package com.lakefarm.service.Impl;

import com.lakefarm.mapper.VegetableBlockMapper;
import com.lakefarm.service.VegetableBlockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by rxl on 17-2-22.
 */
@Service
public class VegetableBlockServiceImp implements VegetableBlockService {
    @Autowired
    private VegetableBlockMapper vegetableBlockMapper;
    @Override
    public int addBlock(VegetableBlockMapper t) {
        return vegetableBlockMapper.addBlock(t);
    }

    @Override
    public int deleteBlock(String block_id) {
        return vegetableBlockMapper.deleteBlock(block_id);
    }

    @Override
    public int updateBlock(VegetableBlockMapper t) {
        return vegetableBlockMapper.updateBlock(t);
    }

    @Override
    public VegetableBlockMapper getBlockById(String block_id) {
        return vegetableBlockMapper.getBlockById(block_id);
    }
}
