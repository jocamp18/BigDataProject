#!/bin/bash

for i in {1..6}
do
	for j in {1..10}
	do
		{ time mysql -u curso -pcurso < questions/mysql/"$i".mysql } 2> questions/mysql/mysql"$i".time
		echo "Total: " >> questions/mysql/mysql"$i".time
		grep -E real questions/mysql/mysql"$i".time | sed s/[a-z]//g | awk '{ total += $1; count++ } END { print total/count}' >> questions/mysql/mysql"$i".time
	done
done
