#!/bin/bash

for i in {1..6}
do
	echo "Output MySQL " $i >> questions/mysql/execution/output.txt
	mysql -u curso -pcurso < questions/mysql/"$i".mysql >> questions/mysql/execution/output.txt
	echo "" >> questions/mysql/execution/output.txt
	for j in {1..10}
	do
		{ time mysql -u curso -pcurso < questions/mysql/"$i".mysql; } 2>> questions/mysql/execution/mysql"$i".time
	done
	echo "Total: " >> questions/mysql/execution/mysql"$i".time
	grep -E real questions/mysql/execution/mysql"$i".time | sed s/[a-z]//g | awk '{ total += $1; count++ } END { print total/count}' >> questions/mysql/execution/mysql"$i".time
done
