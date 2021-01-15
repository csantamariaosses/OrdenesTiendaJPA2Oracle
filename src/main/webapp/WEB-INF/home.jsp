<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
</head>
<body>

<div class="container">
	<div class="row text-center">
		<div class="col-12">
			<h4>Reporte de Ordenes por Tienda</h4>
		</div>
	</div>
</div>
<hr>

	<form name = "frm" id="frm" action="/" method="POST">
		<div class="container">
			<div class="row text-left">
				<div class="col-3">Tienda</div>
				<div class="col-3">Estado</div>
				<div class="col-3">Fecha Desde</div>
				<div class="col-3">Fecha Hasta</div>
			</div>

			<div class="row text-left">
				<div class="col-3">
					<select name="store" id="store">
						<option value="0">Seleccione...</option>
						<c:forEach var="data" items="${stores}">
							<option value="${data.id}">${data.store_name}</option>
						</c:forEach>
					</select>
				</div>
				<div class="col-3">
					<select name="estado" id="estado">
						<option value="0">Seleccione...</option>
						<c:forEach var="data" items="${estados}">
							<option value="${data.id}">${data.estado_name}</option>
						</c:forEach>
					</select>
				</div>
				<div class="col-3">
					<input type="date" name="fechaDesde" id="fechaDesde">
				</div>
				<div class="col-3">
					<input type="date" name="fechaHasta" id="fechaHasta">
				</div>
			</div>
			<div class="row text-right">
				<div class="col-12">
					<button type="button" onClick="validar();">Buscar</button>
				</div>
			</div>

		</div>


	</form>
<br><hr><br>

<div class="container">
	<div class="row">
		<div class="col-12">
			<h4>Ordenes</h4>
		</div>
	</div>
</div>



<div class="container">
	<div class="row">
		<div class="col-12">
			 <table class="table">
		    <thead>
		    	<tr>
		    	<th>Id Orden</th>
		    	<th>Vendedor</th>
		    	<th>Store</th>
		    	<th>Cliente</th>
		    	<th>Fecha Orden</th>
		    	<th>Fecha Respuesta</th>
		    	<th>Estado</th>
		    	<th>Accion</th>
		    	</tr>
		    </thead>	
		    <tbody>
		       <c:forEach var="data" items="${orders}">
		    	<tr>
		    	<td>${data.id}</td>
		    	<td>${data.staff.getFirst_name()} ${data.staff.getLast_name()}</td>
		    	<td>${data.store.getStore_name()}</td>
		    	<td>${data.customer.getFirst_name()} ${data.customer.getLast_name()}</td>
		    	<td>${data.orderDate}</td>
		    	<td>${data.required_date}</td>
		    	<td>${data.estado.getEstado_name()}</td>
		    	<td><button>VER</button></td>
		    	</tr>
		    	</c:forEach>
		    
		    </tbody>
		    	
		    	
		    <tfooter>
		    	<tr>
		    	<th>Id Orden</th>
		    	<th>Vendedor</th>
		    	<th>Store</th>
		    	<th>Cliente</th>
		    	<th>Fecha Orden</th>
		    	<th>Fecha Respuesta</th>
		    	<th>Estado</th>
		    	<th>Accion</th>
		    	</tr>
		    </tfooter>	
		    </table>
		</div>
	</div>
</div>



<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>		
<script>

function validar() {
	const store = document.getElementById("store").value;
	const estado = document.getElementById("estado").value;
	
	let fechaDesde = document.getElementById("fechaDesde").value;
	let fechaHasta = document.getElementById("fechaHasta").value;


    if( fechaDesde.length ==  0 ) {
	    fechaDesde = "0";
    }
    if( fechaHasta.length == 0 ) {
	    fechaHasta = "0";
    }

   if( store != "0" && estado != "0" && fechaDesde !="0" && fechaHasta != "0" ) {
       document.getElementById("frm").submit();
    } else {
        alert("Debe selecciionar todos los datos..!");

    }
	
}

</script>


</body>
</html>