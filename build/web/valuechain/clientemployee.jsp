<%@page import="com.inm.dao.valuechain.*"%>
<%@page import="com.inm.models.*"%> 
<%@page import="com.inm.dao.client.Company"%>
<%@page import="java.util.ArrayList"%> 
<%@ include file="../include/header.jsp" %>
<html>
    <head>
        <script type="text/javascript">
 
            var form = $('#addClientEmployee');
            form.submit(function () {

            $.ajax({
            type: "POST",
            url: ${pageContext.request.contextPath}+'/do?MOD=BOK&ACT=doAddClientEmployee',
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
						<h2>Manage <b>Client Employee Information</b></h2>
					</div>
					<div class="col-sm-6">
						<a href="#addClientEmployeeModal" class="btn btn-success" data-toggle="modal"><i class="material-icons">&#xE147;</i> <span>Add New ClientEmployee</span></a>
						<a href="#deleteClientEmployeeModal" class="btn btn-danger" data-toggle="modal"><i class="material-icons">&#xE15C;</i> <span>Delete</span></a>						
					</div>
                </div>
            </div>
            <table class="table table-striped table-hover">
                <thead>
                    <tr>
					 <th>
						 <a href="#viewAll" data-toggle="modal" data-target="#viewAll"><i class="fa fa-eye" aria-hidden="true"></i></a>
					 </th>
                        <th>Client Name</th>
                        <th>ContactPerson</th>
			<th>Phone#</th>
                        <th>Email</th>
                        <th>Location</th> 
                        <th>#Employees with I&M</th>
                        <th>Target #Employees with I&M</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        ClientEmployeeMaster cl = new ClientEmployeeMaster();
                        ArrayList<ClientEmployeeModel> list = cl.getClientEmployeeInfo(user_code);
                        for(ClientEmployeeModel clientEmployeeModel :list){
                        %>
                    <tr>
                                <td>
                                        <span class="custom-checkbox">
                                            <a href="#viewAll" ><i class="fa fa-eye" aria-hidden="true"></i></a>
                                        </span>
                                </td>
                        <td><%=clientEmployeeModel.getClientMaster()%></td>
                        <td><%=clientEmployeeModel.getClientEmployeeContactperson()%></td>
                        <td><%=clientEmployeeModel.getClientEmployeePhonenumber()%></td>
			<td><%=clientEmployeeModel.getClientEmployeeEmail()%></td>
                        <td><%=clientEmployeeModel.getClientEmployeeLocation()%></td> 
                        <td><%=clientEmployeeModel.getNoofbankedemployeeswithim()%></td>
                        <td><%=clientEmployeeModel.getTargetnoofemployeesbyim()%></td>
                        <td>
                            <a href="#editClientEmployeeModal" class="edit" data-toggle="modal"><i class="material-icons" data-toggle="tooltip" title="Edit">&#xE254;</i></a>
                            <a href="#deleteClientEmployeeModal" class="delete" data-toggle="modal"><i class="material-icons" data-toggle="tooltip" title="Delete">&#xE872;</i></a>
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
	<div id="addClientEmployeeModal" class="modal fade">
		<div class="modal-dialog">
			<div class="modal-content">
				<form  name="addClientEmployee"  method="POST"  action="${pageContext.request.contextPath}/do?MOD=BOK&ACT=doAddClientEmployee"  id="addClientEmployee">
					<div class="modal-header">						
						<h4 class="modal-title">Add Client Employee Information</h4>
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
					</div>
					<div class="modal-body">
                             <div class="form-group">
                                                    <%
                                 ArrayList<ClientModel> clientname = cl.getClientMasterList(user_code); 
                                                        %>
							<label>Client Name</label>
				 <select name="clientnamea" id="clientnamea" class="form-control" required>
                                      <%
                                    for(ClientModel client : clientname){ 
                                %> 
                                <option value ="<%=client.getClientid()%>" > <%=client.getClientname()%></option>  
                                <%
                                    }
                                %>   
                                     </select>
						</div>
                            <div class="form-group">
                                    <label>Client Employee Contact Person</label>
                                <input  name="contactpersona" id="contactpersona"  type="text" class="form-control" required>
                              </div>
                            <div class="form-group">
                                    <label>Client Employee Phone Number</label>
                                    <input  name="phonea" id="phonea"  type="text" class="form-control" required>
                            </div>
                            <div class="form-group">
                                    <label>Client Employee Email</label>
                                    <input type="text" name="emaila" id="emaila"  class="form-control" required>
                            </div>
                          <div class="form-group">
                                    <label>Client Employee Location</label>
                                    <input type="text" name="locationa" id="locationa"  class="form-control" required>
                            </div>
                            <div class="form-group">
                                                    <%  
                                  ArrayList<LookupmasterModel> segment = cl.getLookupList("SEGMENT"); 
                                                        %>
							<label>Segment</label>
				 <select name="segmenta" id="segmenta" class="form-control" required>
                                      <%
                                    for(LookupmasterModel lst : segment){ 
                                %> 
                                <option value ="<%=lst.getLookupmasterid()%>" > <%=lst.getValue()%></option>  
                                <%
                                    } 
                                %>   
                                     </select>
						</div>
                           <div class="form-group">
                                <label>Number Of Employees</label>
                                <input  name="noofemployeea" id="noofemployeea"  type="text" class="form-control" required>
			  </div>
                        <div class="form-group">
                                <label>Number Of Employees Banked(All Banks)</label>
                                <input  name="employeenoallbanksa" id="employeenoallbanksa"  type="text" class="form-control" required>
			  </div>
                           <div class="form-group">
                                <label>Number Of Employees Banked(With I& M)</label>
                                <input  name="employeenoinma" id="employeenoinma"  type="text" class="form-control" required>
			  </div>  
                         <div class="form-group">
                                <label> Target Number Of Employees Banked(With I& M)</label>
                                <input  name="targetemployeenoinma" id="targetemployeenoinma"  type="text" class="form-control" required>
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
	<div id="editClientEmployeeModal" class="modal fade">
		<div class="modal-dialog">
			<div class="modal-content">
				<form>
					<div class="modal-header">						
						<h4 class="modal-title">Edit Client Employee</h4>
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
					</div>
					<div class="modal-content">
				<form>
					<div class="modal-header">						
						<h4 class="modal-title">Add Client Employee Information</h4>
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
					</div>
					<div class="modal-body">
                             <div class="form-group">
                                                    <%
                                  clientname = cl.getClientMasterList(user_code); 
                                                        %>
							<label>Client Name</label>
				 <select name="clientnamea" id="clientnamea" class="form-control" required>
                                      <%
                                    for(ClientModel client : clientname){ 
                                %> 
                                <option value ="<%=client.getClientid()%>" > <%=client.getClientname()%></option>  
                                <%
                                    }
                                %>   
                                     </select>
						</div>
                            <div class="form-group">
                                    <label>Client Employee Contact Person</label>
                                <input  name="contactpersona" id="contactpersona"  type="text" class="form-control" required>
                              </div>
                            <div class="form-group">
                                    <label>Client Employee Phone Number</label>
                                    <input  name="phonea" id="phonea"  type="text" class="form-control" required>
                            </div>
                            <div class="form-group">
                                    <label>Client Employee Email</label>
                                    <input type="text" name="emaila" id="emaila"  class="form-control" required>
                            </div>
                          <div class="form-group">
                                    <label>Client Employee Location</label>
                                    <input type="text" name="locationa" id="locationa"  class="form-control" required>
                            </div>
                            <div class="form-group">
                                                    <%  
                              segment = cl.getLookupList("SEGMENT"); 
                                                        %>
							<label>Segment</label>
				 <select name="segmenta" id="segmenta" class="form-control" required>
                                      <%
                                    for(LookupmasterModel lst : segment){ 
                                %> 
                                <option value ="<%=lst.getLookupmasterid()%>" > <%=lst.getValue()%></option>  
                                <%
                                    } 
                                %>   
                                     </select>
						</div>
                           <div class="form-group">
                                <label>Number Of Employees</label>
                                <input  name="employeenoa" id="employeenoa"  type="text" class="form-control" required>
			  </div>
                        <div class="form-group">
                                <label>Number Of Employees Banked(All Banks)</label>
                                <input  name="employeenoallbanksa" id="employeenoallbanksa"  type="text" class="form-control" required>
			  </div>
                           <div class="form-group">
                                <label>Number Of Employees Banked(With I& M)</label>
                                <input  name="employeenoinma" id="employeenoinma"  type="text" class="form-control" required>
			  </div>  
                         <div class="form-group">
                                <label> Target Number Of Employees Banked(With I& M)</label>
                                <input  name="targetemployeenoinma" id="targetemployeenoinma"  type="text" class="form-control" required>
			  </div> 
					</div>
                                      <div class="modal-footer">
						<input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
						<input type="submit" class="btn btn-success" value="Add">
					</div>
				</form>
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
	<div id="deleteClientEmployeeModal" class="modal fade">
		<div class="modal-dialog">
			<div class="modal-content">
				<form>
					<div class="modal-header">						
						<h4 class="modal-title">Delete ClientEmployee</h4>
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
        <!--  View All -->
        <div id="viewAll" class="modal fade">
        <div class="table-wrapper">
            <div class="table-title">
                <div class="row">
                    <div class="col-sm-6">
						<h2>View All <b>Client Employee Information</b></h2>
					</div>
					<div class="col-sm-6">
					 </div>
                </div>
            </div>
            <table class="table table-striped table-hover">
                <thead>
                    <tr>
						<th>
							<span class="custom-checkbox">
								 
							</span>
						</th>
                        <th>Client Name</th>
                        <th>ContactPerson</th>
			<th>Phone#</th>
                        <th>Email</th>
                        <th>Location</th>
                        <th>Segment</th>
                        <th>#Employees</th>
                        <th>#Employees All Banks</th>
                        <th>#Employees with I&M</th>
                        <th>Target #Employees with I&M</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                          cl = new ClientEmployeeMaster();
                          list = cl.getClientEmployeeInfo(user_code);
                        for(ClientEmployeeModel clientEmployeeModel :list){
                        %>
                    <tr>
                                <td>
                                        <span class="custom-checkbox">
                                         </span>
                                </td>
                        <td><%=clientEmployeeModel.getClientMaster()%></td>
                        <td><%=clientEmployeeModel.getClientEmployeeContactperson()%></td>
                        <td><%=clientEmployeeModel.getClientEmployeePhonenumber()%></td>
			<td><%=clientEmployeeModel.getClientEmployeeEmail()%></td>
                        <td><%=clientEmployeeModel.getClientEmployeeLocation()%></td>
                        <td><%=clientEmployeeModel.getLookupmaster()%></td>
                        <td><%=clientEmployeeModel.getNoofemployees()%></td>
                        <td><%=clientEmployeeModel.getNoofbankedemployeesallbanks()%></td>
                        <td><%=clientEmployeeModel.getNoofbankedemployeeswithim()%></td>
                        <td><%=clientEmployeeModel.getTargetnoofemployeesbyim()%></td>
                        <td>
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
         
<%@ include file="../include/footer.jsp" %>