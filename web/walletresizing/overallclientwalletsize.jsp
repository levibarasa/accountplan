<%@page import="com.inm.dao.walletresize.*"%>
<%@page import="com.inm.models.*"%> 
<%@page import="java.util.ArrayList"%> 
<%@ include file="../include/header.jsp" %>
<html>
<head>
    <script type="text/javascript">
 
            var form = $('#addOClientWalletSize');
            form.submit(function () {

            $.ajax({
            type: "POST",
            url: ${pageContext.request.contextPath}+'/do?MOD=BOK&ACT=doAddOClientWalletSize',
            data: form.serialize(),
            success: function (data) {
            var result=data;
           // $('#result').attr("value",result);
           alert(result);
            }
            });

            return false;
            });
</script>
 <script type="text/javascript"> 
//            function registerOverallClientWalletSize() {
//		var uname = $("#uname").val();
//		var clientname = $("#clientnamea").val();
//		var rmCode = $("#uemaila").val();
//		var altrmCode = $("#altrmCodea").val();
//                var affiliate = $("#affiliatea").val();
//                var currentdate = $("#currentdatea").val();
//                var tradesp = $("#tradespa").val();
//                var cashmp = $("#cashmpa").val();
//                var ebankp = $("#ebankpa").val();
//                var riskmp = $("#riskmpa").val(); 
//		$.ajax({
//			type : "POST",
//			url : ${pageContext.request.contextPath}+'/do?MOD=BOK&ACT=doAddOverallClientWalletSize',
//			data : "clientname=" + clientname + "&rmCode=" + rmCode + "&altrmCode=" + altrmCode
//                        + "&affiliate=" + affiliate+ "&currentdate=" + currentdate+ "&tradesp=" + tradesp+ "&cashmp=" + cashmp+ "&ebankp=" + ebankp+ "&riskmp=" + riskmp,
//			success : function(data) {
//				var ht = data.msg;
//                                alert(ht);
//				//$("#resp").html(ht);
//			},
//			error : function(data) {
//				alert("Some error occured.");
//			}
//		});
//	}
</script>
   </head>    
<div class="container">
        <div class="table-wrapper">
            <div class="table-title">
                <div class="row">
                    <div class="col-sm-6">
						<h2>Overall Client Wallet Size <b>Information</b></h2>
					</div>
					<div class="col-sm-6">
						<a href="#addOverallClientWalletSizeModal" class="btn btn-success" data-toggle="modal"><i class="material-icons">&#xE147;</i> <span>Add New OverallClientWalletSize</span></a>
						<a href="#deleteOverallClientWalletSizeModal" class="btn btn-danger" data-toggle="modal"><i class="material-icons">&#xE15C;</i> <span>Delete</span></a>						
					</div>
                </div>
            </div>
            <table id="clientinformation" class="table table-striped table-hover">
                <thead>
                    <tr>
						<th>
							<span class="custom-checkbox">
								<input type="checkbox" id="selectAll">
								<label for="selectAll"></label>
							</span>
						</th> 
                        <th>Client Name</th>
			<th>Total Corporate Dbt</th>
                        <th>Average I&M Loan Margin</th>
                        <th>Assets Interest Income</th>
                        <th>Estimated Corporate Deposits</th>
                        <th>Average I&M Deposit Margin</th>
                        <th>Net Interest Liability Income</th>
                        <th>Total Net Interest Income</th>
                        <th>Total NII</th>
                        <th>I&M Fee Income</th>
                        <th>Total Fee Income</th>
                        <th>Overall Client Wallet Size Banking Wallet</th>
                        <th>I&M Revenue</th>
                        <th>Estimated Wallet Share</th>                        
                        <th>Actions</th>
                    </tr>
                </thead> 
                <tbody>
                     
                    <%
                        OverallClientWalletSizeMaster ocwm = new OverallClientWalletSizeMaster();
                        ArrayList<OverallClientWalletSizeModel> list = ocwm.getOverallclientwalletsizeInfo(user_code);
                        for(OverallClientWalletSizeModel ocwmModel :list){
                        %>
                  <tr>
                  
						<td>
							<span class="custom-checkbox">
								<input type="checkbox" id="checkbox1" name="options[]" value="1">
								<label for="checkbox1"></label>
							</span>
						</td> 
                        <td><%=ocwmModel.getClientMaster()%></td>
			<td><%=ocwmModel.getTotalcorporatedebt()%></td>
                        <td><%=ocwmModel.getAverageimloanmargin()%></td>
                        <td><%=ocwmModel.getAssetsinterestincome()%></td>
                        <td> <%=ocwmModel.getEstimatedcorporatedeposits()%></td>
                        <td><%=ocwmModel.getAverageimdepositmargin()%> </td>
                        <td><%=ocwmModel.getNetintrstliabltyincome()%></td>
                        <td><%=ocwmModel.getTotalnetinterestincome()%></td>
                        <td><%=ocwmModel.getTotalnii()%> </td>
                        <td><%=ocwmModel.getImfeeincome()%> </td>
                        <td><%=ocwmModel.getTotalfeeincome()%> </td>
                        <td><%=ocwmModel.getClientbankingwallet()%> </td>
                        <td><%=ocwmModel.getImrevenue()%> </td>
                        <td><%=ocwmModel.getEstimatedwalletshare()%> </td>
                        <td>
                            <a href="#editOverallClientWalletSizeModal" class="edit" data-toggle="modal"><i class="material-icons" data-toggle="tooltip" title="Edit">&#xE254;</i></a>
                            <a href="#deleteOverallClientWalletSizeModal" class="delete" data-toggle="modal"><i class="material-icons" data-toggle="tooltip" title="Delete">&#xE872;</i></a>
                        </td>
                        </tr>
                        <%
                        }
                        %>
                    </tbody>
            </table>
			<div class="clearfix">
                <div class="hint-text">Showing <b>1</b> out of <b>1</b> entries</div>
                <ul class="pagination">
                    <li class="page-item disabled"><a href="#">Previous</a></li>
                    <li class="page-item active "><a href="#" class="page-link">1</a></li>
                    <li class="page-item"><a href="#" class="page-link">2</a></li>
                    <li class="page-item "><a href="#" class="page-link">3</a></li> 
                    <li class="page-item"><a href="#" class="page-link">Next</a></li>
                </ul>
            </div>
        </div>
    </div>
	<!-- ADD Modal HTML -->
	<div id="addOverallClientWalletSizeModal" class="modal fade">
		<div class="modal-dialog">
			<div class="modal-content">
            <form  name="addOClientWalletSize"  method="POST"  action="${pageContext.request.contextPath}/do?MOD=BOK&ACT=doAddOClientWalletSize"  id="addOClientWalletSize">
		<input type="hidden" name="uname" id="uname" value="<%= user_code%>"> 			
                <div class="modal-header">						
						<h4 class="modal-title">Add Overall Client Wallet Size</h4>
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
					</div>
					<div class="modal-body">					
						 
						<div class="form-group">
                                                    <%
                                 ArrayList<ClientModel> clientname = ocwm.getClientMasterList(user_code); 
                                                        %>
							<label>Client Name</label>
				 <select name="clientnamea" id="clientnamea" class="form-control" required>
                                      <%
                                    for(ClientModel cl : clientname){ 
                                %> 
                                <option value ="<%=cl.getClientid()%>" > <%=cl.getClientname()%></option>  
                                <%
                                    }

                                %>   
                                     </select>
				 </div>
                                          
                                <div class="form-group">
                                           <label>Average I&M Loans Margin(%)</label>
                                           <input name="imavgloanmargina" id="imavgloanmargin" type="text" class="form-control" required>
                                   </div>    
                                   <div class="form-group">
                                           <label>Average I&M Margin On Deposits(%)</label>
                                           <input name="avgimmargindepositsa" id="avgimmargindepositsa" type="text" class="form-control" required>
                                   </div>	
                                           <div class="form-group">
                                           <label>I&M Fee Income(Interest Income for Client  %)</label>
                                           <input name="imincomeinteresta" id="imincomeinteresta" type="text" class="form-control" required>
                                   </div> 
					</div>
					<div class="modal-footer">
						<input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
						<input type="submit" onclick="registerOverallClientWalletSize();"  class="btn btn-success" value="Add">
					</div>
				</form>
			</div>
		</div>
	</div>
	<!-- Edit Modal HTML -->
	<div id="editOverallClientWalletSizeModal" class="modal fade">
		<div class="modal-dialog">
			<div class="modal-content">
				<form   name="edditOverallClientWalletSize" method="GET" action="do?MOD=BOK&ACT=doUpdateOverallClientWalletSize" id="edditOverallClientWalletSize">
                                     	<div class="modal-header">						
						<h4 class="modal-title">Edit Overall Client Wallet Size</h4>
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
					</div>
					<div class="modal-body">					
						
						<div class="form-group">
                                                    <%
                                  clientname = ocwm.getClientMasterList(user_code); 
                                                        %>
							<label>Client Name</label>
				 <select name="clientnamee" id="clientnamea" class="form-control" required>
                                      <%
                                    for(ClientModel cl : clientname){ 
                                %> 
                                <option value ="<%=cl.getClientid()%>" > <%=cl.getClientname()%></option>  
                                <%
                                    }
                                %>   
                                     </select>
				 </div>
                                          
                                <div class="form-group">
                                           <label>Average I&M Loans Margin(%)</label>
                                           <input name="imavgloanmargine" id="imavgloanmargin" type="text" class="form-control" required>
                                   </div>    
                                   <div class="form-group">
                                           <label>Average I&M Margin On Deposits(%)</label>
                                           <input name="avgimmargindepositse" id="avgimmargindepositsa" type="text" class="form-control" required>
                                   </div>	
                                           <div class="form-group">
                                           <label>I&M Fee Income(Interest Income for Client  %)</label>
                                           <input name="imincomeintereste" id="imincomeinteresta" type="text" class="form-control" required>
                                   </div> 
					</div>
					<div class="modal-footer">
						<input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
						<input type="submit" class="btn btn-info" value="Save">
					</div>
                                                      
				</form>
			</div>
		</div>
	</div>
	<!-- Delete Modal HTML -->
	<div id="deleteOverallClientWalletSizeModal" class="modal fade">
		<div class="modal-dialog">
			<div class="modal-content">
				<form>
					<div class="modal-header">						
						<h4 class="modal-title">Delete Overall Client Wallet Size</h4>
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
					</div>
					<div class="modal-body">					
						<p>Are you sure you want to delete these Records?</p>
						<p class="text-warning"><small>This action cannot be undone.</small></p>
					</div>
					<div class="modal-footer">
						<input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
						<input type="submit" class="btn btn-danger" value="Delete">
					</div>
				</form>
			</div>
		</div>
	</div>



<%@ include file="../include/footer.jsp" %>