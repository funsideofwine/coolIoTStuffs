<?php

	
	
	echo md5Hybridx("rolly", 8);
	
	
	
	
	
	
	
	
	function md5Hybridx($pass, $mcode_length){		
		
	//create mcode		
	$mcode = NonRepeatingRandomDigits($mcode_length);	
	
	echo $mcode." ";
	//hash it
	$pass_md5_hashed = md5($pass);
	
	//compute chuncklenght
	if((32 % 8) != 0) $chunklenght = ((int)(32/(8)))+1;
	else $chunklenght = ((int)(32/(8)));
	
	//split delimited the string
	$delimited_hashed_code =  chunk_split($pass_md5_hashed,$chunklenght);	
	
	/************************************************/
	//remove all non printable characters	
	$str = preg_replace(array('/\s{2,}/', '/[\t\n]/'), ' ', $delimited_hashed_code);
	$str = rtrim($str);		
		
	//save it into array individualy
	if(strpos($str, " ") !== false){
		$str5 = explode(" ", $str);	
	}//if	
		
	$r = array();
	for ($i = 0; $i < 8; $i++) {
		$r[] = substr($mcode, $i, 1);
		//echo $r[$i]."</br>";
	}	
	
	
	//scramble it
	$scrambledEgg = "";
	for($j = 0; $j != 8; $j++){		
		for($i = 0; $i !=9; $i++){
			if($r[$j] == $i){
				$scrambledEgg .= $str5[$i]."--";					
			}	
		}		
	}//for j;

	
		
		return $scrambledEgg;
	}//
	
	
	function NonRepeatingRandomDigits($length){		
		$numbers = range(0,$length-1);
		shuffle($numbers);
		$digits =0;
		for($i = 0; $i < $length && $digits != 12 && $digits != 123 && $digits != 1234 && $digits != 12345 && $digits != 123456
			&& $digits != 1234567 && $digits != 12345678; $i++){
			global $digits;
			$digits .= $numbers[$i];
		}		
		return $digits;
	}//	
	
	
