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
<div>
    <fieldset>
        <legend>Update TravelRoute</legend>
        <form name="travelRoute" action="" method="POST">
            Client:<@spring.formSingleSelect "travelRouteForm.client", movs,"" />
            <br>
            Country:<@spring.formInput "travelRouteForm.country" "" "text"/>
            <br>
            Climate:<@spring.formInput "travelRouteForm.climate" "" "text"/>
            <br>
            Duration:<@spring.formInput "travelRouteForm.duration" "" "text"/>
            <br>
            Hotel:<@spring.formInput "travelRouteForm.hotel" "" "text"/>
            <br>
            Price:<@spring.formInput "travelRouteForm.price" "" "text"/>
            <br>
            <input type="submit" value="Update"/>
        </form>
    </fieldset>
</div>
</body>
</html>