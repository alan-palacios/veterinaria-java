<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<link href="${pageContext.request.contextPath}/css/navbar.css" rel="stylesheet"></link>
<nav>
    <div class="links">
        <a href="${pageContext.request.contextPath}/index.jsp">Inicio</a>
        <c:choose>
            <c:when test="${propietario != null}">
                <form
                    action="${pageContext.request.contextPath}/MascotasServlet"
                    method="POST"
                    class="m-0"
                >
                    <input
                        type="text"
                        name="method"
                        value="mascotasPropietario"
                        hidden
                    />
                    <input
                        type="text"
                        name="idPropietario"
                        value="${propietario.idPropietario}"
                        hidden
                    />
                    <input type="submit" value="Mascotas" class="nav-item" />
                </form>
                <form
                    action="${pageContext.request.contextPath}/PropietariosServlet"
                    method="POST"
                    class="m-0"
                >
                    <input
                        type="text"
                        name="method"
                        value="leer"
                        hidden
                    />
                    <input
                        type="text"
                        name="id"
                        value="${propietario.idPropietario}"
                        hidden
                    />
                    <input type="image" src="${pageContext.request.contextPath}/assets/account-icon.png" alt="user" />
                </form>
            </c:when>
            <c:otherwise>
                <a href="${pageContext.request.contextPath}/pages/FormularioRegistro.jsp">Registrate/ Inicia Sesion</a>
            </c:otherwise>
        </c:choose>
    </div>
</nav>