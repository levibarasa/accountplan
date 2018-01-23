<%@page import="com.inm.dao.client.AccountRevenue"%>
<%@page import="com.inm.models.AccountRevenueModel"%> 
<%@page import="com.inm.dao.client.Company"%>
<%@page import="java.util.ArrayList"%> 
<%@ include file="../include/header.jsp" %>

<html>
<head>
    <script type="text/javascript">
 
            var form = $('#addClient');
            form.submit(function () {

            $.ajax({
            type: "POST",
            url: ${pageContext.request.contextPath}+'/do?MOD=BOK&ACT=doAddClient',
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
						<a href="#addAccountRevenueModal" class="btn btn-success" data-toggle="modal"><i class="material-icons">&#xE147;</i> <span>Add New AccountRevenue</span></a>
						<a href="#deleteAccountRevenueModal" class="btn btn-danger" data-toggle="modal"><i class="material-icons">&#xE15C;</i> <span>Delete</span></a>						
					</div>
                </div>
            </div>
            <table class="table table-striped table-hover">
                <thead>
                    <tr>
						<th>
							<span class="custom-checkbox">
								<input type="checkbox" id="selectAll">
								<label for="selectAll"></label>
							</span>
						</th>
                        <th>Client Name</th>
                        <th>Cur Yr Rev.Target(Ksh'M)</th>
			<th>Pr Yr Act.Revenue(Ksh'M)</th>
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
                        ArrayList<AccountRevenueModel> list = AccountRevenue.getAccountRevenuenfo(user_code);
                        for(AccountRevenueModel accountrevenuemodel :list){
                        %>
                    <tr>
						<td>
							<span class="custom-checkbox">
								<input type="checkbox" id="checkbox1" name="options[]" value="1">
								<label for="checkbox1"></label>
							</span>
						</td>
                        <td><%=accountrevenuemodel.getClientID()%></td>
                        <td><%=accountrevenuemodel.getCurrentYearRevenueTarget()%></td>
			<td><%=accountrevenuemodel.getPriorYearActualRevenue()%></td>
                        <td><%=accountrevenuemodel.getPercentageGrowthRevenue()%></td>
                        <td><%=accountrevenuemodel.getCurrentYearFeeIncomeTarget()%></td>
                        <td><%=accountrevenuemodel.getPriorYearActualFeeIncome()%></td>
                        <td><%=accountrevenuemodel.getPercentageGrowthFeeIncome()%></td>
                        <td><%=accountrevenuemodel.getCurrentShareOfWallet()%></td>
                        <td><%=accountrevenuemodel.getTargetShareOfWallet()%></td>
                        <td><%=accountrevenuemodel.getTotalValueOfIdentifiedOpportunities()%></td>
                        <td>
                            <a href="#editAccountRevenueModal" class="edit" data-toggle="modal"><i class="material-icons" data-toggle="tooltip" title="Edit">&#xE254;</i></a>
                            <a href="#deleteAccountRevenueModal" class="delete" data-toggle="modal"><i class="material-icons" data-toggle="tooltip" title="Delete">&#xE872;</i></a>
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
				<form>
					<div class="modal-header">						
						<h4 class="modal-title">Add Account Revenue Information</h4>
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
					</div>
					<div class="modal-body">					
						<div class="form-group">
                                                    <%
                                 ArrayList clientname = Company.getClientName();
                                  int noOfclientnames = clientname.size();
                                                        %>
							<label>Client Name</label>
				 <select name="clientnamea" id="clientnamea" class="form-control" required>
                                      <%
                                    for (int j = 0; j < noOfclientnames; j++) {
                                        ArrayList cll = (ArrayList) clientname.get(j);
                                        String clid = (String) cll.get(0); 
                                        String clname = (String) cll.get(1); 
                                %> 
                                <option value ="<%=clid%>" > <%=clname%></option>  
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
						<h4 class="modal-title">Edit AccountRevenue</h4>
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
					</div>
					<div class="modal-body">					
						<div class="form-group">
							<label>Name</label>
							<input type="text" class="form-control" required>
						</div>
						<div class="form-group">
							<label>Email</label>
							<input type="email" class="form-control" required>
						</div>
						<div class="form-group">
							<label>Address</label>
							<textarea class="form-control" required></textarea>
						</div>
						<div class="form-group">
							<label>Phone</label>
							<input type="text" class="form-control" required>
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


<%@ include file="../include/footer.jsp" %>