<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
<head>
	<title>Spring 3 MVC - Contact Manager</title>
	<script type="text/javascript"
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.7/jquery.min.js"></script>
	<script type="text/javascript" src="resources/myscript.js"></script>	
</head>
<body>

	<h2>Contact Manager</h2>

	<form:form id="form" action="add.html" method="post" modelAttribute="contact">

		<spring:bind path="*">
			<c:if test="${status.error}">
				<div id="message" class="error">Form has errors</div>
			</c:if>
		</spring:bind>
		<form:errors path="*" />
		
		<table>
			<tr>
				<td><form:label path="firstName">
						<spring:message code="label.firstname" /><form:errors path="firstName" />
					</form:label></td>
				<td><form:input path="firstName" /></td>
			</tr>
			<tr>
				<td><form:label path="lastName">
						<spring:message code="label.lastname" /><form:errors path="lastName" />
					</form:label></td>
				<td><form:input path="lastName" /></td>
			</tr>
			<tr>
				<td><form:label path="email">
						<spring:message code="label.email" /><form:errors path="email" />
					</form:label></td>
				<td><form:input path="email" /></td>
			</tr>
			<tr>
				<td><form:label path="telephone">
						<spring:message code="label.telephone" /><form:errors path="telephone" />
					</form:label></td>
				<td><form:input path="telephone" /></td>
			</tr>
<%-- 			<tr>
				<td><label for="addresses[0].address"> <spring:message
							code="label.contactaddress" />
				</label></td>
				<td><input type="text" name="addresses[0].address" /><input
					type="hidden" name="addresses[0].addressType" value="BUSINESS" /></td>
			</tr> --%>
			<tr>
				<td>
					<form:label path="addresses[0].address">
						<spring:message	code="label.contactaddress" />
					</form:label>					
				</td>
				<td>
					<form:input path="addresses[0].address"/>
				</td>
				<td>
					<form:select path="addresses[0].addressType">
						<form:option selected="selected" value="HOME" >Home</form:option>
						<form:option value="BUSINESS">Business</form:option>												
					</form:select>
				</td>
			</tr>
			

			<tr class="input_fields_wrap">
			</tr>
			
			<tr>
				<td>
					<button class="add_field_button">Add More Fields</button>
				</td>
			</tr>

			<tr>
				<td colspan="2"><input type="submit"
					value="<spring:message code="label.addcontact"/>" /></td>
			</tr>
		</table>
	</form:form>


	<h3>Contacts</h3>

	<c:if test="${!empty contacts}">
		<table class="data">
			<tr>
				<th>Name</th>
				<th>Email</th>
				<th>Telephone</th>
				<th>Address</th>
				<!-- <th>Type</th> -->
				<th>&nbsp;</th>
			</tr>

			<c:forEach items="${contacts}" var="contact">

				<tr>
					<td>${contact.lastName},${contact.firstName}</td>
					<td>${contact.email}</td>
					<td>${contact.telephone}</td>
					<c:choose>
						<c:when test="${empty contact.addresses}">
							<td>&nbsp;</td>
						</c:when>
						<c:otherwise>
							<td><c:forEach items="${contact.addresses}" var="contactAddress"
								varStatus="itr">
								${contactAddress.addressType}: ${contactAddress.address}
							</c:forEach></td>
							
						</c:otherwise>
					</c:choose>					
					<%-- <td><a href="delete/${contact.uuid}">delete</a></td> --%>
					<td><a href="delete/${contact.id}">delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>

</body>
</html>