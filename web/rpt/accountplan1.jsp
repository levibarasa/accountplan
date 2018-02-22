<%@page import="com.inm.dao.qualitativeinformation.*"%> 
<%@page import="com.inm.models.*"%> 
<%@page import="java.util.ArrayList"%> 
<%@page import="com.inm.dao.valuechain.*"%> 
<%@page import="com.inm.dao.client.*"%> 
<%@page import="com.inm.dao.walletresize.*"%> 
<% 
 String clientId = request.getParameter("clientnamea");
  String rmCode = request.getParameter("uname");
  Client cl = new Client();
  AccountRevenue ar = new AccountRevenue();
  ClientFinacial cf = new ClientFinacial();
  Company com = new Company();
  CreditInfo ci = new CreditInfo();
  KeyDistributor kd = new KeyDistributor();
  KeySupplier ks = new KeySupplier();
  ClientCoverageMaster ccm = new ClientCoverageMaster();
  ClientEmployeeMaster cem = new ClientEmployeeMaster();
  CompetitionMaster cm = new CompetitionMaster();
  DealInProgressMaster dipm = new DealInProgressMaster();
  QualitativeInfo qInfo = new QualitativeInfo();
  SaleActionPlan sap = new SaleActionPlan();
   ArrayList<ClientModel> clientinf = cl.getClientInfoByClientId(rmCode,clientId);
   ArrayList<AccountRevenueModel> accrev =  ar.getAccountRevenuenfoByClientId(rmCode,clientId);
   ArrayList<ClientFinacialModel> clfin = cf.getClientFinancialInfoByClientId(rmCode,clientId);
   ArrayList<CompanyModel> cominf = com.getCompanyInfoByClientId(rmCode,clientId);
   ArrayList<CreditInfoModel> crinf =  ci.getCreditInfoByClientId(rmCode,clientId);
   ArrayList<ClientEmployeeModel> cemInf = cem.getClientEmployeeInfoByClientId(rmCode,clientId);
   ArrayList<KeyDistributorModel> kdInf =kd.getDistributorInfoByClientId(rmCode,clientId);
   ArrayList<KeySupplierModel> ksInfo = ks.getKeySupplierInfoByClientId(rmCode,clientId);
   ArrayList<ClientCoverageModel> ccmInfo =  ccm.getClientCoverageInfoByClientId(rmCode,clientId);
   ArrayList<CompetitionModel> cmInfo = cm.getCompetitionInfo(rmCode,clientId);
   ArrayList<DealProgressModel> dipInfo =dipm.getDealInProgressInfoByClientId(rmCode,clientId);
   ArrayList<QualitativeinformationModel> qInf = qInfo.getQualitativeinfoByClientId(rmCode,clientId);
   ArrayList<SalesactionplanModel> sapInf =sap.getSaleActionPlanInfoByClientId(rmCode,clientId);
    %>

<html>
<link rel="stylesheet" type="text/css" href="/Content/font-awesome/css/font-awesome.min.css" />
<link rel="stylesheet" type="text/css" href="http://www.shieldui.com/shared/components/latest/css/light/all.min.css" />
<script type="text/javascript" src="http://www.shieldui.com/shared/components/latest/js/shieldui-all.min.js"></script>
<script type="text/javascript" src="http://www.shieldui.com/shared/components/latest/js/jszip.min.js"></script>
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.16/css/jquery.dataTables.min.css" />
<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.js"></script>

<head>
    <style type="text/css">
            
       body
{
    overflow:auto;
    background-color: #1b1b1b;
    padding-top: 40px;
}
.form-signin {
    max-width: 100%;
    padding: 15px;
    margin:200px;
    margin-top:120px;
    margin-left: 130px;
  }

.input-group-addon
{
    background-color: rgb(50, 118, 177);
    border-color: rgb(40, 94, 142);
    color: rgb(255, 255, 255);
}

.form-signup input[type="text"],.form-signup input[type="password"] { border: 1px solid rgb(50, 118, 177); }
.fullscreen_bg {
    position: fixed;
    top: 0;
    right: 0;
    bottom: 0;
    left: 0;
    background-size: cover;
    background-position: 50% 50%;
    background-image: url('http://i.imgur.com/aFs5QmP.jpg');
    background-repeat:repeat;
  }
  
  table {
    width: 100%;
    display:block;
}
thead {
    display: inline-table;
    width: 95%;
    height: 30px;
}
tbody {
    height: 1000px;
    display: inline-block;
    width: 900px;
    overflow: auto;
}       
    </style>
    <script type="text/javascript">
    $(document).ready(function() {
    $('#exportTable').DataTable( {
        "scrollY": 1000,
        "scrollX": true
    } );
} );

$(document).ready(function() {
    $('#exportForm').DataTable( {
        "scrollY": 1000,
        "scrollX": true
    } );
} );
</script>
   <script type="text/javascript">
    jQuery(function ($) {
        $("#exportButton").click(function () {
            // parse the HTML table element having an id=exportTable
            var dataSource = shield.DataSource.create({
                data: "#exportTable",
                schema: {
                    type: "table",
                    fields: {
                        Name: { type: String },
                        Age: { type: Number },
                        Email: { type: String }
                    }
                }
            });

            // when parsing is done, export the data to PDF
            dataSource.read().then(function (data) {
                var pdf = new shield.exp.PDFDocument({
                    author: "LeviBarasa",
                    created: new Date()
                });

                pdf.addPage("a4", "landscape");

                pdf.table(
                    50,
                    50,
                    data,
                    [
                        { field: "Name", title: "Person Name", width: 200 },
                        { field: "Age", title: "Age", width: 50 },
                        { field: "Email", title: "Email Address", width: 200 }
                    ],
                    {
                        margins: {
                            top: 10,
                            left: 10
                        }
                    }
                );

                pdf.saveAs({
                    fileName: "AccountPlanPDF"
                });
            });
        });
    });
</script>

<style>
    #exportButton {
        border-radius: 0;
    }
</style>
</head>
   <div id="fullscreen_bg" class="fullscreen_bg"/>
 <form  class="form-signin">
<div class="container">
    <div class="row">
        <div class="col-md-7 col-md-offset-2">
        
        <div class="panel panel-default">
        
        <div class="panel panel-primary">
        
            
            <div class="text-center">
                <h3 style="color:#2C3E50" >Account Plan Report</h3>
                 </div>   
    <button id="exportButton" class="btn btn-lg btn-danger clearfix"><span class="fa fa-file-pdf-o"></span> Export to PDF</button>
     <table style="overflow-x: auto;overflow-y: scroll;" id="exportTable" class="table table-hover" >
                 <tr>
                <td>
                    <table>
                         <%  
                             for(ClientModel clientModel :clientinf){
                                %>
                        <tr>
                             <td>Client Name:</td> 
                             <td>
                                <%=clientModel.getClientname()%> 
                             </td>
                              
                        </tr>
                        
                        <tr>
                           <td>Relationship Manager:</td> 
                             <td>
                                <%=clientModel.getRmCode()%> 
                             </td>  
                             <td>Trade Service Partner:</td> 
                             <td><%=clientModel.getTradeserviceprovider()%>  </td>
                            
                        </tr>
                        <tr>
                           <td>Alternate Rm:</td> 
                             <td>
                                <%=clientModel.getAlternativeRmCode()%> 
                             </td> 
                              <td>Cash Management Partner:</td> 
                             <td><%=clientModel.getCashmanagementpartner()%>  </td> 
                              
                        </tr>
                        <tr>
                           <td>Country:</td> 
                             <td>
                                <%=clientModel.getAffiliate()%> 
                             </td>
                             <td>Credit Manager:</td> 
                             <td><%=clientModel.getCreditmanager()%>  </td>
                             
                        </tr>
                        <tr>
                           <td>Date:</td> 
                             <td>
                                <%=clientModel.getCurrentDate()%> 
                             </td>  
                             <td>Treasury Partner:</td> 
                             <td><%=clientModel.getTreasurypartner()%>  </td>
                        </tr>
                        
                          <%  
                             }
                                %>  
                    </table>
                </td>
                 
                <td> </td>
                <td> </td>
            </tr>
            <tr style="vertical-align: baseline;">
                <td style="vertical-align: baseline;">
                    <label style="font-size: 14px;">Company Overview</label>
                     <table>
                        <%   
                            System.out.println(cominf.get(0).getGroupname());
                             for(CompanyModel comModel : cominf){
                                %>
                        <tr>
                            <td>Company Address</td>
                            <td><%=comModel.getCompanyAddress()%></td></tr><tr>
                            <td>Group Name</td>
                            <td><%=comModel.getGroupname()%></td></tr><tr>
                            <td>HQ Country</td>
                            <td><%=comModel.getLookupmasterByAffiliatelookupmasterid()%></td></tr><tr>
                            <td>Industry</td>
                            <td><%=comModel.getLookupmasterByIndustrylookupmasterid()%></td></tr><tr>
                            <td>Segment</td>
                            <td><%=comModel.getLookupmasterBySegmentlookupmasterid()%></td></tr><tr>
                            <td>Number Of Subsidiaries</td>
                            <td><%=comModel.getNoofsubsidiaries()%></td>
                        </tr>
                        <%  
                             }
                                %>
                    </table>
                </td>
                <td style="vertical-align: baseline;"> 
                    <label style="font-size: 14px;">Account Revenue Information</label>
                    <table>
                         <%    
                              for(AccountRevenueModel arModel : accrev){
                                %>
                                <tr>
                                <td>Current Year Revenue Target(Ksh'M)</td>
                                <td><%=arModel.getCurrentyearrevenuetarget()%></td>
                                </tr>
                        <tr>
                                <td>Prior Year Actual Revenue(Ksh'M)</td>
                                <td><%=arModel.getPrioryearactualrevenue()%></td>
                                </tr>
                        <tr>
                                <td>%-growth Revenue</td>
                                <td><%=arModel.getPercentagegrowthrevenue()%></td>
                                </tr>
                        <tr>
                                <td>Current Year Fee Income Target(Ksh'M)</td>
                                <td><%=arModel.getCurrentyearnfitarget()%></td>
                                </tr>
                        <tr>
                                <td>Prior Year Actual Fee Income(Ksh'M)</td>
                                <td><%=arModel.getPrioryearactualfeeincome()%></td>
                                </tr>
                        <tr>
                                <td>%-growth Fee Income</td>
                                <td><%=arModel.getPercentagegrowthfeeincome()%></td>
                                </tr>
                        <tr>
                                <td>Current Share of Wallet</td>
                                <td><%=arModel.getCurrentshareofwallet()%></td>
                                </tr>
                        <tr>
                                <td>Target Share of Wallet</td>
                                <td><%=arModel.getTargetshareofwallet()%></td>
                                </tr>
                        <tr>
                            <td>Total value of Identified Opportunities(Ksh'M)</td>
                                <td><%=arModel.getTotalvalueofidopportunities()%></td>
                                </tr>
                        <%  
                             }
                                %>
                    </table>
                </td>
                <td style="vertical-align: baseline;"> 
                <label style="font-size: 14px;">Credit Information</label>
                <table>
                     <%  
                              for(CreditInfoModel credInfModel : crinf){
                                %>
                                <tr>
                                <td>Approved Lines(Ksh'M)</td>
                                <td><%=credInfModel.getImapprovedlines()%></td>
                                </tr>
                        <tr>
                                <td>Outstanding Amount(Ksh'M)</td>
                                <td><%=credInfModel.getImoutstandingamount()%></td>
                                </tr>
                                <tr>
                                <td>Risk Rating</td>
                                <td><%=credInfModel.getRiskrating()%></td>
                                </tr> 
                                  <%  
                             }
                                %>
                </table>
                </td>
                <td style="vertical-align: baseline;"> 
                <label style="font-size: 14px;">Client Financials</label>
               <table>
                     <%   
                         
                              for(ClientFinacialModel clfinModel : clfin){
                                %>
                                <tr>
                                <td>Turnover(Ksh'M)</td>
                                <td><%=clfinModel.getTurnover()%></td>
                                </tr>
                                <tr>
                                <td>Operating Profit(Ksh'M)</td>
                                <td><%=clfinModel.getOperatingprofit()%></td>
                                </tr>
                                <tr>
                                <td>Total Debt(Ksh'M)</td>
                                <td><%=clfinModel.getTotaldebt()%></td>
                                </tr>
                                <tr>
                                <td>Total Deposits(Ksh'M)</td>
                                <td><%=clfinModel.getTotaldeposits()%></td>
                                </tr>
                                <tr>
                                <td>Gearing Ratio</td>
                                <td><%=clfinModel.getGearingratio()%></td>
                                </tr>
                                <tr>
                               <td>CashFlow Cycle(days)</td>
                                <td><%=clfinModel.getCashflowcycle()%></td>
                                </tr>
                                  <%  
                             }
                                %>
                </table> 
                </td>
            </tr>
            <tr>
                <td>
                    <label style="font-size: 14px;">Key Suppliers</label>
                    <table>
                        <tr>
                            <td>Key Suppliers</td>
                            <td>Vol Of Business(Ksh'M)</td>
                            <td>Banked By I&M</td>
                            <td>Contact Person</td>
                            <td>Comment</td>
                        </tr>
                        
                            <%    
                              for(KeyDistributorModel kdModel : kdInf){
                                %>
                                <tr>
                            <td><%=kdModel.getKdandclients()%></td>
                            <td><%=kdModel.getVolofbusnskdandclient()%></td>
                            <td><%=kdModel.getBankedbyim()%></td>
                            <td><%=kdModel.getKdContactperson()%></td>
                            <td><%=kdModel.getComments()%></td>
                        </tr>
                        <%  
                             }
                                %>
                    </table>
                </td> 
                <td>
                    <label style="font-size: 14px;">Key Distributors</label>
                    <table>
                        <tr>
                            <td>KD and Clients</td>
                            <td>Vol Of Business(Ksh'M)</td>
                            <td>Banked By I&M</td>
                            <td>Contact Person</td>
                            <td>Comment</td>
                        </tr>
                        
                            <%     
                              for(KeySupplierModel ksModel : ksInfo){
                                %>
                                <tr>
                            <td><%=ksModel.getKsname()%></td>
                            <td><%=ksModel.getVolofbusiness()%></td>
                            <td><%=ksModel.getBankedbyim()%></td>
                            <td><%=ksModel.getKsContactperson()%></td>
                            <td><%=ksModel.getComments()%></td>
                        </tr>
                        <%  
                             }
                                %>
                    </table>
                </td>
                <td>
                    <label style="font-size: 14px;">Client Employees</label>
                    <table>
                        <tr>
                            <td>#Employees</td>
                            <td>#Banked Employees(All Banks)</td>
                            <td>Target #Employees Banked By I&M</td>
                            <td>Contact Person</td>
                            <td>#Employees Banked By I&M</td>
                        </tr>
                        
                            <%     
                              for(ClientEmployeeModel ceModel : cemInf){
                                %>
                                <tr>
                            <td><%=ceModel.getNoofemployees()%></td>
                            <td><%=ceModel.getNoofbankedemployeesallbanks()%></td>
                            <td><%=ceModel.getTargetnoofemployeesbyim()%></td>
                            <td><%=ceModel.getClientEmployeeContactperson()%></td>
                            <td><%=ceModel.getNoofbankedemployeeswithim()%></td>
                        </tr>
                        <%  
                             }
                                %>
                    </table>
                </td>
            </tr>
            <tr>
                <td>
                <label style="font-size: 14px;">Qualitative Information</label>     
                <table>
                    <%  
                              for(QualitativeinformationModel qiModel : qInf){
                                %>
                    <tr>
                        <td> Client Strategy
                        </td><td> <%=qiModel.getClientstrategy()%>
                        </td>
                    </tr>
                    <tr>
                        <td> Client Logic For wallet Allocation
                        </td><td> <%=qiModel.getClientwalletalloctnlogic()%>
                        </td>
                    </tr>
                    <tr>
                      <td> Opportunities
                        </td><td> <%=qiModel.getOpportunities()%>
                        </td>  
                    </tr>
                    <tr>
                        <td> Specific Challenges
                        </td><td> <%=qiModel.getSpecificchallenges()%>
                        </td>
                    </tr>
                    <tr>
                        <td> Quality Of Relationship
                        </td><td> <%=qiModel.getRelationshipquality()%>
                        </td>
                    </tr>
                    <%  
                             }
                                %>
                </table>    
                </td>
                </tr>
            <tr>
                <td>
               <label style="font-size: 14px;">Competition</label>     
                    <table>
                        <tr>
                            <td>Bank</td>
                            <td>Estimated Wallet Share(%)</td>
                            <td>Strengths(Threats to Us)</td>
                            <td>Weaknesses</td> 
                        </tr>
                        
                            <%      
                              for(CompetitionModel compeModel : cmInfo){
                                %>
                                <tr>
                            <td><%=compeModel.getBank()%></td>
                            <td><%=compeModel.getEstimatedwalletshare()%></td>
                            <td><%=compeModel.getStrengths()%></td>
                            <td><%=compeModel.getWeaknesses()%></td> 
                        </tr>
                        <%  
                             }
                                %>
                    </table>
                </td>
            </tr>
             <tr>
                <td>
               <label style="font-size: 14px;">Current and Future Opportunities</label>     
                    <table>
                        <tr>
                            <td>Product</td>
                            <td>Currently used</td>
                            <td>Deal Amount for(I&M) Ksh'M</td>
                            <td>Size of Wallet for all banks (Ksh'M)</td> 
                            <td>Projected I&M Share Of Wallet(%)</td>
                            <td>Expected I&M Revenue(Ksh 'M)</td>
                            <td>Probability Of Deal(%)</td>
                            <td>Stage Of Deal</td>
                            <td>Deal Identification Date</td>
                            <td>Expected Month Of Completion</td>
                            <td>Deal Status</td>
                            <td>Deal Type</td>
                            <td>Comment</td>
                        </tr>
                        
                            <%      
                              for(DealProgressModel dipModel : dipInfo){
                                %>
                                <tr>
                            <td><%=dipModel.getProductlookupid()%></td>
                            <td><%=dipModel.getCurrentlyused()%></td>
                            <td><%=dipModel.getImdealamount()%></td>
                            <td><%=dipModel.getAllbankswalletsize()%></td>
                            <td><%=dipModel.getImprojectedwalletshare()%></td>
                            <td><%=dipModel.getImexpectedrevenue()%></td>
                            <td><%=dipModel.getDealpropabilitylookupid()%></td>
                            <td><%=dipModel.getDealstagelookupmasterid()%></td>
                            <td><%=dipModel.getCompletionmonthlookupid()%></td>
                            <td><%=dipModel.getCompletionmonthlookupid()%></td>
                            <td><%=dipModel.getDealstatuslookupmasterid()%></td>
                            <td><%=dipModel.getDealtypelookupmasterid()%></td>
                            <td><%=dipModel.getComments()%></td>
                        </tr>
                        <%  
                             }
                                %>
                    </table>
                </td>
            </tr>
             <tr>
                <td>
               <label style="font-size: 14px;">Client Coverage Profile and Meeting History</label>     
                    <table>
                        <tr>
                            <td>Name</td>
                            <td>Role</td>
                            <td>Client Contact</td>
                            <td>Quality Of Relationship</td> 
                            <td>Last Contact</td>
                            <td>Summary Of Discussion</td> 
                            <td>Next Planned Contact</td>
                            <td>Purpose Of Next Contact</td>
                        </tr>
                        
                            <%        
                              for(ClientCoverageModel ccmModel : ccmInfo){
                                %>
                                <tr>
                            <td><%=ccmModel.getClientofficername()%></td>
                            <td><%=ccmModel.getClientofficerposition()%></td>
                            <td><%=ccmModel.getClientofficercontact()%></td>
                            <td><%=ccmModel.getClientofcerrnshipqlty()%></td>
                            <td><%=ccmModel.getClientofficerlastcontact()%></td>
                            <td><%=ccmModel.getClientofficerdiscussionsummary()%></td>
                            <td><%=ccmModel.getClientofficernextplanedcontact()%></td>
                            <td><%=ccmModel.getClientofficernxtcntctpurpose()%></td> 
                        </tr>
                        <%  
                             }
                                %>
                    </table>
                </td>
            </tr>
    </table>
 </div>
       </div>
        </div>
   

</form>










<%@ include file="../include/footer.jsp" %>