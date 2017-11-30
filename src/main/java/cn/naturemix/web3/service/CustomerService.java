package cn.naturemix.web3.service;

import cn.naturemix.framework.helper.DatabaseHelper;
import cn.naturemix.web3.model.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

/**
 * 提供客户数据服务
 */
public class CustomerService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerService.class);

    /**
     * 获取客户列表
     */
    public List<Customer> getCustomerList() {
        //TODO
        String sql = "SELECT * FROM Customer";
        return DatabaseHelper.queryEntityList(Customer.class,sql);
    }

    /**
     * 获取客户
     */
    public Customer getCustomer(long id){
        //TODO
        String sql = "SELECT * FROM Customer WHERE id = "+id;
        return DatabaseHelper.queryEntity(Customer.class,sql);
    }

    /**
     * 创建客户
     */
    public boolean createCustomer(Map<String,Object> fieldMap){
        //TODO
        boolean result =  DatabaseHelper.insertEntity(Customer.class,fieldMap);
        /*if (result){
            UploadHelper.uploadFile("/tmp/upload",fileParam);
        }*/
        return result;
    }

    /**
     * 更新客户
     */
    public boolean updateCustomer(long id,Map<String,Object> fieldMap){
        //TODO
        return DatabaseHelper.updateEntity(Customer.class,id,fieldMap);
    }

    /**
     * 删除客户
     */
    public boolean deleteCustomer(long id){
        //TODO
        return DatabaseHelper.deleteEntity(Customer.class,id);
    }

}
