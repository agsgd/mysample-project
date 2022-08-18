<%@include file="../shared/flows-header.jsp"%>
<%@taglib prefix="sf"  uri="http://www.springframework.org/tags/form" %>
<div class="container">

	<div class="col-md-offset-2 col-md-8">

			<div class="panel panel-primary">

				<div class="panel-heading">
					<h4>Sign up- Personal</h4>
				</div>

				<div class="panel-boby">

					<!-- FORM ELEMENTS -->

					<sf:form class="form-horizontal" 
						 method="POST"
						 id="registerForm"
						 modelAttribute="user">

						<div class="form-group">
							<label class="control-label col-md-4" >First Name:</label>
							<div class="col-md-8">
								<sf:input type="text" path="firstName" 
									placeholder="firstName" class="form-control" />
								<sf:errors path="firstName" cssClass="help-block" element="em" />
							</div>
						</div>


						<div class="form-group">

							<label class="control-label col-md-4">Last Name:</label>
							<div class="col-md-8">
								<sf:input type="text" path="lastName" id="lastName"
									placeholder="lastName" class="form-control" />
								<sf:errors path="lastName" cssClass="help-block" element="em" />
							</div>
						</div>


						<div class="form-group">
							<label class="control-label col-md-4" >Email</label>
							<div class="col-md-8">
								<sf:input type="text" path="email" id="email" 
									placeholder="email" class="form-control"/>
								<sf:errors path="email" cssClass="help-block" element="em" />
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-4" >Enter Phone Number:</label>
							<div class="col-md-8">
								<sf:input type="text" path="contactNumber" id="contactNumber"
									placeholder="Enter contact Number" class="form-control" />
								<sf:errors path="contactNumber" cssClass="help-block" element="em" />
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-4" >Password:</label>
							<div class="col-md-8">
								<sf:input type="password" path="password" id="password"
									placeholder="password" class="form-control" />
									
								<sf:errors path="password" cssClass="help-block" element="em" />	
							</div>
						</div>
						
						<div class="form-group">
							<label class="control-label col-md-4" >Confirm Password:</label>
							<div class="col-md-8">
								<sf:input type="password" path="confirmPassword" id="confirmPassword"
									placeholder="confirm Password" class="form-control" />
									
								<sf:errors path="confirmPassword" cssClass="help-block" element="em" />	
							</div>
						</div>
						
						
						

						<div class="form-group">
						<label class="control-label col-md-4">Select Role</label>
							<div class="col-md-8">
                               <label class="radio-inline">
                               <sf:radiobutton path="role" value="USER" checked="checked"/>User
                               </label>
								<label class="radio-inline">
                               <sf:radiobutton path="role" value="SUPPLIER"/>Supplier
                               </label>
							</div>
						</div>

					<div class="form-group">
						<div class="col-md-offset-4 col-md-8">
						<!-- Submit button inside the form -->
						<button type="submit" class="btn btn-primary" name="_eventId_billing">
						
						Next - Billing <span class="glyphicon glyphicon-chevron-right"></span>
						
						</button>
						
						</div>
					</div>




				</sf:form>
				</div>
			</div>
		</div>


</div>
<%@include file="../shared/flows-footer.jsp"%>
