// Display current date and time

function displayDateTime() {

    var now = new Date();

    var date = now.getDate();
    var month = now.getMonth() + 1;
    var year = now.getFullYear();

    var hours = now.getHours();
    var minutes = now.getMinutes();
    var seconds = now.getSeconds();

    if (date < 10) {
        date = "0" + date;
    }

    if (month < 10) {
        month = "0" + month;
    }

    if (hours < 10) {
        hours = "0" + hours;
    }

    if (minutes < 10) {
        minutes = "0" + minutes;
    }

    if (seconds < 10) {
        seconds = "0" + seconds;
    }

    document.getElementById("datetime").innerHTML =
        date + "-" + month + "-" + year + " " +
        hours + ":" + minutes + ":" + seconds;
}

setInterval(displayDateTime, 1000);

displayDateTime();


// --------------------------------------------------
// 3 MINUTE TIMER
// --------------------------------------------------

var startTime = new Date().getTime();

setInterval(function () {

    var currentTime = new Date().getTime();

    var difference = currentTime - startTime;

    var threeMinutes = 3 * 60 * 1000;

    if (difference >= threeMinutes) {

        alert("3 mins past.");

        startTime = new Date().getTime();
    }

}, 1000);


// --------------------------------------------------
// FORM VALIDATION
// --------------------------------------------------

function validateForm() {

    // First Name

    var firstName =
        document.getElementById("firstName").value.trim();

    if (firstName == "") {
        alert("First Name must be entered.");
        return false;
    }

    if (!/^[A-Za-z]+$/.test(firstName)) {
        alert("First Name must contain only characters.");
        return false;
    }


    // Last Name

    var lastName =
        document.getElementById("lastName").value.trim();

    if (lastName == "") {
        alert("Last Name must be entered.");
        return false;
    }

    if (!/^[A-Za-z]+$/.test(lastName)) {
        alert("Last Name must contain only characters.");
        return false;
    }


    // Password

    var password =
        document.getElementById("password").value;

    if (password == "") {
        alert("Password must be entered.");
        return false;
    }

    if (password.length < 6 || password.length > 20) {
        alert("Password length should be between 6 to 20 characters.");
        return false;
    }


    // Confirm Password

    var confirmPassword =
        document.getElementById("confirmPassword").value;

    if (confirmPassword == "") {
        alert("Confirm Password must be entered.");
        return false;
    }

    if (confirmPassword.length < 6 ||
        confirmPassword.length > 20) {

        alert("Confirm Password length should be between 6 to 20 characters.");
        return false;
    }


    // Password matching

    if (password != confirmPassword) {
        alert("Password and Confirm Password should be same.");
        return false;
    }


    // Gender

    var gender =
        document.querySelector('input[name="gender"]:checked');

    if (gender == null) {
        alert("Gender must be selected.");
        return false;
    }


    // Mobile Number

    var mobile =
        document.getElementById("mobile").value.trim();

    if (mobile == "") {
        alert("Mobile Number must be entered.");
        return false;
    }

    /*
       Accepted formats:

       XXX-XXX-XXXX
       XXX.XXX.XXXX
       XXX XXX XXXX
    */

    var mobilePattern =
        /^\d{3}[-. ]\d{3}[-. ]\d{4}$/;

    if (!mobilePattern.test(mobile)) {
        alert("Mobile Number must be in the correct format.");
        return false;
    }


    // DOB

    var dob =
        document.getElementById("dob").value.trim();

    if (dob == "") {
        alert("DOB must be entered.");
        return false;
    }

    var dobPattern =
        /^\d{2}-\d{2}-\d{4}$/;

    if (!dobPattern.test(dob)) {
        alert("DOB must be in DD-MM-YYYY format.");
        return false;
    }


    // Email

    var email =
        document.getElementById("email").value.trim();

    if (email == "") {
        alert("Email Address must be entered.");
        return false;
    }

    /*
       Email requirements:

       - @ must exist
       - @ cannot be first
       - dot must exist
       - dot must be after @
       - at least one character after dot
    */

    var emailPattern =
        /^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\.[A-Za-z]{1,}$/;

    if (!emailPattern.test(email)) {
        alert("Please enter a valid Email Address.");
        return false;
    }


    // Everything is correct

    alert("Registration Successful!");

    return true;
}