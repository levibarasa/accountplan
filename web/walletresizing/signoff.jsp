<%@page import="com.inm.dao.walletresize.*"%>
<%@page import="com.inm.models.*"%> 
<%@page import="java.util.ArrayList"%> 
<%@ include file="../include/header.jsp" %>
<html>
<head>
    <script type="text/javascript">
 
            var form = $('#addSignOff');
            form.submit(function () {

            $.ajax({
            type: "POST",
            url: ${pageContext.request.contextPath}+'/do?MOD=BOK&ACT=doAddSignOff',
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
//            function registerSignOff() {
//		var uname = $("#uname").val();
//		var clientname = $("#clientnamea").val();
//		var rmCode = $("#uemaila").val();
//		var altrmCode = $("#altrmCodea").val();
//                var affiliate = $("#affiliatea").val();
//                var currentdate = $("#currentdatea").val();
//                var tradesp = $("#tradespa").val();
//                var cashmp = $("#cashmpa").val();
//                var ebankp = $("#ebankpa").val();
//                var riskmp = $("#riskmpa").val(); 
//		$.ajax({
//			type : "POST",
//			url : ${pageContext.request.contextPath}+'/do?MOD=BOK&ACT=doAddSignOff',
//			data : "clientname=" + clientname + "&rmCode=" + rmCode + "&altrmCode=" + altrmCode
//                        + "&affiliate=" + affiliate+ "&currentdate=" + currentdate+ "&tradesp=" + tradesp+ "&cashmp=" + cashmp+ "&ebankp=" + ebankp+ "&riskmp=" + riskmp,
//			success : function(data) {
//				var ht = data.msg;
//                                alert(ht);
//				//$("#resp").html(ht);
//			},
//			error : function(data) {
//				alert("Some error occured.");
//			}
//		});
//	}
</script>
   </head>    
<div class="container">
        <div class="table-wrapper">
            <div class="table-title">
                <div class="row">
                    <div class="col-sm-6">
						<h2>Sign-Off <b>Information</b></h2>
					</div>
					<div class="col-sm-6">
						<a href="#addSignOffModal" class="btn btn-success" data-toggle="modal"><i class="material-icons">&#xE147;</i> <span>Add New SignOff</span></a>
						<a href="#deleteSignOffModal" class="btn btn-danger" data-toggle="modal"><i class="material-icons">&#xE15C;</i> <span>Delete</span></a>						
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
			<th>Head Of Corporate Sign-off</th>
                        <th>Rm Sign-off</th>                        
                        <th>Actions</th>
                    </tr>
                </thead> 
                <tbody>
                     
                    <%
                        SignOffMaster som = new SignOffMaster();
                         ArrayList<SignOffModel> list = som.getSignOff(user_code);
                        for(SignOffModel somModel :list){
                        %>
                  <tr>
                  
						<td>
							<span class="custom-checkbox">
								<input type="checkbox" id="checkbox1" name="options[]" value="1">
								<label for="checkbox1"></label>
							</span>
						</td> 
                        <td><%=somModel.getClientMaster()%></td>
			<td><%=somModel.getHeadofcorporatesignoff()%></td>
                        <td><%=somModel.getRmsignoff()%></td> 
                        <td>
                            <a href="#editSignOffModal" class="edit" data-toggle="modal"><i class="material-icons" data-toggle="tooltip" title="Edit">&#xE254;</i></a>
                            <a href="#deleteSignOffModal" class="delete" data-toggle="modal"><i class="material-icons" data-toggle="tooltip" title="Delete">&#xE872;</i></a>
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
	<div id="addSignOffModal" class="modal fade">
		<div class="modal-dialog">
			<div class="modal-content">
            <form  name="addSignOff"  method="POST"  action="${pageContext.request.contextPath}/do?MOD=BOK&ACT=doAddSignOff"  id="addSignOff">
		<input type="hidden" name="uname" id="uname" value="<%= user_code%>"> 			
                <div class="modal-header">						
						<h4 class="modal-title">Add SignOff</h4>
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
					</div>
					<div class="modal-body">					
						 	<div class="form-group">
                                                    <%
                                 ArrayList<ClientModel> clientname = som.getClientMasterList(user_code); 
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
                                           <label>Head Of Corporate Sign-off</label>
                               <select name="headofcorporatesignoffa" id="headofcorporatesignoffa" class="form-control" required>
                                     <option value="Yes">Yes</option>
                                      <option value="No">No</option>
                                 </select>
                                </div>    
                                  <div class="form-group">
                                           <label>RM Sign-off</label>
                               <select name="rmsignoffa" id="rmsignoffa" class="form-control" required>
                                     <option value="Yes">Yes</option>
                                      <option value="No">No</option>
                                 </select>
                                </div> 	
                                           
					</div>
					<div class="modal-footer">
						<input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
						<input type="submit" onclick="registerSignOff();"  class="btn btn-success" value="Add">
					</div>
				</form>
			</div>
		</div>
	</div>
	<!-- Edit Modal HTML -->
	<div id="editSignOffModal" class="modal fade">
		<div class="modal-dialog">
			<div class="modal-content">
				<form   name="edditSignOff" method="GET" action="do?MOD=BOK&ACT=doUpdateSignOff" id="edditSignOff">
                                     	<div class="modal-header">						
						<h4 class="modal-title">Edit SignOff</h4>
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
					</div>
					<div class="modal-body">					
						 	<div class="form-group">
                                                    <%
                                  clientname = som.getClientMasterList(user_code); 
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
                                           <label>Head Of Corporate Sign-off</label>
                               <select name="headofcorporatesignoffa" id="headofcorporatesignoffa" class="form-control" required>
                                     <option value="Yes">Yes</option>
                                      <option value="No">No</option>
                                 </select>
                                </div>    
                                  <div class="form-group">
                                           <label>RM Sign-off</label>
                               <select name="rmsignoffa" id="rmsignoffa" class="form-control" required>
                                     <option value="Yes">Yes</option>
                                      <option value="No">No</option>
                                 </select>
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
	<div id="deleteSignOffModal" class="modal fade">
		<div class="modal-dialog">
			<div class="modal-content">
				<form>
					<div class="modal-header">						
						<h4 class="modal-title">Delete SignOff</h4>
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