<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="../layout/taglib.jsp" %>
<script type="text/javascript">
			$(document).ready(function() {
				$('.nav-tabs a:first').tab('show') // Select first tab
				$('.triggerRemove').click(function(e){
					e.preventDefault();
					$('#modalRemove .removeBtn').attr("href",$(this).attr("href"));
					$('#modalRemove').modal();//mettre visible le modal(show)
				});
			});
	</script>

<div class="container">


		<table class="table table-bordered table-hover table-striped">
					<thead>
						<tr>
							<th>Id Produit</th>
							<th>Nom produit</th>
							<th>Description</th>
							<th>Prix</th>
							<th>Quantite</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${produits}" var="produit">
							<tr>
								<td>
									${produit.idProduit}
								</td>
								<td>
									${produit.nomProduit}
								</td>
								<td>
									${produit.description}
								</td>
								<td>
									${produit.prix}
								</td>
								<td>
									${produit.quantite}
								</td>
								<td>
								<a href='<spring:url value="/users/produit/${produit.idProduit}.html"/>' 
										class="btn btn-danger triggerRemove">
										remove
								</a>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
     	
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
		
     	
   		<form:form commandName="produit" cssClass="form-horizontal" >
	     	<!-- Button trigger modal -->
				<button type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">
				  Ajouter produit
				</button>
				
				<!-- Modal -->
				<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
				  <div class="modal-dialog" role="document">
				    <div class="modal-content">
				      <div class="modal-header">
				        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
				        <h4 class="modal-title" id="myModalLabel">Detail Produit</h4>
				      </div>
				      <div class="modal-body">
					      <div class="form-group">
					    		<label for="name" class="col-sm-3 control-label">Nom :</label>
					    		<div class="col-sm-9">
					    			<form:input path="nomProduit" cssClass="form-control" placeholder="nom produit"/>
					    		</div>
					      </div> 
					      <div class="form-group">
				    	  		<label for="name" class="col-sm-3 control-label">prix :</label>
				    			<div class="col-sm-9">
				    				<form:input path="prix" cssClass="form-control" placeholder="entrer le prix"/>
				    			</div>
				    	  </div>
				    	  <div class="form-group">
				    			<label for="name" class="col-sm-3 control-label">Quantite :</label>
				    			<div class="col-sm-9">
				    				<form:input path="quantite" cssClass="form-control" placeholder="entrer la quantite"/>
				    			</div>
				    	  </div>
				    	  <div class="form-group">
					    		<label  class="col-sm-3 control-label">Categorie :</label>
					    		<div class="col-sm-9">
					    			<form:select  path="categorie.idCategorie" cssClass="form-control" items="${categories}"
					    			itemLabel="nomCategorie" itemValue="idCategorie"/>
					    			
					    		</div>
				    	  </div>
				    	  <div class="form-group">
				    			<label for="name" class="col-sm-3 control-label">Description :</label>
				    			<div class="col-sm-9">
				    				<form:input path="description" cssClass="form-control" placeholder="entrer la quantite"/>
				    			</div>
				    	  </div>   
				    	 
				      </div>
				      <div class="modal-footer">
				        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				        <input type="submit" class="btn btn-primary" value="save"/>
				      </div>
				    </div>
				  </div>
				</div>
			</form:form>
			<br><br>
			
			 <!-- Nav tabs -->
				  <ul class="nav nav-tabs" >
				    <li ><a href="#home"  data-toggle="tab">Home</a></li>
				    <li ><a href="#profile"  data-toggle="tab">Profile</a></li>
				    <li ><a href="#messages"  data-toggle="tab">Messages</a></li>
				    <li> <a href="#settings"  data-toggle="tab">Settings</a></li>
				  </ul>
				
				  <!-- Tab panes -->
				  <div class="tab-content">
				    <div  class="tab-pane" id="home">kais</div>
				    <div  class="tab-pane" id="profile">chaa</div>
				    <div  class="tab-pane" id="messages">bane</div>
				    <div  class="tab-pane" id="settings">baya</div>
				  </div>
			
</div>
    