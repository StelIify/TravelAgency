<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet"
          type="text/css" href="<@spring.url '/css/style.css'/>"/>
</head>
<body>
<div class="container">
    <div class="center">
        <fieldset style="display: inline-block">
            <legend>Update TripTicket</legend>
            <form name="tripTicket" action="" method="POST">
                <table>
                    <tr>
                        <td>Travel Route</td><td><@spring.formSingleSelect "tripTicketForm.travelRouteId", movs, ""/></td>
                    </tr>
                    <tr>
                        <td>Date of Departure</td><td><@spring.formInput "tripTicketForm.dateOfDeparture" "" "text"/></td>
                    </tr>
                    <tr>
                        <td>Amount</td><td><@spring.formInput "tripTicketForm.amount", "" "text"/></td>
                    </tr>
                    <tr>
                        <td>Discount</td><td><@spring.formInput "tripTicketForm.discount", "" "text"/></td>
                    </tr>
                </table>
                <input type="submit" value="Update"/>
            </form>
        </fieldset>
    </div>
</div>
</body>
</html>