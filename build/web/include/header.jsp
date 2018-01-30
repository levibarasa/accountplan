<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Account Planning</title>
<link rel="shortcut icon" href="images/favicon.ico" type="image/x-icon">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link href="https://fonts.googleapis.com/css?family=Merienda+One" rel="stylesheet">
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
       <script type="text/javascript">
            window.onload = function () {
                new JsDatePick({
                    useMode: 2,
                    target: "currentdate",
                    dateFormat: "%d/%m/%Y",
                    selectedDate: {//This is an example of what the full configuration offers.
                        day: 22, //For full documentation about these settings please see the full version of the code.
                        month: 1,
                        year: 2018
                    },
                    yearsRange: [1978, 2020],
                    limitToToday: false,
                    cellColorScheme: "beige",
                    dateFormat: "%d/%m/%Y",
                    imgPath: "img/",
                    weekStartDay: 1
                });
            };
        </script>
      <script>
        function doLogout() {
            if (confirm("Are you Sure you want to Logout?")) {
                logout.submit();
            }
  }
    </script>
<style type="text/css">
	body{
		background: #eeeeee;
	}
    .form-inline {
        display: inline-block;
    }
      .footer {
    position: fixed;
    left: 0;
    bottom: 0;
    width: 100%;
    background-color: white;
    color: white;
    text-align: center;
}
	.navbar-header.col {
		padding: 0 !important;
	}	
	.navbar {		
		background: #fff;
		padding-left: 16px;
		padding-right: 16px;
		border-bottom: 1px solid #d6d6d6;
		box-shadow: 0 0 4px rgba(0,0,0,.1);
	}
	.nav-link img {
		border-radius: 50%;
		width: 36px;
		height: 36px;
		margin: -8px 0;
		float: left;
		margin-right: 10px;
	}
	.navbar .navbar-brand {
		color: #555;
		padding-left: 0;
		padding-right: 50px;
		font-family: 'Merienda One', sans-serif;
	}
	.navbar .navbar-brand i {
		font-size: 20px;
		margin-right: 5px;
	}
	.search-box {
        position: relative;
    }	
    .search-box input {
		box-shadow: none;
        padding-right: 35px;
        border-radius: 3px !important;
    }
	.search-box .input-group-addon {
        min-width: 35px;
        border: none;
        background: transparent;
        position: absolute;
        right: 0;
        z-index: 9;
        padding: 7px;
		height: 100%;
    }
    .search-box i {
        color: #a0a5b1;
		font-size: 19px;
    }
	.navbar .nav-item i {
		font-size: 18px;
	}
	.navbar .dropdown-item i {
		font-size: 16px;
		min-width: 22px;
	}
	.navbar .nav-item.open > a {
		background: none !important;
	}
	.navbar .dropdown-menu {
		border-radius: 1px;
		border-color: #e5e5e5;
		box-shadow: 0 2px 8px rgba(0,0,0,.05);
	}
	.navbar .dropdown-menu li a {
		color: #777;
		padding: 8px 20px;
		line-height: normal;
	}
	.navbar .dropdown-menu li a:hover, .navbar .dropdown-menu li a:active {
		color: #333;
	}	
	.navbar .dropdown-item .material-icons {
		font-size: 21px;
		line-height: 16px;
		vertical-align: middle;
		margin-top: -2px;
	}
	.navbar .badge {
		background: #f44336;
		font-size: 11px;
		border-radius: 20px;
		position: absolute;
		min-width: 10px;
		padding: 4px 6px 0;
		min-height: 18px;
		top: 5px;
	}
	.navbar ul.nav li a.notifications, .navbar ul.nav li a.messages {
		position: relative;
		margin-right: 10px;
	}
	.navbar ul.nav li a.messages {
		margin-right: 20px;
	}
	.navbar a.notifications .badge {
		margin-left: -8px;
	}
	.navbar a.messages .badge {
		margin-left: -4px;
	}	
	.navbar .active a, .navbar .active a:hover, .navbar .active a:focus {
		background: transparent !important;
	}
	@media (min-width: 1200px){
		.form-inline .input-group {
			width: 300px;
			margin-left: 30px;
		}
	}
	@media (max-width: 1199px){
		.form-inline {
			display: block;
			margin-bottom: 10px;
		}
		.input-group {
			width: 100%;
		}
	}
</style>
<style type="text/css">
    body {
        color: #566787;
		background: #f5f5f5;
		font-family: 'Varela Round', sans-serif;
		font-size: 13px;
	}
	.table-wrapper {
        background: #fff;
        padding: 20px 25px;
        margin: 30px 0;
		border-radius: 3px;
        box-shadow: 0 1px 1px rgba(0,0,0,.05);
    }
	.table-title {        
		padding-bottom: 15px;
		background: #435d7d;
		color: #fff;
		padding: 16px 30px;
		margin: -20px -25px 10px;
		border-radius: 3px 3px 0 0;
    }
    .table-title h2 {
		margin: 5px 0 0;
		font-size: 24px;
	}
	.table-title .btn-group {
		float: right;
	}
	.table-title .btn {
		color: #fff;
		float: right;
		font-size: 13px;
		border: none;
		min-width: 50px;
		border-radius: 2px;
		border: none;
		outline: none !important;
		margin-left: 10px;
	}
	.table-title .btn i {
		float: left;
		font-size: 21px;
		margin-right: 5px;
	}
	.table-title .btn span {
		float: left;
		margin-top: 2px;
	}
    table.table tr th, table.table tr td {
        border-color: #e9e9e9;
		padding: 12px 15px;
		vertical-align: middle;
    }
	table.table tr th:first-child {
		width: 60px;
	}
	table.table tr th:last-child {
		width: 100px;
	}
    table.table-striped tbody tr:nth-of-type(odd) {
    	background-color: #fcfcfc;
	}
	table.table-striped.table-hover tbody tr:hover {
		background: #f5f5f5;
	}
    table.table th i {
        font-size: 13px;
        margin: 0 5px;
        cursor: pointer;
    }	
    table.table td:last-child i {
		opacity: 0.9;
		font-size: 22px;
        margin: 0 5px;
    }
	table.table td a {
		font-weight: bold;
		color: #566787;
		display: inline-block;
		text-decoration: none;
		outline: none !important;
	}
	table.table td a:hover {
		color: #2196F3;
	}
	table.table td a.edit {
        color: #FFC107;
    }
    table.table td a.delete {
        color: #F44336;
    }
    table.table td i {
        font-size: 19px;
    }
	table.table .avatar {
		border-radius: 50%;
		vertical-align: middle;
		margin-right: 10px;
	}
    .pagination {
        float: right;
        margin: 0 0 5px;
    }
    .pagination li a {
        border: none;
        font-size: 13px;
        min-width: 30px;
        min-height: 30px;
        color: #999;
        margin: 0 2px;
        line-height: 30px;
        border-radius: 2px !important;
        text-align: center;
        padding: 0 6px;
    }
    .pagination li a:hover {
        color: #666;
    }	
    .pagination li.active a, .pagination li.active a.page-link {
        background: #03A9F4;
    }
    .pagination li.active a:hover {        
        background: #0397d6;
    }
	.pagination li.disabled i {
        color: #ccc;
    }
    .pagination li i {
        font-size: 16px;
        padding-top: 6px
    }
    .hint-text {
        float: left;
        margin-top: 10px;
        font-size: 13px;
    }    
	/* Custom checkbox */
	.custom-checkbox {
		position: relative;
	}
	.custom-checkbox input[type="checkbox"] {    
		opacity: 0;
		position: absolute;
		margin: 5px 0 0 3px;
		z-index: 9;
	}
	.custom-checkbox label:before{
		width: 18px;
		height: 18px;
	}
	.custom-checkbox label:before {
		content: '';
		margin-right: 10px;
		display: inline-block;
		vertical-align: text-top;
		background: white;
		border: 1px solid #bbb;
		border-radius: 2px;
		box-sizing: border-box;
		z-index: 2;
	}
	.custom-checkbox input[type="checkbox"]:checked + label:after {
		content: '';
		position: absolute;
		left: 6px;
		top: 3px;
		width: 6px;
		height: 11px;
		border: solid #000;
		border-width: 0 3px 3px 0;
		transform: inherit;
		z-index: 3;
		transform: rotateZ(45deg);
	}
	.custom-checkbox input[type="checkbox"]:checked + label:before {
		border-color: #03A9F4;
		background: #03A9F4;
	}
	.custom-checkbox input[type="checkbox"]:checked + label:after {
		border-color: #fff;
	}
	.custom-checkbox input[type="checkbox"]:disabled + label:before {
		color: #b8b8b8;
		cursor: auto;
		box-shadow: none;
		background: #ddd;
	}
	/* Modal styles */
	.modal .modal-dialog {
		max-width: 400px;
	}
	.modal .modal-header, .modal .modal-body, .modal .modal-footer {
		padding: 20px 30px;
	}
	.modal .modal-content {
		border-radius: 3px;
	}
	.modal .modal-footer {
		background: #ecf0f1;
		border-radius: 0 0 3px 3px;
	}
    .modal .modal-title {
        display: inline-block;
    }
	.modal .form-control {
		border-radius: 2px;
		box-shadow: none;
		border-color: #dddddd;
	}
	.modal textarea.form-control {
		resize: vertical;
	}
	.modal .btn {
		border-radius: 2px;
		min-width: 100px;
	}	
	.modal form label {
		font-weight: normal;
	}
        .square {
    width: 100%;
    padding-bottom: 100%;
    background-size: cover;
    background-position: center;
        }
</style>
<script type="text/javascript">
$(document).ready(function(){
	// Activate tooltip
	$('[data-toggle="tooltip"]').tooltip();
	
	// Select/Deselect checkboxes
	var checkbox = $('table tbody input[type="checkbox"]');
	$("#selectAll").click(function(){
		if(this.checked){
			checkbox.each(function(){
				this.checked = true;                        
			});
		} else{
			checkbox.each(function(){
				this.checked = false;                        
			});
		} 
	});
	checkbox.click(function(){
		if(!this.checked){
			$("#selectAll").prop("checked", false);
		}
	});
});

</script>
<style>
/* Style The Dropdown Button */
.dropbtn {
    background-color: #435d7d;
    color: white;
    padding: 12px;
    font-size: 12px;
    border: none;
    cursor: pointer;
}

/* The container <div> - needed to position the dropdown content */
.dropdown {
    position: relative;
    display: inline-block;
}

/* Dropdown Content (Hidden by Default) */
.dropdown-content {
    display: none;
    position: absolute;
    background-color: #f9f9f9;
    min-width: 160px;
    box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
    z-index: 1;
}

/* Links inside the dropdown */
.dropdown-content a {
    color: black;
    padding: 12px 12px;
    text-decoration: none;
    display: block;
}

/* Change color of dropdown links on hover */
.dropdown-content a:hover {background-color: #f1f1f1}

/* Show the dropdown menu on hover */
.dropdown:hover .dropdown-content {
    display: block;
}

/* Change the background color of the dropdown button when the dropdown content is shown */
.dropdown:hover .dropbtn {
    background-color: white;
    color: #435d7d;
}
</style>
<script type="text/javascript">
        function dopostAccountRevenueDriver() {
          var rmCode = document.getElementById("rmCode").value; 
            window.location.href = 'accountrevenueinfo.jsp?rmCode=' + rmCode;
        }
         function dopostClientInfoDriver() {
          var rmCode = document.getElementById("rmCode").value; 
            window.location.href = '../client/clientinfo.jsp?rmCode=' + rmCode;
        }
        function dopostCompanyInfoDriver() {
          var rmCode = document.getElementById("rmCode").value; 
            window.location.href = '../client/companyinfo.jsp?rmCode=' + rmCode;
        }
        function dopostCreditFinancialDriver() {
          var rmCode = document.getElementById("rmCode").value; 
            window.location.href = '../client/creditfinacial.jsp?rmCode=' + rmCode;
        }  
        function dopostCreditInfoDriver() {
          var rmCode = document.getElementById("rmCode").value; 
            window.location.href = '../client/creditinfo.jsp?rmCode=' + rmCode;
        } 
</script>
</head>
<body>
    <nav class="navbar navbar-default navbar-expand-xl navbar-light" style="align-self: center;">
	<div class="navbar-header d-flex col">
            <a class="navbar-brand" href="index.jsp"><img src="${pageContext.request.contextPath}/images/logo.jpg" width="200" height="80"> </a>  <br/>	
            
		<button type="button" data-target="#navbarCollapse" data-toggle="collapse" class="navbar-toggle navbar-toggler ml-auto">
			<span class="navbar-toggler-icon"></span>
			<span class="icon-bar"></span>
			<span class="icon-bar"></span>
			<span class="icon-bar"></span>
		</button>
	</div> 
	<!-- Collection of nav links, forms, and other content for toggling -->
        <h1 style="align-self: center;"> Account Planning </h1> 
        <div  style="position:relative; margin:0 auto;clear:left;height:auto;z-index: 999; text-align:center;">
             <div class="dropdown">
                 <a href="${pageContext.request.contextPath}/index.jsp">
                 <button class="dropbtn">Home</button>
                 </a>
                      <div class="dropdown-content">
                            </div>
                  </div>    
            <div class="dropdown">
                 <button class="dropbtn">Client Master</button>
                      <div class="dropdown-content">
                          <a href="${pageContext.request.contextPath}/client/clientinfo.jsp" onClick=" return dopostClientInfoDriver();">Client Information</a>
                          <a href="${pageContext.request.contextPath}/client/companyinfo.jsp" onClick=" return dopostCompanyInfoDriver();">Company Information</a>
                          <a href="${pageContext.request.contextPath}/client/accountrevenueinfo.jsp" onClick=" return dopostAccountRevenueDriver();">Account Revenue Information</a>
                          <a href="${pageContext.request.contextPath}/client/creditinfo.jsp" onClick=" return dopostCreditInfoDriver();">Credit Information</a>
                          <a href="${pageContext.request.contextPath}/client/creditfinacial.jsp" onClick=" return dopostCreditFinancialDriver();">Client Financials</a>
                      </div>
                  </div>
             <div class="dropdown">
                 <button class="dropbtn">Value Chain Business</button>
                      <div class="dropdown-content">
                        <a href="${pageContext.request.contextPath}/valuechain/clientemployee.jsp">Client Employees</a>
                        <a href="${pageContext.request.contextPath}/valuechain/keydistributor.jsp">Client Key Distributors</a>
                        <a href="${pageContext.request.contextPath}/valuechain/keysupplier.jsp">Client Key Suppliers</a> 
                      </div>
                  </div>
             <div class="dropdown">
                 <button class="dropbtn">Qualitative Information</button>
                      <div class="dropdown-content">
                        <a href="${pageContext.request.contextPath}/qualitativeinformation/qualitativeinfo.jsp">Qualitative Information</a>
                        <a href="${pageContext.request.contextPath}/qualitativeinformation/competition.jsp">Competition</a>
                        <a href="${pageContext.request.contextPath}/qualitativeinformation/dealsinprogress.jsp">Deals In Progress</a> 
                        <a href="${pageContext.request.contextPath}/qualitativeinformation/clientcoverage.jsp">Client Coverage Profile And Meeting History</a> 
                        <a href="${pageContext.request.contextPath}/qualitativeinformation/salesactionplan.jsp">Sales Action Plan</a>
                      </div>
                  </div>
             <div class="dropdown">
                 <button class="dropbtn">Wallet Resizing</button>
                      <div class="dropdown-content">
                        <a href="${pageContext.request.contextPath}/walletresizing/overallclientwalletsize.jsp">Overall Client wallet size</a>
                        <a href="${pageContext.request.contextPath}/walletresizing/currentandfutureopportunities.jsp">Current and Future Opportunities</a> 
                      </div>
                  </div>
             <div class="dropdown">
                 <button class="dropbtn">Reports</button>
                      <div class="dropdown-content">
                        <a href="#">Reports</a>  
                      </div>
                  </div>
              </div>
        <div style="display: flex; justify-content: flex-end;position: fixed; top: 20px; left: 20px;">
             <div style="margin-left:1080; margin-right:0;float: right !important;">
                          <%
                String user_name = "Null";
                String user_code = "0";
                String user_branch = "Null";
                String user_region = "Null";
                String user_access_level = "";
                user_name = (String) session.getAttribute("name");
                user_code = (String) session.getAttribute("code");
                user_branch = (String) session.getAttribute("branch");
                user_region = (String) session.getAttribute("region");
                user_access_level = (String) session.getAttribute("accessLevel");
            %>

            Welcome, <%=user_name%>  <br />  
            Relationship Officer Code : <%=user_code%>  <br /> 
            Branch : <%=user_branch%>  <br /> 
            Region : <%=user_region%> 
            <button class="btn btn-primary" data-toggle="modal" data-target=".bs-example-modal-sm">Logout</button>
             </div>
             
        </div>
</nav>
    