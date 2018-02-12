<%@page import="com.inm.dao.qualitativeinformation.*"%> 
<%@page import="com.inm.models.*"%> 
<%@page import="java.util.ArrayList"%> 
<%@page import="com.inm.dao.valuechain.*"%> 
<%@page import="com.inm.dao.client.*"%> 
<%@page import="com.inm.dao.walletresize.*"%>
<%@ include file="../include/header.jsp" %>

<html>
<head>
<script type="text/javascript">
       var form = $('#selectClient');
            form.submit(function () {

            $.ajax({
            type: "POST", 
            url: ${pageContext.request.contextPath}+'/rpt/accountplan.jsp',
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
<div class="text-center">
	<!-- Button HTML (to Trigger Modal) -->
        <div class="modal-dialog modal-login">
	<div class="modal-content"> 
			<div class="modal-header"> 			
				<h4 class="modal-title">Select Client Name</h4>	 
			</div>
            <%
                        Company company = new Company();
                        ArrayList<CompanyModel> list = company.getCompanyInfo(user_code); 
                        %>
                    <tr>
			<div class="modal-body">
				<form id="selectClient" name="selectClient" method="post" action="${pageContext.request.contextPath}/rpt/accountplan.jsp">
					<input type="hidden" name="uname" id="uname" value="<%= user_code%>"> 
                                    <div class="form-group">
                                                    <%
                                 ArrayList<ClientModel> clientname = company.getClientMasterList(user_code); 
                                                        %> 
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
						<button type="submit" class="btn btn-primary btn-lg btn-block login-btn">Submit</button>
					</div>
				</form>
			</div> 
		</div>
        </div>
</div>   
<%@ include file="../include/footer.jsp" %>
