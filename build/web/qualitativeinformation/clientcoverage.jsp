<%@page import="com.inm.dao.client.ClientFinacial"%>
<%@page import="com.inm.dao.client.Company"%>
<%@page import="com.inm.models.ClientFinacialModel"%> 
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
						<h2>Manage <b>Credit Financials</b></h2>
					</div>
					<div class="col-sm-6">
						<a href="#addCreditFinancialModal" class="btn btn-success" data-toggle="modal"><i class="material-icons">&#xE147;</i> <span>Add New CreditFinancial</span></a>
						<a href="#deleteCreditFinancialModal" class="btn btn-danger" data-toggle="modal"><i class="material-icons">&#xE15C;</i> <span>Delete</span></a>						
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
                        <th>TurnOver</th>
			<th>Operating Profit</th>
                        <th>Total Debt</th>
                        <th>Total Deposits</th>
                        <th>Gearing Ratio</th>
                        <th>Cash Flow Cycle</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        ArrayList<ClientFinacialModel> list = ClientFinacial.getClientFinancialInfo(user_code);
                        for(ClientFinacialModel clientFinancialModel :list){
                        %>
                    <tr>
						<td>
							<span class="custom-checkbox">
								<input type="checkbox" id="checkbox1" name="options[]" value="1">
								<label for="checkbox1"></label>
							</span>
						</td>
                        <td><%=clientFinancialModel.getClientID()%></td>
                        <td><%=clientFinancialModel.getTurnover()%></td>
			<td><%=clientFinancialModel.getOperatingProfit()%></td>
                        <td><%=clientFinancialModel.getTotalDebt()%></td>
                        <td><%=clientFinancialModel.getTotalDeposits()%></td>
                        <td><%=clientFinancialModel.getGearingRatio()%></td>
                        <td><%=clientFinancialModel.getCashFlowCycle()%></td>
                        <td>
                            <a href="#editCreditFinancialModal" class="edit" data-toggle="modal"><i class="material-icons" data-toggle="tooltip" title="Edit">&#xE254;</i></a>
                            <a href="#deleteCreditFinancialModal" class="delete" data-toggle="modal"><i class="material-icons" data-toggle="tooltip" title="Delete">&#xE872;</i></a>
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
	<div id="addCreditFinancialModal" class="modal fade">
		<div class="modal-dialog">
			<div class="modal-content">
				<form>
					<div class="modal-header">						
						<h4 class="modal-title">Add Credit Financial Information</h4>
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
							<label>TurnOver(Ksh'M)</label>
							<input type="text" name="trunovera" id="trunovera" class="form-control" required>
						</div>
						<div class="form-group">
							<label>Operating Profit(Ksh'M)</label>
							<input type="text" name="operatingprofta" id="operatingprofta" class="form-control" required>
						</div>
						<div class="form-group">
							<label>Total Debt(Ksh'M)</label>
							<input type="text" name="totaldebta" id="totaldebta" class="form-control" required>
						</div>	
                                                 <div class="form-group">
							<label>Total Deposits(Ksh'M)</label>
							<input type="text" name="totaldeposita" id="totaldeposita" class="form-control" required>
						</div>
                                                <div class="form-group">
							<label>Gearing Ratio</label>
							<input type="text" name="geeringratioa" id="geeringratioa" class="form-control" required>
						</div>
                                                <div class="form-group">
							<label>Cash Flow Cycle(Days)</label>
							<input type="text" name="cashflowcyclea" id="cashflowcyclea" class="form-control" required>
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
	<div id="editCreditFinancialModal" class="modal fade">
		<div class="modal-dialog">
			<div class="modal-content">
				<form>
					<div class="modal-header">						
						<h4 class="modal-title">Edit CreditFinancial</h4>
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
	<div id="deleteCreditFinancialModal" class="modal fade">
		<div class="modal-dialog">
			<div class="modal-content">
				<form>
					<div class="modal-header">						
						<h4 class="modal-title">Delete CreditFinancial</h4>
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