<?php
	
	if(isset($_POST['register'])){
		$email = $_POST['email'];
		$pass1 = $_POST['pass1'];
		$pass2 = $_POST['pass2'];
		$pincount = $_POST['pincount'];
		
	} else {
		$email = "";
		$pass1 = "";
		$pass2 = "";
		$pincount = "";
	}
	/************************************************/
	//how many digit user wanted to rearrange
	$howManyDigit = $pincount;    //x012345
	$str_pass = $pass2;
	$md5_hashed_length = 32;
	
	/************************************************/
	$str_pass_md5_hashed[] = "";
	//hash str password
	$str_pass_md5_hashed = md5($str_pass);
	/************************************************/
	
	/************************************************/
	echo '$str_pass_md5_hashed = '.md5($str_pass)."</br>";	
	echo '$md5_hashed_length = '.$md5_hashed_length."</br>";	
	echo '$howManyDigit = '.$howManyDigit."</br>";	
	echo '$str_pass_md5_hashed = '.$str_pass_md5_hashed[0]."</br>";
	//convert to x part
	/************************************************/	
	
	/************************************************/
	//chunk it into delimited string
	if((32 % $howManyDigit) != 0) $chunklenght = ((int)(32/($howManyDigit)))+1;
	else $chunklenght = ((int)(32/($howManyDigit)));
	
	echo '$chunklenght ='.$chunklenght."</br>";
	/************************************************/
	
	/************************************************/
	//convert the string delimited into array
	//2=16keys, 3=11keys, 4=8keys, 5=7keys, 6=6keys, 7=5keys, 8=4keys, 9=4keys, 10=4keys, 11/15=3keys,16 = 2keys,17/32=1keys   	
	$delimited_hashed_code =  chunk_split($str_pass_md5_hashed,$chunklenght);
	echo '$delimited_hashed_code = '.$delimited_hashed_code."</br>";	
	/************************************************/
	
	/************************************************/
	//remove all non printable characters	
	$str = preg_replace(array('/\s{2,}/', '/[\t\n]/'), ' ', $delimited_hashed_code);
	$str = rtrim($str);

	echo $str."</br>";
	/************************************************/	
	
	/************************************************/
	//save it into array individualy
	if(strpos($str, " ") !== false){
		$str5 = explode(" ", $str);	
	}//if	
	echo "<pre>";	
	echo "HASH CHUNKS:";	
	print_r($str5);
	echo "</pre>"; 	
	/************************************************/
	
	/************************************************/
	
	$arr = NonRepeatingRandomDigits($howManyDigit);	
	
	
	
	$r = array();
	for ($i = 0; $i < $howManyDigit; $i++) {
		$r[] = substr($arr, $i, 1);
		//echo $r[$i]."</br>";
	}	
	echo "<pre>";	
	echo "MAGIK CODE:";
	print_r($r);
	echo "</pre>";
	/************************************************/
	
	/************************************************/
	echo "FINAL HASHED: ".'</br>';	
	$scrambledEgg = "";	
	$scrambledEgg1 = "";	
	
	for($j = 0; $j != $howManyDigit; $j++){		
		for($i = 0; $i != $howManyDigit+1; $i++){
			if($r[$j] == $i){
				$scrambledEgg .= $str5[$i]."";				
				
			}	
		}		
	}//for j;	

	
	
	for($j = 0; $j != $howManyDigit; $j++){		
		for($i = 0; $i != $howManyDigit+1; $i++){
			if($r[$j] == $i){
				$scrambledEgg1 .= $str5[$i]."-----";				
				//echo $str5[$j]."</br>";
			}	
		}		
	}//for j;

	
	echo "<pre>";
	echo $scrambledEgg."</br>";
	echo $scrambledEgg1."</br>";
	echo $howManyDigit.'x'.$arr."</br>";
	echo strlen($str_pass_md5_hashed);
	echo "</pre>"; 
	/************************************************/
	function NonRepeatingRandomDigits($length){		
		$numbers = range(0,$length-1);
		shuffle($numbers);
		$digits =0;
		for($i = 0; $i < $length && $digits != 123 && $digits != 1234 && $digits != 12345 && $digits != 123456
			&& $digits != 1234567 && $digits != 12345678; $i++){
			global $digits;
			$digits .= $numbers[$i];
		}		
		return $digits;
	}
