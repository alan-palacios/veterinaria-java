<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:wrapper>
    <jsp:body>
        <div class="form-container">
            <h1>Agrega una Mascota</h1>
            <form action="mascotas" method="POST">
                <div>
                    <h2>Mascota</h2> 
                    <div>
                        <label for="nombre">Nombre:</label>
                        <input type="text" name="nombre" id="nombre" /> 
                    </div>
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
                    <div>
                        <label for="sexo">Sexo:</label>
                        <select name="sexo" id="sexo">
                            <option value="Macho">Macho</option>
                            <option value="Hembra">Hembra</option>
                        </select>
                    </div>
                    <div>
                        <label for="nacimiento">Fecha de Nacimiento</label>
                        <input type="date" name="nacimiento" id="nacimiento" />
                    </div>
                    <div>
                        <label for="imagen">Imagen:</label>
                        <input type="file" name="imagen" id="imagen" />
                    </div>
                </div>
                <input type="submit" value="Agregar Mascota" class="btn-primary" />
            </form>
        </div>
    </jsp:body>
</t:wrapper>

