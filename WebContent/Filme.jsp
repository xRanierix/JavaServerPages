<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Filme</title>
</head>
<body>
	<h1>Filme id: ${filme.id}</h1><br>
	<p><strong>Título: </strong>${filme.titulo}</p><br>
	<p><strong>Descrição: </strong>${filme.descricao}</p><br>
	<p><strong>Popularidade: </strong>${filme.popularidade}</p><br>
	<p><strong>Diretor: </strong>${filme.diretor}</p><br>
	<p><strong>Gênero: </strong>${filme.genero.nome}</p><br>
	<p><img src="${filme.posterPath}"/><br>
</body>
</html>