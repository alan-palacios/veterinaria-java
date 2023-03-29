<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:wrapper>
    <jsp:body>
        <h1>Agenda tu cita con nosotros</h1>
        <form action="citas" method="POST">
            <table>
                <tr>
                    <td>Nombre:</td>
                    <td><input type="text" name="nombre" /></td>
                </tr>
                <tr>
                    <td>Apellido:</td>
                    <td><input type="text" name="apellido" /></td>
                </tr>
                <tr>
                    <td>Fecha:</td>
                    <td><input type="date" name="fecha" /></td>
                </tr>
                <tr>
                    <td>Hora:</td>
                    <td><input type="time" name="hora" /></td>
                </tr>
                <tr>
                    <td>Telefono:</td>
                    <td><input type="text" name="telefono" /></td>
                </tr>
                <tr>
                    <td>Correo:</td>
                    <td><input type="text" name="correo" /></td>
                </tr>
                <tr>
                    <td>Descripcion:</td>
                    <td><input type="text" name="descripcion" /></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Agendar" /></td>
                </tr>
            </table>
        </form>
    </jsp:body>
</t:wrapper>
