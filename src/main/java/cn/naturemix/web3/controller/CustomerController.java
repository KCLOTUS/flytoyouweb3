package cn.naturemix.web3.controller;

import cn.naturemix.framework.annotation.Action;
import cn.naturemix.framework.annotation.Controller;
import cn.naturemix.framework.annotation.Inject;
import cn.naturemix.framework.bean.Data;
import cn.naturemix.framework.bean.Param;
import cn.naturemix.framework.bean.View;
import cn.naturemix.web3.model.Customer;
import cn.naturemix.web3.service.CustomerService;

import java.util.List;
import java.util.Map;

/**
 * 处理客户管理相关请求
 */
@Controller
public class CustomerController {

    @Inject
    private CustomerService customerService;

    /**
     * 进入客户列表 界面
     */

    @Action("get:/Customer")
    public View index(Param param){
        List<Customer> customerList = customerService.getCustomerList();
        return new View("Customer.jsp").addModel("customerList",customerList);
    }

    /**
     * 显示客户基本信息
     */

    @Action("get:/customer_show")
    public View show(Param param){
        long id = param.getLong("id");
        Customer customer = customerService.getCustomer(id);
        return new View("customer_show.jsp").addModel("Customer",customer);
    }

    /**
     * 进入创建客户界面
     */

    @Action("get:/customer_create")
    public View create(Param param){
        return new View("customer_create.jsp");
    }

    /**
     * 处理创建客户请求
     */

    @Action("post:/customer_create")
    public Data createSubmit(Param param){
        Map<String,Object> fieldMap = param.getMap();
        boolean result = customerService.createCustomer(fieldMap);
        return new Data(result);
    }

    /**
     * 进入编辑客户界面
     */

    @Action("get:/customer_edit")
    public View edit(Param param){
        long id = param.getLong("id");
        Customer customer = customerService.getCustomer(id);
        return new View("customer_edit.jsp").addModel("Customer",customer);
    }

    /**
     * 处理编辑客户请求
     */

    @Action("put:/customer_edit")
    public Data editSubmit(Param param){
        long id = param.getLong("id");
        Map<String,Object> fieldMap = param.getMap();
        boolean result = customerService.updateCustomer(id,fieldMap);
        return new Data(result);
    }

    /**
     * 处理删除客户请求
     */

    @Action("delete:/customer_edit")
    public Data delete(Param param){
        long id = param.getLong("id");
        boolean result = customerService.deleteCustomer(id);
        return new Data(result);
    }

}
