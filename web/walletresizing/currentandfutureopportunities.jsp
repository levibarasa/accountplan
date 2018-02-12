<%@page import="com.inm.dao.walletresize.*"%>
<%@page import="com.inm.models.*"%>  
<%@page import="java.util.ArrayList"%> 
<%@ include file="../include/header.jsp" %>

<html>
<head>
    <script type="text/javascript">
 
            var form = $('#addCFOpportunity');
            form.submit(function () {

            $.ajax({
            type: "POST",
            url: ${pageContext.request.contextPath}+'/do?MOD=BOK&ACT=doAddCFOpportunity',
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
						<h2>Manage <b>Current And Future Opportunities Information</b></h2>
					</div>
					<div class="col-sm-6">
						<a href="#addCurrentAndFutureOpportunitiesInformationModal" class="btn btn-success" data-toggle="modal"><i class="material-icons">&#xE147;</i> <span>Add New CurrentAndFutureOpportunitiesInformation</span></a>
						<a href="#deleteCurrentAndFutureOpportunitiesInformationModal" class="btn btn-danger" data-toggle="modal"><i class="material-icons">&#xE15C;</i> <span>Delete</span></a>						
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
                        <th>Assets Estimated Total</th>
			<th>Net Interest Asset Income</th>
                        <th>Net Interest Asset Margin</th>
                        <th>Liability Estimated Total</th>
                        <th>Liability Average Interest Margin</th>
                        <th>Liability Interest Income</th>
                        <th>Estimated Total Assets</th>
                        <th>I&M Asset Average Fee Rate</th>
                        <th>Assets Fee Income</th>
                        <th>Liability Estimated total</th>
                        <th>I&M Liability Average Fee Rate</th>
                        <th>Liability Fee Income</th>
                        <th>Income Total Fee</th>
                        <th>I&M Wallet Size</th>
                        <th>I&M Projected Wallet Share</th>
                        <th>I&M Expected Revenue</th>
                        <th>All Banks Wallet Size Revenue</th>
                        <th>% wallet Share </th>
                        <th>Deal Volume Fees</th>
                        <th>Deal Volume Assets</th>
                        <th>Deal volume Liabilities</th>
                        <th>Deal volume Revenue</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                       CurrentAndFutureOpportunityMaster cfo = new CurrentAndFutureOpportunityMaster(); 
                        ArrayList<CurrentAndFutureOpportunityModel> list = cfo.getCurrentAndFutureOpportunitiesInfo(user_code);
                        for(CurrentAndFutureOpportunityModel cfomodel :list){
                        %>
                    <tr>
						<td>
							<span class="custom-checkbox">
								<input type="checkbox" id="checkbox1" name="options[]" value="1">
								<label for="checkbox1"></label>
							</span>
						</td>
                        <td><%=cfomodel.getClientMaster()%></td>
                        <td><%=cfomodel.getEstimatedtotalasset()%></td>
			<td><%=cfomodel.getImaverageinterestmargin()%></td>
                        <td><%=cfomodel.getAssetsnetinterestincome()%></td>
                        <td><%=cfomodel.getEstimatedtotalliability()%></td>
                        <td><%=cfomodel.getImavrgliabilityintrestmargin()%></td>
                        <td><%=cfomodel.getLiabilitynetinterestincome()%></td>
                        <td><%=cfomodel.getTotalnetinterestincome()%></td>
                        <td><%=cfomodel.getAssetestimatedtotal()%></td>
                        <td><%=cfomodel.getImassetaveragefeerate()%></td>
                        <td><%=cfomodel.getAssetsfeeincome()%></td>
                        <td><%=cfomodel.getLiabilityestimatedtotal()%></td>
                        <td><%=cfomodel.getImliabilityaveragefeerate()%></td>
                        <td><%=cfomodel.getLiabilityfeeincome()%></td>
                        <td><%=cfomodel.getIncometotalfee()%></td>
                        <td><%=cfomodel.getImwalletsize()%></td>
                        <td><%=cfomodel.getImprojectedwalletshare()%></td>
                        <td><%=cfomodel.getImexpectedrevenue()%></td>
                        <td><%=cfomodel.getAllbankswalletsizrevmanual()%></td>
                        <td><%=cfomodel.getPercentwalletsharemanual()%></td>
                        <td><%=cfomodel.getDealvolumefees()%></td>
                        <td><%=cfomodel.getDealvolassets()%></td>
                        <td><%=cfomodel.getDealvolrevenue()%></td>
                        <td>
                            <a href="#editCurrentAndFutureOpportunitiesInformationModal" class="edit" data-toggle="modal"><i class="material-icons" data-toggle="tooltip" title="Edit">&#xE254;</i></a>
                            <a href="#deleteCurrentAndFutureOpportunitiesInformationModal" class="delete" data-toggle="modal"><i class="material-icons" data-toggle="tooltip" title="Delete">&#xE872;</i></a>
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
	<div id="addCurrentAndFutureOpportunitiesInformationModal" class="modal fade">
		<div class="modal-dialog">
			<div class="modal-content">
				<form  name="addCFOpportunity"  method="POST"  action="${pageContext.request.contextPath}/do?MOD=BOK&ACT=doAddCFOpportunity"  id="addCFOpportunity">
					<div class="modal-header">						
						<h4 class="modal-title">Add New Current And Future Opportunities Information</h4>
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
					</div>
					<div class="modal-body">					
						<div class="form-group">
                                                    <%
                                 ArrayList<ClientModel> clientname = cfo.getClientMasterList(user_code); 
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
                                  ArrayList<LookupmasterModel> lookupmaster = cfo.getLookupList("PRODUCT"); 
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
							<label>Assets Estimated Total(Ksh'M)</label>
							<input type="text" name="assetesttotala" id="assetesttotala" class="form-control" required>
						</div>
						<div class="form-group">
							<label>Average I&M Interest Margin Asset(%)</label>
							<input type="text" name="imintrstmargina" id="imintrstmargina" class="form-control" required>
						</div>
						<div class="form-group">
							<label>Estimated Total Liability($mm)</label>
							<input type="text"  name="esttotliabilitya" id="esttotliabilitya"  class="form-control" required>
						</div>	
                                                <div class="form-group">
							<label>Average I&M Interest Margin On Liability</label>
							<input type="text"  name="iminterstmarginliabilitya" id="iminterstmarginliabilitya"  class="form-control" required>
						</div>
                                     <div class="form-group">
							<label>Estimated Total Asset($mm)</label>
							<input type="text"  name="esttotasseta" id="esttotasseta"  class="form-control" required>
						</div>
                                     <div class="form-group">
							<label>Average I&M Fee Rate On Assets(%)</label>
							<input type="text"  name="imfeerateassetsa" id="imfeerateassetsa"  class="form-control" required>
						</div>
                                     <div class="form-group">
							<label>Fee Income Estimated Total Liability($mm)</label>
							<input type="text"  name="feeincomeesttotliabilitya" id="feeincomeesttotliabilitya"  class="form-control" required>
						</div>
                                     <div class="form-group">
							<label>Average I&M Fee Rate On Liability(%)</label>
							<input type="text"  name="imfeerateliabilitya" id="imfeerateliabilitya"  class="form-control" required>
						</div>
                                     <div class="form-group">
							<label>Projected Share Of Wallet(%)</label>
							<input type="text"  name="projectedwalletsharea" id="projectedwalletsharea"  class="form-control" required>
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
	<div id="editCurrentAndFutureOpportunitiesInformationModal" class="modal fade">
		<div class="modal-dialog">
			<div class="modal-content">
				<form>
					<div class="modal-header">						
						<h4 class="modal-title">Edit Current And Future Opportunities Information</h4>
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
					</div>
					<div class="modal-body">					
						<div class="form-group">
                                                    <%
                                   clientname = cfo.getClientMasterList(user_code); 
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
                                  lookupmaster = cfo.getLookupList("PRODUCT"); 
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
							<label>Assets Estimated Total(Ksh'M)</label>
							<input type="text" name="assetesttotala" id="assetesttotala" class="form-control" required>
						</div>
						<div class="form-group">
							<label>Average I&M Interest Margin Asset(%)</label>
							<input type="text" name="imintrstmargina" id="imintrstmargina" class="form-control" required>
						</div>
						<div class="form-group">
							<label>Estimated Total Liability($mm)</label>
							<input type="text"  name="esttotliabilitya" id="esttotliabilitya"  class="form-control" required>
						</div>	
                                                <div class="form-group">
							<label>Average I&M Interest Margin On Liability</label>
							<input type="text"  name="iminterstmarginliabilitya" id="iminterstmarginliabilitya"  class="form-control" required>
						</div>
                                     <div class="form-group">
							<label>Estimated Total Asset($mm)</label>
							<input type="text"  name="esttotasseta" id="esttotasseta"  class="form-control" required>
						</div>
                                     <div class="form-group">
							<label>Average I&M Fee Rate On Assets(%)</label>
							<input type="text"  name="imfeerateassetsa" id="imfeerateassetsa"  class="form-control" required>
						</div>
                                     <div class="form-group">
							<label>Estimated Total Liability($mm)</label>
							<input type="text"  name="esttotliabilitya" id="esttotliabilitya"  class="form-control" required>
						</div>
                                     <div class="form-group">
							<label>Average I&M Fee Rate On Liability(%)</label>
							<input type="text"  name="imfeerateliabilitya" id="imfeerateliabilitya"  class="form-control" required>
						</div>
                                     <div class="form-group">
							<label>Projected Share Of Wallet(%)</label>
							<input type="text"  name="projectedwalletsharea" id="projectedwalletsharea"  class="form-control" required>
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
	<div id="deleteCurrentAndFutureOpportunitiesInformationModal" class="modal fade">
		<div class="modal-dialog">
			<div class="modal-content">
				<form>
					<div class="modal-header">						
						<h4 class="modal-title">Delete CurrentAndFutureOpportunitiesInformation</h4>
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