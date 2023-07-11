<script>
    function buscar() {
        const clave = document.getElementById("clave");
        if(!clave) {
            return;
        }
        document.forms[0].submit();//enviar el formulario via javascript
    }
</script>
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
        <form class="d-flex" 
            role="search" 
            action="<%=request.getContextPath()%>/BuscadorController"
            method="GET">
          <input name="clave" 
            id="clave"
            class="form-control me-2" 
            type="search" 
            placeholder="Search" 
            aria-label="Search">
          <button class="btn btn-outline-success" 
            type="submit">
                Buscar
          </button>
          <!-- <a class="btn btn-outline-success" role="button" href="#" onclick="buscar()">
            Buscar
          </a> -->
        </form>
      </div>
    </div>
  </nav>