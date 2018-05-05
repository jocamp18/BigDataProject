# BigDataProject

## Descripción
Este es el primer proyecto de la materia de BigData que esta orientado a la combinación de técnicas de análitica moderna con técnicas clasicas (Que aún son muy usadas en las compañías Colombianas). Básicamente, el proyecto consta de el proceso de ETL de un conjunto de datos libres publicados por el estado de Texas sobre las emergencias presentadas en los diferentes hospitales de dicho estado, posterior a esto se debe hacer todo el procesamiento, análisis y visualización de los datos para entender la situación que allí pasa en cuanto a las consultas diarias, tanto en terminos de análitica descriptiva como predictiva.

## Prerrequisitos
* Pentaho PDI
* MySQL
* Hive
* HDFS
* HBase
* Spark

## Estructura de carpetas
```
.
├── mysql
│   ├── mysql-inpatient.txt
│   └── mysql-outpatient.txt	
├── pdi
│   ├── mix-by-year.ktr
│   ├── inpatient-select-merge.ktr
│   └── outpatient-merge-select.ktr
├── sqoop
│   ├── inpatients.java
│   └── outpatients.java
```

## Proceso

1. (E) El primer trabajo que se debe hacer es realizar la extracción de todos los datos que vamos a utilizar durante la realización de este trabajo, estos pueden ser encontrados en las siguientes páginas web:

	* Outpatients: http://www.dshs.texas.gov/thcic/Outpatient-Discharge-Data-Public-Use-Data-File/
	* Inpatients: http://www.dshs.texas.gov/THCIC/Hospitals/Download.shtm

	Este proceso de descarga puede ser realizado con un robot o manualmente.	

2. (T) Para el proceso de transformación se utilizó la herramienta Pentaho Data Integration (PDI), con este se hicieron filtros, se eliminaron campos innecesarios y se concatenaron otros, este proceso consta de tres partes que serán explicadas a continuación:

	* Mezclar la información por año: Todos los datos después de haber sido descargados quedan en formato TXT, lo que se hace en esta primer fase es organizar todos estos archivos por año, es decir, cadan archivo va a hacer referencia a todo lo que se hizo durante un año en cierta categoría (Inpatients o Outpatients). Por ejemplo, el archivo "2006-inpatients" se refiere a todo lo que pasó en el 2006 en la categoría de Inpatients. Este archivo se llama "mix-by-year.ktr" y debe ser ejecutado de la siguiente manera en el archivo raíz de PDI:

	```
	$ ./pan.sh -file="<path-this-project>/pdi/mix-by-year.ktr"
	```

	* Transformación de Inpatients: Aquí se organiza toda la información referente a Inpatients, es decir, se filtra información, se eliminan campos innecesarios, se concatenan valores, se cambian nombres de columnas y se junta todo en una sola salida de tal manera que concuerde bajo la estructura definida (Se pueden hacer más operaciones pero para este caso no es necesario). El archivo se llama "inpatients-select-merge.ktr" y debe ser ejecutado de la siguiente manera en el archivo raíz de PDI:

	```
	$ ./pan.sh -file="<path-to-this-project>/pdi/inpatient-select-merge.ktr"
	```

	* Transformación de Outpatients: Aquí se organiza toda la información referente a Outpatients, es decir, se filtra información, se eliminan campos innecesarios, se concatenan valores, se cambian nombres de columnas y se junta todo en una sola salida de tal manera que concuerde bajo la estructura definida (Se pueden hacer más operaciones pero para este caso no es necesario). El archivo se llama "outpatients-merge-select.ktr" y debe ser ejecutado de la siguiente manera en el archivo raíz de PDI:

	```
	$ ./pan.sh -file="<path-to-this-project>/pdi/outpatient-merge-select.ktr"
	```

	**Nota:** Cabe aclarar que el éxito de todas las ejecuciones realizadas en este proceso dependen de las rutas específicadas en el desarrollo en PDI, es decir, que los archivos de entrada y salida tengan como especificación las mismas rutas.

3. (L) La carga de datos puede ser utilizada de diferentes maneras dependiendo de los gustos del usuario y de los destinos designados.

	* Una primer aproximación es realizar la carga a todos los destinos usando Pentaho Data Integration, es necesario hacer una configuración previa e instalar algunos drivers para que PDI se pueda comunicar a los respectivos destinos.
	* Otra aproximación es a través de la obtención de los datos con las propias herramientas finales, esto se puede lograr con diferentes scripts que automatizan este proceso. En esta ocasión se brinda explicación de este camino para que quede claro el uso de las diferentes herramientas que están disponibles en el DCA. El resultado final brindado por PDI serán dos archivos TXT uno para Inpatients y otro para Outpatients ("inpatients.txt" y "outpatients.txt" respectivamente) con los cuales se trabajará durante la carga de los datos para cada uno de los destinos, a continuación se presetará la forma de cargar los datos en cada uno de los destinos, cabe aclarar que solo se harán los ejemplos con Inpatients ya que en ambos casos es lo mismo solo que con archivos fuente diferentes.

	3.1 MySQL: Se importarán los archivos TXT finales con los scripts que se encuentran en la carpeta "mysql". Eliminar los encabezados de los archivos TXT resultantes de Pentaho PDI.

	mysql-inpatients.txt: Con este script se crea la table y se carga basada en un archivo TXT, cabe aclarar que las rutas deben ser cambiadas para que este aplique.

	```
	USE cursodb;
	CREATE TABLE inpatients(RECORD_ID VARCHAR(40), DISCHARGE VARCHAR(40), THCIC_ID VARCHAR(40), TYPE_OF_ADMISSION VARCHAR(40), SOURCE_OF_ADMISSION VARCHAR(40), PAT_STATE VARCHAR(40), PAT_COUNTRY VARCHAR(40), COUNTY VARCHAR(40), PAT_STATUS VARCHAR(40), SEX_CODE VARCHAR(40), PAT_AGE VARCHAR(40), ADMITTING_DIAGNOSIS VARCHAR(40), PRINC_DIAG_CODE VARCHAR(40), OTH_DIAG_CODES VARCHAR(200), E_CODES VARCHAR(200));
	LOAD DATA LOCAL INFILE '/home/jocamp18/dshs_data/inpatients.txt' INTO TABLE inpatients COLUMNS TERMINATED BY ';';
	```

	La forma de cargar estos scripts es la siguiente
	```
	$ mysql -u curso -pcurso
	MariaDB [(none)]> source <path-to-this-project>/mysql/mysql-inpatient.txt
	```

	3.2 HDFS: Los archivos se ubicaran en una ruta de HDFS del usuario donde se guardará el dataset con el que se trabaja actualmente. Hay dos maneras de realizar esta tareas, la primera es manualmente utilizando comandos de HDFS y la segunda es a través de SQOOP obteniendo los datos de MySQL y transfiriendolos a HDFS. 

	Comandos HDFS:
	```
	$ hdfs dfs -mkdir /user/<user>/dshs_dataset
	$ hdfs dfs -copyFromLocal <path-to-dataset>/inpatients.txt /user/<user>/dshs_dataset
	$ hdfs dfs -copyFromLocal <path-to-dataset>/outpatients.txt /user/<user>/dshs_dataset
	```

	SQOOP:
	```
	$ sqoop import --connect jdbc:mysql://192.168.10.80:3306/cursodb --username curso -P --table inpatients  --target-dir /user/<user>/dshs_dataset/sqoop/inpatients -m 1
	$ sqoop import --connect jdbc:mysql://192.168.10.80:3306/cursodb --username curso -P --table outpatients  --target-dir /user/<user>/dshs_dataset/sqoop/outpatients -m 1
	```

	3.3 Hive: Para cargar los datos en Hive utilizaremos SQOOP basados en las tablas creadas en MySQL (inpatients y outpatients que se encuentran en la base de datos cursodb).

	* Lo primero que se debe hacer es ingresar a la línea de comandos de hive para crear una base de datos llamada curso de la siguiente manera:

	```
	$ beeline
	beeline> !connect jdbc:hive2://hdpmaster.dis.eafit.edu.co:2181/;serviceDiscoveryMode=zooKeeper;zooKeeperNamespace=hiveserver2
	beeline> CREATE DATABASE curso;
	```
	* Posteriormente, se debe crear una tabla en hive basado en un esquema ya definido en MySQL (En este caso la tabla inpatients). 
	```
	$ sqoop create-hive-table --connect jdbc:mysql://192.168.10.80:3306/cursodb --username curso -P --table inpatients --hive-table dshs.inpatients --mysql-delimiters
	```
	
	* Finalmente, se importa la tabla que se encuentra en MySQL a Hive.	

	```
	$ sqoop import --connect jdbc:mysql://192.168.10.80:3306/cursodb --username curso -P --table inpatients --hive-import --hive-table dshs.inpatients -m 1 --mysql-delimiters
	```

	3.4 HBase: Para cargar los datos en HBase igualmente se utiliza Sqoop para importar desde MySQL.

	* Primero ingresamos al shell de HBase para crear la tabla que recibirá los datos.

	```
	$ hbase shell
	hbase> create 'inpatients', 'details'
	```

	* Luego, utilizamos el código para importar de MySQL a HBase mesdiante Sqoop.

	```
	$ sqoop import --connect jdbc:mysql://192.160.10.80:3306/cursodb --username curso --password curso --table inpatients --hbase-table inpatients --column-family details --hbase-row-key RECORD_ID -m 1
	```

	* Del mismo modo, el proceso es igual al momento de exportar la tabla outpatients.


4. Procesamiento: En esta tarea se realizará el procesamiento de datos para resolver las preguntas que han sido planteadas previo al inicio del proyecto. Estas serán resueltas utilizando diferentes plataformas, por cada una de las plataformas se presentará la forma de ejecutar el script y el tiempo en promedio (De 10 ejecuciones) necesitado para que este termine; Se brindará una solución general en MySQL donde se muestra la solución a la pregunta, hay que tener en cuenta que esta es aplicable a las otras plataformas con unos ligeros cambios.
	
	**Nota:** Los campos encerrados en parentesis angulares < > deben ser remplazados por el valor correspondiente.

	4.1 ¿Cuál es la proporción de usuarios que asisten a los centros médicos y realmente tienen una urgencia en un año determinado?

	```
	use cursodb;
	SET @year=<year>;
	SET @rec_in = (SELECT COUNT(*) FROM inpatients WHERE YEAR=@year);
	SET @rec_out = (SELECT COUNT(*) FROM outpatients WHERE YEAR=@year);
	SET @total = @rec_in + @rec_out;	
	SET @in_per = (@rec_in/@total)*100;
	SELECT @in_per as inpatients_proportion;
	```

	* Script MySQL: 53.2391 segundos

	```
	$ mysql -u curso -pcurso < <path-to-this-project>/questions/mysql/1.mysql
	```

	* Script Hive:
	* Script HBase:
	* Script SparkSQL:

	4.2 ¿Cuál es la proporción de usuarios que asisten a los centros médicos y no tienen una urgencia real en un año determinado?
	
	```
	use cursodb;
	SET @year=<year>;
	SET @rec_in = (SELECT COUNT(*) FROM inpatients WHERE YEAR=@year);
	SET @rec_out = (SELECT COUNT(*) FROM outpatients WHERE YEAR=@year);
	SET @total = @rec_in + @rec_out;
	SET @out_per = (@rec_out/@total)*100;
	SELECT @out_per as outpatients_proportion;
	```

	* Script MySQL: 53.2224 segundos

	```
	$ mysql -u curso -pcurso < <path-to-this-project>/questions/mysql/2.mysql
	```

	* Script Hive:
	* Script HBase:
	* Script SparkSQL:

	4.3 ¿Cuáles sintomas son los más comunes por año?

	```
	use cursodb;
	SET @year="2011";
	SET @top=10;
	SELECT princ_diag_code, SUM(patients) FROM((SELECT princ_diag_code, COUNT(*) AS patients FROM inpatients WHERE year=@year GROUP BY princ_diag_code) UNION (SELECT princ_diag_code, COUNT(*) AS patients FROM outpatients WHERE year=@year GROUP BY princ_diag_code)) COUNTY_PATIENTS GROUP BY princ_diag_code ORDER BY patients DESC LIMIT @top;
	```

	* Script MySQL: 57.1152 segundos

	```
        $ mysql -u curso -pcurso < <path-to-this-project>/questions/mysql/3.mysql
        ```

	* Script Hive:
	* Script HBase:
	* Script SparkSQL:

	4.4 ¿Quienes asisten más a los centros médicos los hombres o las mujeres durante el año?

	```
	use cursodb;
	SET @year=<year>;
	SET @male_in = (SELECT COUNT(*) FROM inpatients WHERE YEAR=@year AND SEX_CODE='M');
	SET @male_out = (SELECT COUNT(*) FROM outpatients WHERE YEAR=@year AND SEX_CODE='M');
	SET @female_in = (SELECT COUNT(*) FROM inpatients WHERE YEAR=@year AND SEX_CODE='F');
	SET @female_out = (SELECT COUNT(*) FROM outpatients WHERE YEAR=@year AND SEX_CODE='F');
	SET @male = @male_in + @male_out;
	SET @female = @female_in + @female_out;
	SET @total = @male + @female;
	SET @male_per = (@male/@total)*100
	SET @female_per = (@female/@total)*100
	SELECT @male_per AS male_proportion, @female_per AS female_proportion;
	```
	
	* Script MySQL: 1 minuto 40.052 segundos. El resultado final de este será un cuadro donde se ven los dos porcentajes de asistencia por cada uno de los dos generos:

	```
        $ mysql -u curso -pcurso < <path-to-this-project>/questions/mysql/4.mysql
	```

	* Script Hive:
	* Script HBase:
	* Script SparkSQL:

	4.5 ¿Entre hombres y mujeres quienes son los que más asisten a los centros médicos sin tener realmente una necesidad?

	```
	use cursodb;
	SET @year=<year>;
	SET @male_out = (SELECT COUNT(*) FROM outpatients WHERE YEAR=@year AND SEX_CODE='M');
	SET @female_out = (SELECT COUNT(*) FROM outpatients WHERE YEAR=@year AND SEX_CODE='F');
	SET @total = @male_out + @female_out;
	SET @male_per = (@male_out/@total)*100;
	SET @female_per = (@female_out/@total)*100;
	SELECT @male_per AS male_proportion, @female_per AS female_proportion;
	```
	
	* Script MySQL: 49.0227 segundos. El resultado final de esta ejecución será un cuadro donde se ven los dos porcentajes de asistencia por cada uno de los dos generos cuando no se tienen una emergencia real:

	```
       	$ mysql -u curso -pcurso < <path-to-this-project>/questions/mysql/5.mysql
	```

	* Script Hive:
	* Script HBase:
	* Script SparkSQL:

	4.6 ¿Cuál es el condado donde más consultas médicas se realizan durante un año en específico?

	```
	use cursodb;
	SET @year=<year>;
	SET @top=<limit>;
	SELECT county,year, patients FROM((SELECT county, year, COUNT(*) AS patients FROM inpatients group by county) UNION (SELECT county, year, COUNT(*) AS patients FROM outpatients group by county)) COUNTY_PATIENTS WHERE year=@year GROUP BY county ORDER BY patients DESC LIMIT @top;
	```

	* Script MySQL: 56.2355

	```
        $ mysql -u curso -pcurso < <path-to-this-project>/questions/mysql/6.mysql
        ```

	* Script Hive:
	* Script HBase:
	* Script SparkSQL:

5. Visualización: Para visualizar los datos procesados,la información relevante  y ls respuestas a las preguntas anteriormente planteadas se decide utilizar Tableau.
