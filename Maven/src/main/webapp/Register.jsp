<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>ABS Register</title>
       <link rel="stylesheet" href="Register.css">
   
</head>
<body>
     <!--Animal register-->
<div id="background">
   
    <form action="register" name="registerform" class="registerform">
        <div id="image">
            <img src="https://images.pexels.com/photos/8473666/pexels-photo-8473666.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500" alt="back">
        </div>
        <table>
            <thead>
                <tr>
                    <th id="registername" colspan="2">Register here </th>
                    <th> </th>                 
                </tr>
                <tr>
                    <td><label for="firstname">FirstName <span>*</span></label></td>
                    <td><input type="text" name="firstname" id="firstnameinput" pattern="[a-zA-Z]{3,20}" title="Name contains only letter" placeholder="Firstname" required><p id="firstnamecomment"></p></td>
                </tr>
                <tr>
                    <td><label for="lastname">LastName <span>*</span></label></td>
                    <td><input type="text" name="lastname" id="lastnameinput" pattern="[a-zA-Z]{3,20}" title="Name contains only letter" placeholder="Lastname" required></td>
                </tr>
                <tr>
                    <td><label for="Gendr">Gender <span>*</span></label></td>
                    <td><input type="text" name="gender" id="genderinput" pattern="[a-zA-Z]{3,10}" title="Name contains only letter" placeholder="Gender" list="genderlist" required></td>
                </tr>
                <tr>
                     <td><label for="username">UserName <span>*</span></label></td>
                     <td><input type="text" name="username" id="usernameinput" placeholder="username"  pattern="[a-zA-Z0-9]{8,20}" title="minimum 8 character required " required></td>
                </tr>
                <tr>
                    <!--^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%?&])[A-Za-z\d@$!%*?&]{8,15}-->
                    <td><label for="password">Password <span>*</span></label></td>
                    <td><input type="password" name="password" id="passwordinput" placeholder="password" pattern="[a-zA-Z0-9!@#$%^&*()_+]{8,20}" required></td>
                </tr>
                <tr>
                    <td><label for="repassword">Re-Password <span>*</span></label></td>
                    <td><input type="password" onpointerout="valPassword()"  name="Re-password" id="repasswordinput" placeholder="Re enter password" required><p id="repasswordcomment"></p></td>
                    
                </tr>
                <tr>
                    <td><label for="mobile">Phone <span>*</span></label></td>
                    <td><input type="number" name="mobile" id="mobileinput" pattren="[789][0-9]+{10}" placeholder="MobileNumber" required></td>
                </tr>
                <tr>
                    <td><label for="email" >Email <span>*</span></label></td>
                    <td><input type="email" name="email" id="emailinput" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$" placeholder="Email" required></td>
                </tr>
                <tr>
                    <td><button type="submit" id="register">Register</button></td>
                    <td></td>
                </tr>
            </thead>
        </table>   
        <datalist id="genderlist">
            <option value="Male"></option>
            <option value="Female"></option>
            <option value="Others"></option>
        </datalist>   
    </form>
</div>
<script>
    function valPassword(){
        let password=document.getElementById("passwordinput").value;
        let repassword=document.getElementById("repasswordinput").value;
        let comment= document.getElementById("repasswordcomment");
        if(password==repassword){
            console.log("called if");
            comment.style.display="none";
     }
     else{
        
         comment.style.display="block";
         comment.innerHTML="password does not match";
         comment.style.color="red";
         comment.style.fontSize="17px";
         console.log("called else");
    }	
}
function valfirstname(){
        let firstname=document.getElementById("firstnameinput").value;
        let comment= document.getElementById("firstnamecomment");
        if(firstname.legth>2){
        	 comment.style.display="block";
        	 comment.innerHTML="password does not match";
        	 comment.style.color="red";
             comment.style.fontSize="17px";	
        }
        
        
}
</script>
</body>
</html>