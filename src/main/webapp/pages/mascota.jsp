<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<t:wrapper>
    <jsp:body>
        <h1>${mascota.nombre}</h1>
        <div class="row space-x-5 items-start">
            <div class="form-container">
                <h1>Actualizar datos</h1>
                <form
                    action="${pageContext.request.contextPath}/MascotasServlet"
                    method="POST"
                >
                    <input
                        type="text"
                        name="method"
                        value="actualizar"
                        hidden
                    />
                    <input
                        type="text"
                        name="idPropietario"
                        value="${propietario.idPropietario}"
                        hidden
                    />
                    <input
                        type="text"
                        name="idMascota"
                        value="${mascota.idMascota}"
                        hidden
                    />
                    <div class="col space-y-4">
                        <input
                            type="text"
                            name="nombre"
                            value="${mascota.nombre}"
                            placeholder="Nombre(s) *"
                        />
                        <!-- 
                        <div>
                            <label for="raza">Raza:</label>
                            <select name="raza" id="raza">
                                <c:forEach items="${razas}" var="raza">
                                    <option value="${raza.id}">${raza.nombre}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div>
                            <label for="tamaño">Tamaño (cm?):</label>
                            <input type="text" name="tamaño" id="tamaño" />
                        </div>
                        <div>
                            <label for="peso">Peso (kg?):</label>
                            <input type="text" name="peso" id="peso" />
                        </div>
                        -->
                        <div class="col">
                            <label for="sexo">Sexo:</label>
                            <select name="sexo" id="sexo">
                                <option value="Macho"
                                ${mascota.sexo == "Macho" ? 'selected' : ''}>Macho</option>
                                <option value="Hembra" 
                                 ${mascota.sexo == "Hembra" ? 'selected' : ''}>Hembra</option>
                            </select>
                        </div>
                        <div class="col">
                            <label for="nacimiento">Fecha de Nacimiento</label>
                            <input type="datetime-local" name="nacimiento" id="nacimiento"
                            value="${mascota.nacimiento}" />
                        </div>
                        <!-- 
                        <div>
                            <label for="imagen">Imagen:</label>
                            <input type="file" name="imagen" id="imagen" />
                        </div>
                        -->
                        <input type="submit" value="Actualizar" class="btn-primary" />
                    </div>
                </form>
            </div>
        </div>
    </jsp:body>
</t:wrapper>