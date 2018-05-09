#!/bin/bash

for i in {1..6}
do
	echo "Output MySQL " $i >> execution/output.txt
	mysql -u curso -pcurso < "$i".mysql >> execution/output.txt
	echo "" >> execution/output.txt
	for j in {1..10}
	do
		{ time mysql -u curso -pcurso < "$i".mysql; } 2>> execution/mysql"$i".time
	done
	echo "Total: " >> execution/mysql"$i".time
	grep -E real execution/mysql"$i".time | sed s/[a-z]//g | awk '{ total += $1; count++ } END { print total/count}' >> execution/mysql"$i".time
done
