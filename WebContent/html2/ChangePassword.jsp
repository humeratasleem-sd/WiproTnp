<!DOCTYPE html>
<html>

<head>

    <title>Change Password</title>

    <script type="text/javascript">

        function validatePassword() {

            var newPassword =
                document.getElementById("newPassword").value;

            var confirmPassword =
                document.getElementById("confirmPassword").value;

            if (newPassword.length < 6) {
                alert("New password should contain minimum 6 characters");
                return false;
            }

            var number = /[0-9]/;

            if (!number.test(newPassword)) {
                alert("Password must contain at least one number");
                return false;
            }

            var uppercase = /[A-Z]/;

            if (!uppercase.test(newPassword)) {
                alert("Password must contain at least one uppercase letter");
                return false;
            }

            if (newPassword != confirmPassword) {
                alert("New password and Retype password should be same");
                return false;
            }

            return true;
        }

    </script>

</head>

<body>

<center>

    <h2>Change Password</h2>

    <form action="../changePassword"
          method="post"
          onsubmit="return validatePassword()">

        User Name:

        <input type="text"
               name="userid"
               value="<%= request.getParameter("userid") == null ? "" : request.getParameter("userid") %>"
               required>

        <br><br>

        Old Password:

        <input type="password"
               name="oldPassword"
               required>

        <br><br>

        New Password:

        <input type="password"
               id="newPassword"
               name="newPassword"
               required>

        <br><br>

        Retype New Password:

        <input type="password"
               id="confirmPassword"
               name="confirmPassword"
               required>

        <br><br>

        <input type="submit"
               value="Change Password">

    </form>

    <br>

    <a href="Login.html">Back to Login</a>

</center>

</body>
</html>