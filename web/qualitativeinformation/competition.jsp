<%@page import="com.inm.dao.qualitativeinformation.*"%>
<%@page import="com.inm.models.*"%> 
<%@page import="java.util.ArrayList"%> 
<%@ include file="../include/header.jsp" %>
<html>
<head>
    <script type="text/javascript">
 
            var form = $('#addCompetition');
            form.submit(function () {

            $.ajax({
            type: "POST",
            url: ${pageContext.request.contextPath}+'/do?MOD=BOK&ACT=doAddCompetition',
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
						<h2>Competition <b>Information</b></h2>
					</div>
					<div class="col-sm-6">
						<a href="#addCompetitionModal" class="btn btn-success" data-toggle="modal"><i class="material-icons">&#xE147;</i> <span>Add New Competition</span></a>
						<a href="#deleteCompetitionModal" class="btn btn-danger" data-toggle="modal"><i class="material-icons">&#xE15C;</i> <span>Delete</span></a>						
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
                        <th>Client Name</th>
			<th>Bank</th>
                        <th>Estimated wallet share</th>
                        <th>Strengths</th>
                        <th>Weaknesses</th> 
                        <th>Actions</th>
                    </tr>
                </thead> 
                <tbody>
                     
                    <%
                        CompetitionMaster comp = new CompetitionMaster();
                        ArrayList<CompetitionModel> list = comp.getCompetitionInfo(user_code);
                        for(CompetitionModel competitionModel :list){
                        %>
                  <tr>
                  
						<td>
							<span class="custom-checkbox">
								<input type="checkbox" id="checkbox1" name="options[]" value="1">
								<label for="checkbox1"></label>
							</span>
						</td> 
                        <td><%=competitionModel.getClientMaster()%></td>
			<td><%=competitionModel.getBank()%></td>
                        <td><%=competitionModel.getEstimatedwalletshare()%></td>
                        <td><%=competitionModel.getStrengths()%></td>
                        <td> <%=competitionModel.getWeaknesses()%></td> 
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
	<div id="addCompetitionModal" class="modal fade">
		<div class="modal-dialog">
			<div class="modal-content">
            <form  name="addCompetition"  method="POST"  action="${pageContext.request.contextPath}/do?MOD=BOK&ACT=doAddCompetition"  id="addCompetition">
		<input type="hidden" name="uname" id="uname" value="<%= user_code%>"> 			
                <div class="modal-header">						
						<h4 class="modal-title">Add Competition</h4>
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
					</div>
					<div class="modal-body"> 
						<div class="form-group">
                                                    <%
                                 ArrayList<ClientModel> clientname = comp.getClientMasterList(user_code); 
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
							<label>Bank</label>
							<input name="banka" id="banka" type="text" class="form-control" required>
						</div> 	
                                                 <div class="form-group">
							<label>Estimated Wallet Share</label>
							<input name="estimatedwalletsharea" id="estimatedwalletsharea" type="text" class="form-control" required>
						</div>
                                                  <div class="form-group">
							<label>Strengths</label>
                                                        <input name="strengthsa" id="strengthsa" type="text" class="form-control" required>
						</div>
                                                        <div class="form-group">
							<label>Weaknesses</label>
                                                        <input name="weaknessesa"  id="weaknessesa" type="text" class="form-control" required>
						</div>
					</div>
					<div class="modal-footer">
						<input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
						<input type="submit" onclick="registerCompetition();"  class="btn btn-success" value="Add">
					</div>
				</form>
			</div>
		</div>
	</div>
	<!-- Edit Modal HTML -->
	<div id="editCompetitionModal" class="modal fade">
		<div class="modal-dialog">
			<div class="modal-content">
				<form   name="edditCompetition" method="GET" action="do?MOD=BOK&ACT=doUpdateCompetition" id="edditCompetition">
                                     	<div class="modal-header">						
						<h4 class="modal-title">Edit Competition</h4>
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
					</div>
					<div class="modal-body"> 
						<div class="form-group">
                                                    <%
                                   clientname = comp.getClientMasterList(user_code); 
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
							<label>Bank</label>
							<input name="banke" id="banke" type="text" class="form-control" required>
						</div> 	
                                                 <div class="form-group">
							<label>Estimated Wallet Share</label>
							<input name="estimatedwalletsharee" id="estimatedwalletsharee" type="text" class="form-control" required>
						</div>
                                                  <div class="form-group">
							<label>Strengths</label>
                                                        <input name="strengthse" id="strengthse" type="text" class="form-control" required>
						</div>
                                                        <div class="form-group">
							<label>Weaknesses</label>
                                                        <input name="weaknessese"  id="weaknessese" type="text" class="form-control" required>
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
	<div id="deleteCompetitionModal" class="modal fade">
		<div class="modal-dialog">
			<div class="modal-content">
				<form>
					<div class="modal-header">						
						<h4 class="modal-title">Delete Competition</h4>
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