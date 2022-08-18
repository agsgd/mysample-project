<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<div class="container">

	<div class="row">

		<c:if test="${not empty message }">

			<div class="col-xs-12">

				<div class="alert alert-success alert-dismissible">

					<button type="button" class="close" data-dismiss="alert">&times;</button>

					${message}

				</div>

			</div>


		</c:if>





		<div class="col-md-offset-2 col-md-8">

			<div class="panel panel-primary">

				<div class="panel-heading">
					<h4>Product Management</h4>
				</div>

				<div class="panel-boby">

					<!-- FORM ELEMENTS -->

					<sf:form class="form-horizontal" modelAttribute="product"
						action="${contextRoot}/manage/products" method="POST"
						enctype="multipart/form-data">

						<div class="form-group">

							<label class="control-label col-md-4" for="name">Enter
								Product Name:</label>

							<div class="col-md-8">

								<sf:input type="text" path="name" id="name"
									placeholder="Product Name" class="form-control" />
								<sf:errors path="name" cssClass="help-block" element="em" />


							</div>
						</div>


						<div class="form-group">

							<label class="control-label col-md-4" for="brand">Enter
								Brand Name:</label>

							<div class="col-md-8">

								<sf:input type="text" path="brand" id="brand"
									placeholder="Brand Name" class="form-control" />
								<sf:errors path="brand" cssClass="help-block" element="em" />


							</div>
						</div>


						<div class="form-group">

							<label class="control-label col-md-4" for="description">Product
								Description</label>
							<div class="col-md-8">

								<sf:textarea path="description" id="description" rows="4"
									placeholder="write a Description" class="form-control"></sf:textarea>
								<sf:errors path="description" cssClass="help-block" element="em" />

							</div>
						</div>

						<div class="form-group">

							<label class="control-label col-md-4" for="unitPrice">Enter
								Unit Price:</label>

							<div class="col-md-8">

								<sf:input type="number" path="unitPrice" id="unitPrice"
									placeholder="unit Price in &#8377;" class="form-control" />
								<sf:errors path="unitPrice" cssClass="help-block" element="em" />


							</div>
						</div>

						<div class="form-group">

							<label class="control-label col-md-4" for="quantity">Quantity
								Available:</label>

							<div class="col-md-8">

								<sf:input type="number" path="quantity" id="quantity"
									placeholder="Quantity Available" class="form-control" />

							</div>
						</div>


						<div class="form-group">

							<label class="control-label col-md-4" for="quantity">Select
								an Image:</label>

							<div class="col-md-8">

								<sf:input type="file" path="file" id="file" class="form-control" />
								<sf:errors path="file" cssClass="help-block" element="em" />

							</div>
						</div>


						<div class="form-group">

							<label class="control-label col-md-4" for="categoryId">Select
								Category:</label>
							<div class="col-md-8">

								<sf:select class="form-control" path="categoryId"
									id="categoryId" items="${categories}" itemLabel="name"
									itemValue="id" />

								<c:if test="${product.id==0}">
									<div class="text-right">
										<br />
										<button type="button" data-toggle="model"
											data-target="#myCategoryModel" class="btn btn-warning btn-xs">Add
											Category</button>
									</div>
								</c:if>
							</div>
						</div>

						<div class="form-group">
							<div class="col-md-offset-4 col-md-8">

								<input type="submit" name="submit" id="submit" value="Sumbit"
									class="btn btn-primary" />

								<!-- Hidden fields for products -->

								<sf:hidden path="id" />
								<sf:hidden path="code" />
								<sf:hidden path="supplierId" />
								<sf:hidden path="purchases" />
								<sf:hidden path="views" />
								<sf:hidden path="active" />
							</div>
						</div>
					</sf:form>
				</div>
			</div>
		</div>
	</div>


	<div class="row">

		<div class="col-xs-12">
			<h3>Available Products</h3>
			<hr />


		</div>

		<div class="col-xs-12">
			<div class="container-fluid">

				<div class="table-responsive">


					<!-- Product table  for Admin -->

					<table id="adminProductsTable"
						class="table table-striped table-bordered">


						<thead>
							<tr>
								<th>Id</th>
								<th>&#160;</th>
								<th>Brand</th>
								<th>Name</th>
								<th>Quantity</th>
								<th>Unit Price</th>
								<th>Active</th>
								<th>Edit</th>
							</tr>
						</thead>




						<tfoot>
							<tr>
								<th>Id</th>
								<th>&#160;</th>
								<th>Brand</th>
								<th>Name</th>
								<th>Quantity</th>
								<th>Unit Price</th>
								<th>Active</th>
								<th>Edit</th>
							</tr>
						</tfoot>
					</table>



				</div>




			</div>




		</div>

	</div>




	<div class="row">
		<div class="modal fade" id="myCategoryModal" role="dialog"
			tabindex="-1">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">
							<span>&times;</span>
						</button>
						<h4 class="modal-title">Add New Category</h4>
					</div>

					<div class="modal-body">

						<!-- category form -->



					</div>



				</div>
			</div>
		</div>
	</div>






</div>