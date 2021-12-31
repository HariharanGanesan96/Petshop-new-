<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>ABS Login</title>
    <link rel="stylesheet" href="index.css">
    
</head>
<body>
    <div id="background">
         <!--Welcome note-->
        <h1>
            Welcome to PET Market
        </h1>
        <!--Login form-->
        <form action="login" class="form" method="get">      
          <p id="head">Login here</p>   
            <label for="username" id="username">Username:</label>
            <br>
            <input type="text" name="usernameinput" id="usernameinput" placeholder="Enter the username" pattern="[a-zA-Z0-9]+{8,20}" title="username must be in 8 character" required>
            <br>
            <label for="password">Password:</label>
            <br>
            <input type="password" name="passwordinput" id="passwordinput" placeholder="Enter the password" pattern="[a-zA-Z0-9!@#$%^&*()]+{8,20}" title="password must be in 8 character" required>
            <br>
            <button type="submit" id="login">Login</button>
            <p>Don't have account ?<a href="Register.html">Register here</a></p>
        </form>
    </div>
</body>
</html>