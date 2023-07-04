<%@ page import="ar.com.codoacodo.oop.Articulo" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="Cache-Control" content="no-cache, no-store, must-revalidate" />
    <meta http-equiv="Pragma" content="no-cache" />
    <meta http-equiv="Expires" content="0" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>CaC23049</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
    <nav class="navbar navbar-expand-lg bg-body-tertiary">
        <div class="container-fluid">
          <a class="navbar-brand" href="#">Navbar</a>
          <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
          </button>
          <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
              <li class="nav-item">
                <a class="nav-link active" aria-current="page" href="nuevo.jsp">Nuevo</a>
              </li>
              <li class="nav-item">
                <a class="nav-link active" aria-current="page" href="<%=request.getContextPath()%>/ListadoArticuloController">Listado</a>
              </li>              
            </ul>
            <form class="d-flex" role="search">
              <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
              <button class="btn btn-outline-success" type="submit">Search</button>
            </form>
          </div>
        </div>
      </nav>
      <% 
      Articulo articulo = (Articulo)request.getAttribute("producto");
     %>
    <div class="container">
        <div class="row">
            <div class="col-12">
                <section>
                    <h1>Editar Articulo id=<%=articulo.getId()%></h1>
                    <form method="post" action="<%=request.getContextPath()%>/EditarController?id=<%=articulo.getId()%>">
                        <div class="mb-3">
                            <label for="exampleFormControlInput1" 
                                class="form-label">Nombre</label>
                            <input name="nombre" 
                                type="text" 
                                class="form-control" 
                                id="exampleFormControlInput1"
                                placeholder="Nombre"
                                maxlength="50"
                                value="<%=articulo.getTitulo()%>">
                        </div>
                        <div class="mb-3">
                            <label for="exampleFormControlTextarea1" 
                                class="form-label">Precio
                            </label>
                            <input name="precio" 
                                type="number" 
                                class="form-control" 
                                id="exampleFormControlTextarea1"
                                value="<%=articulo.getPrecio()%>">
                        </div>
                        <div class="mb-3">
                            <label for="exampleFormControlTextarea1" 
                                class="form-label">Im&aacute;gen
                            </label>
                            <input name="imagen" 
                                type="file" 
                                class="form-control" 
                                id="exampleFormControlTextarea1"
                                value="<%=articulo.getImagen()%>">
                        </div>
                        <div class="mb-3">
                            <label for="exampleFormControlTextarea1" 
                                class="form-label">C&oacute;digo
                            </label>
                            <input name="codigo" 
                                type="text" 
                                disabled
                                readonly
                                class="form-control" 
                                id="exampleFormControlTextarea1" 
                                maxlength="7"
                                value="<%=articulo.getCodigo()%>">
                        </div>
                        <div class="mb-3">
                            <label for="autor" 
                                class="form-label">Autor
                            </label>
                            <input name="autor" 
                                type="text" 
                                class="form-control" 
                                id="autor" 
                                maxlength="50"
                                value="<%=articulo.getCodigo()%>">
                        </div>
                        <button class="btn btn-primary">
                            Modificar
                        </button>
                    </form>
                </section>
            </div>
        </div>
</body>

</html>