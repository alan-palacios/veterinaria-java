<%@tag description="Main Wrapper" pageEncoding="UTF-8"%>
<html>
  <head>
      <title>Veterinaria</title>
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      <link href="${pageContext.request.contextPath}/css/global.css" rel="stylesheet"></link>
  </head>
  <body>
    <jsp:include page="/components/navbar.jsp"/>
    <div class="container">
      <jsp:doBody/>
    </div>
  </body>
</html>