package com.lakefarm.mapper;

/**
 * Created by rxl on 17-2-22.
 */
public interface VegetableBlockMapper {
    /*
    *增加任务
    */
    public int addBlock(VegetableBlockMapper t);


    /*
    *删除任务
    */
    public int deleteBlock(String block_id);

    /*
    *更新任务
    */
    public int updateBlock(VegetableBlockMapper t);


    /*
    *通过id获取指定任务
    */
    public VegetableBlockMapper getBlockById(String block_id);
}
