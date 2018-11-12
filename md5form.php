<?php

?>


<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>



</style>
</head>
<body>

<form action="/md5.php" method="POST">
  <div class="container">
    <h1>Register</h1>
    <p>Please fill in this form to create an account.</p>
    <hr>

    <label for="email"><b>Email</b></label>
    <input type="text" placeholder="Enter Email" name="email" required>

    <label for="psw"><b>Password</b></label>
    <input type="password" placeholder="Enter Password" name="pass1" required>

    <label for="psw-repeat"><b>Repeat Password</b></label>
    <input type="password" placeholder="Repeat Password" name="pass2" required>
    <hr>
	
	<label for="psw-repeat"><b>Generate Magik Code</b></label></br>
	<select name="pincount">
	  <option value="4">4</option>
	  <option value="6">6</option>
	  <option value="7">7</option>
	  <option value="8">8</option>
	</select>
	
    <p>By creating an account you agree to our <a href="#">Terms & Privacy</a>.</p>

    <button type="submit" class="registerbtn" name="register">Register</button>
  </div>
  
  <div class="container signin">
    <p>Already have an account? <a href="#">Sign in</a>.</p>
  </div>
</form>

</body>
</html>
