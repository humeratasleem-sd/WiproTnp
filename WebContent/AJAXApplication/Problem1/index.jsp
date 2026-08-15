<!DOCTYPE html>
<html>

<head>

    <title>AJAX Application</title>

    <script>

        function showCities() {

            var state = document.getElementById("state").value;

            var result = document.getElementById("cities");

            if (state == "") {

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
                "../../city?state=" + encodeURIComponent(state),
                true
            );

            xhttp.send();
        }

    </script>

</head>

<body>

    <h2>Important Cities</h2>

    <label>Select State:</label>

    <select id="state" onchange="showCities()">

        <option value="">--Select State--</option>

        <option value="Telangana">Telangana</option>

        <option value="Karnataka">Karnataka</option>

        <option value="Maharashtra">Maharashtra</option>

        <option value="Tamil Nadu">Tamil Nadu</option>

    </select>

    <br><br>

    <div id="cities"></div>

</body>

</html>