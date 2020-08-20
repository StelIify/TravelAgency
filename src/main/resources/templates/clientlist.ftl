<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Client list</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
</head>
<body>
<div>
    <form method="get">
        <input type="text" value="Search">
        <input type="submit" value="Start">
    </form>
    <table class="table table-dark">
        <tr>
            <th>Name</th>
            <th>Address</th>
            <th>Telephone Number</th>
            <th>Description </th>
            <th>Delete</th>
            <th>Update</th>
        </tr>
        <#list list as item>
            <tr>
                <td>${item.name}</td>
                <td>${item.address}</td>
                <td>${item.phoneNumber}</td>
                <td>${item.description}</td>
                <td><a href="http://localhost:8080/web/client/delete/${item.id}">
                        <input type ="button" value="delete" class="btn-danger">
                    </a></td>
                <td><a href="http://localhost:8080/web/client/update/${item.id}">
                        <input type ="button" value="update" class="btn-danger">
                    </a></td>
            </tr>
        </#list>
    </table>
    <div>
        <a href="/web/client/reloadDB">
            <input type="button", value="Reload Database" style="
                        background-color: darkseagreen;
                        border-color: darkslategray;
                        border-radius: 20px;
                        border-width: 10px;
                "></a>
    </div>
    <div>
        <a href="/web/client/create">
            <input type="button" value="Create Client From" style="
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