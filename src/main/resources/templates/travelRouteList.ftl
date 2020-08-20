<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>TravelRoute List</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">

</head>
<body>
<div>
    <form method="post">
        <input type="text" value="" name="search">
        <input type="submit" value="Go" onclick="">
    </form>
    <table class="table table-striped table-dark">
        <tr>
            <th>Client</th>
            <th>Country </th>
            <th>Climate</th>
            <th>Duration</th>
            <th>Hotel</th>
            <th>Price</th>
            <th>Update</th>
            <th>Delete</th>
        </tr>
        <#list list as item>
            <tr>
                <td>${item.client.name}</td>
                <td>${item.country}</td>
                <td>${item.climate}</td>
                <td>${item.duration}</td>
                <td>${item.hotel}</td>
                <td>${item.price}</td>
                <td><a href="http://localhost:8080/web/travelRoute/update/${item.id}">
                        <input type ="button" value="update" class="btn-danger">
                    </a></td>
                <td><a href="http://localhost:8080/web/travelRoute/delete/${item.id}">
                        <input type ="button" value="delete" class="btn-danger">
                    </a></td>
            </tr>
        </#list>
    </table>
    <div>
        <a href="/web/travelRoute/reloadDB/">
            <input type="button", value="Reload Database" style="
                       background-color: darkseagreen;
                        border-color: darkslategray;
                        border-radius: 20px;
                        border-width: 10px;
                "></a>
    </div>
    <div>
        <a href="/web/travelRoute/create">
            <input type="button" value="Create TravelRoute" style="
                        background-color: darkseagreen;
                        border-color: darkslategray;
                        border-radius: 20px;
                        border-width: 10px;
                ">
        </a>
    </div>
</div>
</body>

</html>