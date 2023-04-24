<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:wrapper>
    <jsp:body>
        <div class="col form-container">
            <h1>Regístrate</h1>
            <p>
                Crea tu cuenta con nosotros para que puedas agendar tu cita
            </p>
            <form
                action="${pageContext.request.contextPath}/PropietariosServlet"
                method="POST"
            >
                <h3 class="subtitle">Datos Personales</h3>
                <div class="form-grid w-full">
                    <input
                        type="text"
                        name="nombre"
                        placeholder="Nombre(s) *"
                    />
                    <input
                        type="text"
                        name="appat"
                        placeholder="Apellido paterno *"
                    />
                    <input
                        type="text"
                        name="apmat"
                        placeholder="Apellido materno"
                    />
                    <input
                        type="text"
                        name="dir"
                        placeholder="Dirección *"
                    />
                </div>
                <h3 class="subtitle">Datos de acceso</h3>
                <div class="form-grid">
                    <input type="text" name="correo" placeholder="Correo *" />
                    <input type="text" name="password" placeholder="Contraseña *" />
                </div>
                <span>
                    Campos Obligatorios *
                </span>
                <div class="row">
                    <input type="submit" value="CREAR CUENTA"/>
                </div>
                <div class="row">
                    <span>¿Ya tienes una cuenta?</span>
                    <a href="login.jsp">Inicia sesión</a>
                </div>
            </form>
        </div>
    </jsp:body>
</t:wrapper>
