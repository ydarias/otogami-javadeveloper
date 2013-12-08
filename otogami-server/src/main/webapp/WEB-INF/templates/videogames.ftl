<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Videogames finder</title>
</head>
<body>

<h1>Videogames finder</h1>

<form role="form" name="search-form" action="search" method="get">
    <div class="form-group">
        <label for="videogame-title">Title</label>
        <input type="text" class="form-control" name="title" id="videogame-title" placeholder="Title here ...">
    </div>
    <div class="form-group">
        <label for="videogame-platform">Platform</label>
        <select name="platform" id="videogame-platform" class="form-control">
            <option value="ps3">Play Station 3</option>
            <option value="ps4">Play Station 4</option>
            <option value="xbox360">xBox 360</option>
            <option value="xboxone">xBox One</option>
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

<#if videogames??>
	<table class="table">
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
                    <td>${videogame.url}</td>
			    </tr>
			</#list>
		</tbody>
	</table>
<#else>
	Please, introduce some filters and press submit button.
</#if>

</body>
</html>