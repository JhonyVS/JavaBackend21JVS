BASE DE DATOS POSTGRES:
db_name: jvs_db
(IMPORTANTE)
se debe ejecutar el app una vez y luego volver a ejecutar descomentado la siguiente linea del application.properties:
# spring.sql.init.mode=always


ENDPOINTS:

http://localhost:8080/estudiantes
{    
  "nombres": "Javier",    
  "apellidos": "Milei",    
  "dni": "111111111",    
  "edad": 64
}

http://localhost:8080/cursos
{    
  "nombre" : "ALGEBRA",    
  "siglas" : "A-I",    
  "estado" : true
}

http://localhost:8080/matriculas
{    
  "fecha" : "2023-10-05T14:30:00",
  "estudiante" : {        
    "id": 3    
  },
  "estado" : true
}

http://localhost:8080/detalles
{    
  "matricula" : {        
    "id" : 1    
  },    
  "curso" : {        
    "id" : 3    
    },    
    "aula" : "EDIFICIO NUEVO 639F"
}

// obtiene la relacion entre cursos y estudiantes
http://localhost:8080/cursos/relacion-estudiantes

//muestra los estudiantes por edad de forma descendente
http://localhost:8080/estudiantes/por-edad-desc





