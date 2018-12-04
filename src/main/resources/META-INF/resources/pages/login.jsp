<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link href="style.css" rel="stylesheet" media="all" type="text/css"> 
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>

<div class="row">
		<div>${param.error }</div>
		<section class="col-lg-12 " id="form">
			<form class="col-lg-4 offset-lg-4 px-4 py-3" action="" method="post">
				<div class="form-group">
					<label for="username">Username:</label>
					<input class="form-control" id="username" name="username">
				</div>
				<div class="form-group">
					<label for="password">Password:</label>
					<input type="password" class="form-control" id="password" name="password">
				</div>
<!-- 				<div class="form-check"> -->
<!-- 				      <input type="checkbox" class="form-check-input" id="dropdownCheck"> -->
<!-- 				      <label class="form-check-label" for="dropdownCheck"> -->
<!-- 				        Se souvenir de moi -->
<!-- 				      </label> -->
<!-- 				</div> -->
				<div>
					<button class="btn btn-success" type="submit">Login</button>
					<a href="javascript:history.back()" class="btn btn-warning">Cancel</a>
				</div>
			</form>	
<!-- 			<div class="dropdown-divider"></div> -->
<!-- 			<a class="dropdown-item" href="creationcompte.html" >Nouvel adherent? Créé ton compte</a> -->
<!-- 			<a class="dropdown-item" href="#">Mot de passez oublié</a> -->
		</section>
	</div>
	

</body>
</html>