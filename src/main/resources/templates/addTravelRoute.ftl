<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Add TravelRoute</title>
    <link rel="stylesheet"
          type="text/css" href="<@spring.url '/css/style.css'/>"/>
</head>
<style>
    .container {
        height: 200px;
        position: relative;
        border: 3px solid #000000;
    }
    .center {
        margin: 0;
        position: absolute;
        top: 50%;
        left: 50%;
        -ms-transform: translate(-50%, -50%);
        transform: translate(-50%, -50%);
    }
</style>


<body>
<div class="container">
    <div class="center">
        <fieldset style="display: inline-block">
            <legend>Add TravelRoute</legend>
            <form name="travelRoute" action="" method="POST">
                <table>
                    <tr>
                        <td>Client</td><td><@spring.formSingleSelect "travelRouteForm.client", movs, ""/></td>
                    </tr>
                    <tr>
                        <td>Country</td><td><@spring.formInput "travelRouteForm.country" "" "text"/></td>
                    </tr>
                    <tr>
                        <td>Climate</td><td><@spring.formInput "travelRouteForm.climate", "" "text"/></td>
                    </tr>
                    <tr>
                        <td>Duration</td><td><@spring.formInput "travelRouteForm.duration", "" "text"/></td>
                    </tr>
                    <tr>
                        <td>Hotel</td><td><@spring.formInput "travelRouteForm.hotel", "" "text"/></td>
                    </tr>
                    <tr>
                        <td>Price</td><td><@spring.formInput "travelRouteForm.price", "" "text"/></td>
                    </tr>

                </table>
                <input type="submit" value="Create"/>
            </form>
        </fieldset>
    </div>
</div>
</body>
</html>