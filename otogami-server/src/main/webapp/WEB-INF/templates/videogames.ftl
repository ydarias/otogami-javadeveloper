<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Videogames finder</title>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css">

    <!-- Optional theme -->
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap-theme.min.css">


</head>
<body>

<div class="container">

	<h1>Videogames finder</h1>

	<div class="panel panel-default">
		<div class="panel-body">
			<form role="form" name="search-form" action="search" method="get">
				<div class="form-group">
					<label for="videogame-title">Title</label>
					<input type="text" class="form-control" name="title" id="videogame-title" placeholder="Title here ...">
				</div>
				<div class="form-group">
					<label for="videogame-platform">Platform</label>
					<select name="platform" id="videogame-platform" class="form-control">
						<option value="">All platforms</option>
						<option value="ps3">Play Station 3</option>
						<option value="ps4">Play Station 4</option>
						<option value="psvita">Play Station Vita</option>
						<option value="xbox360">xBox 360</option>
						<option value="xboxone">xBox One</option>
						<option value="pc">PC</option>
						<option value="wii">Wii</option>
						<option value="wiiu">Wii U</option>
						<option value="n3ds">Nintendo 3DS</option>
					</select>
				</div>
				<div class="checkbox">
					<label>
						<input name="availability" id="videogame-availability" type="checkbox"> Only available
					</label>
				</div>
				<div class="checkbox">
					<label>
						<input name="price" id="videogame-price" type="checkbox"> Cheapers first
					</label>
				</div>

				<button id="submit-button" type="submit" class="btn btn-default">Submit</button>
			</form>
        </div>
    </div>

	<#if videogames??>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>Title</th>
					<th>Platform</th>
					<th>Available</th>
					<th>Price</th>
					<th>Link</th>
				</tr>
			</thead>
			<tbody>
				<#list videogames as videogame>
					<tr>
						<td>${videogame.title}</td>
						<td>${videogame.platform}</td>
						<td>${videogame.availability}</td>
						<td>${videogame.price} &#8364;</td>
						<td><a href="${videogame.url}" target="_blank">View in shop</a></td>
					</tr>
				</#list>
			</tbody>
		</table>
	<#else>
		<div class="alert alert-info">
			There are no games for your search :-(
		</div>
	</#if>

</div>

<!-- Latest compiled and minified JavaScript -->
<script src="//netdna.bootstrapcdn.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>

</body>
</html>