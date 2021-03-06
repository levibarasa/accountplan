<%@page import="com.inm.dao.client.AccountRevenue"%>
<%@page import="com.inm.models.*"%> 
<%@page import="com.inm.dao.client.Company"%>
<%@page import="java.util.ArrayList"%> 
<%@ include file="../include/header.jsp" %>

<html>
<head>
    <script type="text/javascript">
        $(document).ready(function() {
    $('#accountplantable').DataTable( {
        responsive: {
            details: {
                display: $.fn.dataTable.Responsive.display.modal( {
                    header: function ( row ) {
                        var data = row.data();
                        return 'Details for '+data[0];
                    }
                } ),
                renderer: $.fn.dataTable.Responsive.renderer.tableAll( {
                    tableClass: 'table'
                } )
            }
        }
    } );
} );
        </script>
          <script type="text/javascript">  
//totidoppe,totwalshre,curwalletshre,priyractfeee,curyrfeetarge,priyractreve,curyrrevtarge,clientnamee,accountrevenueId
      function fetchOldRecord(that){	 
            $("#accountrevenueId").val($(that).parent().prev().prev().prev().prev().prev().prev().prev().prev().prev().text());
            $("#clientnamee").val($(that).parent().prev().prev().prev().prev().prev().prev().prev().prev().text());
           $("#curyrrevtarge").val($(that).parent().prev().prev().prev().prev().prev().prev().prev().text());
           $("#priyractreve").val($(that).parent().prev().prev().prev().prev().prev().prev().text());
           $("#curyrfeetarge").val($(that).parent().prev().prev().prev().prev().prev().text());
           $("#priyractfeee").val($(that).parent().prev().prev().prev().prev().text());
          $("#curwalletshre").val($(that).parent().prev().prev().prev().text());
            $("#totwalshre").val($(that).parent().prev().prev().text());
           $("#totidoppe").val($(that).parent().prev().text()); 
       	} 
       
   $('#editAccountRevenueModal').modal('show'); 
       </script>
    <script type="text/javascript">
 
            var form = $('#addAccountRevenue');
            form.submit(function () {

            $.ajax({
            type: "POST",
            url: ${pageContext.request.contextPath}+'/do?MOD=BOK&ACT=doAddAccountRevenue',
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
</head>
<div class="container">
        <div class="table-wrapper">
            <div class="table-title">
                <div class="row">
                    <div class="col-sm-6">
						<h2>Manage <b>Account Revenue Information</b></h2>
					</div>
					<div class="col-sm-6">
						<a href="#addAccountRevenueModal" class="btn btn-success" data-toggle="modal"><i class="material-icons">&#xE147;</i> <span>Add New Account Revenue</span></a>
						<a href="#deleteAccountRevenueModal" class="btn btn-danger" data-toggle="modal"><i class="material-icons">&#xE15C;</i> <span>Delete</span></a>						
					</div>
                </div>
            </div>
            <table id="accountplantable" class="table table-striped table-hover">
                <thead>
                    <tr> 
                        <th>#</th> 
                        <th>Client Name</th>
                        <th style="display: none;">Cur Yr Rev.Target(Ksh'M)</th>
			<th  style="display: none;">Pr Yr Act.Revenue(Ksh'M)</th> -->
                        <th>% Growth Revenue</th>
                        <th  style="display: none;">Cur Yr FeeInc.Target(Ksh'M)</th>
                      <th  style="display: none;"> Pr Yr Act.Fee Income(Ksh'M)</th>
                        <th>% Growth FeeIncome</th> 
                        <th>Cur WalletShare</th>
                        <th>Target WalletShare</th>
                        <th>Tot.Val. Of Id.Opportunitie(Ksh'M)</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                      <%
                          AccountRevenue ar = new AccountRevenue();
                        ArrayList<AccountRevenueModel> list = ar.getAccountRevenuenfo(user_code);
                        for(AccountRevenueModel accountrevenuemodel :list){
                        %>
                    <tr>
                        <td> <%=accountrevenuemodel.getAccountRevenueid()%> </td>
                        <td><%=accountrevenuemodel.getClientMaster()%></td>
                        <td  style="display: none;"><%=accountrevenuemodel.getCurrentyearrevenuetarget()%></td>
			<td  style="display: none;"><%=accountrevenuemodel.getPrioryearactualrevenue()%></td>  
                        <td><%=accountrevenuemodel.getPercentagegrowthrevenue()%></td>
                        <td  style="display: none;"><%=accountrevenuemodel.getCurrentyearnfitarget()%></td>
                        <td  style="display: none;"><%=accountrevenuemodel.getPrioryearactualfeeincome()%></td>  
                        <td><%=accountrevenuemodel.getPercentagegrowthfeeincome()%></td>
                        <td><%=accountrevenuemodel.getCurrentshareofwallet()%></td>
                        <td><%=accountrevenuemodel.getTargetshareofwallet()%></td>
                        <td><%=accountrevenuemodel.getTotalvalueofidopportunities()%></td>
                        <td>
                            <button onclick='fetchOldRecord(this);' class='btn btn-sm btn-info' data-toggle='modal' data-target='#editAccountRevenueModal'>Update</button>
                            <button onclick='deleteUser(this);' class='btn btn-sm btn-danger' data-target='#deleteAccountRevenueModal'>Delete</button>
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
	<div id="addAccountRevenueModal" class="modal fade">
		<div class="modal-dialog">
			<div class="modal-content">
				<form  name="addAccountRevenue"  method="POST"  action="${pageContext.request.contextPath}/do?MOD=BOK&ACT=doAddAccountRevenue"  id="addAccountRevenue">
					<div class="modal-header">						
						<h4 class="modal-title">Add Account Revenue Information</h4>
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
					</div>
					<div class="modal-body">					
						<div class="form-group">
                                                    <%
                                 ArrayList<ClientModel> clientname = ar.getClientMasterList(user_code); 
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
							<label>Current Year Revenue Target(Ksh'M)</label>
							<input type="text" name="curyrrevtarga" id="curyrrevtarga" class="form-control" required>
						</div>
						<div class="form-group">
							<label>Prior Year Actual Revenue(Ksh'M)</label>
							<input type="text" name="priyractreva" id="priyractreva" class="form-control" required>
						</div>
						<div class="form-group">
							<label>Current Year Fee Income Target(Ksh'M)</label>
							<input type="text" name="curyrfeetarga" id="curyrfeetarga" class="form-control" required>
						</div>	
                                                <div class="form-group">
							<label>Prior Year Actual Fee Income(Ksh'M)</label>
							<input type="text" name="priyractfeea" id="priyractfeea" class="form-control" required>
						</div>
                                                <div class="form-group">
							<label>Current Share Of Wallet(%)</label>
							<input type="text" name="curwalletshra" id="curwalletshra" class="form-control" required>
						</div>
                                            <div class="form-group">
							<label>Target Share Of Wallet(%)</label>
							<input type="text" name="totwalshra" id="totwalshra" class="form-control" required>
						</div>
                                                 <div class="form-group">
							<label>Total Value Of Identified Opportunities(Ksh'M)</label>
							<input type="text" name="totidoppa" id="totidoppa" class="form-control" required>
						</div>
                                              
					</div>
					<div class="modal-footer">
						<input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
						<input type="submit" class="btn btn-success" value="Add">
					</div>
				</form>
			</div>
		</div>
	</div>
	<!-- Edit Modal HTML -->
	<div id="editAccountRevenueModal" class="modal fade">
		<div class="modal-dialog">
			<div class="modal-content">
				<form>
					<div class="modal-header">						
						<h4 class="modal-title">Edit Account Revenue Information</h4>
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
					</div>
					<div class="modal-body">					
						<div class="form-group">
                                                    <input  name="accountrevenueId" id="accountrevenueId"   type="text" class="form-control" required>
                                                    <%
                                   clientname = ar.getClientMasterList(user_code); 
                                                        %>
							<label>Client Name</label>
				 <select name="clientnamee" id="clientnamee" class="form-control" required>
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
							<label>Current Year Revenue Target(Ksh'M)</label>
							<input type="text" name="curyrrevtarge" id="curyrrevtarge" class="form-control" required>
						</div>
						<div class="form-group">
							<label>Prior Year Actual Revenue(Ksh'M)</label>
							<input type="text" name="priyractreve" id="priyractreve" class="form-control" required>
						</div>
						<div class="form-group">
							<label>Current Year Fee Income Target(Ksh'M)</label>
							<input type="text" name="curyrfeetarge" id="curyrfeetarge" class="form-control" required>
						</div>	
                                                <div class="form-group">
							<label>Prior Year Actual Fee Income(Ksh'M)</label>
							<input type="text" name="priyractfeee" id="priyractfeee" class="form-control" required>
						</div>
                                                <div class="form-group">
							<label>Current Share Of Wallet(%)</label>
							<input type="text" name="curwalletshre" id="curwalletshre" class="form-control" required>
						</div>
             
                                            <div class="form-group">
							<label>Target Share Of Wallet(%)</label>
							<input type="text" name="totwalshre" id="totwalshre" class="form-control" required>
						</div>
                                             <div class="form-group">
							<label>Total Value Of Identified Opportunities(Ksh'M)</label>
							<input type="text" name="totidoppe" id="totidoppe" class="form-control" required>
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
	<div id="deleteAccountRevenueModal" class="modal fade">
		<div class="modal-dialog">
			<div class="modal-content">
				<form>
					<div class="modal-header">						
						<h4 class="modal-title">Delete AccountRevenue</h4>
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
<div id="accountplan" class="modal fade">
        <div class="table-wrapper">
            
            <table class="table table-striped table-hover">
                <thead>
                    <tr> 
                        <th>Client Name</th>
                       <th>Cur Yr Rev.Target(Ksh'M)</th>
			<th>Pr Yr Act.Revenue(Ksh'M)</th> -->
                        <th>% Growth Revenue</th>
                        <th>Cur Yr FeeInc.Target(Ksh'M)</th>
                      <th> Pr Yr Act.Fee Income(Ksh'M)</th>
                        <th>% Growth FeeIncome</th> 
                        <th>Cur WalletShare</th>
                        <th>Target WalletShare</th>
                        <th>Tot.Val. Of Id.Opportunitie(Ksh'M)</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                      <%
                         ar = new AccountRevenue();
                         list = ar.getAccountRevenuenfo(user_code);
                        for(AccountRevenueModel accountrevenuemodel :list){
                        %>
                    <tr> 
                        <td><%=accountrevenuemodel.getClientMaster()%></td>
                        <td><%=accountrevenuemodel.getCurrentyearrevenuetarget()%></td>
			<td><%=accountrevenuemodel.getPrioryearactualrevenue()%></td>  
                        <td><%=accountrevenuemodel.getPercentagegrowthrevenue()%></td>
                        <td><%=accountrevenuemodel.getCurrentyearnfitarget()%></td>
                        <td><%=accountrevenuemodel.getPrioryearactualfeeincome()%></td>  
                        <td><%=accountrevenuemodel.getPercentagegrowthfeeincome()%></td>
                        <td><%=accountrevenuemodel.getCurrentshareofwallet()%></td>
                        <td><%=accountrevenuemodel.getTargetshareofwallet()%></td>
                        <td><%=accountrevenuemodel.getTotalvalueofidopportunities()%></td>
                        <td>
                        </td>
                    </tr> 
		<%
                        }
                        %>			
                </tbody>
            </table>
			 
        </div>
    </div>

<%@ include file="../include/footer.jsp" %>