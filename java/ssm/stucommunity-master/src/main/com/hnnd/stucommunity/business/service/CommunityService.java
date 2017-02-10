package main.com.hnnd.stucommunity.business.service;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import main.com.hnnd.stucommunity.business.dao.CommunityDao;
import main.com.hnnd.stucommunity.business.model.Community;
import main.com.hnnd.stucommunity.common.base.ResultModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommunityService {

	@Autowired
	CommunityDao communityDao;
	
	/**
	 * 创建社团
	 * @param request
	 * @return
	 */
	public ResultModel saveCommunity(HttpServletRequest request){
		Community community=new Community();
		community.setCreator(Integer.valueOf(request.getParameter("userId")));
		community.setCreateTime(new Date());
		community.setName(request.getParameter("name"));
		community.setIntroduction(request.getParameter("introduction"));
	
		Integer communityId=communityDao.saveCommunity(community);
		return ResultModel.successModel();
	}
	
}
