<%@page import="com.inm.dao.qualitativeinformation.*"%>
<%@page import="com.inm.models.*"%>  
<%@page import="java.util.ArrayList"%> 
<%@ include file="../include/header.jsp" %>
<html>
    <head>
    <script type="text/javascript">
 
            var form = $('#addDealInProgress');
            form.submit(function () {

            $.ajax({
            type: "POST",
            url: ${pageContext.request.contextPath}+'/do?MOD=BOK&ACT=doAddDealInProgress',
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
						<h2>Manage <b>DealInProgress Information</b></h2>
					</div>
					<div class="col-sm-6">
						<a href="#addDealInProgressModal" class="btn btn-success" data-toggle="modal"><i class="material-icons">&#xE147;</i> <span>Add New DealInProgress</span></a>
						<a href="#deleteDealInProgressModal" class="btn btn-danger" data-toggle="modal"><i class="material-icons">&#xE15C;</i> <span>Delete</span></a>						
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
                        <th>Product</th>
                        <th>Deal Probability</th>
			<th>Deal Stage</th>
                        <th>Completion Month</th>
                        <th>Deal Status</th>
                        <th>Deal Type</th>
                        <th>Currently Used</th>
                        <th>I&M Deal Amount</th>
                        <th>All Banks Wallet Size</th>
                        <th>I&M Projected Wallet Share</th>
                        <th>I&M Expected Revenue</th>
                        <th>Comments</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        DealInProgressMaster dip = new DealInProgressMaster();
                        ArrayList<DealProgressModel> list = dip.getDealInProgressInfo(user_code);
                        for(DealProgressModel dealProgressModel :list){
                        %>
                    <tr>
						<td>
							<span class="custom-checkbox">
								<input type="checkbox" id="checkbox1" name="options[]" value="1">
								<label for="checkbox1"></label>
							</span>
						</td>
                        <td><%=dealProgressModel.getClientMaster()%></td>
                        <td><%=dealProgressModel.getProductlookupid()%></td>
                        <td><%=dealProgressModel.getDealpropabilitylookupid()%></td>
			<td><%=dealProgressModel.getDealstagelookupmasterid()%></td>
                        <td><%=dealProgressModel.getCompletionmonthlookupid()%></td>
                        <td><%=dealProgressModel.getDealstatuslookupmasterid()%></td>
                        <td><%=dealProgressModel.getDealtypelookupmasterid()%></td>
                        <td><%=dealProgressModel.getCurrentlyused()%></td>
                        <td><%=dealProgressModel.getImdealamount()%></td>
                        <td><%=dealProgressModel.getAllbankswalletsize()%></td>
                        <td><%=dealProgressModel.getImprojectedwalletshare()%></td>
                        <td><%=dealProgressModel.getImexpectedrevenue()%></td>
                        <td><%=dealProgressModel.getComments()%></td>
                        <td>
                            <a href="#editDealInProgressModal" class="edit" data-toggle="modal"><i class="material-icons" data-toggle="tooltip" title="Edit">&#xE254;</i></a>
                            <a href="#deleteDealInProgressModal" class="delete" data-toggle="modal"><i class="material-icons" data-toggle="tooltip" title="Delete">&#xE872;</i></a>
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
	<div id="addDealInProgressModal" class="modal fade">
		<div class="modal-dialog">
			<div class="modal-content">
				<form   name="addDealInProgress"  method="POST"  action="${pageContext.request.contextPath}/do?MOD=BOK&ACT=doAddDealInProgress"  id="addDealInProgress" >
					<div class="modal-header">						
						<h4 class="modal-title">Add Deal In Progress Information</h4>
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
					</div>
					<div class="modal-body">
                                            	<div class="form-group">
                                                    <%
                                 ArrayList<ClientModel> clientname = dip.getClientMasterList(user_code); 
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
                                  ArrayList<LookupmasterModel> lookupmaster = dip.getLookupList("PRODUCT"); 
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
                                   lookupmaster = dip.getLookupList("DEALPROBABILITY"); 
                                                        %>
							<label>Deal Probability</label>
				 <select name="dealprobabilitya" id="dealprobabilitya" class="form-control" required>
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
                                   lookupmaster = dip.getLookupList("DEALSTAGE"); 
                                                        %>
							<label>Deal Stage</label>
				 <select name="dealstagea" id="dealstagea" class="form-control" required>
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
                                   lookupmaster = dip.getLookupList("MONTH"); 
                                                        %>
							<label>Completion Month</label>
				 <select name="completionmontha" id="completionmontha" class="form-control" required>
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
                                   lookupmaster = dip.getLookupList("DEALSTATUS"); 
                                                        %>
							<label>Deal Status</label>
				 <select name="dealstatusa" id="dealstatusa" class="form-control" required>
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
                                   lookupmaster = dip.getLookupList("DEALTYPE"); 
                                                        %>
							<label>Deal Type</label>
				 <select name="dealtypea" id="dealtypea" class="form-control" required>
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
							<label>Currently Used</label>
				 <select name="currentlyuseda" id="currentlyuseda" class="form-control" required>
                                     <option value="Yes">Yes</option>
                                      <option value="No">No</option>
                                 </select>
                                      </div>
                                  <div class="form-group">
                                            <label>I&M Deal Amount</label>
                                        <input type="text"  name="imdealamounta" id="imdealamounta" class="form-control" required></textarea>
                                     </div>     
                                     <div class="form-group">
                                            <label>All Banks Wallet Size</label>
                                        <input type="text"  name="allbankswalletsizea" id="allbankswalletsizea" class="form-control" required></textarea>
                                     </div>
                                     <div class="form-group">
                                            <label>I&M Projected Wallet Share</label>
                                        <input type="text"  name="improjectedwalletsharea" id="improjectedwalletsharea" class="form-control" required></textarea>
                                     </div>
                                     <div class="form-group">
                                            <label>I&M Expected Revenue</label>
                                        <input type="text"  name="imexpectedrevenuea" id="imexpectedrevenuea" class="form-control" required></textarea>
                                     </div>
                                     <div class="form-group">
                                            <label>Comments</label>
                                        <textarea  type="text" name="commenta" id="commenta" class="form-control" required></textarea>
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
	<div id="editDealInProgressModal" class="modal fade">
		<div class="modal-dialog">
			<div class="modal-content">
				<form>
					<div class="modal-header">						
						<h4 class="modal-title">Edit Deal In Progress</h4>
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
					</div>
					<div class="modal-body">
                                            	<div class="form-group">
                                                    <%
                                   clientname = dip.getClientMasterList(user_code); 
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
                                                    <%  
                                    lookupmaster = dip.getLookupList("PRODUCT"); 
                                                        %>
							<label>Product</label>
				 <select name="producte" id="producte" class="form-control" required>
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
                                   lookupmaster = dip.getLookupList("DEALPROBABILITY"); 
                                                        %>
							<label>Deal Probability</label>
				 <select name="dealprobabilitye" id="dealprobabilitye" class="form-control" required>
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
                                   lookupmaster = dip.getLookupList("DEALSTAGE"); 
                                                        %>
							<label>Deal Stage</label>
				 <select name="dealstagee" id="dealstagee" class="form-control" required>
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
                                   lookupmaster = dip.getLookupList("MONTH"); 
                                                        %>
							<label>Completion Month</label>
				 <select name="completionmonthe" id="completionmonthe" class="form-control" required>
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
                                   lookupmaster = dip.getLookupList("DEALSTATUS"); 
                                                        %>
							<label>Deal Status</label>
				 <select name="dealstatuse" id="dealstatuse" class="form-control" required>
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
                                   lookupmaster = dip.getLookupList("DEALTYPE"); 
                                                        %>
							<label>Deal Type</label>
				 <select name="dealtypee" id="dealtypee" class="form-control" required>
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
							<label>Currently Used</label>
				 <select name="currentlyusede" id="currentlyusede" class="form-control" required>
                                     <option value="Yes">Yes</option>
                                      <option value="No">No</option>
                                 </select>
                                      </div>
                                  <div class="form-group">
                                            <label>I&M Deal Amount</label>
                                        <textarea  name="imdealamounta" id="imdealamounta" class="form-control" required></textarea>
                                     </div>     
                                     <div class="form-group">
                                            <label>All Banks Wallet Size</label>
                                        <textarea  name="allbankswalletsizea" id="allbankswalletsizea" class="form-control" required></textarea>
                                     </div>
                                     <div class="form-group">
                                            <label>I&M Projected Wallet Share</label>
                                        <textarea  name="improjectedwalletsharea" id="improjectedwalletsharea" class="form-control" required></textarea>
                                     </div>
                                     <div class="form-group">
                                            <label>I&M Expected Revenue</label>
                                        <textarea  name="imexpectedrevenuea" id="imexpectedrevenuea" class="form-control" required></textarea>
                                     </div>
                                     <div class="form-group">
                                            <label>Comments</label>
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
	<div id="deleteDealInProgressModal" class="modal fade">
		<div class="modal-dialog">
			<div class="modal-content">
				<form>
					<div class="modal-header">						
						<h4 class="modal-title">Delete DealInProgress</h4>
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