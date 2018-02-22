<%@page import="com.inm.dao.walletresize.*"%>
<%@page import="com.inm.models.*"%> 
<%@page import="java.util.ArrayList"%> 
<%@ include file="../include/header.jsp" %>
<html>
<head>
    <script type="text/javascript">
 
            var form = $('#addWalletResize');
            form.submit(function () {

            $.ajax({
            type: "POST",
            url: ${pageContext.request.contextPath}+'/do?MOD=BOK&ACT=doAddWalletSize',
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
						<h2>Wallet Resize <b>Information</b></h2>
					</div>
					<div class="col-sm-6">
						<a href="#addWalletResizeModal" class="btn btn-success" data-toggle="modal"><i class="material-icons">&#xE147;</i> <span>Add New WalletResize</span></a>
						<a href="#deleteWalletResizeModal" class="btn btn-danger" data-toggle="modal"><i class="material-icons">&#xE15C;</i> <span>Delete</span></a>						
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
                       <th>#</th>
                        <th>Client Name</th>
			<th>Product</th>
                        <th>Currency</th>  
                        <th>Deal Amount</th>
                        <th>Margin</th>
                        <th>Interest Rate</th>
                        <th>Tenor</th>
                        <th>Total Revenue</th>
                        <th>Actions</th>
                    </tr>
                </thead> 
                <tbody>
                     
                    <%
                        WalletResizeMaster wrm = new WalletResizeMaster();
                         ArrayList<WalletResizeModel> list = wrm.getWalletResize(user_code);
                        for(WalletResizeModel wrModel :list){
                        %>
                  <tr>
                  
						<td>
							<span class="custom-checkbox">
								<input type="checkbox" id="checkbox1" name="options[]" value="1">
								<label for="checkbox1"></label>
							</span>
						</td> 
                        <td><%=wrModel.getWalletResizeId()%></td>
                        <td><%=wrModel.getClientMaster()%></td>
			<td><%=wrm.getLookUpMasterByID(wrModel.getLookupmasterByProduct()).getValue()%></td>
                        <td><%=wrm.getLookUpMasterByID(wrModel.getLookupmasterByCurrencyLookupid()).getValue()%></td> 
                        <td><%=wrModel.getDealMount()%></td> 
                        <td><%=wrModel.getMargin()%></td> 
                        <td><%=wrModel.getInterestRate()%></td> 
                        <td><%=wrModel.getTenor()%></td> 
                        <td><%=wrModel.getTotalrevenue()%></td> 
                         
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
	<div id="addWalletResizeModal" class="modal fade">
		<div class="modal-dialog">
			<div class="modal-content">
            <form  name="addWalletResize"  method="POST"  action="${pageContext.request.contextPath}/do?MOD=BOK&ACT=doAddWalletSize"  id="addWalletResize">
		<input type="hidden" name="uname" id="uname" value="<%= user_code%>"> 			
                <div class="modal-header">						
						<h4 class="modal-title">Add Wallet Resize</h4>
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
					</div>
					<div class="modal-body">					
						 	<div class="form-group">
                                                    <%
                                 ArrayList<ClientModel> clientname = wrm.getClientMasterList(user_code); 
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
                                                    <%  
                                  ArrayList<LookupmasterModel> lookupmaster = wrm.getLookupList("PRODUCT"); 
                                                        %>
							<label>Product</label>
				 <select name="producta" id="producta" class="form-control" required>
                                      <%
                                    for(LookupmasterModel lst : lookupmaster){ 
                                %> 
                                <option value ="<%=lst.getLookupmasterid()%>" > <%=lst.getValue()%></option>  
                                <%
                                    } 
                                %>   
                                     </select>
						</div>    
                                     <div class="form-group">
                                                    <%  
                                    lookupmaster = wrm.getLookupList("CURRENCY"); 
                                                        %>
							<label>Currency</label>
				 <select name="currencya" id="currencya" class="form-control" required>
                                      <%
                                    for(LookupmasterModel lst : lookupmaster){ 
                                %> 
                                <option value ="<%=lst.getLookupmasterid()%>" > <%=lst.getValue()%></option>  
                                <%
                                    } 
                                %>   
                                     </select>
						</div> 
                                  <div class="form-group">
                                            <label>I&M Deal Amount</label>
                                        <input type="text"  name="imdealamounta" id="imdealamounta" class="form-control" required> 
                                     </div>	
                                <div class="form-group">
                                            <label>Interest Rate</label>
                                        <input type="text"  name="interstratea" id="interstratea" class="form-control" required> 
                                     </div>   
                                <div class="form-group">
                                            <label>Processing Fee Rate</label>
                                        <input type="text"  name="processfeeratea" id="processfeeratea" class="form-control" required> 
                                     </div>
                                     <div class="form-group">
                                            <label>Tenor(In Months)</label>
                                        <input type="text"  name="tenora" id="tenora" class="form-control" required> 
                                     </div>
                                     <div class="form-group">
                                            <label>Limit</label>
                                        <input type="text"  name="limita" id="limita" class="form-control" required> 
                                     </div>
                                     <div class="form-group">
                                            <label>Average Utilization Amount(Optional)</label>
                                        <input type="text"  name="avgutilamta" id="avgutilamta" class="form-control" > 
                                     </div>
                                     <div class="form-group">
                                            <label>Annual Average Float(Optional)</label>
                                        <input type="text"  name="annualavgfloata" id="annualavgfloata" class="form-control" > 
                                     </div>
					</div>
					<div class="modal-footer">
						<input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
						<input type="submit" onclick="registerWalletResize();"  class="btn btn-success" value="Add">
					</div>
				</form>
			</div>
		</div>
	</div>
	<!-- Edit Modal HTML -->
	<div id="editWalletResizeModal" class="modal fade">
		<div class="modal-dialog">
			<div class="modal-content">
				<form   name="edditWalletResize" method="GET" action="do?MOD=BOK&ACT=doUpdateWalletResize" id="edditWalletResize">
                                     	<div class="modal-header">						
						<h4 class="modal-title">Edit WalletResize</h4>
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
					</div>
					<div class="modal-content">
            <form  name="editWalletResize"  method="POST"  action="${pageContext.request.contextPath}/do?MOD=BOK&ACT=doUpdateWalletSize"  id="editWalletResize">
		<input type="hidden" name="uname" id="uname" value="<%= user_code%>"> 			
                <div class="modal-header">						
						<h4 class="modal-title">Update Wallet Resize</h4>
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
					</div>
					<div class="modal-body">					
						 	<div class="form-group">
                                                    <%
                                  clientname = wrm.getClientMasterList(user_code); 
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
                                                    <%  
                                   lookupmaster = wrm.getLookupList("PRODUCT"); 
                                                        %>
							<label>Product</label>
				 <select name="producta" id="producta" class="form-control" required>
                                      <%
                                    for(LookupmasterModel lst : lookupmaster){ 
                                %> 
                                <option value ="<%=lst.getLookupmasterid()%>" > <%=lst.getValue()%></option>  
                                <%
                                    } 
                                %>   
                                     </select>
						</div>    
                                     <div class="form-group">
                                                    <%  
                                    lookupmaster = wrm.getLookupList("CURRENCY"); 
                                                        %>
							<label>Currency</label>
				 <select name="currencya" id="currencya" class="form-control" required>
                                      <%
                                    for(LookupmasterModel lst : lookupmaster){ 
                                %> 
                                <option value ="<%=lst.getLookupmasterid()%>" > <%=lst.getValue()%></option>  
                                <%
                                    } 
                                %>   
                                     </select>
						</div> 
                                  <div class="form-group">
                                            <label>I&M Deal Amount</label>
                                        <input type="text"  name="imdealamounta" id="imdealamounta" class="form-control" required> 
                                     </div>	
                                <div class="form-group">
                                            <label>Interest Rate</label>
                                        <input type="text"  name="interstratea" id="interstratea" class="form-control" required> 
                                     </div>   
                                <div class="form-group">
                                            <label>Processing Fee Rate</label>
                                        <input type="text"  name="processfeeratea" id="processfeeratea" class="form-control" required> 
                                     </div>
                                     <div class="form-group">
                                            <label>Tenor(In Months)</label>
                                        <input type="text"  name="tenora" id="tenora" class="form-control" required> 
                                     </div>
                                     <div class="form-group">
                                            <label>Limit</label>
                                        <input type="text"  name="limita" id="limita" class="form-control" required> 
                                     </div>
                                     <div class="form-group">
                                            <label>Average Utilization Amount(Optional)</label>
                                        <input type="text"  name="avgutilamta" id="avgutilamta" class="form-control" > 
                                     </div>
                                     <div class="form-group">
                                            <label>Annual Average Float(Optional)</label>
                                        <input type="text"  name="annualavgfloata" id="annualavgfloata" class="form-control" > 
                                     </div>
					</div>
					<div class="modal-footer">
						<input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
						<input type="submit" onclick="registerWalletResize();"  class="btn btn-success" value="Add">
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
	<div id="deleteWalletResizeModal" class="modal fade">
		<div class="modal-dialog">
			<div class="modal-content">
				<form>
					<div class="modal-header">						
						<h4 class="modal-title">Delete WalletResize</h4>
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