package com.lakefarm.mapper;

import com.lakefarm.pojo.FarmTools;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by cxd on 2017/2/12.
 */
public interface FarmToolsMapper {
    public List<FarmTools> selectall();

    public long getTotal();

    public int addFarmtools(FarmTools tfarmtools);

    public int deletebyId(String nj_id);

    public int updateFarmtools(FarmTools tfarmtools);

    public FarmTools findById(@Param(value="njid") String njid);

    public List<FarmTools> selectfarmtoolsByPage(@Param(value="start") Integer start,@Param(value="size") Integer size);

}
