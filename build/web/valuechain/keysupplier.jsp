<%@page import="com.inm.dao.valuechain.*"%> 
<%@page import="com.inm.models.*"%>  
<%@page import="java.util.ArrayList"%> 
<%@ include file="../include/header.jsp" %>

<html>
<head>
    <script type="text/javascript">
 
            var form = $('#addKeySupplier');
            form.submit(function () {

            $.ajax({
            type: "POST",
            url: ${pageContext.request.contextPath}+'/do?MOD=BOK&ACT=doAddKeySupplier',
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
						<h2>Manage <b>Key Supplier Information</b></h2>
					</div>
					<div class="col-sm-6">
						<a href="#addKeySupplierInformationModal" class="btn btn-success" data-toggle="modal"><i class="material-icons">&#xE147;</i> <span>Add New KeySupplierInformation</span></a>
						<a href="#deleteKeySupplierInformationModal" class="btn btn-danger" data-toggle="modal"><i class="material-icons">&#xE15C;</i> <span>Delete</span></a>						
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
			<th>Key Supplier</th>
                        <th>ContactPerson</th>
                        <th>Phone#</th>
                        <th>Email</th> 
                        <th>VolOfBusiness</th>
                        <th>BankedByI&M</th>  
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        KeySupplier ks = new KeySupplier();
                        ArrayList<KeySupplierModel> list = ks.getKeySupplierInfo(user_code);
                        for(KeySupplierModel keySupplierModel :list){
                        %>
                    <tr>
						<td>
							 <a href="#viewAll" data-toggle="modal" data-target="#viewAll"><i class="fa fa-eye" aria-hidden="true"></i></a>
						</td>
                        <td><%=keySupplierModel.getClientMaster()%></td>
			<td><%=keySupplierModel.getKsname()%></td>
                        <td><%=keySupplierModel.getKsContactperson()%></td>
                        <td><%=keySupplierModel.getKsPhonenumber()%></td>
                        <td><%=keySupplierModel.getKsEmail()%></td> 
                        <td><%=keySupplierModel.getVolofbusiness()%> </td>
                        <td><%=keySupplierModel.getBankedbyim()%></td>  
                        <td>
                            <a href="#editKeySupplierInformationModal" class="edit" data-toggle="modal"><i class="material-icons" data-toggle="tooltip" title="Edit">&#xE254;</i></a>
                            <a href="#deleteKeySupplierInformationModal" class="delete" data-toggle="modal"><i class="material-icons" data-toggle="tooltip" title="Delete">&#xE872;</i></a>
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
	<div id="addKeySupplierInformationModal" class="modal fade">
		<div class="modal-dialog">
			<div class="modal-content">
				<form name="addKeySupplier"  method="POST"  action="${pageContext.request.contextPath}/do?MOD=BOK&ACT=doAddKeySupplier"  id="addKeySupplier">
					<div class="modal-header">						
						<h4 class="modal-title">Add New Key Supplier Information</h4>
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
					</div>
					<div class="modal-body">					
						<div class="form-group">
                                                    <%
                                 ArrayList<ClientModel> clientname = ks.getClientMasterList(user_code); 
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
                                    <label>Key Supplier Name</label>
                                    <input name="ksnamea" id="ksnamea" type="text" class="form-control" required>
                            </div>    
                                                        <div class="form-group">
                                    <label>Key Supplier Contact Person</label>
                                <input  name="contactpersona" id="contactpersona"  type="text" class="form-control" required>
                              </div>
                            <div class="form-group">
                                    <label>Key Supplier Phone Number</label>
                                    <input  name="phonea" id="phonea"  type="text" class="form-control" required>
                            </div>
                            <div class="form-group">
                                    <label>Key Supplier Email</label>
                                    <input type="text" name="emaila" id="emaila"  class="form-control" required>
                            </div>
                          <div class="form-group">
                                    <label>Key Supplier Location</label>
                                    <input type="text" name="locationa" id="locationa"  class="form-control" required>
                            </div>
                                     
                               <div class="form-group">
                                                    <%  
                                ArrayList<LookupmasterModel>   segment = ks.getLookupList("SEGMENT"); 
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
                                    <label>Volume Of Business</label>
                                    <input type="text" name="volofbusinessa" id="volofbusinessa"  class="form-control" required>
                            </div> 
                                      <div class="form-group"> 
							<label>Banked By I&M</label>
				 <select name="bankedbyima" id="bankedbyima" class="form-control" required>
                                     <option value="Yes">Yes</option>
                                      <option value="No">No</option>
                                 </select>
                                      </div>
                                     <div class="form-group">
                                            <label>Comment</label>
                                        <textarea  name="commenta" id="commenta" class="form-control" required></textarea>
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
	<div id="editKeySupplierInformationModal" class="modal fade">
		<div class="modal-dialog">
			<div class="modal-content">
				<form>
					<div class="modal-header">						
						<h4 class="modal-title">Edit KeySupplierInformation</h4>
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
					</div>
					<div class="modal-body">					
						<div class="form-group">
                                                    <%
                                   clientname = ks.getClientMasterList(user_code); 
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
                                    <label>Key Supplier Name</label>
                                    <input name="ksnamea" id="ksnamea" type="text" class="form-control" required>
                            </div>    
                                                        <div class="form-group">
                                    <label>Key Supplier Contact Person</label>
                                <input  name="contactpersona" id="contactpersona"  type="text" class="form-control" required>
                              </div>
                            <div class="form-group">
                                    <label>Key Supplier Phone Number</label>
                                    <input  name="phonea" id="phonea"  type="text" class="form-control" required>
                            </div>
                            <div class="form-group">
                                    <label>Key Supplier Email</label>
                                    <input type="text" name="emaila" id="emaila"  class="form-control" required>
                            </div>
                          <div class="form-group">
                                    <label>Key Supplier Location</label>
                                    <input type="text" name="locationa" id="locationa"  class="form-control" required>
                            </div>
                                     
                               <div class="form-group">
                                                    <%  
                                   segment = ks.getLookupList("SEGMENT"); 
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
                                    <label>Volume Of Business</label>
                                    <input type="text" name="volofbusinessa" id="volofbusinessa"  class="form-control" required>
                            </div> 
                                      <div class="form-group"> 
							<label>Banked By I&M</label>
				 <select name="bankedbyima" id="bankedbyima" class="form-control" required>
                                     <option value="Yes">Yes</option>
                                      <option value="No">No</option>
                                 </select>
                                      </div>
                                     <div class="form-group">
                                            <label>Comment</label>
                                        <textarea  name="commenta" id="commenta" class="form-control" required></textarea>
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
	<div id="deleteKeySupplierInformationModal" class="modal fade">
		<div class="modal-dialog">
			<div class="modal-content">
				<form>
					<div class="modal-header">						
						<h4 class="modal-title">Delete Key Supplier Information</h4>
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
<div  id="viewAll" class="modal fade">
        <div class="table-wrapper">
            <div class="table-title">
                <div class="row">
                    <div class="col-sm-6">
						<h2>View All <b>Key Supplier Information</b></h2>
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
			<th>Key Supplier</th>
                        <th>ContactPerson</th>
                        <th>Phone#</th>
                        <th>Email</th>
                        <th>Location</th>
                        <th>Segment</th>
                        <th>VolOfBusiness</th>
                        <th>BankedByI&M</th> 
                        <th>Comment</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                       ks = new KeySupplier();
                       list = ks.getKeySupplierInfo(user_code);
                        for(KeySupplierModel keySupplierModel :list){
                        %>
                    <tr>
						<td>
							<span class="custom-checkbox">
								<input type="checkbox" id="checkbox1" name="options[]" value="1">
								<label for="checkbox1"></label>
							</span>
						</td>
                        <td><%=keySupplierModel.getClientMaster()%></td>
			<td><%=keySupplierModel.getKsname()%></td>
                        <td><%=keySupplierModel.getKsContactperson()%></td>
                        <td><%=keySupplierModel.getKsPhonenumber()%></td>
                        <td><%=keySupplierModel.getKsEmail()%></td>
                        <td><%=keySupplierModel.getKsLocation()%></td>
                        <td> <%=keySupplierModel.getLookupmaster()%></td>
                        <td><%=keySupplierModel.getVolofbusiness()%> </td>
                        <td><%=keySupplierModel.getBankedbyim()%></td> 
                        <td><%=keySupplierModel.getComments()%> </td>
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