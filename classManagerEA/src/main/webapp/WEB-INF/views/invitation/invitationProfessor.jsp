<%@include file="../pageCommons/include.jsp"%>

<div class="col-sm-9 col-md-9 col-lg-10">
	<br>
	<div class="panel panel-default">
		<div class="panel-heading">
			<h3 class="panel-title">
				<spring:message code="message.invitation.operation" />
			</h3>
		</div>
		<div class="panel-body">
			<ul>
				<li><a href="./sendInvitation"><spring:message
							code="message.invitation.professorOperation1" /></a></li>
				<li><a href="./checkInvitations"><spring:message
							code="message.invitation.professorOperation2" /></a></li>
			</ul>
		</div>
	</div>
</div>
