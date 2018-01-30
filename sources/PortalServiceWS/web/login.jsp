<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Experimente o Spring Security 3!</title>
        <link rel="stylesheet" href="estilo2.css" type="text/css" media="all" charset="utf-8"/>
    </head>
    <body>
        <c:if test="${param.error eq 'invalido'}">
            <p>
                <span style="color:#404040">
                    Usuário ou Senha incorretos!
                </span>
            </p>
        </c:if>
        <h1>Bem vindo ao Sistema!</h1>
        <h2>Experimente o Spring Security 3 para acessar sua aplicação</h2>
        <div id="box1">
            <div class="box2">
                <form action="j_spring_security_check" method="post">
                    <div title="Efetue o Login" id="loginform" class="form">
                        <label for="user_login">Email:</label>
                        <input type="text" name="j_username" id="user_login" value="${not empty login_error ? SPRING_SECURITY_LAST_USERNAME : ''}" size="30" value="" class="setup">
                        <label for="user_password">Senha:</label>
                        <input type="password" name="j_password" id="user_password" size="30" class="setup">
                        <p>
                            <input type="submit" class="login" value="Login"
                                   style="vertical-align:middle; margin-right:10px"/>
                    </div>
                </form>
                <h3>Ou, Entre com Sua Conta do OpenID</h3>
                <form action="j_spring_openid_security_check" method="post">
                    <label for="openid_identifier">Login</label>
                    <input id="openid_identifier" name="openid_identifier" class="setup" size="20" maxlength="100" type="text"/>
                    <br/>
                    <input type="submit" class="login" value="Login"/>
                </form>
                <p>
                    <a href="index.jsp">Retornar para a Página Inicial</a>
                </p>
            </div>
        </div>
    </body>
</html>
