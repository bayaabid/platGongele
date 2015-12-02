<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="../layout/taglib.jsp" %>
<style>
.admin-bar{
background-color: #b2b2b2;
}
</style>
<div class="container">
      
	        	<table class="table table-bordered table-hover table-striped">
					<thead>
						<tr>
							<th>User name</th>
							<th>Delete user</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${users}" var="user">
							<tr>
								<td>
									<a href='<spring:url value="/users/${user.idUser}.html"/>' >
										${user.userName}
									</a>
								</td>
								<td>
									<a href='<spring:url value="/users/remove/${user.idUser}.html"/>' class="btn btn-danger triggerRemove">
										remove
									</a>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
		<script type="text/javascript">
			$(document).ready(function() {
				$('.nav-tabs a:first').tab('show'); // Select first tab
				$('.triggerRemove').click(function(e){
					e.preventDefault();
					$('#modalRemove .removeBtn').attr("href",$(this).attr("href"));
					$('#modalRemove').modal();//mettre visible le modal(show)
				});
			});
	</script>	
			<!-- Modal -->
<div class="modal fade" id="modalRemove" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">Remove user</h4>
      </div>
      <div class="modal-body">
        Really remove!!
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
       <a href="" class="btn btn-danger removeBtn"> remove</a>
      </div>
    </div>
  </div>
</div>
			
			
</div>
	  
    

