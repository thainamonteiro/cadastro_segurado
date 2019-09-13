<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta charset="UTF-8">
<title>Cadastrar Segurado</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>
	<form action="${pageContext.request.contextPath}/seguradoControllerServlet" method="post">

		<h1>Cadastro Segurado</h1>
		<div class="form-group row">
			<div class="col-sm-10">
				<input type="text" class="form-control" name="nome"
					placeholder="Nome:" value="${param.nome}">
			</div>
		</div>

		<div class="form-group row">
			<div class="col-sm-10">
				<input type="text" class="form-control" name="cpf"
					placeholder="Cpf:" value="${param.cpf}">
			</div>
		</div>

		<div class="form-group row">
			<div class="col-sm-10">
				<input type="text" class="form-control" name="rg" placeholder="Rg:" value="${param.rg}">
			</div>
		</div>

		<div class="row">
			<legend class="col-form-label col-sm-2 pt-0">Sexo:</legend>
			<div class="col-sm-10">
				<div class="form-check">
					<input class="form-check-input" type="radio" name="sexo"
						value="Masculino" ${param.marcacao == 'Feminino' ? 'checked' : ''}> <label class="form-check-label"
						for="gridRadios1"> Feminino </label>
				</div>
				<div class="form-check">
					<input class="form-check-input" type="radio" name="sexo"
						value="Feminino "${param.marcacao == 'Masculino' ? 'checked' : ''}> <label class="form-check-label"
						for="gridRadios2"> Masculino </label>
				</div>
			</div>
		</div>

		<div class="form-group row">
			<legend class="col-form-label col-sm-2 pt-0">Seguros:</legend>
			<div class="col-sm-10">
				<div class="form-check">
					<input class="form-check-input" type="checkbox" name="seguros"  value="Auto"
						${paramValues.seguro.stream().anyMatch(v->v == 'Auto').get() ? 'checked' : ''}> <label class="form-check-label"
						for="gridRadios1"> AUTO </label>
				</div>
				<div class="form-check">
					<input class="form-check-input" type="checkbox" name="seguros" value="Residencial"
						${paramValues.seguro.stream().anyMatch(v->v == 'Residencial').get() ? 'checked' : ''}> <label class="form-check-label"
						for="gridRadios2"> RESIDENCIAL </label>
				</div>
				<div class="form-check">
					<input class="form-check-input" type="checkbox" name="seguros" value="Vida"
						${paramValues.seguro.stream().anyMatch(v->v == 'Vida').get() ? 'checked' : ''}> <label class="form-check-label"
						for="gridRadios2"> VIDA </label>
				</div>
			</div>
		</div>

		<div class="form-group row">
			<div class="col-sm-10">
				<select name="correntista" class="form-control"
					id="exampleFormControlSelect1">
					<option disabled checked>Correntista:</option>
					<option value="Sim" ${param.correntista == 'Sim' ? 'selected' : ''}>Sim</option>
					<option value="Nao" ${param.correntista == 'Nao' ? 'selected' : ''}>Não</option>
				</select>
			</div>
		</div>

		<div class="form-group row">
			<div class="col-sm-10">
				<select multiple name="diasVisita" class="form-control"
					id="exampleFormControlSelect1">
					<option value="Correntista" disabled>Dias da visita:</option>
					<option value="segunda" ${paramValue.visita.stream().anyMartch(v -> v == "Segunda").get() ? 'selected' : ''}>Segunda</option>
					<option value="terca" 
							${paramValue.visita.stream().anyMartch(v -> v == "Terça").get() ? 'selected' : ''}>Terça</option>
					<option value="quarta" 
							${paramValue.visita.stream().anyMartch(v -> v == "Quarta").get() ? 'selected' : ''}>Quarta</option>
					<option value="quinta" 
							${paramValue.visita.stream().anyMartch(v -> v == "Quinta").get() ? 'selected' : ''}>Quinta</option>
					<option value="sexta" 
							${paramValue.visita.stream().anyMartch(v -> v == "Sexta").get() ? 'selected' : ''}>Sexta</option>
				</select>
			</div>
		</div>
		<button type="submit" class="btn btn-primary">Cadastrar</button>
		<button type="reset" class="btn btn-primary">Limpar</button>

		${erro}
	</form>

</body>
</html>