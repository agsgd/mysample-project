<%@include file="../shared/flows-header.jsp"%>
<%@taglib prefix="sf"  uri="http://www.springframework.org/tags/form" %>


<div class="container">
	<div class="col-md-offset-2 col-md-8">

		<div class="panel panel-primary">

			<div class="panel-heading">
				<h4>Sign up- Address</h4>
			</div>

			<div class="panel-boby">

				<!-- FORM ELEMENTS -->

				<sf:form class="form-horizontal" method="POST" id="billingForm"
					modelAttribute="billing">

					<div class="form-group">
						<label class="control-label col-md-4" for="addressLineOne">Address Line One:</label>
						<div class="col-md-8">
							<sf:input type="text" path="addressLineOne" placeholder="Enter Address Line one"
								class="form-control" />
							<sf:errors path="addressLineOne" cssClass="help-block" element="em" />
						</div>
					</div>


					<div class="form-group">
						<label class="control-label col-md-4" for="addreddLineTwo">Address Line Two:</label>
						<div class="col-md-8">
							<sf:input type="text" path="addreddLineTwo" id="addreddLineTwo"
								placeholder="Enter Address Line Two" class="form-control" />
							<sf:errors path="addreddLineTwo" cssClass="help-block" element="em" />
						</div>
					</div>


					<div class="form-group">
						<label class="control-label col-md-4" for="city">City</label>
						<div class="col-md-8">
							<sf:input type="text" path="city" id="city" placeholder="Enter City Name"
								class="form-control" />
							<sf:errors path="city" cssClass="help-block" element="em" />
						</div>
					</div>

					<div class="form-group">
						<label class="control-label col-md-4" for="postalcode">Postal Code:</label>
						<div class="col-md-8">
							<sf:input type="text" path="postalcode" id="postalcode"
								placeholder="Enter Postal Code" class="form-control" />
							<sf:errors path="postalcode" cssClass="help-block"
								element="em" />
						</div>
					</div>

					<div class="form-group">
						<label class="control-label col-md-4" for="state">State:</label>
						<div class="col-md-8">
							<sf:input type="text" path="state" id="state"
								placeholder="Enter State Name" class="form-control" />
								<sf:errors path="state" cssClass="help-block"
								element="em" />
						</div>
					</div>

					<div class="form-group">
						<label class="control-label col-md-4" for="country">Country:</label>
						<div class="col-md-8">
							<sf:input type="text" path="country" id="country"
								placeholder="Enter country Name" class="form-control" />
								<sf:errors path="country" cssClass="help-block"
								element="em" />
						</div>
					</div>

					<div class="form-group">
						<div class="col-md-offset-4 col-md-8">
							<!-- Submit button for moving to the personal -->
							<button type="submit" class="btn btn-primary"
								name="_eventId_personal">

								<span class="glyphicon glyphicon-chevron-left"></span>Previous - Personal 

							</button>
							
								<!-- Submit button for moving to the confirm -->
							<button type="submit" class="btn btn-primary"
								name="_eventId_confirm">

								Next - Confirm <span class="glyphicon glyphicon-chevron-right"></span>

							</button>
							

						</div>
					</div>
				</sf:form>
			</div>
		</div>
	</div>



</div>
<%@include file="../shared/flows-footer.jsp"%>
