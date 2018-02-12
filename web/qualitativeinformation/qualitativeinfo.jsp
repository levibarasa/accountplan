<%@page import="com.inm.dao.qualitativeinformation.*"%>
<%@page import="com.inm.models.*"%>  
<%@page import="java.util.ArrayList"%> 
<%@ include file="../include/header.jsp" %>

<html>
<head>
    <script type="text/javascript">
 
            var form = $('#addQualitativeInfo');
            form.submit(function () {

            $.ajax({
            type: "POST",
            url: ${pageContext.request.contextPath}+'/do?MOD=BOK&ACT=doAddQualitativeInfo',
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
						<h2>Manage <b>Account Revenue Information</b></h2>
					</div>
					<div class="col-sm-6">
						<a href="#addQualitativeInformationModal" class="btn btn-success" data-toggle="modal"><i class="material-icons">&#xE147;</i> <span>Add New QualitativeInformation</span></a>
						<a href="#deleteQualitativeInformationModal" class="btn btn-danger" data-toggle="modal"><i class="material-icons">&#xE15C;</i> <span>Delete</span></a>						
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
                        <th>Client Strategy</th>
			<th>Wallet Allocation Logic</th>
                        <th>Opportunities</th>
                        <th>Specific Challenges</th>
                        <th> Relationship Quality</th> 
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                      <%
                         QualitativeInfo qi = new QualitativeInfo(); 
                        ArrayList<QualitativeinformationModel> list = qi.getQualitativeinfo(user_code);
                        for(QualitativeinformationModel qualitativeinformationModel :list){
                        %>
                    <tr>
						<td>
							<span class="custom-checkbox">
								<input type="checkbox" id="checkbox1" name="options[]" value="1">
								<label for="checkbox1"></label>
							</span>
						</td>
                        <td><%=qualitativeinformationModel.getClientMaster()%></td>
                        <td><%=qualitativeinformationModel.getClientstrategy()%></td>
			<td><%=qualitativeinformationModel.getClientwalletalloctnlogic()%></td>
                        <td><%=qualitativeinformationModel.getOpportunities()%></td>
                        <td><%=qualitativeinformationModel.getSpecificchallenges()%></td>
                        <td><%=qualitativeinformationModel.getRelationshipquality()%></td> 
                        <td>
                            <a href="#editQualitativeInformationModal" class="edit" data-toggle="modal"><i class="material-icons" data-toggle="tooltip" title="Edit">&#xE254;</i></a>
                            <a href="#deleteQualitativeInformationModal" class="delete" data-toggle="modal"><i class="material-icons" data-toggle="tooltip" title="Delete">&#xE872;</i></a>
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
	<div id="addQualitativeInformationModal" class="modal fade">
		<div class="modal-dialog">
			<div class="modal-content">
				<form  name="addQualitativeInfo"  method="POST"  action="${pageContext.request.contextPath}/do?MOD=BOK&ACT=doAddQualitativeInfo"  id="addQualitativeInfo">
					<div class="modal-header">						
						<h4 class="modal-title">Add Qualitative Information</h4>
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
					</div>
					<div class="modal-body">					
						<div class="form-group">
                                                    <%
                                 ArrayList<ClientModel> clientname = qi.getClientMasterList(user_code); 
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
							<label>Client Strategy</label>
							<input type="text" name="clientstrategya" id="clientstrategya" class="form-control" required>
						</div>
						<div class="form-group">
							<label>Wallet Allocation Logic</label>
							<input type="text" name="clientwalletalloctnlogica" id="clientwalletalloctnlogica" class="form-control" required>
						</div>
						<div class="form-group">
							<label>Opportunities</label>
							<input type="text" name="opportunitiesa" id="opportunitiesa" class="form-control" required>
						</div>	
                                                <div class="form-group">
							<label>Specific Challenges</label>
							<input type="text" name="specchallengesa" id="specchallengesa" class="form-control" required>
						</div>
                                                <div class="form-group">
							<label>Relationship Quality</label>
							<input type="text" name="rshpqltya" id="rshpqltya" class="form-control" required>
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
	<div id="editQualitativeInformationModal" class="modal fade">
		<div class="modal-dialog">
			<div class="modal-content">
				<form>
					<div class="modal-header">						
						<h4 class="modal-title">Edit Qualitative Information</h4>
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
					</div>
					<div class="modal-body">					
						<div class="form-group">
                                                    <%
                                   clientname = qi.getClientMasterList(user_code); 
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
							<label>Client Strategy</label>
							<input type="text" name="clientstrategya" id="clientstrategya" class="form-control" required>
						</div>
						<div class="form-group">
							<label>Wallet Allocation Logic</label>
							<input type="text" name="clientwalletalloctnlogica" id="clientwalletalloctnlogica" class="form-control" required>
						</div>
						<div class="form-group">
							<label>Opportunities</label>
							<input type="text" name="opportunitiesa" id="opportunitiesa" class="form-control" required>
						</div>	
                                                <div class="form-group">
							<label>Specific Challenges</label>
							<input type="text" name="specchallengesa" id="specchallengesa" class="form-control" required>
						</div>
                                                <div class="form-group">
							<label>Relationship Quality</label>
							<input type="text" name="rshpqltya" id="rshpqltya" class="form-control" required>
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
	<div id="deleteQualitativeInformationModal" class="modal fade">
		<div class="modal-dialog">
			<div class="modal-content">
				<form>
					<div class="modal-header">						
						<h4 class="modal-title">Delete QualitativeInformation</h4>
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