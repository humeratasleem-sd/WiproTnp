<!DOCTYPE html>
<html>

<head>

    <title>AJAX Database Application</title>

    <script>

        function checkEmail() {

            var email = document.getElementById("email").value;

            var result = document.getElementById("result");

            if (email.trim() == "") {

                result.innerHTML = "";

                return;
            }

            var xhttp = new XMLHttpRequest();

            xhttp.onreadystatechange = function() {

                if (this.readyState == 4 && this.status == 200) {

                    result.innerHTML = this.responseText;

                }

            };

            xhttp.open(
                "GET",
                "../checkEmail?email=" + encodeURIComponent(email),
                true
            );

            xhttp.send();
        }

    </script>

</head>

<body>

    <h2>Registration Form</h2>

    <form>

        Email:
        <input type="text" id="email" name="email" onblur="checkEmail()">

        <span id="result"></span>

        <br><br>


        Password:
        <input type="password" name="password">

        <br><br>


        Name:
        <input type="text" name="name">

        <br><br>


        Date of Birth:
        <input type="date" name="dob">

        <br><br>


        Gender:

        <input type="radio" name="gender" value="Male">

        Male

        <input type="radio" name="gender" value="Female">

        Female

        <br><br>


        City:
        <input type="text" name="city">

        <br><br>


        Pincode:
        <input type="text" name="pincode">

        <br><br>


        Mobile:
        <input type="text" name="mobile">

        <br><br>


        <input type="submit" value="Register">

    </form>

</body>

</html>