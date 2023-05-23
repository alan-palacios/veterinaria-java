<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<t:wrapper>
    <jsp:body>
        <h1>Mascotas</h1>
        <div class="row space-x-5 items-start">
            <div class="form-container">
                <h1>Agrega una Mascota</h1>
                <form
                    action="${pageContext.request.contextPath}/MascotasServlet"
                    method="POST"
                >
                    <input
                        type="text"
                        name="method"
                        value="registrar"
                        hidden
                    />
                    <input
                        type="text"
                        name="idPropietario"
                        value="${propietario.idPropietario}"
                        hidden
                    />
                    <div class="col space-y-4">
                        <input
                            type="text"
                            name="nombre"
                            value=""
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
                                <option value="Macho">Macho</option>
                                <option value="Hembra">Hembra</option>
                            </select>
                        </div>
                        <div class="col">
                            <label for="nacimiento">Fecha de Nacimiento</label>
                            <input type="date" name="nacimiento" id="nacimiento" />
                        </div>
                        <!-- 
                        <div>
                            <label for="imagen">Imagen:</label>
                            <input type="file" name="imagen" id="imagen" />
                        </div>
                        -->
                        <input type="submit" value="Agregar Mascota" class="btn-primary" />
                    </div>
                </form>
            </div>
            <div>
                <h1>Mis Mascotas</h1>
                <p>Tienes ${mascotas.size()} mascotas registradas</p>
                <div class="col space-y-4 mascotas-container">
                    <c:forEach items="${mascotas}" var="mascota">
                        <div class="mascota-card">
                            <h3>${mascota.nombre}</h3>
                            <span>${mascota.sexo}</span>
                            <span>${mascota.nacimiento}</span>
                            <form
                                action="${pageContext.request.contextPath}/MascotasServlet"
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
                                    value="${mascota.idMascota}"
                                    hidden
                                />
                                <input type="submit" value="BORRAR" class="button btn-error"/>
                            </form>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </div>
    </jsp:body>
</t:wrapper>