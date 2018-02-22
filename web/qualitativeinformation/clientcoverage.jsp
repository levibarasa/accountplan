<%@page import="com.inm.dao.qualitativeinformation.*"%> 
<%@page import="com.inm.models.*"%> 
<%@page import="java.util.ArrayList"%>  
<%@ include file="../include/header.jsp" %>

<html>
<head>
    <script type="text/javascript">
 
            var form = $('#addClientCoverage');
            form.submit(function () {

            $.ajax({
            type: "POST",
            url: ${pageContext.request.contextPath}+'/do?MOD=BOK&ACT=doAddClientCoverage',
            data: form.serialize(),
            success: function (data) {
            var result=data; 
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
						<h2>Manage <b>Client Coverage and Profile</b></h2>
					</div>
					<div class="col-sm-6">
						<a href="#addClientCoverageFinancialModal" class="btn btn-success" data-toggle="modal"><i class="material-icons">&#xE147;</i> <span>Add New Client Coverage And Profile</span></a>
						<a href="#deleteClientCoverageFinancialModal" class="btn btn-danger" data-toggle="modal"><i class="material-icons">&#xE15C;</i> <span>Delete</span></a>						
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
                        <th>Contact Name</th>
			<th>Contact Position</th>
                        <th>Contact Detail</th>
                        <th>Relationship Quality</th>
                        <th>Last Contact</th>
                        <th>Discussion summary</th>
                        <th>Next Contact</th>
                        <th>Next Contact Purpose</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        ClientCoverageMaster ccm = new ClientCoverageMaster();
                        ArrayList<ClientCoverageModel> list = ccm.getClientCoverageInfo(user_code);
                        for(ClientCoverageModel clientCoverageModel :list){
                        %>
                    <tr>
						<td>
							<span class="custom-checkbox">
								<input type="checkbox" id="checkbox1" name="options[]" value="1">
								<label for="checkbox1"></label>
							</span>
						</td>
                        <td><%=clientCoverageModel.getClientMaster()%></td>
                        <td><%=clientCoverageModel.getClientofficername()%></td>
			<td><%=clientCoverageModel.getClientofficerposition()%></td>
                        <td><%=clientCoverageModel.getClientofficercontact()%></td>
                        <td><%=clientCoverageModel.getClientofcerrnshipqlty()%></td>
                        <td><%=clientCoverageModel.getClientofficerlastcontact()%></td>
                        <td><%=clientCoverageModel.getClientofficerdiscussionsummary()%></td>
                        <td><%=clientCoverageModel.getClientofficernextplanedcontact()%></td>
                        <td><%=clientCoverageModel.getClientofficernxtcntctpurpose()%></td>
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
	<!-- ADD Modal HTML -->
	<div id="addClientCoverageFinancialModal" class="modal fade">
		<div class="modal-dialog">
			<div class="modal-content">
				<form  name="addClientCoverage"  method="POST"  action="${pageContext.request.contextPath}/do?MOD=BOK&ACT=doAddClientCoverage"  id="addClientCoverage">
					<div class="modal-header">						
						<h4 class="modal-title">Add Client Coverage Information</h4>
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
					</div>
					<div class="modal-body">					
						<div class="form-group">
                                                    <%
                                 ArrayList<ClientModel> clientname = ccm.getClientMasterList(user_code); 
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
                                    <label>Contact Person Name</label>
                                    <input type="text" name="contactnamea" id="contactnamea" class="form-control" required>
                            </div>
                            <div class="form-group">
                                    <label>Contact Person Position</label>
                                    <input type="text" name="contactpositiona" id="contactpositiona" class="form-control" required>
                            </div>
                            <div class="form-group">
                                    <label>Contact </label>
                                    <input type="text" name="contacta" id="contacta" class="form-control" required>
                            </div>	
                             <div class="form-group">
                                    <label>Relationship Quality</label>
                                    <input type="text" name="rshpqltya" id="rshpqltya" class="form-control" required>
                            </div>
                            <div class="form-group">
                                    <label>Last Contact</label>
                                    <input type="text" name="lastcontacta" id="lastcontacta" class="form-control" required>
                            </div>
                            <div class="form-group">
                                    <label>Last Discussion summary</label>
                                      <textarea  name="discussionsummarya" id="discussionsummarya" class="form-control" required></textarea>
                            </div>
                            <div class="form-group">
                                    <label>Next Planned Contact</label>
                                      <textarea  name="nxtplanedcontacta" id="nxtplanedcontacta" class="form-control" required></textarea>
                            </div>
                             <div class="form-group">
                                    <label>Next Planned Contact Purpose</label>
                                      <textarea  name="nxtplanedcontactpurposa" id="nxtplanedcontactpurposa" class="form-control" required></textarea>
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
	<div id="editClientCoverageFinancialModal" class="modal fade">
		<div class="modal-dialog">
			<div class="modal-content">
				<form>
					<div class="modal-header">						
						<h4 class="modal-title">Add Client Coverage Information</h4>
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
					</div>
					<div class="modal-body">					
						<div class="form-group">
                                                    <%
                                   clientname = ccm.getClientMasterList(user_code); 
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
                                    <label>Contact Person Name</label>
                                    <input type="text" name="contactnamea" id="contactnamea" class="form-control" required>
                            </div>
                            <div class="form-group">
                                    <label>Contact Person Position</label>
                                    <input type="text" name="contactpositiona" id="contactpositiona" class="form-control" required>
                            </div>
                            <div class="form-group">
                                    <label>Contact </label>
                                    <input type="text" name="contacta" id="contacta" class="form-control" required>
                            </div>	
                             <div class="form-group">
                                    <label>Relationship Quality</label>
                                    <input type="text" name="rshpqltya" id="rshpqltya" class="form-control" required>
                            </div>
                            <div class="form-group">
                                    <label>Last Contact</label>
                                    <input type="text" name="lastcontacta" id="lastcontacta" class="form-control" required>
                            </div>
                            <div class="form-group">
                                    <label>Last Discussion summary</label>
                                      <textarea  name="discussionsummarya" id="discussionsummarya" class="form-control" required></textarea>
                            </div>
                            <div class="form-group">
                                    <label>Next Planned Contact</label>
                                      <textarea  name="nxtplanedcontacta" id="nxtplanedcontacta" class="form-control" required></textarea>
                            </div>
                             <div class="form-group">
                                    <label>Next Planned Contact Purpose</label>
                                      <textarea  name="nxtplanedcontactpurposa" id="nxtplanedcontactpurposa" class="form-control" required></textarea>
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
	<!-- Delete Modal HTML -->
	<div id="deleteClientCoverageFinancialModal" class="modal fade">
		<div class="modal-dialog">
			<div class="modal-content">
				<form>
					<div class="modal-header">						
						<h4 class="modal-title">Delete ClientCoverageFinancial</h4>
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