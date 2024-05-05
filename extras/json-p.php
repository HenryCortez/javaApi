<?php
header('Content-Type: application/json', );
//Json_encode convertir un objetivo de php a un formato json
$objeto = new stdClass();
$objeto -> nombre = "Juan";
$objeto -> edad = 20;
$objeto -> pais = "Ecuador";
print_r( $objeto );
$miJson = json_encode( $objeto);
echo $miJson;
echo "<br><br>";

//array simple de php a Json
$colores = array("azul", "amarillo"); 
print_r($colores);
echo"<br>";
echo json_encode($colores);
echo "<br><br>";
//array asociativo de php a Json
$array = array("nombre" => "David", "edad" => 30, "país" => "Ecuador");
print_r( $array );
echo"<br>";
echo json_encode($array, JSON_UNESCAPED_UNICODE);

//de json a php usando json_decode
// convierte de json a php
$lista = '{"nombre": "David", "edad": 30, "país": "Ecuador"}';
echo "<br><br>";
echo $lista;
$miphp = json_decode($lista);
print_r($miphp);