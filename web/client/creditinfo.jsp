<%@page import="com.inm.dao.client.AccountRevenue"%>
<%@page import="com.inm.dao.client.Company"%>
<%@page import="com.inm.models.*"%> 
<%@page import="com.inm.dao.client.CreditInfo"%>
<%@page import="java.util.ArrayList"%> 
<%@ include file="../include/header.jsp" %>

<html>
<head>
    <script type="text/javascript">
 
            var form = $('#addCreditInfo');
            form.submit(function () {

            $.ajax({
            type: "POST",
            url: ${pageContext.request.contextPath}+'/do?MOD=BOK&ACT=doAddCreditInfo',
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
  <script type="text/javascript">  
      function fetchOldRecord(that){	 
             $("#companyaddressa").val($(that).parent().prev().prev().prev().prev().prev().text());
         $("#grpnamea").val($(that).parent().prev().prev().prev().prev().text());
        $("#hqcountrya").val($(that).parent().prev().prev().prev().text());
          $("#indrustrye").val($(that).parent().prev().prev().text());
         $("#noofsubsidiarya").val($(that).parent().prev().text()); 
       	} 
       
   $('#editCompanyModal').modal('show'); 
       </script>
</head>
 


<div class="container">
        <div class="table-wrapper">
            <div class="table-title">
                <div class="row">
                    <div class="col-sm-6">
						<h2>Manage <b>Credit Information</b></h2>
					</div>
					<div class="col-sm-6">
						<a href="#addCreditInformationModal" class="btn btn-success" data-toggle="modal"><i class="material-icons">&#xE147;</i> <span>Add New Credit Information</span></a>
						<a href="#deleteCreditInformationModal" class="btn btn-danger" data-toggle="modal"><i class="material-icons">&#xE15C;</i> <span>Delete</span></a>						
					</div>
                </div>
            </div>
            <table class="table table-striped table-hover">
                <thead>
                    <tr>
                        <th># </th>
                        <th>Client Name</th>
                        <th>I&M Approved Lines</th>
                        <th>All Banks Approved Lines</th>
			<th>I&M Outstanding Amount</th>
                         <th>All Banks Outstanding Amount</th>
                        <th>Risk Rating</th>
                         <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        CreditInfo creditInfo = new CreditInfo();
                        ArrayList<CreditInfoModel> list = creditInfo.getCreditInfo(user_code);
                        for(CreditInfoModel creditInfoModel :list){
                        %>
                    <tr>
                        <td> <%=creditInfoModel.getCreditid()%> </td>
                        <td><%=creditInfoModel.getClientMaster()%></td>
                        <td><%=creditInfoModel.getImapprovedlines()%></td>
			<td><%=creditInfoModel.getApprovedlinesallbanks()%></td>
                        <td><%=creditInfoModel.getImoutstandingamount()%></td>
                        <td><%=creditInfoModel.getOutstandingamountallbanks()%></td>
                        <td><%=creditInfoModel.getRiskrating()%></td>
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
	<div id="addCreditInformationModal" class="modal fade">
		<div class="modal-dialog">
			<div class="modal-content">
				<form  name="addCreditInfo"  method="POST"  action="${pageContext.request.contextPath}/do?MOD=BOK&ACT=doAddCreditInfo"  id="addCreditInfo">
					<div class="modal-header">						
						<h4 class="modal-title">Add New Credit Information</h4>
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
					</div>
					<div class="modal-body">					
						<div class="form-group">
                                                    <%
                                 ArrayList<ClientModel> clientname = creditInfo.getClientMasterList(user_code); 
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
							<label>I&M Approved Lines</label>
							<input type="text" name="imapprovedlinesa" id="imapprovedlinesa" class="form-control" required>
						</div>
						<div class="form-group">
							<label>I&M Outstanding Amount</label>
							<input type="text" name="imoutstandingamta" id="imoutstandingamta" class="form-control" required>
						</div>
                                                    <div class="form-group">
                                                            <label>All Banks Approved Lines</label>
                                                            <input type="text" name="allapprovedlinesa" id="allapprovedlinesa" class="form-control" required>
                                                    </div>
                                                    <div class="form-group">
                                                            <label>All Banks Outstanding Amount</label>
                                                            <input type="text" name="alloutstandingamta" id="alloutstandingamta" class="form-control" required>
                                                    </div>
						<div class="form-group">
							<label>Risk Rating</label>
							<input type="text"  name="riskratinga" id="riskratinga"  class="form-control" required>
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
	<div id="editCreditInformationModal" class="modal fade">
		<div class="modal-dialog">
			<div class="modal-content">
				<form>
					<div class="modal-header">						
						<h4 class="modal-title">Edit Credit Information</h4>
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
					</div>
					<div class="modal-content">
				<form>
					<div class="modal-header">						
						<h4 class="modal-title">Add New Credit Information</h4>
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
					</div>
					<div class="modal-body">					
						<div class="form-group">
                                                    <%
                                 clientname = creditInfo.getClientMasterList(user_code); 
                                                        %>
							<label>Client Name</label>
				 <select name="clientnamee" id="clientnamee" class="form-control" required>
                                      <%
                                    for(ClientModel cl : clientname){ 
                                %> 
                                <option value ="<%=cl.getClientid()%>" > <%=cl.getClientname()%></option>  
                                <%
                                    }
//ratingagencye,riskratinge,outstandingamte,approvedlinese,clientnamee
                                %>   
                                     </select>
						</div>
						<div class="form-group">
							<label>Approved Lines</label>
							<input type="text" name="approvedlinese" id="approvedlinese" class="form-control" required>
						</div>
						<div class="form-group">
							<label>Outstanding Amount</label>
							<input type="text" name="outstandingamte" id="outstandingamta" class="form-control" required>
						</div>
						<div class="form-group">
							<label>Risk Rating</label>
							<input type="text"  name="riskratinge" id="riskratinge"  class="form-control" required>
						</div>	
                                                <div class="form-group">
							<label>Rating Agency</label>
							<input type="text"  name="ratingagencye" id="ratingagencye"  class="form-control" required>
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
	<div id="deleteCreditInformationModal" class="modal fade">
		<div class="modal-dialog">
			<div class="modal-content">
				<form>
					<div class="modal-header">						
						<h4 class="modal-title">Delete CreditInformation</h4>
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