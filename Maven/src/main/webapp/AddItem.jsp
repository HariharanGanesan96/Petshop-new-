<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Animal register</title>
     <link rel="stylesheet" href="AddItem.css">
</head>

<body>
    <div id="background">
    <form class="animalform" action="">
        <table>
            <tr>
                <th id="register" colspan="2">Register Animal</th>
                <th></th>
            </tr>

            <tbody>
                <tr>
                    <td><label for="animaltype">Animal Type </label></td>
                    <td><input type="text" name="animaltype" id="animaltype" pattern="[a-zA-Z]{3,20}"  list="typelist" required></td>
                </tr>
                <tr>
                    <td><label for="animalname">Name</label></td>
                    <td> <input type="text" name="animalname" id="animalname" pattern="[a-zA-Z]{3,20}" list="namelist" required></td>
                </tr>
                <tr>
                    <td><label for="animalgender">Gender</label></td>
                    <td><input type="text" name="animalgender" id="animalgender" pattern="[a-zA-Z]{3,20}" list="genderlist" required></td>
                </tr>
                <tr>
                    <td><label for="dob" name="dob">Date of birth</label></td>
                    <td><input type="date" name="dob" id="dob"  ></td>
                </tr>
                <tr>
                    <td><label for="color">Color</label></td>
                    <td><input type="text" name="color" id="color" pattern="[a-zA-Z]{3,20}" list="colors" ></td>
                </tr>
                <tr>
                    <td><label for="price">price</label></td>
                    <td><input type="number" 5 name="price" id="price" min="0" required></td>
                </tr>
                <tr>
                    <td><label for="imagelink">Image Link</label></td>
                    <td><input type="text" 5 name="imagelink" id="imagelink"  required></td>
                </tr>
                <tr>
                    <td><label for="description">Description</label></td>
                    <td><textarea name="description" id="description" cols="30" required></textarea></td>
                </tr>
                <tr>
                    <td><button>Register</button></td>
                </tr>
            </tbody>
        </table>
        <datalist id="typelist">
            <option value="Dog"></option>
            <option value="Cat"></option>
            <option value="Birds"></option>
            <option value="Fish"></option>
        </datalist>
        <datalist id="namelist">
            <option value="french bulldog"></option>
            <option value="German Shepherd"></option>
            <option value="Maine Coon"></option>
            <option value="Ragdoll"></option>
            <option value="Parakeets"></option>
            <option value="Cockatiels"></option>
            <option value="Angelfish"></option>
            <option value="Rainbow"></option>
        </datalist>
        <datalist id="genderlist">
            <option value="Male" ></option>
            <option value="Female"></option>
        </datalist>
        <datalist id="colors">
            <option value="Black" ></option>
            <option value="White"></option>
            <option value="Gray"></option>
            <option value="Gold"></option>
            <option value="Sliver"></option>
            <option value="Green"></option>
            <option value="Rainbow"></option>
            <option value="Blue"></option>
        </datalist>
    </form>
</div>
<script>
today();
function today(){
    var today = new Date();
    var dd = String(today.getDate()).padStart(2, '0');
    var mm = String(today.getMonth() + 1).padStart(2, '0'); //January is 0!
    var yyyy = today.getFullYear();
    var yyyy1= today.getFullYear()-10;
    
maxdate =yyyy + '-' + mm + '-'+ dd  ;
mindate =yyyy1 + '-' + mm + '-'+ dd  ;
document.getElementById("dob").setAttribute("max",maxdate);
document.getElementById("dob").setAttribute("min",mindate);
}
</script>
</body>

</html>