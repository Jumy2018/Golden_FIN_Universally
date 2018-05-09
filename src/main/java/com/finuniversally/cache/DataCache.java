package com.finuniversally.cache;

import com.finuniversally.model.Contract;
import com.finuniversally.model.Customer;
import com.finuniversally.model.DocumentaryDetailedData;
import com.finuniversally.untils.CustomerGenerateUtils;

import java.util.ArrayList;
import java.util.List;


public  class DataCache {


    private volatile static DataCache instance;

    //跟单明细数据
    private List<DocumentaryDetailedData> DocumentaryDetailedDatas = new ArrayList<>();
    //合约信息数据
    private List<Contract> contractList = new ArrayList<>();


    public static DataCache getInstance(){
        if(instance==null){
            synchronized (DataCache.class){
                if(instance==null){
                    instance=new DataCache();
                }
            }
        }
        return instance;
    }

    public List<DocumentaryDetailedData> getDocumentaryDetailedDatas() {
        return DocumentaryDetailedDatas;
    }

    public void setDocumentaryDetailedDatas(List<DocumentaryDetailedData> documentaryDetailedDatas) {
        DocumentaryDetailedDatas = documentaryDetailedDatas;
    }

    public static void setInstance(DataCache instance) {
        DataCache.instance = instance;
    }

    public List<Customer> getCustomerList() {
        //假客户数据
        List<Customer> customers = new ArrayList<>();
        customers.add(CustomerGenerateUtils.GenerateCustomer());
        return customers;
    }

    public  List<Contract> getContractList() {
        return contractList;
    }


}
