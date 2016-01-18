<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<li><a href="/courses"><span class="glyphicon glyphicon-book"></span>Courses</a></li>

<c:if test="<%=session.getAttribute("ActiveCourse") != null%>">
	<li><a href="/lectures"><span
			class="glyphicon glyphicon-folder-open"></span>Lectures</a></li>

	<li><a href="/scores"><span
			class="glyphicon glyphicon-equalizer"></span>Scores</a></li>

	<li><a href="/students"><span class="glyphicon glyphicon-edit"></span>Homework
			Student Solving</a></li>

	<li><a href="#"><span class="glyphicon glyphicon-blackboard"></span>Blackboard</a></li>
</c:if>

<li><a href="/calendar"><span
		class="glyphicon glyphicon-calendar"></span> Calendar</a></li>

<li><a href="#"><span class="glyphicon glyphicon-comment"></span>Forum</a></li>

<li><a href="/statistics"><span
		class="glyphicon glyphicon-stats"></span> Statistics</a></li>

<li><a href="/invitation"> <span
		class="glyphicon glyphicon-gift" aria-hidden="true"></span> Invitation
		<c:if test="${not empty newInvitations}">
			<span class="badge invitationActionButton">${newInvitations}</span>
		</c:if>
</a></li>

<li><a href="/editor"><span
		class="glyphicon glyphicon-modal-window"></span>Editor</a></li>

<li><a href="/viewer3D"><span
		class="glyphicon glyphicon-eye-open"></span> Viewer3D</a></li>

<li><a href="./noticeboard?init=1"> <span
		class="glyphicon glyphicon-send"></span> <spring:message
			code="message.noticeboard" text="default text" /> con fake init
</a></li>

<li><a href="./noticeboard"> <span
		class="glyphicon glyphicon-send"></span> <spring:message
			code="message.noticeboard" text="default text" /> senza init
</a></li>

<c:if test="${not empty loggedIn && role == 'admin' }">
	<a href="/userslist"> <span class="glyphicon glyphicon-king"></span>
		Administration
	</a>
</c:if>
