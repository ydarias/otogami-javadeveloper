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
					<input type="text" class="form-control" name="title" id="videogame-title" placeholder="Title here ..." value="${title}">
				</div>
				<div class="form-group">
					<label for="videogame-platform">Platform</label>
					<select name="platform" id="videogame-platform" class="form-control">
						<option value="" <#if (platform == "")> selected="selected" </#if>>All platforms</option>
						<option value="ps3" <#if (platform == "ps3")> selected="selected" </#if>>Play Station 3</option>
						<option value="ps4" <#if (platform == "ps4")> selected="selected" </#if>>Play Station 4</option>
						<option value="psvita" <#if (platform == "psvita")> selected="selected" </#if>>Play Station Vita</option>
						<option value="xbox360" <#if (platform == "xbox360")> selected="selected" </#if>>xBox 360</option>
						<option value="xboxone" <#if (platform == "xboxone")> selected="selected" </#if>>xBox One</option>
						<option value="pc" <#if (platform == "pc")> selected="selected" </#if>>PC</option>
						<option value="wii" <#if (platform == "wii")> selected="selected" </#if>>Wii</option>
						<option value="wiiu" <#if (platform == "wiiu")> selected="selected" </#if>>Wii U</option>
						<option value="n3ds" <#if (platform == "n3ds")> selected="selected" </#if>>Nintendo 3DS</option>
					</select>
				</div>
				<div class="checkbox">
					<label>
						<input name="availability" id="videogame-availability" type="checkbox" <#if availability??>checked</#if>> Only available
					</label>
				</div>
				<div class="checkbox">
					<label>
						<input name="price" id="videogame-price" type="checkbox" <#if price??>checked</#if>> Cheapers first
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
						<td>${videogame.price?string("0.00")} &#8364;</td>
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