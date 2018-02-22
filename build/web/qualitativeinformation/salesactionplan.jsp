<%@page import="com.inm.dao.qualitativeinformation.*"%>
<%@page import="com.inm.models.*"%>  
<%@page import="java.util.ArrayList"%> 
<%@ include file="../include/header.jsp" %>

<html>
<head>
    <script type="text/javascript">
 
            var form = $('#addSaleActionPlan');
            form.submit(function () {

            $.ajax({
            type: "POST",
            url: ${pageContext.request.contextPath}+'/do?MOD=BOK&ACT=doAddSaleActionPlan',
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
						<h2>Manage <b>Sales Action Plan Information</b></h2>
					</div>
					<div class="col-sm-6">
						<a href="#addSaleActionPlanInformationModal" class="btn btn-success" data-toggle="modal"><i class="material-icons">&#xE147;</i> <span>Add New SaleActionPlanInformation</span></a>
						<a href="#deleteSaleActionPlanInformationModal" class="btn btn-danger" data-toggle="modal"><i class="material-icons">&#xE15C;</i> <span>Delete</span></a>						
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
                        <th>Specific Action</th>
			<th>Contact Person</th>
                        <th>Person Responsible For Action</th>
                        <th>DeadLine Date</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        SaleActionPlan sap = new SaleActionPlan();
                        ArrayList<SalesactionplanModel> list = sap.getSaleActionPlanInfo(user_code);
                        for(SalesactionplanModel salesactionplanModel :list){
                        %>
                    <tr>
						<td>
							<span class="custom-checkbox">
								<input type="checkbox" id="checkbox1" name="options[]" value="1">
								<label for="checkbox1"></label>
							</span>
						</td>
                        <td><%=salesactionplanModel.getClientMaster()%></td>
                        <td><%=salesactionplanModel.getSpecification()%></td>
			<td><%=salesactionplanModel.getClocontactpersion()%></td>
                        <td><%=salesactionplanModel.getClopersonresponsibleforaction()%></td>
                        <td><%=salesactionplanModel.getClodatelinedate()%></td>
                        <td>
                            <button onclick='fetchOldRecord(this);' class='btn btn-sm btn-info' data-toggle='modal' data-target='#editClientModal'>Update</button>
                            <button onclick='deleteUser(this);' class='btn btn-sm btn-danger'>Delete</button>
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
	<!-- Add Modal HTML -->
	<div id="addSaleActionPlanInformationModal" class="modal fade">
		<div class="modal-dialog">
			<div class="modal-content">
				<form   name="addSaleActionPlan"  method="POST"  action="${pageContext.request.contextPath}/do?MOD=BOK&ACT=doAddSaleActionPlan"  id="addSaleActionPlan">
					<div class="modal-header">						
						<h4 class="modal-title">Add New Sale Action Plan </h4>
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
					</div>
					<div class="modal-body">					
						<div class="form-group">
                                                    <%
                                 ArrayList<ClientModel> clientname = sap.getClientMasterList(user_code); 
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
							<label>Specific Action</label>
							<input type="text" name="specificationa" id="specificationa" class="form-control" required>
						</div>
						<div class="form-group">
							<label>Contact Person</label>
							<input type="text" name="contactpersona" id="contactpersona" class="form-control" required>
						</div>
						<div class="form-group">
							<label>Person Responsible For Action</label>
							<input type="text"  name="presponsibleforactiona" id="presponsibleforactiona"  class="form-control" required>
						</div>	
                                                <div class="form-group">
							<label>DeadLine Date</label>
							<input type="text"  name="dateLinea" id="dateLinea"  class="form-control" required>
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
	<div id="editSaleActionPlanInformationModal" class="modal fade">
		<div class="modal-dialog">
			<div class="modal-content">
				<form>
					<div class="modal-header">						
						<h4 class="modal-title">Edit Sales Action Plan </h4>
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
					</div>
					<div class="modal-body">					
						<div class="form-group">
                                                    <%
                                  clientname = sap.getClientMasterList(user_code); 
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
							<label>Specific Action</label>
							<input type="text" name="specificatione" id="specificatione" class="form-control" required>
						</div>
						<div class="form-group">
							<label>Contact Person</label>
							<input type="text" name="contactpersone" id="contactpersone" class="form-control" required>
						</div>
						<div class="form-group">
							<label>Person Responsible For Action</label>
							<input type="text"  name="presponsibleforactione" id="presponsibleforactione"  class="form-control" required>
						</div>	
                                                <div class="form-group">
							<label>Deadline Date</label>
							<input type="text"  name="dateLinee" id="dateLinee"  class="form-control" required>
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
	<div id="deleteSaleActionPlanInformationModal" class="modal fade">
		<div class="modal-dialog">
			<div class="modal-content">
				<form>
					<div class="modal-header">						
						<h4 class="modal-title">Delete SaleActionPlanInformation</h4>
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