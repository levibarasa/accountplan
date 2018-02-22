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
   //ArrayList<SalesactionplanModel> sapInf =sap.getSaleActionPlanInfoByClientId(rmCode,clientId);
    %>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<!------ Include the above in your HEAD tag ---------->
<style type="text/css">
    
body {
    background-color: #dedede;
}

.topbar {
	background: #2A3F54;
	border-color: #2A3F54;
	border-radius: 0px;
}

.topbar .navbar-header a {
	color: #ffffff;
}

.wrapper {
    padding-left: 0px;
    -webkit-transition: all 0.5s ease;
    -moz-transition: all 0.5s ease;
    -o-transition: all 0.5s ease;
    transition: all 0.5s ease;
}

.sidebar {
    z-index: 1000;
    position: fixed;
    top: 50px;
    left: -50px;
    width: 50px;
    height: 100%;
    overflow-y: auto;
    background: #2A3F54;
	color: #ffffff;
	-webkit-transition: all 0.5s ease;
    -moz-transition: all 0.5s ease;
    -o-transition: all 0.5s ease;
    transition: all 0.5s ease;
}

.main {
	width: 100%;
    position: relative;
    padding-bottom:20px;
}

.wrapper.toggled {
	padding-left: 50px;
}

.wrapper.toggled .sidebar {
	left: 0;
}

/* Sidebar Styles */

.sidebar-nav {
    position: absolute;
    top: 52px;
    width: 50px;
    margin: 0;
    padding: 0;
    list-style: none;
}
.sidebar-nav li {
    line-height: 40px;
}
.sidebar-nav li a {
    display: block;
    text-decoration: none;
    color: #e8e8e8;
    padding: 0;
    text-align:center;
}

.sidebar-nav li a:hover, .sidebar-nav li.active a {
    text-decoration: none;
    color: #fff;
    background: #fff;
    background: rgba(255,255,255,0.2);
}

.sidebar-nav li a:active,
.sidebar-nav li a:focus {
    text-decoration: none;
}

.sidebar-nav li span, .subbar li span {
	display : none;
}

nav.subbar {
	position: relative;
	width: 100%;
	border-radius: 0px;
	background: #fff;
	margin: 50px 0 -50px 0;
	padding: 10px 0 0 0;
	z-index: 2;
}
nav.subbar > ul.nav.nav-tabs {
	padding: 0 5px;
}

nav.subbar > ul.nav.nav-tabs > li.active > a {
    background: #dedede;
    border-top: 1px solid #a6a6a6;
    border-left: 1px solid #a6a6a6;
    border-right: 1px solid #a6a6a6;
    border-radius: 0px;
}

.content {
    margin-top: 70px;
    padding: 0 30px;
}

@media(min-width:768px){
	.subbar li span {
		display: inline;
	}
}

@media(min-width:992px) {
    .wrapper {
    	padding-left: 50px;
    }

    .sidebar {
    	left: 0;
    	width: 50px;
	}

	.wrapper.toggled {
		padding-left: 200px;
	}

	.wrapper.toggled .sidebar, .wrapper.toggled .sidebar-nav {
		width: 200px;
	}
	
	.wrapper.toggled .sidebar-nav li a {
		text-align: left;
		padding: 0 0 0 10px;
	}

	.wrapper.toggled .sidebar-nav li span {
		display: inline;
	}

}

.navbar-btn {
    background: none;
    border: none;
    height: 35px;
    min-width: 35px;
    color: #fff;
}
.navbar-text {
  margin-top: 14px;
  margin-bottom: 14px;
}
@media (min-width: 768px) {
  .navbar-text {
    float: left;
    margin-left: 15px;
    margin-right: 15px;
  }
}
</style>
<script type="text/javascript">
    $(document).on("click",".sidebar-toggle",function(){
    $(".wrapper").toggleClass("toggled");
});
    </script>
<link href="http://fontawesome.io/assets/font-awesome/css/font-awesome.css" rel="stylesheet" media="screen">

    <nav class="navbar navbar-default navbar-fixed-top topbar">
		<div class="container-fluid">

			<div class="navbar-header">

				<a href="${pageContext.request.contextPath}/index.jsp" class="navbar-brand"> 
					<span class="hidden-xs">Go Back </span>
				</a>

				<p class="navbar-text">
					<a href="#" class="sidebar-toggle">
                        <i class="fa fa-bars"></i>
                    </a>
				</p>
                                <h2>Account Plan</h2>
			</div>

			<div class="navbar-collapse collapse" id="navbar-collapse-main">

				<ul class="nav navbar-nav navbar-right">
                    
                    <li>
                        <button class="navbar-btn">
                            <i class="fa fa-bell"></i>
                        </button>
                    </li>
                     	</ul>

			</div>
		</div>
	</nav>
	
	<article class="wrapper">
	    
	    <aside class="sidebar">
	        <ul class="sidebar-nav">
			    <li class="active"><a href="#dashboard" data-toggle="tab"><i class="fa fa-dashboard"></i> <span>Dashboard</span></a></li>
			    <li><a href="#configuration" data-toggle="tab"><i class="fa fa-cogs"></i> <span>Configuration</span></a></li>
			    <li><a href="#users" data-toggle="tab"><i class="fa fa-users"></i> <span>Users</span></a></li>
			    <li><a href="#mail" data-toggle="tab"><i class="fa fa-envelope"></i> <span>Mail</span></a></li>
		    </ul>
	    </aside>
	    
	    <section class="main">
	        
	        <section class="tab-content">
	            
	           <section class="tab-pane active fade in content" id="dashboard">
	               
	                
	                         
	                 <div class="col-xs-12 col-sm-9">
	                       <div class="panel panel-default">
	                           <div class="panel-heading">
	                               Client Information
	                           </div>
	                           <div class="panel-body"> 
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
                                       
                                       </div>
	                       </div>
	                   </div>
	                   
                            <div class="col-xs-12 col-sm-9">
	                       <div class="panel panel-default">
	                           <div class="panel-heading">
	                               Company Information
	                           </div>
	                           <div class="panel-body"> 
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
                                       
                                       </div>
	                       </div>
	                   </div>
                             <div class="col-xs-12 col-sm-9">
	                       <div class="panel panel-default">
	                           <div class="panel-heading">
	                               Account Revenue Information
	                           </div>
	                           <div class="panel-body"> 
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
                    </table   
                                       
                                       </div>
	                       </div>
	                   </div>
                            <div class="col-xs-12 col-sm-9">
	                       <div class="panel panel-default">
	                           <div class="panel-heading">
	                               Credit Information
	                           </div>
	                           <div class="panel-body"> 
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
                                       
                                       </div>
	                       </div>
	                   </div>
	                   <div class="col-xs-12 col-sm-9">
	                       <div class="panel panel-default">
	                           <div class="panel-heading">
	                               Client Financials
	                           </div>
	                           <div class="panel-body">
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
	                           </div>
	                       </div>
	                   </div>
	                   <div class="col-xs-12 col-sm-9">
	                       <div class="panel panel-default">
	                           <div class="panel-heading">
	                               Key Distributors
	                           </div>
	                           <div class="panel-body"> 
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
                                       
                                       </div>
	                       </div>
	                   </div>
	                    
                 <div class="col-xs-12 col-sm-9">
	                       <div class="panel panel-default">
	                           <div class="panel-heading">
	                               Key Suppliers
	                           </div>
	                           <div class="panel-body"> 
                                       
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
                                       </div>
	                       </div>
	                   </div>
	                  <div class="col-xs-12 col-sm-9">
	                       <div class="panel panel-default">
	                           <div class="panel-heading">
	                               Employees
	                           </div>
	                           <div class="panel-body"> 
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
                                       
                                       </div>
	                       </div>
	                   </div>
	               <div class="col-xs-12 col-sm-9">
	                       <div class="panel panel-default">
	                           <div class="panel-heading">
	                               Qualitative Information
	                           </div>
	                           <div class="panel-body"> 
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
                                       
                                       </div>
	                       </div>
	                   </div>
                <div class="col-xs-12 col-sm-9">
	                       <div class="panel panel-default">
	                           <div class="panel-heading">
	                               Competition
	                           </div>
	                           <div class="panel-body"> 
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
                                       
                                       </div>
	                       </div>
	                   </div>
                <div class="col-xs-12 col-sm-9">
	                       <div class="panel panel-default">
	                           <div class="panel-heading">
	                               Current And Future Opportunities
	                           </div>
	                           <div class="panel-body"> 
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
                                       
                                       </div>
	                       </div>
	                   </div>
                <div class="col-xs-12 col-sm-9">
	                       <div class="panel panel-default">
	                           <div class="panel-heading">
	                               Client Coverage profile and meeting History
	                           </div>
	                           <div class="panel-body"> 
                                       
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
                                       </div>
	                       </div>
	                   </div>
                <div class="col-xs-12 col-sm-9">
	                       <div class="panel panel-default">
	                           <div class="panel-heading">
	                               Sales Action Planning
	                           </div>
	                           <div class="panel-body"> 
                                       
                                       
                                       </div>
	                       </div>
	                   </div>
	           </section>
	           
	            
	           
	           <section class="tab-pane fade" id="users">
	               
	           </section>
	           
	           <section class="tab-pane fade" id="mail">
	               
	           </section>
	           
	        </section>
	        
	        
	                
	        
	    </section>
	    
	</article>