<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Get Check Box Value</title>
    <style>
        .container {
            margin: 100px 50px;
            font-size: 20px;
        }
    </style>
</head>
<body>
<div class="container">
    <input type="checkbox" class="checks" value="Apple"> A____<br>
    <input type="checkbox" class="checks" value="Banana"> B_____<br>
    <input type="checkbox" class="checks" value="Carrot"> C_____<br>
    <br><br>
    <a href="#" onclick="getValue();return false;">Get Value</a>
</div>
<script>
    function getValue() {
        var checks = document.getElementsByClassName('checks');
        var str = '';

        for ( i = 0; i < 3; i++) {
            if ( checks[i].checked === true ) {
                str += checks[i].value + " ";
            }
        }
        alert(str);
    }
</script>
</body>
</html>