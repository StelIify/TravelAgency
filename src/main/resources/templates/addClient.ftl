<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<div>
    <fieldset>
        <legend>Add client</legend>
        <form name="client" action="" method="POST">
            Name:<@spring.formInput "clientForm.name" "" "text"/>
            <br>
            Address:<@spring.formInput "clientForm.address" "" "text"/>
            <br>
            Phone Number:<@spring.formInput "clientForm.phoneNumber" "" "text"/>
            <br>
            Description:<@spring.formInput "clientForm.description" "" "text"/>
            <br>
            <input type="submit" value="Create"/>
        </form>
    </fieldset>
</div>

</body>
</html>