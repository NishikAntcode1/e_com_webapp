<nav class="navbar navbar-expand-lg bg-body-tertiary">
	<div class="container-fluid">
		<a class="navbar-brand fw-bold" href="home">FAKESHOP</a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav me-auto mb-2 mb-lg-0">
				<li class="nav-item"><a class="nav-link active"
					aria-current="page" href="home">Home</a></li>
				<li class="nav-item">
					<form action="all_categories">
						<button class="nav-link" type="submit">Category</button>
					</form>

				</li>
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" role="button"
					data-bs-toggle="dropdown" aria-expanded="false"> Dropdown </a>
					<ul class="dropdown-menu">
						<li><a class="dropdown-item" href="#">Action</a></li>
						<li><a class="dropdown-item" href="#">Another action</a></li>
						<li><hr class="dropdown-divider"></li>
						<li><a class="dropdown-item" href="#">Something else here</a></li>
					</ul></li>
				<li class="nav-item"><a class="nav-link disabled"
					aria-disabled="true">Disabled</a></li>
			</ul>
			<form class="d-flex" role="search" action="search" method="post">
				<input class="form-control me-2" name="searchData" type="search" placeholder="Search"
					aria-label="Search" />
				<button class="btn bg-orange" type="submit">Search</button>
			</form>
		</div>
	</div>
</nav>