<html>
<head>
<title>Mottoes</title>
</head>
<body>
<table>
<tr>
	<th>����</th><th>����</th>
</tr>
{foreach item=motto from=$rows }
<tr>
<td>{$motto.words}</td>
<td>{$motto.author}</td>
</tr>
{/foreach}
</table>
</body>
</html>
 

