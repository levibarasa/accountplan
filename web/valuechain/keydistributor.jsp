<%@page import="com.inm.dao.valuechain.*"%>
<%@page import="com.inm.models.*"%> 
<%@page import="java.util.ArrayList"%> 
<%@ include file="../include/header.jsp" %>
<html>
<head>
    <script type="text/javascript">
 
            var form = $('#addKeyDistributor');
            form.submit(function () {

            $.ajax({
            type: "POST",
            url: ${pageContext.request.contextPath}+'/do?MOD=BOK&ACT=doAddKeyDistributor',
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
						<h2>Key Distributor <b>Information</b></h2>
					</div>
					<div class="col-sm-6">
						<a href="#addKeyDistributorModal" class="btn btn-success" data-toggle="modal"><i class="material-icons">&#xE147;</i> <span>Add New KeyDistributor</span></a>
						<a href="#deleteKeyDistributorModal" class="btn btn-danger" data-toggle="modal"><i class="material-icons">&#xE15C;</i> <span>Delete</span></a>						
					</div>
                </div>
            </div>
            <table id="clientinformation" class="table table-striped table-hover">
                <thead>
                    <tr>
						<th>
							<span class="custom-checkbox">
			 <a href="#viewAll" ><i class="fa fa-eye" aria-hidden="true"></i></a>
							</span>
						</th> 
                        <th>Client Name</th>
			<th>KD&Clients</th>
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
                        KeyDistributor kd = new KeyDistributor();
                        ArrayList<KeyDistributorModel> list = kd.getDistributorInfo(user_code);
                        for(KeyDistributorModel keyDistributorModel :list){
                        %>
                  <tr>
                  
						<td>
							<span class="custom-checkbox">
								<a href="#viewAll" ><i class="fa fa-eye" aria-hidden="true"></i></a>
							</span>
						</td> 
                        <td><%=keyDistributorModel.getClientMaster()%></td>
			<td><%=keyDistributorModel.getKdandclients()%></td>
                        <td><%=keyDistributorModel.getKdContactperson()%></td>
                        <td><%=keyDistributorModel.getKdPhonenumber()%></td>
                        <td><%=keyDistributorModel.getKdEmail()%></td> 
                        <td><%=keyDistributorModel.getVolofbusnskdandclient()%> </td>
                        <td><%=keyDistributorModel.getBankedbyim()%></td>  
                        <td>
                            <a href="#editKeyDistributorModal" class="edit" data-toggle="modal"><i class="material-icons" data-toggle="tooltip" title="Edit">&#xE254;</i></a>
                            <a href="#deleteKeyDistributorModal" class="delete" data-toggle="modal"><i class="material-icons" data-toggle="tooltip" title="Delete">&#xE872;</i></a>
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
	<div id="addKeyDistributorModal" class="modal fade">
		<div class="modal-dialog">
			<div class="modal-content">
            <form  name="addKeyDistributor"  method="POST"  action="${pageContext.request.contextPath}/do?MOD=BOK&ACT=doAddKeyDistributor"  id="addKeyDistributor">
		<input type="hidden" name="uname" id="uname" value="<%= user_code%>"> 			
                <div class="modal-header">						
						<h4 class="modal-title">Add Key Distributors</h4>
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
					</div>
					<div class="modal-body">					
						 <div class="form-group">
                                                    <%
                                 ArrayList<ClientModel> clientname = kd.getClientMasterList(user_code); 
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
                                    <label>Key Distributor and Clients</label>
                                    <input name="kdandclienta" id="kdandclienta" type="text" class="form-control" required>
                            </div>    
                                                        <div class="form-group">
                                    <label>Key Distributor Contact Person</label>
                                <input  name="contactpersona" id="contactpersona"  type="text" class="form-control" required>
                              </div>
                            <div class="form-group">
                                    <label>Key Distributor Phone Number</label>
                                    <input  name="phonea" id="phonea"  type="text" class="form-control" required>
                            </div>
                            <div class="form-group">
                                    <label>Key Distributor Email</label>
                                    <input type="text" name="emaila" id="emaila"  class="form-control" required>
                            </div>
                          <div class="form-group">
                                    <label>Key Distributor Location</label>
                                    <input type="text" name="locationa" id="locationa"  class="form-control" required>
                            </div>
                            <div class="form-group">
                                                    <%  
                                  ArrayList<LookupmasterModel> segment = kd.getLookupList("SEGMENT"); 
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
							<label>Relationship Officer</label>
                                                        <%
                                 ArrayList<RmCodelistModel>  allRms = kd.getRmCodeList();
                                 
                                                        %>
			 <select name="rmCodea" id="rmCodea" class="form-control" required>
                              <%
                                    for(RmCodelistModel codelistModel : allRms){ 
                                %> 
                                <option value ="<%=codelistModel.getRmCode()%>" > <%=codelistModel.getRmName()%></option>  
                                <%
                                    } 
                                %>
                          </select>
						</div>
                                   <div class="form-group">
                                            <label>Comment</label>
                                        <textarea  name="commenta" id="commenta" class="form-control" required></textarea>
                                     </div>  
                    </div>
					<div class="modal-footer">
						<input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
						<input type="submit" onclick="registerKeyDistributor();"  class="btn btn-success" value="Add">
					</div>
				</form>
			</div>
		</div>
	</div>
	<!-- Edit Modal HTML -->
	<div id="editKeyDistributorModal" class="modal fade">
		<div class="modal-dialog">
			<div class="modal-content">
            <form  name="addKeyDistributor"  method="POST"  action="${pageContext.request.contextPath}/do?MOD=BOK&ACT=doAddKeyDistributor"  id="addKeyDistributor">
		<input type="hidden" name="uname" id="uname" value="<%= user_code%>"> 			
                <div class="modal-header">						
						<h4 class="modal-title">Add Key Distributors</h4>
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
					</div>
					<div class="modal-body">					
						 <div class="form-group">
                                                    <%
                                clientname = kd.getClientMasterList(user_code); 
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
                                    <label>Key Distributor and Clients</label>
                                    <input name="kdandclienta" id="kdandclienta" type="text" class="form-control" required>
                            </div>    
                                                        <div class="form-group">
                                    <label>Key Distributor Contact Person</label>
                                <input  name="contactpersona" id="contactpersona"  type="text" class="form-control" required>
                              </div>
                            <div class="form-group">
                                    <label>Key Distributor Phone Number</label>
                                    <input  name="phonea" id="phonea"  type="text" class="form-control" required>
                            </div>
                            <div class="form-group">
                                    <label>Key Distributor Email</label>
                                    <input type="text" name="emaila" id="emaila"  class="form-control" required>
                            </div>
                          <div class="form-group">
                                    <label>Key Distributor Location</label>
                                    <input type="text" name="locationa" id="locationa"  class="form-control" required>
                            </div>
                            <div class="form-group">
                                                    <%  
                                   segment = kd.getLookupList("SEGMENT"); 
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
							<label>Relationship Officer</label>
                                                        <%
                                    allRms = kd.getRmCodeList();
                                 
                                                        %>
			 <select name="rmCodea" id="rmCodea" class="form-control" required>
                              <%
                                    for(RmCodelistModel codelistModel : allRms){ 
                                %> 
                                <option value ="<%=codelistModel.getRmCode()%>" > <%=codelistModel.getRmName()%></option>  
                                <%
                                    } 
                                %>
                          </select>
						</div>
                                   <div class="form-group">
                                            <label>Comment</label>
                                        <textarea  name="commenta" id="commenta" class="form-control" required></textarea>
                                     </div>  
                    </div>
					<div class="modal-footer">
						<input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
						<input type="submit" onclick="registerKeyDistributor();"  class="btn btn-success" value="Add">
					</div>
				</form>
			</div>
		</div>
	</div>
	<!-- Delete Modal HTML -->
	<div id="deleteKeyDistributorModal" class="modal fade">
		<div class="modal-dialog">
			<div class="modal-content">
				<form>
					<div class="modal-header">						
						<h4 class="modal-title">Delete KeyDistributor</h4>
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
<div id="viewAll" class="modal fade">
        <div class="table-wrapper">
            <div class="table-title">
                <div class="row">
                    <div class="col-sm-6">
						<h2>Key Distributor <b>Information</b></h2>
					</div>
					 
                </div>
            </div>
            <table id="clientinformation" class="table table-striped table-hover">
                <thead>
                    <tr>
						<th>
							 
						</th> 
                        <th>Client Name</th>
			<th>KD&Clients</th>
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
                         kd = new KeyDistributor();
                          list = kd.getDistributorInfo(user_code);
                        for(KeyDistributorModel keyDistributorModel :list){
                        %>
                  <tr>
                  
						<td>
							<span class="custom-checkbox">
								<a href="#viewAll" ><i class="fa fa-eye" aria-hidden="true"></i></a>
							</span>
						</td> 
                        <td><%=keyDistributorModel.getClientMaster()%></td>
			<td><%=keyDistributorModel.getKdandclients()%></td>
                        <td><%=keyDistributorModel.getKdContactperson()%></td>
                        <td><%=keyDistributorModel.getKdPhonenumber()%></td>
                        <td><%=keyDistributorModel.getKdEmail()%></td>
                        <td><%=keyDistributorModel.getKdLocation()%></td>
                        <td> <%=keyDistributorModel.getLookupmaster()%></td>
                        <td><%=keyDistributorModel.getVolofbusnskdandclient()%> </td>
                        <td><%=keyDistributorModel.getBankedbyim()%></td> 
                        <td><%=keyDistributorModel.getComments()%> </td>
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