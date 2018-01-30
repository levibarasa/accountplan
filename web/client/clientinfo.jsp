<%@page import="com.inm.dao.client.Client"%>
<%@page import="com.inm.models.*"%> 
<%@page import="java.util.ArrayList"%> 
<%@ include file="../include/header.jsp" %>
<html>
<head>
      <script type="text/javascript"> 
          function updateValues(ths, clientid, currentdate,trades,cashm,ebank,riskm) { 
                    var clientidb = document.getElementById("clientidb");
                    var clientnameb = document.getElementById("clientnameb");
                    var currentdateb = document.getElementById("currentdateb");
                    var tradespb = document.getElementById("tradespb");
                    var cashmpb = document.getElementById("cashmpb");
                    var ebankpb = document.getElementById("ebankpb");
                    var riskmpb = document.getElementById("riskmpb"); 
                    clientnameb.value = ths.value.innerHTML; //for innerhtml
                    clientidb.value = clientid;
                    currentdateb.value = currentdate;
                   tradesp.value = tradespb;
                    cashmpb.value = cashmp;
                   ebankpb.value = ebankp;
                    riskmpb.value = riskmp; 
            }
            
//       $(document).ready(function () {
//    $("#clientnameb").change(function () {
//        var val = $(this).val();
//        
//        if (val == "item1") {
//            $("#size").html("<option value='test'>item1: test 1</option><option value='test2'>item1: test 2</option>");
//        }  
//    });
//});
    </script>
    <script type="text/javascript">
 
            var form = $('#addClient');
            form.submit(function () {

            $.ajax({
            type: "POST",
            url: ${pageContext.request.contextPath}+'/do?MOD=BOK&ACT=doAddClient',
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
//            function registerClient() {
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
//			url : ${pageContext.request.contextPath}+'/do?MOD=BOK&ACT=doAddClient',
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
						<h2>Client <b>Information</b></h2>
					</div>
					<div class="col-sm-6">
						<a href="#addClientModal" class="btn btn-success" data-toggle="modal"><i class="material-icons">&#xE147;</i> <span>Add New Client</span></a>
						<a href="#deleteClientModal" class="btn btn-danger" data-toggle="modal"><i class="material-icons">&#xE15C;</i> <span>Delete</span></a>						
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
			<th>Rm Name</th>
                        <th>Alt Rm Name</th>
                        <th>Country</th>
                        <th>Date</th>
                        <th>Trade Services Partner</th>
                        <th>Cash Management Partner</th>
                        <th>E-Banking Partner</th>
                        <th>Risk Management Partner</th>
                        <th>Actions</th>
                    </tr>
                </thead> 
                <tbody>
                     
                    <%
                        Client client = new Client();
                        ArrayList<ClientModel> list = client.getClientInfo(user_code);
                        for(ClientModel clientModel :list){
                        %>
                  <tr>
                  
						<td>
							<span class="custom-checkbox">
								<input type="checkbox" id="checkbox1" name="options[]" value="1">
								<label for="checkbox1"></label>
							</span>
						</td> 
                        <td><%=clientModel.getClientname()%></td>
			<td><%=clientModel.getRmCode()%></td>
                        <td><%=clientModel.getAlternativeRmCode()%></td>
                        <td><%=clientModel.getAffiliate()%></td>
                        <td> <%=clientModel.getCurrentDate()%></td>
                        <td><%=clientModel.getTradeserviceprovider()%> </td>
                        <td><%=clientModel.getCashmanagementpartner()%></td>
                        <td><%=clientModel.getEBankingpartner()%></td>
                        <td><%=clientModel.getRiskmanagementpartner()%> </td>
                        <td>
                            <a href="#editClientModal" class="edit" data-toggle="modal"><i class="material-icons" data-toggle="tooltip" title="Edit">&#xE254;</i></a>
                            <a href="#deleteClientModal" class="delete" data-toggle="modal"><i class="material-icons" data-toggle="tooltip" title="Delete">&#xE872;</i></a>
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
	<div id="addClientModal" class="modal fade">
		<div class="modal-dialog">
			<div class="modal-content">
            <form  name="addClient"  method="POST"  action="${pageContext.request.contextPath}/do?MOD=BOK&ACT=doAddClient"  id="addClient">
		<input type="hidden" name="uname" id="uname" value="<%= user_code%>"> 			
                <div class="modal-header">						
						<h4 class="modal-title">Add Client</h4>
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
					</div>
					<div class="modal-body">					
						<div class="form-group">
							<label>Name</label>
							<input name="clientnamea" id="clientnamea" type="text" class="form-control" required>
						</div>
						<div class="form-group">
							<label>Relationship Officer</label>
                                                        <%
                                 ArrayList<RmCodelistModel>  allRms = client.getRmCodeList();
                                 
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
                                <label>Alternative Relationship Officer</label>
                            
                        <select name="altrmCodea" id="altrmCodea" class="form-control" required>
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
                                                     <%
                                 ArrayList<LookupmasterModel>  affiliates = client.getLookupList("AFFILIATE");
                                 
                                                        %>
							<label>Country</label>
             <select name="affiliatea" id="affiliatea" class="form-control" required>
                        <%
                                    for(LookupmasterModel lookupmasterModel : affiliates){ 
                                %> 
                                <option value ="<%=lookupmasterModel.getLookupmasterid()%>" > <%=lookupmasterModel.getValue()%></option>  
                                <%
                                    } 
                                %>
                     </select>
						</div>
                                                    <div class="form-group">
							<label>Date</label>
							<input name="currentdatea" id="currentdatea" type="text" class="form-control" required>
						</div>    
						<div class="form-group">
							<label>Trade Service Partner</label>
                                                        <input name="tradespa" id="tradespa" type="text" class="form-control" required>
						</div>	
                                                        <div class="form-group">
							<label>Cash Management Partner</label>
							<input name="cashmpa" id="cashmpa" type="text" class="form-control" required>
						</div>
                                                  <div class="form-group">
							<label>E-Banking Partner</label>
                                                        <input name="ebankpa" id="ebankpa" type="text" class="form-control" required>
						</div>
                                                        <div class="form-group">
							<label>Risk Management Partner</label>
                                                        <input name="riskmpa"  id="riskmpa" type="text" class="form-control" required>
						</div>
					</div>
					<div class="modal-footer">
						<input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
						<input type="submit" onclick="registerClient();"  class="btn btn-success" value="Add">
					</div>
				</form>
			</div>
		</div>
	</div>
	<!-- Edit Modal HTML -->
	<div id="editClientModal" class="modal fade">
		<div class="modal-dialog">
			<div class="modal-content">
            <form  name="addClient"  method="POST"  action="${pageContext.request.contextPath}/do?MOD=BOK&ACT=doAddClient"  id="addClient">
		<input type="hidden" name="uname" id="uname" value="<%= user_code%>"> 			
                <div class="modal-header">						
						<h4 class="modal-title">Edit Client</h4>
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
					</div>
					<div class="modal-body">					
						<div class="form-group">
							<label>Name</label>
							<input name="clientnamea" id="clientnamea" type="text" class="form-control" required>
						</div>
						<div class="form-group">
							<label>Relationship Officer</label>
                                                        <%
                                    allRms = client.getRmCodeList();
                                 
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
                                <label>Alternative Relationship Officer</label>
                            
                        <select name="altrmCodea" id="altrmCodea" class="form-control" required>
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
                                                     <%
                                  affiliates = client.getLookupList("AFFILIATE");
                                 
                                                        %>
							<label>Country</label>
             <select name="affiliatea" id="affiliatea" class="form-control" required>
                        <%
                                    for(LookupmasterModel lookupmasterModel : affiliates){ 
                                %> 
                                <option value ="<%=lookupmasterModel.getLookupmasterid()%>" > <%=lookupmasterModel.getValue()%></option>  
                                <%
                                    } 
                                %>
                     </select>
						</div>
                                                    <div class="form-group">
							<label>Date</label>
							<input name="currentdatea" id="currentdatea" type="text" class="form-control" required>
						</div>    
						<div class="form-group">
							<label>Trade Service Partner</label>
                                                        <input name="tradespa" id="tradespa" type="text" class="form-control" required>
						</div>	
                                                        <div class="form-group">
							<label>Cash Management Partner</label>
							<input name="cashmpa" id="cashmpa" type="text" class="form-control" required>
						</div>
                                                  <div class="form-group">
							<label>E-Banking Partner</label>
                                                        <input name="ebankpa" id="ebankpa" type="text" class="form-control" required>
						</div>
                                                        <div class="form-group">
							<label>Risk Management Partner</label>
                                                        <input name="riskmpa"  id="riskmpa" type="text" class="form-control" required>
						</div>
					</div>
					<div class="modal-footer">
						<input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
						<input type="submit" onclick="registerClient();"  class="btn btn-success" value="Add">
					</div>
				</form>
			</div>
		</div>
	</div>
        
        
	<!-- Delete Modal HTML -->
	<div id="deleteClientModal" class="modal fade">
		<div class="modal-dialog">
			<div class="modal-content">
				<form>
					<div class="modal-header">						
						<h4 class="modal-title">Delete Client</h4>
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