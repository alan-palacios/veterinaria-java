<%@tag description="Main Wrapper" pageEncoding="UTF-8"%>
<html>
  <head>
      <title>Veterinaria Saguira</title>
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      <link href="${pageContext.request.contextPath}/css/global.css" rel="stylesheet"></link>
      <link rel="icon" type="image/x-icon" sizes="16x16" href="${pageContext.request.contextPath}/assets/favicon.ico">
  </head>
  <body>
    <jsp:include page="/components/navbar.jsp"/>
    <div class="main-container">
      <jsp:doBody/>
    </div>
  </body>
</html>