<%@page import="com.inm.dao.client.*"%>
<%@page import="com.inm.models.*"%> 
<%@page import="java.util.ArrayList"%> 
<%@ include file="../include/header.jsp" %>
<html>
    <head>
         <script type="text/javascript">
 
            var form = $('#addShareholder');
            form.submit(function () {

            $.ajax({
            type: "POST",
            url: ${pageContext.request.contextPath}+'/do?MOD=BOK&ACT=doAddShareholder',
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
 
            var form = $('#addDirector');
            form.submit(function () {

            $.ajax({
            type: "POST",
            url: ${pageContext.request.contextPath}+'/do?MOD=BOK&ACT=doAddDirector',
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
 
            var form = $('#addCompany');
            form.submit(function () {

            $.ajax({
            type: "POST",
            url: ${pageContext.request.contextPath}+'/do?MOD=BOK&ACT=doAddCompany',
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
            $("#companyid").val($(that).parent().prev().prev().prev().prev().prev().prev().prev().text());
         $("#clientnamee").val($(that).parent().prev().prev().prev().prev().prev().prev().text());
         $("#companyaddresse").val($(that).parent().prev().prev().prev().prev().prev().text());
         $("#grpnamee").val($(that).parent().prev().prev().prev().prev().text());
        $("#hqcountrye").val($(that).parent().prev().prev().prev().text());
          $("#indrustrye").val($(that).parent().prev().prev().text());
         $("#noofsubsidiarye").val($(that).parent().prev().text()); 
       	} 
  //noofsubsidiarye,indrustrye,hqcountrye,grpnamee,companyaddresse,clientnamee,companyid     
   $('#editCompanyModal').modal('show'); 
       </script>
    </head>
<div class="container">
        <div class="table-wrapper">
            <div class="table-title">
                <div class="row">
                    <div class="col-sm-6">
						<h2>Manage <b>Company Information</b></h2>
					</div>
					<div class="col-sm-6">
                                            <a href="#addCompanyModal" class="btn btn-success" data-toggle="modal"><i class="material-icons">&#xE147;</i> <span>Add Company</span></a>
						<a href="#addShareholderModal" class="btn btn-primary" data-toggle="modal"><i class="material-icons">&#xE147;</i> <span>Add Shareholder</span></a>
                                                <a href="#addDirectorModal" class="btn btn-info" data-toggle="modal"><i class="material-icons">&#xE147;</i> <span>Add Director</span></a>
                                            </div>
                </div>
            </div>
            <table class="table table-striped table-hover">
                <thead>
                    <tr>
                        <th>
                        #
                        </th>
                        <th>Client Name</th>
                        <th>Company Address</th>
			<th>Group Name</th>
                        <th>HQ Country</th>
                        <th>Industry</th>
                        <th>Segment</th>
                        <th># Of Subsidiaries</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        Company company = new Company();
                        ArrayList<CompanyModel> list = company.getCompanyInfo(user_code);
                        for(CompanyModel companyModel :list){
                        %>
                    <tr>
                        <td><%=companyModel.getCompanyid()%> </td>
                        <td><%=companyModel.getClientMaster()%></td>
                        <td><%=companyModel.getCompanyAddress()%></td>
                        <td><%=companyModel.getGroupname()%></td>
			<td><%=companyModel.getLookupmasterByAffiliatelookupmasterid()%></td>
                        <td><%=companyModel.getLookupmasterByIndustrylookupmasterid()%></td>
                        <td><%=companyModel.getLookupmasterBySegmentlookupmasterid()%></td>
                        <td><%=companyModel.getNoofsubsidiaries()%></td>
                        <td>
                           <button onclick='fetchOldRecord(this);' class='btn btn-sm btn-info' data-toggle='modal' data-target='#editCompanyModal'>Update</button>
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
	<div id="addCompanyModal" class="modal fade">
		<div class="modal-dialog">
			<div class="modal-content">
				<form  name="addCompany"  method="POST"  action="${pageContext.request.contextPath}/do?MOD=BOK&ACT=doAddCompany"  id="addCompany">
					<div class="modal-header">						
						<h4 class="modal-title">Add Company Information</h4>
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
					</div>
                                        <input type="hidden" name="uname" id="uname" value="<%= user_code%>"> 	
					<div class="modal-body">
                                            	<div class="form-group">
                                                    <%
                                 ArrayList<ClientModel> clientname = company.getClientMasterList(user_code); 
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
							<label>Company Address</label>
                                                        <textarea  name="companyaddressa" id="companyaddressa" class="form-control" required></textarea>
							 </div>
						<div class="form-group">
							<label>Group Name</label>
							<input  name="grpnamea" id="grpnamea"  type="text" class="form-control" required>
						</div>
						<div class="form-group">
							<label>HQ Country</label>
                                                        <%  
                                ArrayList<LookupmasterModel> affiliate = company.getLookupList("AFFILIATE"); 
                                                        %>
							 
                                                        <select name="hqcountrya" id="hqcountrya" class="form-control" required>
                                      <%
                                    for(LookupmasterModel lst : affiliate){ 
                                %> 
                                <option value ="<%=lst.getLookupmasterid()%>" > <%=lst.getValue()%></option>  
                                <%
                                    } 
                                %>   
                                     </select>
						</div>	
                                     <div class="form-group">
                                                    <%  
                                  ArrayList<LookupmasterModel> industry = company.getLookupList("INDUSTRY"); 
                                                        %>
							<label>Industry</label>
				 <select name="indrustrya" id="indrustrya" class="form-control" required>
                                      <%
                                    for(LookupmasterModel lst : industry){ 
                                %> 
                                <option value ="<%=lst.getLookupmasterid()%>" > <%=lst.getValue()%></option>  
                                <%
                                    } 
                                %>   
                                     </select>
						</div>
                                     <div class="form-group">
                                                    <%  
                                  ArrayList<LookupmasterModel> segment = company.getLookupList("SEGMENT"); 
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
							<label>Number Of Subsidiaries</label>
							<input  name="noofsubsidiarya" id="noofsubsidiarya"  type="text" class="form-control" required>
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
        <!-- Add Shareholder Modal HTML -->                             
    <div id="addShareholderModal" class="modal fade">
		<div class="modal-dialog">
			<div class="modal-content">
				<form  name="addShareholder"  method="POST"  action="${pageContext.request.contextPath}/do?MOD=BOK&ACT=doAddShareholder"  id="addShareholder">
					<div class="modal-header">						
						<h4 class="modal-title">Add Shareholder Information</h4>
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
					</div>
                                        <input type="hidden" name="uname" id="uname" value="<%= user_code%>"> 	
					<div class="modal-body">
                                            <div class="form-group">
							<label>Company Name</label>
                                                        <%   
                                ArrayList<CompanyModel> companyList = company.getCompanyMasterList(user_code); 
                                                        %>
							 
                                                        <select name="companya" id="companya" class="form-control" required>
                                      <%
                                    for(CompanyModel lst : companyList){ 
                                %> 
                                <option value ="<%=lst.getCompanyid()%>" > <%=lst.getGroupname()%></option>  
                                <%
                                    } 
                                %>   
                                     </select>
						</div>		 
                                     <div class="form-group">
							<label>ShareHolder Name</label>
							<input  name="shareholdera" id="shareholdera"  type="text" class="form-control" required>
						</div>
                                     <div class="form-group">
							<label> Share holding(%)</label>
							<input  name="shareholdinga" id="shareholdinga"  type="text" class="form-control" required>
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
     <!-- Add Director Modal HTML -->                             
    <div id="addDirectorModal" class="modal fade">
		<div class="modal-dialog">
			<div class="modal-content">
				<form  name="addDirector"  method="POST"  action="${pageContext.request.contextPath}/do?MOD=BOK&ACT=doAddDirector"  id="addDirector">
					<div class="modal-header">						
						<h4 class="modal-title">Add Director Information</h4>
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
					</div>
                                        <input type="hidden" name="uname" id="uname" value="<%= user_code%>"> 	
					<div class="modal-body">
                                         <div class="form-group">
							<label>Company Name</label>
                                                        <%   
                                  companyList = company.getCompanyMasterList(user_code); 
                                                        %>
							 
                                                        <select name="companya" id="companya" class="form-control" required>
                                      <%
                                    for(CompanyModel lst : companyList){ 
                                %> 
                                <option value ="<%=lst.getCompanyid()%>" > <%=lst.getGroupname()%></option>  
                                <%
                                    } 
                                %>   
                                     </select>
						</div>	   	 
                                     <div class="form-group">
							<label>Director Name</label>
							<input  name="directornamea" id="directornamea"  type="text" class="form-control" required>
						</div>
                                     <div class="form-group">
							<label>Director Position</label>
							<input  name="directorposta" id="directorposta"  type="text" class="form-control" required>
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
	<div id="editCompanyModal" class="modal fade">
		<div class="modal-dialog">
			<div class="modal-content">
				<form>
					<div class="modal-header">						
						<h4 class="modal-title">Edit Company</h4>
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
					</div>
					<div class="modal-body">
                                            	<div class="form-group">
                                                    <input  name="companyid" id="companyid"   type="text" class="form-control" required>
                                                    <%
                                   clientname = company.getClientMasterList(user_code); 
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
							<label>Company Address</label>
                                                        <textarea  name="companyaddresse" id="companyaddresse" class="form-control" required></textarea>
							 </div>
    
						<div class="form-group">
							<label>Group Name</label>
							<input  name="grpnamee" id="grpnamee"  type="text" class="form-control" required>
						</div>
						<div class="form-group">
							<label>HQ Country</label> 
							 
                                                        <select name="hqcountrye" id="hqcountrye" class="form-control" required>
                                      <%
                                    for(LookupmasterModel lst : affiliate){ 
                                %> 
                                <option value ="<%=lst.getLookupmasterid()%>" > <%=lst.getValue()%></option>  
                                <%
                                    } 
                                %>   
                                     </select>
						</div>	
                                     <div class="form-group">
                                                    <%  
                                   industry = company.getLookupList("INDUSTRY"); 
                                                        %>
							<label>Industry</label>
				 <select name="indrustrye" id="indrustrye" class="form-control" required>
                                      <%
                                    for(LookupmasterModel lst : industry){ 
                                %> 
                                <option value ="<%=lst.getLookupmasterid()%>" > <%=lst.getValue()%></option>  
                                <%
                                    } 
                                %>   
                                     </select>
						</div>
                                     <div class="form-group">
                                                    <%  
                                   segment = company.getLookupList("SEGMENT"); 
                                                        %>
							<label>Segment</label>
				 <select name="segmente" id="segmente" class="form-control" required>
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
							<label>Number Of Subsidiaries</label>
							<input  name="noofsubsidiarye" id="noofsubsidiarye"  type="text" class="form-control" required>
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
	<div id="deleteCompanyModal" class="modal fade">
		<div class="modal-dialog">
			<div class="modal-content">
				<form>
					<div class="modal-header">						
						<h4 class="modal-title">Delete Company</h4>
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