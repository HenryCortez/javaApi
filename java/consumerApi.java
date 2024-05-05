import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import static com.mashape.unirest.http.utils.URLParamEncoder.encode;
import java.util.List;

/**
 *
 * @author henry
 */
public class consumerApi {
    
    final static String BASE_URL = "http://localhost/Quinto/clase/controllers/apiRest.php";
    
    static boolean createStudent(Student student) throws UnirestException {
        
         try {
            HttpResponse<JsonNode> response = Unirest.post(BASE_URL)
                    .header("Accept", "*/*")
                    .field("id", student.getId())
                    .field("nombre", student.getNombre())
                    .field("apellido", student.getApellido())
                    .field("direccion", student.getDireccion())
                    .field("telefono", student.getTelefono()) 
                    .asJson();

            int statusCode = response.getStatus();
            // Si el código de estado es 200, la solicitud fue exitosa
            return statusCode == 200;
        } catch (UnirestException e) {
            e.printStackTrace();
            return false; // Se produjo una excepción, la solicitud falló
        }
    }

    // Read (get all students)
    static List<Student> getAllStudents() throws UnirestException {
        JsonNode algo = Unirest.get(BASE_URL)
                .header("Content-Type", "application/json")
                .asJson()
                .getBody();
        String jsonResponse = algo.toString();
        Gson gson = new Gson();
    
        List<Student> estudiantes = gson.fromJson(jsonResponse, new TypeToken<List<Student>>() {
        }.getType());
        return estudiantes;
    }

    // Update
    static boolean updateStudent( Student student) throws UnirestException {
        try {
          HttpResponse<JsonNode> response = Unirest.put(BASE_URL + "?id=" + encode(student.getId())
          +"&nombre="+encode(student.getNombre())
          +"&apellido="+encode(student.getApellido())
          +"&direccion="+encode(student.getDireccion())
          +"&telefono="+encode(student.getTelefono())
          )
                .header("Accept", "*/*")
                  
                
                    .asJson();
          int statusCode = response.getStatus();
            // Si el código de estado es 200, la solicitud fue exitosa
            return statusCode == 200;
        } catch (UnirestException e) {
            e.printStackTrace();
            return false; // Se produjo una excepción, la solicitud falló
        }
    }

    // Delete
    static boolean deleteStudent(String studentId) throws UnirestException {
        try {
          HttpResponse<JsonNode> response = Unirest.delete(BASE_URL + "?id=" + encode(studentId))
                .header("Accept", "*/*")
                .asJson();
          int statusCode = response.getStatus();
            // Si el código de estado es 200, la solicitud fue exitosa
            return statusCode == 200;
        } catch (UnirestException e) {
            e.printStackTrace();
            return false; // Se produjo una excepción, la solicitud falló
        }
    }

    // Search by condition (e.g., name)
    static List<Student> searchStudentsByName(String id) throws UnirestException {
        JsonNode algo = Unirest.get(BASE_URL)
                .queryString("id", id)
                .header("Content-Type", "application/json")
                .asJson()
                .getBody();    
        String jsonResponse = algo.toString();
        Gson gson = new Gson();
        List<Student> estudiantes = gson.fromJson(jsonResponse, new TypeToken<List<Student>>() {
        }.getType());
        return estudiantes;
    }