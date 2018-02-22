/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inm.dao.walletresize;

import com.inm.ap.conn.AdminDb;
import com.inm.ap.hibernate.Util.*; 
import com.inm.models.*;
import java.util.ArrayList;
import com.inm.ap.mode.hibernate.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.math.RoundingMode;
/**
 *
 * @author Levi
 */
public class WalletResizeMaster {
     OperationsDal ops;

    public WalletResizeMaster() {
        ops = OperationsDalImpl.getInstance(Databases.ACCPLAN);
    }
    public  boolean deleteWalletResize(WalletResizeModel walletResizeModel ) {
     return ops.delete(walletResizeModel);
        }
   
    public BigDecimal getTotalRevenue(BigDecimal tenor,BigDecimal margin,BigDecimal dealAmount) {
        BigDecimal revenue =BigDecimal.ZERO;
        BigDecimal tenorAnnul =BigDecimal.ZERO; 
        BigDecimal marginten =BigDecimal.ZERO; 
        tenorAnnul = tenor.divide(new BigDecimal(12), 3, RoundingMode.CEILING);
        marginten = tenorAnnul.multiply(margin);
        revenue = marginten.multiply(dealAmount);
        return revenue;
    }
    public BigDecimal getMargin(BigDecimal tenor,BigDecimal ftp,BigDecimal interestRate,String product) {
        WalletResizeMaster wrm = new WalletResizeMaster();
    BigDecimal margin =BigDecimal.ZERO;
    String productClass =wrm.getProductClass(product);
    BigDecimal ftpRate = wrm.getFpt(tenor,productClass);
    margin = interestRate.subtract(ftpRate);
     return margin.abs();
    } 
    public BigDecimal getFpt(BigDecimal tenor,String productClass) {
        WalletResizeMaster wrm = new WalletResizeMaster(); 
        BigDecimal ftpRate =BigDecimal.ZERO;;
        BigDecimal tenorDays = BigDecimal.ZERO;
        tenorDays  = tenor.multiply(new BigDecimal(30));  
        CoreQuery coreQuery = new CoreQuery("from Fpt where tenorStart>= :tenor", true);
        coreQuery.addParam("tenor", tenorDays);
        List ftpLst = ops.fetch(coreQuery);
        Fpt ftpObj = (Fpt) ftpLst.get(0);
        int fg = tenorDays .compareTo(ftpObj.getTenorStart());    
        if(productClass.equalsIgnoreCase("LIABILITIES")){
        ftpRate = ftpObj.getCreditPoolRate();
        }else if(productClass.equalsIgnoreCase("ASSET")){
        ftpRate = ftpObj.getDebitPoolRate(); 
       }
          return ftpRate;
    }
     
 
    public String getProductClass(String product) {
        CoreQuery coreQuery = new CoreQuery("from ProductClass where product like :product", true);
        coreQuery.addParam("product", '%' + product + '%'); 
        List prdList = ops.fetch(coreQuery);
        ProductClass prdClass = (ProductClass) prdList.get(0);
        return prdClass.getProductClass();
    }
    
//    public static void main(String[] args) {
//        WalletResizeMaster wrm = new WalletResizeMaster();
//     WalletResizeModel walletResizeModel = new WalletResizeModel();
//     walletResizeModel.setAnnualAverageFloat(new BigDecimal("100000000"));
//     walletResizeModel.setAverageUtilizationAmount(new BigDecimal("100000000"));
//     walletResizeModel.setClientMaster("15");
//     walletResizeModel.setDealMount(new BigDecimal("100000000"));
//     walletResizeModel.setFtpRate(BigDecimal.ZERO);
//     walletResizeModel.setInterestRate(new BigDecimal("13"));
//     walletResizeModel.setLimit(new BigDecimal("100000000"));
//     walletResizeModel.setLookupmasterByCurrencyLookupid(188);
//     walletResizeModel.setLookupmasterByProduct(37);
//     walletResizeModel.setMargin(BigDecimal.ZERO);
//     walletResizeModel.setProcessingRate(new BigDecimal("13"));
//     walletResizeModel.setTenor(new BigDecimal("2"));
//     walletResizeModel.setWalletResizeId(100);
//     wrm.createWalletResize(walletResizeModel);
//    }
    public  void createWalletResize(WalletResizeModel walletResizeModel) {
         WalletResizeMaster wrm = new WalletResizeMaster(); 
         WalletResize wr = new WalletResize();  
         wr.setClientMaster(wrm.getClientMasterByID(walletResizeModel.getClientMaster())); 
         wr.setAnnualAverageFloat(walletResizeModel.getAnnualAverageFloat());
         wr.setAverageUtilizationAmount(walletResizeModel.getAnnualAverageFloat());
         //wr.setDealMount(walletResizeModel.getDealMount());
         wr.setMargin(wrm.getMargin(walletResizeModel.getTenor(),wrm.getFpt(walletResizeModel.getTenor(), wrm.getProductClass(wrm.getLookUpMasterByID(walletResizeModel.getLookupmasterByProduct()).getValue())), walletResizeModel.getInterestRate(), wrm.getLookUpMasterByID(walletResizeModel.getLookupmasterByProduct()).getValue()));
         //wr.setProcessingRate(walletResizeModel.getProcessingRate()); 
         wr.setTenor(walletResizeModel.getTenor());
         wr.setFtpRate(wrm.getFpt(walletResizeModel.getTenor(), wrm.getProductClass(wrm.getLookUpMasterByID(walletResizeModel.getLookupmasterByProduct()).getValue())));
         wr.setInterestRate(walletResizeModel.getInterestRate());
         wr.setLimit(walletResizeModel.getLimit());
         wr.setTotalrevenue(wrm.getTotalRevenue(walletResizeModel.getTenor(),wrm.getMargin(walletResizeModel.getTenor(),wrm.getFpt(walletResizeModel.getTenor(), wrm.getProductClass(wrm.getLookUpMasterByID(walletResizeModel.getLookupmasterByProduct()).getValue())), walletResizeModel.getInterestRate(), wrm.getLookUpMasterByID(walletResizeModel.getLookupmasterByProduct()).getValue()),walletResizeModel.getDealMount()));
         wr.setLookupmasterByCurrencyLookupid(getLookUpMasterByID(walletResizeModel.getLookupmasterByCurrencyLookupid()));
         wr.setLookupmasterByProduct(getLookUpMasterByID(walletResizeModel.getLookupmasterByProduct()));
         
        ops.save(wr);
    }
    
        public ArrayList<WalletResizeModel> getWalletResize(String rmCode) {
         ArrayList<WalletResizeModel> walletResizeModels = new ArrayList<WalletResizeModel>();
       WalletResizeMaster wrm = new WalletResizeMaster();
         CoreQuery coreQuery = new CoreQuery("from WalletResize where clientMaster.rmCodelistByRmCode.rmCode =:rmCode", true);
        coreQuery.addParam("rmCode", rmCode);
        List wrMaster = ops.fetch(coreQuery);
        for (Object wrObject : wrMaster) {
            WalletResize wr = (WalletResize) wrObject;
            WalletResizeModel walletResizeModel = new WalletResizeModel(); 
            walletResizeModel.setClientMaster(wrm.getClientMaster(wr.getClientMaster().getClientid()).getClientname()); 
           walletResizeModel.setAnnualAverageFloat(wr.getAnnualAverageFloat());
           walletResizeModel.setAverageUtilizationAmount(wr.getAverageUtilizationAmount());
           walletResizeModel.setFtpRate(wr.getFtpRate());
           //walletResizeModel.setDealMount(wr.getDealMount());
           walletResizeModel.setTotalrevenue(wr.getTotalrevenue());
           walletResizeModel.setInterestRate(wr.getInterestRate());
           walletResizeModel.setLimit(wr.getLimit());
           walletResizeModel.setLookupmasterByCurrencyLookupid(wr.getLookupmasterByCurrencyLookupid().getLookupmasterid());
           walletResizeModel.setLookupmasterByProduct(wr.getLookupmasterByProduct().getLookupmasterid());
           walletResizeModel.setMargin(wr.getMargin());
          // walletResizeModel.setProcessingRate(wr.getProcessingRate());
           walletResizeModel.setTenor(wr.getTenor());
           walletResizeModel.setWalletResizeId(wr.getWalletResizeId());
            walletResizeModels.add(walletResizeModel);
        }

        return walletResizeModels;
    }
        public ArrayList<WalletResizeModel> getWalletResizeByClientId(String rmCode, String clientid) {
         ArrayList<WalletResizeModel> walletResizeModels = new ArrayList<WalletResizeModel>();
       WalletResizeMaster wrm = new WalletResizeMaster();
         CoreQuery coreQuery = new CoreQuery("from WalletResize where clientMaster.rmCodelistByRmCode.rmCode =:rmCode and clientid =:clientid", true);
        coreQuery.addParam("rmCode", rmCode);
        coreQuery.addParam("clientid", clientid);
        List wrMaster = ops.fetch(coreQuery);
        for (Object wrObject : wrMaster) {
            WalletResize wr = (WalletResize) wrObject;
            WalletResizeModel walletResizeModel = new WalletResizeModel(); 
            walletResizeModel.setClientMaster(wrm.getClientMaster(wr.getClientMaster().getClientid()).getClientname()); 
           walletResizeModel.setAnnualAverageFloat(wr.getAnnualAverageFloat());
           walletResizeModel.setAverageUtilizationAmount(wr.getAverageUtilizationAmount());
           walletResizeModel.setFtpRate(wr.getFtpRate());
           //walletResizeModel.setDealMount(wr.getDealMount());
           walletResizeModel.setTotalrevenue(wr.getTotalrevenue());
           walletResizeModel.setInterestRate(wr.getInterestRate());
           walletResizeModel.setLimit(wr.getLimit());
           walletResizeModel.setLookupmasterByCurrencyLookupid(wr.getLookupmasterByCurrencyLookupid().getLookupmasterid());
           walletResizeModel.setLookupmasterByProduct(wr.getLookupmasterByProduct().getLookupmasterid());
           walletResizeModel.setMargin(wr.getMargin());
           //walletResizeModel.setProcessingRate(wr.getProcessingRate());
           walletResizeModel.setTenor(wr.getTenor());
           walletResizeModel.setWalletResizeId(wr.getWalletResizeId());
            walletResizeModels.add(walletResizeModel);
        }

        return walletResizeModels;
    }
    public  void updateWalletResize(WalletResizeModel walletResizeModel) {
         WalletResizeMaster wrm = new WalletResizeMaster(); 
         WalletResize wr = new WalletResize();  
         wr.setClientMaster(wrm.getClientMasterByID(walletResizeModel.getClientMaster())); 
         wr.setAnnualAverageFloat(walletResizeModel.getAnnualAverageFloat());
         wr.setAverageUtilizationAmount(walletResizeModel.getAnnualAverageFloat());
        // wr.setDealMount(walletResizeModel.getDealMount());
         wr.setMargin(wrm.getMargin(walletResizeModel.getTenor(),wrm.getFpt(walletResizeModel.getTenor(), wrm.getProductClass(wrm.getLookUpMasterByID(walletResizeModel.getLookupmasterByProduct()).getValue())), walletResizeModel.getInterestRate(), wrm.getLookUpMasterByID(walletResizeModel.getLookupmasterByProduct()).getValue()));
        // wr.setProcessingRate(walletResizeModel.getProcessingRate()); 
         wr.setTenor(walletResizeModel.getTenor());
         wr.setFtpRate(wrm.getFpt(walletResizeModel.getTenor(), wrm.getProductClass(wrm.getLookUpMasterByID(walletResizeModel.getLookupmasterByProduct()).getValue())));
         wr.setInterestRate(walletResizeModel.getInterestRate());
         wr.setWalletResizeId(walletResizeModel.getWalletResizeId());
         wr.setLimit(walletResizeModel.getLimit());
         wr.setTotalrevenue(wrm.getTotalRevenue(walletResizeModel.getTenor(),wrm.getMargin(walletResizeModel.getTenor(),wrm.getFpt(walletResizeModel.getTenor(), wrm.getProductClass(wrm.getLookUpMasterByID(walletResizeModel.getLookupmasterByProduct()).getValue())), walletResizeModel.getInterestRate(), wrm.getLookUpMasterByID(walletResizeModel.getLookupmasterByProduct()).getValue()),walletResizeModel.getDealMount()));
         wr.setLookupmasterByCurrencyLookupid(getLookUpMasterByID(walletResizeModel.getLookupmasterByCurrencyLookupid()));
         wr.setLookupmasterByProduct(getLookUpMasterByID(walletResizeModel.getLookupmasterByProduct()));
        ops.saveOrUpdate(wr);
    }
      public Lookupmaster getLookUpMasterByID(int lookupmasterid) {
        CoreQuery coreQuery = new CoreQuery("from Lookupmaster where lookupmasterid =:lookupmasterid", true);
        coreQuery.addParam("lookupmasterid", lookupmasterid); 
        List lkup = ops.fetch(coreQuery);
        return (Lookupmaster) lkup.get(0);
    }
    public ClientMaster getClientMasterByID(String clientid) {
        CoreQuery coreQuery = new CoreQuery("from ClientMaster where clientid =:clientid", true);
        coreQuery.addParam("clientid", clientid); 
        List clientMaster = ops.fetch(coreQuery);
        return (ClientMaster) clientMaster.get(0);
    }
    public ArrayList<LookupmasterModel> getLookupList(String code) {
         ArrayList<LookupmasterModel> lookupList = new ArrayList<LookupmasterModel>();
        CoreQuery coreQuery = new CoreQuery("from Lookupmaster where code =:code", true);
        coreQuery.addParam("code", code); 
        List lookups = ops.fetch(coreQuery);
         if (Validator.validateList(lookups)) {
                for (Object lookup : lookups) {
                    if (lookup != null) {
                     Lookupmaster lookupmaster = (Lookupmaster) lookup;
                     LookupmasterModel lookupmasterModel =   new LookupmasterModel(lookupmaster.getLookupmasterid(), lookupmaster.getCode(), lookupmaster.getValue());
                        lookupList.add(lookupmasterModel);
                        }
                }
            }
         return lookupList;
     } 
    public ArrayList<ClientModel> getClientMasterList(String rmCode) {
         ArrayList<ClientModel> clientModelList = new ArrayList<ClientModel>();
        CoreQuery coreQuery = new CoreQuery("from ClientMaster where rmCodelistByRmCode.rmCode =:rmCode", true);
        coreQuery.addParam("rmCode", rmCode); 
        List rms = ops.fetch(coreQuery);
         if (Validator.validateList(rms)) {
                for (Object rm : rms) {
                    if (rm != null) {
                     ClientMaster clientMaster = (ClientMaster) rm;
                     
                     ClientModel clientModel =   new ClientModel(clientMaster.getClientid(), clientMaster.getRmCodelistByRmCode().getRmCode(), clientMaster.getRmCodelistByAlternativeRmCode().getRmCode(), clientMaster.getLookupmaster().getValue(), clientMaster.getClientname(), clientMaster.getCurrentDate(),clientMaster.getTradeserviceprovider(), clientMaster.getCashmanagementpartner(), clientMaster.getECommercepartner(), clientMaster.getCreditmanager(), clientMaster.getTreasurypartner(), clientMaster.getInternetbankingpartner(),clientMaster.getAssetfinancepartner(), clientMaster.getCardspartner(),clientMaster.getBancassurancepartner());
                        clientModelList.add(clientModel);
                        }
                }
            }
         return clientModelList;
     }
     public ClientMaster getClientMaster(String clientid) {
        CoreQuery coreQuery = new CoreQuery("from ClientMaster where clientid =:clientid", true);
        coreQuery.addParam("clientid", clientid); 
        List clientMaster = ops.fetch(coreQuery);
        return (ClientMaster) clientMaster.get(0);
    }
     public RmCodelist getRmCodeList(String rmCode) {
        CoreQuery coreQuery = new CoreQuery("from RmCodelist where rmCode =:rmCode", true);
        coreQuery.addParam("rmCode", rmCode); 
        List rmCodes = ops.fetch(coreQuery);
        return (RmCodelist) rmCodes.get(0);
    }
      public ArrayList<RmCodelistModel> getRmCodeList() {
         ArrayList<RmCodelistModel> rmCodeList = new ArrayList<RmCodelistModel>();
        CoreQuery coreQuery = new CoreQuery("from RmCodelist", true); 
        List rmlst = ops.fetch(coreQuery);
         if (Validator.validateList(rmlst)) {
                for (Object rm : rmlst) {
                    if (rm != null) {
                     RmCodelist codelist = (RmCodelist) rm;
                     RmCodelistModel codelistModel =   new RmCodelistModel(codelist.getRmCode(), codelist.getDesignation(), codelist.getBranch(), codelist.getBranch(), codelist.getRegion(), codelist.getCategory(), codelist.getRmName());
                        rmCodeList.add(codelistModel);
                        }
                }
            }
         return rmCodeList;
     }
}
