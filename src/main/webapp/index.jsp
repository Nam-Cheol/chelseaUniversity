<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:choose>
<c:when test="${param.role eq 'student'}">
<%@ include file="/WEB-INF/views/home/studentHeader.jsp" %>
</c:when>
<c:when test="${param.role eq 'professor'}">
<%@ include file="/WEB-INF/views/home/professorHeader.jsp" %>
</c:when>
<c:otherwise>
<%@ include file="/WEB-INF/views/home/staffHeader.jsp" %>
</c:otherwise>
</c:choose>
<h2>${principal.name}</h2>
</body>
</html>