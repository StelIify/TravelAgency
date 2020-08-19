<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>TripTicket List</title>
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
            <th>Travel Route</th>
            <th>Date of Departure </th>
            <th>Amount</th>
            <th>Discount</th>
            <th>Update</th>
            <th>Delete</th>
        </tr>
        <#list list as item>
            <tr>
                <td>${item.travelRoute.getCountry()}</td>
                <td>${item.dateOfDeparture}</td>
                <td>${item.amount}</td>
                <td>${item.discount}</td>
                <td><a href="http://localhost:8080/web/tripTicket/update/${item.id}">
                        <input type ="button" value="update" class="btn-danger">
                    </a></td>
                <td><a href="http://localhost:8080/web/tripTicket/delete/${item.id}">
                        <input type ="button" value="delete" class="btn-danger">
                    </a></td>
            </tr>
        </#list>
    </table>
    <div>
        <a href="/web/tripTicket/reloadDB/">
            <input type="button", value="Reload Database" style="
                        background-color: aquamarine;
                        border-color: aqua;
                        border-radius: 30px;
                        border-width: 10px;
                "></a>
    </div>
    <div>
        <a href="/web/tripTicket/create">
            <input type="button" value="Create TripTicket" style="
                        background-color: aquamarine;
                        border-color: aqua;
                        border-radius: 30px;
                        border-width: 10px;
                ">
        </a>
    </div>
</div>
</body>

</html>