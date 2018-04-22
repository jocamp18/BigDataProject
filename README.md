# BigDataProject

## Descripción
Este es el primer proyecto de la materia de BigData que esta orientado a la combinación de técnicas de análitica moderna con técnicas clasicas como BI que aún es muy usado en las compañías Colombianas. Básicamente, el proyecto consta de el proceso de ETL de un conjunto de datos libres publicados por el estado de Texas sobre las emergencias presentadas en los diferentes hospitales de dicho estado, posterior a esto se debe hacer todo el procesamiento, análisis y visualización de los datos para entender la situación que allí pasa en cuanto a las consultas diarias, tanto en terminos de análitica descriptiva como predictiva.

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
│   ├── mysql-outpatient.txt	
├── pdi
│   ├── mix-by-year.ktr
│   ├── inpatient-select-merge.ktr
│   ├── outpatient-merge-select.ktr
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

**Nota:** Cabe aclarar que el éxito de todas las ejecuciones realizadas en este proceso dependen de las rutas específicadas en el desarrollo en PDI, es decir, que los archivos de entrada y salida tengan como especificación las mismas rutas. Sin embargo, para mayor facilidad los archivos ya procesados se encuentran en la ruta "<path-to-this-project>/pdi/output/"

3. (L) La carga de datos puede ser utilizada de diferentes maneras dependiendo de los gustos del usuario y de los destinos designados.

* Una primer aproximación es realizar la carga a todos los destinos usando Pentaho Data Integration, es necesario hacer una configuración previa e instalar algunos drivers para que PDI se pueda comunicar a los respectivos destinos.
* Otra aproximación es a través de la obtención de los datos con las propias herramientas finales, esto se puede lograr con diferentes scripts que automatizan este proceso. En esta ocasión se brinda explicación de este camino para que quede claro el uso de las diferentes herramientas que están disponibles en el DCA. El resultado final brindado por PDI serán dos archivos TXT uno para Inpatients y otro para Outpatients ("inpatients.txt" y "outpatients.txt" respectivamente) con los cuales se trabajará durante la carga de los datos para cada uno de los destinos, a continuación se presetará la forma de cargar los datos en cada uno de los destinos, cabe aclarar que solo se harán los ejemplos con Inpatients ya que en ambos casos es lo mismo solo que con archivos fuente diferentes.

3.1 MySQL: Se importarán los archivos TXT finales con los scripts que se encuentran en la carpeta "mysql".

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
$ sqoop import --connect jdbc:mysql://192.168.10.80:3306/cursodb --username curso -P --table inpatients  --target-dir /user/jocamp18/dshs_dataset/inpatients -m 1
$ sqoop import --connect jdbc:mysql://192.168.10.80:3306/cursodb --username curso -P --table outpatients  --target-dir /user/jocamp18/dshs_dataset/outpatients -m 1
```

3.3 Hive: Para cargar los datos en Hive utilizaremos SQOOP basados en las tablas creadas en MySQL (inpatients y outpatients que se encuentran en la base de datos cursodb).

* Lo primero que se debe hacer una tabla en Hive a partir de la definición de una tabla en MySQL. Por ejemplo, con inpatients:



3.4 HBase:


