<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Axios with JSP</title>
    <script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
    <script>
        function fetchData() {
            axios.get('ApiServletUser')
                .then(function (response) {
                    // handle success
                    console.log(response.data);
                    document.getElementById('result').innerText = JSON.stringify(response.data, null, 2);
                })
                .catch(function (error) {
                    // handle error
                    console.error(error);
                    document.getElementById('result').innerText = 'Error: ' + error.message;
                });
        }
    </script>
</head>
<body>
<h1>Axios with JSP Example</h1>
<button onclick="fetchData()">Fetch Data</button>
<pre id="result"></pre>
</body>
</html>
