package com.test.architecture1.customermgr.web;

import static org.hamcrest.CoreMatchers.nullValue;

import java.util.IntSummaryStatistics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.test.architecture1.customermgr.service.ICustomerService;
import com.test.architecture1.customermgr.vo.CustomerModel;
import com.test.architecture1.customermgr.vo.CustomerQueryModel;
import com.test.pageutils.PageBean;
import com.test.utils.DateFormatHelper;
import com.test.utils.JsonHelper;

@Controller
@RequestMapping(value="/customer")
public class CustomerController {
	@Autowired 
	private ICustomerService iCustomerService = null;
	
	@RequestMapping(value="toAdd",method=RequestMethod.GET)
	public String toAdd() {
		
		return "customer/add";
	}
	
	@RequestMapping(value="add",method=RequestMethod.POST)
	public String add(@ModelAttribute("cm") CustomerModel cm) {
		cm.setRegisterTime(DateFormatHelper.long2str(System.currentTimeMillis()));
		iCustomerService.create(cm);
		return "customer/success";
	}
	
	@RequestMapping(value="toUpdate/{customerUuid}",method=RequestMethod.GET)
	public String toUpdate(Model model,@PathVariable("customerUuid") int customerUuid) {
		CustomerModel cModel = iCustomerService.getByUuid(customerUuid);
		model.addAttribute("cm",cModel);
		return "customer/update";
	}
	
	@RequestMapping(value="update",method=RequestMethod.POST)
	public String update(@ModelAttribute("cm") CustomerModel cm) {
		iCustomerService.update(cm);
		return "customer/success";
	}
	
	@RequestMapping(value="toDelete/{customerUuid}",method=RequestMethod.GET)
	public String toDelete(Model model,@PathVariable("customerUuid") int customerUuid) {
		CustomerModel cModel = iCustomerService.getByUuid(customerUuid);
		model.addAttribute("cm",cModel);
		return "customer/delete";
	}
	
	@RequestMapping(value="delete",method=RequestMethod.POST)
	public String delete(@RequestParam("uuid") int customerUuid) {
		iCustomerService.delete(customerUuid);
		return "customer/success";
	}
	
	@RequestMapping(value="toList",method=RequestMethod.GET)
	public String toList(@RequestParam(value="queryJsonStr",defaultValue="") String queryJson,
			@SuppressWarnings("rawtypes") @ModelAttribute("page") PageBean page, Model model) {
		CustomerQueryModel cqm = null;
		System.out.println("page ======"+page);
		if (queryJson==null || queryJson.trim().length()==0) {
			cqm = new CustomerQueryModel();
		} else {
			cqm = (CustomerQueryModel) JsonHelper.str2Object(queryJson,CustomerQueryModel.class);
		}
		
		cqm.getPage().setPage(page.getPage());
		PageBean<CustomerModel> dbPage = iCustomerService.getByConditionPage(cqm);
		
		model.addAttribute("queryJsonStr",queryJson);
		model.addAttribute("page",dbPage);
		return "customer/list";
	}
	
	@RequestMapping(value="toQuery",method=RequestMethod.GET)
	public String toQuery() {
		return "customer/query";
	}
	
}
