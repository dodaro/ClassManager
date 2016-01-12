<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<li><a href="#"><span class="glyphicon glyphicon-home"></span>Dashboard</a></li>
<li><a href="#"><span class="glyphicon glyphicon-book"></span>Classroom</a></li>
<li><a href="#"><span class="glyphicon glyphicon-folder-open"></span>
		Materials</a></li>
<li><a href="#"><span class="glyphicon glyphicon-list"></span>Discussions</a></li>
<li><a href="./statistics"><span
		class="glyphicon glyphicon-stats"></span> Statistics</a></li>
<li><a href="./invitation"> <span
		class="glyphicon glyphicon-gift" aria-hidden="true"></span> Invitation
		<c:if test="${not empty newInvitations}">
			<span class="badge invitationActionButton">${newInvitations}</span>
		</c:if>
</a></li>
<li><a href="./viewer3D"><span
		class="glyphicon glyphicon-eye-open"></span> Viewer3D</a></li>
<li><a href="./noticeboard?init=1"> <span
		class="glyphicon glyphicon-send"></span> <spring:message
			code="message.noticeboard" text="default text" /> con fake init
</a></li>
<li><a href="./noticeboard"> <span
		class="glyphicon glyphicon-send"></span> <spring:message
			code="message.noticeboard" text="default text" /> senza init
</a></li>
<li><a href="#"> <span class="glyphicon glyphicon-send"></span>
		Apri cancello
</a></li>