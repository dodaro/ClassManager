<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
				<h3>Users List</h3>
				<form class="form-inline" action="searchusers" method="GET" role="form">
				  <div class="form-group">
				    <label for="lastname"><spring:message code="message.lastName" text="default text"/></label>
				    <input type="text"  class="form-control" name="query" placeholder="Rossi"/>
				    	<label for="select"><spring:message code="message.usersperpage" text="default text"/></label>
						  <select class="form-control" name="users">
						  	<c:if test="${not empty pageSize}">
						  		<option selected="selected">${pageSize}</option>
						  	</c:if>
						    <option>10</option>
						    <option>25</option>
						    <option>50</option>
						    <option>100</option>
						  </select>
				  	<button type="submit" class="btn btn-default">Search</button>
				    	<c:if test="${not empty error}" >
				    		<span class="help-block"><spring:message code="searchField.length.error" text="default text"/></span>
					    	<script>$(".form-group").addClass("has-error")</script>
				    	</c:if>
				  </div>
				    
				</form>
				
				<table class="table table-striped table-bordered">
					<thead>
					      <tr>
					        <th>User
					        	<a href="sort?prop=username">
					        	<c:choose>
					        		<c:when test="${prop == 'username' && asc == true }">
						        		<i class="sort fa fa-sort-asc"></i>
					        		</c:when>
					        		<c:when test="${prop == 'username' && asc != true }">
						        		<i class="sort fa fa-sort-desc"></i>
						        	</c:when>
						        	<c:otherwise>
						        		<i class="sort fa fa-sort"></i>
						        	</c:otherwise>
					        	</c:choose>
					        		
					        	</a>
					        </th>
					        <th>
					        	<spring:message code="message.firstName" text="default text" /> 
					        	<a href="sort?prop=firstName">
						        	<c:choose>
						        		<c:when test="${prop == 'firstName' && asc == true }">
							        		<i class="sort fa fa-sort-asc"></i>
						        		</c:when>
						        		<c:when test="${prop == 'firstName' && asc != true }">
							        		<i class="sort fa fa-sort-desc"></i>
							        	</c:when>
							        	<c:otherwise>
							        		<i class="sort fa fa-sort"></i>
							        	</c:otherwise>
						        	</c:choose>
					        	</a>
					        </th>
					        <th>
					        	<spring:message code="message.lastName" text="default text" /> 
					        	<a href="sort?prop=lastName">
					        		<c:choose>
					        		<c:when test="${prop == 'lastName' && asc == true }">
						        		<i class="sort fa fa-sort-asc"></i>
					        		</c:when>
					        		<c:when test="${prop == 'lastName' && asc != true }">
						        		<i class="sort fa fa-sort-desc"></i>
						        	</c:when>
						        	<c:otherwise>
						        		<i class="sort fa fa-sort"></i>
						        	</c:otherwise>
					        	</c:choose>
					        	</a>
					        </th>
					        <th>Role
					        	<a href="sort?prop=role">
					        		<c:choose>
					        		<c:when test="${prop == 'role' && asc == true }">
						        		<i class="sort fa fa-sort-asc"></i>
					        		</c:when>
					        		<c:when test="${prop == 'role' && asc != true }">
						        		<i class="sort fa fa-sort-desc"></i>
						        	</c:when>
						        	<c:otherwise>
						        		<i class="sort fa fa-sort"></i>
						        	</c:otherwise>
					        	</c:choose>
					        	</a>
					        </th>
					        <th>Action</th>
					      </tr>
    				</thead>
    				<tbody>
    					<c:forEach var="user" items="${users.getPageList()}">
    						
							<tr>
								<td class="user">${user.username}</td>
								<td class="firstname">${user.firstName}</td>
								<td class="lastname">${user.lastName}</td>
								<td class="role">${user.role}</td>
								
								<td>
								<c:if test="${user.username != loggedIn }">
									<button type="submit" class="btn btn-danger"><spring:message code="message.delete" text="default text"/></button>
								</c:if>
								<c:if test="${user.role == 'Student'}">
									<button type="submit" class="btn btn-success"><spring:message code="message.professor" text="default text"/></button>
								</c:if>
								</td>
							</tr>
						</c:forEach>
    				</tbody>
				</table>
				<form id="options">
					<input name="total-pages" type="hidden" value="${pageCount}"/> 
					<input name="page-number" type="hidden" value="${pageNumber}"/> 
				</form>
				<div id="paginator">
				</div>
