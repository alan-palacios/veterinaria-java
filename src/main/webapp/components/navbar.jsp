<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<link href="${pageContext.request.contextPath}/css/navbar.css" rel="stylesheet"></link>
<nav>
    <div class="links">
        <a href="${pageContext.request.contextPath}/index.jsp">Inicio</a>
        <c:choose>
            <c:when test="${propietario != null}">
                <a href="${pageContext.request.contextPath}/pages/formularioMascota.jsp">Agregar Mascota</a>
                <a href="${pageContext.request.contextPath}/leerPropietario?id=${propietario.idPropietario}">
                    <img src="${pageContext.request.contextPath}/assets/account-icon.png" alt="user" />
                </a>
            </c:when>
            <c:otherwise>
                <a href="${pageContext.request.contextPath}/pages/FormularioRegistro.jsp">Registrate/ Inicia Sesion</a>
            </c:otherwise>
        </c:choose>
    </div>
</nav>