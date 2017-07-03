package com.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.biz.UserBiz;
import com.model.BuyInfo;
import com.opensymphony.xwork2.ActionSupport;
import com.util.Log;
import com.util.Page;

/**
*********************************************
*@����   BuyInfoAction
*@ʱ��   2017��6��9�� ����9:08:23
*@����   guyan
*@����
*********************************************
*/
public class BuyInfoAction extends ActionSupport{
	//��ѯ�����¼
		public String buyInfo() throws Exception {
			String result =  "error";
			HttpServletRequest request = ServletActionContext.getRequest();
			String uname = request.getParameter("uname");
			String beginDate = request.getParameter("beginDate");
			String endDate = request.getParameter("endDate");
			Date bDate = null;
			Date eDate = null;
			UserBiz biz = new UserBiz();
			try {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				if(beginDate!=null&&!beginDate.equals("")){
					bDate = sdf.parse(beginDate);
				}
				if(endDate!=null&&!endDate.equals("")){
					eDate = sdf.parse(endDate);
				}
				/*if(uname!=null){*/
					String page = request.getParameter("page");
					int currentPageNo = 1;
					if(page!=null){
						currentPageNo = Integer.parseInt(page);
						if(currentPageNo<1){
							currentPageNo=1;
						}
					}
					Page pages = new Page();
					pages.setCurrentPageNo(currentPageNo);//��ǰҳ��
					pages.setPageSize(5);     //ÿҳ��¼��
					List<BuyInfo> list = biz.getBuyInfoList(uname,bDate,eDate,pages);
					request.setAttribute("buyInfos",list);
					request.setAttribute("uname",uname);
					request.setAttribute("beginDate",beginDate);
					request.setAttribute("endDate",endDate);	
					request.setAttribute("allCount",pages.getAllCount());
					request.setAttribute("pageAllCount",pages.getPageAllCount());
					request.setAttribute("currentPageNo",pages.getCurrentPageNo());
				/*}*/
				result = "buyInfo";
			} catch (Exception e) {
				Log.logger.error(e.getMessage());
			}
			return result;
		}

}
