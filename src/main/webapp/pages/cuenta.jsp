<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:wrapper>
    <jsp:body>
        <h1>Bienvenid@ ${propietario.nombre}</h1>
        <div class="col form-container">
            <h1>Actualiza tus datos</h1>
            <form
                action="${pageContext.request.contextPath}/PropietariosServlet"
                method="POST"
            >
                <input
                    type="text"
                    name="method"
                    value="actualizar"
                    hidden
                />
                <h3 class="subtitle">Datos Personales</h3>
                <div class="form-grid w-full">
                    <input
                        type="text"
                        name="idPropietario"
                        value="${propietario.idPropietario}"
                        hidden
                    />
                    <input
                        type="text"
                        name="nombre"
                        value="${propietario.nombre}"
                        placeholder="Nombre(s) *"
                    />
                    <input
                        type="text"
                        name="appat"
                        value="${propietario.appat}"
                        placeholder="Apellido paterno *"
                    />
                    <input
                        type="text"
                        name="apmat"
                        value="${propietario.apmat}"
                        placeholder="Apellido materno"
                    />
                    <input
                        type="text"
                        name="dir"
                        value="${propietario.dir}"
                        placeholder="Dirección *"
                    />
                </div>
                <span>
                    Campos Obligatorios *
                </span>
                <div class="row">
                    <input type="submit" value="ACTUALIZAR"/>
                </div>
            </form>
        </div>
        <div class="col space-y-4">
            <a href="${pageContext.request.contextPath}/pages/logout.jsp">
                <button class="button btn-info">
                    CERRAR SESIÓN
                </button>
            </a>
            <form
                action="${pageContext.request.contextPath}/PropietariosServlet"
                method="POST"
            >
                <input
                    type="text"
                    name="method"
                    value="borrar"
                    hidden
                />
                <input
                    type="text"
                    name="id"
                    value="${propietario.idPropietario}"
                    hidden
                />
                <input type="submit" value="BORRAR CUENTA" class="button btn-error"/>
            </form>
        </div>
    </jsp:body>
</t:wrapper>