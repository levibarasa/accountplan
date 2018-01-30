<%@ include file="include/header.jsp" %>

  <br/> <br/><br/>
    
    <div class="container">
  <div class="row">
      <div class="col-xs-3">
         <a href="${pageContext.request.contextPath}/valuechain/clientemployee.jsp">  <div class="square" style="background-image: url('images/clien.png')"></div></a>
           <caption> Client Master</caption>
      </div>

      <div class="col-xs-3">
          <a href="${pageContext.request.contextPath}/client/companyinfo.jsp"> <div class="square" style="background-image: url('images/compan.jpg')"></div></a>
           <caption> Company Master</caption>
      </div>
      <div class="col-xs-3">
          <a href="${pageContext.request.contextPath}/valuechain/keydistributor.jsp"> <div class="square" style="background-image: url('images/distributor.jpg')"></div></a>
           <caption> Distributor Master</caption>
      </div>
      <div class="col-xs-3">
          <a href="${pageContext.request.contextPath}/valuechain/keysupplier.jsp"> <div class="square" style="background-image: url('images/supplier.jpg')"></div></a>
           <caption> Supplier Master</caption>
      </div>
  </div>
</div>  
    <div class="modal bs-example-modal-sm" tabindex="-1" role="dialog" aria-hidden="true">
  <div class="modal-dialog modal-sm">
    <div class="modal-content">
      <div class="modal-header"><h4>Logout <i class="fa fa-lock"></i></h4></div>
      <div class="modal-body"><i class="fa fa-question-circle"></i> Are you sure you want to log-off?</div>
      <div class="modal-footer"><a href="${pageContext.request.contextPath}/index.jsp" class="btn btn-primary btn-block">Logout</a></div>
    </div>
  </div>
</div>
    
    <%@ include file="include/footer.jsp" %> 
                                		                            