<%--
- form.jsp
-
- Copyright (C) 2012-2025 Rafael Corchuelo.
-
- In keeping with the traditional purpose of furthering education and research, it is
- the policy of the copyright owner to permit non-commercial use and redistribution of
- this software. It has been tested carefully, but it is not guaranteed for any particular
- purposes.  The copyright owner does not offer any warranties or representations, nor do
- they accept any liabilities with respect to them.
--%>

<%@page%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="http://acme-framework.org/"%>

<acme:form>
	<acme:input-textbox code="manager.flight.form.label.tag" path="tag" readonly="true" />
	<acme:input-textbox code="manager.flight.form.label.requiresSelfTransfer" path="requiresSelfTransfer" readonly="true" />
	<acme:input-textbox code="manager.flight.form.label.cost" path="cost" readonly="true" />
	<acme:input-textbox code="manager.flight.form.label.description" path="description" readonly="true" />
	<acme:input-textbox code="manager.flight.form.label.scheduledDeparture" path="scheduledDeparture" readonly="true" />
	<acme:input-textbox code="manager.flight.form.label.scheduledArrival" path="scheduledArrival" readonly="true" />
	<acme:input-textbox code="manager.flight.form.label.originCity" path="originCity" readonly="true" />
	<acme:input-textbox code="manager.flight.form.label.destinationCity" path="destinationCity" readonly="true" />
	<acme:input-textbox code="manager.flight.form.label.layovers" path="layovers" readonly="true" />

</acme:form>

