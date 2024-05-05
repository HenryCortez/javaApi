<?php
include_once 'conexion.php';
class editar{
    public static function editar(){
        $con = new conexion();
        $conexion = $con->conectar();
        $cedula = $_GET['id'];
        
        $nombre =  $_GET['nombre'];
        $apellido =  $_GET['apellido'];
        $telefono =  $_GET['telefono'];
        $direccion =  $_GET['direccion'];
        
        $sql = "UPDATE estudiantes set nombre = '$nombre', apellido = '$apellido', direccion = '$direccion', telefono ='$telefono' where id = '$cedula'";
        
        $resultado = $conexion->prepare($sql);
        $resultado->execute();
        if (!$resultado) {
            return ['message' => 'Error'];
        }
        return ['message' => 'Estudiante editado con exito'] ;
    }
}