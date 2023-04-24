<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:wrapper>
    <jsp:body>
        <div class="col form-container">
            <h1>Iniciar Sesión</h1>
            <p>
                Ingresa para poder agendar tu cita
            </p>
            <form
                action="${pageContext.request.contextPath}/LoginServlet"
                method="POST"
            >
                <div class="col space-y-4">
                    <input type="text" name="correo" placeholder="Correo *" />
                    <input type="text" name="password" placeholder="Contraseña *" />
                </div>
                <div class="row">
                    <input type="submit" value="INICIAR SESIÓN"/>
                </div>
                <div class="row">
                    <span>¿No tienes una cuenta?</span>
                    <a href="FormularioRegistro.jsp">Regístrate aquí</a>
                </div>
            </form>
        </div>
    </jsp:body>
</t:wrapper>
