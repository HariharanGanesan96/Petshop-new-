
function checkPassword(){
var password=document.getElementById("passwordinput");
var repassword=document.getElementById("repasswordinput");
if(password.value==repassword.value){

}
else{
    repassword.title=("Password not matched");
}
}